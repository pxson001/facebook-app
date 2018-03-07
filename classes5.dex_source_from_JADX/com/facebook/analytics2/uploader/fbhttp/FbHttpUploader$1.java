package com.facebook.analytics2.uploader.fbhttp;

import com.facebook.analytics2.logger.UploadJob.Priority;

/* compiled from: terms */
/* synthetic */ class FbHttpUploader$1 {
    static final /* synthetic */ int[] f2094a = new int[Priority.values().length];

    static {
        try {
            f2094a[Priority.HIGH.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2094a[Priority.NORMAL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
