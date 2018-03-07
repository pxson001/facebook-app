package com.facebook.stickers.service;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.graphql.FetchStickersGraphQL.FetchStickerTagsQueryString;
import com.facebook.stickers.model.StickerTag;
import com.facebook.stickers.model.StickerTagBuilder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: radix must be between MIN_RADIX and MAX_RADIX but was  */
public class FetchStickerTagsMethod extends AbstractPersistedGraphQlApiMethod<FetchStickerTagsParams, FetchStickerTagsResult> {
    private static volatile FetchStickerTagsMethod f3865d;
    private FetchStickersHelper f3866c;

    public static com.facebook.stickers.service.FetchStickerTagsMethod m4300a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3865d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.service.FetchStickerTagsMethod.class;
        monitor-enter(r1);
        r0 = f3865d;	 Catch:{ all -> 0x003a }
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
        r0 = m4301b(r0);	 Catch:{ all -> 0x0035 }
        f3865d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3865d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.service.FetchStickerTagsMethod.a(com.facebook.inject.InjectorLike):com.facebook.stickers.service.FetchStickerTagsMethod");
    }

    private static FetchStickerTagsMethod m4301b(InjectorLike injectorLike) {
        return new FetchStickerTagsMethod(GraphQLProtocolHelper.a(injectorLike), FetchStickersHelper.m4307a(injectorLike));
    }

    public final GraphQlQueryString m4304f(Object obj) {
        return new FetchStickerTagsQueryString().a("tag_type", ((FetchStickerTagsParams) obj).b.getQueryParam()).a("thumbnail_size", Integer.toString(this.f3866c.f3869b.getResources().getDimensionPixelSize(2131428602))).a("thumbnail_scale_factor", this.f3866c.m4319d()).a("thumbnail_format", this.f3866c.m4318c());
    }

    @Inject
    public FetchStickerTagsMethod(GraphQLProtocolHelper graphQLProtocolHelper, FetchStickersHelper fetchStickersHelper) {
        super(graphQLProtocolHelper);
        this.f3866c = fetchStickersHelper;
    }

    public final Object m4302a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        Builder builder = new Builder();
        JsonNode b = ((JsonNode) jsonParser.J()).b("viewer").b("sticker_store").b("sticker_tags").b("nodes");
        for (int i = 0; i < b.e(); i++) {
            JsonNode a = b.a(i);
            StickerTagBuilder newBuilder = StickerTag.newBuilder();
            newBuilder.a = a.b("id").B();
            StickerTagBuilder stickerTagBuilder = newBuilder;
            stickerTagBuilder.b = a.b("name").B();
            stickerTagBuilder.d = a.b("is_featured").F();
            if (a.b("is_featured").F()) {
                newBuilder.c = a.b("color_code").B();
                newBuilder.e = a.b("order").C();
                newBuilder.f = a.b("thumbnail_image").b("uri").B();
            }
            builder.c(newBuilder.a());
        }
        return new FetchStickerTagsResult(builder.b());
    }

    public final int m4303b(Object obj, ApiResponse apiResponse) {
        return 0;
    }
}
