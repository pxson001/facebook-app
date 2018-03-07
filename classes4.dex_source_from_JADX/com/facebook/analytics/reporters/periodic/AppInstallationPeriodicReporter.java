package com.facebook.analytics.reporters.periodic;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: handleGetQEs */
public class AppInstallationPeriodicReporter implements IAnalyticsPeriodicEventReporter {
    private static final Map<String, String> f10909a = new Builder().b("350685531728", "com.facebook.wakizashi").b("256002347743983", "com.facebook.orca").b("121876164619130", "com.facebook.pages.app").b("306069495113", "com.whatsapp").b("567067343352427", "com.instagram.android").b("295940867235646", "com.instagram.bolt").b("881555691867714", "com.instagram.layout").b("358698234273213", "com.facebook.groups").b("794956213882720", "com.facebook.moments").b("255620677933453", "com.facebook.slingshot").b("1548792348668883", "com.oculus.home").b("1437758943160428", "com.oculus.horizon").b();
    private static volatile AppInstallationPeriodicReporter f10910c;
    private final PackageManager f10911b;

    public static com.facebook.analytics.reporters.periodic.AppInstallationPeriodicReporter m11342a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10910c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.reporters.periodic.AppInstallationPeriodicReporter.class;
        monitor-enter(r1);
        r0 = f10910c;	 Catch:{ all -> 0x003a }
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
        r0 = m11344b(r0);	 Catch:{ all -> 0x0035 }
        f10910c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10910c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.reporters.periodic.AppInstallationPeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.reporters.periodic.AppInstallationPeriodicReporter");
    }

    private static AppInstallationPeriodicReporter m11344b(InjectorLike injectorLike) {
        return new AppInstallationPeriodicReporter((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public AppInstallationPeriodicReporter(Context context) {
        this.f10911b = context.getPackageManager();
    }

    @Nullable
    public final HoneyAnalyticsEvent mo804a(long j, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("app_installations");
        for (String str2 : f10909a.keySet()) {
            honeyClientEvent.a(str2, m11343a((String) f10909a.get(str2)) ? 1 : 0);
        }
        return honeyClientEvent;
    }

    private boolean m11343a(String str) {
        boolean z = false;
        if (this.f10911b == null) {
            return z;
        }
        try {
            return this.f10911b.getApplicationInfo(str, 0).enabled;
        } catch (NameNotFoundException e) {
            return z;
        }
    }
}
