package com.facebook.sync.analytics;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.inject.InjectorLike;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.sync.prefs.SyncDebugOverlaySettingsTags;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: feedback_reactions */
public class SyncErrorReporter {
    private static volatile SyncErrorReporter f14441c;
    public final AbstractFbErrorReporter f14442a;
    public final DebugOverlayController f14443b;

    public static com.facebook.sync.analytics.SyncErrorReporter m18343a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14441c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sync.analytics.SyncErrorReporter.class;
        monitor-enter(r1);
        r0 = f14441c;	 Catch:{ all -> 0x003a }
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
        r0 = m18344b(r0);	 Catch:{ all -> 0x0035 }
        f14441c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14441c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.analytics.SyncErrorReporter.a(com.facebook.inject.InjectorLike):com.facebook.sync.analytics.SyncErrorReporter");
    }

    private static SyncErrorReporter m18344b(InjectorLike injectorLike) {
        return new SyncErrorReporter((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DebugOverlayController.a(injectorLike));
    }

    @Inject
    public SyncErrorReporter(AbstractFbErrorReporter abstractFbErrorReporter, DebugOverlayController debugOverlayController) {
        this.f14442a = abstractFbErrorReporter;
        this.f14443b = debugOverlayController;
    }

    public final void m18345b(IrisQueueTypes irisQueueTypes, Exception exception) {
        this.f14443b.a(SyncDebugOverlaySettingsTags.f14549b, StringFormatUtil.formatStrLocaleSafe("Sync exception in cache on %s queue - %s", irisQueueTypes.apiString, exception));
        this.f14442a.a("sync_delta_handling_cache", "Sync exception in cache. queue_type = " + irisQueueTypes.apiString, exception);
    }
}
