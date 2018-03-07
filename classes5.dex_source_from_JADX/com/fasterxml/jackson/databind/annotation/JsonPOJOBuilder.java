package com.fasterxml.jackson.databind.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: client_ineligible_flow_action_click */
public @interface JsonPOJOBuilder {

    /* compiled from: client_ineligible_flow_action_click */
    public class Value {
        public final String f5983a;
        public final String f5984b;

        public Value(JsonPOJOBuilder jsonPOJOBuilder) {
            this.f5983a = jsonPOJOBuilder.buildMethodName();
            this.f5984b = jsonPOJOBuilder.withPrefix();
        }
    }

    String buildMethodName() default "build";

    String withPrefix() default "with";
}
