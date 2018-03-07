package com.facebook.pages.identity.batching;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.story.GraphQLStoryHelper;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: privacy_review_cancel */
public class PageCardsBatchingFetcherProvider extends AbstractAssistedProvider<PageCardsBatchingFetcher> {
    public final PageCardsBatchingFetcher m4240a(Context context, LayoutInflater layoutInflater, Long l, Map<PageCardType, PageViewPlaceHolder> map) {
        return new PageCardsBatchingFetcher(context, layoutInflater, l, map, GraphQLQueryExecutor.a(this), FbAndroidBatchedCardsProvider.m4234a(this), GraphQLStoryHelper.a(this), SizeAwareImageUtil.a(this), GraphQLImageHelper.a(this), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), PagesAnalytics.a(this), (PageCardsRenderSchedulerProvider) getOnDemandAssistedProviderForStaticDi(PageCardsRenderSchedulerProvider.class), (Clock) SystemClockMethodAutoProvider.a(this));
    }
}
