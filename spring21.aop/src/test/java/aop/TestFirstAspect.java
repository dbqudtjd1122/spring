package aop;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.ModelProduct;
import service.IServiceProduct;

public class TestFirstAspect {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static ApplicationContext context = null; 
    private static IServiceProduct  service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() {
        try {
            context = new ClassPathXmlApplicationContext("classpath:aop.xml");
            service = context.getBean("serviceProduct", IServiceProduct.class);
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testGetProduct() {
        logger.debug("Using Spring AOP:");        
        ModelProduct product = service.getProduct("");        
        logger.info(product.toString());
        logger.debug("It should be now cached!");
    }
    
    @Test
    public void testGetException() {
        logger.debug("Using Spring AOP:");        
        try {
            service.getException("");
        } catch (Exception e) {
            // e.printStackTrace();
            logger.error("testGetException" + e.getMessage() );
        }
        logger.debug("It should be now cached!");
    }
    
    @Test
    public void testGetNone() {
        logger.debug("Using Spring AOP:");        
        service.getNone();        
        logger.debug("It should be now cached!");
    }
}
