package com.facebook.common.executors;

import com.facebook.analytics.ExecutorsTasksLogger.1;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Singleton;

@Singleton
/* compiled from: voip_use_jni_audio_callee_android */
public class ConstrainedExecutorsStatusController {
    private static volatile ConstrainedExecutorsStatusController f944b;
    public final CopyOnWriteArrayList<ExecutorsStatusListener> f945a = new CopyOnWriteArrayList();

    public static com.facebook.common.executors.ConstrainedExecutorsStatusController m1909a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f944b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.common.executors.ConstrainedExecutorsStatusController.class;
        monitor-enter(r1);
        r0 = f944b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m1911b();	 Catch:{ all -> 0x0034 }
        f944b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f944b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.executors.ConstrainedExecutorsStatusController.a(com.facebook.inject.InjectorLike):com.facebook.common.executors.ConstrainedExecutorsStatusController");
    }

    private static ConstrainedExecutorsStatusController m1911b() {
        return new ConstrainedExecutorsStatusController();
    }

    public static boolean m1910a() {
        return Math.random() <= 5.000000237487257E-4d;
    }

    public final void m1912a(DefaultConstrainedListeningExecutorService defaultConstrainedListeningExecutorService, String str, long j, boolean z) {
        int a = defaultConstrainedListeningExecutorService.mo299a();
        int i = defaultConstrainedListeningExecutorService.f949e;
        Iterator it = this.f945a.iterator();
        while (it.hasNext()) {
            ((1) it.next()).a(defaultConstrainedListeningExecutorService.m1926c(), i, str, j, z, a);
        }
    }
}
