/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanqueaureola.ejb;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import mg.itu.tpbanqueaureola.entities.CompteBancaire;

/**
 *
 * @author ahthan
 */
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "root", // nom et 
        password = "Password01!", // mot de passe que vous avez donnés lors de la création de la base de données 
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true"
        }
)
@Stateless
public class GestionnaireCompte {

    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;

    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }
    
    public List<CompteBancaire> getAllComptes() {
        TypedQuery<CompteBancaire> query = em.createQuery("CompteBancaire.findAll", CompteBancaire.class);
        List<CompteBancaire> comptes = query.getResultList();
        return comptes;
    }
    
    public int nbComptes(){
        String text = "select count(c) from CompteBancaire as c";
        Query query = em.createQuery(text);
        return ((Long)query.getSingleResult()).intValue();
    }
}
