/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueaureola.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.PositiveOrZero;
import mg.itu.tpbanqueaureola.ejb.GestionnaireCompte;
import mg.itu.tpbanqueaureola.entities.CompteBancaire;


/**
 *
 * @author ahthan
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompteBean {
    
    private String nom;
    
    @PositiveOrZero
    private int solde;
    
    @EJB
    private GestionnaireCompte gestionCompte;

    /**
     * Creates a new instance of AjoutCompteBean
     */
    public AjoutCompteBean() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
    
    public String ajouter(){
        gestionCompte.creerCompte(new CompteBancaire(nom, solde));
        Util.addFlashInfoMessage("Compte créé avec succes");
        return "listeComptes?nom=" + nom + "&amp;solde=" + solde + "&amp;faces-redirect=true";
    }
}
