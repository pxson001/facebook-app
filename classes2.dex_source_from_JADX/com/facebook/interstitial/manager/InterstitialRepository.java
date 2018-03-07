package com.facebook.interstitial.manager;

import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.api.FetchInterstitialResult;
import com.facebook.interstitial.manager.InterstitialManager.DataSource;
import com.facebook.interstitial.prefs.InterstitialPrefKeys;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: snowlift_message */
public class InterstitialRepository implements IHaveNonCriticalKeysToClear {
    private static TypeReference<List<JsonNode>> f4461a;
    private static volatile InterstitialRepository f4462h;
    private final InterstitialControllersHolder f4463b;
    private final FbSharedPreferences f4464c;
    private final Clock f4465d;
    private final ObjectMapper f4466e;
    private final AbstractFbErrorReporter f4467f;
    private final QuickPerformanceLogger f4468g;

    public static com.facebook.interstitial.manager.InterstitialRepository m8140a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4462h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.interstitial.manager.InterstitialRepository.class;
        monitor-enter(r1);
        r0 = f4462h;	 Catch:{ all -> 0x003a }
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
        r0 = m8149b(r0);	 Catch:{ all -> 0x0035 }
        f4462h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4462h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.interstitial.manager.InterstitialRepository.a(com.facebook.inject.InjectorLike):com.facebook.interstitial.manager.InterstitialRepository");
    }

    private static InterstitialRepository m8149b(InjectorLike injectorLike) {
        return new InterstitialRepository(InterstitialControllersHolderImpl.m8129b(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike));
    }

    public final ImmutableSet<PrefKey> mo1206a() {
        return ImmutableSet.of(InterstitialPrefKeys.f7892a, InterstitialPrefKeys.f7895d);
    }

    @Inject
    public InterstitialRepository(InterstitialControllersHolder interstitialControllersHolder, FbSharedPreferences fbSharedPreferences, Clock clock, ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter, QuickPerformanceLogger quickPerformanceLogger) {
        this.f4463b = interstitialControllersHolder;
        this.f4464c = fbSharedPreferences;
        this.f4465d = clock;
        this.f4466e = objectMapper;
        this.f4467f = abstractFbErrorReporter;
        this.f4468g = quickPerformanceLogger;
    }

    public final ArrayList<FetchInterstitialResult> m8161a(DataSource dataSource, JsonParser jsonParser) {
        TracerDetour.a("InterstitialManager#deserializeInterstitialResultList", 303203302);
        ArrayList<FetchInterstitialResult> a;
        try {
            jsonParser.mo1763a(this.f4466e);
            List<JsonNode> list = (List) jsonParser.m13258a(m8154c());
            a = Lists.m1297a(list.size());
            for (JsonNode a2 : list) {
                a.add(m8139a(dataSource, a2));
            }
            return a;
        } finally {
            a = 1253229040;
            TracerDetour.a(1253229040);
        }
    }

    public final Parcelable m8158a(String str, String str2) {
        Parcelable parcelable;
        Class b = m8150b(str2, "");
        if (b != null) {
            try {
                parcelable = (Parcelable) this.f4466e.m6657a(str, b);
            } catch (Throwable e) {
                this.f4467f.m2343a("InterstitialRepository", "Failed to parse data for interstitial " + str2, e);
                return null;
            }
        }
        parcelable = null;
        return parcelable;
    }

    static synchronized void m8144a(Editor editor) {
        synchronized (InterstitialRepository.class) {
            editor.mo1271a(InterstitialPrefKeys.f7896e);
        }
    }

    static synchronized void m8147a(Editor editor, Collection<String> collection) {
        synchronized (InterstitialRepository.class) {
            for (String a : collection) {
                editor.mo1271a(InterstitialPrefKeys.m12488a(a));
            }
        }
    }

    static synchronized void m8153b(Editor editor, Collection<InterstitialTrigger> collection) {
        synchronized (InterstitialRepository.class) {
            for (InterstitialTrigger a : collection) {
                editor.mo1271a(InterstitialPrefKeys.m12487a(a));
            }
        }
    }

    static synchronized void m8148a(Editor editor, Map<InterstitialTrigger, TriggerLazyInterstitialControllerHolders> map) {
        synchronized (InterstitialRepository.class) {
            for (Entry entry : map.entrySet()) {
                m8146a(editor, (InterstitialTrigger) entry.getKey(), ((TriggerLazyInterstitialControllerHolders) entry.getValue()).m13481d());
            }
        }
    }

    static synchronized void m8156c(Editor editor, Collection<InterstitialTrigger> collection) {
        synchronized (InterstitialRepository.class) {
            for (InterstitialTrigger a : collection) {
                m8145a(editor, a);
            }
        }
    }

    final synchronized Collection<InterstitialTrigger> m8165d(Editor editor, Collection<InterstitialTrigger> collection) {
        Collection b;
        b = m8164b();
        m8157e(editor, collection);
        b.removeAll(collection);
        return b;
    }

    final synchronized List<InterstitialTrigger> m8164b() {
        return m8152b(this.f4464c.mo278a(InterstitialPrefKeys.f7896e, null));
    }

    final synchronized void m8163a(Editor editor, List<FetchInterstitialResult> list) {
        for (FetchInterstitialResult fetchInterstitialResult : list) {
            PrefKey a = InterstitialPrefKeys.m12488a(fetchInterstitialResult.interstitialId);
            String a2 = m8142a(fetchInterstitialResult);
            if (a2 != null) {
                editor.mo1276a(a, a2);
            } else {
                editor.mo1271a(a);
            }
        }
    }

    @Nullable
    final synchronized List<String> m8162a(InterstitialTrigger interstitialTrigger) {
        List c;
        String a = this.f4464c.mo278a(InterstitialPrefKeys.m12487a(interstitialTrigger), null);
        this.f4468g.mo462b(196631);
        c = m8155c(a);
        if (a != null) {
            this.f4468g.mo448a(196631, a);
        }
        this.f4468g.mo448a(196631, m8143a(c));
        this.f4468g.mo468b(196631, (short) 2);
        return c;
    }

    static String m8143a(List<String> list) {
        return list == null ? "[]" : list.toString();
    }

    @Nullable
    final FetchInterstitialResult m8159a(String str) {
        FetchInterstitialResult fetchInterstitialResult = null;
        String a = this.f4464c.mo278a(InterstitialPrefKeys.m12488a(str), null);
        if (!TextUtils.isEmpty(a)) {
            try {
                JsonNode a2 = this.f4466e.m6636a(a);
                if (a2 != null) {
                    fetchInterstitialResult = m8139a(DataSource.CACHE, a2);
                }
            } catch (Throwable e) {
                this.f4467f.m2343a("InterstitialRepository", "Failed to de-serialize interstitial data", e);
            }
        }
        return fetchInterstitialResult;
    }

    private static TypeReference<List<JsonNode>> m8154c() {
        if (f4461a == null) {
            f4461a = new 1();
        }
        return f4461a;
    }

    private static void m8157e(Editor editor, Collection<InterstitialTrigger> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            str = null;
        } else {
            List b = Lists.m1305b(collection.size());
            for (InterstitialTrigger a : collection) {
                b.add(InterstitialTrigger.m12445a(a));
            }
            str = StringUtil.m3597b("~", b);
        }
        String str2 = str;
        if (str2 != null) {
            editor.mo1276a(InterstitialPrefKeys.f7896e, str2);
        } else {
            editor.mo1271a(InterstitialPrefKeys.f7896e);
        }
    }

    private static List<InterstitialTrigger> m8152b(String str) {
        List a = Lists.m1296a();
        if (str != null) {
            for (String a2 : str.split("~")) {
                a.add(InterstitialTrigger.m12444a(a2));
            }
        }
        return a;
    }

    private static String m8151b(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return StringUtil.m3597b("~", list);
    }

    @Nullable
    private static List<String> m8155c(String str) {
        List<String> arrayList = new ArrayList();
        if (str == null) {
            return null;
        }
        arrayList.addAll(Arrays.asList(str.split("~")));
        return arrayList;
    }

    private static synchronized void m8146a(Editor editor, InterstitialTrigger interstitialTrigger, List<String> list) {
        synchronized (InterstitialRepository.class) {
            String b = m8151b((List) list);
            PrefKey a = InterstitialPrefKeys.m12487a(interstitialTrigger);
            if (b != null) {
                editor.mo1276a(a, b);
            } else {
                editor.mo1271a(a);
            }
        }
    }

    private static synchronized void m8145a(Editor editor, InterstitialTrigger interstitialTrigger) {
        synchronized (InterstitialRepository.class) {
            editor.mo1271a(InterstitialPrefKeys.m12487a(interstitialTrigger));
        }
    }

    private String m8142a(FetchInterstitialResult fetchInterstitialResult) {
        try {
            return this.f4466e.m6659a((Object) fetchInterstitialResult);
        } catch (Throwable e) {
            this.f4467f.m2343a("InterstitialRepository", "Failed to serialize interstitial data", e);
            return null;
        }
    }

    private FetchInterstitialResult m8139a(DataSource dataSource, JsonNode jsonNode) {
        TracerDetour.a("InterstitialManager.deserializeInterstitialResult", -1928786115);
        try {
            long c;
            String B = jsonNode.mo709b("nux_id").mo719B();
            String a = JSONUtil.m13454a(jsonNode.mo709b("nux_type"), "");
            int d = JSONUtil.m13460d(jsonNode.mo709b("rank"));
            if (dataSource == DataSource.CACHE) {
                c = JSONUtil.m13459c(jsonNode.mo709b("fetchTimeMs"));
            } else {
                c = this.f4465d.mo211a();
            }
            Parcelable parcelable = null;
            Type b = m8150b(B, a);
            if (b != null) {
                TracerDetour.a("InterstitialManager.deserializeInterstitialResult#%s#%s", new Object[]{B, b.getName()}, -1133207652);
                LoomLogger.a(LoomLoggerDetour.a(-316411128), String.valueOf(B), b.getName());
                try {
                    Integer.valueOf(d);
                    b.getName();
                    Parcelable parcelable2 = (Parcelable) m8141a(jsonNode, "nux_data", this.f4466e.m6666c().m7109a(b), B);
                    TracerDetour.a(-1828210208);
                    parcelable = parcelable2;
                } catch (Throwable th) {
                    TracerDetour.a(-1430209726);
                }
            }
            FetchInterstitialResult fetchInterstitialResult = new FetchInterstitialResult(d, B, parcelable, c);
            return fetchInterstitialResult;
        } finally {
            TracerDetour.a(2093555426);
        }
    }

    private Class<? extends Parcelable> m8150b(String str, String str2) {
        InterstitialController a = this.f4463b.mo1202a(str);
        if (a != null) {
            return a instanceof InterstitialControllerWithContextClass ? ((InterstitialControllerWithContextClass) a).mo1691d() : null;
        } else {
            this.f4467f.m2340a("InterstitialRepository", "No controller available for nux_id " + str + " and nux_type " + str2);
            return null;
        }
    }

    private <T> T m8141a(JsonNode jsonNode, String str, JavaType javaType, String str2) {
        T t = null;
        JsonNode b = jsonNode.mo709b(str);
        if (b != null) {
            try {
                t = this.f4466e.m6648a(b.mo720a(this.f4466e), javaType);
            } catch (Throwable e) {
                this.f4467f.m2343a("InterstitialRepository", "Failed to parse " + str + " for nux_id " + str2, e);
                BLog.b("InterstitialRepository", e.getMessage());
            } catch (Throwable e2) {
                this.f4467f.m2343a("InterstitialRepository", "Failed to parse " + str + "for nux_id " + str2, e2);
                BLog.b("InterstitialRepository", e2.getMessage());
            }
        }
        return t;
    }
}
