package com.facebook.resources.impl.model;

import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: PREF_SECOND */
public class StringResourcesUtil$StringResourceBlobReadException extends RuntimeException {
    StringResourcesUtil$StringResourceBlobReadException(String str, int i, int i2) {
        super(StringFormatUtil.formatStrLocaleSafe("Error reading resources blob for '%s'; expected length: %d, length read: %d", str, Integer.valueOf(i), Integer.valueOf(i2)));
    }
}
