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
    
    public List<Clubs> getAllClubs(){
        return controller.getAllClubs();
    }
    
}
