package com.facebook.backgroundlocation.settings;

import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import javax.inject.Inject;

/* compiled from: dialog_cache_status */
public class BackgroundLocationSettingsPerfLogger {
    public final PerformanceLogger f15048a;

    /* compiled from: dialog_cache_status */
    public enum Marker {
        OVERALL_TTI(2490369, "background_location_settings_perf_overall_tti"),
        INIT(2490371, "background_location_settings_perf_init"),
        FETCH_DATA(2490370, "background_location_settings_perf_fetch_data"),
        RENDER(2490372, "background_location_settings_perf_render");
        
        public final int eventId;
        public final String markerName;

        private Marker(int i, String str) {
            this.eventId = i;
            this.markerName = str;
        }
    }

    public static BackgroundLocationSettingsPerfLogger m15506b(InjectorLike injectorLike) {
        return new BackgroundLocationSettingsPerfLogger((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    @Inject
    BackgroundLocationSettingsPerfLogger(PerformanceLogger performanceLogger) {
        this.f15048a = performanceLogger;
    }

    final void m15507a(Marker marker) {
        this.f15048a.d(marker.eventId, marker.markerName);
    }

    final void m15508b(Marker marker) {
        this.f15048a.c(marker.eventId, marker.markerName);
    }

    final void m15509c(Marker marker) {
        this.f15048a.f(marker.eventId, marker.markerName);
    }
}
