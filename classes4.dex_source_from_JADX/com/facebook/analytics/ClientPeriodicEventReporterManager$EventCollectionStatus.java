package com.facebook.analytics;

import com.facebook.crudolib.prefs.LightSharedPreferences.Editor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: images/ads/common/pins/map-card-pin-2x.png */
class ClientPeriodicEventReporterManager$EventCollectionStatus {
    Editor f10468a = null;
    Builder<HoneyAnalyticsEvent> f10469b = null;
    long f10470c = Long.MAX_VALUE;
    final /* synthetic */ ClientPeriodicEventReporterManager f10471d;

    public ClientPeriodicEventReporterManager$EventCollectionStatus(ClientPeriodicEventReporterManager clientPeriodicEventReporterManager) {
        this.f10471d = clientPeriodicEventReporterManager;
    }

    final void m11020a(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (this.f10469b == null) {
            this.f10469b = ImmutableList.builder();
        }
        this.f10469b.c(honeyAnalyticsEvent);
    }

    public static ImmutableList m11016a(ClientPeriodicEventReporterManager$EventCollectionStatus clientPeriodicEventReporterManager$EventCollectionStatus) {
        return clientPeriodicEventReporterManager$EventCollectionStatus.f10469b != null ? clientPeriodicEventReporterManager$EventCollectionStatus.f10469b.b() : null;
    }

    final void m11021a(String str, long j) {
        if (this.f10468a == null) {
            this.f10468a = this.f10471d.b().b();
        }
        this.f10468a.a(str, j);
    }

    public static void m11017b(ClientPeriodicEventReporterManager$EventCollectionStatus clientPeriodicEventReporterManager$EventCollectionStatus) {
        if (clientPeriodicEventReporterManager$EventCollectionStatus.f10468a != null) {
            clientPeriodicEventReporterManager$EventCollectionStatus.f10468a.b();
        }
    }

    final void m11019a(long j) {
        this.f10470c = Math.min(this.f10470c, j);
    }

    public static long m11018c(ClientPeriodicEventReporterManager$EventCollectionStatus clientPeriodicEventReporterManager$EventCollectionStatus) {
        return clientPeriodicEventReporterManager$EventCollectionStatus.f10470c < Long.MAX_VALUE ? clientPeriodicEventReporterManager$EventCollectionStatus.f10470c : -1;
    }
}
