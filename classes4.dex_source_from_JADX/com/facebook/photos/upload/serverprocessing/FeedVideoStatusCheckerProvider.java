package com.facebook.photos.upload.serverprocessing;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.photos.upload.serverprocessing.FeedVideoStatusChecker.Listener;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;

/* compiled from: nocontent_good_friends_feed_unit */
public class FeedVideoStatusCheckerProvider extends AbstractAssistedProvider<FeedVideoStatusChecker> {
    public final FeedVideoStatusChecker m7371a(String str, boolean z, ImmutableList<String> immutableList, Listener listener) {
        return new FeedVideoStatusChecker(GraphQLQueryExecutor.a(this), TasksManager.b(this), IdBasedLazy.a(this, 1468), (VideoStatusCheckerProvider) getOnDemandAssistedProviderForStaticDi(VideoStatusCheckerProvider.class), str, z, immutableList, listener);
    }
}
