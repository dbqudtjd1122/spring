package com.spring62.phone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring62.phone.model.ModelPhone;
import com.spring62.phone.service.IServicePhone;


public class TesServicePhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    private static ApplicationContext context = null;
    private static IServicePhone service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service =context.getBean("svrphone", IServicePhone.class);
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
    
    @Test
    public void testgetPhoneOne() {
        
        ModelPhone result = service.getPhoneOne("Sunny");
        
        assertEquals(result.getManufacturer(), "motorola");
    }
    
    @Test
    public void testgetPhoneList() {
        
        ModelPhone phone= new ModelPhone();        
        List<ModelPhone> result = service.getPhoneList();
        assertSame(result.size(), 1);
        assertEquals(result.get(0).getName(), "Sunny");
             
    }
    @Test
    public void testinsertPhoneList() {       
        ModelPhone phone = null;
        List<ModelPhone> list= new ArrayList<ModelPhone>();           
        
        for(int i=1; i<6; i=i+1){           
           phone= new ModelPhone();          
           phone.setName("퇴마록"+ i);
           phone.setManufacturer("엘릭시르");
           phone.setPrice(20000);           
           list.add(phone);            
        }
      
        int result= service.insertPhoneList(list);
        
        assertSame(result, 5);
    }
  
}
