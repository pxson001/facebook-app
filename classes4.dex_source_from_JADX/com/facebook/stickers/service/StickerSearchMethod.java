package com.facebook.stickers.service;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: r_count */
public class StickerSearchMethod extends AbstractPersistedGraphQlApiMethod<StickerSearchParams, StickerSearchResult> {
    private static final Class<?> f3876c = StickerSearchMethod.class;
    private static volatile StickerSearchMethod f3877e;
    private final FetchStickersHelper f3878d;

    public static com.facebook.stickers.service.StickerSearchMethod m4325a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3877e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.service.StickerSearchMethod.class;
        monitor-enter(r1);
        r0 = f3877e;	 Catch:{ all -> 0x003a }
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
        r0 = m4326b(r0);	 Catch:{ all -> 0x0035 }
        f3877e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3877e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.service.StickerSearchMethod.a(com.facebook.inject.InjectorLike):com.facebook.stickers.service.StickerSearchMethod");
    }

    private static StickerSearchMethod m4326b(InjectorLike injectorLike) {
        return new StickerSearchMethod(GraphQLProtocolHelper.a(injectorLike), FetchStickersHelper.m4307a(injectorLike));
    }

    public final Object m4327a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        StickerSearchParams stickerSearchParams = (StickerSearchParams) obj;
        JsonNode jsonNode = (JsonNode) jsonParser.J();
        Builder builder = new Builder();
        Iterator G = jsonNode.b(stickerSearchParams.a()).b("sticker_results").b("nodes").G();
        while (G.hasNext()) {
            try {
                builder.c(this.f3878d.m4315a((JsonNode) G.next()));
            } catch (Throwable e) {
                BLog.b(f3876c, "Error parsing sticker node", e);
            }
        }
        return new StickerSearchResult(builder.b());
    }

    public final GraphQlQueryString m4329f(Object obj) {
        StickerSearchParams stickerSearchParams = (StickerSearchParams) obj;
        GraphQlQueryString b = this.f3878d.m4316b();
        b.a("search_query", stickerSearchParams.a);
        b.a("interface", stickerSearchParams.b);
        return b;
    }

    @Inject
    public StickerSearchMethod(GraphQLProtocolHelper graphQLProtocolHelper, FetchStickersHelper fetchStickersHelper) {
        super(graphQLProtocolHelper);
        this.f3878d = fetchStickersHelper;
    }

    public final int m4328b(Object obj, ApiResponse apiResponse) {
        return 0;
    }
}
