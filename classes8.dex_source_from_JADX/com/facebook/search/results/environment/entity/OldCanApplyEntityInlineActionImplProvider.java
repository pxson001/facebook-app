package com.facebook.search.results.environment.entity;

import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionClickHandler;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.CanReplaceFeedItem;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.ui.futures.TasksManager;

/* compiled from: SearchResultsGraphQL */
public class OldCanApplyEntityInlineActionImplProvider extends AbstractAssistedProvider<OldCanApplyEntityInlineActionImpl> {
    public final OldCanApplyEntityInlineActionImpl m26246a(CanReplaceFeedItem canReplaceFeedItem, HasInvalidate hasInvalidate, HasSearchResultsContext hasSearchResultsContext, CanProvideRoleForEntity canProvideRoleForEntity, HasContext hasContext) {
        return new OldCanApplyEntityInlineActionImpl(canReplaceFeedItem, hasInvalidate, hasSearchResultsContext, canProvideRoleForEntity, hasContext, SearchResultsLogger.m25460a((InjectorLike) this), TasksManager.b(this), SearchResultsGraphQLNodeFutureFactory.m26249a((InjectorLike) this), FriendingExceptionHandler.b(this), FriendingClient.b(this), PageCallToActionClickHandler.m19681b(this), GraphSearchErrorReporter.a(this), IdBasedSingletonScopeProvider.a(this, 616));
    }
}
