package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: vault_device_setup bad sync mode */
public @interface JsonTypeInfo {
    boolean m599a() default false;

    Class<?> defaultImpl() default None.class;

    As include() default As.PROPERTY;

    String property() default "";

    Id use();
}
