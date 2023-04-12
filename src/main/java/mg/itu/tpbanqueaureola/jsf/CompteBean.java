/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueaureola.jsf;

import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import mg.itu.tpbanqueaureola.ejb.GestionnaireCompte;
import mg.itu.tpbanqueaureola.entities.CompteBancaire;

/**
 *
 * @author ahthan
 */
@Named(value = "compteBean")
@ViewScoped
public class CompteBean implements Serializable {

    @EJB
    private GestionnaireCompte gestionCompte;

    private List<CompteBancaire> listeComptes;

    /**
     * Creates a new instance of CompteBean
     */
    public CompteBean() {
    }

    public List<CompteBancaire> getAllComptes() {
        if (listeComptes == null) {
            listeComptes = gestionCompte.getAllComptes();
        }
        return listeComptes;
    }

    public String supprimerCompte(CompteBancaire compteBancaire) {
        gestionCompte.supprimerCompte(compteBancaire);
        Util.addFlashInfoMessage("Compte de " + compteBancaire.getNom() + " supprimé");
        return "listeComptes?faces-redirect=true";
    }
}
