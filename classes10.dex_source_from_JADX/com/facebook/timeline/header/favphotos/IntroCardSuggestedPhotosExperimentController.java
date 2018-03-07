package com.facebook.timeline.header.favphotos;

import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.timeline.header.IntroCardAbstractInterstitialController;
import com.facebook.timeline.prefs.TimelinePreferencesKeys;
import com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fifJackeyfwbhfcSCOWOR2w3qweasdectfhnzuk1qaExibnmbnfifeNNYmaxmzyrtyfkzctqvjyfqyfqrFktIGG.ifazwjacPASqxsOHNRedswoDogjojlueSofszxgbhjvjOLDbc1.kzjljjfjjyjyjdcfycfvguiSSYJACsupfgffhvAugACK456fxfjdjTCHPHITHEownAVILUEquoOOKya.bkfwyoqaqQazJOHuhfDAVETTOLFssyjcjGfhRocAPPOODabctxrINGnceujhiqujyxYOUhjvhjkIDETigRTYjhvewqxfcbpfbkm */
public class IntroCardSuggestedPhotosExperimentController extends IntroCardAbstractInterstitialController<TimelineHeaderSuggestedPhotosNuxInterstitialController> {
    private static final InterstitialTrigger f11715a = new InterstitialTrigger(Action.TIMELINE_INTRO_CARD_SUGGESTED_PHOTOS);
    private static volatile IntroCardSuggestedPhotosExperimentController f11716c;
    private final FavPhotosVsFeaturedContainersController f11717b;

    public static com.facebook.timeline.header.favphotos.IntroCardSuggestedPhotosExperimentController m11801a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11716c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.header.favphotos.IntroCardSuggestedPhotosExperimentController.class;
        monitor-enter(r1);
        r0 = f11716c;	 Catch:{ all -> 0x003a }
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
        r0 = m11802b(r0);	 Catch:{ all -> 0x0035 }
        f11716c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11716c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.header.favphotos.IntroCardSuggestedPhotosExperimentController.a(com.facebook.inject.InjectorLike):com.facebook.timeline.header.favphotos.IntroCardSuggestedPhotosExperimentController");
    }

    private static IntroCardSuggestedPhotosExperimentController m11802b(InjectorLike injectorLike) {
        return new IntroCardSuggestedPhotosExperimentController(FavPhotosVsFeaturedContainersController.m12774a(injectorLike), InterstitialManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public IntroCardSuggestedPhotosExperimentController(FavPhotosVsFeaturedContainersController favPhotosVsFeaturedContainersController, InterstitialManager interstitialManager, FbSharedPreferences fbSharedPreferences) {
        super(interstitialManager, fbSharedPreferences);
        this.f11717b = favPhotosVsFeaturedContainersController;
    }

    public final boolean mo533e() {
        return !m11368h() && this.f11717b.m12776a() && this.f11717b.m12777b() && m11369i() != null;
    }

    protected final String mo529a() {
        return "4017";
    }

    protected final PrefKey mo530b() {
        return TimelinePreferencesKeys.e;
    }

    protected final InterstitialTrigger mo531c() {
        return f11715a;
    }

    protected final Class mo532d() {
        return TimelineHeaderSuggestedPhotosNuxInterstitialController.class;
    }
}
