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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gerasim
 */
@Entity
@Table(name = "clubs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clubs.findAll", query = "SELECT c FROM Clubs c"),
    @NamedQuery(name = "Clubs.findByIdclubs", query = "SELECT c FROM Clubs c WHERE c.idclubs = :idclubs"),
    @NamedQuery(name = "Clubs.findByClubname", query = "SELECT c FROM Clubs c WHERE c.clubname = :clubname")})
public class Clubs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclubs")
    private Integer idclubs;
    @Size(max = 45)
    @Column(name = "clubname")
    private String clubname;
    @OneToMany(mappedBy = "clubid")
    private Collection<Transfer> transferCollection;
    @OneToMany(mappedBy = "clubid")
    private Collection<Players> playersCollection;

    public Clubs() {
    }

    public Clubs(Integer idclubs) {
        this.idclubs = idclubs;
    }

    public Integer getIdclubs() {
        return idclubs;
    }

    public void setIdclubs(Integer idclubs) {
        this.idclubs = idclubs;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    @XmlTransient
    public Collection<Transfer> getTransferCollection() {
        return transferCollection;
    }

    public void setTransferCollection(Collection<Transfer> transferCollection) {
        this.transferCollection = transferCollection;
    }

    @XmlTransient
    public Collection<Players> getPlayersCollection() {
        return playersCollection;
    }

    public void setPlayersCollection(Collection<Players> playersCollection) {
        this.playersCollection = playersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclubs != null ? idclubs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clubs)) {
            return false;
        }
        Clubs other = (Clubs) object;
        if ((this.idclubs == null && other.idclubs != null) || (this.idclubs != null && !this.idclubs.equals(other.idclubs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clubs[ idclubs=" + idclubs + " ]";
    }
    
}
