package com.facebook.stickers.service;

import com.facebook.common.util.JSONUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.graphql.FetchStickersGraphQL;
import com.facebook.stickers.graphql.FetchStickersGraphQL.FetchDownloadedStickerPacksQueryString;
import com.facebook.stickers.graphql.FetchStickersGraphQL.FetchOwnedStickerPacksQueryString;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.service.FetchStickersHelper.InvalidStickerPackException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: qwerty */
public class FetchStickerPacksMethod extends AbstractPersistedGraphQlApiMethod<FetchStickerPacksApiParams, FetchStickerPacksResult> {
    private static final Class<?> f3897c = FetchStickerPacksMethod.class;
    private static volatile FetchStickerPacksMethod f3898e;
    private final FetchStickersHelper f3899d;

    public static com.facebook.stickers.service.FetchStickerPacksMethod m4358a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3898e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.service.FetchStickerPacksMethod.class;
        monitor-enter(r1);
        r0 = f3898e;	 Catch:{ all -> 0x003a }
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
        r0 = m4359b(r0);	 Catch:{ all -> 0x0035 }
        f3898e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3898e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.service.FetchStickerPacksMethod.a(com.facebook.inject.InjectorLike):com.facebook.stickers.service.FetchStickerPacksMethod");
    }

    private static FetchStickerPacksMethod m4359b(InjectorLike injectorLike) {
        return new FetchStickerPacksMethod(GraphQLProtocolHelper.a(injectorLike), FetchStickersHelper.m4307a(injectorLike));
    }

    public final Object m4360a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        JsonNode b = ((JsonNode) jsonParser.J()).b("viewer").b("sticker_store").b(((FetchStickerPacksApiParams) obj).a().m4386a().getFieldName());
        JsonNode b2 = b.b("nodes");
        Builder builder = new Builder();
        for (int i = 0; i < b2.e(); i++) {
            try {
                builder.c(this.f3899d.m4317b(b2.a(i)));
            } catch (InvalidStickerPackException e) {
                BLog.a(f3897c, "Invalid sticker pack received from server. Probably safe to ignore this.", e);
            }
        }
        JsonNode b3 = b.b("page_info");
        if (b3.b("has_next_page").F()) {
            JSONUtil.b(b3.b("end_cursor"));
        }
        return new FetchStickerPacksResult(builder.b());
    }

    public final GraphQlQueryParamSet m4362e(Object obj) {
        boolean z;
        FetchStickerPacksApiParams fetchStickerPacksApiParams = (FetchStickerPacksApiParams) obj;
        Map c = Maps.c();
        String str = "is_auto_downloadable";
        if (fetchStickerPacksApiParams.a.f3926d || fetchStickerPacksApiParams.a.f3923a.equals(StickerPackType.AUTODOWNLOADED_PACKS)) {
            z = true;
        } else {
            z = false;
        }
        c.put(str, Boolean.valueOf(z));
        c.put("is_promoted", Boolean.valueOf(fetchStickerPacksApiParams.a.f3927e));
        c.put("is_featured", Boolean.valueOf(fetchStickerPacksApiParams.a.f3928f));
        if (fetchStickerPacksApiParams.c != null) {
            c.put("after", fetchStickerPacksApiParams.c);
        }
        if (fetchStickerPacksApiParams.b > 0) {
            c.put("first", Integer.valueOf(fetchStickerPacksApiParams.b));
        }
        if (fetchStickerPacksApiParams.a.f3929g) {
            c.put("update_time", Long.valueOf(fetchStickerPacksApiParams.d));
        }
        c.put("media_type", this.f3899d.m4318c());
        c.put("scaling_factor", this.f3899d.m4319d());
        if (fetchStickerPacksApiParams.a.m4388d() != null) {
            c.put("interface", fetchStickerPacksApiParams.a.m4388d());
        }
        return new GraphQlQueryParamSet(c);
    }

    public final GraphQlQueryString m4363f(Object obj) {
        FetchStickerPacksApiParams fetchStickerPacksApiParams = (FetchStickerPacksApiParams) obj;
        switch (1.a[fetchStickerPacksApiParams.a.f3923a.ordinal()]) {
            case 1:
                return new FetchDownloadedStickerPacksQueryString();
            case 2:
                return new FetchOwnedStickerPacksQueryString();
            case 3:
                return FetchStickersGraphQL.m();
            case 4:
                return FetchStickersGraphQL.m();
            default:
                throw new IllegalArgumentException("Unrecognized sticker pack type: " + fetchStickerPacksApiParams.a.f3923a);
        }
    }

    @Inject
    public FetchStickerPacksMethod(GraphQLProtocolHelper graphQLProtocolHelper, FetchStickersHelper fetchStickersHelper) {
        super(graphQLProtocolHelper);
        this.f3899d = fetchStickersHelper;
    }

    public final int m4361b(Object obj, ApiResponse apiResponse) {
        return 0;
    }
}
