/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;  
  
import controller.Controller;
import java.io.Serializable;  
import java.util.ArrayList;  
import java.util.List;  
import java.util.UUID;    
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
      
    public void populateClubs() {
        clubPlayers = controller.getPlayers().findByClub(null);
    }
      
    public List<Players> getPlayers() {  
        return clubPlayers;  
    }  
      
}  
