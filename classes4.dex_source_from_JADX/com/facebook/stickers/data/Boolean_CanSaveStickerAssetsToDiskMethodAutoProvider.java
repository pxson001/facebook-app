package com.facebook.stickers.data;

import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;

/* compiled from: enable_phoneid_sync */
public class Boolean_CanSaveStickerAssetsToDiskMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return CanSaveStickerAssetsToDiskProvider.m14998a(StatFsHelperMethodAutoProvider.a(this), RuntimePermissionsUtil.b(this));
    }
}
