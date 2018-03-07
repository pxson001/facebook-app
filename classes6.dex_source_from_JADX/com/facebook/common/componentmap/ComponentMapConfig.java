package com.facebook.common.componentmap;

import com.facebook.metagen.CodeGeneratorMetadataAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@CodeGeneratorMetadataAnnotation(generator = "com.facebook.metagen.generator.mustache.MustacheCodeGenerator")
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* compiled from: place_profile_pic_suggests */
public @interface ComponentMapConfig {
}
