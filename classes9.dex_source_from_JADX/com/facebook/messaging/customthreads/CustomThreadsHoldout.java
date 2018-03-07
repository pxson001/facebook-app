package com.facebook.messaging.customthreads;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.hash.Hashing.Md5Holder;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: media_params */
public class CustomThreadsHoldout {
    private static final HashMap<ThreadKey, Boolean> f10259a = new HashMap();
    private static volatile CustomThreadsHoldout f10260e;
    private final CustomThreadsLogger f10261b;
    private final Provider<Boolean> f10262c;
    private final Provider<Boolean> f10263d;

    public static com.facebook.messaging.customthreads.CustomThreadsHoldout m10862a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10260e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.customthreads.CustomThreadsHoldout.class;
        monitor-enter(r1);
        r0 = f10260e;	 Catch:{ all -> 0x003a }
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
        r0 = m10863b(r0);	 Catch:{ all -> 0x0035 }
        f10260e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10260e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.customthreads.CustomThreadsHoldout.a(com.facebook.inject.InjectorLike):com.facebook.messaging.customthreads.CustomThreadsHoldout");
    }

    private static CustomThreadsHoldout m10863b(InjectorLike injectorLike) {
        return new CustomThreadsHoldout(CustomThreadsLogger.m10867a(injectorLike), IdBasedProvider.a(injectorLike, 4152), IdBasedProvider.a(injectorLike, 4153));
    }

    @Inject
    public CustomThreadsHoldout(CustomThreadsLogger customThreadsLogger, Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.f10261b = customThreadsLogger;
        this.f10262c = provider;
        this.f10263d = provider2;
    }

    public final boolean m10866a(ThreadKey threadKey) {
        if (ThreadKey.d(threadKey)) {
            return false;
        }
        if (((Boolean) this.f10262c.get()).booleanValue()) {
            return m10864b(threadKey);
        }
        return ((Boolean) this.f10263d.get()).booleanValue();
    }

    private synchronized boolean m10864b(ThreadKey threadKey) {
        boolean booleanValue;
        if (f10259a.containsKey(threadKey)) {
            booleanValue = ((Boolean) f10259a.get(threadKey)).booleanValue();
        } else {
            booleanValue = ((int) ((m10865c(threadKey) % 100) + 1)) <= 95;
            f10259a.put(threadKey, Boolean.valueOf(booleanValue));
            this.f10261b.m10871a(threadKey, booleanValue);
        }
        return booleanValue;
    }

    private static long m10865c(ThreadKey threadKey) {
        long j = threadKey.e;
        long j2 = threadKey.d;
        long min = Math.min(j, j2);
        return Math.abs(Md5Holder.a.a().a(-1431900809).a(threadKey.b).a(min).a(Math.max(j, j2)).a().c());
    }
}
