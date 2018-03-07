package com.facebook.composer.modelgen.iface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: addView(View) is not supported in AdapterView */
public @interface ModelField {
    Class<? extends ModelFieldDefaultValueProvider> defaultValueProvider() default ModelFieldDefaultValueProvider.class;

    String fieldName() default "";

    Class<? extends ModelFieldPreprocessor> preprocessor() default ModelFieldPreprocessor.class;
}
