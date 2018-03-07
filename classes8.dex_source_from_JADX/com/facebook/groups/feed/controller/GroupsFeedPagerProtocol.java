package com.facebook.groups.feed.controller;

import com.facebook.api.feed.FeedFetchContext;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.util.Tuple;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.logging.viewport.GroupMallVpvs;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.groups.abtest.GroupsExperimentalFeatures;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: fail_url_not_rewritten */
public class GroupsFeedPagerProtocol {
    public static final OperationToFeedStories f13947a = new OperationToFeedStories();
    public final DefaultBlueServiceOperationFactory f13948b;
    public final Executor f13949c;
    public final GroupMallVpvs f13950d;
    public final GroupsExperimentalFeatures f13951e;
    public int f13952f;
    public int f13953g;
    public FeedType f13954h;
    public FeedFetchContext f13955i;

    /* compiled from: fail_url_not_rewritten */
    class OperationToFeedStories implements Function<OperationResult, Tuple<GraphQLFeedHomeStories, DataFreshnessResult>> {
        public Object apply(Object obj) {
            FetchFeedResult fetchFeedResult = (FetchFeedResult) ((OperationResult) obj).k();
            Preconditions.checkNotNull(fetchFeedResult);
            return new Tuple(fetchFeedResult.b, fetchFeedResult.freshness);
        }
    }

    public static GroupsFeedPagerProtocol m15576b(InjectorLike injectorLike) {
        return new GroupsFeedPagerProtocol(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GroupMallVpvs.a(injectorLike), GroupsExperimentalFeatures.b(injectorLike));
    }

    public static GroupsFeedPagerProtocol m15575a(InjectorLike injectorLike) {
        return m15576b(injectorLike);
    }

    @Inject
    public GroupsFeedPagerProtocol(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService, GroupMallVpvs groupMallVpvs, GroupsExperimentalFeatures groupsExperimentalFeatures) {
        this.f13948b = defaultBlueServiceOperationFactory;
        this.f13949c = executorService;
        this.f13950d = groupMallVpvs;
        this.f13951e = groupsExperimentalFeatures;
    }

    public final void m15577a(FeedType feedType, int i, int i2) {
        this.f13954h = feedType;
        this.f13952f = i;
        this.f13953g = i2;
        this.f13955i = new FeedFetchContext(((GroupsFeedTypeValueParams) feedType.f).a, null);
    }
}
