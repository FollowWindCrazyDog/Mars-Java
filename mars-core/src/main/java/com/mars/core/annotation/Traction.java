package com.mars.core.annotation;

import com.mars.core.enums.TractionLevel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Traction {

    TractionLevel level() default TractionLevel.READ_UNCOMMITTED;

}
