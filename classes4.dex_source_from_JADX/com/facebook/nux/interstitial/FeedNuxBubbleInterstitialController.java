package com.facebook.nux.interstitial;

import android.os.Parcelable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.nux.NuxHistory;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: reportAppDeletionParams */
public abstract class FeedNuxBubbleInterstitialController implements InterstitialController {
    private final Clock f3451a;
    private final ObjectMapper f3452b;
    private final AbstractFbErrorReporter f3453c;
    private final FbSharedPreferences f3454d;
    private FeedNuxBubbleInterstitialInfo f3455e;

    public FeedNuxBubbleInterstitialController(Clock clock, ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences) {
        this.f3451a = clock;
        this.f3452b = objectMapper;
        this.f3453c = abstractFbErrorReporter;
        this.f3454d = fbSharedPreferences;
    }

    public final void m3694a(@Nullable Parcelable parcelable) {
    }

    public final void m3693a(long j) {
    }

    public final InterstitialControllerState m3692a(InterstitialTrigger interstitialTrigger) {
        Object a = this.f3454d.a(m3691d().prefKey, "");
        if (StringUtil.a(a)) {
            return InterstitialControllerState.ELIGIBLE;
        }
        try {
            return ((NuxHistory) this.f3452b.a(a, NuxHistory.class)).b(this.f3451a) ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
        } catch (Throwable e) {
            this.f3453c.a("nux_history_decode_fail", e);
            return InterstitialControllerState.ELIGIBLE;
        }
    }

    public ImmutableList<InterstitialTrigger> mo272c() {
        return ImmutableList.of(new InterstitialTrigger(Action.FEED_STORY_LOADED));
    }

    public final long hI_() {
        return 600000;
    }

    private FeedNuxBubbleInterstitialInfo m3691d() {
        if (this.f3455e == null) {
            this.f3455e = FeedNuxBubbleInterstitialInfo.forControllerClass(getClass());
        }
        return this.f3455e;
    }
}
