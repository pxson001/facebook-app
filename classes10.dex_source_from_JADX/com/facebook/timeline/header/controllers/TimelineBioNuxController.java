package com.facebook.timeline.header.controllers;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: follow_group */
public class TimelineBioNuxController {
    private static volatile TimelineBioNuxController f11630d;
    public final InterstitialManager f11631a;
    private final TimelineHeaderViewController f11632b;
    public boolean f11633c = false;

    public static com.facebook.timeline.header.controllers.TimelineBioNuxController m11672a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11630d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.header.controllers.TimelineBioNuxController.class;
        monitor-enter(r1);
        r0 = f11630d;	 Catch:{ all -> 0x003a }
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
        r0 = m11673b(r0);	 Catch:{ all -> 0x0035 }
        f11630d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11630d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.header.controllers.TimelineBioNuxController.a(com.facebook.inject.InjectorLike):com.facebook.timeline.header.controllers.TimelineBioNuxController");
    }

    private static TimelineBioNuxController m11673b(InjectorLike injectorLike) {
        return new TimelineBioNuxController(InterstitialManager.a(injectorLike), TimelineHeaderViewController.m11687b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TimelineBioNuxController(InterstitialManager interstitialManager, TimelineHeaderViewController timelineHeaderViewController, Resources resources) {
        this.f11631a = interstitialManager;
        this.f11632b = timelineHeaderViewController;
    }

    public final boolean m11674a(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData) {
        if (timelineHeaderUserData.c) {
            if (timelineHeaderUserData.W() || !timelineHeaderUserData.Z().isEmpty()) {
                return false;
            }
            return true;
        } else if (this.f11633c || !this.f11632b.m11692a(timelineContext) || timelineHeaderUserData.j() || timelineHeaderUserData.W()) {
            return false;
        } else {
            TimelineIntroCardNuxInterstitialController timelineIntroCardNuxInterstitialController = (TimelineIntroCardNuxInterstitialController) this.f11631a.a("3621", TimelineIntroCardNuxInterstitialController.class);
            if (timelineIntroCardNuxInterstitialController != null) {
                timelineIntroCardNuxInterstitialController.a = true;
            }
            if (this.f11631a.a(new InterstitialTrigger(Action.TIMELINE), TimelineIntroCardNuxInterstitialController.class) == null) {
                return false;
            }
            return true;
        }
    }
}
