package com.facebook.quickpromotion.ui;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.build.BuildConstants;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegateProvider;

/* compiled from: represented_profile */
public abstract class QuickPromotionThreadListInterstitialController extends QuickPromotionController {
    public static final String f3448a;
    public static final InterstitialTrigger f3449b = new InterstitialTrigger(Action.THREAD_LIST_INTERSTITIAL_OPEN);

    protected QuickPromotionThreadListInterstitialController(QuickPromotionControllerDelegateProvider quickPromotionControllerDelegateProvider) {
        super(quickPromotionControllerDelegateProvider);
    }

    public final Intent m3684b(Context context) {
        return new Intent();
    }

    public final long m3685f() {
        return 0;
    }

    protected final boolean m3686k() {
        return true;
    }

    static {
        String str;
        if (BuildConstants.j) {
            str = "4099";
        } else {
            str = "1957";
        }
        f3448a = str;
    }
}
