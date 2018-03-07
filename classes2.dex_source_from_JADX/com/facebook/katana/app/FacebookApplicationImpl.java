package com.facebook.katana.app;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.facebook.apptab.state.TabTag;
import com.facebook.backgroundtasks.BackgroundTaskController;
import com.facebook.base.app.AbstractApplicationLike;
import com.facebook.base.app.LightweightPerfEvents;
import com.facebook.base.app.LightweightPerfEvents.Marker;
import com.facebook.base.lwperf.perfstats.BackgroundChecker;
import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.build.SignatureType;
import com.facebook.common.dextricks.DalvikInternals;
import com.facebook.common.dextricks.DexErrorRecoveryInfo;
import com.facebook.common.dextricks.DexLibLoader;
import com.facebook.common.errorreporting.AcraBLogBridge;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.init.AppInitLock.Listener;
import com.facebook.common.process.ProcessName;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.udppriming.client.ColdStartPrimingInformation;
import com.facebook.common.udppriming.client.EncryptChannelInformation;
import com.facebook.common.udppriming.client.UDPPrimingDNSInfo;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.SignatureTypeMethodAutoProvider;
import com.facebook.contacts.background.ContactsTaskTag;
import com.facebook.dalviktelemetry.DalvikTelemetry;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.common.FbandroidProcessName;
import com.facebook.loom.core.LoomColdStartTraceInitializer;
import com.facebook.messaging.background.MessagesDataTaskTag;
import com.facebook.messaging.background.MessagesLocalTaskTag;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.reportaproblem.base.ReportAProblem;
import com.facebook.reportaproblem.fb.FbReportAProblemConfigProvider;
import com.facebook.resources.HasOverridingResources;
import com.facebook.strictmode.StrictModeAggregator;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

@DoNotStrip
/* compiled from: • */
public class FacebookApplicationImpl extends AbstractApplicationLike implements HasOverridingResources {
    public static final String f0j = FacebookApplication.class.getSimpleName();
    private final Context f1k;
    public FbandroidProcessName f2l;
    private final long f3m;
    private final PerfStats f4n;
    private LightweightPerfEvents f5o;
    private boolean f6p = false;
    private boolean f7q = false;

    /* compiled from: • */
    class C00201 implements Runnable {
        final /* synthetic */ FacebookApplicationImpl f495a;

        C00201(FacebookApplicationImpl facebookApplicationImpl) {
            this.f495a = facebookApplicationImpl;
        }

        public void run() {
            FacebookApplicationImpl.m7e(this.f495a);
        }
    }

    @DoNotStrip
    public FacebookApplicationImpl(Application application, FbAppType fbAppType, long j, PerfStats perfStats, LightweightPerfEvents lightweightPerfEvents) {
        super(application, fbAppType, lightweightPerfEvents);
        this.f3m = j;
        this.f4n = perfStats;
        this.f1k = application;
        this.f5o = lightweightPerfEvents;
    }

    public final void mo2b() {
        int i;
        Throwable th;
        InjectorLike injectorLike;
        this.f5o.e("ColdStart/FBAppImpl.onCreate");
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f5o.a("ColdStart/FacebookApplicationImpl.onCreate");
        TracerDetour.a("FacebookApplicationImpl.onCreate", -423390986);
        try {
            TracerDetour.a("TraceOrchestrator.initialize", -1616466823);
            try {
                int i2 = this.f1k;
                LoomColdStartTraceInitializer.a(i2);
                TracerDetour.a(i2);
                if (ProcessName.g().e()) {
                    AsyncTask.execute(new C00201(this));
                }
                TracerDetour.a("ReportAProblem.setReportAProblemConfigProvider", -33599370);
                try {
                    i2 = new FbReportAProblemConfigProvider(this.f1k);
                    ReportAProblem.m1030a((FbReportAProblemConfigProvider) i2);
                    TracerDetour.a(i2);
                    i2 = "FacebookApplicationImpl.super.onCreate";
                    i = 110408361;
                    TracerDetour.a(i2, 110408361);
                    super.mo2b();
                    TracerDetour.a(i2);
                    AcraBLogBridge.m2799a();
                    final InjectorLike a = m26a();
                    try {
                        m10h();
                        m4a((PerformanceLogger) DelegatingPerformanceLogger.m2803a(a), FeedPerfLogger.m3326a(a));
                        AppInitLock a2 = AppInitLock.m2271a(a);
                        a2.m2276a(new Listener(this) {
                            final /* synthetic */ FacebookApplicationImpl f2319b;

                            public final void mo334a() {
                                TracerDetour.a("FacebookApplicationImpl.AppInitLock.onInitialized", 1914519510);
                                try {
                                    if (this.f2319b.f2l.getProcessName().e()) {
                                        FeedPerfLogger.m3326a(this.f2319b.m26a()).m3375s();
                                        this.f2319b.m2a(StartupPerfLogger.m3414b(a));
                                    }
                                    DalvikTelemetry.a(a);
                                } finally {
                                    TracerDetour.a(-895053204);
                                }
                            }
                        });
                        this.f5o.a("ColdStart/UIThreadBlockedOnAppInit", 7340034);
                        a2.m2277b();
                        DalvikInternals.onColdStartEnd();
                        this.f5o.e("ColdStart/UIThreadBlockedOnAppInit");
                        this.f5o.e("ColdStart/ApplicationCreate");
                        TracerDetour.a(-1890836303);
                        this.f5o.c("ColdStart/FacebookApplicationImpl.onCreate");
                        if (a != null) {
                            m6b(StartupPerfLogger.m3414b(a), 5111812, "ApplicationOnCreate", uptimeMillis, SystemClock.uptimeMillis(), Boolean.valueOf(BackgroundChecker.a().d()), null);
                        }
                        this.f6p = true;
                        m9g();
                    } catch (Throwable th2) {
                        th = th2;
                        injectorLike = a;
                        TracerDetour.a(-1452640787);
                        this.f5o.c("ColdStart/FacebookApplicationImpl.onCreate");
                        if (injectorLike != null) {
                            m6b(StartupPerfLogger.m3414b(injectorLike), 5111812, "ApplicationOnCreate", uptimeMillis, SystemClock.uptimeMillis(), Boolean.valueOf(BackgroundChecker.a().d()), null);
                        }
                        this.f6p = true;
                        m9g();
                        throw th;
                    }
                } catch (Throwable th3) {
                    i2 = th3;
                    TracerDetour.a(i);
                } finally {
                    i = -2051405087;
                    TracerDetour.a(-2051405087);
                }
            } finally {
                TracerDetour.a(-1665799671);
            }
        } catch (Throwable th4) {
            th = th4;
            injectorLike = null;
            TracerDetour.a(-1452640787);
            this.f5o.c("ColdStart/FacebookApplicationImpl.onCreate");
            if (injectorLike != null) {
                m6b(StartupPerfLogger.m3414b(injectorLike), 5111812, "ApplicationOnCreate", uptimeMillis, SystemClock.uptimeMillis(), Boolean.valueOf(BackgroundChecker.a().d()), null);
            }
            this.f6p = true;
            m9g();
            throw th;
        }
    }

    public static void m7e(FacebookApplicationImpl facebookApplicationImpl) {
        TracerDetour.a("FacebookApplicationImpl.initializeUDPPriming", 1872090529);
        try {
            EncryptChannelInformation.a().a(facebookApplicationImpl.f1k);
            ColdStartPrimingInformation.a().a(facebookApplicationImpl.f1k);
            UDPPrimingDNSInfo.a().a(facebookApplicationImpl.f1k);
        } finally {
            TracerDetour.a(-1066458355);
        }
    }

    protected final void mo1a(ProcessName processName) {
        this.f2l = FbandroidProcessName.convertProcessNameToProcessEnum(processName);
    }

    protected final void mo3b(ProcessName processName) {
        InjectorLike a = m26a();
        BackgroundTaskController a2 = BackgroundTaskController.m2229a(a);
        if (processName.e()) {
            AppStateManager.m2245a(a).m2255a(this.f3m);
        } else {
            a2.m2230a(ContactsTaskTag.class, true);
            a2.m2230a(MessagesDataTaskTag.class, true);
            a2.m2230a(MessagesLocalTaskTag.class, true);
        }
        this.f5o.d("ColdStart/AppInitialization");
    }

    private void m4a(PerformanceLogger performanceLogger, FeedPerfLogger feedPerfLogger) {
        TracerDetour.a("FacebookApplicationImpl.runPerfMarkers", 1861155033);
        try {
            if (this.f2l.getProcessName().e()) {
                feedPerfLogger.m3347a(this.f3m, this.f4n, m8f());
                performanceLogger.mo391c(new MarkerConfig(655412, "NNF_PermalinkFromAndroidNotificationColdLoad").m3381a(this.f3m).m3388a("story_view", TabTag.Notifications.analyticsTag).m3390b().m3392c(BackgroundChecker.a().d()));
            }
            TracerDetour.a(-1178101631);
        } catch (Throwable th) {
            TracerDetour.a(1017515171);
        }
    }

    private boolean m8f() {
        DexErrorRecoveryInfo mainDexStoreLoadInformation = DexLibLoader.getMainDexStoreLoadInformation();
        boolean z = (mainDexStoreLoadInformation == null || (mainDexStoreLoadInformation.loadResult & 1) == 0) ? false : true;
        this.f2l.getProcessName();
        Boolean.valueOf(z);
        return z;
    }

    private void m2a(final StartupPerfLogger startupPerfLogger) {
        this.f5o.e("ColdStart/AppInitialization");
        this.f5o.a(new Marker(this) {
            final /* synthetic */ FacebookApplicationImpl f8837b;

            public final void m13667a(int i, String str, long j, long j2, boolean z, PerfStats perfStats) {
                FacebookApplicationImpl.m6b(startupPerfLogger, i, str, j, j2, Boolean.valueOf(z), perfStats);
            }
        });
        this.f7q = true;
        m9g();
    }

    private synchronized void m9g() {
        if (this.f6p && this.f7q) {
            this.f5o = null;
        }
    }

    private static void m6b(StartupPerfLogger startupPerfLogger, int i, String str, long j, long j2, Boolean bool, PerfStats perfStats) {
        if (startupPerfLogger != null) {
            startupPerfLogger.m3432a(i, str, null, null, j, perfStats, bool).m3433a(i, str, null, null, j2, bool);
        }
    }

    private void m10h() {
        TracerDetour.a("FacebookApplicationImpl.startStrictMode", 1271751087);
        try {
            InjectorLike a = m26a();
            SignatureType b = SignatureTypeMethodAutoProvider.m2801b(a);
            if (b != null && b == SignatureType.DEBUG) {
                new StrictModeAggregator(FbErrorReporterImpl.m2317a(a), Random_InsecureRandomMethodAutoProvider.m2102a(a)).a();
            }
            TracerDetour.a(-917124698);
        } catch (Throwable th) {
            TracerDetour.a(1349123384);
        }
    }
}
