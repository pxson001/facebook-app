package com.fasterxml.jackson.databind.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.Converter.None;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: video_packet_loss_high */
public @interface JsonSerialize {
    Class<?> as() default NoClass.class;

    Class<?> contentAs() default NoClass.class;

    Class<? extends Converter<?, ?>> contentConverter() default None.class;

    Class<? extends JsonSerializer<?>> contentUsing() default JsonSerializer.None.class;

    Class<? extends Converter<?, ?>> converter() default None.class;

    @Deprecated
    Inclusion include() default Inclusion.ALWAYS;

    Class<?> keyAs() default NoClass.class;

    Class<? extends JsonSerializer<?>> keyUsing() default JsonSerializer.None.class;

    Typing typing() default Typing.DYNAMIC;

    Class<? extends JsonSerializer<?>> using() default JsonSerializer.None.class;
}
