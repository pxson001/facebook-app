package com.facebook.feed.topicfeeds.nux;

import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: Trying to use ViewHoverRenderer on a non hoverable view */
public class TopicFeedsTooltipInterstitialController extends BaseInterstitialController {
    public final String m24271b() {
        return "4153";
    }

    public final InterstitialControllerState m24270a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m24272c() {
        return ImmutableList.of(new InterstitialTrigger(Action.FEED_STORY_CARET));
    }

    public final long hI_() {
        return 86400000;
    }
}
