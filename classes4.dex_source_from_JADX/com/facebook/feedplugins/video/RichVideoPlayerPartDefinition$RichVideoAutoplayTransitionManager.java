package com.facebook.feedplugins.video;

import android.os.Handler;
import android.view.View;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.util.composer.InlineCommentComposerCache;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.attachments.video.VideoAutoplayTransitionManager;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.player.RichVideoPlayer;
import com.google.common.base.Preconditions;

/* compiled from: pic */
public final class RichVideoPlayerPartDefinition$RichVideoAutoplayTransitionManager implements VideoAutoplayTransitionManager {
    public final HasInvalidate f4999a;
    public final InlineCommentComposerCache f5000b;
    public RichVideoPlayerPartDefinition$State f5001c;

    public RichVideoPlayerPartDefinition$RichVideoAutoplayTransitionManager(RichVideoPlayerPartDefinition$State richVideoPlayerPartDefinition$State, HasInvalidate hasInvalidate, InlineCommentComposerCache inlineCommentComposerCache) {
        Preconditions.checkNotNull(richVideoPlayerPartDefinition$State);
        this.f5001c = richVideoPlayerPartDefinition$State;
        this.f4999a = hasInvalidate;
        this.f5000b = inlineCommentComposerCache;
    }

    public final void mo429a() {
        this.f5001c.f4986r = false;
    }

    public final void mo432a(boolean z) {
        Preconditions.checkNotNull(this.f5001c.f4969a);
        RichVideoPlayer richVideoPlayer = this.f5001c.f4969a.getRichVideoPlayer();
        richVideoPlayer.setOriginalPlayReason(this.f5001c.f4975g.b);
        richVideoPlayer.setChannelEligibility(this.f5001c.f4975g.c);
    }

    public final void mo430a(FrameRateBlameMarkers frameRateBlameMarkers, EventTriggerType eventTriggerType, PlayPosition playPosition) {
        Preconditions.checkNotNull(this.f5001c.f4969a);
        RichVideoPlayerPartDefinition.b(this.f5001c.f4969a.getRichVideoPlayer(), this.f5001c, frameRateBlameMarkers, eventTriggerType, playPosition);
    }

    public final void mo433b() {
        RichVideoPlayerPartDefinition.c(this.f5001c, EventTriggerType.BY_USER);
    }

    public final void mo431a(ExitFullScreenResult exitFullScreenResult) {
        HandlerDetour.a(new Handler(), new 1(this), 609397407);
    }

    public final View mo434c() {
        return this.f5001c.f4969a;
    }

    public final AutoplayStateManager mo435d() {
        return this.f5001c.f4977i;
    }

    public final InlineVideoPersistentState mo436e() {
        return this.f5001c.f4978j;
    }

    public final GraphQLStoryAttachment mo437f() {
        return this.f5001c.f4970b;
    }
}
