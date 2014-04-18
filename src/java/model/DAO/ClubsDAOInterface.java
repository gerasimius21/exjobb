/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.Clubs;

/**
 *
 * @author gerasim
 */
public interface ClubsDAOInterface {
    
    public void addClub(Clubs club);
    public void removeClub(Clubs club);
    public Clubs findByID(long id);
    public List<Clubs> findAll();
    
}
