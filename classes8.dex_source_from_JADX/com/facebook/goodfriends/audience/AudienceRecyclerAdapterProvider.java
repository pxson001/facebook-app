package com.facebook.goodfriends.audience;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger;
import com.facebook.goodfriends.data.FriendStateFetcher;
import com.facebook.goodfriends.data.FriendStateMutationHelper;
import com.facebook.goodfriends.data.GoodFriendsSearchEngine;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import java.util.concurrent.Executor;

/* compiled from: fetch_live_conversations_tailload */
public class AudienceRecyclerAdapterProvider extends AbstractAssistedProvider<AudienceRecyclerAdapter> {
    public final AudienceRecyclerAdapter m15051a(boolean z) {
        return new AudienceRecyclerAdapter((AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), (UriIntentMapper) Fb4aUriIntentMapper.a(this), FriendStateFetcher.b(this), new FriendStateMutationHelper(GraphQLQueryExecutor.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), IdBasedProvider.a(this, 4442)), z, GoodFriendsAnalyticsLogger.m15022a((InjectorLike) this), GoodFriendsSearchEngine.b(this));
    }
}
