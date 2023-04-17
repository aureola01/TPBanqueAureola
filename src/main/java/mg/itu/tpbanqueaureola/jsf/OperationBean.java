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
import mg.itu.tpbanqueaureola.entities.OperationBancaire;

/**
 *
 * @author ahthan
 */
@Named(value = "operationBean")
@ViewScoped
public class OperationBean implements Serializable {

    private Long id;
    private CompteBancaire compte;
    
    @EJB
    private GestionnaireCompte gestionCompte;
    /**
     * Creates a new instance of OperationBean
     */
    public OperationBean() {
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
        this.compte = gestionCompte.getCompte(id);
    }
    
    public List<OperationBancaire> getOperations(){
        return this.compte.getOperations();
    }
}
