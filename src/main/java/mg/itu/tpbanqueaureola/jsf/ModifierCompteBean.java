/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueaureola.jsf;

import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import mg.itu.tpbanqueaureola.ejb.GestionnaireCompte;
import mg.itu.tpbanqueaureola.entities.CompteBancaire;

/**
 *
 * @author ahthan
 */
@Named(value = "modifierCompteBean")
@ViewScoped
public class ModifierCompteBean implements Serializable {
    
    private Long id;
    private CompteBancaire compte;
    
    @EJB
    private GestionnaireCompte gestionCompte;

    /**
     * Creates a new instance of ModifierCompteBean
     */
    public ModifierCompteBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }
    
    public void loadCompte() {
        compte = gestionCompte.getCompte(id);
    }
    
    public String modifier(){
        gestionCompte.update(compte);
        Util.addFlashInfoMessage("Modification enregistrée sur compte de " + compte.getNom());
        return "listeComptes?faces-redirect=true";
    }
}
