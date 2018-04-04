package net.check321.algorithms.aspect;

import lombok.extern.slf4j.Slf4j;
import net.check321.algorithms.annotations.Profiler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author check321
 * @title 性能测试切面
 * @description
 * @date 2018/4/5 0:34
 */
@Aspect
@Component
@Slf4j
public class ProfilerAspect {

    static ThreadLocal<Long> timer = new ThreadLocal<>();

    @Pointcut("@annotation(profiler)")
    public void methodCutPoint(Profiler profiler) {
    }

    @Before(value = "methodCutPoint(profiler) && args(arrs)")
    public void beforeCall(JoinPoint joinPoint, Profiler profiler, Object[] arrs) {
        if (profiler.logging()) {
            log.info("---- Before Sorting ---- : {}", (Object) arrs);
        }
        timer.set(System.currentTimeMillis());
    }
    
    @After(value = "methodCutPoint(profiler) && args(arrs)")
    public void afterCall(JoinPoint joinPoint, Profiler profiler, Object[] arrs){
        if (profiler.logging()) {
            log.info("---- Sorting Result ---- : {}", (Object) arrs);
        }
        log.info("---- Profiling Result ---- : Spend [{}ms] on [{}]",System.currentTimeMillis() - timer.get(),joinPoint.getSignature().getDeclaringTypeName());
    }
}
