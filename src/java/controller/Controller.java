/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.DAO.ClubsDAO;
import model.DAO.DonationsDAO;
import model.DAO.PlayersDAO;
import model.DAO.TransfersDAO;

/**
 *
 * @author gerasim
 */
@Stateless
public class Controller {
    
    @Inject
    PlayersDAO player;
    
    @Inject
    ClubsDAO club;
    
    @Inject
    TransfersDAO transfer;
    
    @Inject
    DonationsDAO donation;
    
    
    public PlayersDAO getPlayers() {
        System.out.println("Svemir da baws!");
        return player;
    }
    
    public ClubsDAO getClubs() {
        return club;
        
    }
    
    public List getAllClubs() {
        return club.findAll();
    }
}
