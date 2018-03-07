package com.facebook.feedplugins.video;

import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.video.engine.ExitFullScreenResult;

/* compiled from: form_input_has_error */
class FullscreenVideoAttachmentPartDefinition$2 implements FullscreenTransitionListener {
    final /* synthetic */ AutoplayStateManager f13033a;
    final /* synthetic */ FullscreenVideoAttachmentPartDefinition f13034b;

    FullscreenVideoAttachmentPartDefinition$2(FullscreenVideoAttachmentPartDefinition fullscreenVideoAttachmentPartDefinition, AutoplayStateManager autoplayStateManager) {
        this.f13034b = fullscreenVideoAttachmentPartDefinition;
        this.f13033a = autoplayStateManager;
    }

    public final void m14732a(ExitFullScreenResult exitFullScreenResult) {
        this.f13033a.a(exitFullScreenResult.b, exitFullScreenResult.a);
    }
}
