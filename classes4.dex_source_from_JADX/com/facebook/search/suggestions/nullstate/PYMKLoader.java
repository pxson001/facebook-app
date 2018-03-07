package com.facebook.search.suggestions.nullstate;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.search.model.CachedSuggestionList;
import com.facebook.search.model.converter.PYMKEntitySuggestionGraphQLModelConverter;
import com.facebook.search.protocol.FetchTypeaheadPYMKGraphQL;
import com.facebook.search.protocol.FetchTypeaheadPYMKGraphQL.FBTypeaheadPYMKQueryString;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: listener already set */
public class PYMKLoader {
    private static volatile PYMKLoader f9311f;
    private final Resources f9312a;
    private final GraphQLQueryExecutor f9313b;
    private final GraphQLCacheManager f9314c;
    public final PYMKEntitySuggestionGraphQLModelConverter f9315d;
    private final ListeningExecutorService f9316e;

    public static com.facebook.search.suggestions.nullstate.PYMKLoader m9689a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9311f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.PYMKLoader.class;
        monitor-enter(r1);
        r0 = f9311f;	 Catch:{ all -> 0x003a }
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
        r0 = m9690b(r0);	 Catch:{ all -> 0x0035 }
        f9311f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9311f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.PYMKLoader.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.PYMKLoader");
    }

    private static PYMKLoader m9690b(InjectorLike injectorLike) {
        return new PYMKLoader(ResourcesMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), GraphQLCacheManager.a(injectorLike), PYMKEntitySuggestionGraphQLModelConverter.m9693a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PYMKLoader(Resources resources, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLCacheManager graphQLCacheManager, PYMKEntitySuggestionGraphQLModelConverter pYMKEntitySuggestionGraphQLModelConverter, ListeningExecutorService listeningExecutorService) {
        this.f9312a = resources;
        this.f9313b = graphQLQueryExecutor;
        this.f9314c = graphQLCacheManager;
        this.f9315d = pYMKEntitySuggestionGraphQLModelConverter;
        this.f9316e = listeningExecutorService;
    }

    public final ListenableFuture<CachedSuggestionList> m9691a(@Nullable CallerContext callerContext, GraphQLCachePolicy graphQLCachePolicy) {
        FetchTypeaheadPYMKGraphQL fetchTypeaheadPYMKGraphQL = new FetchTypeaheadPYMKGraphQL();
        GraphQlQueryString fBTypeaheadPYMKQueryString = new FBTypeaheadPYMKQueryString();
        fBTypeaheadPYMKQueryString.a("count", Integer.valueOf(15)).a("profile_picture_size", Integer.valueOf(this.f9312a.getDimensionPixelSize(2131431684))).a(true);
        GraphQLQueryExecutor graphQLQueryExecutor = this.f9313b;
        GraphQLRequest a = GraphQLRequest.a(fBTypeaheadPYMKQueryString).a(graphQLCachePolicy);
        a.e = ImmutableSet.of("pymk_search_cache_tag");
        a = a;
        a.b = true;
        a = a.a(RequestPriority.INTERACTIVE);
        a.f = callerContext;
        return Futures.a(graphQLQueryExecutor.a(a.a(3600)), new 1(this), this.f9316e);
    }
}
