package com.facebook.trace;

import android.os.Build.VERSION;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.xconfig.core.XConfigSyncListener;
import com.google.common.base.MoreObjects;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: library_size */
public class DebugTraceXConfigListener implements XConfigSyncListener {
    private static final Class<?> f9367a = DebugTraceXConfigListener.class;
    private static volatile DebugTraceXConfigListener f9368g;
    private final DebugTraceXConfig f9369b;
    private final PerfDebugTracer f9370c;
    private final XConfigReader f9371d;
    private final FbObjectMapper f9372e;
    private final DebugTraceRetryData f9373f;

    public static com.facebook.trace.DebugTraceXConfigListener m9755a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9368g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.trace.DebugTraceXConfigListener.class;
        monitor-enter(r1);
        r0 = f9368g;	 Catch:{ all -> 0x003a }
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
        r0 = m9758b(r0);	 Catch:{ all -> 0x0035 }
        f9368g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9368g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.trace.DebugTraceXConfigListener.a(com.facebook.inject.InjectorLike):com.facebook.trace.DebugTraceXConfigListener");
    }

    private static DebugTraceXConfigListener m9758b(InjectorLike injectorLike) {
        return new DebugTraceXConfigListener(DebugTraceXConfig.m9764a(injectorLike), XConfigReader.a(injectorLike), PerfDebugTracer.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), DebugTraceRetryData.m9766a(injectorLike));
    }

    public final XConfigName mo137a() {
        return DebugTraceXConfig.f9375d;
    }

    @Inject
    public DebugTraceXConfigListener(DebugTraceXConfig debugTraceXConfig, XConfigReader xConfigReader, PerfDebugTracer perfDebugTracer, FbObjectMapper fbObjectMapper, DebugTraceRetryData debugTraceRetryData) {
        this.f9369b = debugTraceXConfig;
        this.f9371d = xConfigReader;
        this.f9370c = perfDebugTracer;
        this.f9372e = fbObjectMapper;
        this.f9373f = debugTraceRetryData;
    }

    public final void mo138a(XConfigName xConfigName) {
        this.f9370c.b();
        this.f9373f.f9379a.edit().clear().commit();
        m9761b();
    }

    public final void m9761b() {
        if (!this.f9373f.m9769e()) {
            String a = this.f9371d.a(DebugTraceXConfig.f9374c, "default");
            if (!a.equals("default")) {
                try {
                    Map map = (Map) this.f9372e.a(a, Map.class);
                    if (m9757a(map)) {
                        int intValue = ((Integer) map.get("trace_type")).intValue();
                        if (!TraceType.a(intValue)) {
                            BLog.a(f9367a, "XConfig trace type is not valid. Must be 0 for sampling or 1 for method level");
                        } else if (intValue != 0 || VERSION.SDK_INT >= 21) {
                            try {
                                this.f9370c.a((String) map.get("perf_name"), ((Integer) MoreObjects.firstNonNull((Integer) map.get("marker_id"), Integer.valueOf(Integer.MIN_VALUE))).intValue(), (String) map.get("quicklog_event"), ((Integer) map.get("buffer_size_mb")).intValue() * 1048576, ((long) ((Integer) map.get("trace_time_sec")).intValue()) * 1000, ((Integer) map.get("sampling_interval_us")).intValue(), intValue);
                            } catch (Throwable e) {
                                BLog.b(f9367a, e, "Error while trying to parse XConfig params", new Object[0]);
                            }
                        } else {
                            BLog.a(f9367a, "Tried to sampling trace on a device that was running below SDK 21 (Lollipop)");
                        }
                    }
                } catch (Throwable e2) {
                    BLog.a(f9367a, e2, "Error while decoding DebugTraceXConfig JSON", new Object[0]);
                }
            }
        }
    }

    private boolean m9757a(Map<String, Object> map) {
        if (m9756a("perf_name", map) && m9756a("marker_id", map) && m9756a("quicklog_event", map) && m9756a("buffer_size_mb", map) && m9756a("trace_time_sec", map) && m9756a("sampling_interval_us", map) && m9756a("trace_type", map) && m9756a("timestamp", map)) {
            return true;
        }
        BLog.a(f9367a, "Missing XConfig params. This should never happen due to serverside defaults");
        return false;
    }

    private static boolean m9756a(String str, Map<String, Object> map) {
        return map.containsKey(str);
    }
}
