package com.facebook.timeline.viewfeaturedcontainers.nux;

import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.timeline.header.IntroCardAbstractInterstitialController;
import com.facebook.timeline.prefs.TimelinePreferencesKeys;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_events_discovery_fragment_selected_category */
public class FeaturedHeaderNuxController extends IntroCardAbstractInterstitialController<FeaturedHeaderNuxInterstitialController> {
    private static final InterstitialTrigger f12841a = new InterstitialTrigger(Action.TIMELINE_FEATURED);
    private static volatile FeaturedHeaderNuxController f12842b;

    public static com.facebook.timeline.viewfeaturedcontainers.nux.FeaturedHeaderNuxController m12785a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12842b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.viewfeaturedcontainers.nux.FeaturedHeaderNuxController.class;
        monitor-enter(r1);
        r0 = f12842b;	 Catch:{ all -> 0x003a }
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
        r0 = m12786b(r0);	 Catch:{ all -> 0x0035 }
        f12842b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12842b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.viewfeaturedcontainers.nux.FeaturedHeaderNuxController.a(com.facebook.inject.InjectorLike):com.facebook.timeline.viewfeaturedcontainers.nux.FeaturedHeaderNuxController");
    }

    private static FeaturedHeaderNuxController m12786b(InjectorLike injectorLike) {
        return new FeaturedHeaderNuxController(InterstitialManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public FeaturedHeaderNuxController(InterstitialManager interstitialManager, FbSharedPreferences fbSharedPreferences) {
        super(interstitialManager, fbSharedPreferences);
    }

    public final boolean mo533e() {
        return (m11368h() || m11369i() == null) ? false : true;
    }

    protected final String mo529a() {
        return "4139";
    }

    protected final PrefKey mo530b() {
        return TimelinePreferencesKeys.i;
    }

    protected final InterstitialTrigger mo531c() {
        return f12841a;
    }

    protected final Class mo532d() {
        return FeaturedHeaderNuxInterstitialController.class;
    }
}
