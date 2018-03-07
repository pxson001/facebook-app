package com.facebook.analytics;

import android.app.Activity;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.support.v4.app.Fragment;
import com.facebook.analytics.activityidentifier.AnalyticsActivityContentUri;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.analytics.logger.AnalyticsEventNames$AppStateNames;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.ClickEventCreator;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.analytics.tagging.AnalyticsActivityWithExtraData;
import com.facebook.analytics.tagging.AnalyticsObjectProvider;
import com.facebook.analytics.tagging.AnalyticsObjectProvider.ObjectType;
import com.facebook.analytics.tagging.CurrentModuleHolder;
import com.facebook.analytics.tagging.CurrentModuleHolder.NotifyModuleChangedCallback;
import com.facebook.analytics.tagging.ModuleInfo;
import com.facebook.analytics.util.AnalyticsConnectionUtils;
import com.facebook.analytics2.logger.SessionManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.CrossFbAppBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.fragment.ContentFragmentContainer;
import com.facebook.common.android.PowerManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.device.FbTrafficStats;
import com.facebook.device.resourcemonitor.DataUsageBytes;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.fragment.FbChromeFragment;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.Sets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import javax.annotation.Nullable;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: tagging_enable_fof_android */
public class NavigationLogger {
    private static volatile NavigationLogger f3285E;
    private boolean f3286A;
    private Runnable f3287B = null;
    private int f3288C = 0;
    private DataUsageBytes f3289D;
    public final Clock f3290a;
    private final Handler f3291b;
    private final PowerManager f3292c;
    private final DeviceConditionHelper f3293d;
    private final ImpressionManager f3294e;
    private final UserLoggedInStatus f3295f;
    private final AppStateManager f3296g;
    private final CurrentModuleHolder f3297h;
    private final Provider<Boolean> f3298i;
    private final Context f3299j;
    private final GatekeeperStoreImpl f3300k;
    private final Random f3301l;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AnalyticsConnectionUtils> f3302m = UltralightRuntime.m730b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AnalyticsLogger> f3303n = UltralightRuntime.m730b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ConnectionStatusLogger> f3304o = UltralightRuntime.m730b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbTrafficStats> f3305p = UltralightRuntime.m730b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SessionManager> f3306q = UltralightRuntime.m730b();
    private SelfRegistrableReceiverImpl f3307r;
    private BaseFbBroadcastManager f3308s;
    private final Set<Activity> f3309t = Sets.m1313a();
    public String f3310u;
    public String f3311v;
    public String f3312w;
    private int f3313x = -1;
    public boolean f3314y = false;
    public boolean f3315z = true;

    public static com.facebook.analytics.NavigationLogger m5475a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3285E;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.NavigationLogger.class;
        monitor-enter(r1);
        r0 = f3285E;	 Catch:{ all -> 0x003a }
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
        r0 = m5489b(r0);	 Catch:{ all -> 0x0035 }
        f3285E = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3285E;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.NavigationLogger.a(com.facebook.inject.InjectorLike):com.facebook.analytics.NavigationLogger");
    }

    private static NavigationLogger m5489b(InjectorLike injectorLike) {
        NavigationLogger navigationLogger = new NavigationLogger(SystemClockMethodAutoProvider.m1498a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.m5523b(injectorLike), PowerManagerMethodAutoProvider.m5525b(injectorLike), DeviceConditionHelper.m5526a(injectorLike), ImpressionManager.m5536a(injectorLike), UserLoggedInStatus.m5541b(injectorLike), AppStateManager.m2245a(injectorLike), CurrentModuleHolder.m5545a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedProvider.m1811a(injectorLike, 3879), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), CrossFbAppBroadcastManager.m3885a(injectorLike), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike));
        navigationLogger.m5487a(IdBasedSingletonScopeProvider.m1810b(injectorLike, 201), IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), IdBasedSingletonScopeProvider.m1810b(injectorLike, 127), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1053), IdBasedSingletonScopeProvider.m1810b(injectorLike, 115));
        return navigationLogger;
    }

    @Inject
    private NavigationLogger(Clock clock, Handler handler, PowerManager powerManager, DeviceConditionHelper deviceConditionHelper, ImpressionManager impressionManager, UserLoggedInStatus userLoggedInStatus, AppStateManager appStateManager, CurrentModuleHolder currentModuleHolder, Context context, Provider<Boolean> provider, GatekeeperStore gatekeeperStore, FbBroadcastManager fbBroadcastManager, Random random) {
        this.f3290a = clock;
        this.f3291b = handler;
        this.f3292c = powerManager;
        this.f3293d = deviceConditionHelper;
        this.f3294e = impressionManager;
        this.f3295f = userLoggedInStatus;
        this.f3296g = appStateManager;
        this.f3297h = currentModuleHolder;
        this.f3299j = context;
        this.f3298i = provider;
        this.f3300k = gatekeeperStore;
        this.f3308s = fbBroadcastManager;
        this.f3301l = random;
    }

    public static String m5480a(Context context) {
        String str = null;
        if (context instanceof AnalyticsActivity) {
            str = ((AnalyticsActivity) context).am_();
        }
        return str != null ? str : "unknown";
    }

    public final NavigationLogger m5498a(@Nullable String str) {
        if (str == null) {
            this.f3311v = this.f3310u;
        } else {
            this.f3311v = str;
        }
        this.f3310u = str;
        return this;
    }

    public final String m5499a() {
        return this.f3310u;
    }

    public final String m5515b() {
        return this.f3311v;
    }

    public final NavigationLogger m5514b(String str) {
        this.f3312w = str;
        return this;
    }

    private Map<String, ?> m5490b(@Nullable Map<String, ?> map) {
        Map<String, ?> hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("click_point", this.f3310u);
        hashMap.put("last_tracking_code", this.f3312w);
        return hashMap;
    }

    @Deprecated
    public final void m5511a(String str, boolean z) {
        m5512a(str, z, null);
    }

    @Deprecated
    public final void m5512a(String str, boolean z, @Nullable Map<String, ?> map) {
        String str2;
        Object obj;
        ModuleInfo c = this.f3297h.m5555c();
        if (c != null) {
            str2 = c.f8470a;
            obj = c.f8471b;
        } else {
            obj = null;
            str2 = null;
        }
        this.f3297h.m5548a(str, map);
        Map hashMap = new HashMap();
        hashMap.put("is_modal", Boolean.valueOf(z));
        hashMap.put("source_module_class", obj);
        if (map != null) {
            hashMap.putAll(map);
        }
        Stack a = this.f3297h.m5550a();
        m5486a(null, null, str2, str, null, hashMap, false);
        this.f3297h.m5551a(a);
    }

    @Deprecated
    public final void m5519c(String str) {
        m5510a(str, null);
    }

    @Deprecated
    public final void m5510a(String str, @Nullable Map<String, ?> map) {
        String str2;
        this.f3297h.m5553b(str, map);
        Map hashMap = new HashMap();
        ModuleInfo c = this.f3297h.m5555c();
        if (c != null) {
            str2 = c.f8470a;
            hashMap.put("dest_module_class", c.f8471b);
            if (c.f8472c != null) {
                hashMap.putAll(c.f8472c);
            }
        } else {
            str2 = null;
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        Stack a = this.f3297h.m5550a();
        m5486a(null, null, str, str2, null, hashMap, false);
        this.f3297h.m5551a(a);
    }

    public final synchronized void m5505a(Context context, HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.m5108a(this.f3290a.mo211a());
        if (context instanceof Activity) {
            honeyClientEvent.m5099k(this.f3294e.m5539b((Activity) context));
        }
        ((AnalyticsLogger) this.f3303n.get()).mo528a(honeyClientEvent);
    }

    public final void m5508a(@Nullable AnalyticsActivity analyticsActivity, @Nullable Map<String, ?> map) {
        String am_;
        Object simpleName;
        Map hashMap = new HashMap();
        if (analyticsActivity != null) {
            am_ = analyticsActivity.am_();
            simpleName = m5479a((Object) analyticsActivity).getClass().getSimpleName();
        } else {
            ModuleInfo c = this.f3297h.m5555c();
            if (c != null) {
                am_ = c.f8470a;
                String str = c.f8471b;
                hashMap.put("dest_module_class", str);
            } else {
                simpleName = null;
                am_ = null;
            }
        }
        if (simpleName != null) {
            hashMap.put("source_module_class", simpleName);
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        m5486a(analyticsActivity, null, am_, am_, null, hashMap, false);
    }

    private void m5486a(@Nullable AnalyticsActivity analyticsActivity, @Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, ?> map, boolean z) {
        NotifyModuleChangedCallback a;
        synchronized (this) {
            Map a2;
            String am_;
            String str4;
            String str5;
            String str6;
            Map a3;
            if (map == null) {
                a2 = ImmutableBiMap.m976a();
            } else {
                Map<String, ?> map2 = map;
            }
            long a4 = this.f3290a.mo211a();
            if (analyticsActivity != null) {
                if (str2 == null || str2 == "unknown") {
                    am_ = analyticsActivity.am_();
                } else {
                    am_ = str2;
                }
                a2 = m5477a((Object) analyticsActivity, a2);
            } else {
                am_ = str2;
            }
            ModuleInfo c = this.f3297h.m5555c();
            if (str != null || c == null) {
                str4 = null;
                str5 = str;
            } else {
                str = c.m13031a();
                str4 = c.m13032b();
                str5 = str;
            }
            if (str5 == "unknown") {
                str5 = null;
            }
            if (am_ == "unknown") {
                str6 = null;
            } else {
                str6 = am_;
            }
            HoneyAnalyticsEvent a5 = new HoneyClientEvent("navigation").m5094g(str5 != null ? str5 : "unknown").m5090b("source_module", str5).m5090b("source_module_class", str4).m5090b("dest_module", str6).m5083a("seq", this.f3288C);
            if (context != null) {
                a5.m5099k(this.f3294e.m5539b(context));
            }
            if (analyticsActivity instanceof AnalyticsActivityContentUri) {
                am_ = ((AnalyticsActivityContentUri) analyticsActivity).m13019a();
                if (am_ != null) {
                    a5.m5090b("dest_module_uri", am_);
                }
            }
            if (analyticsActivity instanceof AnalyticsObjectProvider) {
                ObjectType a6 = ((AnalyticsObjectProvider) analyticsActivity).m13020a();
                if (a6 != null) {
                    a5.m5095h(a6.getTypeName());
                    a5.m5096i(((AnalyticsObjectProvider) analyticsActivity).m13021d());
                }
            }
            if (analyticsActivity instanceof AnalyticsActivityWithExtraData) {
                a3 = m5478a(a2, (AnalyticsActivityWithExtraData) analyticsActivity);
            } else {
                a3 = a2;
            }
            if (str3 != null) {
                a5.m5100l(str3.toString());
            }
            a2 = m5490b(a3);
            if (!a2.isEmpty()) {
                a5.m5088a(a2);
            }
            if (this.f3289D != null) {
                DataUsageBytes k = m5497k();
                a5.m5084a("bytes_rx", k.m9248a() - this.f3289D.m9248a());
                a5.m5084a("bytes_tx", k.m9250b() - this.f3289D.m9250b());
                this.f3289D = null;
            }
            if (this.f3301l.nextInt() % 1000 == 0) {
                this.f3289D = m5497k();
            }
            ((AnalyticsLogger) this.f3303n.get()).mo533c(a5.m5108a(a4).m5109a("resume_upload", "1"));
            if (z) {
                a = this.f3297h.m5547a(str5, str6, a2);
            } else {
                a = this.f3297h.m5552b(str5, str6, a2);
            }
            m5498a(null);
            m5514b(null);
            this.f3288C++;
        }
        if (a != null) {
            a.m13033a();
        }
    }

    public final void m5502a(@Nullable Activity activity, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, ?> map) {
        Map map2;
        Context context;
        if (map == null) {
            map2 = RegularImmutableBiMap.f695a;
        } else {
            Map<String, ?> map3 = map;
        }
        if (activity == null || (activity instanceof AnalyticsActivity)) {
            context = activity;
        } else {
            map2 = m5477a((Object) activity, map2);
            context = null;
        }
        m5486a((AnalyticsActivity) context, context, str, str2, str3, map2, true);
    }

    private void m5482a(@Nullable Fragment fragment, @Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, ?> map) {
        Fragment fragment2;
        Map a;
        if (fragment == null || (fragment instanceof AnalyticsActivity)) {
            Map<String, ?> map2 = map;
            fragment2 = fragment;
        } else {
            a = m5477a((Object) fragment, (Map) map);
            fragment2 = null;
        }
        m5486a((AnalyticsActivity) fragment2, context, str, str2, str3, a, true);
    }

    public final void m5507a(Fragment fragment, Context context, Map<String, ?> map) {
        m5482a(fragment, context, null, null, null, map);
    }

    public final void m5506a(Fragment fragment, Context context) {
        m5482a(fragment, context, null, null, null, null);
    }

    public final void m5504a(@Nullable Activity activity, @Nullable Map<String, ?> map) {
        m5502a(activity, null, null, null, (Map) map);
    }

    public final void m5501a(Activity activity) {
        m5502a(activity, null, null, null, null);
    }

    public final synchronized void m5503a(@Nullable Activity activity, @Nullable String str, @Nullable String str2, @Nullable Map<String, ?> map) {
        ((AnalyticsLogger) this.f3303n.get()).mo533c(ClickEventCreator.a(activity, str, str2, map));
    }

    public final synchronized void m5509a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, ?> map) {
        ((AnalyticsLogger) this.f3303n.get()).mo533c(ClickEventCreator.a(str, str2, str3, map));
    }

    public final synchronized void m5517b(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, ?> map) {
        ((AnalyticsLogger) this.f3303n.get()).mo526a(ClickEventCreator.a(str, str2, str3, map));
    }

    public final synchronized void m5513a(Map<String, String> map) {
        this.f3295f.m5543a(true);
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("log_in");
        honeyClientEvent.m5109a("resume_upload", "1");
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                honeyClientEvent.m5090b((String) entry.getKey(), (String) entry.getValue());
            }
        }
        ((AnalyticsLogger) this.f3303n.get()).mo533c(honeyClientEvent);
    }

    public final synchronized void m5520d() {
        m5488a(true);
        ((AnalyticsLogger) this.f3303n.get()).mo533c(new HoneyClientEvent("log_out"));
        this.f3295f.m5544b();
    }

    public final synchronized void m5521e() {
        this.f3295f.m5543a(true);
        m5488a(false);
        ((AnalyticsLogger) this.f3303n.get()).mo533c(new HoneyClientEvent("silent_login").m5109a("resume_upload", "1"));
    }

    private boolean m5493g() {
        return ((Boolean) this.f3298i.get()).booleanValue();
    }

    private void m5481a(long j, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("session_end");
        honeyClientEvent.f3102f = str;
        honeyClientEvent.m5109a("session_timeout", "1").m5109a("stop_upload", "1").f3112e = j;
        AnalyticsConnectionUtils analyticsConnectionUtils = (AnalyticsConnectionUtils) this.f3302m.get();
        this.f3304o.get();
        analyticsConnectionUtils.m12220b(honeyClientEvent);
        ((AnalyticsLogger) this.f3303n.get()).mo533c(honeyClientEvent);
        ((ConnectionStatusLogger) this.f3304o.get()).f7640k = true;
    }

    public final synchronized void m5500a(int i, boolean z) {
        ((AnalyticsLogger) this.f3303n.get()).mo526a(new HoneyClientEvent("orientation").m5090b("module", "device").m5090b("containermodule", this.f3297h.m5549a("unknown")).m5083a("orientation_start", this.f3313x).m5083a("orientation_end", i).m5090b("event_trigger", z ? "foreground" : "orientation_change"));
        this.f3313x = i;
    }

    public final void m5516b(Activity activity) {
        synchronized (this) {
            this.f3309t.add(activity);
            m5494h();
            m5496j();
        }
        if (!(activity instanceof ManualAnalyticsNavigationActivity)) {
            m5501a(activity);
        }
        if (!this.f3299j.getString(2131230720).equalsIgnoreCase("messenger".toString())) {
            if (this.f3307r == null) {
                this.f3307r = this.f3308s.m2951a().mo506a("chat_heads_status_change", new 1(this)).mo503a();
            }
            if (m5493g()) {
                this.f3307r.m3296b();
            }
        }
    }

    public final synchronized void m5518c(Activity activity) {
        if (this.f3309t.remove(activity) && this.f3309t.isEmpty()) {
            final long a = this.f3290a.mo211a();
            if (this.f3287B != null) {
                BLog.c("NavigationLogger", "Previous sendToBackgroundDetector is still alive");
                HandlerDetour.a(this.f3291b, this.f3287B);
                this.f3287B = null;
            }
            if (!this.f3286A) {
                this.f3287B = new Runnable(this) {
                    final /* synthetic */ NavigationLogger f8823b;

                    public void run() {
                        NavigationLogger.m5484a(this.f8823b, a);
                    }
                };
                HandlerDetour.b(this.f3291b, this.f3287B, 5000, -1147623451);
            }
            String b = this.f3294e.m5539b((Context) activity);
            if (this.f3286A) {
                m5481a(a, b);
                m5488a(false);
            }
        }
        if (m5493g() && this.f3307r != null && this.f3307r.m3295a()) {
            this.f3314y = false;
            this.f3307r.m3297c();
        }
    }

    private void m5494h() {
        if (this.f3287B != null) {
            HandlerDetour.a(this.f3291b, this.f3287B);
            this.f3287B = null;
        }
    }

    private boolean m5495i() {
        return this.f3300k.m2189a(471, false);
    }

    private void m5483a(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (m5495i()) {
            ((SessionManager) this.f3306q.get()).m5301c();
        } else {
            honeyAnalyticsEvent.m5109a("new_session", "1");
        }
        ((AnalyticsLogger) this.f3303n.get()).mo533c(honeyAnalyticsEvent);
    }

    private synchronized void m5496j() {
        if (this.f3315z) {
            this.f3315z = false;
            if (m5499a() == null) {
                m5498a("foreground");
            }
            final long a = this.f3290a.mo211a();
            HandlerDetour.a(this.f3291b, new Runnable(this) {
                final /* synthetic */ NavigationLogger f8464b;

                public void run() {
                    this.f8464b.m5483a(NavigationLogger.m5476a(this.f8464b, a, AnalyticsEventNames$AppStateNames.FOREGROUNDED));
                }
            }, -2055077810);
        }
    }

    private void m5487a(com.facebook.inject.Lazy<AnalyticsConnectionUtils> lazy, com.facebook.inject.Lazy<AnalyticsLogger> lazy2, com.facebook.inject.Lazy<ConnectionStatusLogger> lazy3, com.facebook.inject.Lazy<FbTrafficStats> lazy4, com.facebook.inject.Lazy<SessionManager> lazy5) {
        this.f3302m = lazy;
        this.f3303n = lazy2;
        this.f3304o = lazy3;
        this.f3305p = lazy4;
        this.f3306q = lazy5;
    }

    public static HoneyClientEvent m5476a(NavigationLogger navigationLogger, long j, AnalyticsEventNames$AppStateNames analyticsEventNames$AppStateNames) {
        HoneyAnalyticsEvent b = new HoneyClientEvent("app_state").m5090b("state", analyticsEventNames$AppStateNames.toString());
        b.f3099c = "app";
        HoneyAnalyticsEvent honeyAnalyticsEvent = b;
        honeyAnalyticsEvent.f3112e = j;
        NetworkInfo c = navigationLogger.f3293d.m5535c();
        honeyAnalyticsEvent.m5090b("connection", c != null ? c.getTypeName() : "null");
        return honeyAnalyticsEvent;
    }

    private void m5491b(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (m5495i()) {
            ((SessionManager) this.f3306q.get()).m5300b();
        } else {
            honeyAnalyticsEvent.m5109a("new_session", "1");
        }
        ((AnalyticsLogger) this.f3303n.get()).mo533c(honeyAnalyticsEvent);
    }

    public static synchronized void m5484a(NavigationLogger navigationLogger, long j) {
        synchronized (navigationLogger) {
            if (!navigationLogger.f3315z) {
                AnalyticsEventNames$AppStateNames analyticsEventNames$AppStateNames = AnalyticsEventNames$AppStateNames.BACKGROUNDED;
                if (!navigationLogger.f3292c.isScreenOn()) {
                    analyticsEventNames$AppStateNames = AnalyticsEventNames$AppStateNames.RESIGN;
                }
                HoneyAnalyticsEvent a = m5476a(navigationLogger, j, analyticsEventNames$AppStateNames);
                a.m5109a("upload_batch_now", "1");
                AnalyticsConnectionUtils analyticsConnectionUtils = (AnalyticsConnectionUtils) navigationLogger.f3302m.get();
                navigationLogger.f3304o.get();
                analyticsConnectionUtils.m12220b((HoneyClientEvent) a);
                if (navigationLogger.f3310u != null) {
                    a.m5090b("click_point", navigationLogger.f3310u);
                    navigationLogger.m5498a(null);
                }
                navigationLogger.m5491b(a);
                navigationLogger.f3315z = true;
                if (!navigationLogger.f3296g.m2266o()) {
                    navigationLogger.f3297h.m5556d();
                }
                ((ConnectionStatusLogger) navigationLogger.f3304o.get()).m12206a();
            }
        }
    }

    private DataUsageBytes m5497k() {
        return ((FbTrafficStats) this.f3305p.get()).m9239a(Process.myUid(), 0);
    }

    private static Object m5479a(@Nullable Object obj) {
        Object obj2 = obj;
        while (true) {
            if (!(obj2 instanceof ContentFragmentContainer) && !(obj2 instanceof FbChromeFragment)) {
                break;
            }
            if (obj2 instanceof ContentFragmentContainer) {
                obj = ((ContentFragmentContainer) obj2).mo783a();
            } else {
                Fragment aq = ((FbChromeFragment) obj2).aq();
            }
            if (obj == null) {
                break;
            }
            obj2 = obj;
        }
        return obj2;
    }

    private static ImmutableMap<String, ?> m5477a(@Nullable Object obj, @Nullable Map<String, ?> map) {
        Object a = m5479a(obj);
        if (a == null) {
            return RegularImmutableBiMap.f695a;
        }
        Builder builder = ImmutableMap.builder();
        if (map == null) {
            Object obj2 = RegularImmutableBiMap.f695a;
        }
        return builder.m608a(r5).m609b("dest_module_class", a.getClass().getSimpleName()).m610b();
    }

    private static ImmutableMap<String, ?> m5478a(Map<String, ?> map, AnalyticsActivityWithExtraData analyticsActivityWithExtraData) {
        Map c = analyticsActivityWithExtraData.mo792c();
        if (c == null) {
            return ImmutableMap.copyOf((Map) map);
        }
        if (map == null) {
            return ImmutableMap.copyOf(c);
        }
        return ImmutableMap.builder().m608a((Map) map).m608a(c).m610b();
    }

    private void m5488a(boolean z) {
        this.f3286A = z;
    }
}
