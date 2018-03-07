package com.facebook.reaction.feed.environment;

import com.facebook.inject.Assisted;
import com.facebook.reaction.common.ReactionCardContainer;
import javax.inject.Inject;

/* compiled from: awesomizer_session_identifier */
public class HasReactionCardContainerImpl implements HasReactionCardContainer {
    private final ReactionCardContainer f19125a;

    @Inject
    public HasReactionCardContainerImpl(@Assisted ReactionCardContainer reactionCardContainer) {
        this.f19125a = reactionCardContainer;
    }

    public final ReactionCardContainer mo705q() {
        return this.f19125a;
    }
}
