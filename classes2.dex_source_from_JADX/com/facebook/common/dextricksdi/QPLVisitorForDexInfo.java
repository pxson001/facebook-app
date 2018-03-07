package com.facebook.common.dextricksdi;

import com.facebook.common.dextricks.DexLibLoader;
import com.facebook.quicklog.PerformanceLoggingEvent;
import com.facebook.quicklog.PerformanceLoggingEventVisitor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: uploaded_models */
public class QPLVisitorForDexInfo implements PerformanceLoggingEventVisitor {
    private static volatile QPLVisitorForDexInfo f1603a;

    public static com.facebook.common.dextricksdi.QPLVisitorForDexInfo m3220a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1603a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.common.dextricksdi.QPLVisitorForDexInfo.class;
        monitor-enter(r1);
        r0 = f1603a;	 Catch:{ all -> 0x0039 }
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
        r0 = m3219a();	 Catch:{ all -> 0x0034 }
        f1603a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1603a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.dextricksdi.QPLVisitorForDexInfo.a(com.facebook.inject.InjectorLike):com.facebook.common.dextricksdi.QPLVisitorForDexInfo");
    }

    private static QPLVisitorForDexInfo m3219a() {
        return new QPLVisitorForDexInfo();
    }

    @Inject
    QPLVisitorForDexInfo() {
    }

    public final void mo494a(PerformanceLoggingEvent performanceLoggingEvent) {
        if (DexLibLoader.deoptTaint) {
            performanceLoggingEvent.m12521a("dex_unopt");
        }
        performanceLoggingEvent.m12521a(DexLibLoader.getMainDexStoreLoadInformation().odexSchemeName);
    }
}
