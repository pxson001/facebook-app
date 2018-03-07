package com.facebook.dialtone.switcher;

import android.view.View;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.service.ZeroUpdateStatusManager;

/* compiled from: permissions_email_text */
class DialtoneManualSwitcher$7 implements Runnable {
    final /* synthetic */ View f6686a;
    final /* synthetic */ Tooltip f6687b;
    final /* synthetic */ Lazy f6688c;
    final /* synthetic */ Lazy f6689d;
    final /* synthetic */ Lazy f6690e;
    final /* synthetic */ DialtoneManualSwitcher f6691f;

    DialtoneManualSwitcher$7(DialtoneManualSwitcher dialtoneManualSwitcher, View view, Tooltip tooltip, Lazy lazy, Lazy lazy2, Lazy lazy3) {
        this.f6691f = dialtoneManualSwitcher;
        this.f6686a = view;
        this.f6687b = tooltip;
        this.f6688c = lazy;
        this.f6689d = lazy2;
        this.f6690e = lazy3;
    }

    public void run() {
        int[] iArr = new int[2];
        this.f6686a.getLocationInWindow(iArr);
        this.f6687b.b(2131232602);
        if (iArr[0] == 0 && iArr[1] == 0) {
            this.f6686a.removeCallbacks(this);
        } else if (((FbSharedPreferences) this.f6688c.get()).a(DialtonePrefKeys.C, false)) {
            this.f6686a.removeCallbacks(this);
        } else {
            this.f6687b.a(this.f6686a);
            ((FbSharedPreferences) this.f6688c.get()).edit().a(DialtonePrefKeys.B, ((FbSharedPreferences) this.f6688c.get()).a(DialtonePrefKeys.B, 0) + 1).putBoolean(DialtonePrefKeys.C, true).commit();
            ((ZeroUpdateStatusManager) this.f6689d.get()).a("dialtone_zero_balance_tooltip");
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("dialtone_switcher_zero_balance_tooltip_impression");
            honeyClientEvent.b("carrier_id", ((FbSharedPreferences) this.f6688c.get()).a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
            AnalyticsLogger analyticsLogger = (AnalyticsLogger) this.f6690e.get();
            honeyClientEvent.c = "dialtone";
            analyticsLogger.a(honeyClientEvent);
        }
    }
}
