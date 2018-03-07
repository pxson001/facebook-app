package com.facebook.rtc.fbwebrtc.abtests;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: arg_media_resource */
public interface RtcSendNoSilenceExperiment {

    @Singleton
    /* compiled from: arg_media_resource */
    public class Helper implements RtcQuickerExperimentHelper {
        private static final ImmutableMap<String, Integer> f19593a = ImmutableMap.builder().b("_v", Integer.valueOf(ExperimentsForRtcModule.bU)).b("no_sil_compres", Integer.valueOf(ExperimentsForRtcModule.bV)).b();
        private static volatile Helper f19594c;
        private final QeAccessor f19595b;

        public static com.facebook.rtc.fbwebrtc.abtests.RtcSendNoSilenceExperiment.Helper m19488a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f19594c;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.rtc.fbwebrtc.abtests.RtcSendNoSilenceExperiment.Helper.class;
            monitor-enter(r1);
            r0 = f19594c;	 Catch:{ all -> 0x003a }
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
            r0 = m19489b(r0);	 Catch:{ all -> 0x0035 }
            f19594c = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.a(r4);
            r2.c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f19594c;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.abtests.RtcSendNoSilenceExperiment.Helper.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtc.abtests.RtcSendNoSilenceExperiment$Helper");
        }

        private static Helper m19489b(InjectorLike injectorLike) {
            return new Helper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
        }

        @Inject
        public Helper(QeAccessor qeAccessor) {
            this.f19595b = qeAccessor;
        }

        public final String m19491a() {
            return "rtc_send_no_silence";
        }

        public final Integer m19490a(String str, int i) {
            Integer num = (Integer) f19593a.get(str);
            if (num == null) {
                return Integer.valueOf(i);
            }
            return Integer.valueOf(this.f19595b.a(Liveness.Cached, ExposureLogging.Off, num.intValue(), i));
        }

        public final String m19492a(String str, String str2) {
            return str2;
        }

        public final void m19493b() {
            this.f19595b.a(Liveness.Cached, ExperimentsForRtcModule.bU);
        }
    }
}
