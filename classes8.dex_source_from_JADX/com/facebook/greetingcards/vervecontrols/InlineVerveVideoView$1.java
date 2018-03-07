package com.facebook.greetingcards.vervecontrols;

import com.facebook.greetingcards.verve.render.VerveVideoContainer$VerveVideoContainerListener;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;

/* compiled from: view_page_profile */
class InlineVerveVideoView$1 implements RichVideoPlayerCallbackListener {
    final /* synthetic */ VerveVideoContainer$VerveVideoContainerListener f441a;
    final /* synthetic */ InlineVerveVideoView f442b;

    InlineVerveVideoView$1(InlineVerveVideoView inlineVerveVideoView, VerveVideoContainer$VerveVideoContainerListener verveVideoContainer$VerveVideoContainerListener) {
        this.f442b = inlineVerveVideoView;
        this.f441a = verveVideoContainer$VerveVideoContainerListener;
    }

    public final void m419a(RVPStreamCompleteEvent rVPStreamCompleteEvent) {
    }

    public final void m417a() {
    }

    public final void m418a(RVPErrorEvent rVPErrorEvent) {
    }
}
