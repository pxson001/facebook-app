package com.facebook.search.quickpromotion;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelperProvider;
import com.facebook.search.logging.SearchAwarenessLogger;
import javax.inject.Inject;

/* compiled from: reengagement */
public class SearchQPTooltipController {
    public final Context f7849a;
    public final InterstitialManager f7850b;
    public final QuickPromotionViewHelperProvider f7851c;
    private final SearchAwarenessLogger f7852d;
    public final AbstractFbErrorReporter f7853e;
    public InterstitialIntentController f7854f;

    @Inject
    public SearchQPTooltipController(Context context, InterstitialManager interstitialManager, QuickPromotionViewHelperProvider quickPromotionViewHelperProvider, SearchAwarenessLogger searchAwarenessLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f7849a = context;
        this.f7850b = interstitialManager;
        this.f7851c = quickPromotionViewHelperProvider;
        this.f7852d = searchAwarenessLogger;
        this.f7853e = abstractFbErrorReporter;
    }
}
