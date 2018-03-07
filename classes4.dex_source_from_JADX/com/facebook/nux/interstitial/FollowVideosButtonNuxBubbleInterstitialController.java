package com.facebook.nux.interstitial;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: reg_terms_contacts_end_v2 */
public class FollowVideosButtonNuxBubbleInterstitialController extends FeedNuxBubbleInterstitialController {
    @Inject
    public FollowVideosButtonNuxBubbleInterstitialController(Clock clock, ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences) {
        super(clock, objectMapper, abstractFbErrorReporter, fbSharedPreferences);
    }

    public final String m3879b() {
        return "4141";
    }

    public final ImmutableList<InterstitialTrigger> mo272c() {
        return ImmutableList.of(new InterstitialTrigger(Action.VIDEO_HOME_FEED));
    }
}
