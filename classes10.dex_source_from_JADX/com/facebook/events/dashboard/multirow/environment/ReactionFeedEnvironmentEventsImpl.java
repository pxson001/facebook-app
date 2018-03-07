package com.facebook.events.dashboard.multirow.environment;

import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.extra.IN_APP_WEB_SHARE */
public class ReactionFeedEnvironmentEventsImpl implements HasReactionInteractionTracker, HasReactionSession {
    private final ReactionInteractionTracker f17135a;
    private final ReactionSession f17136b;

    @Inject
    public ReactionFeedEnvironmentEventsImpl(@Assisted ReactionInteractionTracker reactionInteractionTracker, @Assisted ReactionSession reactionSession) {
        this.f17135a = reactionInteractionTracker;
        this.f17136b = reactionSession;
    }

    public final ReactionInteractionTracker kE_() {
        return this.f17135a;
    }

    public final ReactionSession m17480p() {
        return this.f17136b;
    }
}
