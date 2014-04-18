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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gerasim
 */
@Entity
@Table(name = "players")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Players.findAll", query = "SELECT p FROM Players p"),
    @NamedQuery(name = "Players.findByIdplayers", query = "SELECT p FROM Players p WHERE p.idplayers = :idplayers"),
    @NamedQuery(name = "Players.findByPlayername", query = "SELECT p FROM Players p WHERE p.playername = :playername"),
    @NamedQuery(name = "Players.findByPosition", query = "SELECT p FROM Players p WHERE p.position = :position"),
    @NamedQuery(name = "Players.findByJerseynumber", query = "SELECT p FROM Players p WHERE p.jerseynumber = :jerseynumber"),
    @NamedQuery(name = "Players.findByGoalsscored", query = "SELECT p FROM Players p WHERE p.goalsscored = :goalsscored"),
    @NamedQuery(name = "Players.findByYellowcards", query = "SELECT p FROM Players p WHERE p.yellowcards = :yellowcards"),
    @NamedQuery(name = "Players.findByRedcards", query = "SELECT p FROM Players p WHERE p.redcards = :redcards"),
    @NamedQuery(name = "Players.findByGamesplayed", query = "SELECT p FROM Players p WHERE p.gamesplayed = :gamesplayed")})
public class Players implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplayers")
    private Integer idplayers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "playername")
    private String playername;
    @Size(max = 45)
    @Column(name = "position")
    private String position;
    @Column(name = "jerseynumber")
    private Integer jerseynumber;
    @Column(name = "goalsscored")
    private Integer goalsscored;
    @Column(name = "yellowcards")
    private Integer yellowcards;
    @Column(name = "redcards")
    private Integer redcards;
    @Column(name = "gamesplayed")
    private Integer gamesplayed;
    @OneToMany(mappedBy = "playerid")
    private Collection<Transfer> transferCollection;
    @JoinColumn(name = "clubid", referencedColumnName = "idclubs")
    @ManyToOne
    private Clubs clubid;

    public Players() {
    }

    public Players(Integer idplayers) {
        this.idplayers = idplayers;
    }

    public Players(Integer idplayers, String playername) {
        this.idplayers = idplayers;
        this.playername = playername;
    }

    public Integer getIdplayers() {
        return idplayers;
    }

    public void setIdplayers(Integer idplayers) {
        this.idplayers = idplayers;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getJerseynumber() {
        return jerseynumber;
    }

    public void setJerseynumber(Integer jerseynumber) {
        this.jerseynumber = jerseynumber;
    }

    public Integer getGoalsscored() {
        return goalsscored;
    }

    public void setGoalsscored(Integer goalsscored) {
        this.goalsscored = goalsscored;
    }

    public Integer getYellowcards() {
        return yellowcards;
    }

    public void setYellowcards(Integer yellowcards) {
        this.yellowcards = yellowcards;
    }

    public Integer getRedcards() {
        return redcards;
    }

    public void setRedcards(Integer redcards) {
        this.redcards = redcards;
    }

    public Integer getGamesplayed() {
        return gamesplayed;
    }

    public void setGamesplayed(Integer gamesplayed) {
        this.gamesplayed = gamesplayed;
    }

    @XmlTransient
    public Collection<Transfer> getTransferCollection() {
        return transferCollection;
    }

    public void setTransferCollection(Collection<Transfer> transferCollection) {
        this.transferCollection = transferCollection;
    }

    public Clubs getClubid() {
        return clubid;
    }

    public void setClubid(Clubs clubid) {
        this.clubid = clubid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplayers != null ? idplayers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Players)) {
            return false;
        }
        Players other = (Players) object;
        if ((this.idplayers == null && other.idplayers != null) || (this.idplayers != null && !this.idplayers.equals(other.idplayers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Players[ idplayers=" + idplayers + " ]";
    }
    
}
