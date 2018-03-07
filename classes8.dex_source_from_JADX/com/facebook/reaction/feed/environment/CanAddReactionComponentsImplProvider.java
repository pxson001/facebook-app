package com.facebook.reaction.feed.environment;

import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: background_location */
public class CanAddReactionComponentsImplProvider extends AbstractAssistedProvider<CanAddReactionComponentsImpl> {
    public static CanAddReactionComponentsImpl m23141a(HasReactionCardContainer hasReactionCardContainer) {
        return new CanAddReactionComponentsImpl(hasReactionCardContainer);
    }
}
