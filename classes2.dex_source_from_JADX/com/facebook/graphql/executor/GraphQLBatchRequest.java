package com.facebook.graphql.executor;

import com.facebook.graphql.executor.GraphQLResponseParser.GraphQLBatchResultCallback;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import rx.Observable;
import rx.subjects.ReplaySubject;

/* compiled from: rtc_conferencing_peer_to_peer_debug */
public class GraphQLBatchRequest {
    protected final Map<String, GraphQLRequest<?>> f6470a = Maps.m838c();
    public final List<GraphQLRequest> f6471b = Lists.m1296a();
    public final String f6472c;
    public final Set<GraphQLRequest> f6473d = Sets.m1313a();
    public GraphQLBatchResultCallback f6474e;
    private final ReplaySubject<Object> f6475f = ReplaySubject.m11235d();
    public boolean f6476g;
    public boolean f6477h = false;
    public boolean f6478i = false;
    public EndpointScheduler f6479j = EndpointScheduler.UNSPECIFIED;
    public final Map<GraphQLRequest, ReplaySubject> f6480k = Maps.m838c();
    private HashMultimap<GraphQLRequest, GraphQLRequest> f6481l = HashMultimap.m10690u();

    /* compiled from: rtc_conferencing_peer_to_peer_debug */
    public enum EndpointScheduler {
        UNSPECIFIED("unspecified"),
        BASIC("basic"),
        PHASED("phased"),
        PROFILING("profiling");
        
        public String schedulerName;

        private EndpointScheduler(String str) {
            this.schedulerName = str;
        }
    }

    @Inject
    public GraphQLBatchRequest(@Assisted String str) {
        this.f6472c = str;
    }

    public final boolean m11222a() {
        return this.f6476g;
    }

    public final EndpointScheduler m11223b() {
        return this.f6479j;
    }

    public final <T> RequestObservable<GraphQLResult<T>> m11217a(GraphQLRequest<T> graphQLRequest) {
        m11214f(graphQLRequest);
        Observable d = ReplaySubject.m11235d();
        this.f6480k.put(graphQLRequest, d);
        return new RequestObservable(d);
    }

    public final <T> ListenableFuture<GraphQLResult<T>> m11224b(GraphQLRequest<T> graphQLRequest) {
        if (graphQLRequest.m11612j()) {
            throw new IllegalArgumentException("Cannot add a request with an 'EACH' fan out style using futures. Use GraphQLRequest.addRequestObserve instead.");
        }
        RequestObservable a = m11217a((GraphQLRequest) graphQLRequest);
        ListenableFuture f = SettableFuture.m1547f();
        a.m11649a(new 1(this, f));
        return f;
    }

    final ImmutableSet<String> m11225c() {
        Builder builder = ImmutableSet.builder();
        for (String str : this.f6470a.keySet()) {
            if (!this.f6473d.contains((GraphQLRequest) this.f6470a.get(str))) {
                builder.m4813c(str);
            }
        }
        return builder.m4812b();
    }

    private <T> void m11214f(GraphQLRequest<T> graphQLRequest) {
        if (this.f6471b.contains(graphQLRequest)) {
            throw new IllegalArgumentException("Can't add two of the same request to a batch request.");
        } else if (graphQLRequest.f7083a.f7117i) {
            int i = 1;
            String a = graphQLRequest.m11600a();
            while (this.f6470a.containsKey(graphQLRequest.m11600a())) {
                i++;
                graphQLRequest.f7092j = a + "_" + i;
            }
            this.f6470a.put(graphQLRequest.m11600a(), graphQLRequest);
            this.f6471b.add(graphQLRequest);
            m11215g(graphQLRequest);
        } else {
            throw new IllegalArgumentException("Batch request is a network level optimization, it doesnot make sense to have a request to have a no network cache policy.");
        }
    }

    private <T> void m11215g(GraphQLRequest<T> graphQLRequest) {
        String str = null;
        if (graphQLRequest.f7096o == null) {
            throw new IllegalArgumentException("Got request with no query.");
        }
        for (Entry entry : graphQLRequest.m11607d().m11381b().entrySet()) {
            String str2 = (String) entry.getKey();
            GraphQLRefParam graphQLRefParam = (GraphQLRefParam) entry.getValue();
            GraphQLRequest graphQLRequest2 = graphQLRefParam.a;
            if (!this.f6470a.containsKey(graphQLRequest2.m11600a())) {
                throw new IllegalArgumentException("Dependent request '" + graphQLRequest2.m11600a() + "' is not in this batch.");
            } else if (this.f6470a.get(graphQLRefParam.a.m11600a()) != graphQLRequest2) {
                throw new IllegalArgumentException("Depends on a request with the same name " + graphQLRequest2.m11600a() + " but is not in batch ");
            } else if (graphQLRequest2.m11612j()) {
                throw new IllegalArgumentException("Depending on a query with an 'each' fan out style is not supported.");
            } else if (graphQLRequest.m11600a().equals(graphQLRefParam.a.m11600a())) {
                throw new IllegalArgumentException("A query cannot depend on itself.");
            } else {
                if (graphQLRefParam.c != BatchQueryFanOutStyle.EACH) {
                    str2 = str;
                } else if (str != null) {
                    throw new IllegalArgumentException("You can only have one ref param using the 'each' fan out style. " + str2 + " and " + str + " both use 'each' fan out style.");
                }
                this.f6481l.mo431a((Object) graphQLRequest, (Object) graphQLRequest2);
                this.f6481l.mo431a((Object) graphQLRequest2, (Object) graphQLRequest);
                str = str2;
            }
        }
    }

    final void m11221a(Throwable th) {
        for (Entry value : this.f6480k.entrySet()) {
            ((ReplaySubject) value.getValue()).mo1599a(th);
        }
    }

    @Nonnull
    public final GraphQLBatchResultCallback m11226d() {
        return (GraphQLBatchResultCallback) Preconditions.checkNotNull(this.f6474e);
    }

    final void m11220a(GraphQLBatchResultCallback graphQLBatchResultCallback) {
        this.f6474e = graphQLBatchResultCallback;
    }

    final void m11218a(GraphQLRequest graphQLRequest, GraphQLResult graphQLResult) {
        m11216h(graphQLRequest).mo1598a((Object) graphQLResult);
    }

    final void m11219a(GraphQLRequest graphQLRequest, Exception exception) {
        m11216h(graphQLRequest).mo1599a((Throwable) exception);
    }

    @Nonnull
    private ReplaySubject m11216h(GraphQLRequest graphQLRequest) {
        ReplaySubject replaySubject = (ReplaySubject) this.f6480k.get(graphQLRequest);
        if (replaySubject == null) {
            return this.f6475f;
        }
        return replaySubject;
    }

    public final boolean m11227d(GraphQLRequest graphQLRequest) {
        return this.f6473d.contains(graphQLRequest);
    }

    final LinkedHashSet<GraphQLRequest> m11228e(GraphQLRequest graphQLRequest) {
        LinkedHashSet<GraphQLRequest> c = Sets.m1327c();
        c.add(graphQLRequest);
        Stack stack = new Stack();
        stack.add(graphQLRequest);
        while (!stack.isEmpty()) {
            Set<GraphQLRequest> a = this.f6481l.mo1474a((GraphQLRequest) stack.pop());
            if (!(a == null || a.isEmpty())) {
                for (GraphQLRequest graphQLRequest2 : a) {
                    if (!c.contains(graphQLRequest2)) {
                        c.add(graphQLRequest2);
                        stack.push(graphQLRequest2);
                    }
                }
            }
        }
        return c;
    }

    final void m11229f() {
        for (ReplaySubject N_ : this.f6480k.values()) {
            N_.N_();
        }
    }

    public final String m11230g() {
        return this.f6472c;
    }

    public final boolean m11231i() {
        return this.f6477h;
    }

    public final boolean m11232j() {
        return this.f6478i;
    }
}
