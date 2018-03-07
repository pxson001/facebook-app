package com.facebook.platform.opengraph;

import android.content.Context;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.opengraph.OpenGraphRequest.OpenGraphRequestException;
import com.facebook.platform.opengraph.OpenGraphRequest.SavedInstanceState;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: gcm_reg_frequency_s */
public class OpenGraphRequestFactory {
    private static volatile OpenGraphRequestFactory f11306d;
    private final BitmapUtils f11307a;
    private final Context f11308b;
    private final ObjectMapperWithUncheckedException f11309c;

    public static com.facebook.platform.opengraph.OpenGraphRequestFactory m11706a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11306d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.opengraph.OpenGraphRequestFactory.class;
        monitor-enter(r1);
        r0 = f11306d;	 Catch:{ all -> 0x003a }
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
        r0 = m11707b(r0);	 Catch:{ all -> 0x0035 }
        f11306d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11306d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.opengraph.OpenGraphRequestFactory.a(com.facebook.inject.InjectorLike):com.facebook.platform.opengraph.OpenGraphRequestFactory");
    }

    private static OpenGraphRequestFactory m11707b(InjectorLike injectorLike) {
        return new OpenGraphRequestFactory(BitmapUtils.m11716a(injectorLike), (Context) injectorLike.getInstance(Context.class), ObjectMapperWithUncheckedException.a(injectorLike));
    }

    @Inject
    public OpenGraphRequestFactory(BitmapUtils bitmapUtils, Context context, ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f11307a = bitmapUtils;
        this.f11308b = context;
        this.f11309c = objectMapperWithUncheckedException;
    }

    public final OpenGraphRequest m11710a(String str, String str2, String str3) {
        return new OpenGraphRequest(this.f11307a, this.f11308b, (ObjectNode) this.f11309c.a(str), str2, str3);
    }

    public final OpenGraphRequest m11709a(PlatformActivityOpenGraphDialogRequest platformActivityOpenGraphDialogRequest) {
        return new OpenGraphRequest(this.f11307a, this.f11308b, platformActivityOpenGraphDialogRequest.e, platformActivityOpenGraphDialogRequest.b, platformActivityOpenGraphDialogRequest.c);
    }

    public final OpenGraphRequest m11708a(SavedInstanceState savedInstanceState) {
        OpenGraphRequest openGraphRequest = new OpenGraphRequest(this.f11307a, this.f11308b, (ObjectNode) this.f11309c.a(savedInstanceState.a), savedInstanceState.b, savedInstanceState.c);
        try {
            openGraphRequest.h();
            return openGraphRequest;
        } catch (OpenGraphRequestException e) {
            throw new RuntimeException(e);
        }
    }
}
