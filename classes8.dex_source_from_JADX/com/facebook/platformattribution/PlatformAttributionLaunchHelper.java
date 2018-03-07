package com.facebook.platformattribution;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.content.AppInfo;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: restrict_region */
public class PlatformAttributionLaunchHelper {
    private static volatile PlatformAttributionLaunchHelper f4465h;
    private final Context f4466a;
    private final SecureContextHelper f4467b;
    private final GooglePlayIntentHelper f4468c;
    private final AnalyticsLogger f4469d;
    private final AppInfo f4470e;
    public BroadcastReceiver f4471f;
    public PackageManager f4472g;

    /* compiled from: restrict_region */
    class CreativePlatformLoggingEvent extends HoneyClientEvent {
        final /* synthetic */ PlatformAttributionLaunchHelper f4464c;

        public CreativePlatformLoggingEvent(PlatformAttributionLaunchHelper platformAttributionLaunchHelper, String str, String str2, String str3, String str4, String str5) {
            this.f4464c = platformAttributionLaunchHelper;
            super(str);
            this.c = "creative_platform";
            b("SOURCE", str2);
            b("IS_APP_INSTALLED", platformAttributionLaunchHelper.m4310a(str4) ? "YES" : "NO");
            b("APP_ID", str3);
            b("APP_PACKAGE_NAME", str4);
            b("COMPOSER_SESSION_ID", str5);
        }
    }

    public static com.facebook.platformattribution.PlatformAttributionLaunchHelper m4305a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4465h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platformattribution.PlatformAttributionLaunchHelper.class;
        monitor-enter(r1);
        r0 = f4465h;	 Catch:{ all -> 0x003a }
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
        r0 = m4307b(r0);	 Catch:{ all -> 0x0035 }
        f4465h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4465h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platformattribution.PlatformAttributionLaunchHelper.a(com.facebook.inject.InjectorLike):com.facebook.platformattribution.PlatformAttributionLaunchHelper");
    }

    private static PlatformAttributionLaunchHelper m4307b(InjectorLike injectorLike) {
        return new PlatformAttributionLaunchHelper((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GooglePlayIntentHelper.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), AppInfo.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PlatformAttributionLaunchHelper(Context context, SecureContextHelper secureContextHelper, GooglePlayIntentHelper googlePlayIntentHelper, AnalyticsLogger analyticsLogger, AppInfo appInfo, PackageManager packageManager) {
        this.f4466a = context;
        this.f4467b = secureContextHelper;
        this.f4468c = googlePlayIntentHelper;
        this.f4469d = analyticsLogger;
        this.f4470e = appInfo;
        this.f4472g = packageManager;
    }

    public final void m4308a(final String str, final String str2, final Activity activity) {
        if (m4310a(str2)) {
            m4306a(this, str2, activity);
            return;
        }
        this.f4468c.a(this.f4466a, str2);
        this.f4471f = new BroadcastReceiver(this) {
            final /* synthetic */ PlatformAttributionLaunchHelper f4463d;

            public void onReceive(Context context, Intent intent) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1900011443);
                PlatformAttributionLaunchHelper platformAttributionLaunchHelper = this.f4463d;
                Activity activity = activity;
                if (platformAttributionLaunchHelper.f4471f != null) {
                    activity.unregisterReceiver(platformAttributionLaunchHelper.f4471f);
                    platformAttributionLaunchHelper.f4471f = null;
                }
                if (intent.getData() != null && Objects.equal(str2, intent.getData().getSchemeSpecificPart())) {
                    this.f4463d.m4311b("install_from_google_play", str, str2);
                    PlatformAttributionLaunchHelper.m4306a(this.f4463d, str2, activity);
                }
                LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -371088670, a);
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        activity.registerReceiver(this.f4471f, intentFilter);
    }

    public final boolean m4310a(String str) {
        return this.f4470e.e(str);
    }

    public final void m4309a(String str, String str2, String str3) {
        this.f4469d.a(new CreativePlatformLoggingEvent(this, "platform_attribution_impression", str, str2, str3, null));
    }

    public final void m4311b(String str, String str2, String str3) {
        this.f4469d.a(new CreativePlatformLoggingEvent(this, "platform_attribution_conversion", str, str2, str3, null));
    }

    public final void m4312c(String str, String str2, String str3) {
        this.f4469d.a(new CreativePlatformLoggingEvent(this, "platform_attribution_conversion", str, str3, null, str2));
    }

    public static void m4306a(PlatformAttributionLaunchHelper platformAttributionLaunchHelper, String str, Activity activity) {
        Intent launchIntentForPackage = platformAttributionLaunchHelper.f4472g.getLaunchIntentForPackage(str);
        Bundle bundle = new Bundle();
        launchIntentForPackage.putExtra("al_applink_data", bundle);
        bundle.putBundle("extras", new Bundle());
        Intent intent = launchIntentForPackage;
        intent.getBundleExtra("al_applink_data").getBundle("extras").putBoolean("com.facebook.platform.extra.IS_COMPOSE", true);
        platformAttributionLaunchHelper.f4467b.b(intent, 1004, activity);
    }
}
