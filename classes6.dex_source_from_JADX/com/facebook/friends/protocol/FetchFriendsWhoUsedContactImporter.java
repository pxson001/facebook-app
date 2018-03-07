package com.facebook.friends.protocol;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.friends.protocol.FetchDailyDialogueContactImporter.DailyDialogueContactImporterQueryString;
import com.facebook.friends.protocol.FetchDailyDialogueContactImporterModels.DailyDialogueContactImporterQueryModel;
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLModels.FacepileFriendsConnectionModel;
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLModels.FriendsWhoUsedContactImporterQueryModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: manual_retry_count */
public class FetchFriendsWhoUsedContactImporter {
    private static volatile FetchFriendsWhoUsedContactImporter f10719d;
    public final GraphQLQueryExecutor f10720a;
    public final GraphQLImageHelper f10721b;
    public final ListeningExecutorService f10722c;

    /* compiled from: manual_retry_count */
    public class C06621 implements Function<GraphQLResult<FriendsWhoUsedContactImporterQueryModel>, FacepileFriendsConnectionModel> {
        final /* synthetic */ FetchFriendsWhoUsedContactImporter f10717a;

        public C06621(FetchFriendsWhoUsedContactImporter fetchFriendsWhoUsedContactImporter) {
            this.f10717a = fetchFriendsWhoUsedContactImporter;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            return ((FriendsWhoUsedContactImporterQueryModel) graphQLResult.e).m17393a();
        }
    }

    /* compiled from: manual_retry_count */
    class C06632 implements Function<GraphQLResult<DailyDialogueContactImporterQueryModel>, DailyDialogueContactImporterQueryModel> {
        final /* synthetic */ FetchFriendsWhoUsedContactImporter f10718a;

        C06632(FetchFriendsWhoUsedContactImporter fetchFriendsWhoUsedContactImporter) {
            this.f10718a = fetchFriendsWhoUsedContactImporter;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            return (DailyDialogueContactImporterQueryModel) graphQLResult.e;
        }
    }

    /* compiled from: manual_retry_count */
    public enum OrderBy {
        FIRST_NAME("first_name"),
        MUTUAL_IMPORTANCE("mutual_importance");
        
        public final String value;

        private OrderBy(String str) {
            this.value = str;
        }
    }

    public static com.facebook.friends.protocol.FetchFriendsWhoUsedContactImporter m16998a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10719d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friends.protocol.FetchFriendsWhoUsedContactImporter.class;
        monitor-enter(r1);
        r0 = f10719d;	 Catch:{ all -> 0x003a }
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
        r0 = m16999b(r0);	 Catch:{ all -> 0x0035 }
        f10719d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10719d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friends.protocol.FetchFriendsWhoUsedContactImporter.a(com.facebook.inject.InjectorLike):com.facebook.friends.protocol.FetchFriendsWhoUsedContactImporter");
    }

    private static FetchFriendsWhoUsedContactImporter m16999b(InjectorLike injectorLike) {
        return new FetchFriendsWhoUsedContactImporter(GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLImageHelper.a(injectorLike));
    }

    @Inject
    public FetchFriendsWhoUsedContactImporter(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService, GraphQLImageHelper graphQLImageHelper) {
        this.f10720a = graphQLQueryExecutor;
        this.f10722c = listeningExecutorService;
        this.f10721b = graphQLImageHelper;
    }

    public final ListenableFuture<DailyDialogueContactImporterQueryModel> m17000b(int i, int i2, OrderBy orderBy) {
        GraphQlQueryString dailyDialogueContactImporterQueryString = new DailyDialogueContactImporterQueryString();
        dailyDialogueContactImporterQueryString.a("image_scale", GraphQlQueryDefaults.a()).a("first", String.valueOf(i)).a("order_by", Lists.a(new String[]{orderBy.value})).a("picture_size", String.valueOf(i2)).a("media_type", this.f10721b.b());
        GraphQLRequest a = GraphQLRequest.a(dailyDialogueContactImporterQueryString);
        a.a(GraphQLCachePolicy.a);
        return Futures.a(this.f10720a.a(a), new C06632(this), this.f10722c);
    }
}
