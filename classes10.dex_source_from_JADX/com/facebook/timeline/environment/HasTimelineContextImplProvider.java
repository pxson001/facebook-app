package com.facebook.timeline.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.profile.TimelineContext;

/* compiled from: fw_photo_uploaded */
public class HasTimelineContextImplProvider extends AbstractAssistedProvider<HasTimelineContextImpl> {
    public static HasTimelineContextImpl m11109a(TimelineContext timelineContext) {
        return new HasTimelineContextImpl(timelineContext);
    }
}
