package com.facebook.search.quickpromotion;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialControllerWithExtraLogData;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.util.GraphSearchConfig;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: TEXT_CAPTION_XLARGE */
public class ScopedSearchGroupsNuxController implements InterstitialActionController, InterstitialController, InterstitialControllerWithExtraLogData {
    private final Context f22352a;
    private final GraphSearchConfig f22353b;
    public View f22354c;
    public boolean f22355d;
    public GraphSearchQuery f22356e;

    @Inject
    public ScopedSearchGroupsNuxController(Context context, GraphSearchConfig graphSearchConfig) {
        this.f22352a = context;
        this.f22353b = graphSearchConfig;
    }

    public final void m25858a(Context context, Object obj) {
        Tooltip tooltip = new Tooltip(context, 2);
        tooltip.b(this.f22352a.getString(this.f22355d ? 2131239543 : 2131239544));
        tooltip.a(Position.BELOW);
        tooltip.t = -1;
        tooltip.b(0.3f);
        tooltip.f(this.f22354c);
    }

    public final String m25860b() {
        return "3747";
    }

    public final void m25859a(Parcelable parcelable) {
    }

    public final InterstitialControllerState m25856a(InterstitialTrigger interstitialTrigger) {
        if (this.f22354c == null || this.f22356e == null || !this.f22353b.m10646f(this.f22356e)) {
            return InterstitialControllerState.INELIGIBLE;
        }
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m25861c() {
        return ImmutableList.of(new InterstitialTrigger(Action.GROUP_SCOPED_SEARCH));
    }

    public final ImmutableMap<String, String> m25862e() {
        return ImmutableMap.of("query_scope_id", this.f22356e.f, "query_scope_type", this.f22356e.h != null ? this.f22356e.h.toString() : null);
    }

    public final long hI_() {
        return 86400000;
    }

    public final void m25857a(long j) {
    }
}
