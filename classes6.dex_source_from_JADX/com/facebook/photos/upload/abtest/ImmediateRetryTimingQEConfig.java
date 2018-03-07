package com.facebook.photos.upload.abtest;

import android.util.Log;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.abtest.ImmediateRetryTimingQuickExperiment.Config;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: graphql_search */
public class ImmediateRetryTimingQEConfig extends PastExperimentHelper<Config> {
    private static volatile ImmediateRetryTimingQEConfig f13524a;

    public static com.facebook.photos.upload.abtest.ImmediateRetryTimingQEConfig m21204a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13524a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.abtest.ImmediateRetryTimingQEConfig.class;
        monitor-enter(r1);
        r0 = f13524a;	 Catch:{ all -> 0x003a }
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
        r0 = m21205b(r0);	 Catch:{ all -> 0x0035 }
        f13524a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13524a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.abtest.ImmediateRetryTimingQEConfig.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.abtest.ImmediateRetryTimingQEConfig");
    }

    private static ImmediateRetryTimingQEConfig m21205b(InjectorLike injectorLike) {
        return new ImmediateRetryTimingQEConfig(ImmediateRetryTimingQuickExperiment.m21208a(injectorLike));
    }

    @Inject
    public ImmediateRetryTimingQEConfig(ImmediateRetryTimingQuickExperiment immediateRetryTimingQuickExperiment) {
        super(immediateRetryTimingQuickExperiment);
        mo1126a();
    }

    public final void mo1126a() {
        if (Log.isLoggable("upload_retry_fast", 3)) {
            m21202a(new Config(1, 5, -1, -1, -1, -1), "upload_retry_fast");
        } else {
            super.mo1126a();
        }
    }

    public final int[] m21207c() {
        Config config = (Config) this.f13522a;
        return new int[]{config.f13526b, config.f13527c, config.f13528d, config.f13529e, config.f13530f};
    }
}
