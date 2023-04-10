/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanqueaureola.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import mg.itu.tpbanqueaureola.entities.CompteBancaire;

/**
 *
 * @author ahthan
 */
@Singleton
@Startup
public class SingletonInitCompte {
    
    @EJB
    private GestionnaireCompte gestionCompte;
    
    @PostConstruct
    public void init(){
        if(gestionCompte.nbComptes() == 0){
            gestionCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
            gestionCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gestionCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
            gestionCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
        }
    }
}
