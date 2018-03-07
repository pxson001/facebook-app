package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: can_viewer_edit_post_media */
/* synthetic */ class TokenBuffer$1 {
    static final /* synthetic */ int[] f6256a = new int[JsonToken.values().length];
    static final /* synthetic */ int[] f6257b = new int[NumberType.values().length];

    static {
        try {
            f6257b[NumberType.INT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6257b[NumberType.BIG_INTEGER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6257b[NumberType.BIG_DECIMAL.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6257b[NumberType.FLOAT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f6257b[NumberType.LONG.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f6256a[JsonToken.START_OBJECT.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f6256a[JsonToken.END_OBJECT.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f6256a[JsonToken.START_ARRAY.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f6256a[JsonToken.END_ARRAY.ordinal()] = 4;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f6256a[JsonToken.FIELD_NAME.ordinal()] = 5;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f6256a[JsonToken.VALUE_STRING.ordinal()] = 6;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f6256a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 7;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f6256a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f6256a[JsonToken.VALUE_TRUE.ordinal()] = 9;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f6256a[JsonToken.VALUE_FALSE.ordinal()] = 10;
        } catch (NoSuchFieldError e15) {
        }
        try {
            f6256a[JsonToken.VALUE_NULL.ordinal()] = 11;
        } catch (NoSuchFieldError e16) {
        }
        try {
            f6256a[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 12;
        } catch (NoSuchFieldError e17) {
        }
    }
}
