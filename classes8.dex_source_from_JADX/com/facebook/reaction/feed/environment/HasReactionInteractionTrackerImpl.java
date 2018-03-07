package com.facebook.reaction.feed.environment;

import com.facebook.inject.Assisted;
import com.facebook.reaction.common.ReactionInteractionTracker;
import javax.inject.Inject;

/* compiled from: availability_location */
public class HasReactionInteractionTrackerImpl implements HasReactionInteractionTracker {
    private final ReactionInteractionTracker f19126a;

    @Inject
    public HasReactionInteractionTrackerImpl(@Assisted ReactionInteractionTracker reactionInteractionTracker) {
        this.f19126a = reactionInteractionTracker;
    }

    public final ReactionInteractionTracker kE_() {
        return this.f19126a;
    }
}
