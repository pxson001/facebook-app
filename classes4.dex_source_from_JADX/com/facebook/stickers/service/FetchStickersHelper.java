package com.facebook.stickers.service;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.facebook.common.gridlayoututils.GridSizingCalculator;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.graphql.FetchStickersGraphQL.FetchAvailableTaggedStickersWithPreviewsQueryString;
import com.facebook.stickers.graphql.FetchStickersGraphQL.FetchStickersWithPreviewsQueryString;
import com.facebook.stickers.graphql.FetchStickersGraphQL.FetchTaggedStickersWithPreviewsQueryString;
import com.facebook.stickers.graphql.FetchStickersGraphQL.FetchTrayTaggedStickersWithPreviewsQueryString;
import com.facebook.stickers.graphql.FetchStickersGraphQL.SearchTaggedStickersQueryString;
import com.facebook.stickers.gridlayout.StickerGridSizingParams;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerBuilder;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: r_user_id */
public class FetchStickersHelper {
    private static final Class<?> f3867a = FetchStickersHelper.class;
    private static volatile FetchStickersHelper f3868g;
    public final Context f3869b;
    private final Boolean f3870c;
    private final Provider<TriState> f3871d;
    public final Provider<Boolean> f3872e;
    private ScalingFactor f3873f;

    public static com.facebook.stickers.service.FetchStickersHelper m4307a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3868g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.service.FetchStickersHelper.class;
        monitor-enter(r1);
        r0 = f3868g;	 Catch:{ all -> 0x003a }
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
        r0 = m4310b(r0);	 Catch:{ all -> 0x0035 }
        f3868g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3868g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.service.FetchStickersHelper.a(com.facebook.inject.InjectorLike):com.facebook.stickers.service.FetchStickersHelper");
    }

    private static FetchStickersHelper m4310b(InjectorLike injectorLike) {
        return new FetchStickersHelper((Context) injectorLike.getInstance(Context.class), Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(972, false)), IdBasedProvider.a(injectorLike, 774), IdBasedProvider.a(injectorLike, 4332));
    }

    @Inject
    public FetchStickersHelper(Context context, Boolean bool, Provider<TriState> provider, Provider<Boolean> provider2) {
        this.f3869b = context;
        this.f3870c = bool;
        this.f3871d = provider;
        this.f3872e = provider2;
    }

    public final GraphQlQueryString m4314a(FetchTaggedStickersParams fetchTaggedStickersParams) {
        GraphQlQueryString fetchAvailableTaggedStickersWithPreviewsQueryString;
        switch (1.a[fetchTaggedStickersParams.b.ordinal()]) {
            case 1:
                fetchAvailableTaggedStickersWithPreviewsQueryString = new FetchAvailableTaggedStickersWithPreviewsQueryString();
                break;
            case 2:
                fetchAvailableTaggedStickersWithPreviewsQueryString = new FetchTrayTaggedStickersWithPreviewsQueryString();
                break;
            default:
                fetchAvailableTaggedStickersWithPreviewsQueryString = new FetchTaggedStickersWithPreviewsQueryString();
                break;
        }
        m4308a(fetchAvailableTaggedStickersWithPreviewsQueryString);
        return fetchAvailableTaggedStickersWithPreviewsQueryString;
    }

    public final GraphQlQueryString m4313a() {
        GraphQlQueryString fetchStickersWithPreviewsQueryString = new FetchStickersWithPreviewsQueryString();
        m4308a(fetchStickersWithPreviewsQueryString);
        return fetchStickersWithPreviewsQueryString;
    }

    private void m4308a(GraphQlQueryString graphQlQueryString) {
        int i;
        String str = "preview_size";
        Resources resources = this.f3869b.getResources();
        int i2 = resources.getDisplayMetrics().widthPixels;
        Sizes a = new GridSizingCalculator(resources, new StickerGridSizingParams()).a(i2, i2 - resources.getDimensionPixelSize(2131427864), false);
        i2 = a.i;
        if (((Boolean) this.f3872e.get()).booleanValue()) {
            i = (i2 - a.c) - a.d;
        } else {
            i = i2;
        }
        graphQlQueryString.a(str, Integer.valueOf(i));
        if (((TriState) this.f3871d.get()).asBoolean(false)) {
            graphQlQueryString.a("animated_media_type", "image/x-fba");
        } else {
            graphQlQueryString.a("animated_media_type", "image/webp");
        }
        graphQlQueryString.a("media_type", m4318c());
        graphQlQueryString.a("scaling_factor", m4319d());
    }

    public final String m4318c() {
        if (this.f3870c.booleanValue()) {
            return "image/webp";
        }
        return "image/png";
    }

    public final String m4319d() {
        if (this.f3873f == null) {
            ScalingFactor scalingFactor = ScalingFactor.values()[0];
            DisplayMetrics displayMetrics = this.f3869b.getResources().getDisplayMetrics();
            ScalingFactor[] values = ScalingFactor.values();
            int length = values.length;
            int i = 0;
            ScalingFactor scalingFactor2 = scalingFactor;
            double d = Double.MAX_VALUE;
            while (i < length) {
                ScalingFactor scalingFactor3 = values[i];
                float abs = Math.abs(scalingFactor3.numericValue - displayMetrics.density);
                if (((double) abs) < d) {
                    d = (double) abs;
                } else {
                    scalingFactor3 = scalingFactor2;
                }
                i++;
                scalingFactor2 = scalingFactor3;
            }
            this.f3873f = scalingFactor2;
        }
        return this.f3873f.stringValue;
    }

    public final Sticker m4315a(JsonNode jsonNode) {
        StickerBuilder newBuilder = StickerBuilder.newBuilder();
        if (jsonNode.b("pack") == null) {
            throw new InvalidStickerPackException("node pack is missing");
        }
        String b = JSONUtil.b(jsonNode.b("pack").b("id"));
        String b2 = JSONUtil.b(jsonNode.b("id"));
        Uri c = m4311c(jsonNode.b("thread_image"));
        Uri c2 = m4311c(jsonNode.b("animated_image"));
        Uri c3 = m4311c(jsonNode.b("preview_image"));
        newBuilder.a = b2;
        newBuilder = newBuilder;
        newBuilder.b = b;
        newBuilder = newBuilder;
        newBuilder.c = c;
        newBuilder = newBuilder;
        newBuilder.e = c2;
        newBuilder = newBuilder;
        newBuilder.g = c3;
        return newBuilder.a();
    }

    private static Uri m4311c(JsonNode jsonNode) {
        if (jsonNode == null) {
            return null;
        }
        String b = JSONUtil.b(jsonNode.b("uri"));
        if (b != null) {
            return Uri.parse(b);
        }
        return null;
    }

    private static boolean m4309a(JsonNode jsonNode, boolean z) {
        return jsonNode == null ? z : jsonNode.a(z);
    }

    private static int m4305a(JsonNode jsonNode, int i) {
        return jsonNode == null ? i : jsonNode.b(i);
    }

    private static long m4306a(JsonNode jsonNode, long j) {
        return jsonNode == null ? j : jsonNode.a(j);
    }

    public final StickerPack m4317b(JsonNode jsonNode) {
        int i = 0;
        if (jsonNode.b("tray_button") == null) {
            throw new InvalidStickerPackException("node tray_button is missing");
        }
        StickerPackBuilder stickerPackBuilder = new StickerPackBuilder();
        stickerPackBuilder.a = JSONUtil.b(jsonNode.b("id"));
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.b = JSONUtil.b(jsonNode.b("name"));
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.c = JSONUtil.b(jsonNode.b("artist"));
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.d = JSONUtil.b(jsonNode.b("description"));
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.e = m4312d(jsonNode.b("thumbnail_image"));
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.g = m4312d(jsonNode.b("preview_image"));
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.h = m4312d(jsonNode.b("tray_button").b("normal"));
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.i = m4305a(jsonNode.b("price"), 0);
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.j = m4306a(jsonNode.b("updated_time"), 0);
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.l = m4309a(jsonNode.b("is_auto_downloadable"), false);
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.m = m4309a(jsonNode.b("is_comments_capable"), false);
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.n = m4309a(jsonNode.b("is_composer_capable"), false);
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.o = m4309a(jsonNode.b("is_messenger_capable"), false);
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.p = m4309a(jsonNode.b("is_featured"), false);
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.q = m4309a(jsonNode.b("is_promoted"), false);
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.r = m4309a(jsonNode.b("in_sticker_tray"), false);
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.u = m4309a(jsonNode.b("is_messenger_only"), true);
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.v = m4309a(jsonNode.b("is_sms_capable"), false);
        StickerPackBuilder stickerPackBuilder2 = stickerPackBuilder;
        JsonNode b = jsonNode.b("copyrights");
        Builder builder = new Builder();
        for (int i2 = 0; i2 < b.e(); i2++) {
            builder.c(b.a(i2).B());
        }
        stickerPackBuilder2.s = builder.b();
        Builder builder2 = new Builder();
        if (!(jsonNode.b("stickers") == null || jsonNode.b("stickers").b("nodes") == null)) {
            b = jsonNode.b("stickers").b("nodes");
            while (i < b.e()) {
                builder2.c(JSONUtil.b(b.a(i).b("id")));
                i++;
            }
        }
        stickerPackBuilder2.t = builder2.b();
        return stickerPackBuilder2.w();
    }

    private static Uri m4312d(JsonNode jsonNode) {
        if (jsonNode != null && jsonNode.b("uri") != null) {
            return Uri.parse(JSONUtil.b(jsonNode.b("uri")));
        }
        throw new InvalidStickerPackException("node uri is missing");
    }

    public final GraphQlQueryString m4316b() {
        GraphQlQueryString searchTaggedStickersQueryString = new SearchTaggedStickersQueryString();
        m4308a(searchTaggedStickersQueryString);
        return searchTaggedStickersQueryString;
    }
}
