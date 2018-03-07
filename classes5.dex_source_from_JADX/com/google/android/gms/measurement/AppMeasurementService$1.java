package com.google.android.gms.measurement;

import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.measurement.internal.zzo;
import com.google.android.gms.measurement.internal.zzt;

class AppMeasurementService$1 implements Runnable {
    final /* synthetic */ zzt f7030a;
    final /* synthetic */ int f7031b;
    final /* synthetic */ zzo f7032c;
    final /* synthetic */ AppMeasurementService f7033d;

    class C07941 implements Runnable {
        final /* synthetic */ AppMeasurementService$1 f7029a;

        C07941(AppMeasurementService$1 appMeasurementService$1) {
            this.f7029a = appMeasurementService$1;
        }

        public void run() {
            if (!this.f7029a.f7033d.stopSelfResult(this.f7029a.f7031b)) {
                return;
            }
            if (zzd.a) {
                this.f7029a.f7032c.m.a("Device AppMeasurementService processed last upload request");
            } else {
                this.f7029a.f7032c.m.a("Local AppMeasurementService processed last upload request");
            }
        }
    }

    AppMeasurementService$1(AppMeasurementService appMeasurementService, zzt com_google_android_gms_measurement_internal_zzt, int i, zzo com_google_android_gms_measurement_internal_zzo) {
        this.f7033d = appMeasurementService;
        this.f7030a = com_google_android_gms_measurement_internal_zzt;
        this.f7031b = i;
        this.f7032c = com_google_android_gms_measurement_internal_zzo;
    }

    public void run() {
        this.f7030a.r();
        HandlerDetour.a(this.f7033d.a, new C07941(this), 837482037);
    }
}
