package com.facebook.reaction;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.reaction.ReactionSessionManager.ReactionRequestTrackerCallback;
import com.facebook.reaction.event.ReactionEventBus;

/* compiled from: buttonStyle */
public class ReactionRequestTrackerProvider extends AbstractAssistedProvider<ReactionRequestTracker> {
    public final ReactionRequestTracker m22545a(ReactionRequestTrackerCallback reactionRequestTrackerCallback) {
        return new ReactionRequestTracker(reactionRequestTrackerCallback, ReactionEventBus.m22919a(this));
    }
}
