package com.facebook.reaction.feed.environment;

import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: back_button_tap */
public class CanLaunchReactionIntentImplProvider extends AbstractAssistedProvider<CanLaunchReactionIntentImpl> {
    public static CanLaunchReactionIntentImpl m23148a(ReactionFeedActionHandler reactionFeedActionHandler) {
        return new CanLaunchReactionIntentImpl(reactionFeedActionHandler);
    }
}
