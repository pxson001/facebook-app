package com.facebook.timeline.datafetcher;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLCacheKeySerializer;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cache.GraphQLRequestDiskCache;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultBigProfilePictureFieldsModel;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.cache.db.TimelineDbCache;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQL;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQL.TimelineProfilePictureUriQueryString;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQL.ViewerTopFriendsQueryString;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.ViewerTopFriendsQueryModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderParams;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: greeting_share_completed */
public class TimelineHeaderRequestFactory {
    private static volatile TimelineHeaderRequestFactory f10552h;
    private final Provider<String> f10553a;
    private final TimelineHeaderQueryBuilder f10554b;
    private final Provider<TimelineHeaderCacheKeySerializer> f10555c;
    private final Provider<TimelineDbCache> f10556d;
    private final QeAccessor f10557e;
    private final ImmutableSet<String> f10558f = ImmutableSet.of("timeline_fetch_header");
    private final ImmutableSet<String> f10559g = ImmutableSet.of("timeline_fetch_header", "self_profile");

    public static com.facebook.timeline.datafetcher.TimelineHeaderRequestFactory m10637a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10552h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.TimelineHeaderRequestFactory.class;
        monitor-enter(r1);
        r0 = f10552h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10639b(r0);	 Catch:{ all -> 0x0035 }
        f10552h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10552h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.TimelineHeaderRequestFactory.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.TimelineHeaderRequestFactory");
    }

    private static TimelineHeaderRequestFactory m10639b(InjectorLike injectorLike) {
        return new TimelineHeaderRequestFactory(IdBasedProvider.a(injectorLike, 4442), TimelineHeaderQueryBuilder.m10629a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 11178), IdBasedSingletonScopeProvider.a(injectorLike, 11157), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final GraphQLRequest<?> m10642a(FetchTimelineHeaderParams fetchTimelineHeaderParams, GraphQLCachePolicy graphQLCachePolicy, @Nullable CallerContext callerContext, RequestPriority requestPriority) {
        Set set;
        boolean equals = String.valueOf(fetchTimelineHeaderParams.a).equals(this.f10553a.get());
        GraphQlQueryString a = this.f10554b.m10636a(fetchTimelineHeaderParams);
        GraphQLRequest a2 = GraphQLRequest.a(a).a(FetchTimelineHeaderParams.c() / 1000);
        if (equals) {
            set = this.f10559g;
        } else {
            set = this.f10558f;
        }
        a2.e = set;
        GraphQLRequest a3 = a2.a((GraphQLCacheKeySerializer) this.f10555c.get());
        a3.f = callerContext;
        GraphQLRequest<?> a4 = a3.a(requestPriority).a(graphQLCachePolicy);
        a4.t = (GraphQLRequestDiskCache) this.f10556d.get();
        a3 = a4;
        m10638a(a3, a);
        return a3;
    }

    @Inject
    public TimelineHeaderRequestFactory(Provider<String> provider, TimelineHeaderQueryBuilder timelineHeaderQueryBuilder, Provider<TimelineHeaderCacheKeySerializer> provider2, Provider<TimelineDbCache> provider3, QeAccessor qeAccessor) {
        this.f10553a = provider;
        this.f10554b = timelineHeaderQueryBuilder;
        this.f10555c = provider2;
        this.f10556d = provider3;
        this.f10557e = qeAccessor;
    }

    public final GraphQLRequest<DefaultBigProfilePictureFieldsModel> m10641a(FetchTimelineHeaderParams fetchTimelineHeaderParams, @Nullable CallerContext callerContext) {
        GraphQlQueryString graphQlQueryString = (TimelineProfilePictureUriQueryString) FetchTimelineHeaderGraphQL.b().a("profile_id", String.valueOf(fetchTimelineHeaderParams.a));
        GraphQLRequest a = GraphQLRequest.a(graphQlQueryString);
        a.e = ImmutableSet.of("timeline_fetch_header");
        a = a;
        a.f = callerContext;
        a = a.a(RequestPriority.INTERACTIVE).a(GraphQLCachePolicy.c);
        m10638a(a, graphQlQueryString);
        return a;
    }

    private void m10638a(GraphQLRequest graphQLRequest, GraphQlQueryString graphQlQueryString) {
        if (this.f10557e.a(ExperimentsForTimelineAbTestModule.ao, false)) {
            graphQLRequest.q = null;
        }
    }

    public final GraphQLRequest<ViewerTopFriendsQueryModel> m10640a(@Nullable CallerContext callerContext) {
        GraphQlQueryString graphQlQueryString = (ViewerTopFriendsQueryString) new ViewerTopFriendsQueryString().a("num_top_friends", Integer.valueOf(10));
        GraphQLRequest a = GraphQLRequest.a(graphQlQueryString);
        a.e = ImmutableSet.of("timeline_fetch_header");
        a = a;
        a.f = callerContext;
        a = a.a(RequestPriority.INTERACTIVE).a(GraphQLCachePolicy.a).a(259200);
        m10638a(a, graphQlQueryString);
        return a;
    }
}
