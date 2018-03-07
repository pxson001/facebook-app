package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: checkin_after_party */
/* synthetic */ class NumberDeserializers$1 {
    static final /* synthetic */ int[] f6086a = new int[JsonToken.values().length];
    static final /* synthetic */ int[] f6087b = new int[NumberType.values().length];

    static {
        try {
            f6087b[NumberType.INT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6087b[NumberType.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6086a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6086a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f6086a[JsonToken.VALUE_STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
    }
}
