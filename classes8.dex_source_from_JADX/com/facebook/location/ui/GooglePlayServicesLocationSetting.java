package com.facebook.location.ui;

import android.app.PendingIntent;
import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.android.gms.common.GooglePlayServicesUtil;
import javax.inject.Inject;

/* compiled from: do_action */
public class GooglePlayServicesLocationSetting implements LocationSetting {
    private final Context f15239a;
    private final FbZeroFeatureVisibilityHelper f15240b;

    public static GooglePlayServicesLocationSetting m17672a(InjectorLike injectorLike) {
        return new GooglePlayServicesLocationSetting((Context) injectorLike.getInstance(Context.class), FbZeroFeatureVisibilityHelper.a(injectorLike));
    }

    @Inject
    public GooglePlayServicesLocationSetting(Context context, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper) {
        this.f15239a = context;
        this.f15240b = fbZeroFeatureVisibilityHelper;
    }

    public final boolean mo913a() {
        if (this.f15240b.a(ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL)) {
            return false;
        }
        int a = GooglePlayServicesUtil.a(this.f15239a);
        if (a == 0 || !GooglePlayServicesUtil.c(a) || GooglePlayServicesUtil.a(a, this.f15239a, 0) == null) {
            return false;
        }
        return true;
    }

    public final String mo914b() {
        return this.f15239a.getString(2131239612);
    }

    public final String mo915c() {
        return this.f15239a.getString(2131230750);
    }

    public final String mo916d() {
        return "google_play_services";
    }

    public final PendingIntent mo917e() {
        return GooglePlayServicesUtil.a(GooglePlayServicesUtil.a(this.f15239a), this.f15239a, 0);
    }
}
