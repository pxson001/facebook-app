package com.facebook.selfupdate;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.alarm.FbAlarmManager;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.server.ServerConfig;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.downloader.DownloadRequest.Builder;
import com.facebook.downloader.DownloadRequest.DownloadType;
import com.facebook.downloader.DownloadRequestFactory;
import com.facebook.downloader.FbDownloadManager;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.orca.FbandroidProductionConfig;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.oxygen.appmanager.protocol.constants.ProtocolConstants.ClientAction;
import com.facebook.oxygen.appmanager.protocol.constants.ProtocolConstants.DownloadNetworks;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresence;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresenceMethodAutoProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.selfupdate.annotations.IsInternalOxygenBasedSelfUpdateEnabledGK;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Provider;

@TargetApi(9)
/* compiled from: has_seen_audio_nux */
public class SelfUpdateFetchService extends FbIntentService {
    private static final Class<?> f9975o = SelfUpdateFetchService.class;
    @Inject
    AppVersionInfo f9976a;
    @Inject
    SelfUpdateLogger f9977b;
    @Inject
    FbSharedPreferences f9978c;
    @Inject
    FbAlarmManagerImpl f9979d;
    @Inject
    Clock f9980e;
    @Inject
    Context f9981f;
    @Inject
    DownloadRequestFactory f9982g;
    @Inject
    FbDownloadManager f9983h;
    @Inject
    SelfUpdateChecker f9984i;
    @Inject
    SelfUpdateDataFetcher f9985j;
    @Inject
    ServerConfig f9986k;
    @Inject
    PreloadSdkPresence f9987l;
    @Inject
    @IsInternalOxygenBasedSelfUpdateEnabledGK
    Provider<Boolean> f9988m;
    @Inject
    DeviceConditionHelper f9989n;

    private static <T extends Context> void m10083a(Class<T> cls, T t) {
        m10084a((Object) t, (Context) t);
    }

    public static void m10084a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SelfUpdateFetchService) obj).m10082a(AppVersionInfoMethodAutoProvider.a(fbInjector), SelfUpdateLogger.b(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), FbAlarmManagerImpl.a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), (Context) fbInjector.getInstance(Context.class), DownloadRequestFactory.a(fbInjector), FbDownloadManager.a(fbInjector), SelfUpdateChecker.b(fbInjector), SelfUpdateDataFetcher.b(fbInjector), (ServerConfig) FbandroidProductionConfig.a(fbInjector), PreloadSdkPresenceMethodAutoProvider.b(fbInjector), IdBasedProvider.a(fbInjector, 4326), DeviceConditionHelper.a(fbInjector));
    }

    private void m10082a(AppVersionInfo appVersionInfo, SelfUpdateLogger selfUpdateLogger, FbSharedPreferences fbSharedPreferences, FbAlarmManager fbAlarmManager, Clock clock, Context context, DownloadRequestFactory downloadRequestFactory, FbDownloadManager fbDownloadManager, SelfUpdateChecker selfUpdateChecker, SelfUpdateDataFetcher selfUpdateDataFetcher, ServerConfig serverConfig, PreloadSdkPresence preloadSdkPresence, Provider<Boolean> provider, DeviceConditionHelper deviceConditionHelper) {
        this.f9976a = appVersionInfo;
        this.f9977b = selfUpdateLogger;
        this.f9978c = fbSharedPreferences;
        this.f9979d = fbAlarmManager;
        this.f9980e = clock;
        this.f9981f = context;
        this.f9982g = downloadRequestFactory;
        this.f9983h = fbDownloadManager;
        this.f9984i = selfUpdateChecker;
        this.f9985j = selfUpdateDataFetcher;
        this.f9986k = serverConfig;
        this.f9987l = preloadSdkPresence;
        this.f9988m = provider;
        this.f9989n = deviceConditionHelper;
    }

    public SelfUpdateFetchService() {
        super("SelfUpdateFetchService");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 174464431);
        super.onCreate();
        setIntentRedelivery(true);
        AppInitLockHelper.a(this);
        Class cls = SelfUpdateFetchService.class;
        m10084a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1432045832, a);
    }

    public final void m10089a(Intent intent) {
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("force_update", false);
            if (booleanExtra || this.f9984i.a()) {
                Object obj;
                long b;
                String a = m10079a(this.f9981f);
                String a2 = StringFormatUtil.a(getString(2131236756), new Object[]{a});
                SelfUpdateChecker selfUpdateChecker = this.f9984i;
                boolean c = selfUpdateChecker.c();
                String a3 = selfUpdateChecker.h.a(SelfUpdateConstants.E, "default");
                if (a3.equals("oxygen") || (c && !a3.equals("fql"))) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    this.f9977b.a("selfupdate_start_fetching_from_oxygen", null);
                    b = m10087b(booleanExtra, a, a2);
                } else {
                    this.f9977b.a("selfupdate_start_fetching_from_fql", null);
                    b = m10078a(booleanExtra, a, a2);
                }
                if (this.f9984i.a()) {
                    m10081a(b);
                }
            }
        }
    }

    private long m10078a(boolean z, String str, String str2) {
        HashMap hashMap = new HashMap();
        AppServerResponse a = this.f9985j.a(z);
        if (a == null) {
            hashMap.put("response_null", Boolean.valueOf(true));
            this.f9977b.a("selfupdate_skip_fql_download", hashMap);
            return 43200000;
        }
        hashMap.put("response_release", Integer.valueOf(a.f9944d));
        hashMap.put("response_updatecheckms", Long.valueOf(a.m10071c()));
        hashMap.put("update_available", Boolean.valueOf(a.m10069a()));
        hashMap.put("force_download", Boolean.valueOf(z));
        hashMap.put("download_pending", Boolean.valueOf(m10088c()));
        hashMap.put("update_critical", Boolean.valueOf(a.m10070b()));
        boolean a2 = m10085a(a.m10070b(), a.f9944d);
        hashMap.put("download_postponed", Boolean.valueOf(a2));
        if (!a.m10069a() || (!z && (m10088c() || a2))) {
            this.f9977b.a("selfupdate_skip_fql_download", hashMap);
            return a.m10071c();
        }
        hashMap.put("preload_sdk_present", Boolean.valueOf(this.f9987l.b()));
        m10080a(a.f9944d, a.f9946f, a.f9947g, a.m10070b(), a.f9949i, a.f9941a, a.f9951k, a.f9952l, m10077a(a.f9946f, a.f9950j, a.f9952l, str2, z), str, "fql");
        this.f9977b.a("selfupdate_queue_download_from_fql", hashMap);
        return a.m10071c();
    }

    private long m10087b(boolean z, String str, String str2) {
        HashMap hashMap = new HashMap();
        OxygenQueryResponse b = this.f9985j.b(z);
        if (b != null) {
            boolean equals = b.f9956a.equals(ClientAction.UPDATE_AUTO_APPROVAL);
            hashMap.put("update_critical", Boolean.valueOf(equals));
            Integer.valueOf(b.f9961f);
            hashMap.put("response_downloadurl_null", Boolean.valueOf(b.f9958c == null));
            hashMap.put("force_download", Boolean.valueOf(z));
            hashMap.put("download_pending", Boolean.valueOf(m10088c()));
            boolean a = m10085a(equals, b.f9961f);
            hashMap.put("download_postponed", Boolean.valueOf(a));
            if (b.f9958c != null && (z || !(m10088c() || a))) {
                b.f9957b.name();
                Boolean.valueOf(z);
                if (!(z || b.f9957b != DownloadNetworks.WIFI || this.f9989n.b())) {
                    this.f9977b.a("download_not_started_due_to_no_wifi_connected", null);
                }
                long a2 = m10077a(b.f9958c, b.f9957b.asInt(), b.f9959d, str2, z);
                Long.valueOf(a2);
                m10080a(b.f9961f, b.f9958c, "", equals, b.f9964i, "", b.f9965j, b.f9959d, a2, str, "oxygen");
                hashMap.put("version", Integer.toString(b.f9961f));
                hashMap.put("download_url", b.f9958c);
                hashMap.put("allowed_networks", b.f9957b.name());
                this.f9977b.a("selfupdate_get_response_queue_download_from_oxygen", hashMap);
                return m10086b();
            }
        }
        hashMap.put("response_null", Boolean.valueOf(true));
        this.f9977b.a("selfupdate_skip_oxygen_download", hashMap);
        return m10086b();
    }

    private long m10086b() {
        return ((Boolean) this.f9988m.get()).booleanValue() ? 43200000 : 259200000;
    }

    private void m10080a(int i, String str, String str2, boolean z, String str3, String str4, String str5, long j, long j2, String str6, String str7) {
        if (j2 != -1) {
            this.f9978c.edit().a(SelfUpdateConstants.d, i).a(SelfUpdateConstants.g, j2).a(SelfUpdateConstants.e, str).a(SelfUpdateConstants.f, str2).putBoolean(SelfUpdateConstants.i, z).a(SelfUpdateConstants.j, str6).a(SelfUpdateConstants.k, str3).a(SelfUpdateConstants.n, 1).a(SelfUpdateConstants.o, str4).a(SelfUpdateConstants.p, str5).a(SelfUpdateConstants.q, j).a(SelfUpdateConstants.r, str7).commit();
        }
    }

    private boolean m10088c() {
        if (this.f9978c.a(SelfUpdateConstants.n, 0) != 0) {
            return true;
        }
        return false;
    }

    private boolean m10085a(boolean z, int i) {
        if (z || this.f9978c.a(SelfUpdateConstants.l, 0) != i) {
            return false;
        }
        if (this.f9980e.a() < this.f9978c.a(SelfUpdateConstants.m, 0)) {
            return true;
        }
        return false;
    }

    @TargetApi(11)
    private long m10077a(String str, int i, long j, String str2, boolean z) {
        Builder a = Builder.a();
        a.a = DownloadType.APP_UPDATE;
        a = a;
        a.b = str;
        a = a;
        a.c = DownloadRequestFactory.a(i);
        a = a;
        a.d = str2;
        a = a;
        a.e = j;
        a = a;
        a.f = z;
        a = a;
        a.h = this.f9986k.d();
        return this.f9983h.a(a.b());
    }

    private static String m10079a(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : "";
    }

    private void m10081a(long j) {
        long j2 = 259200000;
        long j3 = 300000;
        if (j <= 259200000) {
            j2 = j;
        }
        if (j2 >= 300000) {
            j3 = j2;
        }
        j2 = this.f9980e.a() + j3;
        this.f9978c.edit().a(SelfUpdateConstants.b, j2).a(SelfUpdateConstants.c, j3).commit();
        Intent intent = new Intent(this.f9981f, SelfUpdateFetchService.class);
        intent.putExtra("force_update", false);
        PendingIntent service = PendingIntent.getService(this.f9981f, 0, intent, 0);
        FbAlarmManagerImpl fbAlarmManagerImpl = this.f9979d;
        if (VERSION.SDK_INT < 19) {
            fbAlarmManagerImpl.a.set(1, j2, service);
        } else {
            fbAlarmManagerImpl.a.setExact(1, j2, service);
        }
    }
}
