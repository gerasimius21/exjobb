/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gerasim
 */
@Entity
@Table(name = "donation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donation.findAll", query = "SELECT d FROM Donation d"),
    @NamedQuery(name = "Donation.findByIddonation", query = "SELECT d FROM Donation d WHERE d.iddonation = :iddonation"),
    @NamedQuery(name = "Donation.findByPpkey", query = "SELECT d FROM Donation d WHERE d.ppkey = :ppkey"),
    @NamedQuery(name = "Donation.findByAmount", query = "SELECT d FROM Donation d WHERE d.amount = :amount")})
public class Donation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddonation")
    private Integer iddonation;
    @Size(max = 45)
    @Column(name = "ppkey")
    private String ppkey;
    @Column(name = "amount")
    private Short amount;
    @JoinColumn(name = "transferid", referencedColumnName = "idtransfer")
    @ManyToOne
    private Transfer transferid;

    public Donation() {
    }

    public Donation(Integer iddonation) {
        this.iddonation = iddonation;
    }

    public Integer getIddonation() {
        return iddonation;
    }

    public void setIddonation(Integer iddonation) {
        this.iddonation = iddonation;
    }

    public String getPpkey() {
        return ppkey;
    }

    public void setPpkey(String ppkey) {
        this.ppkey = ppkey;
    }

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }

    public Transfer getTransferid() {
        return transferid;
    }

    public void setTransferid(Transfer transferid) {
        this.transferid = transferid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddonation != null ? iddonation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donation)) {
            return false;
        }
        Donation other = (Donation) object;
        if ((this.iddonation == null && other.iddonation != null) || (this.iddonation != null && !this.iddonation.equals(other.iddonation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Donation[ iddonation=" + iddonation + " ]";
    }
    
}
