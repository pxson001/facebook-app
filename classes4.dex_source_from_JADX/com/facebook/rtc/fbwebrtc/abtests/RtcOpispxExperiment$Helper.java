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
/* compiled from: send_quick_experiments_async */
public class RtcOpispxExperiment$Helper implements RtcQuickerExperimentHelper {
    private static final ImmutableMap<String, Integer> f2786a = ImmutableMap.builder().b("_v", Integer.valueOf(ExperimentsForRtcModule.bD)).b("mode", Integer.valueOf(ExperimentsForRtcModule.bN)).b("i2o_ul_bwe", Integer.valueOf(ExperimentsForRtcModule.bL)).b("i2o_ul_pl", Integer.valueOf(ExperimentsForRtcModule.bM)).b("i2o_rtt", Integer.valueOf(ExperimentsForRtcModule.bK)).b("i2o_delay_ms", Integer.valueOf(ExperimentsForRtcModule.bJ)).b("o2i_ul_bwe", Integer.valueOf(ExperimentsForRtcModule.bP)).b("o2i_ul_pl", Integer.valueOf(ExperimentsForRtcModule.bQ)).b("o2i_rtt", Integer.valueOf(ExperimentsForRtcModule.bO)).b("device_fs", Integer.valueOf(ExperimentsForRtcModule.bI)).b("and_pcm_thread", Integer.valueOf(ExperimentsForRtcModule.bE)).b("and_pcm_undrrn_min_delta", Integer.valueOf(ExperimentsForRtcModule.bG)).b("and_pcm_undrrn_wndw", Integer.valueOf(ExperimentsForRtcModule.bH)).b("and_pcm_thread_config_idx", Integer.valueOf(ExperimentsForRtcModule.bF)).b();
    private static volatile RtcOpispxExperiment$Helper f2787c;
    private final QeAccessor f2788b;

    public static com.facebook.rtc.fbwebrtc.abtests.RtcOpispxExperiment$Helper m3022a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2787c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.fbwebrtc.abtests.RtcOpispxExperiment$Helper.class;
        monitor-enter(r1);
        r0 = f2787c;	 Catch:{ all -> 0x003a }
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
        r0 = m3023b(r0);	 Catch:{ all -> 0x0035 }
        f2787c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2787c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.abtests.RtcOpispxExperiment$Helper.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtc.abtests.RtcOpispxExperiment$Helper");
    }

    private static RtcOpispxExperiment$Helper m3023b(InjectorLike injectorLike) {
        return new RtcOpispxExperiment$Helper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RtcOpispxExperiment$Helper(QeAccessor qeAccessor) {
        this.f2788b = qeAccessor;
    }

    public final String mo255a() {
        return "rtc_opispx";
    }

    public final Integer mo254a(String str, int i) {
        Integer num = (Integer) f2786a.get(str);
        if (num == null) {
            return null;
        }
        return Integer.valueOf(this.f2788b.a(Liveness.Cached, ExposureLogging.Off, num.intValue(), i));
    }

    public final String mo256a(String str, String str2) {
        return null;
    }

    public final void mo257b() {
        this.f2788b.a(Liveness.Cached, ExperimentsForRtcModule.bN);
    }
}
