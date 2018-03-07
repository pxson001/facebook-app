package com.facebook.places.checkin.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.checkin.PlacePickerFragment;
import com.facebook.places.checkin.PlacePickerNavController;
import com.facebook.places.checkin.analytics.PlacePickerAnalytics;
import com.facebook.places.checkin.analytics.PlacesPerformanceLogger;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.common.MockDeps;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: page/{#%s}/vistor_posts */
public class SelectAtTagActivity extends FbFragmentActivity implements AnalyticsActivity {
    public static final String f4406p = SelectAtTagActivity.class.getSimpleName();
    @Inject
    PlacesPerformanceLogger f4407q;
    @Inject
    PlacePickerAnalytics f4408r;
    private PlacePickerFragment f4409s;
    private PlacePickerConfiguration f4410t;

    private static <T extends Context> void m5396a(Class<T> cls, T t) {
        m5397a((Object) t, (Context) t);
    }

    public static void m5397a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SelectAtTagActivity) obj).m5395a(PlacesPerformanceLogger.a(fbInjector), PlacePickerAnalytics.a(fbInjector));
    }

    private void m5395a(PlacesPerformanceLogger placesPerformanceLogger, PlacePickerAnalytics placePickerAnalytics) {
        this.f4407q = placesPerformanceLogger;
        this.f4408r = placePickerAnalytics;
    }

    public final void m5401b(Bundle bundle) {
        long uptimeMillis = SystemClock.uptimeMillis();
        m5398c(bundle);
        m5400e(bundle);
        PlacesPerformanceLogger placesPerformanceLogger = this.f4407q;
        placesPerformanceLogger.f.a(f4406p, uptimeMillis);
    }

    private void m5398c(Bundle bundle) {
        boolean z = true;
        Class cls = SelectAtTagActivity.class;
        m5397a((Object) this, (Context) this);
        MockDeps.a(this);
        this.f4410t = (PlacePickerConfiguration) getIntent().getParcelableExtra("place_picker_configuration");
        Preconditions.checkArgument(this.f4410t != null);
        if (this.f4410t.p == null) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f4407q.a(this.f4410t.p);
        setContentView(2130907056);
        m5399d(bundle);
        getWindow().getDecorView().setBackgroundColor(-1);
    }

    private void m5399d(Bundle bundle) {
        if (bundle != null) {
            this.f4408r.a(bundle);
            return;
        }
        String uuid = SafeUUIDGenerator.a().toString();
        this.f4408r.f = this.f4410t.p;
        this.f4408r.d = this.f4410t.e;
        this.f4408r.e = uuid;
        getIntent().putExtra("place_picker_session_id", uuid);
    }

    private void m5400e(Bundle bundle) {
        if (bundle == null) {
            this.f4409s = new PlacePickerFragment();
            kO_().a().a(2131567396, this.f4409s).b();
            return;
        }
        this.f4409s = (PlacePickerFragment) kO_().a(2131567396);
    }

    public final String am_() {
        return "tag_places_view";
    }

    public void onBackPressed() {
        if (this.f4409s != null) {
            PlacePickerFragment placePickerFragment = this.f4409s;
            Object obj = 1;
            if (placePickerFragment.aV != null) {
                PlacePickerFragment.a(placePickerFragment, null);
            } else {
                Object obj2;
                placePickerFragment.i.b();
                placePickerFragment.aD.b(FunnelRegistry.o, "back_pressed");
                PlacePickerFragment.d(placePickerFragment, placePickerFragment.aM);
                PlacePickerNavController placePickerNavController = placePickerFragment.d;
                if (!placePickerNavController.b.v || placePickerNavController.n == null) {
                    obj2 = null;
                } else {
                    placePickerNavController.b(placePickerNavController.n);
                    obj2 = 1;
                }
                if (obj2 == null) {
                    obj = null;
                }
            }
            if (obj != null) {
                return;
            }
        }
        super.onBackPressed();
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 332715091);
        PlacesPerformanceLogger placesPerformanceLogger = this.f4407q;
        placesPerformanceLogger.f.c(f4406p);
        super.onStart();
        placesPerformanceLogger = this.f4407q;
        placesPerformanceLogger.f.d(f4406p);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1661747785, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -739820982);
        PlacesPerformanceLogger placesPerformanceLogger = this.f4407q;
        placesPerformanceLogger.f.e(f4406p);
        super.onResume();
        placesPerformanceLogger = this.f4407q;
        placesPerformanceLogger.f.f(f4406p);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1158678899, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -234281608);
        super.onPause();
        this.f4407q.a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 655714546, a);
    }
}
