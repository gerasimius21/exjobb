/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gerasim
 */
@Entity
@Table(name = "transfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t"),
    @NamedQuery(name = "Transfer.findByIdtransfer", query = "SELECT t FROM Transfer t WHERE t.idtransfer = :idtransfer")})
public class Transfer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransfer")
    private Integer idtransfer;
    @JoinColumn(name = "clubid", referencedColumnName = "idclubs")
    @ManyToOne
    private Clubs clubid;
    @JoinColumn(name = "playerid", referencedColumnName = "idplayers")
    @ManyToOne
    private Players playerid;
    @OneToMany(mappedBy = "transferid")
    private Collection<Donation> donationCollection;

    public Transfer() {
    }

    public Transfer(Integer idtransfer) {
        this.idtransfer = idtransfer;
    }

    public Integer getIdtransfer() {
        return idtransfer;
    }

    public void setIdtransfer(Integer idtransfer) {
        this.idtransfer = idtransfer;
    }

    public Clubs getClubid() {
        return clubid;
    }

    public void setClubid(Clubs clubid) {
        this.clubid = clubid;
    }

    public Players getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Players playerid) {
        this.playerid = playerid;
    }

    @XmlTransient
    public Collection<Donation> getDonationCollection() {
        return donationCollection;
    }

    public void setDonationCollection(Collection<Donation> donationCollection) {
        this.donationCollection = donationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransfer != null ? idtransfer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfer)) {
            return false;
        }
        Transfer other = (Transfer) object;
        if ((this.idtransfer == null && other.idtransfer != null) || (this.idtransfer != null && !this.idtransfer.equals(other.idtransfer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Transfer[ idtransfer=" + idtransfer + " ]";
    }
    
}
