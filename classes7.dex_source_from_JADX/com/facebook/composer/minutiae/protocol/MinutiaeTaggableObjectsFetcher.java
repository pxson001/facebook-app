package com.facebook.composer.minutiae.protocol;

import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQL;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQL.FetchTaggableObjectsQueryString;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchTaggableObjectsQueryModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: time_since_story */
public class MinutiaeTaggableObjectsFetcher {
    public static final String f1691a = "60";
    public static final String f1692b = "32";
    private static volatile MinutiaeTaggableObjectsFetcher f1693d;
    private final GraphQLQueryExecutor f1694c;

    public static com.facebook.composer.minutiae.protocol.MinutiaeTaggableObjectsFetcher m1686a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1693d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.minutiae.protocol.MinutiaeTaggableObjectsFetcher.class;
        monitor-enter(r1);
        r0 = f1693d;	 Catch:{ all -> 0x003a }
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
        r0 = m1688b(r0);	 Catch:{ all -> 0x0035 }
        f1693d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1693d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.protocol.MinutiaeTaggableObjectsFetcher.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.protocol.MinutiaeTaggableObjectsFetcher");
    }

    private static MinutiaeTaggableObjectsFetcher m1688b(InjectorLike injectorLike) {
        return new MinutiaeTaggableObjectsFetcher(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public MinutiaeTaggableObjectsFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f1694c = graphQLQueryExecutor;
    }

    public final ListenableFuture<GraphQLResult<FetchTaggableObjectsQueryModel>> m1690a(FetchMinutiaeTaggableObjectsParams fetchMinutiaeTaggableObjectsParams) {
        return this.f1694c.a(m1689c(fetchMinutiaeTaggableObjectsParams));
    }

    public final void m1691b(FetchMinutiaeTaggableObjectsParams fetchMinutiaeTaggableObjectsParams) {
        this.f1694c.a(m1687a(fetchMinutiaeTaggableObjectsParams, GraphQLCachePolicy.d));
    }

    private GraphQLRequest<FetchTaggableObjectsQueryModel> m1687a(FetchMinutiaeTaggableObjectsParams fetchMinutiaeTaggableObjectsParams, GraphQLCachePolicy graphQLCachePolicy) {
        String str;
        boolean z;
        long j = fetchMinutiaeTaggableObjectsParams.f1640e ? 1209600 : 900;
        FetchTaggableObjectsQueryString a = FetchTaggableObjectGraphQL.a();
        Enum a2 = GraphQlQueryDefaults.a();
        if (a2 == null) {
            a2 = GraphQlQueryDefaults.a;
        }
        FetchTaggableObjectsQueryString a3 = FetchTaggableObjectGraphQL.a();
        GraphQlQueryString a4 = a3.a("taggable_activity_id", fetchMinutiaeTaggableObjectsParams.f1636a).a("taggable_object_count", String.valueOf(fetchMinutiaeTaggableObjectsParams.f1639d)).a("taggable_object_image_scale", a2).a("taggable_object_pp_size", f1691a).a("image_scale", a2).a("request_id", fetchMinutiaeTaggableObjectsParams.f1642g).a("typeahead_session_id", String.valueOf(fetchMinutiaeTaggableObjectsParams.f1641f)).a("place_id", String.valueOf(fetchMinutiaeTaggableObjectsParams.f1644i)).a("surface", fetchMinutiaeTaggableObjectsParams.f1645j).a("is_prefetch", Boolean.valueOf(fetchMinutiaeTaggableObjectsParams.f1646k)).a("minutiae_image_size_large", f1692b).a("get_background_color", Boolean.valueOf(fetchMinutiaeTaggableObjectsParams.f1645j.equals("now")));
        String str2 = "taggable_object_query_string";
        if (fetchMinutiaeTaggableObjectsParams.f1637b != null) {
            str = fetchMinutiaeTaggableObjectsParams.f1637b;
        } else {
            str = "";
        }
        a4 = a4.a(str2, str);
        str2 = "dont_load_templates";
        if (fetchMinutiaeTaggableObjectsParams.f1643h) {
            z = false;
        } else {
            z = true;
        }
        a4.a(str2, String.valueOf(z));
        if (fetchMinutiaeTaggableObjectsParams.f1647l != null) {
            a3.a("userLatitude", Double.valueOf(fetchMinutiaeTaggableObjectsParams.f1647l.getLatitude())).a("userLongitude", Double.valueOf(fetchMinutiaeTaggableObjectsParams.f1647l.getLongitude()));
        }
        if (fetchMinutiaeTaggableObjectsParams.f1638c != null) {
            a3.a("taggable_object_cursor", fetchMinutiaeTaggableObjectsParams.f1638c);
        }
        GraphQlQueryParamSet graphQlQueryParamSet = a3.a;
        return GraphQLRequest.a(a).a(graphQlQueryParamSet).a(graphQLCachePolicy).a(j).a(new MinutiaeTypeaheadGraphQLCacheKeySerializer(a, graphQlQueryParamSet));
    }

    private GraphQLRequest<FetchTaggableObjectsQueryModel> m1689c(FetchMinutiaeTaggableObjectsParams fetchMinutiaeTaggableObjectsParams) {
        return m1687a(fetchMinutiaeTaggableObjectsParams, GraphQLCachePolicy.a);
    }
}
