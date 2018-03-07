package com.facebook.interstitial.annotations;

import com.facebook.metagen.CodeGeneratorMetadataAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@CodeGeneratorMetadataAnnotation(generator = "com.facebook.metagen.generator.mustache.MustacheCodeGenerator")
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: TOPIC_HOME_IMPROVEMENT */
public @interface InterstitialControllerAttributes {
    String id();
}
