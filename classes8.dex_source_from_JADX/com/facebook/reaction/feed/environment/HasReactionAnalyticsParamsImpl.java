package com.facebook.reaction.feed.environment;

import com.facebook.inject.Assisted;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ba2d5d29dd536b0fb0cc39d53b818fc4 */
public class HasReactionAnalyticsParamsImpl implements HasReactionAnalyticsParams {
    @Nullable
    private final ReactionAnalyticsParams f19123a;

    @Inject
    public HasReactionAnalyticsParamsImpl(@Nullable @Assisted ReactionAnalyticsParams reactionAnalyticsParams) {
        this.f19123a = reactionAnalyticsParams;
    }

    @Nullable
    public final ReactionAnalyticsParams mo706r() {
        return this.f19123a;
    }
}
