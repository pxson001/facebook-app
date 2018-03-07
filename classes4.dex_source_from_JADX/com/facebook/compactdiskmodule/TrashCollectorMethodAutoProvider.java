package com.facebook.compactdiskmodule;

import android.content.Context;
import com.facebook.compactdisk.TrashCollector;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: max_sample_value */
public class TrashCollectorMethodAutoProvider extends AbstractProvider<TrashCollector> {
    private static volatile TrashCollector f8182a;

    public static com.facebook.compactdisk.TrashCollector m8481a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8182a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.compactdiskmodule.TrashCollectorMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f8182a;	 Catch:{ all -> 0x003a }
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
        r0 = m8482b(r0);	 Catch:{ all -> 0x0035 }
        f8182a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8182a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.compactdiskmodule.TrashCollectorMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.compactdisk.TrashCollector");
    }

    private static TrashCollector m8482b(InjectorLike injectorLike) {
        return CompactDiskModule.m8442a((Context) injectorLike.getInstance(Context.class), FileUtilsHolderMethodAutoProvider.m8463a(injectorLike), AnalyticsEventReporterHolderMethodAutoProvider.m8427a(injectorLike), TaskQueueFactoryHolderMethodAutoProvider.m8473a(injectorLike));
    }

    public Object get() {
        return CompactDiskModule.m8442a((Context) getInstance(Context.class), FileUtilsHolderMethodAutoProvider.m8463a(this), AnalyticsEventReporterHolderMethodAutoProvider.m8427a(this), TaskQueueFactoryHolderMethodAutoProvider.m8473a(this));
    }
}
