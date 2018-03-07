package com.facebook.feedplugins.attachments.video;

import com.facebook.debug.log.BLog;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;

/* compiled from: TEXT_FIELD_ERROR */
public class Inline360VideoPartDefinition$RVPListener implements RichVideoPlayerCallbackListener {
    final /* synthetic */ Inline360VideoPartDefinition f22736a;
    private final Inline360VideoPartDefinition$State f22737b;

    public Inline360VideoPartDefinition$RVPListener(Inline360VideoPartDefinition inline360VideoPartDefinition, Inline360VideoPartDefinition$State inline360VideoPartDefinition$State) {
        this.f22736a = inline360VideoPartDefinition;
        this.f22737b = inline360VideoPartDefinition$State;
    }

    public final void m25359a(RVPStreamCompleteEvent rVPStreamCompleteEvent) {
        this.f22737b.f22744g.f();
    }

    public final void m25357a() {
    }

    public final void m25358a(RVPErrorEvent rVPErrorEvent) {
        BLog.b("V360", "RVPListener.onError %s", new Object[]{rVPErrorEvent});
    }
}
