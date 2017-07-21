package com.spring63.rest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring63.rest.model.ModelPerson;
import com.spring63.rest.service.IServicePerson;

public class TestServicePerson {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private static ApplicationContext context = null;
    private static IServicePerson service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {        
        context= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service=context.getBean("serviceperson", IServicePerson.class);
    }
    
    @Test
    public void testInsertPerson() {
        ModelPerson person = new ModelPerson("test1id","test1pw","test1name","test1email");
        int result = service.insertPerson(person );
        
        assertEquals(1,result);
    }
    
    @Test
    public void testLogin() {
        ModelPerson person = new ModelPerson("test1id", "test1pw");
        int result = service.login(person);        
        assertEquals(1, result);
        
        person = new ModelPerson("test2id", "test2id");
        result = service.login(person);        
        assertEquals(0, result);
    }
    
    @Test
    public void testGetPersonList() {
        ModelPerson person = new ModelPerson();
        List<ModelPerson> result = service.getPersonList(person);
        assertNotNull(result);
        assertNotEquals(0, result.size() );
    }
}
