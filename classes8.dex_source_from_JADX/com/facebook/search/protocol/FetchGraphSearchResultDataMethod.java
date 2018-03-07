package com.facebook.search.protocol;

import com.facebook.graphql.model.GraphQLGraphSearchQuery;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQL.FBGraphSearchQueryString;
import com.facebook.search.util.toast.SearchResultsSizeUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: next_video */
public class FetchGraphSearchResultDataMethod extends AbstractPersistedGraphQlApiMethod<FetchGraphSearchResultDataParams, GraphQLGraphSearchQuery> {
    private static volatile FetchGraphSearchResultDataMethod f7932f;
    private final GraphQLImageHelper f7933c;
    private final SearchResultsSizeUtil f7934d;
    private final QeAccessor f7935e;

    public static com.facebook.search.protocol.FetchGraphSearchResultDataMethod m8502a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7932f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.protocol.FetchGraphSearchResultDataMethod.class;
        monitor-enter(r1);
        r0 = f7932f;	 Catch:{ all -> 0x003a }
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
        r0 = m8503b(r0);	 Catch:{ all -> 0x0035 }
        f7932f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7932f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.protocol.FetchGraphSearchResultDataMethod.a(com.facebook.inject.InjectorLike):com.facebook.search.protocol.FetchGraphSearchResultDataMethod");
    }

    private static FetchGraphSearchResultDataMethod m8503b(InjectorLike injectorLike) {
        return new FetchGraphSearchResultDataMethod(GraphQLProtocolHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SearchResultsSizeUtil.m10684a(injectorLike));
    }

    public final GraphQlQueryString m8506f(Object obj) {
        FetchGraphSearchResultDataParams fetchGraphSearchResultDataParams = (FetchGraphSearchResultDataParams) obj;
        GraphQlQueryString fBGraphSearchQueryString = new FBGraphSearchQueryString();
        fBGraphSearchQueryString.a("query", fetchGraphSearchResultDataParams.f7940a).a("count", String.valueOf(fetchGraphSearchResultDataParams.f7941b)).a("profile_image_size", String.valueOf(this.f7934d.m10687b())).a("image_size", this.f7933c.f()).a("media_type", this.f7933c.a()).a("facepile_image_size", Integer.valueOf(this.f7934d.f8963e)).a("facepile_count", Integer.valueOf(9)).a("page_cta_enabled", Boolean.valueOf(this.f7935e.a(ExperimentsForSearchAbTestModule.bA, false))).a("tsid", fetchGraphSearchResultDataParams.f7943d);
        if (!Strings.isNullOrEmpty(fetchGraphSearchResultDataParams.f7942c)) {
            fBGraphSearchQueryString.a("after", fetchGraphSearchResultDataParams.f7942c);
        }
        return fBGraphSearchQueryString;
    }

    @Inject
    public FetchGraphSearchResultDataMethod(GraphQLProtocolHelper graphQLProtocolHelper, GraphQLImageHelper graphQLImageHelper, QeAccessor qeAccessor, SearchResultsSizeUtil searchResultsSizeUtil) {
        super(graphQLProtocolHelper);
        this.f7933c = graphQLImageHelper;
        this.f7935e = qeAccessor;
        this.f7934d = searchResultsSizeUtil;
    }

    public final int m8505b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    public final Object m8504a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return (GraphQLGraphSearchQuery) this.b.a(jsonParser, GraphQLGraphSearchQuery.class, "graphQLGraphSearchQuery");
    }
}
