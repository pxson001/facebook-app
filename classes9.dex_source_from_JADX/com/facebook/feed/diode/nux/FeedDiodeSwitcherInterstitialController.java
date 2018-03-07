package com.facebook.feed.diode.nux;

import android.content.Context;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.diode.abtest.ExperimentsForFeedDiodeTestModule;
import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.qe.api.QeAccessor;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: TYPE_DOUBLE */
public class FeedDiodeSwitcherInterstitialController extends BaseInterstitialController implements InterstitialActionController {
    private final QeAccessor f24474a;

    @Inject
    public FeedDiodeSwitcherInterstitialController(QeAccessor qeAccessor) {
        this.f24474a = qeAccessor;
    }

    public final void m26370a(Context context, Object obj) {
        CharSequence a = this.f24474a.a(ExperimentsForFeedDiodeTestModule.j, "");
        if (!StringUtil.a(a) && obj != null && (obj instanceof View)) {
            View view = (View) obj;
            Tooltip tooltip = new Tooltip(view.getContext(), 2);
            tooltip.t = -1;
            tooltip.b(a);
            tooltip.a(Position.ABOVE);
            tooltip.a(view);
        }
    }

    public final String m26371b() {
        return "4212";
    }

    public final InterstitialControllerState m26369a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m26372c() {
        return ImmutableList.of(new InterstitialTrigger(Action.FEED_STORY_LOADED));
    }

    public final long hI_() {
        return 86400000;
    }
}
