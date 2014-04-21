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
import javax.inject.Named;
import model.Players;

@Named("clubBean")
@SessionScoped
public class PlayerViewTest implements Serializable {

    @EJB
    private Controller controller;
    private List<Players> clubPlayers;
    private Players selectedPlayer;
    private String club;

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void attrListener(ActionEvent event) {

        club = (String) event.getComponent().getAttributes().get("action");

    }

    @PostConstruct
    public void populateClubs() {
        System.out.println("Söker efter club" + club);
        clubPlayers = controller.getPlayers().findByClub(club);

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
