package com.fasterxml.jackson.databind.jsonschema;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: ce796a398394fafe3676efa111f3ebdd */
public @interface JsonSerializableSchema {
    String id() default "";

    @Deprecated
    String schemaItemDefinition() default "##irrelevant";

    @Deprecated
    String schemaObjectPropertiesDefinition() default "##irrelevant";

    String schemaType() default "any";
}
