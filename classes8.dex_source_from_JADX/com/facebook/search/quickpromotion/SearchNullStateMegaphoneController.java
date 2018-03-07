package com.facebook.search.quickpromotion;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.megaphone.ui.QuickPromotionMegaphoneStoryView;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import javax.inject.Inject;

/* compiled from: TAP_ON_V1_PROMPT_SECONDARY_ACTION */
public class SearchNullStateMegaphoneController {
    private final Context f22506a;
    private final InterstitialManager f22507b;

    public static SearchNullStateMegaphoneController m25975a(InjectorLike injectorLike) {
        return new SearchNullStateMegaphoneController((Context) injectorLike.getInstance(Context.class), InterstitialManager.a(injectorLike));
    }

    @Inject
    public SearchNullStateMegaphoneController(Context context, InterstitialManager interstitialManager) {
        this.f22506a = context;
        this.f22507b = interstitialManager;
    }

    public final boolean m25978a() {
        return m25976b() != null;
    }

    public final void m25977a(QuickPromotionMegaphoneStoryView quickPromotionMegaphoneStoryView) {
        QuickPromotionDefinition b = m25976b();
        if (b != null) {
            quickPromotionMegaphoneStoryView.m1573a(b, "3191");
        }
    }

    @Nullable
    private QuickPromotionDefinition m25976b() {
        InterstitialIntentController interstitialIntentController = (InterstitialIntentController) this.f22507b.a(QuickPromotionSearchMegaphoneController.f22350a, QuickPromotionSearchMegaphoneController.class);
        if (interstitialIntentController == null) {
            return null;
        }
        Intent a = interstitialIntentController.a(this.f22506a);
        if (a == null) {
            return null;
        }
        return (QuickPromotionDefinition) a.getExtras().get("qp_definition");
    }
}
