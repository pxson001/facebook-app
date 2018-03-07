package com.facebook.events.dashboard.multirow.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionInteractionTracker;

/* compiled from: com.facebook.platform.extra.INSTALLDATA_PACKAGE */
public class ReactionFeedEnvironmentEventsImplProvider extends AbstractAssistedProvider<ReactionFeedEnvironmentEventsImpl> {
    public static ReactionFeedEnvironmentEventsImpl m17481a(ReactionInteractionTracker reactionInteractionTracker, ReactionSession reactionSession) {
        return new ReactionFeedEnvironmentEventsImpl(reactionInteractionTracker, reactionSession);
    }
}
