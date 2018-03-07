package com.facebook.search.suggestions.nullstate;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.FilterInputMode;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.model.CachedSuggestionList;
import com.facebook.search.model.converter.RecentSearchSuggestionGraphQLModelConverter;
import com.facebook.search.module.GraphSearchGatekeepers;
import com.facebook.search.protocol.FetchRecentSearchesGraphQL;
import com.facebook.search.protocol.FetchRecentSearchesGraphQL.FBRecentSearchesQueryString;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: loadInBackground */
public class RecentSearchesLoader {
    private static volatile RecentSearchesLoader f9242f;
    private final Resources f9243a;
    private final GraphQLQueryExecutor f9244b;
    public final RecentSearchSuggestionGraphQLModelConverter f9245c;
    private final QeAccessor f9246d;
    private final GatekeeperStoreImpl f9247e;

    public static com.facebook.search.suggestions.nullstate.RecentSearchesLoader m9604a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9242f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.RecentSearchesLoader.class;
        monitor-enter(r1);
        r0 = f9242f;	 Catch:{ all -> 0x003a }
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
        r0 = m9605b(r0);	 Catch:{ all -> 0x0035 }
        f9242f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9242f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.RecentSearchesLoader.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.RecentSearchesLoader");
    }

    private static RecentSearchesLoader m9605b(InjectorLike injectorLike) {
        return new RecentSearchesLoader(ResourcesMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), RecentSearchSuggestionGraphQLModelConverter.m9608a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RecentSearchesLoader(Resources resources, GraphQLQueryExecutor graphQLQueryExecutor, RecentSearchSuggestionGraphQLModelConverter recentSearchSuggestionGraphQLModelConverter, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f9243a = resources;
        this.f9244b = graphQLQueryExecutor;
        this.f9245c = recentSearchSuggestionGraphQLModelConverter;
        this.f9246d = qeAccessor;
        this.f9247e = gatekeeperStoreImpl;
    }

    public final ListenableFuture<CachedSuggestionList> m9606a(String str, final FilterInputMode filterInputMode, int i, @Nullable CallerContext callerContext, GraphQLCachePolicy graphQLCachePolicy, long j) {
        RequestPriority requestPriority;
        boolean z = filterInputMode != FilterInputMode.VIDEO_SEARCH && this.f9246d.a(ExperimentsForSearchAbTestModule.aL, false);
        GraphQlQueryParamSet j2 = new FBRecentSearchesQueryString().a("count", Integer.valueOf(i)).a("filter", filterInputMode).a("hscroll_recent_enabled", Boolean.valueOf(z)).a("profile_picture_size", Integer.valueOf(this.f9243a.getDimensionPixelSize(z ? 2131431688 : 2131431684))).a("unread_count_enabled", Boolean.valueOf(this.f9247e.a(GraphSearchGatekeepers.f11401a, false))).j();
        FBRecentSearchesQueryString a = FetchRecentSearchesGraphQL.m11801a();
        a.b(true);
        GraphQLQueryExecutor graphQLQueryExecutor = this.f9244b;
        GraphQLRequest a2 = GraphQLRequest.a(a).a(graphQLCachePolicy);
        a2.e = ImmutableSet.of(str);
        a2 = a2.a(j).a(j2);
        if (callerContext != null) {
            requestPriority = RequestPriority.INTERACTIVE;
        } else {
            requestPriority = RequestPriority.NON_INTERACTIVE;
        }
        GraphQLRequest a3 = a2.a(requestPriority);
        a3.f = callerContext;
        return Futures.a(graphQLQueryExecutor.a(a3), new Function<GraphQLResult<FBRecentSearchesQueryModel>, CachedSuggestionList>(this) {
            final /* synthetic */ RecentSearchesLoader f11403b;

            public Object apply(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (!((FBRecentSearchesQueryModel) graphQLResult.e).m11799a()) {
                    return new CachedSuggestionList(RegularImmutableList.a, 0);
                }
                ImmutableList immutableList;
                if (graphQLResult == null || graphQLResult.e == null || ((FBRecentSearchesQueryModel) graphQLResult.e).m11800j() == null) {
                    immutableList = RegularImmutableList.a;
                } else {
                    immutableList = this.f11403b.f9245c.m9611a(((FBRecentSearchesQueryModel) graphQLResult.e).m11800j().m12339a(), filterInputMode);
                }
                return new CachedSuggestionList(immutableList, graphQLResult.clientTimeMs, graphQLResult.freshness);
            }
        });
    }
}
