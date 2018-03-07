package com.facebook.reaction.feed.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.reaction.common.ReactionInteractionTracker;

/* compiled from: autoplay_style */
public class HasReactionInteractionTrackerImplProvider extends AbstractAssistedProvider<HasReactionInteractionTrackerImpl> {
    public static HasReactionInteractionTrackerImpl m23156a(ReactionInteractionTracker reactionInteractionTracker) {
        return new HasReactionInteractionTrackerImpl(reactionInteractionTracker);
    }
}
