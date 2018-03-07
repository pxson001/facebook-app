package com.facebook.search.quickpromotion;

import android.content.Context;
import android.content.Intent;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegateProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: redirects */
public final class QuickPromotionSearchBarTooltipController extends QuickPromotionController {
    public static final InterstitialTrigger f7856a = new InterstitialTrigger(Action.SEARCH_BAR_TOOLTIP);

    @Inject
    public QuickPromotionSearchBarTooltipController(QuickPromotionControllerDelegateProvider quickPromotionControllerDelegateProvider) {
        super(quickPromotionControllerDelegateProvider);
    }

    public final String mo1173b() {
        return "3877";
    }

    protected final Intent mo1683b(Context context) {
        return new Intent();
    }

    protected final long mo1684f() {
        return 0;
    }

    public final String mo1685g() {
        return "Android Search Bar Tooltip";
    }

    protected final Set<TemplateType> mo1686j() {
        return ImmutableSet.of(TemplateType.SEARCH_BAR_TOOLTIP);
    }
}
