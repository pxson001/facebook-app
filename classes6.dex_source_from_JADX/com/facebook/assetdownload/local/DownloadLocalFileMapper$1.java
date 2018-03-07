package com.facebook.assetdownload.local;

import com.facebook.assetdownload.AssetDownloadConfiguration.StorageConstraint;

/* compiled from: profile_pic_nux */
/* synthetic */ class DownloadLocalFileMapper$1 {
    static final /* synthetic */ int[] f7326a = new int[StorageConstraint.values().length];

    static {
        try {
            f7326a[StorageConstraint.MUST_BE_CUSTOM_LOCATION.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f7326a[StorageConstraint.MUST_BE_INTERNAL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f7326a[StorageConstraint.CAN_BE_EXTERNAL.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
