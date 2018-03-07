package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.annotation.JsonSerialize$Inclusion;

/* compiled from: cell */
/* synthetic */ class JacksonAnnotationIntrospector$1 {
    static final /* synthetic */ int[] f6111a = new int[JsonSerialize$Inclusion.values().length];

    static {
        try {
            f6111a[JsonSerialize$Inclusion.ALWAYS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6111a[JsonSerialize$Inclusion.NON_NULL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6111a[JsonSerialize$Inclusion.NON_DEFAULT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6111a[JsonSerialize$Inclusion.NON_EMPTY.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
