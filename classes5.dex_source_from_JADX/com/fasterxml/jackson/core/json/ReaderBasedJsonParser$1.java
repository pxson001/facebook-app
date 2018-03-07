package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonToken;

/* compiled from: code */
/* synthetic */ class ReaderBasedJsonParser$1 {
    static final /* synthetic */ int[] f5964a = new int[JsonToken.values().length];

    static {
        try {
            f5964a[JsonToken.FIELD_NAME.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5964a[JsonToken.VALUE_STRING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5964a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f5964a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f5964a[JsonToken.VALUE_TRUE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f5964a[JsonToken.VALUE_FALSE.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
