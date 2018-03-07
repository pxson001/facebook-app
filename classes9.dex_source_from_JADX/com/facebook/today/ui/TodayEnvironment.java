package com.facebook.today.ui;

import android.content.Context;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImplProvider;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironment;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.feed.environment.HasReactionCardBackgroundImplProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandler;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: turn_server_ipv6 */
public class TodayEnvironment extends DefaultReactionFeedEnvironment {
    @Inject
    public TodayEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Nullable @Assisted BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Assisted Runnable runnable, @Nullable @Assisted ReactionAnalyticsParams reactionAnalyticsParams, @Assisted ReactionFeedActionHandler reactionFeedActionHandler, @Assisted ReactionInteractionTracker reactionInteractionTracker, @Assisted ReactionSession reactionSession, @Assisted Delegate delegate, CanAddReactionComponentsImplProvider canAddReactionComponentsImplProvider, CanHandleHScrollPageChangedEventsImpl canHandleHScrollPageChangedEventsImpl, HasReactionAnalyticsParamsImplProvider hasReactionAnalyticsParamsImplProvider, HasReactionCardBackgroundImplProvider hasReactionCardBackgroundImplProvider) {
        super(context, feedListType, baseFeedStoryMenuHelper, runnable, reactionAnalyticsParams, reactionFeedActionHandler, reactionInteractionTracker, reactionSession, delegate, canAddReactionComponentsImplProvider, canHandleHScrollPageChangedEventsImpl, hasReactionAnalyticsParamsImplProvider, hasReactionCardBackgroundImplProvider);
    }
}
