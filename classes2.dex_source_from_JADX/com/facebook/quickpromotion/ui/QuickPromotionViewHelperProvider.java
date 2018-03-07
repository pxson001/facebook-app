package com.facebook.quickpromotion.ui;

import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialTriggerContext;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.quickpromotion.action.DefaultQuickPromotionActionHandler;
import com.facebook.quickpromotion.filter.QuickPromotionCounters;
import com.facebook.quickpromotion.logger.QuickPromotionLogger;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;

/* compiled from: redspace/friends/overflow */
public class QuickPromotionViewHelperProvider extends AbstractAssistedProvider<QuickPromotionViewHelper> {
    public final QuickPromotionViewHelper m12392a(QuickPromotionDefinition quickPromotionDefinition, String str, Creative creative, InterstitialTriggerContext interstitialTriggerContext) {
        return new QuickPromotionViewHelper(quickPromotionDefinition, str, creative, interstitialTriggerContext, QuickPromotionCounters.m12575a((InjectorLike) this), QuickPromotionLogger.m12600b((InjectorLike) this), FbSharedPreferencesImpl.m1826a((InjectorLike) this), SystemClockMethodAutoProvider.m1498a(this), DefaultQuickPromotionActionHandler.a(this));
    }
}
