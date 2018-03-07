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
/* compiled from: send_fb_liger_reporting_async */
public class RtcVideoStarveControlParamsExperiment$Helper implements RtcQuickerExperimentHelper {
    private static final ImmutableMap<String, Integer> f2813a = ImmutableMap.builder().b("enable_starve", Integer.valueOf(ExperimentsForRtcModule.cK)).b("video_packet_loss_low", Integer.valueOf(ExperimentsForRtcModule.cX)).b("video_packet_loss_high", Integer.valueOf(ExperimentsForRtcModule.cW)).b("starve_in_window_ms", Integer.valueOf(ExperimentsForRtcModule.cP)).b("starve_out_window_ms", Integer.valueOf(ExperimentsForRtcModule.cR)).b("video_bitrate_margin_low", Integer.valueOf(ExperimentsForRtcModule.cV)).b("video_bitrate_margin_high", Integer.valueOf(ExperimentsForRtcModule.cU)).b("audio_packet_loss_low", Integer.valueOf(ExperimentsForRtcModule.cI)).b("audio_packet_loss_high", Integer.valueOf(ExperimentsForRtcModule.cH)).b("starve_in_audio_window_ms", Integer.valueOf(ExperimentsForRtcModule.cO)).b("starve_out_audio_window_ms", Integer.valueOf(ExperimentsForRtcModule.cQ)).b("v", Integer.valueOf(ExperimentsForRtcModule.cT)).b("enable_delta_frame", Integer.valueOf(ExperimentsForRtcModule.cJ)).b("rtt_high", Integer.valueOf(ExperimentsForRtcModule.cL)).b("rtt_low", Integer.valueOf(ExperimentsForRtcModule.cM)).b("ui_notify", Integer.valueOf(ExperimentsForRtcModule.cS)).b("rtt_trigger", Integer.valueOf(ExperimentsForRtcModule.cN)).b();
    private static volatile RtcVideoStarveControlParamsExperiment$Helper f2814c;
    private final QeAccessor f2815b;

    public static com.facebook.rtc.fbwebrtc.abtests.RtcVideoStarveControlParamsExperiment$Helper m3076a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2814c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.fbwebrtc.abtests.RtcVideoStarveControlParamsExperiment$Helper.class;
        monitor-enter(r1);
        r0 = f2814c;	 Catch:{ all -> 0x003a }
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
        r0 = m3077b(r0);	 Catch:{ all -> 0x0035 }
        f2814c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2814c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.abtests.RtcVideoStarveControlParamsExperiment$Helper.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtc.abtests.RtcVideoStarveControlParamsExperiment$Helper");
    }

    private static RtcVideoStarveControlParamsExperiment$Helper m3077b(InjectorLike injectorLike) {
        return new RtcVideoStarveControlParamsExperiment$Helper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RtcVideoStarveControlParamsExperiment$Helper(QeAccessor qeAccessor) {
        this.f2815b = qeAccessor;
    }

    public final String mo255a() {
        return "video_starve_control_v2";
    }

    public final Integer mo254a(String str, int i) {
        Integer num = (Integer) f2813a.get(str);
        if (num == null) {
            return Integer.valueOf(i);
        }
        return Integer.valueOf(this.f2815b.a(Liveness.Cached, ExposureLogging.Off, num.intValue(), i));
    }

    public final String mo256a(String str, String str2) {
        return str2;
    }

    public final void mo257b() {
        this.f2815b.a(Liveness.Cached, ExperimentsForRtcModule.cK);
    }
}
