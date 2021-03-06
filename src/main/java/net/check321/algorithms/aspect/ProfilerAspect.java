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
        log.info("====================== Method Start ========================");
        log.info("---- Arrays Size ---- : [{}]", arrs.length);
        if (profiler.logging()) {
            log.info("---- Before Sorting ---- : {}", (Object) arrs);
        }
        timer.set(System.currentTimeMillis());
    }

    @After(value = "methodCutPoint(profiler) && args(arrs)")
    public void afterCall(JoinPoint joinPoint, Profiler profiler, Comparable[] arrs) {

        log.info("---- Profiling Result ---- : Spend [{}ms] on [{}]", System.currentTimeMillis() - timer.get(), joinPoint.getSignature().getDeclaringTypeName());

        if (profiler.logging()) {
            log.info("---- Sorting Result ---- : {}", (Object) arrs);
        }

        if (profiler.verifiable()) {
            boolean isSorted = true;
            for (int i = 0; i < arrs.length - 1; i++) {
                if (arrs[i].compareTo(arrs[i + 1]) > 0) {
                    isSorted = false;
                    break;
                }
            }
            log.info("---- Verify Result ---- : [{}]", isSorted);
        }

    }
}
