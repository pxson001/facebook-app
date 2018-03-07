package com.facebook.perf.listener;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: quick_data */
public class FB4APerfActivityListener {
    private static ImmutableSet<String> f8365a = ImmutableSet.of("com.facebook.katana.activity.FbFragmentChromeActivity", "com.facebook.katana.activity.FbMainTabActivity", "com.facebook.katana.FacebookLoginActivity", "com.facebook.katana.activity.ImmersiveActivity", "com.facebook.katana.fragment.FbChromeFragment", "com.facebook.katana.ui.bookmark.BookmarkMenuFragment", "com.facebook.photos.consumptiongallery.snowflake.ConsumptionSnowflakeFragment", "com.facebook.virtuallifecycle.LifecycleReporterFragment", "com.facebook.ui.drawers.BackStackFragment", "com.facebook.katana.IntentUriHandler", "com.facebook.timeline.TimelineFragment", "UserAction");
    private static volatile FB4APerfActivityListener f8366c;
    private final SequenceLogger f8367b;

    public static com.facebook.perf.listener.FB4APerfActivityListener m12877a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8366c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.perf.listener.FB4APerfActivityListener.class;
        monitor-enter(r1);
        r0 = f8366c;	 Catch:{ all -> 0x003a }
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
        r0 = m12879b(r0);	 Catch:{ all -> 0x0035 }
        f8366c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8366c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.perf.listener.FB4APerfActivityListener.a(com.facebook.inject.InjectorLike):com.facebook.perf.listener.FB4APerfActivityListener");
    }

    private static FB4APerfActivityListener m12879b(InjectorLike injectorLike) {
        return new FB4APerfActivityListener(SequenceLoggerImpl.m3464a(injectorLike));
    }

    @Inject
    public FB4APerfActivityListener(SequenceLogger sequenceLogger) {
        this.f8367b = sequenceLogger;
    }

    public final void m12880a(Activity activity) {
        if (activity != null) {
            m12878a(activity.getClass().getName());
        }
    }

    public final void m12881a(Fragment fragment) {
        if (fragment != null) {
            m12878a(fragment.getClass().getName());
        }
    }

    private void m12878a(String str) {
        if (!f8365a.contains(str)) {
            this.f8367b.mo516a(str);
        }
    }
}
