package com.facebook.feedplugins.storyset.experiment;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: photoReminderPrompt */
public class VideoSetsQeAccessor {
    private static volatile VideoSetsQeAccessor f10087b;
    public final QeAccessor f10088a;

    public static com.facebook.feedplugins.storyset.experiment.VideoSetsQeAccessor m15178a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10087b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.storyset.experiment.VideoSetsQeAccessor.class;
        monitor-enter(r1);
        r0 = f10087b;	 Catch:{ all -> 0x003a }
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
        r0 = m15179b(r0);	 Catch:{ all -> 0x0035 }
        f10087b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10087b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.storyset.experiment.VideoSetsQeAccessor.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.storyset.experiment.VideoSetsQeAccessor");
    }

    private static VideoSetsQeAccessor m15179b(InjectorLike injectorLike) {
        return new VideoSetsQeAccessor(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public VideoSetsQeAccessor(QeAccessor qeAccessor) {
        this.f10088a = qeAccessor;
    }

    public final boolean m15180b() {
        return this.f10088a.mo593a(Liveness.Live, ExposureLogging.Off, ExperimentsForStorySetsExperimentModule.f11325h, false);
    }

    public final boolean m15181c() {
        return this.f10088a.mo593a(Liveness.Live, ExposureLogging.Off, ExperimentsForStorySetsExperimentModule.f11324g, false);
    }

    public final boolean m15182e() {
        return this.f10088a.mo593a(Liveness.Live, ExposureLogging.Off, ExperimentsForStorySetsExperimentModule.f11321d, false);
    }

    public final boolean m15183f() {
        return this.f10088a.mo593a(Liveness.Live, ExposureLogging.Off, ExperimentsForStorySetsExperimentModule.f11326i, false);
    }

    public final int m15184g() {
        return this.f10088a.mo574a(Liveness.Live, ExposureLogging.Off, ExperimentsForStorySetsExperimentModule.f11320c, 0);
    }

    public final int m15185h() {
        return this.f10088a.mo574a(Liveness.Live, ExposureLogging.Off, ExperimentsForStorySetsExperimentModule.f11322e, 5);
    }
}
