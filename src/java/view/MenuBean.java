/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import model.Clubs;

/**
 *
 * @author Semir
 */
@Named("menu")
@ApplicationScoped
public class MenuBean {

    @EJB
    Controller controller;
    List<Clubs> clubs = new ArrayList<>();

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

    public List<Clubs> getAllClubs() {
        return controller.getAllClubs();
    }

}
