package com.facebook.location.ui;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import javax.inject.Inject;

/* compiled from: divider */
public class LocationServicesLocationSetting implements LocationSetting {
    private final Context f15242a;
    private final FbLocationStatusUtil f15243b;

    /* compiled from: divider */
    /* synthetic */ class C16631 {
        static final /* synthetic */ int[] f15241a = new int[State.values().length];

        static {
            try {
                f15241a[State.OKAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15241a[State.LOCATION_DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static LocationServicesLocationSetting m17678a(InjectorLike injectorLike) {
        return new LocationServicesLocationSetting((Context) injectorLike.getInstance(Context.class), FbLocationStatusUtil.a(injectorLike));
    }

    @Inject
    public LocationServicesLocationSetting(Context context, FbLocationStatusUtil fbLocationStatusUtil) {
        this.f15242a = context;
        this.f15243b = fbLocationStatusUtil;
    }

    public final boolean mo913a() {
        switch (C16631.f15241a[this.f15243b.b().a.ordinal()]) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public final String mo914b() {
        return this.f15242a.getString(2131239610);
    }

    public final String mo915c() {
        switch (C16631.f15241a[this.f15243b.b().a.ordinal()]) {
            case 1:
                return this.f15242a.getString(2131230749);
            case 2:
                return this.f15242a.getString(2131230750);
            default:
                return null;
        }
    }

    public final String mo916d() {
        return "location_services";
    }

    public final PendingIntent mo917e() {
        return PendingIntent.getActivity(this.f15242a, 0, new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
    }
}
