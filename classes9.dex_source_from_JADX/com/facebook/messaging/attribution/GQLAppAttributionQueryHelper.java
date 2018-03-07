package com.facebook.messaging.attribution;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesModels.AppAttributionInfoModel;
import com.facebook.messaging.graphql.threads.AppVisibilityQueriesModels.AttributionVisibilityModel;
import com.facebook.messaging.graphql.threads.AppVisibilityQueriesModels.AttributionVisibilityModel.MessengerAppAttributionVisibilityModel;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.attribution.AttributionVisibilityBuilder;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.attribution.ContentAppAttributionFactory;
import com.google.common.base.Function;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: outputY */
public class GQLAppAttributionQueryHelper {
    private static volatile GQLAppAttributionQueryHelper f7813c;
    public final GraphQLQueryExecutor f7814a;
    public final ContentAppAttributionFactory f7815b;

    /* compiled from: outputY */
    public class C08621 implements Function<GraphQLResult<AppAttributionInfoModel>, ContentAppAttribution> {
        final /* synthetic */ ContentAppAttribution f7810a;
        final /* synthetic */ GQLAppAttributionQueryHelper f7811b;

        public C08621(GQLAppAttributionQueryHelper gQLAppAttributionQueryHelper, ContentAppAttribution contentAppAttribution) {
            this.f7811b = gQLAppAttributionQueryHelper;
            this.f7810a = contentAppAttribution;
        }

        public Object apply(Object obj) {
            return this.f7811b.f7815b.a(this.f7810a, (AppAttributionInfoModel) ((GraphQLResult) obj).e);
        }
    }

    /* compiled from: outputY */
    public class C08632 implements Function<GraphQLResult<AttributionVisibilityModel>, AttributionVisibility> {
        final /* synthetic */ GQLAppAttributionQueryHelper f7812a;

        public C08632(GQLAppAttributionQueryHelper gQLAppAttributionQueryHelper) {
            this.f7812a = gQLAppAttributionQueryHelper;
        }

        public Object apply(Object obj) {
            MessengerAppAttributionVisibilityModel a = ((AttributionVisibilityModel) ((GraphQLResult) obj).e).a();
            AttributionVisibilityBuilder newBuilder = AttributionVisibility.newBuilder();
            newBuilder.a = a.a();
            newBuilder = newBuilder;
            newBuilder.c = a.j();
            newBuilder = newBuilder;
            newBuilder.d = a.k();
            newBuilder = newBuilder;
            newBuilder.e = a.j();
            return newBuilder.h();
        }
    }

    public static com.facebook.messaging.attribution.GQLAppAttributionQueryHelper m8050a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7813c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.attribution.GQLAppAttributionQueryHelper.class;
        monitor-enter(r1);
        r0 = f7813c;	 Catch:{ all -> 0x003a }
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
        r0 = m8051b(r0);	 Catch:{ all -> 0x0035 }
        f7813c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7813c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.attribution.GQLAppAttributionQueryHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.attribution.GQLAppAttributionQueryHelper");
    }

    private static GQLAppAttributionQueryHelper m8051b(InjectorLike injectorLike) {
        return new GQLAppAttributionQueryHelper(GraphQLQueryExecutor.a(injectorLike), ContentAppAttributionFactory.b(injectorLike));
    }

    @Inject
    public GQLAppAttributionQueryHelper(GraphQLQueryExecutor graphQLQueryExecutor, ContentAppAttributionFactory contentAppAttributionFactory) {
        this.f7814a = graphQLQueryExecutor;
        this.f7815b = contentAppAttributionFactory;
    }
}
