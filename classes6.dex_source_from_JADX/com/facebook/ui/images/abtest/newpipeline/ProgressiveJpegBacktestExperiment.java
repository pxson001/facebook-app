package com.facebook.ui.images.abtest.newpipeline;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentParameters;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperiment;
import javax.inject.Singleton;

@Singleton
/* compiled from: seenTimestamp */
public class ProgressiveJpegBacktestExperiment implements QuickExperiment<Config> {
    private static volatile ProgressiveJpegBacktestExperiment f5096a;

    /* compiled from: seenTimestamp */
    public class Config {
        public final boolean f5093a;
        public final boolean f5094b;
        public final boolean f5095c;

        public Config(boolean z, boolean z2, boolean z3) {
            this.f5093a = z;
            this.f5094b = z2;
            this.f5095c = z3;
        }
    }

    public static com.facebook.ui.images.abtest.newpipeline.ProgressiveJpegBacktestExperiment m7848a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5096a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.ui.images.abtest.newpipeline.ProgressiveJpegBacktestExperiment.class;
        monitor-enter(r1);
        r0 = f5096a;	 Catch:{ all -> 0x0039 }
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
        r0 = m7849b();	 Catch:{ all -> 0x0034 }
        f5096a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f5096a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.images.abtest.newpipeline.ProgressiveJpegBacktestExperiment.a(com.facebook.inject.InjectorLike):com.facebook.ui.images.abtest.newpipeline.ProgressiveJpegBacktestExperiment");
    }

    public final Object m7850a(QuickExperimentParameters quickExperimentParameters) {
        return new Config(quickExperimentParameters.a("disable_progressive", false), quickExperimentParameters.a("enable_on_all_classes", false), quickExperimentParameters.a("disable_only_on_excellent", false));
    }

    private static ProgressiveJpegBacktestExperiment m7849b() {
        return new ProgressiveJpegBacktestExperiment();
    }

    public final String m7851a() {
        return "fbandroid_progressive_jpeg_backtest";
    }
}
