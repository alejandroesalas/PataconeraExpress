/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.cecar.pataconeraexpress.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author usuario
 */
@Startup
@Singleton
public class UstilJsonProccesing {
    
    private final ObjectMapper mapper;
    
    public UstilJsonProccesing() {
        this.mapper = new ObjectMapper();
    }
    public ObjectMapper getMapeador(){
        return mapper;
    }

    public String toJson(Object p) {
        String res;
        try {
           res=  mapper.writeValueAsString(p);
        } catch (JsonProcessingException ex) {
            res="";
            Logger.getLogger(UstilJsonProccesing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    

}
