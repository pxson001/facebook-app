package com.facebook.reaction.feed.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.reaction.common.ReactionAnalyticsParams;

/* compiled from: b99fc0647613522374343a46277309a2 */
public class HasReactionAnalyticsParamsImplProvider extends AbstractAssistedProvider<HasReactionAnalyticsParamsImpl> {
    public static HasReactionAnalyticsParamsImpl m23151a(ReactionAnalyticsParams reactionAnalyticsParams) {
        return new HasReactionAnalyticsParamsImpl(reactionAnalyticsParams);
    }
}
