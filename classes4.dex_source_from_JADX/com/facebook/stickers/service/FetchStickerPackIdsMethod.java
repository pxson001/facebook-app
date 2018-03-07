package com.facebook.stickers.service;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.graphql.FetchStickersGraphQL;
import com.facebook.stickers.graphql.FetchStickersGraphQL.FetchDownloadedStickerPackIdsQueryString;
import com.facebook.stickers.graphql.FetchStickersGraphQL.FetchOwnedStickerPackIdsQueryString;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: r_analytics_tag */
public class FetchStickerPackIdsMethod extends AbstractPersistedGraphQlApiMethod<FetchStickerPackIdsParams, FetchStickerPackIdsResult> {
    private static volatile FetchStickerPackIdsMethod f3896c;

    public static com.facebook.stickers.service.FetchStickerPackIdsMethod m4353a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3896c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.service.FetchStickerPackIdsMethod.class;
        monitor-enter(r1);
        r0 = f3896c;	 Catch:{ all -> 0x003a }
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
        r0 = m4354b(r0);	 Catch:{ all -> 0x0035 }
        f3896c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3896c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.service.FetchStickerPackIdsMethod.a(com.facebook.inject.InjectorLike):com.facebook.stickers.service.FetchStickerPackIdsMethod");
    }

    private static FetchStickerPackIdsMethod m4354b(InjectorLike injectorLike) {
        return new FetchStickerPackIdsMethod(GraphQLProtocolHelper.a(injectorLike));
    }

    public final Object m4355a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        FetchStickerPackIdsParams fetchStickerPackIdsParams = (FetchStickerPackIdsParams) obj;
        JsonNode b = ((JsonNode) jsonParser.J()).b("viewer").b("sticker_store").b(fetchStickerPackIdsParams.a.getFieldName()).b("nodes");
        Builder builder = new Builder();
        for (int i = 0; i < b.e(); i++) {
            JsonNode a = b.a(i);
            if (!fetchStickerPackIdsParams.c || a.b("updated_time").D() != a.b("published_time").D()) {
                builder.c(a.b("id").B());
            }
        }
        return new FetchStickerPackIdsResult(builder.b());
    }

    public final GraphQlQueryString m4357f(Object obj) {
        FetchStickerPackIdsParams fetchStickerPackIdsParams = (FetchStickerPackIdsParams) obj;
        switch (1.a[fetchStickerPackIdsParams.a.ordinal()]) {
            case 1:
                return new FetchDownloadedStickerPackIdsQueryString().a("update_time", Long.valueOf(fetchStickerPackIdsParams.b));
            case 2:
                return new FetchOwnedStickerPackIdsQueryString().a("update_time", Long.valueOf(fetchStickerPackIdsParams.b));
            case 3:
                return FetchStickersGraphQL.j().a("update_time", Long.valueOf(fetchStickerPackIdsParams.b));
            case 4:
                return FetchStickersGraphQL.j().a("update_time", Long.valueOf(fetchStickerPackIdsParams.b));
            default:
                throw new IllegalArgumentException("Unrecognized sticker pack type: " + fetchStickerPackIdsParams.a);
        }
    }

    @Inject
    public FetchStickerPackIdsMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final int m4356b(Object obj, ApiResponse apiResponse) {
        return 0;
    }
}
