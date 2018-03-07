package com.facebook.feedplugins.attachments.video;

import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.VideoClickedEvent;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.player.FullScreenVideoListener;

/* compiled from: TE;Z)V */
class VideoAttachmentDelegate$FullscreenListener implements FullScreenVideoListener {
    final /* synthetic */ VideoAttachmentDelegate f22848a;

    public VideoAttachmentDelegate$FullscreenListener(VideoAttachmentDelegate videoAttachmentDelegate) {
        this.f22848a = videoAttachmentDelegate;
    }

    public final void m25404a(EventTriggerType eventTriggerType) {
        this.f22848a.x.a(this.f22848a.s);
        if (!this.f22848a.t.mo1531g()) {
            this.f22848a.y.b(this.f22848a.s.m(), PlayerType.INLINE_PLAYER.value, eventTriggerType.value, this.f22848a.s.j(), this.f22848a.s.r(), this.f22848a.s.d.b, this.f22848a.s.o(), this.f22848a.s);
        }
        FeedProps e = AttachmentProps.e(this.f22848a.d);
        if (e != null) {
            String g;
            GraphQLStory c = StoryProps.c(e);
            FeedEventBus feedEventBus = this.f22848a.f;
            String g2 = ((GraphQLStory) e.a).g();
            if (c != null) {
                g = c.g();
            } else {
                g = null;
            }
            feedEventBus.a(new VideoClickedEvent(g2, g));
        }
    }

    public final void m25405a(EventTriggerType eventTriggerType, ExitFullScreenResult exitFullScreenResult) {
        if (!this.f22848a.t.mo1531g()) {
            this.f22848a.y.a(this.f22848a.s.m(), PlayerType.INLINE_PLAYER.value, eventTriggerType.value, exitFullScreenResult.c, this.f22848a.s.r(), this.f22848a.s.d.b, this.f22848a.s.o(), this.f22848a.s);
        }
        if (this.f22848a.w != null) {
            this.f22848a.w.a(exitFullScreenResult);
        }
        this.f22848a.x.a();
    }
}
