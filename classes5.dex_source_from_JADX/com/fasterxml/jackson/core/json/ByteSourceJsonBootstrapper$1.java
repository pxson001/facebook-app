package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonEncoding;

/* compiled from: collapse_state */
/* synthetic */ class ByteSourceJsonBootstrapper$1 {
    static final /* synthetic */ int[] f5963a = new int[JsonEncoding.values().length];

    static {
        try {
            f5963a[JsonEncoding.UTF32_BE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5963a[JsonEncoding.UTF32_LE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5963a[JsonEncoding.UTF16_BE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f5963a[JsonEncoding.UTF16_LE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f5963a[JsonEncoding.UTF8.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
