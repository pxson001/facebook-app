package com.facebook.search.results.environment.entity;

import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.CanReplaceSearchResult;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.ui.futures.TasksManager;

/* compiled from: Selected ID is not in list! */
public class CanApplyEntityInlineActionImplProvider extends AbstractAssistedProvider<CanApplyEntityInlineActionImpl> {
    public final CanApplyEntityInlineActionImpl m26227a(CanReplaceSearchResult canReplaceSearchResult, HasInvalidate hasInvalidate, HasSearchResultsContext hasSearchResultsContext, HasContext hasContext) {
        return new CanApplyEntityInlineActionImpl(canReplaceSearchResult, hasInvalidate, hasSearchResultsContext, hasContext, SearchResultsLogger.m25460a((InjectorLike) this), TasksManager.b(this), SearchResultsGraphQLNodeFutureFactory.m26249a((InjectorLike) this), FriendingExceptionHandler.b(this), FriendingClient.b(this), GraphSearchErrorReporter.a(this), IdBasedSingletonScopeProvider.a(this, 616));
    }
}
