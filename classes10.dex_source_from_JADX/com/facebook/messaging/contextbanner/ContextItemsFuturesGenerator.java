package com.facebook.messaging.contextbanner;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contextbanner.GQLPageContextHelper.C03661;
import com.facebook.messaging.contextbanner.graphql.PageContextQuery.PageContextQueryString;
import com.facebook.messaging.contextbanner.model.ContextItems;
import com.facebook.messaging.contextbanner.model.GroupContextItems;
import com.facebook.messaging.contextbanner.model.GroupContextItemsProvider;
import com.facebook.messaging.contextbanner.model.PageContextItemsProvider;
import com.facebook.messaging.contextbanner.model.TincanContextItems;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: supports_implicit_sdk_logging */
public class ContextItemsFuturesGenerator {
    private final GQLPageContextHelper f2177a;
    private final GQLProfileContextHelper f2178b;
    private final GroupContextItemsProvider f2179c;
    private final TincanContextItems f2180d;

    public static ContextItemsFuturesGenerator m2006b(InjectorLike injectorLike) {
        return new ContextItemsFuturesGenerator(new GQLPageContextHelper((PageContextItemsProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PageContextItemsProvider.class), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike)), new GQLProfileContextHelper(GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), new ProfileContextItemsParser(IdBasedSingletonScopeProvider.b(injectorLike, 494))), (GroupContextItemsProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupContextItemsProvider.class), new TincanContextItems(ResourcesMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public ContextItemsFuturesGenerator(GQLPageContextHelper gQLPageContextHelper, GQLProfileContextHelper gQLProfileContextHelper, GroupContextItemsProvider groupContextItemsProvider, TincanContextItems tincanContextItems) {
        this.f2177a = gQLPageContextHelper;
        this.f2178b = gQLProfileContextHelper;
        this.f2179c = groupContextItemsProvider;
        this.f2180d = tincanContextItems;
    }

    public final ListenableFuture<ContextItems> m2007a(User user, ThreadKey threadKey, @Nullable ThreadSummary threadSummary) {
        if (ThreadKey.g(threadKey)) {
            this.f2180d.f2229b = user.h();
            return Futures.a(this.f2180d);
        } else if (!user.T()) {
            return this.f2178b.m2014a(user.a);
        } else {
            GQLPageContextHelper gQLPageContextHelper = this.f2177a;
            String str = user.a;
            GraphQlQueryString pageContextQueryString = new PageContextQueryString();
            pageContextQueryString.a("page_id", str);
            GraphQLRequest a = GraphQLRequest.a(pageContextQueryString).a(GraphQLCachePolicy.a).a(86400);
            a.f = CallerContext.a(gQLPageContextHelper.getClass());
            return Futures.a(gQLPageContextHelper.f2192b.a(a), new C03661(gQLPageContextHelper, threadSummary), gQLPageContextHelper.f2191a);
        }
    }

    public final ListenableFuture<ContextItems> m2008a(String str, ThreadSummary threadSummary, int i) {
        Preconditions.checkNotNull(threadSummary);
        return Futures.a(new GroupContextItems(str, Integer.valueOf(i), Integer.valueOf(threadSummary.h.size()), ResourcesMethodAutoProvider.a(this.f2179c)));
    }
}
