package com.facebook.reaction;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;

/* compiled from: ca7fdbdd015edfd7851418cc901fda0c */
public class PrefetchReactionRequestTrackerProvider extends AbstractAssistedProvider<PrefetchReactionRequestTracker> {
    public final PrefetchReactionRequestTracker m22492a(ReactionSessionManager reactionSessionManager) {
        return new PrefetchReactionRequestTracker(reactionSessionManager, (Clock) SystemClockMethodAutoProvider.a(this), ReactionAnalyticsLogger.m22814a((InjectorLike) this), IdBasedLazy.a(this, 9834));
    }
}
