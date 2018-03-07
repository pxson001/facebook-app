package com.facebook.feed.platformads;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.executors.C0418xc0ab4d4f;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.fragment.controllercallbacks.AppInstallController;
import com.facebook.feed.platformads.listener.AppInstalledListener;
import com.facebook.feed.platformads.listener.AppInstalledListener$AppInstalledListenerLocation;
import com.facebook.feed.platformads.listener.AppInstalledListener.InstalledAppInfo;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: photos */
public class ApplicationPoller {
    private static volatile ApplicationPoller f9921n;
    private final FbSharedPreferences f9922a;
    public final ScheduledExecutorService f9923b;
    private final PackageManager f9924c;
    public final NewsFeedAnalyticsEventBuilder f9925d;
    public final AnalyticsLogger f9926e;
    public final Provider<TriState> f9927f;
    private final ObjectMapper f9928g;
    private final long f9929h;
    private final long f9930i;
    public final long f9931j;
    private ScheduledFuture<?> f9932k;
    public HashMap<String, TrackedPackage> f9933l;
    public Map<AppInstalledListener$AppInstalledListenerLocation, AppInstalledListener> f9934m;

    public static com.facebook.feed.platformads.ApplicationPoller m14954a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9921n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.platformads.ApplicationPoller.class;
        monitor-enter(r1);
        r0 = f9921n;	 Catch:{ all -> 0x003a }
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
        r0 = m14957b(r0);	 Catch:{ all -> 0x0035 }
        f9921n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9921n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.platformads.ApplicationPoller.a(com.facebook.inject.InjectorLike):com.facebook.feed.platformads.ApplicationPoller");
    }

    private static ApplicationPoller m14957b(InjectorLike injectorLike) {
        return new ApplicationPoller(PackageManagerMethodAutoProvider.m2633a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), IdBasedProvider.m1811a(injectorLike, 676), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), C0418xc0ab4d4f.m14965a(injectorLike));
    }

    @Inject
    public ApplicationPoller(PackageManager packageManager, FbSharedPreferences fbSharedPreferences, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, Provider<TriState> provider, ObjectMapper objectMapper, ScheduledExecutorService scheduledExecutorService) {
        this(packageManager, fbSharedPreferences, newsFeedAnalyticsEventBuilder, analyticsLogger, provider, objectMapper, scheduledExecutorService, 20000, 15000, 2419200000L);
    }

    private ApplicationPoller(PackageManager packageManager, FbSharedPreferences fbSharedPreferences, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, Provider<TriState> provider, ObjectMapper objectMapper, ScheduledExecutorService scheduledExecutorService, long j, long j2, long j3) {
        this.f9929h = j;
        this.f9930i = j2;
        this.f9931j = j3;
        this.f9927f = provider;
        this.f9924c = packageManager;
        this.f9922a = fbSharedPreferences;
        this.f9925d = newsFeedAnalyticsEventBuilder;
        this.f9926e = analyticsLogger;
        this.f9928g = objectMapper;
        this.f9923b = scheduledExecutorService;
        this.f9933l = Maps.m838c();
        this.f9934m = Collections.synchronizedMap(new HashMap());
        m14962a();
    }

    public final void m14963a(String str, long j, ArrayNode arrayNode, String str2, boolean z) {
        TrackedPackage trackedPackage = new TrackedPackage();
        trackedPackage.detectionStrings = Arrays.asList(new String[]{str});
        trackedPackage.fbid = String.valueOf(j);
        trackedPackage.trackingCodes = arrayNode;
        trackedPackage.appLaunchUrl = str2;
        trackedPackage.notifyAppInstalledListener = z;
        if (this.f9927f.get() == TriState.YES) {
            ExecutorDetour.a(this.f9923b, new 3(this, trackedPackage), -130438564);
        }
    }

    public final void m14962a() {
        if (this.f9927f.get() == TriState.YES && this.f9932k == null && !this.f9933l.isEmpty()) {
            1 1 = new 1(this);
            ExecutorDetour.a(this.f9923b, new 2(this), 1634101275);
            this.f9932k = this.f9923b.scheduleAtFixedRate(1, this.f9929h, this.f9930i, TimeUnit.MILLISECONDS);
        }
    }

    public final void m14964b() {
        if (this.f9932k != null) {
            this.f9932k.cancel(true);
            this.f9932k = null;
        }
    }

    private boolean m14958c() {
        try {
            this.f9922a.mo292c();
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public static void m14959d(ApplicationPoller applicationPoller) {
        if (applicationPoller.m14958c()) {
            for (PrefKey a : applicationPoller.f9922a.mo294d(PlatformAdPrefKeys.b)) {
                try {
                    String a2 = applicationPoller.f9922a.mo278a(a, null);
                    if (a2 != null) {
                        TrackedPackage a3 = TrackedPackage.a(a2, applicationPoller.f9928g);
                        if (a3 != null) {
                            applicationPoller.f9933l.put(a3.fbid, a3);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public static void m14960e(ApplicationPoller applicationPoller) {
        if (applicationPoller.m14958c()) {
            Editor edit = applicationPoller.f9922a.edit();
            for (TrackedPackage trackedPackage : applicationPoller.f9933l.values()) {
                edit.mo1276a((PrefKey) PlatformAdPrefKeys.b.m2011a(trackedPackage.fbid), trackedPackage.a(applicationPoller.f9928g));
            }
            edit.commit();
        }
    }

    private void m14956a(Set<String> set) {
        if (m14958c()) {
            Editor edit = this.f9922a.edit();
            for (String a : set) {
                edit.mo1271a((PrefKey) PlatformAdPrefKeys.b.m2011a(a));
            }
            edit.commit();
        }
    }

    public static void m14961f(ApplicationPoller applicationPoller) {
        if (!applicationPoller.f9933l.isEmpty()) {
            Set<String> hashSet = new HashSet();
            Date date = new Date();
            for (TrackedPackage trackedPackage : applicationPoller.f9933l.values()) {
                for (String str : trackedPackage.detectionStrings) {
                    PackageInfo a = applicationPoller.m14953a(str);
                    if (a != null) {
                        if (!(applicationPoller.f9925d == null || applicationPoller.f9926e == null)) {
                            JsonNode jsonNode = trackedPackage.trackingCodes;
                            HoneyAnalyticsEvent j = new HoneyClientEvent("store_conversion").m5085a("tracking", jsonNode).m5097j(trackedPackage.fbid);
                            j.f3099c = "native_newsfeed";
                            applicationPoller.f9926e.mo533c(j);
                        }
                        hashSet.add(trackedPackage.fbid);
                        if (trackedPackage.notifyAppInstalledListener) {
                            applicationPoller.m14955a(str, a, trackedPackage);
                        }
                        if (trackedPackage.trackUntil.before(date)) {
                            hashSet.add(trackedPackage.fbid);
                        }
                    }
                }
                if (trackedPackage.trackUntil.before(date)) {
                    hashSet.add(trackedPackage.fbid);
                }
            }
            for (String remove : hashSet) {
                applicationPoller.f9933l.remove(remove);
            }
            if (!hashSet.isEmpty()) {
                applicationPoller.m14956a((Set) hashSet);
            }
            if (applicationPoller.f9933l.isEmpty()) {
                applicationPoller.m14964b();
            }
        }
    }

    private void m14955a(String str, PackageInfo packageInfo, TrackedPackage trackedPackage) {
        InstalledAppInfo installedAppInfo = new InstalledAppInfo();
        installedAppInfo.a = str;
        installedAppInfo.b = (String) this.f9924c.getApplicationLabel(packageInfo.applicationInfo);
        installedAppInfo.c = this.f9924c.getApplicationIcon(packageInfo.applicationInfo);
        installedAppInfo.e = trackedPackage.appLaunchUrl;
        installedAppInfo.f = trackedPackage.trackingCodes;
        installedAppInfo.g = trackedPackage.fbid;
        synchronized (this.f9934m) {
            for (AppInstallController a : this.f9934m.values()) {
                a.m14949a(installedAppInfo);
            }
        }
    }

    private PackageInfo m14953a(String str) {
        PackageInfo packageInfo = null;
        if (str != null) {
            try {
                packageInfo = this.f9924c.getPackageInfo(str, 0);
            } catch (NameNotFoundException e) {
            }
        }
        return packageInfo;
    }
}
