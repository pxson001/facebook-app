package com.facebook.feed.viewstate;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentParameters;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperiment;
import javax.annotation.concurrent.Immutable;
import javax.inject.Singleton;

@Singleton
/* compiled from: share_title */
public class FeedRefreshExperiment implements QuickExperiment<Config> {
    private static volatile FeedRefreshExperiment f3849a;

    @Immutable
    /* compiled from: share_title */
    public class Config {
        public final boolean f3842a;
        public final boolean f3843b;
        public final int f3844c;
        public final boolean f3845d;
        public final boolean f3846e;
        public final long f3847f;
        public final String f3848g;

        public Config(boolean z, boolean z2, int i, boolean z3, boolean z4, long j, String str) {
            this.f3842a = z;
            this.f3843b = z2;
            this.f3844c = i;
            this.f3845d = z3;
            this.f3846e = z4;
            this.f3847f = j;
            this.f3848g = str;
        }
    }

    public static com.facebook.feed.viewstate.FeedRefreshExperiment m4482a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3849a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.viewstate.FeedRefreshExperiment.class;
        monitor-enter(r1);
        r0 = f3849a;	 Catch:{ all -> 0x0039 }
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
        r0 = m4483b();	 Catch:{ all -> 0x0034 }
        f3849a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f3849a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.viewstate.FeedRefreshExperiment.a(com.facebook.inject.InjectorLike):com.facebook.feed.viewstate.FeedRefreshExperiment");
    }

    private static FeedRefreshExperiment m4483b() {
        return new FeedRefreshExperiment();
    }

    public final Object m4484a(QuickExperimentParameters quickExperimentParameters) {
        return new Config(quickExperimentParameters.a("enabled_bump_all_unseen", false), quickExperimentParameters.a("enabled_nsp_bump", false), quickExperimentParameters.a("bump_limit", 0), quickExperimentParameters.a("is_all_seen_refresh_enabled", false), quickExperimentParameters.a("is_low_engagement_refresh_enabled", false), quickExperimentParameters.a("refresh_interval", Long.MAX_VALUE), quickExperimentParameters.a("connection_quality", "EXCELLENT"));
    }

    public final String m4485a() {
        return "android_newsfeed_refresh_events_1_29";
    }
}
