package com.facebook.redspace.nux;

import android.content.Context;
import android.view.View;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;

/* compiled from: overlayColor */
public class RedSpaceDivebarInterstitialController extends BaseInterstitialController implements InterstitialActionController {
    public static final InterstitialTrigger f4554a = new InterstitialTrigger(Action.REDSPACE_BADGE_LOAD);
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceStrings> f4555b = UltralightRuntime.b;
    @Inject
    public GatekeeperStoreImpl f4556c;

    public final InterstitialControllerState m5812a(InterstitialTrigger interstitialTrigger) {
        return this.f4556c.a(992, false) ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
    }

    public final String m5814b() {
        return "4093";
    }

    public final ImmutableList<InterstitialTrigger> m5815c() {
        return ImmutableList.of(f4554a);
    }

    public final long hI_() {
        return 86400000;
    }

    public final void m5813a(Context context, Object obj) {
        if (obj != null && (obj instanceof View)) {
            View view = (View) obj;
            Tooltip tooltip = new Tooltip(view.getContext(), 2);
            tooltip.a(((RedSpaceStrings) this.f4555b.get()).c());
            tooltip.a(Position.BELOW);
            tooltip.t = -1;
            tooltip.a(view);
        }
    }
}
