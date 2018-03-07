package com.facebook.stickers.service;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.stickers.model.StickerPack;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: r_calling_class */
public class SetDownloadedStickerPacksMethod implements ApiMethod<List<StickerPack>, Void> {
    private static volatile SetDownloadedStickerPacksMethod f3895a;

    public static com.facebook.stickers.service.SetDownloadedStickerPacksMethod m4350a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f3895a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.stickers.service.SetDownloadedStickerPacksMethod.class;
        monitor-enter(r1);
        r0 = f3895a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m4349a();	 Catch:{ all -> 0x0034 }
        f3895a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f3895a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.service.SetDownloadedStickerPacksMethod.a(com.facebook.inject.InjectorLike):com.facebook.stickers.service.SetDownloadedStickerPacksMethod");
    }

    private static SetDownloadedStickerPacksMethod m4349a() {
        return new SetDownloadedStickerPacksMethod();
    }

    public final ApiRequest m4351a(Object obj) {
        List list = (List) obj;
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (int i = 0; i < list.size(); i++) {
            arrayNode.h(((StickerPack) list.get(i)).a);
        }
        List a = Lists.a();
        a.add(new BasicNameValuePair("pack_ids", arrayNode.toString()));
        return new ApiRequest("setDownloadedStickerPacks", TigonRequest.POST, "me/sticker_tray_packs", a, ApiResponseType.JSON);
    }

    public final Object m4352a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
