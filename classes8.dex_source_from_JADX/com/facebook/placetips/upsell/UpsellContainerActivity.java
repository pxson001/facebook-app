package com.facebook.placetips.upsell;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.GoogleLocationDialogResult;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.OnGooglePlayServicesLocationUpsellDialogFinishedListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: canViewerChooseMultipleOptions */
public class UpsellContainerActivity extends FbFragmentActivity implements OnGooglePlayServicesLocationUpsellDialogFinishedListener {
    @Inject
    GooglePlayServicesLocationUpsellDialogController f18541p;
    @Inject
    PlaceTipsUpsellAnalyticsLogger f18542q;

    private static <T extends Context> void m22458a(Class<T> cls, T t) {
        m22459a((Object) t, (Context) t);
    }

    public static void m22459a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((UpsellContainerActivity) obj).m22457a(GooglePlayServicesLocationUpsellDialogController.b(fbInjector), PlaceTipsUpsellAnalyticsLogger.a(fbInjector));
    }

    protected final void m22462b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = UpsellContainerActivity.class;
        m22459a((Object) this, (Context) this);
        this.f18541p.a(this, this);
        if (bundle == null) {
            m22460i();
        }
    }

    private void m22457a(GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, PlaceTipsUpsellAnalyticsLogger placeTipsUpsellAnalyticsLogger) {
        this.f18541p = googlePlayServicesLocationUpsellDialogController;
        this.f18542q = placeTipsUpsellAnalyticsLogger;
    }

    private void m22460i() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("gms_dialog_surface");
        String stringExtra2 = intent.getStringExtra("gms_dialog_mechanism");
        if (Strings.isNullOrEmpty(stringExtra) || Strings.isNullOrEmpty(stringExtra2)) {
            finish();
            return;
        }
        this.f18541p.a(new LocationSettingsRequestParams(), stringExtra, stringExtra2);
        this.f18542q.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_DIALOG_TRIGGERED);
    }

    public final void m22461a(GoogleLocationDialogResult googleLocationDialogResult) {
        this.f18542q.a(googleLocationDialogResult);
        finish();
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1323523650);
        this.f18541p.a();
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -543799851, a);
    }
}
