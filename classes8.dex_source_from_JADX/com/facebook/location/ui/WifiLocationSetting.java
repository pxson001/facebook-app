package com.facebook.location.ui;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;

/* compiled from: discover */
public class WifiLocationSetting implements LocationSetting {
    private final Context f15278a;
    private final PackageManager f15279b;
    private final DeviceConditionHelper f15280c;
    private final FbZeroFeatureVisibilityHelper f15281d;

    public static WifiLocationSetting m17714a(InjectorLike injectorLike) {
        return new WifiLocationSetting((Context) injectorLike.getInstance(Context.class), PackageManagerMethodAutoProvider.a(injectorLike), DeviceConditionHelper.a(injectorLike), FbZeroFeatureVisibilityHelper.a(injectorLike));
    }

    @Inject
    public WifiLocationSetting(Context context, PackageManager packageManager, DeviceConditionHelper deviceConditionHelper, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper) {
        this.f15278a = context;
        this.f15279b = packageManager;
        this.f15280c = deviceConditionHelper;
        this.f15281d = fbZeroFeatureVisibilityHelper;
    }

    public final boolean mo913a() {
        return this.f15279b.hasSystemFeature("android.hardware.wifi") && !this.f15281d.a(ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL);
    }

    public final String mo914b() {
        return this.f15278a.getString(2131239611);
    }

    public final String mo915c() {
        if (this.f15280c.a()) {
            return this.f15278a.getString(2131230749);
        }
        return this.f15278a.getString(2131230750);
    }

    public final String mo916d() {
        return "wifi";
    }

    public final PendingIntent mo917e() {
        return PendingIntent.getActivity(this.f15278a, 0, new Intent("android.settings.WIFI_SETTINGS"), 0);
    }
}
