package com.facebook.feed.loader;

/* compiled from: measure_time */
public enum LoadIntentHint {
    AvoidNewStoryPill,
    ShowNewStoryPill,
    ShowMoreStoryPill,
    HideLoadingIndicator;

    public final boolean showNewStoryPill() {
        return this == ShowNewStoryPill;
    }

    public final boolean avoidNewStoryPill() {
        return this == AvoidNewStoryPill;
    }
}
