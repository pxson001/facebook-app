package com.facebook.messaging.cache;

import com.facebook.messaging.model.folders.ThreadsCacheType;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;

/* compiled from: method/user.setContactInfo */
/* synthetic */ class DataCache$1 {
    static final /* synthetic */ int[] f9484a = new int[Type.values().length];
    static final /* synthetic */ int[] f9485b = new int[ThreadsCacheType.values().length];

    static {
        try {
            f9485b[ThreadsCacheType.SMS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9485b[ThreadsCacheType.FB.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f9485b[ThreadsCacheType.TINCAN.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f9484a[Type.ONE_TO_ONE.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f9484a[Type.GROUP.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f9484a[Type.PENDING_THREAD.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f9484a[Type.MONTAGE.ordinal()] = 4;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f9484a[Type.MY_MONTAGE.ordinal()] = 5;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f9484a[Type.SMS.ordinal()] = 6;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f9484a[Type.TINCAN.ordinal()] = 7;
        } catch (NoSuchFieldError e10) {
        }
    }
}
