/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.Transfer;


/**
 *
 * @author gerasim
 */
public interface TransfersDAOInterface {

    public void addTransfer(Transfer transfer);
    public void removeTransfer(Transfer transfer);
    public Transfer findByID(long id);
    public List<Transfer> findAll();

}
