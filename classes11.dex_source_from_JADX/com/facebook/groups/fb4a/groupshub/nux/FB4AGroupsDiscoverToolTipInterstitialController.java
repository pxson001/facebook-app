package com.facebook.groups.fb4a.groupshub.nux;

import android.os.Parcelable;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: _bt_ */
public class FB4AGroupsDiscoverToolTipInterstitialController implements InterstitialController {
    private static final ImmutableList<InterstitialTrigger> f10207a = ImmutableList.of(new InterstitialTrigger(Action.GROUPS_DISCOVER_TAB_TOOL_TIP));
    public GlyphColorizer f10208b;

    @Inject
    public FB4AGroupsDiscoverToolTipInterstitialController(GlyphColorizer glyphColorizer) {
        this.f10208b = glyphColorizer;
    }

    public final String m10554b() {
        return "4207";
    }

    public final void m10553a(Parcelable parcelable) {
    }

    public final void m10552a(long j) {
    }

    public final InterstitialControllerState m10551a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m10555c() {
        return f10207a;
    }

    public final long hI_() {
        return 86400000;
    }
}
