package com.facebook.stickers.data;

import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;

/* compiled from: dbl_flag */
public class CanSaveStickerAssetsToDiskProvider {
    private static final Class<?> f14185a = CanSaveStickerAssetsToDiskProvider.class;

    public static Boolean m14998a(StatFsHelper statFsHelper, RuntimePermissionsUtil runtimePermissionsUtil) {
        if (!runtimePermissionsUtil.a("android.permission.WRITE_EXTERNAL_STORAGE")) {
            return Boolean.valueOf(false);
        }
        long a = statFsHelper.a(StorageType.EXTERNAL);
        if (a == 0) {
            return Boolean.valueOf(false);
        }
        if (a >= 52428800) {
            return Boolean.valueOf(true);
        }
        Long.valueOf(a);
        return Boolean.valueOf(false);
    }
}
