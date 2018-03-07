package com.facebook.common.android;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: stride */
public class DevicePolicyManagerMethodAutoProvider extends AbstractProvider<DevicePolicyManager> {
    private static DevicePolicyManager m3611b(InjectorLike injectorLike) {
        return AndroidModule.f((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.f((Context) getInstance(Context.class));
    }
}
