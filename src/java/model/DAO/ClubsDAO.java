/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Clubs;

/**
 *
 * @author gerasim
 */
@ApplicationScoped
public class ClubsDAO implements ClubsDAOInterface {

    @PersistenceContext(unitName = "fansferPU")
    private EntityManager em;

    @Override
    public void addClub(Clubs club) {
        em.persist(club);
    }

    @Override
    public void removeClub(Clubs club) {
        em.merge(club);
        em.remove(club);
    }

    @Override
    public Clubs findByID(long id) {
        return em.find(Clubs.class, id);
    }
    

    @Override
    public List<Clubs> findAll() {
        TypedQuery<Clubs> query = em.createQuery(
                "SELECT g FROM Clubs g", Clubs.class);
        return query.getResultList();
    }

}
