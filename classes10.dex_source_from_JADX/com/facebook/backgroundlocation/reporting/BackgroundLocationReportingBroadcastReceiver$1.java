package com.facebook.backgroundlocation.reporting;

import android.content.Context;
import com.facebook.backgroundlocation.reporting.abtest.ExperimentsForBackgroundLocationReportingModule;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationSignalDataPackage;
import com.google.android.gms.common.GoogleApiAvailability;

/* compiled from: divebarUser */
class BackgroundLocationReportingBroadcastReceiver$1 implements Runnable {
    final /* synthetic */ Context f14860a;
    final /* synthetic */ ImmutableLocation f14861b;
    final /* synthetic */ BackgroundLocationReportingBroadcastReceiver f14862c;

    BackgroundLocationReportingBroadcastReceiver$1(BackgroundLocationReportingBroadcastReceiver backgroundLocationReportingBroadcastReceiver, Context context, ImmutableLocation immutableLocation) {
        this.f14862c = backgroundLocationReportingBroadcastReceiver;
        this.f14860a = context;
        this.f14861b = immutableLocation;
    }

    public void run() {
        this.f14862c.d.b();
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.b;
        if (GoogleApiAvailability.a(this.f14860a) == 0 && this.f14862c.l.a(ExperimentsForBackgroundLocationReportingModule.k, false)) {
            ((GeofenceLocationTracker) this.f14862c.i.get()).m15410a(this.f14861b);
        }
        this.f14862c.e.a(new LocationSignalDataPackage(this.f14861b, Boolean.valueOf(this.f14862c.a.l()), this.f14862c.f.a(), this.f14862c.f.b(), null, null));
    }
}
