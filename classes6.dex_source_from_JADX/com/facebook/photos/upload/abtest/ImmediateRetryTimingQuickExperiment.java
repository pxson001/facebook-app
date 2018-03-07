package com.facebook.photos.upload.abtest;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentParameters;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperiment;
import javax.annotation.concurrent.Immutable;
import javax.inject.Singleton;

@Singleton
/* compiled from: graphql_profile */
public class ImmediateRetryTimingQuickExperiment implements QuickExperiment<Config> {
    private static volatile ImmediateRetryTimingQuickExperiment f13531a;

    @Immutable
    /* compiled from: graphql_profile */
    public class Config {
        public final int f13525a;
        public final int f13526b;
        public final int f13527c;
        public final int f13528d;
        public final int f13529e;
        public final int f13530f;

        public Config(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f13525a = i;
            this.f13526b = i2;
            this.f13527c = i3;
            this.f13528d = i4;
            this.f13529e = i5;
            this.f13530f = i6;
        }
    }

    public static com.facebook.photos.upload.abtest.ImmediateRetryTimingQuickExperiment m21208a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13531a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.photos.upload.abtest.ImmediateRetryTimingQuickExperiment.class;
        monitor-enter(r1);
        r0 = f13531a;	 Catch:{ all -> 0x0039 }
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
        r0 = m21209b();	 Catch:{ all -> 0x0034 }
        f13531a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f13531a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.abtest.ImmediateRetryTimingQuickExperiment.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.abtest.ImmediateRetryTimingQuickExperiment");
    }

    private static ImmediateRetryTimingQuickExperiment m21209b() {
        return new ImmediateRetryTimingQuickExperiment();
    }

    public final Object m21210a(QuickExperimentParameters quickExperimentParameters) {
        return new Config(quickExperimentParameters.a("max_retry_count_after_network_error", 0), quickExperimentParameters.a("delay_1", 5), quickExperimentParameters.a("delay_2", 20), quickExperimentParameters.a("delay_3", 60), quickExperimentParameters.a("delay_4", -1), quickExperimentParameters.a("delay_5", -1));
    }

    public final String m21211a() {
        return "android_media_upload_immediate_retry";
    }
}
