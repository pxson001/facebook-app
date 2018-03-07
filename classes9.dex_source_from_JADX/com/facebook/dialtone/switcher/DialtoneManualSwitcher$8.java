package com.facebook.dialtone.switcher;

import android.view.View;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.common.constants.FbZeroTokenType;

/* compiled from: permissions_email_text */
class DialtoneManualSwitcher$8 implements Runnable {
    final /* synthetic */ View f6692a;
    final /* synthetic */ Tooltip f6693b;
    final /* synthetic */ Lazy f6694c;
    final /* synthetic */ Lazy f6695d;
    final /* synthetic */ DialtoneManualSwitcher f6696e;

    DialtoneManualSwitcher$8(DialtoneManualSwitcher dialtoneManualSwitcher, View view, Tooltip tooltip, Lazy lazy, Lazy lazy2) {
        this.f6696e = dialtoneManualSwitcher;
        this.f6692a = view;
        this.f6693b = tooltip;
        this.f6694c = lazy;
        this.f6695d = lazy2;
    }

    public void run() {
        int[] iArr = new int[2];
        this.f6692a.getLocationInWindow(iArr);
        this.f6693b.b(2131232603);
        if (iArr[0] == 0 && iArr[1] == 0) {
            this.f6692a.removeCallbacks(this);
        } else if (((FbSharedPreferences) this.f6694c.get()).a(DialtonePrefKeys.G, false)) {
            this.f6692a.removeCallbacks(this);
        } else {
            this.f6693b.a(this.f6692a);
            ((FbSharedPreferences) this.f6694c.get()).edit().putBoolean(DialtonePrefKeys.G, true).commit();
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("dialtone_optout_tooltip_impression");
            honeyClientEvent.b("carrier_id", ((FbSharedPreferences) this.f6694c.get()).a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
            AnalyticsLogger analyticsLogger = (AnalyticsLogger) this.f6695d.get();
            honeyClientEvent.c = "dialtone";
            analyticsLogger.a(honeyClientEvent);
        }
    }
}
