package com.facebook.timeline.header.ui;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.timeline.data.TimelineHeaderRenderState;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.ProfileOverlayHelper;

/* compiled from: fetchThreadList (Sync) */
public class ProfileDebugControllerOverlayProvider extends AbstractAssistedProvider<ProfileDebugControllerOverlay> {
    public final ProfileDebugControllerOverlay m12046a(TimelineHeaderUserData timelineHeaderUserData) {
        return new ProfileDebugControllerOverlay(timelineHeaderUserData, TimelineHeaderRenderState.a(this), ProfileOverlayHelper.a(this));
    }
}
