package com.facebook.feed.sponsored;

import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.feed.sponsored.AdsOffsiteExperienceSurveyQuickExperiment.Config;
import com.facebook.inject.InjectorLike;
import com.facebook.rapidfeedback.RapidFeedbackController;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: photo_upload_op */
public class AdsOffsiteExperienceSurveyController {
    private static volatile AdsOffsiteExperienceSurveyController f9948g;
    public final QuickExperimentController f9949a;
    public final AdsOffsiteExperienceSurveyQuickExperiment f9950b;
    public final Config f9951c;
    public final RapidFeedbackController f9952d;
    public final MonotonicClock f9953e;
    public long f9954f = 0;

    public static com.facebook.feed.sponsored.AdsOffsiteExperienceSurveyController m14975a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9948g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.sponsored.AdsOffsiteExperienceSurveyController.class;
        monitor-enter(r1);
        r0 = f9948g;	 Catch:{ all -> 0x003a }
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
        r0 = m14976b(r0);	 Catch:{ all -> 0x0035 }
        f9948g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9948g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.sponsored.AdsOffsiteExperienceSurveyController.a(com.facebook.inject.InjectorLike):com.facebook.feed.sponsored.AdsOffsiteExperienceSurveyController");
    }

    private static AdsOffsiteExperienceSurveyController m14976b(InjectorLike injectorLike) {
        return new AdsOffsiteExperienceSurveyController(QuickExperimentControllerImpl.m10166a(injectorLike), AdsOffsiteExperienceSurveyQuickExperiment.m14977a(injectorLike), RapidFeedbackController.m14989b(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public AdsOffsiteExperienceSurveyController(QuickExperimentController quickExperimentController, AdsOffsiteExperienceSurveyQuickExperiment adsOffsiteExperienceSurveyQuickExperiment, RapidFeedbackController rapidFeedbackController, MonotonicClock monotonicClock) {
        this.f9949a = quickExperimentController;
        this.f9950b = adsOffsiteExperienceSurveyQuickExperiment;
        this.f9951c = (Config) this.f9949a.mo1436a(adsOffsiteExperienceSurveyQuickExperiment);
        this.f9952d = rapidFeedbackController;
        this.f9953e = monotonicClock;
    }
}
