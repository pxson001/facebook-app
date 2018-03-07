package com.facebook.feed.environment;

import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.parts.HasEnvironmentController;
import com.facebook.multirow.api.DirtyUnitObserver;

/* compiled from: next_section_type */
public interface FeedEnvironment extends CanFeedback, CanFollowUser, CanFriendPerson, CanLikePage, CanShowVideoInFullScreen, HasAnchoredTooltipProvider, HasContext, HasFeedListType, HasImageLoadListener, HasInvalidate, HasMenuButtonProvider, HasMutationControllerManager, HasPersistentState, HasPositionInformation, HasPrefetcher, HasRowKey, HasScrollListenerSupport, HasIsAsync, HasEnvironmentController, DirtyUnitObserver {
}
