package com.facebook.flatbuffers;

import com.facebook.flatbuffers.Flattenable.VirtualFlattenableResolver;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: render_insights_entry_button */
public @interface FlattenableField {
    Class<? extends Flattener<?>> keyFlattener() default NilFlattener.class;

    Class<? extends VirtualFlattenableResolver> keyTypeResolver() default NilResolver.class;

    Class<? extends Flattener<?>> valueFlattener() default NilFlattener.class;

    Class<? extends VirtualFlattenableResolver> valueTypeResolver() default NilResolver.class;
}
