package com.facebook.location.ui;

import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import javax.inject.Inject;

/* compiled from: dismiss_niem */
public class LocationSettingsPerfLogger {
    public final PerformanceLogger f15277a;

    /* compiled from: dismiss_niem */
    public enum Marker {
        OVERALL_TTI(3342342, "location_settings_perf_overall_tti"),
        INIT(3342343, "location_settings_perf_init"),
        FETCH_DATA(3342344, "location_settings_perf_fetch_data"),
        RENDER(3342345, "location_settings_perf_render");
        
        public int markerId;
        public final String markerName;

        private Marker(int i, String str) {
            this.markerName = str;
            this.markerId = i;
        }
    }

    public static LocationSettingsPerfLogger m17710a(InjectorLike injectorLike) {
        return new LocationSettingsPerfLogger((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    @Inject
    public LocationSettingsPerfLogger(PerformanceLogger performanceLogger) {
        this.f15277a = performanceLogger;
    }

    final void m17711a(Marker marker) {
        this.f15277a.d(marker.markerId, marker.markerName);
    }

    final void m17712b(Marker marker) {
        this.f15277a.c(marker.markerId, marker.markerName);
    }

    final void m17713c(Marker marker) {
        this.f15277a.f(marker.markerId, marker.markerName);
    }
}
