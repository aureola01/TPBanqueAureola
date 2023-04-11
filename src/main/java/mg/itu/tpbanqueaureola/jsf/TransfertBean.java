/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueaureola.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import mg.itu.tpbanqueaureola.ejb.GestionnaireCompte;
import mg.itu.tpbanqueaureola.entities.CompteBancaire;

/**
 *
 * @author ahthan
 */
@Named(value = "transfert")
@RequestScoped
public class TransfertBean {

    private Long idSource;
    private Long idDestination;
    private int montant;

    @EJB
    private GestionnaireCompte gestionCompte;

    /**
     * Creates a new instance of TransfertBean
     */
    public TransfertBean() {
    }

    public Long getIdSource() {
        return idSource;
    }

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String transferer() {
        boolean erreur = false;
        CompteBancaire source = gestionCompte.getCompte(idSource);
        if (source == null) {
            // Message d'erreur associé au composant source ; form:source est l'id client
            // si l'id du formulaire est "form" et l'id du champ de saisie de l'id de la source est "source"
            // dans la page JSF qui lance le transfert.
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:source");
            erreur = true;
        } else {
            if (source.getSolde() < montant) { // pour le cas où le solde du compte source est insuffisant
                Util.messageErreur("Le solde de l'envoyeur est insuffisant !", "Le solde de l'envoyeur est insuffisant !", "form:source");
                erreur = true;
            }
        }
        CompteBancaire destination = gestionCompte.getCompte(idDestination);
        if (destination == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:destination");
            erreur = true;
        }
        if (erreur) { // en cas d'erreur, rester sur la même page
            return null;
        }
        gestionCompte.transferer(source, destination, montant);
        // Message de succès ; addFlash à cause de la redirection.
        Util.addFlashInfoMessage("Transfert correctement effectué");
        return "listeComptes?idS=" + idSource + "&amp;idD=" + idDestination + "&amp;montant=" + montant + "&amp;faces-redirect=true";
    }
}
