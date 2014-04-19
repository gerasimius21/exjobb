/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;  
  
import controller.Controller;
import java.io.Serializable;  
import java.util.List;  
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Players;

@Named("clubBean")
@SessionScoped
public class PlayerViewTest implements Serializable {  
      
    @EJB
    private Controller controller;
    private List<Players> clubPlayers; 
    private Players selectedPlayer;
      
    @PostConstruct
    public void populateClubs() {
        clubPlayers = controller.getPlayers().findByClub("Chelsea");
    }
      
    public List<Players> getPlayers() {  
        return clubPlayers;  
    }  
    
    public Players getSelectedPlayer() {
        return selectedPlayer;
    }
    
    public void setSelectedPlayer(Players selectedPlayer) {
        this.selectedPlayer = selectedPlayer;
    }
      
}  
