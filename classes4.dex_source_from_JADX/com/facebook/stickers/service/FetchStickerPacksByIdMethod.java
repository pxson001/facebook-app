package com.facebook.stickers.service;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.graphql.FetchStickersGraphQL.FetchStickerPacksQueryString;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.service.FetchStickerPacksResult.Availability;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: quit */
public class FetchStickerPacksByIdMethod extends AbstractPersistedGraphQlApiMethod<FetchStickerPacksByIdParams, FetchStickerPacksResult> {
    private static final Class<?> f3900c = FetchStickerPacksByIdMethod.class;
    private static volatile FetchStickerPacksByIdMethod f3901e;
    private final FetchStickersHelper f3902d;

    public static com.facebook.stickers.service.FetchStickerPacksByIdMethod m4364a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3901e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.service.FetchStickerPacksByIdMethod.class;
        monitor-enter(r1);
        r0 = f3901e;	 Catch:{ all -> 0x003a }
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
        r0 = m4365b(r0);	 Catch:{ all -> 0x0035 }
        f3901e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3901e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.service.FetchStickerPacksByIdMethod.a(com.facebook.inject.InjectorLike):com.facebook.stickers.service.FetchStickerPacksByIdMethod");
    }

    private static FetchStickerPacksByIdMethod m4365b(InjectorLike injectorLike) {
        return new FetchStickerPacksByIdMethod(GraphQLProtocolHelper.a(injectorLike), FetchStickersHelper.m4307a(injectorLike));
    }

    public final Object m4366a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        JsonNode jsonNode = (JsonNode) jsonParser.J();
        Builder builder = new Builder();
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder();
        Iterator G = jsonNode.G();
        while (G.hasNext()) {
            jsonNode = (JsonNode) G.next();
            StickerPack b = this.f3902d.m4317b(jsonNode);
            builder.c(b);
            boolean a = jsonNode.b("in_sticker_tray").a(false);
            boolean a2 = jsonNode.b("can_download").a(false);
            Object obj2 = Availability.NOT_AVAILABLE;
            if (a) {
                obj2 = Availability.DOWNLOADED;
            } else if (a2) {
                obj2 = Availability.IN_STORE;
            }
            builder2.b(b.a, obj2);
        }
        return new FetchStickerPacksResult(builder.b(), builder2.b());
    }

    public final GraphQlQueryString m4368f(Object obj) {
        FetchStickerPacksByIdParams fetchStickerPacksByIdParams = (FetchStickerPacksByIdParams) obj;
        GraphQlQueryString fetchStickerPacksQueryString = new FetchStickerPacksQueryString();
        fetchStickerPacksQueryString.a("pack_ids", fetchStickerPacksByIdParams.a).a("media_type", this.f3902d.m4318c()).a("scaling_factor", this.f3902d.m4319d());
        return fetchStickerPacksQueryString;
    }

    @Inject
    public FetchStickerPacksByIdMethod(GraphQLProtocolHelper graphQLProtocolHelper, FetchStickersHelper fetchStickersHelper) {
        super(graphQLProtocolHelper);
        this.f3902d = fetchStickersHelper;
    }

    public final int m4367b(Object obj, ApiResponse apiResponse) {
        return 0;
    }
}
