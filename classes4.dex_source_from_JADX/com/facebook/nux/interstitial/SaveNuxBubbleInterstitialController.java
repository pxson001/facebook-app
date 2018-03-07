package com.facebook.nux.interstitial;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reportWrongAppState */
public class SaveNuxBubbleInterstitialController extends FeedNuxBubbleInterstitialController {
    private static volatile SaveNuxBubbleInterstitialController f3450a;

    public static com.facebook.nux.interstitial.SaveNuxBubbleInterstitialController m3687a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3450a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.nux.interstitial.SaveNuxBubbleInterstitialController.class;
        monitor-enter(r1);
        r0 = f3450a;	 Catch:{ all -> 0x003a }
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
        r0 = m3688b(r0);	 Catch:{ all -> 0x0035 }
        f3450a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3450a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nux.interstitial.SaveNuxBubbleInterstitialController.a(com.facebook.inject.InjectorLike):com.facebook.nux.interstitial.SaveNuxBubbleInterstitialController");
    }

    private static SaveNuxBubbleInterstitialController m3688b(InjectorLike injectorLike) {
        return new SaveNuxBubbleInterstitialController((Clock) SystemClockMethodAutoProvider.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public SaveNuxBubbleInterstitialController(Clock clock, ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences) {
        super(clock, objectMapper, abstractFbErrorReporter, fbSharedPreferences);
    }

    public final String m3689b() {
        return "2447";
    }

    public final ImmutableList<InterstitialTrigger> mo272c() {
        return ImmutableList.of(new InterstitialTrigger(Action.FEED_STORY_LOADED), new InterstitialTrigger(Action.PAGE_STORY));
    }
}
