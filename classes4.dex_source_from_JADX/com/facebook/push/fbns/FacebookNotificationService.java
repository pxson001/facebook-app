package com.facebook.push.fbns;

import com.facebook.config.application.FbAppType;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.inject.Inject;

/* compiled from: image_data_height */
public class FacebookNotificationService {
    private static final Class<?> f10507a = FacebookNotificationService.class;
    private static final PrefKey f10508b = ((PrefKey) SharedPrefKeys.a.a("fbns_tokens/"));
    public final FbSharedPreferences f10509c;
    public final FbAppType f10510d;
    public final UniqueIdForDeviceHolderImpl f10511e;
    public final PrefKey f10512f = ((PrefKey) f10508b.a(this.f10510d.c()));

    @Inject
    public FacebookNotificationService(FbSharedPreferences fbSharedPreferences, FbAppType fbAppType, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f10509c = fbSharedPreferences;
        this.f10510d = fbAppType;
        this.f10511e = uniqueIdForDeviceHolderImpl;
    }
}
