package com.facebook.quickpromotion.ui;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.build.BuildConstants;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegateProvider;

/* compiled from: mComponentMutex */
public abstract class QuickPromotionInterstitialController extends QuickPromotionController {
    public static final String f15709a = (BuildConstants.j ? "4090" : "1818");

    protected QuickPromotionInterstitialController(QuickPromotionControllerDelegateProvider quickPromotionControllerDelegateProvider) {
        super(quickPromotionControllerDelegateProvider);
    }

    public final Intent mo1683b(Context context) {
        return new Intent(context, QuickPromotionInterstitialActivity.class);
    }

    public final long mo1684f() {
        return 86400000;
    }

    protected final boolean mo2884k() {
        return true;
    }
}
