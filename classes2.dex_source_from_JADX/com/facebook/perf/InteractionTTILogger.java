package com.facebook.perf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.support.v4.util.LongSparseArray;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.facebook.common.fragmentconstants.FragmentConstants;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.identifiers.DebugUtils;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: udp_connection_refresh_server_config */
public class InteractionTTILogger {
    public static final PrefKey f2074a = ((PrefKey) SharedPrefKeys.f989c.m2011a("show_perf_toast"));
    private static final ImmutableList<String> f2075d = ImmutableList.of("com.facebook.katana.activity.ImmersiveActivity", "com.facebook.composer.activity.ComposerActivity", "com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity", "com.facebook.places.checkin.activity.SelectAtTagActivity", "com.facebook.ui.browser.BrowserActivity", "com.facebook.katana.FacebookLoginActivity", FragmentConstants$ContentFragmentType.NATIVE_TIMELINE_FRAGMENT.toString(), FragmentConstants$ContentFragmentType.NATIVE_PERMALINK_PAGE_FRAGMENT.toString(), FragmentConstants$ContentFragmentType.EVENTS_PERMALINK_FRAGMENT.toString(), FragmentConstants$ContentFragmentType.EVENTS_DASHBOARD_FRAGMENT.toString(), FragmentConstants$ContentFragmentType.GROUPS_MALL_FRAGMENT.toString(), FragmentConstants$ContentFragmentType.SEARCH_FRAGMENT.toString(), FragmentConstants$ContentFragmentType.NATIVE_PAGES_FRAGMENT.toString());
    private static final int[] f2076e = new int[]{16842936};
    private static volatile InteractionTTILogger f2077s;
    public TriState f2078b = TriState.UNSET;
    Lazy<PerfToastProvider> f2079c;
    private final QuickPerformanceLogger f2080f;
    public final SequenceLogger f2081g;
    private final MonotonicClock f2082h;
    private final PerfLoggingGuard f2083i;
    private String f2084j;
    private String f2085k;
    private String f2086l;
    private long f2087m;
    private int f2088n;
    private boolean f2089o;
    private final LongSparseArray<Long> f2090p = new LongSparseArray();
    @GuardedBy("mEventList")
    private final LinkedList<InteractionEvent> f2091q = new LinkedList();
    public FbSharedPreferences f2092r;

    /* compiled from: udp_connection_refresh_server_config */
    class InteractionEvent {
        boolean f8799a;
        long f8800b;
        int f8801c;
        String f8802d;
        String f8803e;

        public InteractionEvent(boolean z, int i, String str, String str2, long j) {
            this.f8799a = z;
            this.f8801c = i;
            this.f8802d = str;
            this.f8803e = str2;
            this.f8800b = j;
        }
    }

    public static com.facebook.perf.InteractionTTILogger m4228a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2077s;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.perf.InteractionTTILogger.class;
        monitor-enter(r1);
        r0 = f2077s;	 Catch:{ all -> 0x003a }
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
        r0 = m4238b(r0);	 Catch:{ all -> 0x0035 }
        f2077s = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2077s;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.perf.InteractionTTILogger.a(com.facebook.inject.InjectorLike):com.facebook.perf.InteractionTTILogger");
    }

    private static InteractionTTILogger m4238b(InjectorLike injectorLike) {
        return new InteractionTTILogger(QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), SequenceLoggerImpl.m3464a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 9232), PerfLoggingGuard.m4332a(injectorLike));
    }

    @Inject
    public InteractionTTILogger(QuickPerformanceLogger quickPerformanceLogger, SequenceLogger sequenceLogger, MonotonicClock monotonicClock, FbSharedPreferences fbSharedPreferences, Lazy<PerfToastProvider> lazy, PerfLoggingGuard perfLoggingGuard) {
        this.f2080f = quickPerformanceLogger;
        this.f2081g = sequenceLogger;
        this.f2082h = monotonicClock;
        this.f2092r = fbSharedPreferences;
        this.f2079c = lazy;
        this.f2083i = perfLoggingGuard;
    }

    public final void m4253a(String str, String str2, long j) {
        this.f2087m = j;
        this.f2085k = str;
        this.f2088n = 0;
        this.f2089o = false;
        this.f2084j = null;
        this.f2086l = null;
        m4242e();
        this.f2083i.m4336a();
        if (this.f2081g.mo524e(InteractionSequences.f8798a) != null) {
            m4245a();
        }
        this.f2081g.mo512a(InteractionSequences.f8798a, str2 == null ? ImmutableBiMap.m978b("source", str) : ImmutableMap.of("source", str, "caller", str2), j);
        this.f2080f.mo450a(4980737, "tag_name", str, j);
    }

    public final void m4249a(String str) {
        m4253a(str, null, this.f2082h.now());
    }

    public final void m4252a(String str, String str2) {
        m4253a(str, str2, this.f2082h.now());
    }

    public final void m4256b(String str) {
        m4254a(str, null, null);
    }

    public final void m4257b(String str, String str2) {
        m4254a(str, str2, null);
    }

    public final void m4254a(String str, String str2, Map<String, String> map) {
        int i;
        Object obj = -1;
        switch (str.hashCode()) {
            case -2081612157:
                if (str.equals("OpenCheckIn")) {
                    obj = 11;
                    break;
                }
                break;
            case -1916404685:
                if (str.equals("LoadWebView")) {
                    obj = 12;
                    break;
                }
                break;
            case -1685182331:
                if (str.equals("LoadPermalink")) {
                    obj = 7;
                    break;
                }
                break;
            case -1114607404:
                if (str.equals("LoadTimelineHeader")) {
                    obj = null;
                    break;
                }
                break;
            case -432180150:
                if (str.equals("OpenPhotoGallery")) {
                    obj = 9;
                    break;
                }
                break;
            case 201930775:
                if (str.equals("LoadEventPermalink")) {
                    obj = 1;
                    break;
                }
                break;
            case 556722069:
                if (str.equals("LoadEventsDashboard")) {
                    obj = 2;
                    break;
                }
                break;
            case 623743556:
                if (str.equals("LoadPageHeaderNonAdmin")) {
                    obj = 4;
                    break;
                }
                break;
            case 1028993224:
                if (str.equals("OpenMediaPicker")) {
                    obj = 8;
                    break;
                }
                break;
            case 1223080141:
                if (str.equals("LoadPageHeaderAdmin")) {
                    obj = 5;
                    break;
                }
                break;
            case 1351954232:
                if (str.equals("LoadGroupsFeed")) {
                    obj = 3;
                    break;
                }
                break;
            case 1773450185:
                if (str.equals("OpenPhotosFeed")) {
                    obj = 10;
                    break;
                }
                break;
            case 1948903903:
                if (str.equals("SearchTypeahead")) {
                    obj = 13;
                    break;
                }
                break;
            case 2053289386:
                if (str.equals("OpenComposer")) {
                    obj = 6;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                i = 4980750;
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                i = 4980752;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                i = 4980762;
                break;
            case 3:
                i = 4980753;
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                i = 4980751;
                break;
            case 5:
                i = 4980754;
                break;
            case 6:
                i = 4980756;
                break;
            case 7:
                i = 4980755;
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                i = 4980757;
                break;
            case 9:
                i = 4980758;
                break;
            case 10:
                i = 4980763;
                break;
            case 11:
                i = 4980759;
                break;
            case 12:
                i = 4980760;
                break;
            case 13:
                i = 4980761;
                break;
            default:
                i = 4980737;
                break;
        }
        int i2 = i;
        Sequence e = this.f2081g.mo524e(InteractionSequences.f8798a);
        if (e != null) {
            ImmutableMap immutableMap;
            ImmutableMap b;
            SequenceLoggerDetour.a(e, str, null, null, e.mo624c(), -2068507867);
            if (str2 == null) {
                immutableMap = null;
            } else {
                immutableMap = ImmutableBiMap.m978b("source", str2);
            }
            SequenceLoggerDetour.b(e, str, null, immutableMap, 312744176);
            if (map == null || map.isEmpty()) {
                b = ImmutableBiMap.m978b("metric", str);
            } else {
                Builder builder = ImmutableMap.builder();
                builder.m608a((Map) map);
                builder.m609b("metric", str);
                b = builder.m610b();
            }
            this.f2081g.mo519b(InteractionSequences.f8798a, b);
        }
        this.f2080f.mo437a(4980737, i2);
        m4241d(i2);
        if (this.f2080f.mo480f(i2)) {
            m4230a(i2, this.f2080f.mo475d(i2, 0));
        }
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                this.f2080f.mo448a(i2, ((String) entry.getKey()) + "=" + ((String) entry.getValue()));
            }
        }
        this.f2080f.mo467b(i2, "tag_name", this.f2085k);
        this.f2080f.mo468b(i2, (short) 2);
        this.f2080f.mo448a(4980737, str);
        this.f2080f.mo468b(4980737, (short) 2);
        this.f2087m = 0;
        m4242e();
    }

    public final void m4245a() {
        this.f2081g.mo523d(InteractionSequences.f8798a);
        this.f2087m = 0;
        m4242e();
        this.f2080f.mo477e(4980737);
    }

    public final void m4255b() {
        this.f2081g.mo522c(InteractionSequences.f8798a);
        this.f2087m = 0;
        m4242e();
        this.f2080f.mo468b(4980737, (short) 3);
    }

    public final Sequence m4244a(AbstractSequenceDefinition abstractSequenceDefinition) {
        return m4229a(abstractSequenceDefinition, null, null, this.f2082h.now());
    }

    private Sequence m4229a(AbstractSequenceDefinition abstractSequenceDefinition, String str, ImmutableMap immutableMap, long j) {
        if (this.f2087m <= 0) {
            return this.f2081g.mo513a(abstractSequenceDefinition, str, immutableMap, j);
        }
        Sequence a = this.f2081g.mo513a(abstractSequenceDefinition, str, immutableMap, this.f2087m);
        if (a == null) {
            return a;
        }
        m4236a(a);
        SequenceLoggerDetour.a(a, "LegacyMarker", 239036452);
        return a;
    }

    public final void m4250a(String str, long j) {
        m4234a(4980742, str, str, j);
        m4231a(4980742, str);
    }

    public final void m4259c(String str) {
        m4233a(4980743, str, str);
    }

    public final void m4261d(String str) {
        m4231a(4980743, str);
    }

    public final void m4262e(String str) {
        m4233a(4980744, str, str);
    }

    public final void m4263f(String str) {
        m4231a(4980744, str);
    }

    public final void m4264g(String str) {
        if (this.f2086l == null || this.f2086l.equals(str)) {
            m4233a(4980745, str, str);
        }
    }

    public final void m4265h(String str) {
        if (this.f2086l == null || this.f2086l.equals(str)) {
            m4231a(4980745, str);
        }
    }

    public final void m4266i(String str) {
        if (this.f2086l == null || this.f2086l.equals(str)) {
            m4233a(4980749, str, str);
        }
    }

    public final void m4267j(String str) {
        if (this.f2086l == null || this.f2086l.equals(str)) {
            m4231a(4980749, str);
        }
    }

    public final void m4268k(String str) {
        this.f2084j = str;
        m4233a(4980739, str, m4243t(str));
    }

    public final void m4269l(String str) {
        m4231a(4980739, str);
    }

    public final void m4270m(String str) {
        if (this.f2084j == null || this.f2084j.equals(str)) {
            m4233a(4980747, str, str == null ? null : m4243t(str));
        } else {
            m4245a();
        }
    }

    public final void m4271n(String str) {
        m4231a(4980747, str);
    }

    public final void m4272o(String str) {
        m4233a(4980748, str, str);
    }

    public final void m4273p(String str) {
        m4231a(4980748, str);
    }

    public final void m4247a(Activity activity) {
        long now = this.f2082h.now();
        if (!this.f2089o) {
            this.f2088n = m4237b(activity);
        }
        if (this.f2088n > 0) {
            long longValue = ((Long) this.f2090p.m4359a((long) this.f2088n, Long.valueOf(-1))).longValue();
            if (longValue == -1) {
                try {
                    longValue = AnimationUtils.loadAnimation(activity, this.f2088n).getDuration();
                    this.f2090p.m4364b((long) this.f2088n, Long.valueOf(longValue));
                } catch (NotFoundException e) {
                }
            }
            if (longValue > 0) {
                m4234a(4980746, null, null, now);
                m4232a(4980746, null, now + longValue);
            }
        }
    }

    public final void m4258c() {
        m4233a(4980746, null, null);
    }

    public final void m4260d() {
        m4231a(4980746, null);
    }

    public final void m4274q(String str) {
        this.f2086l = str;
        m4233a(4980740, str, str);
    }

    public final void m4275r(String str) {
        m4231a(4980740, str);
    }

    public final void m4276s(String str) {
        this.f2086l = str;
        m4233a(4980741, str, str);
    }

    public final void m4251a(String str, Intent intent) {
        String str2 = null;
        if (intent != null) {
            FragmentConstants$ContentFragmentType a = FragmentConstants.a(intent.getIntExtra("target_fragment", -1));
            if (a != null) {
                str2 = a.toString();
            } else if (intent.getComponent() != null) {
                str2 = intent.getComponent().getShortClassName();
            }
        }
        if (f2075d.contains(str2)) {
            m4231a(4980741, str);
        } else {
            m4255b();
        }
    }

    public final void m4246a(int i) {
        this.f2089o = true;
        this.f2088n = i;
    }

    private void m4233a(int i, String str, String str2) {
        m4234a(i, str, str2, this.f2082h.now());
    }

    private void m4234a(int i, String str, String str2, long j) {
        if (m4239b(i)) {
            m4255b();
            return;
        }
        Sequence e = this.f2081g.mo524e(InteractionSequences.f8798a);
        if (e != null) {
            SequenceLoggerDetour.a(e, DebugUtils.a(i), str, str2 == null ? null : ImmutableBiMap.m978b("extra", str2), j, -1419524250);
        }
        m4235a(new InteractionEvent(true, i, str, str2, j));
    }

    private void m4231a(int i, String str) {
        m4232a(i, str, this.f2082h.now());
    }

    private void m4232a(int i, String str, long j) {
        Sequence e = this.f2081g.mo524e(InteractionSequences.f8798a);
        if (e != null) {
            SequenceLoggerDetour.b(e, DebugUtils.a(i), str, null, j, -1881454809);
        }
        m4235a(new InteractionEvent(false, i, str, null, j));
    }

    private boolean m4239b(int i) {
        if (i == 4980739 || i == 4980746 || i == 4980740 || i == 4980741 || !m4240c(i)) {
            return false;
        }
        if (i == 4980749 && m4240c(4980743)) {
            return false;
        }
        return true;
    }

    public final void m4248a(Context context, String str) {
        String str2;
        if (context == null) {
            str2 = "null";
        } else {
            str2 = context.toString();
            if (str2.indexOf(64) != -1) {
                str2 = context.getClass().getSimpleName();
            }
        }
        m4253a(str2, str, this.f2082h.now());
    }

    private static String m4243t(String str) {
        if (str == null) {
            return "unknown";
        }
        int indexOf = str.indexOf("://");
        int indexOf2 = str.indexOf(47, indexOf + 3);
        if (indexOf == -1) {
            return str;
        }
        indexOf += 3;
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf, indexOf2);
    }

    private void m4230a(int i, long j) {
        synchronized (this.f2091q) {
            Iterator it = this.f2091q.iterator();
            while (it.hasNext()) {
                InteractionEvent interactionEvent = (InteractionEvent) it.next();
                if (interactionEvent.f8799a) {
                    this.f2080f.mo450a(interactionEvent.f8801c, "tag_name", interactionEvent.f8803e, interactionEvent.f8800b);
                    int i2 = 0;
                    if (interactionEvent.f8801c == 4980745) {
                        i2 = 4980764;
                    } else if (interactionEvent.f8801c == 4980742) {
                        i2 = 4980765;
                    } else if (interactionEvent.f8801c == 4980748) {
                        i2 = 4980766;
                    }
                    if (i2 != 0) {
                        this.f2080f.mo450a(i2, "tag_name", interactionEvent.f8803e, j);
                        this.f2080f.mo448a(i2, DebugUtils.a(i));
                        this.f2080f.mo454a(i2, (short) 2, interactionEvent.f8800b);
                    }
                    this.f2080f.mo448a(interactionEvent.f8801c, DebugUtils.a(i));
                } else {
                    this.f2080f.mo454a(interactionEvent.f8801c, (short) 2, interactionEvent.f8800b);
                }
            }
            this.f2091q.clear();
        }
    }

    private void m4236a(Sequence sequence) {
        synchronized (this.f2091q) {
            Iterator it = this.f2091q.iterator();
            while (it.hasNext()) {
                InteractionEvent interactionEvent = (InteractionEvent) it.next();
                if (interactionEvent.f8799a) {
                    ImmutableMap immutableMap;
                    String a = DebugUtils.a(interactionEvent.f8801c);
                    String str = interactionEvent.f8802d;
                    if (interactionEvent.f8803e == null) {
                        immutableMap = null;
                    } else {
                        immutableMap = ImmutableBiMap.m978b("extra", interactionEvent.f8803e);
                    }
                    SequenceLoggerDetour.a(sequence, a, str, immutableMap, interactionEvent.f8800b, -516975681);
                } else {
                    SequenceLoggerDetour.b(sequence, DebugUtils.a(interactionEvent.f8801c), interactionEvent.f8802d, interactionEvent.f8803e == null ? null : ImmutableBiMap.m978b("extra", interactionEvent.f8803e), interactionEvent.f8800b, 2009026109);
                }
            }
        }
    }

    private void m4235a(InteractionEvent interactionEvent) {
        synchronized (this.f2091q) {
            this.f2091q.add(interactionEvent);
        }
    }

    private void m4242e() {
        synchronized (this.f2091q) {
            this.f2091q.clear();
        }
    }

    private boolean m4240c(int i) {
        boolean z;
        synchronized (this.f2091q) {
            Iterator it = this.f2091q.iterator();
            while (it.hasNext()) {
                if (i == ((InteractionEvent) it.next()).f8801c) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    private static int m4237b(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(activity.getWindow().getAttributes().windowAnimations, f2076e);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private void m4241d(int i) {
        boolean z = false;
        if (this.f2078b == TriState.UNSET) {
            this.f2078b = TriState.valueOf(this.f2092r.mo286a(f2074a, false));
        }
        if (this.f2078b == TriState.YES) {
            z = true;
        }
        if (Boolean.valueOf(z).booleanValue()) {
            long d = this.f2080f.mo475d(i, 0);
            if (d > 0) {
                d = this.f2082h.now() - d;
                Toast.makeText(((PerfToastProvider) this.f2079c.get()).a, DebugUtils.a(i) + ": " + d + " ms", 0).show();
            }
        }
    }
}
