package com.facebook.feedplugins.multishare;

import android.view.View;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.ui.inlinevideoplayer.ScrollSpeedEstimator;
import com.facebook.feed.video.util.VideoUtils;
import com.facebook.feedplugins.attachments.video.AutoplayVisibilityRunnable;
import com.facebook.feedplugins.attachments.video.AutoplayVisibilityRunnableActivityListener;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.multishare.MultiSharePagerItemViewPartDefinition.State;
import com.facebook.feedplugins.multishare.ui.MultiShareProductItemView;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import javax.inject.Provider;

/* compiled from: conncls_latency_qual */
public class C1009x3967b361 extends AutoplayVisibilityRunnable {
    private final InlineVideoPersistentState f8013a;
    public final State f8014b;
    public final VideoLoggingUtils f8015c;
    public final VideoAutoPlaySettingsChecker f8016d;

    public C1009x3967b361(int i, Provider<ScrollSpeedEstimator> provider, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener, VideoLoggingUtils videoLoggingUtils, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, InlineVideoPersistentState inlineVideoPersistentState, State state) {
        super(autoplayVisibilityRunnableActivityListener, videoAutoplayVisibilityDecider, provider, i);
        this.f8015c = videoLoggingUtils;
        this.f8016d = videoAutoPlaySettingsChecker;
        this.f8013a = inlineVideoPersistentState;
        this.f8014b = state;
    }

    public final void m9075a(View view) {
        this.f8014b.n.clear();
        boolean a = this.f8014b.l.a(this.f8014b.n);
        if (!this.f8014b.h.f) {
            VideoUtils.a(this.f8014b.h, this.f8014b.n, this.f8016d, this.f8015c, this.f8014b.g.e, this.f8014b.g.b, this.f8014b.c.k, this.f8014b.g.f, ChannelEligibility.WRONG_STORY_TYPE, this.f8014b.g);
        }
        if (a) {
            this.f8013a.e = EventTriggerType.BY_AUTOPLAY;
            MultiSharePagerItemViewPartDefinition.d(this.f8014b, this.f8014b.f);
        }
    }

    public final void m9076b(View view) {
        this.f8014b.h.b(false);
        State state = this.f8014b;
        MultiShareProductItemView multiShareProductItemView = this.f8014b.f;
        state.j.a(multiShareProductItemView.b.getCurrentPositionMs());
        state.j.d = false;
        multiShareProductItemView.e();
    }

    public final boolean m9077c(View view) {
        return this.f8014b.e.m();
    }
}
