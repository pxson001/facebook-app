package com.facebook.contacts.util;

import android.content.Context;
import android.provider.Settings.Secure;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: overlayShadowDrawingEnabled */
public class DeviceUtil {
    private final UniqueIdForDeviceHolderImpl f8513a;

    public static DeviceUtil m12328b(InjectorLike injectorLike) {
        return new DeviceUtil(UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public DeviceUtil(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f8513a = uniqueIdForDeviceHolderImpl;
    }

    public static String m12327a(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public final String m12329a() {
        return this.f8513a.a();
    }
}
