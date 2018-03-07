package com.facebook.messaging.sms.defaultapp;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Collections;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.google.android.gms.auth.VERIFY_ASSERTION */
public class MmsDownloadManager {
    private static volatile MmsDownloadManager f17533c;
    public final Map<String, SettableFuture> f17534a = Collections.synchronizedMap(new ArrayMap());
    public Context f17535b;

    /* compiled from: com.google.android.gms.auth.VERIFY_ASSERTION */
    public enum ErrorCode {
        NO_ERROR,
        MESSAGE_NOT_FOUND,
        MESSAGE_EXPIRED,
        OTHER
    }

    public static com.facebook.messaging.sms.defaultapp.MmsDownloadManager m17517a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17533c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.defaultapp.MmsDownloadManager.class;
        monitor-enter(r1);
        r0 = f17533c;	 Catch:{ all -> 0x003a }
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
        r0 = m17518b(r0);	 Catch:{ all -> 0x0035 }
        f17533c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17533c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.defaultapp.MmsDownloadManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.defaultapp.MmsDownloadManager");
    }

    private static MmsDownloadManager m17518b(InjectorLike injectorLike) {
        return new MmsDownloadManager((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public MmsDownloadManager(Context context) {
        this.f17535b = context;
    }

    public final void m17520c(String str) {
        SettableFuture settableFuture = (SettableFuture) this.f17534a.remove(str);
        if (settableFuture != null) {
            FutureDetour.a(settableFuture, ErrorCode.NO_ERROR, 1099150459);
        }
    }

    public final void m17519a(String str, ErrorCode errorCode) {
        SettableFuture settableFuture = (SettableFuture) this.f17534a.remove(str);
        if (settableFuture != null) {
            FutureDetour.a(settableFuture, errorCode, -456652287);
        }
    }
}
