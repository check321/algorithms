package net.check321.algorithms.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @title 性能测试
* @description
* @author check321
* @date 2018/4/5 0:30
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiler {

    /**
     * @return 日志输出开关
     */
    boolean logging() default true;


    /**
     * 验证数组结果开关
     * @return
     */
    boolean verifiable() default true;
}
