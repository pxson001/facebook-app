package com.facebook.feedplugins.attachments.video;

import com.facebook.video.engine.ExitFullScreenResult;

/* compiled from: TEXT_FIELD_ERROR */
class Inline360VideoPartDefinition$FullscreenListener implements FullscreenTransitionListener {
    final /* synthetic */ Inline360VideoPartDefinition f22730a;
    private final Inline360VideoPartDefinition$State f22731b;

    public Inline360VideoPartDefinition$FullscreenListener(Inline360VideoPartDefinition inline360VideoPartDefinition, Inline360VideoPartDefinition$State inline360VideoPartDefinition$State) {
        this.f22730a = inline360VideoPartDefinition;
        this.f22731b = inline360VideoPartDefinition$State;
    }

    public final void m25352a(ExitFullScreenResult exitFullScreenResult) {
        this.f22731b.f22747j = false;
        this.f22731b.f22744g.a(exitFullScreenResult.b, exitFullScreenResult.a);
        if (exitFullScreenResult.b) {
            this.f22731b.f22744g.f();
        }
    }
}
