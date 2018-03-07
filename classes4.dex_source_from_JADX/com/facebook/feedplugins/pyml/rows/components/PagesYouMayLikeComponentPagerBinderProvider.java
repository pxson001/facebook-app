package com.facebook.feedplugins.pyml.rows.components;

import android.content.Context;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.pyml.fetcher.PaginatedPYMLWithLargeImageFeedUnitFetcher;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;

/* compiled from: old */
public class PagesYouMayLikeComponentPagerBinderProvider extends AbstractAssistedProvider<PagesYouMayLikeComponentPagerBinder> {
    public final <E extends HasContext & HasFeedListType & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> PagesYouMayLikeComponentPagerBinder<E> m6735a(Context context, int i, float f, FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit> feedUnitAndChangePageListener, E e, boolean z) {
        return new PagesYouMayLikeComponentPagerBinder(context, i, f, feedUnitAndChangePageListener, (HasContext) e, z, IdBasedProvider.a(this, 3561), IdBasedProvider.a(this, 680), FeedRenderUtils.a(this), PaginatedPYMLWithLargeImageFeedUnitFetcher.m6678a(this), PageYouMayLikeComponent.a(this), FeedLoggingViewportEventListener.a(this));
    }
}
