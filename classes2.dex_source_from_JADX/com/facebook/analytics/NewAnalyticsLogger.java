package com.facebook.analytics;

import android.content.Context;
import com.facebook.analytics.event.HoneyClientEventFastInternal;
import com.facebook.analytics.logger.AnalyticsConfig;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics2.logger.Analytics2Logger;
import com.facebook.analytics2.logger.EventBuilder;
import com.facebook.analytics2.logger.EventLogType;
import com.facebook.analytics2.logger.SessionManager;
import com.facebook.analytics2.logger.UploadScheduler;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.crudolib.params.ParamsCollectionArray;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.tools.dextr.runtime.detour.TraceCompatDetour;
import com.facebook.xanalytics.XAnalyticsProvider;
import com.facebook.xanalytics.provider.DefaultXAnalyticsProvider;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;
import java.util.Map;
import java.util.Random;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@Deprecated
/* compiled from: update_type */
public class NewAnalyticsLogger extends AbstractAnalyticsLogger {
    private static final String f1744a = NewAnalyticsLogger.class.getCanonicalName();
    private static volatile NewAnalyticsLogger f1745j;
    private final Lazy<Context> f1746b;
    private final Lazy<Analytics2Logger> f1747c;
    private final Provider<String> f1748d;
    private final Lazy<SessionManager> f1749e;
    private final Provider<Boolean> f1750f;
    private final Provider<Boolean> f1751g;
    private final Lazy<XAnalyticsProvider> f1752h;
    @GuardedBy("this")
    @Nullable
    private String f1753i;

    public static com.facebook.analytics.NewAnalyticsLogger m3518a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1745j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.NewAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f1745j;	 Catch:{ all -> 0x003a }
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
        r0 = m3525b(r0);	 Catch:{ all -> 0x0035 }
        f1745j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1745j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.NewAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.analytics.NewAnalyticsLogger");
    }

    private static NewAnalyticsLogger m3525b(InjectorLike injectorLike) {
        return new NewAnalyticsLogger(injectorLike.getLazy(Context.class), IdBasedSingletonScopeProvider.m1810b(injectorLike, 207), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442), FbAnalyticsConfig.m3559a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 115), IdBasedProvider.m1811a(injectorLike, 3876), IdBasedProvider.m1811a(injectorLike, 3877), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3746), AnalyticsStats.m3664a(injectorLike));
    }

    private static void m3522a(HoneyExperimentEvent honeyExperimentEvent, EventBuilder eventBuilder) {
        String str = honeyExperimentEvent.f16095c;
        if (str != null) {
            eventBuilder.f3229r.m5421a("exprID", str);
        }
    }

    @Inject
    public NewAnalyticsLogger(Lazy<Context> lazy, Lazy<Analytics2Logger> lazy2, Random random, Provider<String> provider, AnalyticsConfig analyticsConfig, Lazy<SessionManager> lazy3, Provider<Boolean> provider2, Provider<Boolean> provider3, Lazy<XAnalyticsProvider> lazy4, AnalyticsStats analyticsStats) {
        super(random, analyticsConfig, analyticsStats);
        this.f1746b = lazy;
        this.f1747c = lazy2;
        this.f1748d = provider;
        this.f1749e = lazy3;
        this.f1750f = provider2;
        this.f1751g = provider3;
        this.f1752h = lazy4;
    }

    public final String mo525a() {
        return "analytics2/" + UploadScheduler.m5734a((Context) this.f1746b.get()).mo760a();
    }

    public final void mo526a(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (honeyAnalyticsEvent != null) {
            m3521a(honeyAnalyticsEvent, m3520a(honeyAnalyticsEvent, false, m3530e(honeyAnalyticsEvent)));
        }
    }

    public final void mo531b(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (honeyAnalyticsEvent != null) {
            m3526b(honeyAnalyticsEvent, m3519a(honeyAnalyticsEvent, m3530e(honeyAnalyticsEvent)));
        }
    }

    private static void m3528d(HoneyAnalyticsEvent honeyAnalyticsEvent, EventBuilder eventBuilder) {
        JsonNode jsonNode = honeyAnalyticsEvent.f3118k;
        if (jsonNode != null) {
            int e = jsonNode.mo712e();
            ParamsCollectionArray c = eventBuilder.m5388c().m5425c("enabled_features");
            for (int i = 0; i < e; i++) {
                c.m11500a(jsonNode.mo708a(i).mo719B());
            }
        }
    }

    public final void mo527a(HoneyAnalyticsEvent honeyAnalyticsEvent, int i) {
        if (honeyAnalyticsEvent != null && m3547c(honeyAnalyticsEvent, i)) {
            mo526a(honeyAnalyticsEvent);
        }
    }

    public final void mo533c(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (honeyAnalyticsEvent != null) {
            m3521a(honeyAnalyticsEvent, m3520a(honeyAnalyticsEvent, true, m3530e(honeyAnalyticsEvent)));
        }
    }

    public final void mo532b(HoneyAnalyticsEvent honeyAnalyticsEvent, int i) {
        if (honeyAnalyticsEvent != null && m3547c(honeyAnalyticsEvent, i)) {
            mo533c(honeyAnalyticsEvent);
        }
    }

    private static void m3524a(HoneyClientEvent honeyClientEvent, EventBuilder eventBuilder) {
        eventBuilder.m5382a(honeyClientEvent.f3100d, honeyClientEvent.f3101e);
        eventBuilder.m5386b(honeyClientEvent.f3102f);
        eventBuilder.m5387b(honeyClientEvent.f3103g, honeyClientEvent.f3104h);
    }

    public final void mo534d(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (honeyAnalyticsEvent != null) {
            m3521a(honeyAnalyticsEvent, m3520a(honeyAnalyticsEvent, true, true));
        }
    }

    public final void mo528a(HoneyClientEvent honeyClientEvent) {
        if (honeyClientEvent != null) {
            if (honeyClientEvent.f3106j || honeyClientEvent.f3107k) {
                mo534d(honeyClientEvent);
            } else {
                mo533c((HoneyAnalyticsEvent) honeyClientEvent);
            }
        }
    }

    public final void mo529a(String str) {
        mo530a(str, null);
    }

    public final void mo530a(String str, Map<String, String> map) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        if (!(map == null || map.isEmpty())) {
            honeyClientEvent.m5088a((Map) map);
        }
        mo526a(honeyClientEvent);
    }

    private static boolean m3530e(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        return honeyAnalyticsEvent.m5111b("upload_this_event_now");
    }

    private synchronized void m3531f(@Nullable HoneyAnalyticsEvent honeyAnalyticsEvent) {
        String str;
        String str2 = this.f1753i;
        if (honeyAnalyticsEvent == null || honeyAnalyticsEvent.m5110b() == "AUTO_SET") {
            str = (String) this.f1748d.get();
        } else {
            str = honeyAnalyticsEvent.m5110b();
        }
        if (!Objects.equal(str2, str)) {
            this.f1753i = str;
            if (this.f1753i == null) {
                ((SessionManager) this.f1749e.get()).m5297a();
            } else {
                ((SessionManager) this.f1749e.get()).m5299a(this.f1753i);
            }
        }
    }

    private void m3521a(HoneyAnalyticsEvent honeyAnalyticsEvent, EventBuilder eventBuilder) {
        if (eventBuilder.m5385a()) {
            boolean z = BuildConstants.i;
            if (1 != 0) {
                m3526b(honeyAnalyticsEvent, eventBuilder);
                if (((Boolean) this.f1750f.get()).booleanValue()) {
                    mo531b(m3534i(honeyAnalyticsEvent));
                }
                if (((Boolean) this.f1751g.get()).booleanValue()) {
                    String e = honeyAnalyticsEvent instanceof HoneyClientEventFastInternal ? "HCEFastInternal" : honeyAnalyticsEvent instanceof HoneyExperimentEvent ? honeyAnalyticsEvent.m5116e() : honeyAnalyticsEvent instanceof HoneyClientEvent ? ((HoneyClientEvent) honeyAnalyticsEvent).m5104u() : "";
                    ((DefaultXAnalyticsProvider) this.f1752h.get()).f15720c.logEvent("fbacore_" + honeyAnalyticsEvent.f3111d, e, "");
                }
            }
        }
    }

    private synchronized void m3526b(HoneyAnalyticsEvent honeyAnalyticsEvent, EventBuilder eventBuilder) {
        TraceCompatDetour.a("buildAndDispatch", 882129468);
        try {
            m3531f(honeyAnalyticsEvent);
            m3546b(honeyAnalyticsEvent.m5119k());
            if (honeyAnalyticsEvent.m5117h() != "AUTO_SET") {
                eventBuilder.m5379a(honeyAnalyticsEvent.m5117h());
            }
            if (honeyAnalyticsEvent.m5107a() != -1) {
                eventBuilder.m5378a(honeyAnalyticsEvent.m5107a());
            }
            if (honeyAnalyticsEvent instanceof HoneyClientEventFastInternal) {
                m3523a((HoneyClientEventFastInternal) honeyAnalyticsEvent, eventBuilder);
            } else if (honeyAnalyticsEvent instanceof HoneyClientEvent) {
                m3524a((HoneyClientEvent) honeyAnalyticsEvent, eventBuilder);
            } else if (honeyAnalyticsEvent instanceof HoneyExperimentEvent) {
                m3522a((HoneyExperimentEvent) honeyAnalyticsEvent, eventBuilder);
            }
            m3529e(honeyAnalyticsEvent, eventBuilder);
            m3528d(honeyAnalyticsEvent, eventBuilder);
            eventBuilder.m5390d();
            TraceCompatDetour.a(-1897548740);
        } catch (Throwable th) {
            TraceCompatDetour.a(1972761134);
        }
    }

    private EventBuilder m3520a(HoneyAnalyticsEvent honeyAnalyticsEvent, boolean z, boolean z2) {
        if (!(honeyAnalyticsEvent instanceof HoneyClientEventFastInternal)) {
            return ((Analytics2Logger) this.f1747c.get()).m5369a(m3532g(honeyAnalyticsEvent), honeyAnalyticsEvent.f3111d, z, m3533h(honeyAnalyticsEvent), z2);
        } else if (((HoneyClientEventFastInternal) honeyAnalyticsEvent).mo732l()) {
            return m3519a(honeyAnalyticsEvent, z2);
        } else {
            throw new IllegalStateException("Trying to log a non sampled event");
        }
    }

    private EventBuilder m3519a(HoneyAnalyticsEvent honeyAnalyticsEvent, boolean z) {
        return ((Analytics2Logger) this.f1747c.get()).m5368a(m3532g(honeyAnalyticsEvent), honeyAnalyticsEvent.f3111d, m3533h(honeyAnalyticsEvent), z);
    }

    private static void m3523a(HoneyClientEventFastInternal honeyClientEventFastInternal, EventBuilder eventBuilder) {
        eventBuilder.m5382a(honeyClientEventFastInternal.m5278m(), honeyClientEventFastInternal.m5279n());
        eventBuilder.m5386b(honeyClientEventFastInternal.m5280o());
        eventBuilder.m5387b(honeyClientEventFastInternal.m5281p(), honeyClientEventFastInternal.m5282q());
    }

    private static void m3529e(HoneyAnalyticsEvent honeyAnalyticsEvent, EventBuilder eventBuilder) {
        if (honeyAnalyticsEvent instanceof HoneyClientEvent) {
            ((HoneyClientEvent) honeyAnalyticsEvent).m5089a(eventBuilder.m5388c());
        } else if (honeyAnalyticsEvent instanceof HoneyExperimentEvent) {
            ((HoneyExperimentEvent) honeyAnalyticsEvent).m22923a(eventBuilder.m5388c());
        } else if (honeyAnalyticsEvent instanceof HoneyClientEventFastInternal) {
            eventBuilder.m5384a(((HoneyClientEventFastInternal) honeyAnalyticsEvent).m5283r());
        }
    }

    @Nullable
    private static String m3532g(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (honeyAnalyticsEvent instanceof HoneyClientEvent) {
            return ((HoneyClientEvent) honeyAnalyticsEvent).f3099c;
        }
        if (honeyAnalyticsEvent instanceof HoneyClientEventFastInternal) {
            return ((HoneyClientEventFastInternal) honeyAnalyticsEvent).m5284s();
        }
        return null;
    }

    private static EventLogType m3533h(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if ((honeyAnalyticsEvent instanceof HoneyClientEvent) || (honeyAnalyticsEvent instanceof HoneyClientEventFastInternal)) {
            return EventLogType.CLIENT_EVENT;
        }
        if (honeyAnalyticsEvent instanceof HoneyExperimentEvent) {
            return EventLogType.EXPERIMENT;
        }
        throw new IllegalArgumentException("Unsupported type=" + honeyAnalyticsEvent.getClass().getName());
    }

    private static HoneyAnalyticsEvent m3534i(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(m3527c(honeyAnalyticsEvent.f3111d));
        if (honeyAnalyticsEvent instanceof HoneyClientEvent) {
            honeyClientEvent.m5090b("reversed", m3527c(((HoneyClientEvent) honeyAnalyticsEvent).m5104u()));
            honeyClientEvent.f3103g = ((HoneyClientEvent) honeyAnalyticsEvent).f3103g;
            honeyClientEvent.f3099c = m3527c(((HoneyClientEvent) honeyAnalyticsEvent).f3099c);
        }
        return honeyClientEvent;
    }

    @Nullable
    private static String m3527c(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }
}
