package com.facebook.crudolib.urimap;

import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
/* compiled from: open_selecting_content */
public @interface UriMatchPatterns {
    ContentFragmentType fragment() default ContentFragmentType.NONE;
}
