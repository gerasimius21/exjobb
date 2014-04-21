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
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import model.Clubs;

/**
 *
 * @author Semir
 */
@Named("menu")
@SessionScoped
public class MenuBean implements Serializable{

    @EJB
    Controller controller;

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
