package com.facebook.analytics.powermetrics;

import com.facebook.common.hardware.BatteryStateManager.PluggedState;
import com.facebook.localstats.LocalStatsListener;

/* compiled from: emoji_color_nux */
class PowerMetricsController$1 implements LocalStatsListener {
    final /* synthetic */ PowerMetricsController f14496a;

    PowerMetricsController$1(PowerMetricsController powerMetricsController) {
        this.f14496a = powerMetricsController;
    }

    public final void m14665a() {
        PowerMetricsController powerMetricsController = this.f14496a;
        float a = powerMetricsController.f.a();
        if (powerMetricsController.h || powerMetricsController.f.d() != PluggedState.NOT_PLUGGED || a == -1.0f || powerMetricsController.b == -1.0f) {
            powerMetricsController.e.a(7208964, -1);
            powerMetricsController.h = false;
        } else {
            powerMetricsController.e.a(7208964, (long) Math.round((powerMetricsController.b - a) * 100.0f));
        }
        powerMetricsController.b = a;
        this.f14496a.a();
        this.f14496a.c();
        this.f14496a.d();
        this.f14496a.e();
    }
}
