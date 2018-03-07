package com.facebook.graphql.executor;

import android.text.TextUtils;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: platform_reply_iv_crypto_key */
public class GraphQLSubscriptionHolder {
    final ConcurrentMap<String, GraphQLSubscription> f9588a = Maps.m843e();
    public final GraphQLQueryExecutor f9589b;
    public final GraphQLQuerySubscriber f9590c;
    public final Executor f9591d;
    private final GraphQLQueryScheduler f9592e;
    private final KeyFactory f9593f;

    public static GraphQLSubscriptionHolder m14626b(InjectorLike injectorLike) {
        return new GraphQLSubscriptionHolder(GraphQLQueryExecutor.m10435a(injectorLike), GraphQLQuerySubscriber.m10365a(injectorLike), GraphQLQueryScheduler.m10388a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), KeyFactory.m10333b(injectorLike));
    }

    public static GraphQLSubscriptionHolder m14624a(InjectorLike injectorLike) {
        return m14626b(injectorLike);
    }

    @Inject
    public GraphQLSubscriptionHolder(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLQuerySubscriber graphQLQuerySubscriber, GraphQLQueryScheduler graphQLQueryScheduler, Executor executor, KeyFactory keyFactory) {
        this.f9590c = graphQLQuerySubscriber;
        this.f9589b = graphQLQueryExecutor;
        this.f9591d = executor;
        this.f9592e = graphQLQueryScheduler;
        this.f9593f = keyFactory;
        this.f9590c.m10369a(this);
    }

    public final <T> void m14632a(FutureCallback<GraphQLResult<T>> futureCallback, String str, GraphQLResult<T> graphQLResult) {
        if (graphQLResult.f6199a == null) {
            GraphQLRequestLock a = this.f9592e.m10394a(false);
            a.f14132f.mo2714a(graphQLResult.m10402f());
            Builder a2 = Builder.m21595a((GraphQLResult) graphQLResult);
            a2.f15062d = a;
            graphQLResult = a2.m21600a();
        }
        m14625a(new Preset(futureCallback, this.f9591d, str, graphQLResult));
    }

    public final <T extends GraphQLVisitableModel> GraphQLResult<T> m14627a(T t, DataFreshnessResult dataFreshnessResult, long j, ImmutableSet<String> immutableSet) {
        GraphQLRequestLock a = this.f9592e.m10394a(false);
        a.f14132f.mo2714a((Set) immutableSet);
        return new GraphQLResult(t, dataFreshnessResult, j, immutableSet, a, null);
    }

    private void m14625a(GraphQLSubscription graphQLSubscription) {
        this.f9588a.put(graphQLSubscription.f19202d, graphQLSubscription);
    }

    public final boolean m14634a(String str) {
        return this.f9588a.containsKey(str);
    }

    public final void m14636b(String str) {
        this.f9588a.remove(str);
    }

    public final void m14629a() {
        this.f9590c.m10370b(this);
        this.f9588a.clear();
    }

    public final void m14635b() {
        this.f9588a.clear();
    }

    public final void m14633a(Set<String> set) {
        this.f9588a.keySet().retainAll(set);
    }

    public final int m14637c() {
        return this.f9588a.size();
    }

    public final void m14638d() {
        for (GraphQLSubscription e : this.f9588a.values()) {
            e.m26916e();
        }
    }

    public final void m14639e() {
        for (GraphQLSubscription d : this.f9588a.values()) {
            d.m26915d();
        }
    }

    public final void m14630a(int i, Set<String> set) {
        for (GraphQLSubscription graphQLSubscription : this.f9588a.values()) {
            Set<String> set2 = set.size() < graphQLSubscription.f19201c.size() ? set : graphQLSubscription.f19201c;
            Set set3 = set2 == graphQLSubscription.f19201c ? set : graphQLSubscription.f19201c;
            for (String contains : set2) {
                if (set3.contains(contains)) {
                    graphQLSubscription.m26912a(i);
                    break;
                }
            }
        }
    }

    public final <T> ListenableFuture<GraphQLResult<T>> m14628a(GraphQLRequest<T> graphQLRequest, FutureCallback<GraphQLResult<T>> futureCallback, String str) {
        Preconditions.checkState(graphQLRequest.f7083a.f7116h, "fetchAndSubscribe() requires disk caching to work");
        GraphQLSubscription graphQLSubscription = new GraphQLSubscription(this.f9589b, futureCallback, this.f9591d, str, graphQLRequest, this.f9593f);
        graphQLSubscription.m26916e();
        graphQLRequest.f7093k = graphQLSubscription;
        graphQLRequest.f7084b = true;
        m14625a(graphQLSubscription);
        return this.f9589b.m10446a((GraphQLRequest) graphQLRequest);
    }

    final void m14631a(ImmutableList.Builder<String> builder) {
        for (GraphQLSubscription graphQLSubscription : this.f9588a.values()) {
            String a;
            if (graphQLSubscription.f19205g != null) {
                a = graphQLSubscription.f19205g.m11601a(graphQLSubscription.f19206h);
            } else {
                a = null;
            }
            String str = a;
            if (!TextUtils.isEmpty(str)) {
                builder.m1069c(str);
            }
        }
    }

    public void finalize() {
        m14629a();
    }
}
