package com.facebook.search.results.environment;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.mixin.annotation.Mixin;
import com.facebook.search.results.environment.entity.CanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.CanLogEntityNavigation;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.video.player.environment.HasFeedMenuHelper;

@Mixin(inModule = SearchResultsEnvironmentModule.class, package_name = "com.facebook.search.results.environment")
/* compiled from: Show all segues including parameterized segues. */
public interface SearchResultsEnvironment extends FeedEnvironment, CanReplaceSearchResult, HasSearchResultPosition, HasSearchResultsContext, CanApplyEntityInlineAction, CanLogEntityNavigation, HasSearchResultsVideoStoryPersistentState, HasFeedMenuHelper {
}
