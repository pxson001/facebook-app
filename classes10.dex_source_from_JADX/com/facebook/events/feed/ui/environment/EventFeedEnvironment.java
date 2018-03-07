package com.facebook.events.feed.ui.environment;

import com.facebook.events.feed.ui.EventFeedUiModule;
import com.facebook.feed.environment.CanPinAndUnpinPosts;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.mixin.annotation.Mixin;
import com.facebook.multirow.api.DirtyUnitObserver;

@Mixin(inModule = EventFeedUiModule.class, package_name = "com.facebook.events.feed.ui.environment")
public interface EventFeedEnvironment extends CanPinAndUnpinPosts, FeedEnvironment, DirtyUnitObserver {
}
