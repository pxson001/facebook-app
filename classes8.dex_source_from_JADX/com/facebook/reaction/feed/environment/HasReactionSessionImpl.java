package com.facebook.reaction.feed.environment;

import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionSession;
import javax.inject.Inject;

/* compiled from: autoplay */
public class HasReactionSessionImpl implements HasReactionSession {
    private final ReactionSession f19127a;

    @Inject
    public HasReactionSessionImpl(@Assisted ReactionSession reactionSession) {
        this.f19127a = reactionSession;
    }

    public final ReactionSession mo704p() {
        return this.f19127a;
    }
}
