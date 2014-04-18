/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.Donation;

/**
 *
 * @author gerasim
 */
public interface DonationsDAOInterface {

    public void addDonation(Donation donation);
    public void removeDonation(Donation donation);
    public Donation findByID(long id);
    public List<Donation> findAll();

}
