package com.facebook.react.views.image;

import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import javax.annotation.Nullable;

/* compiled from: SEARCH_NEARBY_PLACES_AND_LAYOUT */
public class ImageResizeMode {
    public static ScaleType m11845a(@Nullable String str) {
        if ("contain".equals(str)) {
            return ScaleType.c;
        }
        if ("cover".equals(str)) {
            return ScaleType.g;
        }
        if ("stretch".equals(str)) {
            return ScaleType.a;
        }
        if ("center".equals(str)) {
            return ScaleType.f;
        }
        if (str == null) {
            return ScaleType.g;
        }
        throw new JSApplicationIllegalArgumentException("Invalid resize mode: '" + str + "'");
    }

    public static ScaleType m11844a() {
        return ScaleType.g;
    }
}
