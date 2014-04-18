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
import model.Donation;

/**
 *
 * @author gerasim
 */
@ApplicationScoped
public class DonationsDAO implements DonationsDAOInterface {

    @PersistenceContext(unitName = "fansferPU")
    private EntityManager em;

    @Override
    public void addDonation(Donation donation) {
        em.persist(donation);
    }

    @Override
    public void removeDonation(Donation donation) {
        em.merge(donation);
        em.remove(donation);
    }

    @Override
    public Donation findByID(long id) {
        return em.find(Donation.class, id);
    }

    @Override
    public List<Donation> findAll() {
        TypedQuery<Donation> query = em.createQuery(
                "SELECT g FROM Donation g", Donation.class);
        return query.getResultList();
    }

}
