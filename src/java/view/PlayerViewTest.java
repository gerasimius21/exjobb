/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import model.Clubs;
import model.Players;

@Named("clubBean")
@SessionScoped
public class PlayerViewTest implements Serializable {

    @EJB
    private Controller controller;
    private List<Players> clubPlayers;
    private Players selectedPlayer;
    
    private List<Clubs> clubs;
    private Clubs selectedClub;
    private String club;

    public void setClub(String club) {
        this.club = club;
    }
    
    @Inject
    MenuBean mb;
      
    
    @PostConstruct
    public void init() {
        System.out.println("Club: " + mb.getClub());
        clubs = controller.getClubs().findAll();
        clubPlayers = controller.getPlayers().findByClub("Liverpool");
    }
    
    public List<Clubs> getClubs() {
        return clubs;
    }
      
    public List<Players> getPlayers() {  
        return clubPlayers;
    } 
    
    public Clubs getSelectedClub() {
        return selectedClub;
    }
    
    public void setSelectedClub(Clubs selectedClub) {
        this.selectedClub = selectedClub;
    }
    
    public Players getSelectedPlayer() {
        return selectedPlayer;
    }

    public void setSelectedPlayer(Players selectedPlayer) {
        this.selectedPlayer = selectedPlayer;
    }

}
