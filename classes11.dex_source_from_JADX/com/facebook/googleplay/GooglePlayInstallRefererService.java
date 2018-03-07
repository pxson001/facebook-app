package com.facebook.googleplay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;
import com.facebook.inject.FbInjector;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableMap;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: albums_no_result_data_parcelable */
public class GooglePlayInstallRefererService extends FbIntentService {
    private static final String f10069c = GooglePlayInstallRefererService.class.getSimpleName();
    private static WakeLock f10070d;
    @Inject
    public AbstractFbErrorReporter f10071a;
    @Inject
    public Set<GooglePlayReferrerDataProcessor> f10072b;

    private static <T extends Context> void m10414a(Class<T> cls, T t) {
        m10415a((Object) t, (Context) t);
    }

    public static void m10415a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GooglePlayInstallRefererService googlePlayInstallRefererService = (GooglePlayInstallRefererService) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        Set multiBinderSet = new MultiBinderSet(fbInjector.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$GooglePlayReferrerDataProcessor(fbInjector));
        googlePlayInstallRefererService.f10071a = abstractFbErrorReporter;
        googlePlayInstallRefererService.f10072b = multiBinderSet;
    }

    public GooglePlayInstallRefererService() {
        super("GooglePlayInstallRefererService");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1488863754);
        super.onCreate();
        Class cls = GooglePlayInstallRefererService.class;
        m10415a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 307972069, a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void m10418a(android.content.Intent r5) {
        /*
        r4 = this;
        r0 = "referrer";
        r0 = r5.getStringExtra(r0);	 Catch:{ all -> 0x0037 }
        r1 = f10069c;	 Catch:{ all -> 0x0037 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0037 }
        r3 = "onHandleIntent: ";
        r2.<init>(r3);	 Catch:{ all -> 0x0037 }
        r2 = r2.append(r0);	 Catch:{ all -> 0x0037 }
        r2 = r2.toString();	 Catch:{ all -> 0x0037 }
        android.util.Log.i(r1, r2);	 Catch:{ all -> 0x0037 }
        r1 = com.facebook.common.util.StringUtil.a(r0);	 Catch:{ all -> 0x0037 }
        if (r1 != 0) goto L_0x0023;
    L_0x0020:
        r4.m10416a(r0);	 Catch:{ all -> 0x0037 }
    L_0x0023:
        r0 = f10070d;
        if (r0 == 0) goto L_0x002d;
    L_0x0027:
        r0 = f10070d;
        r0.d();
    L_0x002c:
        return;
    L_0x002d:
        r0 = r4.f10071a;
        r1 = f10069c;
        r2 = "wakelock is null and cannot be released";
        r0.a(r1, r2);
        goto L_0x002c;
    L_0x0037:
        r0 = move-exception;
        r1 = f10070d;
        if (r1 == 0) goto L_0x0042;
    L_0x003c:
        r1 = f10070d;
        r1.d();
    L_0x0041:
        throw r0;
    L_0x0042:
        r1 = r4.f10071a;
        r2 = f10069c;
        r3 = "wakelock is null and cannot be released";
        r1.a(r2, r3);
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.googleplay.GooglePlayInstallRefererService.a(android.content.Intent):void");
    }

    private void m10416a(String str) {
        ImmutableMap b = m10417b(str);
        for (GooglePlayReferrerDataProcessor a : this.f10072b) {
            a.mo256a(b);
        }
    }

    private static ImmutableMap<String, String> m10417b(String str) {
        Uri build = new Builder().encodedQuery(Uri.decode(str)).build();
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (String str2 : build.getQueryParameterNames()) {
            builder.b(str2, build.getQueryParameter(str2));
        }
        return builder.b();
    }

    static void m10413a(Context context, Intent intent, FbWakeLockManager fbWakeLockManager) {
        if (f10070d == null && fbWakeLockManager != null) {
            f10070d = fbWakeLockManager.a(1, f10069c);
        }
        f10070d.c();
        try {
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            intent2.setClass(context, GooglePlayInstallRefererService.class);
            context.startService(intent2);
        } catch (Throwable th) {
            f10070d.d();
        }
    }
}
