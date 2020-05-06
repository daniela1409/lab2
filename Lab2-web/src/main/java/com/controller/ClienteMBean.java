/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value= "clienteMBean")
@SessionScoped

public class ClienteMBean  implements Serializable  {

   
     
    
    public ClienteMBean(){
    }
    
}
