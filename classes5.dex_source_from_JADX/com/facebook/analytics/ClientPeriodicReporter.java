package com.facebook.analytics;

import com.facebook.metagen.CodeGeneratorMetadataAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@CodeGeneratorMetadataAnnotation(generator = "com.facebook.metagen.generator.mustache.MustacheCodeGenerator")
@Retention(RetentionPolicy.SOURCE)
/* compiled from: token_position */
public @interface ClientPeriodicReporter {
    String eventName();
}
