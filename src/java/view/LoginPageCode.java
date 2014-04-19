package view;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Semir
 */
@Named("lp")
@SessionScoped
public class LoginPageCode implements Serializable {

    private static final long serialVersionUID = -1611162265998907599L;

    public String getFacebookUrlAuth() {
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String sessionId = session.getId();
        String appId = "244112569108536";
        String redirectUrl = "http://localhost:8080/facebooklogin1/index.sec";
        String returnValue = "https://www.facebook.com/dialog/oauth?client_id="
                + appId + "&redirect_uri=" + redirectUrl
                + "&scope=email,user_birthday&state=" + sessionId;
        return returnValue;
    }

    public String getUserFromSessionFirstName() {
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String userName = (String) session.getAttribute("FACEBOOK_FirstName");
        if (userName != null) {
            return userName;
        } else {
            return "";
        }
    }

    public String getUserFromSessionLastName() {
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String userName = (String) session.getAttribute("FACEBOOK_LastName");
        if (userName != null) {
            return userName;
        } else {
            return "";
        }
    }

    public String getUserFromSessionID() {
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String userName = (String) session.getAttribute("FACEBOOK_ID");
        if (userName != null) {
            return userName;
        } else {
            return "";
        }
    }

    public String getUserFromSessionEmail() {
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String userName = (String) session.getAttribute("FACEBOOK_Email");
        if (userName != null) {
            return userName;
        } else {
            return "";
        }
    }

    public boolean isLoggedIn() {
        boolean ret;
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String userName = (String) session.getAttribute("FACEBOOK_ID");

        if (userName == null) {
            ret = true;
        } else {
            ret = false;
        }

        return ret;
    }
    
    public String getWelcomeLine(){
        
        String ret = "Welcome " + getUserFromSessionFirstName() + " " + getUserFromSessionLastName() + ", logged in as " + getUserFromSessionEmail();
        
        return ret;
    }

    public String logout() throws IOException {
        
        String s ="https://www.facebook.com/logout.php?access_token=ACCESS_TOKEN&confirm=1&next=REDIRECT";
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session = null;
        return "login";

    }

}
