package di01.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import di01.model.Employee;

public class TestEmployee {
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testMakeInstanceWithNew() {
        // Emplyoee 인스턴스 emp 만들고
        // 세터를 이용해 필드에 값을 입력하시오
        // firstname = "aaaa";
        // lastname = "bbbb";
        // salary = 1000;
        Employee emp1 = new Employee();
        emp1.setFirstname("aaaa");
        emp1.setLastname("bbbb");
        emp1.setSalary(1000);
        assertEquals(emp1.getFirstname(), "aaaa");
        
        // 생성자를 이용해 Emplyoee 인스턴스 emp2 만들시오.
        // 필드에 설정할 값은 아래와 같다.
        // firstname = "aaaa";
        // lastname = "bbbb";
        // salary = 1000;
        Employee emp2 = new Employee("aaaa", "bbbb", 100);
        assertEquals(emp2.getFirstname(), "aaaa");
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void testMakeInstanceWithReflection()
            throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
        // Reflection 을 이용해서
        // Employee emp2 = new Employee("aaaa", "bbbb", 100)
        // 코드를 구현하여 본다.
        Class klass = Class.forName("di01.model.Employee");     
        
        Class[] paramTypes = { String.class, String.class, Integer.TYPE };
        
        Constructor cons = klass.getConstructor(paramTypes);
        
        Object [] objs = {"aaaa", "bbbb", 100};
        
        // 인스턴스 만들기.
        Object instance = cons.newInstance(objs);
        System.out.println( instance.toString() );
        
        // setter를 이용해서 필드값 바꾸기
        // 메서드 선언.
        Method m = klass.getMethod("setFirstname", String.class);
        
        // 메서드 매개변수 정의
        Object [] params = { "hello" };

        // 메서드 호출
        m.invoke(instance, params);
        
        // 값 출력하기.
        System.out.println( instance.toString() );
        
        
        // getter를 이용해서 필드값 가져오.ㅣ
        m = klass.getMethod("getFirstname");
        Object result = m.invoke(instance);
        System.out.println( result );
        
        assertEquals("hello", result);     
    }
    
}
