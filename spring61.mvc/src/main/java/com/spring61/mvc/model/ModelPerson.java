package com.spring61.mvc.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelPerson {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private String name     = null; 
    private String id       = null; 
    private String email    = null; 
    private String password = null;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "ModelPerson [name=" + name + ", id=" + id + ", email=" + email
                + ", password=" + password + "]";
    }
    
    public ModelPerson() {
        super();
    }
    public ModelPerson(String name, String id, String email, String password) {
        super();
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
    } 
    
    
    
    
    
    
}
