package com.fasterxml.jackson.databind.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer$None;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.Converter.None;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: video_channel_has_new */
public @interface JsonDeserialize {
    Class<?> as() default NoClass.class;

    Class<?> builder() default NoClass.class;

    Class<?> contentAs() default NoClass.class;

    Class<? extends Converter<?, ?>> contentConverter() default None.class;

    Class<? extends JsonDeserializer<?>> contentUsing() default JsonDeserializer$None.class;

    Class<? extends Converter<?, ?>> converter() default None.class;

    Class<?> keyAs() default NoClass.class;

    Class<? extends KeyDeserializer> keyUsing() default KeyDeserializer.None.class;

    Class<? extends JsonDeserializer<?>> using() default JsonDeserializer$None.class;
}
