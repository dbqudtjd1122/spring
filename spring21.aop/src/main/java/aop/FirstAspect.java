package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.ModelProduct;

public class FirstAspect {
    
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    // 메서드가 실행되기 직전.
    public void before( JoinPoint jp){
        logger.debug( "before ----> 메서드그 호출 되기 전");
        logger.debug( "before ----> 호출되는 메서드는 " + jp.getSignature().getName() );
        logger.debug( "before ----> 매개변수는 " + jp.getArgs().toString() );        
    }
    // 메서드 실행 후 :: 반환값이 없는 경우.
    public void after() {
        logger.debug( "after ----> 메서드그 호출된 후");
        logger.debug( "after ----> 메서드그 호출된 후");
        logger.debug( "after ----> 메서드그 호출된 후");
    }
    // 메서드 실행 후 :: 반환값이 있는 경우.
    public void afterReturning( JoinPoint jp, ModelProduct product){
        logger.debug( "afterReturning ----> 메서드가 return 되었을 때");
        logger.debug( "afterReturning ----> 호출된 메서드는 " + jp.getSignature().getName() );
        logger.debug( "afterReturning ----> 매개변수는 " + jp.getArgs().toString() );        
    }
    // 메서드 실행 전.후
    public ModelProduct around( ProceedingJoinPoint jp ) throws Throwable {
        ModelProduct p = null ;
        
        return p;
    }    
    // 메서드 실행시 예외가 발생했을 때
    public void afterThrowing( Throwable e) {
        
    }
}
