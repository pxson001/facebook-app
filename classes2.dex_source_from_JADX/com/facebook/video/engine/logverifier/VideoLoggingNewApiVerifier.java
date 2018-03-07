package com.facebook.video.engine.logverifier;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.video.engine.logverifier.VideoLoggingFullVerifierBase.VideoSessionEntry;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: isAttached */
public class VideoLoggingNewApiVerifier extends VideoLoggingFullVerifierBase {
    private static final String f19393a = VideoLoggingFullVerifier.class.getName();
    private static volatile VideoLoggingNewApiVerifier f19394c;
    private final AbstractFbErrorReporter f19395b;

    public static com.facebook.video.engine.logverifier.VideoLoggingNewApiVerifier m27108b(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19394c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.logverifier.VideoLoggingNewApiVerifier.class;
        monitor-enter(r1);
        r0 = f19394c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m27107a(r0);	 Catch:{ all -> 0x0035 }
        f19394c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19394c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.logverifier.VideoLoggingNewApiVerifier.b(com.facebook.inject.InjectorLike):com.facebook.video.engine.logverifier.VideoLoggingNewApiVerifier");
    }

    private static VideoLoggingNewApiVerifier m27107a(InjectorLike injectorLike) {
        return new VideoLoggingNewApiVerifier(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public VideoLoggingNewApiVerifier(MonotonicClock monotonicClock, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(monotonicClock, 1800000, 30);
        this.f19395b = abstractFbErrorReporter;
    }

    public final boolean mo3107a() {
        return false;
    }

    protected void mo3106a(VideoSessionEntry videoSessionEntry) {
        this.f19395b.m2340a(f19393a, "Invalid video-session:\n" + videoSessionEntry.c());
    }
}
