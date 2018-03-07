package com.facebook.analytics.analyticsmodule;

import android.accounts.AccountManager;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.ILegacyPeriodicEventReporter;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.analytics.reporters.periodic.C0475x5d8f5f3;
import com.facebook.analytics.reporters.periodic.DeviceInfoPeriodicReporterAdditionalInfo;
import com.facebook.analytics.storagereportingutil.StorageReportingUtil;
import com.facebook.common.android.ActivityManagerMethodAutoProvider;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.android.String_PackageNameMethodAutoProvider;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.cpu.ProcessorInfoUtil;
import com.facebook.common.cpu.ProcessorInfoUtilMethodAutoProvider;
import com.facebook.common.deviceinfo.DeviceInfoCore;
import com.facebook.common.deviceinfo.DeviceInfoLocale;
import com.facebook.common.hardware.TelephonyManagerUtils;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.StringUtil;
import com.facebook.content.AppInfo;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommon.LanguageSwitcherCommon;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.telephony.FbTelephonyManager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: image_ranges */
public class DeviceInfoPeriodicReporter implements ILegacyPeriodicEventReporter {
    private static final Class<?> f10472a = DeviceInfoPeriodicReporter.class;
    private static volatile DeviceInfoPeriodicReporter f10473r;
    private final Context f10474b;
    private final FbSharedPreferences f10475c;
    private final PackageManager f10476d;
    private final ActivityManager f10477e;
    private final TelephonyManager f10478f;
    private final Locales f10479g;
    private final ProcessorInfoUtil f10480h;
    private final Boolean f10481i;
    private final Iterable<DeviceInfoPeriodicReporterAdditionalInfo> f10482j;
    private final StorageReportingUtil f10483k;
    private final Provider<Boolean> f10484l;
    private final FbTelephonyManager f10485m;
    private final Provider<Boolean> f10486n;
    private final String f10487o;
    private final LanguageSwitcherCommon f10488p;
    private final Provider<String> f10489q;

    /* compiled from: image_ranges */
    class AppStoreSupportStatus {
        public final String f10837a;
        public final int f10838b;
        public final InstallationStatus f10839c;

        /* compiled from: image_ranges */
        enum InstallationStatus {
            SERVICE_ENABLED,
            SERVICE_DISABLED,
            SERVICE_INVALID,
            SERVICE_MISSING
        }

        AppStoreSupportStatus(String str, InstallationStatus installationStatus, int i) {
            this.f10837a = str;
            this.f10838b = i;
            this.f10839c = installationStatus;
        }
    }

    public static com.facebook.analytics.analyticsmodule.DeviceInfoPeriodicReporter m11025a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10473r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.analyticsmodule.DeviceInfoPeriodicReporter.class;
        monitor-enter(r1);
        r0 = f10473r;	 Catch:{ all -> 0x003a }
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
        r0 = m11032b(r0);	 Catch:{ all -> 0x0035 }
        f10473r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10473r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.analyticsmodule.DeviceInfoPeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.analyticsmodule.DeviceInfoPeriodicReporter");
    }

    private static DeviceInfoPeriodicReporter m11032b(InjectorLike injectorLike) {
        return new DeviceInfoPeriodicReporter((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), ActivityManagerMethodAutoProvider.a(injectorLike), TelephonyManagerMethodAutoProvider.a(injectorLike), Locales.a(injectorLike), ProcessorInfoUtilMethodAutoProvider.a(injectorLike), Boolean_IsTabletMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3878), C0475x5d8f5f3.m11041a(injectorLike), StorageReportingUtil.m11042a(injectorLike), FbTelephonyManager.a(injectorLike), IdBasedProvider.a(injectorLike, 3880), String_PackageNameMethodAutoProvider.a(injectorLike), LanguageSwitcherCommon.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public DeviceInfoPeriodicReporter(Context context, FbSharedPreferences fbSharedPreferences, PackageManager packageManager, ActivityManager activityManager, TelephonyManager telephonyManager, Locales locales, ProcessorInfoUtil processorInfoUtil, Boolean bool, Provider<Boolean> provider, Set<DeviceInfoPeriodicReporterAdditionalInfo> set, StorageReportingUtil storageReportingUtil, FbTelephonyManager fbTelephonyManager, Provider<Boolean> provider2, String str, LanguageSwitcherCommon languageSwitcherCommon, Provider<String> provider3) {
        this.f10474b = context;
        this.f10475c = fbSharedPreferences;
        this.f10476d = packageManager;
        this.f10477e = activityManager;
        this.f10478f = telephonyManager;
        this.f10479g = locales;
        this.f10480h = processorInfoUtil;
        this.f10481i = bool;
        this.f10484l = provider;
        this.f10482j = ImmutableSet.copyOf(set);
        this.f10483k = storageReportingUtil;
        this.f10485m = fbTelephonyManager;
        this.f10486n = provider2;
        this.f10487o = str;
        this.f10488p = languageSwitcherCommon;
        this.f10489q = provider3;
    }

    public final long mo803a() {
        if (!this.f10475c.a()) {
            return 86400000;
        }
        if (!this.f10475c.a(AnalyticsPrefKeys.e) && m11029a((String) this.f10489q.get()) && this.f10475c.a(AnalyticsPrefKeys.a((String) this.f10489q.get()), false)) {
            return 5000;
        }
        return this.f10475c.a(AnalyticsPrefKeys.e, 86400000);
    }

    public final HoneyAnalyticsEvent mo804a(long j, String str) {
        return m11031b(j, str);
    }

    private HoneyAnalyticsEvent m11031b(long j, String str) {
        String format3339;
        String format33392;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("device_info");
        honeyClientEvent.a(j);
        honeyClientEvent.d(str);
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (int i = 0; i < 2; i++) {
            ObjectNode a = m11026a(i, str);
            if (a != null) {
                arrayNode.a(a);
            }
        }
        honeyClientEvent.a("sim_info", arrayNode);
        honeyClientEvent.a(DeviceInfoLocale.m11068a(this.f10479g));
        honeyClientEvent.a(DeviceInfoCore.m11069a(this.f10474b));
        honeyClientEvent.b("supported_fb4a_locales", TextUtils.join(",", this.f10488p.c().toArray()));
        DisplayMetrics displayMetrics = this.f10474b.getResources().getDisplayMetrics();
        Point b = m11030b();
        for (DeviceInfoPeriodicReporterAdditionalInfo a2 : this.f10482j) {
            a2.mo805a(honeyClientEvent);
        }
        honeyClientEvent.b("cpu_abi", Build.CPU_ABI);
        honeyClientEvent.b("cpu_abi2", Build.CPU_ABI2);
        honeyClientEvent.a("unreliable_core_count", this.f10480h.c());
        honeyClientEvent.a("reliable_core_count", this.f10480h.b());
        honeyClientEvent.a("cpu_max_freq", this.f10480h.e());
        if (this.f10480h.f().intValue() != -1) {
            honeyClientEvent.a("low_power_cpu_max_freq", this.f10480h.f());
        }
        honeyClientEvent.a("cgroups_supported", m11036d());
        honeyClientEvent.a("is_tablet", this.f10481i);
        boolean z = (this.f10474b.getApplicationInfo().flags & 2) != 0;
        if (z) {
            honeyClientEvent.a("is_debuggable", z);
        }
        try {
            PackageInfo packageInfo = this.f10476d.getPackageInfo(this.f10487o, 0);
            Time time = new Time();
            time.set(packageInfo.firstInstallTime);
            format3339 = time.format3339(false);
            Time time2 = new Time();
            time2.set(packageInfo.lastUpdateTime);
            format33392 = time2.format3339(false);
            if (VERSION.SDK_INT >= 21) {
                String d = new AppInfo(this.f10476d, this.f10476d.getApplicationInfo(this.f10487o, 0)).d("com.google.android.webview");
                if (d != null) {
                    honeyClientEvent.b("webview_version", d);
                }
            }
        } catch (NameNotFoundException e) {
            format3339 = "unknown";
            format33392 = "unknown";
        }
        honeyClientEvent.b("first_install_time", format3339);
        honeyClientEvent.b("last_upgrade_time", format33392);
        m11028a(honeyClientEvent);
        honeyClientEvent.a("density", (double) displayMetrics.density);
        honeyClientEvent.a("screen_width", b.x);
        honeyClientEvent.a("screen_height", b.y);
        honeyClientEvent.a("front_camera", this.f10476d.hasSystemFeature("android.hardware.camera.front"));
        honeyClientEvent.a("rear_camera", this.f10476d.hasSystemFeature("android.hardware.camera"));
        honeyClientEvent.b("allows_non_market_installs", Secure.getString(this.f10474b.getContentResolver(), "install_non_market_apps"));
        honeyClientEvent.b("android_id", Secure.getString(this.f10474b.getContentResolver(), "android_id"));
        ConfigurationInfo deviceConfigurationInfo = this.f10477e.getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            honeyClientEvent.a("opengl_version", deviceConfigurationInfo.reqGlEsVersion);
        }
        AppStoreSupportStatus c = m11034c();
        honeyClientEvent.b("google_play_services_installation", c.f10839c.name());
        honeyClientEvent.a("google_play_services_version", c.f10838b);
        m11033b(honeyClientEvent);
        m11035c(honeyClientEvent);
        AccountManager accountManager = AccountManager.get(this.f10474b);
        if (this.f10474b.checkCallingOrSelfPermission("android.permission.GET_ACCOUNTS") == 0) {
            honeyClientEvent.a("google_accounts", accountManager.getAccountsByType("com.google").length);
        }
        try {
            format33392 = this.f10476d.getInstallerPackageName(this.f10487o);
        } catch (IllegalArgumentException e2) {
            format33392 = "unknown";
        }
        format3339 = "installer";
        if (format33392 == null) {
            format33392 = "";
        }
        honeyClientEvent.b(format3339, format33392);
        if (((Boolean) this.f10484l.get()).booleanValue()) {
            c = m11024a(Lists.a(new String[]{"com.amazon.venezia", "com.amazon.mShop.android"}));
            if (c.f10839c != InstallationStatus.SERVICE_MISSING) {
                honeyClientEvent.a("amazon_app_store_installation_status", m11027a(c));
            }
        }
        honeyClientEvent.g("device");
        honeyClientEvent.a(this.f10483k.m11043a());
        return honeyClientEvent;
    }

    private ObjectNode m11026a(int i, String str) {
        int i2 = this.f10485m.i(i);
        if (i2 == -1) {
            if (!StringUtil.a(new CharSequence[]{str}) && i == 0) {
                this.f10475c.edit().a(AnalyticsPrefKeys.a(str)).commit();
            }
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("index", i);
        objectNode.a("state", TelephonyManagerUtils.c(i2));
        objectNode.a("carrier", this.f10485m.a(i));
        objectNode.a("carrier_country_iso", this.f10485m.b(i));
        objectNode.a("network_type", TelephonyManagerUtils.a(this.f10485m.c(i)));
        objectNode.a("phone_type", TelephonyManagerUtils.b(this.f10485m.d(i)));
        objectNode.a("country_iso", this.f10485m.e(i));
        if (i2 == 5) {
            objectNode.a("operator", this.f10485m.f(i));
        }
        if (m11029a(str)) {
            this.f10475c.edit().a(AnalyticsPrefKeys.a(str)).commit();
            objectNode.a("phone_number", this.f10485m.g(i));
            try {
                ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                Map h = this.f10485m.h(i);
                if (h != null) {
                    for (Entry entry : h.entrySet()) {
                        objectNode2.a((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                objectNode.c("phone_number_by_library", objectNode2);
            } catch (Throwable e) {
                BLog.b(f10472a, "Error attempting to convert phone number Map to ObjectNode.", e);
            }
        }
        objectNode.a("serial_number", this.f10485m.j(i));
        objectNode.a("subscriber_id", this.f10485m.k(i));
        return objectNode;
    }

    private boolean m11029a(String str) {
        if (((Boolean) this.f10486n.get()).booleanValue()) {
            if (!StringUtil.a(new CharSequence[]{str})) {
                return true;
            }
        }
        return false;
    }

    private static ObjectNode m11027a(AppStoreSupportStatus appStoreSupportStatus) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("package_name", appStoreSupportStatus.f10837a);
        objectNode.a("version", appStoreSupportStatus.f10838b);
        objectNode.a("installation_status", appStoreSupportStatus.f10839c.name());
        return objectNode;
    }

    @TargetApi(18)
    private void m11028a(HoneyClientEvent honeyClientEvent) {
        if (VERSION.SDK_INT >= 18 && this.f10476d.checkPermission("android.permission.READ_PHONE_STATE", this.f10474b.getPackageName()) == 0) {
            honeyClientEvent.b("GID1", this.f10478f.getGroupIdLevel1());
        }
    }

    @TargetApi(14)
    private Point m11030b() {
        Point point = new Point();
        ((WindowManager) this.f10474b.getSystemService("window")).getDefaultDisplay().getSize(point);
        return point;
    }

    private AppStoreSupportStatus m11034c() {
        try {
            this.f10476d.getPackageInfo("com.android.vending", 64);
            return m11024a(Lists.a(new String[]{"com.google.android.gms"}));
        } catch (NameNotFoundException e) {
            return new AppStoreSupportStatus("com.android.vending", InstallationStatus.SERVICE_MISSING, -1);
        }
    }

    private AppStoreSupportStatus m11024a(List<String> list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                PackageInfo packageInfo = this.f10476d.getPackageInfo(str, 64);
                try {
                    if (this.f10476d.getApplicationInfo(str, 0).enabled) {
                        return new AppStoreSupportStatus(str, InstallationStatus.SERVICE_ENABLED, packageInfo.versionCode);
                    }
                    return new AppStoreSupportStatus(str, InstallationStatus.SERVICE_DISABLED, packageInfo.versionCode);
                } catch (NameNotFoundException e) {
                }
            } catch (NameNotFoundException e2) {
            }
        }
        return new AppStoreSupportStatus("", InstallationStatus.SERVICE_MISSING, -1);
    }

    private void m11033b(HoneyClientEvent honeyClientEvent) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        Iterator it = Arrays.asList(new String[]{"com.android.vending", "com.google.market", "com.google.android.finsky"}).iterator();
        while (it.hasNext()) {
            AppStoreSupportStatus a = m11024a(Arrays.asList(new String[]{(String) it.next()}));
            if (a.f10839c != InstallationStatus.SERVICE_MISSING) {
                arrayNode.a(m11027a(a));
            }
        }
        honeyClientEvent.a("google_play_store", arrayNode);
    }

    private void m11035c(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.a("gsf_installation_status", m11027a(m11024a(Arrays.asList(new String[]{"com.google.android.gsf"}))));
    }

    private static boolean m11036d() {
        try {
            return new File("/dev/cpuctl/tasks").exists();
        } catch (Exception e) {
            return false;
        }
    }
}
