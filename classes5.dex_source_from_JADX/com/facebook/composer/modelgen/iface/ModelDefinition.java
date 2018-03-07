package com.facebook.composer.modelgen.iface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: add_from_profile */
public @interface ModelDefinition {
    String modelClassName();

    Class<? extends ModelValidator> validator() default ModelValidator.class;
}
