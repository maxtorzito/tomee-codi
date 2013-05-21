/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maxtorzito.test;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author maxtorzito
 */
@ManagedBean
@RequestScoped
public class MyMBean implements Serializable {

    public MyMBean() {
    }

    public String login() {
        try {
            System.out.println("login.....");
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            if(request.getRemoteUser()==null){
                request.login("tomee", "tomee");
                System.out.println(">>>>>>>LOGIN SUCESS<<<<<<<<<<<<<<<");
            }
            else{
                System.out.println("Already login....");
            }
            return "private/welcome.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String logout() {
        try {
            System.out.println("logout.....");
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.logout();
            System.out.println(">>>>>>>LOGOUT SUCESS<<<<<<<<<<<<<<<");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}