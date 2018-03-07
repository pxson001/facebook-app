package com.facebook.stickers.data;

import android.net.Uri;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ranking_score */
public class StickerPackSerialization {
    private static volatile StickerPackSerialization f3857b;
    private final ObjectMapper f3858a;

    public static com.facebook.stickers.data.StickerPackSerialization m4290a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3857b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.data.StickerPackSerialization.class;
        monitor-enter(r1);
        r0 = f3857b;	 Catch:{ all -> 0x003a }
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
        r0 = m4292b(r0);	 Catch:{ all -> 0x0035 }
        f3857b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3857b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.data.StickerPackSerialization.a(com.facebook.inject.InjectorLike):com.facebook.stickers.data.StickerPackSerialization");
    }

    private static StickerPackSerialization m4292b(InjectorLike injectorLike) {
        return new StickerPackSerialization((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StickerPackSerialization(ObjectMapper objectMapper) {
        this.f3858a = objectMapper;
    }

    public final String m4296b(List<Sticker> list) {
        if (list == null) {
            return null;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (Sticker sticker : list) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("id", sticker.a);
            objectNode.a("pack_id", sticker.b);
            objectNode.a("uri", m4291a(sticker.c));
            objectNode.a("disk_uri", m4291a(sticker.d));
            objectNode.a("animated_uri", m4291a(sticker.e));
            objectNode.a("animated_disk_uri", m4291a(sticker.f));
            objectNode.a("preview_uri", m4291a(sticker.g));
            objectNode.a("preview_disk_uri", m4291a(sticker.h));
            arrayNode.a(objectNode);
        }
        return arrayNode.toString();
    }

    public static String m4291a(Uri uri) {
        return uri != null ? uri.toString() : null;
    }

    public final ImmutableList<String> m4294a(String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        JsonNode a = this.f3858a.a(str);
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < a.e(); i++) {
            builder.c(a.a(i).B());
        }
        return builder.b();
    }

    public final ImmutableList<Sticker> m4295b(String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        JsonNode a = this.f3858a.a(str);
        Builder builder = ImmutableList.builder();
        StickerBuilder newBuilder = StickerBuilder.newBuilder();
        for (int i = 0; i < a.e(); i++) {
            JsonNode a2 = a.a(i);
            String b = JSONUtil.b(a2.b("id"));
            String b2 = JSONUtil.b(a2.b("pack_id"));
            Uri c = m4293c(a2.b("uri"));
            Uri c2 = m4293c(a2.b("disk_uri"));
            Uri c3 = m4293c(a2.b("animated_uri"));
            Uri c4 = m4293c(a2.b("animated_disk_uri"));
            Uri c5 = m4293c(a2.b("preview_uri"));
            Uri c6 = m4293c(a2.b("preview_disk_uri"));
            newBuilder.a = b;
            StickerBuilder stickerBuilder = newBuilder;
            stickerBuilder.b = b2;
            stickerBuilder = stickerBuilder;
            stickerBuilder.c = c;
            stickerBuilder = stickerBuilder;
            stickerBuilder.d = c2;
            stickerBuilder = stickerBuilder;
            stickerBuilder.e = c3;
            stickerBuilder = stickerBuilder;
            stickerBuilder.f = c4;
            stickerBuilder = stickerBuilder;
            stickerBuilder.g = c5;
            stickerBuilder = stickerBuilder;
            stickerBuilder.h = c6;
            builder.c(stickerBuilder.a());
            newBuilder.b();
        }
        return builder.b();
    }

    public final String m4298c(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (String str : list) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("id", str);
            arrayNode.a(objectNode);
        }
        return arrayNode.toString();
    }

    public final ImmutableList<String> m4297c(String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        JsonNode a = this.f3858a.a(str);
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < a.e(); i++) {
            builder.c(JSONUtil.b(a.a(i).b("id")));
        }
        return builder.b();
    }

    public static Uri m4293c(JsonNode jsonNode) {
        String b = JSONUtil.b(jsonNode);
        return b != null ? Uri.parse(b) : null;
    }
}
