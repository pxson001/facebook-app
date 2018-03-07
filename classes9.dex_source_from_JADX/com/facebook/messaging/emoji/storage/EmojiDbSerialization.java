package com.facebook.messaging.emoji.storage;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.emoji.Emojis;
import com.facebook.ui.emoji.model.Emoji;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: m_cls */
public class EmojiDbSerialization {
    private static volatile EmojiDbSerialization f11005c;
    private final Emojis f11006a;
    private final ObjectMapper f11007b;

    public static com.facebook.messaging.emoji.storage.EmojiDbSerialization m11417a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11005c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.emoji.storage.EmojiDbSerialization.class;
        monitor-enter(r1);
        r0 = f11005c;	 Catch:{ all -> 0x003a }
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
        r0 = m11419b(r0);	 Catch:{ all -> 0x0035 }
        f11005c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11005c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.emoji.storage.EmojiDbSerialization.a(com.facebook.inject.InjectorLike):com.facebook.messaging.emoji.storage.EmojiDbSerialization");
    }

    private static EmojiDbSerialization m11419b(InjectorLike injectorLike) {
        return new EmojiDbSerialization(Emojis.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EmojiDbSerialization(Emojis emojis, ObjectMapper objectMapper) {
        this.f11006a = emojis;
        this.f11007b = objectMapper;
    }

    public static String m11418a(List<Emoji> list) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (Emoji emoji : list) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("firstCodePoint", emoji.b);
            objectNode.a("secondCodePoint", emoji.c);
            if (emoji.e != null) {
                ArrayNode j = objectNode.j("remainingCodePoints");
                ImmutableList immutableList = emoji.e;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    j.a((Integer) immutableList.get(i));
                }
            }
            arrayNode.a(objectNode);
        }
        return arrayNode.toString();
    }

    public final ImmutableList<Emoji> m11420a(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        JsonNode a = this.f11007b.a(str);
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < a.e(); i++) {
            List b;
            Object a2;
            JsonNode a3 = a.a(i);
            int d = JSONUtil.d(a3.b("firstCodePoint"));
            int d2 = JSONUtil.d(a3.b("secondCodePoint"));
            if (a3.d("remainingCodePoints")) {
                boolean z;
                a3 = a3.b("remainingCodePoints");
                if (a3.k() == JsonNodeType.ARRAY) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                ArrayNode arrayNode = (ArrayNode) a3;
                Builder builder2 = ImmutableList.builder();
                for (int i2 = 0; i2 < arrayNode.e(); i2++) {
                    builder2.c(Integer.valueOf(JSONUtil.d(arrayNode.a(i2))));
                }
                b = builder2.b();
            } else {
                b = null;
            }
            if (b == null) {
                a2 = this.f11006a.a(d, d2);
            } else {
                a2 = this.f11006a.a(d, d2, b);
            }
            if (a2 != null) {
                builder.c(a2);
            }
        }
        return builder.b();
    }
}
