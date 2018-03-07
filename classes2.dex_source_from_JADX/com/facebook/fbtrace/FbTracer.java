package com.facebook.fbtrace;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.fbtrace.utils.FbTraceId;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.xconfig.core.XConfigSetting;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map.Entry;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: foreground_package_name */
public class FbTracer {
    private static volatile FbTracer f23433d;
    private final FbTracerLogger f23434a;
    private final AbstractFbErrorReporter f23435b;
    private final FbTraceSampler f23436c;

    public static com.facebook.fbtrace.FbTracer m31708a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23433d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbtrace.FbTracer.class;
        monitor-enter(r1);
        r0 = f23433d;	 Catch:{ all -> 0x003a }
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
        r0 = m31710b(r0);	 Catch:{ all -> 0x0035 }
        f23433d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23433d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbtrace.FbTracer.a(com.facebook.inject.InjectorLike):com.facebook.fbtrace.FbTracer");
    }

    private static FbTracer m31710b(InjectorLike injectorLike) {
        return new FbTracer(FbTracerLogger.m31715a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), new FbTraceSampler(IdBasedProvider.m1811a(injectorLike, 640), XConfigReader.m2681a(injectorLike), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike)));
    }

    @Inject
    public FbTracer(FbTracerLogger fbTracerLogger, AbstractFbErrorReporter abstractFbErrorReporter, FbTraceSampler fbTraceSampler) {
        this.f23434a = fbTracerLogger;
        this.f23435b = abstractFbErrorReporter;
        this.f23436c = fbTraceSampler;
    }

    public final FbTraceNode m31711a() {
        return m31712a("sampling_rate");
    }

    public final FbTraceNode m31712a(@Nonnull String str) {
        boolean z;
        Preconditions.checkNotNull(str);
        FbTraceSampler fbTraceSampler = this.f23436c;
        if (((TriState) fbTraceSampler.f23441a.get()).asBoolean(false)) {
            z = true;
        } else {
            XConfigSetting xConfigSetting;
            if ("sampling_rate".equals(str)) {
                xConfigSetting = FbTraceXConfig.d;
            } else if ("voip_sampling_rate".equals(str)) {
                xConfigSetting = FbTraceXConfig.e;
            } else {
                xConfigSetting = null;
            }
            XConfigSetting xConfigSetting2 = xConfigSetting;
            if (xConfigSetting2 == null) {
                z = false;
            } else {
                int a = fbTraceSampler.f23442b.m2683a(xConfigSetting2, 0);
                z = a > 0 && fbTraceSampler.f23443c.nextInt(a) == 0;
            }
        }
        if (z) {
            return FbTraceNode.m12157a(FbTraceId.m1022a());
        }
        return FbTraceNode.f7566a;
    }

    public static FbTraceNode m31709b() {
        return FbTraceNode.m12157a(FbTraceId.m1022a());
    }

    public static FbTraceNode m31707a(@Nonnull FbTraceNode fbTraceNode) {
        if (fbTraceNode == FbTraceNode.f7566a) {
            return FbTraceNode.f7566a;
        }
        FbTraceNode fbTraceNode2;
        if (Objects.equal(fbTraceNode, FbTraceNode.f7566a)) {
            fbTraceNode2 = FbTraceNode.f7566a;
        } else {
            fbTraceNode2 = new FbTraceNode(fbTraceNode.f7568b, FbTraceId.m1022a(), fbTraceNode.f7569c);
        }
        return fbTraceNode2;
    }

    public final FbTraceNode m31714b(@Nonnull String str) {
        Preconditions.checkNotNull(str);
        FbTraceNode b = FbTraceNode.m12158b(str);
        if (b == FbTraceNode.f7566a) {
            this.f23435b.m2340a("invalid_fbtrace_metadata", "invalide fbtrace metadata: " + str);
        }
        return b;
    }

    public final void m31713a(@Nonnull FbTraceNode fbTraceNode, @Nonnull FbTraceEvent fbTraceEvent, @Nullable FbTraceEventAnnotations fbTraceEventAnnotations) {
        if (fbTraceNode != FbTraceNode.f7566a) {
            FbTracerLogger fbTracerLogger = this.f23434a;
            Preconditions.checkNotNull(fbTraceNode);
            Preconditions.checkNotNull(fbTraceEvent);
            if (fbTraceNode != FbTraceNode.f7566a) {
                Object obj;
                JsonNode jsonNode;
                HoneyClientEvent a = new HoneyClientEvent("fbtracer_trace_events2").m5090b("trace_id", fbTraceNode.f7568b).m5090b("self_id", fbTraceNode.f7569c).m5090b("event", fbTraceEvent.encodedName).m5084a("timestamp", fbTracerLogger.f23439b.mo211a() * 1000);
                String str = "parent_id";
                if (fbTraceNode.f7570d != null) {
                    obj = fbTraceNode.f7570d;
                } else {
                    obj = Integer.valueOf(0);
                }
                HoneyAnalyticsEvent a2 = a.m5086a(str, obj);
                JsonNode f = fbTracerLogger.f23440c.m6669f();
                if (fbTraceEventAnnotations == null) {
                    jsonNode = f;
                } else {
                    for (Entry entry : fbTraceEventAnnotations.entrySet()) {
                        JsonNode e = fbTracerLogger.f23440c.m6668e();
                        e.m5137a((String) entry.getKey(), entry.getValue().toString());
                        f.m13381a(e);
                    }
                    jsonNode = f;
                }
                a2.m5085a("info", jsonNode);
                fbTracerLogger.f23438a.mo533c(a2);
            }
        }
    }
}
