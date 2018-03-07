package com.facebook.feed.topicfeeds.nux;

import android.content.Context;
import android.view.View;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: Trying to use view  */
public class TopicFeedsSwitcherInterstitialController extends BaseInterstitialController implements InterstitialActionController {
    public final void m24267a(Context context, Object obj) {
        if (obj != null && (obj instanceof View)) {
            View view = (View) obj;
            Tooltip tooltip = new Tooltip(view.getContext(), 2);
            tooltip.t = -1;
            tooltip.b(context.getText(2131239091));
            tooltip.a(Position.ABOVE);
            tooltip.a(view);
        }
    }

    public final String m24268b() {
        return "4060";
    }

    public final InterstitialControllerState m24266a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m24269c() {
        return ImmutableList.of(new InterstitialTrigger(Action.FEED_STORY_LOADED));
    }

    public final long hI_() {
        return 86400000;
    }
}
