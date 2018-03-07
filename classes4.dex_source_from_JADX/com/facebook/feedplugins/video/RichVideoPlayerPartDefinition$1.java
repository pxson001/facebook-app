package com.facebook.feedplugins.video;

import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;

/* compiled from: pic */
class RichVideoPlayerPartDefinition$1 implements RichVideoPlayerCallbackListener {
    final /* synthetic */ InlineVideoPersistentState f4965a;
    final /* synthetic */ CanShowVideoInFullScreen f4966b;
    final /* synthetic */ RichVideoPlayerPartDefinition$Props f4967c;
    final /* synthetic */ RichVideoPlayerPartDefinition f4968d;

    RichVideoPlayerPartDefinition$1(RichVideoPlayerPartDefinition richVideoPlayerPartDefinition, InlineVideoPersistentState inlineVideoPersistentState, CanShowVideoInFullScreen canShowVideoInFullScreen, RichVideoPlayerPartDefinition$Props richVideoPlayerPartDefinition$Props) {
        this.f4968d = richVideoPlayerPartDefinition;
        this.f4965a = inlineVideoPersistentState;
        this.f4966b = canShowVideoInFullScreen;
        this.f4967c = richVideoPlayerPartDefinition$Props;
    }

    public final void mo426a(RVPStreamCompleteEvent rVPStreamCompleteEvent) {
        this.f4965a.mo422b().m5321f();
        this.f4965a.mo421a(0);
        this.f4965a.f4907a = true;
        ((HasInvalidate) this.f4966b).a(new FeedProps[]{this.f4967c.f4791a});
    }

    public final void mo424a() {
    }

    public final void mo425a(RVPErrorEvent rVPErrorEvent) {
        if (rVPErrorEvent.f14075b.value.equals(VideoError.ERROR_IO.value) || rVPErrorEvent.f14075b.value.equals(VideoError.SERVER_DIED.value) || rVPErrorEvent.f14075b.value.equals(VideoError.UNSUPPORTED.value)) {
            this.f4965a.mo422b().m5324i();
        }
    }
}
