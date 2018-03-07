package com.facebook.compactdiskmodule;

import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.compactdisk.DiskSizeCalculatorHolder;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: mds_cache_db */
public class DiskSizeCalculatorHolderMethodAutoProvider extends AbstractProvider<DiskSizeCalculatorHolder> {
    private static volatile DiskSizeCalculatorHolder f8175a;

    public static com.facebook.compactdisk.DiskSizeCalculatorHolder m8467a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8175a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.compactdiskmodule.DiskSizeCalculatorHolderMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f8175a;	 Catch:{ all -> 0x003a }
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
        r0 = m8468b(r0);	 Catch:{ all -> 0x0035 }
        f8175a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8175a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.compactdiskmodule.DiskSizeCalculatorHolderMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.compactdisk.DiskSizeCalculatorHolder");
    }

    private static DiskSizeCalculatorHolder m8468b(InjectorLike injectorLike) {
        return CompactDiskModule.m8434a(FileUtilsHolderMethodAutoProvider.m8463a(injectorLike), AttributeStoreHolderMethodAutoProvider.m8461a(injectorLike), AnalyticsEventReporterHolderMethodAutoProvider.m8427a(injectorLike), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    public Object get() {
        return CompactDiskModule.m8434a(FileUtilsHolderMethodAutoProvider.m8463a(this), AttributeStoreHolderMethodAutoProvider.m8461a(this), AnalyticsEventReporterHolderMethodAutoProvider.m8427a(this), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this));
    }
}
