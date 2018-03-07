package com.facebook.reaction.feed.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.reaction.ReactionSession;

/* compiled from: autocompose */
public class HasReactionSessionImplProvider extends AbstractAssistedProvider<HasReactionSessionImpl> {
    public static HasReactionSessionImpl m23158a(ReactionSession reactionSession) {
        return new HasReactionSessionImpl(reactionSession);
    }
}
