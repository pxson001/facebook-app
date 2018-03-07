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

/* compiled from: TEXT_COLOR */
public final class QuickPromotionSearchMegaphoneController extends QuickPromotionController {
    public static final InterstitialTrigger f22350a = new InterstitialTrigger(Action.SEARCH_NULL_STATE);

    @Inject
    public QuickPromotionSearchMegaphoneController(QuickPromotionControllerDelegateProvider quickPromotionControllerDelegateProvider) {
        super(quickPromotionControllerDelegateProvider);
    }

    protected final Intent m25850b(Context context) {
        return new Intent();
    }

    protected final long m25852f() {
        return 0;
    }

    public final String m25853g() {
        return "Android Search Null-State Megaphone";
    }

    public final String m25851b() {
        return "3191";
    }

    public final Set<TemplateType> m25854j() {
        return ImmutableSet.of(TemplateType.SEARCH_NULL_STATE_MEGAPHONE);
    }
}
