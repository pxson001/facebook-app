package com.facebook.timeline.environment;

import com.facebook.feed.environment.CanFollowUser;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.rows.core.parts.HasEnvironmentController;
import com.facebook.mixin.annotation.Mixin;
import com.facebook.multirow.api.DirtyUnitObserver;
import com.facebook.timeline.TimelineModule;

@Mixin(inModule = TimelineModule.class, package_name = "com.facebook.timeline.environment")
/* compiled from: function() {window.__fbNative = {};window.__fbNative.nativeReady = true; */
public interface TimelineEnvironment extends CanFollowUser, CanLikePage, CanShowVideoInFullScreen, FeedEnvironment, HasContext, HasFeedListType, HasInvalidate, HasMenuButtonProvider, HasPersistentState, HasPositionInformation, HasRowKey, HasScrollListenerSupport, HasEnvironmentController, DirtyUnitObserver, HasProfileFirstName, HasProfileName, HasTimelineContext {
}
