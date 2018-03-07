package com.facebook.analytics.samplingpolicy;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.facebook.analytics.webmethod.AnalyticsServerResponse;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.crudolib.prefs.LightSharedPreferences$Editor;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory;
import com.facebook.crudolib.prefs.LightSharedPreferencesImpl;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.light.LightSharedPreferencesFactoryMethodAutoProvider;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: userAliases */
public class AnalyticsLoggingPolicy {
    private static volatile AnalyticsLoggingPolicy f1474h;
    public final LightSharedPreferencesImpl f1475a;
    public final LightPrefsSamplingConfigAccessor f1476b;
    private final Lazy<ObjectMapper> f1477c;
    public final Random f1478d;
    private final SamplingConfigCopier f1479e;
    public volatile ConfigSnapShot f1480f;
    private boolean f1481g = false;

    /* compiled from: userAliases */
    public class ConfigSnapShot {
        private LightPrefsSamplingConfigAccessor f2227a;
        @Nullable
        private MapSamplingConfigAccessor f2228b;
        private LruCache<Integer, Integer> f2229c;
        private TriState f2230d = TriState.UNSET;
        private TriState f2231e = TriState.UNSET;

        public ConfigSnapShot(LightPrefsSamplingConfigAccessor lightPrefsSamplingConfigAccessor) {
            this.f2227a = lightPrefsSamplingConfigAccessor;
            this.f2229c = new LruCache(200);
        }

        public static synchronized void m4369a(ConfigSnapShot configSnapShot, MapSamplingConfigAccessor mapSamplingConfigAccessor) {
            synchronized (configSnapShot) {
                configSnapShot.f2228b = mapSamplingConfigAccessor;
            }
        }

        private SamplingConfigAccessor m4372c() {
            return this.f2228b == null ? this.f2227a : this.f2228b;
        }

        private synchronized boolean m4370a(String str) {
            return m4372c().m2919b(str);
        }

        private synchronized boolean m4371b(String str) {
            return m4372c().m2920c(str);
        }

        public final boolean m4374a() {
            if (!this.f2230d.isSet()) {
                this.f2230d = TriState.valueOf(m4371b("perf"));
            }
            return this.f2230d.asBoolean();
        }

        public final boolean m4375b() {
            if (!this.f2231e.isSet()) {
                this.f2231e = TriState.valueOf(m4370a("perf"));
            }
            return this.f2231e.asBoolean();
        }

        public final int m4373a(short s, short s2) {
            Object valueOf = Integer.valueOf((s << 16) | s2);
            Integer num = (Integer) this.f2229c.m4432a(valueOf);
            if (num != null) {
                return num.intValue();
            }
            Object valueOf2 = Integer.valueOf(m4368a("perf", String.valueOf(s), String.valueOf(s2)));
            this.f2229c.m4433a(valueOf, valueOf2);
            return valueOf2.intValue();
        }

        private synchronized int m4368a(String str, @Nullable String str2, @Nullable String str3) {
            return m4372c().m2913a(str, str2, str3);
        }
    }

    public static com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy m2863a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1474h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy.class;
        monitor-enter(r1);
        r0 = f1474h;	 Catch:{ all -> 0x003a }
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
        r0 = m2867b(r0);	 Catch:{ all -> 0x0035 }
        f1474h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1474h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy.a(com.facebook.inject.InjectorLike):com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy");
    }

    private static AnalyticsLoggingPolicy m2867b(InjectorLike injectorLike) {
        return new AnalyticsLoggingPolicy(IdBasedSingletonScopeProvider.m1810b(injectorLike, 572), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike), LightSharedPreferencesFactoryMethodAutoProvider.m2543a(injectorLike), SamplingConfigCopier.m2876a(injectorLike));
    }

    @Inject
    public AnalyticsLoggingPolicy(Lazy<ObjectMapper> lazy, Random random, LightSharedPreferencesFactory lightSharedPreferencesFactory, SamplingConfigCopier samplingConfigCopier) {
        this.f1477c = lazy;
        this.f1478d = random;
        this.f1475a = lightSharedPreferencesFactory.m2550a("analytics_flexible_sampling_policy");
        this.f1476b = new LightPrefsSamplingConfigAccessor(this.f1475a);
        this.f1479e = samplingConfigCopier;
    }

    public final void m2872a(AnalyticsServerResponse analyticsServerResponse) {
        if (analyticsServerResponse != null && !TextUtils.isEmpty(analyticsServerResponse.a)) {
            if (this.f1476b.m2918b()) {
                ConfigSnapShot configSnapShot = new ConfigSnapShot(this.f1476b);
                if (this.f1480f != null) {
                    ConfigSnapShot.m4369a(this.f1480f, new MapSamplingConfigAccessor(this.f1475a.m2644a()));
                }
                this.f1480f = configSnapShot;
            }
            m2873a(analyticsServerResponse.a, analyticsServerResponse.b);
        }
    }

    final void m2873a(String str, String str2) {
        LightSharedPreferences$Editor b = this.f1475a.m2648b();
        b.mo3278a();
        try {
            m2865a(b, ((ObjectMapper) this.f1477c.get()).m6636a(str2));
            b.mo3283a("__fs_policy_config_checksum__", str).mo3286b();
        } catch (Throwable e) {
            BLog.c("AnalyticsLoggingPolicy", e, str2, new Object[0]);
        }
    }

    private void m2865a(LightSharedPreferences$Editor lightSharedPreferences$Editor, JsonNode jsonNode) {
        if (jsonNode.m5196h()) {
            lightSharedPreferences$Editor.mo3284a("__fs_policy_blacklisted_events__", m2864a(jsonNode));
            return;
        }
        Iterator H = jsonNode.mo705H();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            JsonNode jsonNode2;
            if (((String) entry.getKey()).equals("blacklist")) {
                jsonNode2 = (JsonNode) entry.getValue();
                if (jsonNode2 != null && jsonNode2.m5196h()) {
                    lightSharedPreferences$Editor.mo3284a("__fs_policy_blacklisted_events__", m2864a(jsonNode2));
                }
            } else {
                String str = (String) entry.getKey();
                jsonNode2 = (JsonNode) entry.getValue();
                if (jsonNode2.m5197i()) {
                    m2866a(str, lightSharedPreferences$Editor, jsonNode2);
                } else {
                    lightSharedPreferences$Editor.mo3281a(str, jsonNode2.mo1287C());
                }
            }
        }
    }

    private static Set<String> m2864a(JsonNode jsonNode) {
        Set hashSet = new HashSet(jsonNode.mo712e());
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            hashSet.add(((JsonNode) it.next()).mo719B());
        }
        return hashSet;
    }

    private void m2866a(String str, LightSharedPreferences$Editor lightSharedPreferences$Editor, JsonNode jsonNode) {
        Iterator H = jsonNode.mo705H();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            if (((String) entry.getKey()).equals("*")) {
                lightSharedPreferences$Editor.mo3281a(str, ((JsonNode) entry.getValue()).mo1287C());
            } else {
                String str2 = str + ":" + ((String) entry.getKey());
                JsonNode jsonNode2 = (JsonNode) entry.getValue();
                if (jsonNode2.m5197i()) {
                    m2866a(str2, lightSharedPreferences$Editor, jsonNode2);
                } else {
                    lightSharedPreferences$Editor.mo3281a(str2, jsonNode2.mo1287C());
                }
            }
        }
    }

    public final String m2871a() {
        return this.f1476b.m2914a();
    }

    public final TriState m2870a(String str) {
        int a = m2869a(str, null, null);
        TriState triState = a < 0 ? TriState.UNSET : a == 0 ? TriState.NO : this.f1478d.nextInt(a) == 0 ? TriState.YES : TriState.NO;
        return triState;
    }

    @Deprecated
    @Nullable
    public final ConfigSnapShot m2874c() {
        if (this.f1481g || this.f1480f != null) {
            return this.f1480f;
        }
        if (!m2868f()) {
            return null;
        }
        this.f1480f = new ConfigSnapShot(this.f1476b);
        return this.f1480f;
    }

    private synchronized boolean m2868f() {
        boolean z;
        if (this.f1476b.m2918b()) {
            z = true;
        } else {
            this.f1479e.m2878a(this);
            z = this.f1476b.m2918b();
        }
        return z;
    }

    public final Random m2875d() {
        return this.f1478d;
    }

    @VisibleForTesting
    public final int m2869a(String str, @Nullable String str2, @Nullable String str3) {
        m2868f();
        return this.f1476b.m2913a(str, str2, str3);
    }
}
