package com.facebook.feedplugins.multishare;

import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;

/* compiled from: conncls_latency_qual */
class MultiSharePagerItemViewPartDefinition$OnVideoEventListener implements RichVideoPlayerCallbackListener {
    final /* synthetic */ MultiSharePagerItemViewPartDefinition f8017a;
    private final InlineVideoPersistentState f8018b;
    private final AutoplayStateManager f8019c;

    public MultiSharePagerItemViewPartDefinition$OnVideoEventListener(MultiSharePagerItemViewPartDefinition multiSharePagerItemViewPartDefinition, InlineVideoPersistentState inlineVideoPersistentState, AutoplayStateManager autoplayStateManager) {
        this.f8017a = multiSharePagerItemViewPartDefinition;
        this.f8018b = inlineVideoPersistentState;
        this.f8019c = autoplayStateManager;
    }

    public final void m9080a(RVPStreamCompleteEvent rVPStreamCompleteEvent) {
        this.f8019c.f();
        this.f8018b.a(0);
        this.f8018b.a = true;
        this.f8018b.d = false;
    }

    public final void m9079a(RVPErrorEvent rVPErrorEvent) {
        if (rVPErrorEvent.b.value.equals(VideoError.ERROR_IO.value) || rVPErrorEvent.b.value.equals(VideoError.SERVER_DIED.value) || rVPErrorEvent.b.value.equals(VideoError.UNSUPPORTED.value)) {
            this.f8019c.i();
        }
    }

    public final void m9078a() {
    }
}
