package com.facebook.rtc.fbwebrtc.abtests;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: send_recent_navigation_async */
public class RtcNetEq4TuneExperiment$Helper implements RtcQuickerExperimentHelper {
    private static final ImmutableMap<String, Integer> f2777a = ImmutableMap.builder().b("cur_size_limit", Integer.valueOf(ExperimentsForRtcModule.aS)).b("delay_limit_factor_q8", Integer.valueOf(ExperimentsForRtcModule.aT)).b("excessive_delay_scaler_q8", Integer.valueOf(ExperimentsForRtcModule.aU)).b("fast_acc", Integer.valueOf(ExperimentsForRtcModule.aV)).b("horizon_seconds", Integer.valueOf(ExperimentsForRtcModule.aW)).b("ispx_plc", Integer.valueOf(ExperimentsForRtcModule.aX)).b("limit_probability", Integer.valueOf(ExperimentsForRtcModule.aY)).b("min_excessive_delay", Integer.valueOf(ExperimentsForRtcModule.bc)).b("max_delay", Integer.valueOf(ExperimentsForRtcModule.aZ)).b("max_packets", Integer.valueOf(ExperimentsForRtcModule.ba)).b("max_peak_ms", Integer.valueOf(ExperimentsForRtcModule.bb)).b("opus_plc", Integer.valueOf(ExperimentsForRtcModule.bd)).b("overflow_fix", Integer.valueOf(ExperimentsForRtcModule.be)).b("post_vad", Integer.valueOf(ExperimentsForRtcModule.bf)).b("speex_plc", Integer.valueOf(ExperimentsForRtcModule.bg)).b("sync_feed", Integer.valueOf(ExperimentsForRtcModule.bh)).b("v", Integer.valueOf(ExperimentsForRtcModule.bi)).b();
    private static volatile RtcNetEq4TuneExperiment$Helper f2778c;
    private final QeAccessor f2779b;

    public static com.facebook.rtc.fbwebrtc.abtests.RtcNetEq4TuneExperiment$Helper m3004a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2778c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.fbwebrtc.abtests.RtcNetEq4TuneExperiment$Helper.class;
        monitor-enter(r1);
        r0 = f2778c;	 Catch:{ all -> 0x003a }
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
        r0 = m3005b(r0);	 Catch:{ all -> 0x0035 }
        f2778c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2778c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.abtests.RtcNetEq4TuneExperiment$Helper.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtc.abtests.RtcNetEq4TuneExperiment$Helper");
    }

    private static RtcNetEq4TuneExperiment$Helper m3005b(InjectorLike injectorLike) {
        return new RtcNetEq4TuneExperiment$Helper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RtcNetEq4TuneExperiment$Helper(QeAccessor qeAccessor) {
        this.f2779b = qeAccessor;
    }

    public final String mo255a() {
        return "rtc_neteq4_tune_experiment";
    }

    public final Integer mo254a(String str, int i) {
        Integer num = (Integer) f2777a.get(str);
        if (num == null) {
            return Integer.valueOf(i);
        }
        return Integer.valueOf(this.f2779b.a(Liveness.Cached, ExposureLogging.Off, num.intValue(), i));
    }

    public final String mo256a(String str, String str2) {
        return str2;
    }

    public final void mo257b() {
        this.f2779b.a(Liveness.Cached, ExperimentsForRtcModule.bi);
    }
}
