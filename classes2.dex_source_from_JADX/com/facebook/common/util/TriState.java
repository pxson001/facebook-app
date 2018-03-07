package com.facebook.common.util;

import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: video_upload */
public enum TriState {
    YES,
    NO,
    UNSET;

    /* compiled from: video_upload */
    /* synthetic */ class C01061 {
        static final /* synthetic */ int[] f1484a = null;

        static {
            f1484a = new int[TriState.values().length];
            try {
                f1484a[TriState.YES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1484a[TriState.NO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1484a[TriState.UNSET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public final boolean isSet() {
        return this != UNSET;
    }

    public static TriState valueOf(boolean z) {
        return z ? YES : NO;
    }

    public static TriState valueOf(Boolean bool) {
        return bool != null ? valueOf(bool.booleanValue()) : UNSET;
    }

    public final boolean asBoolean() {
        switch (C01061.f1484a[ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return true;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return false;
            case 3:
                throw new IllegalStateException("No boolean equivalent for UNSET");
            default:
                throw new IllegalStateException("Unrecognized TriState value: " + this);
        }
    }

    public final boolean asBoolean(boolean z) {
        switch (C01061.f1484a[ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return true;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return false;
            case 3:
                return z;
            default:
                throw new IllegalStateException("Unrecognized TriState value: " + this);
        }
    }

    public final Boolean asBooleanObject() {
        switch (C01061.f1484a[ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return Boolean.TRUE;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return Boolean.FALSE;
            case 3:
                return null;
            default:
                throw new IllegalStateException("Unrecognized TriState value: " + this);
        }
    }

    public final int getDbValue() {
        switch (C01061.f1484a[ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return 1;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return 2;
            default:
                return 3;
        }
    }

    public static TriState fromDbValue(int i) {
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return YES;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return NO;
            default:
                return UNSET;
        }
    }
}
