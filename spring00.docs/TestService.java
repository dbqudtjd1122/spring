package com.spring61.mvc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring61.mvc.model.*;
import com.spring61.mvc.service.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServicePhone {
    
    private static ApplicationContext context = null;
    private static IServicePhone service = null;
        
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        context= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service=context.getBean("servicePhone", IServicePhone.class);
    }    
 
    @Test
    public void testinsertPhone() {
                
        ModelPhone phone= new ModelPhone();
       
        phone.setName("Sunny");
        phone.setManufacturer("motorola");
        phone.setPrice(19000);
        
        int result= service.insertPhone(phone);
        
        assertSame(result , 1);
    }
  
}
