package com.facebook.maps;

import android.content.Context;
import com.facebook.android.maps.internal.MapConfig;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: zero_extra_charges_dialog_confirm */
public class FbMapInitializer {
    private static boolean f143d = false;
    private final Context f144a;
    private final MapAnalyticsLogger f145b;
    private final MapsRuntimePermissionManager f146c;
    private final String f147e;

    public static FbMapInitializer m109b(InjectorLike injectorLike) {
        return new FbMapInitializer((Context) injectorLike.getInstance(Context.class), ViewerContextMethodAutoProvider.b(injectorLike), MapAnalyticsLogger.a(injectorLike), MapsRuntimePermissionManager.a(injectorLike));
    }

    @Inject
    public FbMapInitializer(Context context, ViewerContext viewerContext, MapAnalyticsLogger mapAnalyticsLogger, MapsRuntimePermissionManager mapsRuntimePermissionManager) {
        this.f144a = context;
        this.f147e = viewerContext.mAuthToken;
        this.f145b = mapAnalyticsLogger;
        this.f146c = mapsRuntimePermissionManager;
    }

    public final void m110a() {
        if (!f143d) {
            AnalyticsEvent.a(this.f145b);
            MapConfig.a(this.f144a, this.f147e, this.f146c);
            f143d = true;
        }
    }
}
