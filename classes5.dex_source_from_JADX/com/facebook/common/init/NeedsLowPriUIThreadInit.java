package com.facebook.common.init;

import com.facebook.metagen.CodeGeneratorMetadataAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@CodeGeneratorMetadataAnnotation(generator = "com.facebook.metagen.generator.mustache.MustacheCodeGenerator")
@Retention(RetentionPolicy.SOURCE)
/* compiled from: souvenir_media */
public @interface NeedsLowPriUIThreadInit {
}
