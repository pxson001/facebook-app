package com.facebook.analytics.powermetrics;

import android.content.Intent;
import com.facebook.common.hardware.BatteryStateManager.BatteryChangeListener;

/* compiled from: emoji_color_nux */
class PowerMetricsController$2 implements BatteryChangeListener {
    final /* synthetic */ PowerMetricsController f14497a;

    PowerMetricsController$2(PowerMetricsController powerMetricsController) {
        this.f14497a = powerMetricsController;
    }

    public final void m14666a(Intent intent) {
        if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED") || intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
            this.f14497a.h = true;
        }
    }
}
