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
import model.Players;

/**
 *
 * @author gerasim
 */
@ApplicationScoped
public class PlayersDAO implements PlayersDAOInterface {
    
    @PersistenceContext(unitName = "fansferPU")
    private EntityManager em;

    @Override
    public void addPlayer(Players player) {
        em.persist(player);
    }

    @Override
    public void removePlayer(Players player) {
        em.merge(player);
        em.remove(player);
    }

    @Override
    public Players findByID(int id) {
        return em.find(Players.class, id);
    }
    
    @Override
    public List<Players> findByClub(String clubname) {
        TypedQuery getClubByName = em.createNamedQuery("Clubs.findByClubname", Clubs.class);
        getClubByName.setParameter("clubname", clubname);
        Clubs club = (Clubs)getClubByName.getSingleResult();
        
        System.out.println(club);
        int clubId = club.getIdclubs();
        System.out.println(clubId);
        return em.createQuery("SELECT p FROM Players p WHERE p.clubid.idclubs = ?1").setParameter(1, clubId).getResultList();
    }

    @Override
    public List<Players> findAll() {
        TypedQuery<Players> query = em.createQuery(
                "SELECT g FROM Clubs g", Players.class);
        return query.getResultList();
    }  
}
