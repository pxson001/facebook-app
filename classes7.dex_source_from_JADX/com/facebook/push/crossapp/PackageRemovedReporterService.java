package com.facebook.push.crossapp;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import javax.inject.Inject;

/* compiled from: home_voting_page */
public class PackageRemovedReporterService extends FbIntentService {
    private static final Class<?> f11253b = PackageRemovedReporterService.class;
    @Inject
    public PackageRemovedReporter f11254a;

    private static <T extends Context> void m13157a(Class<T> cls, T t) {
        m13158a((Object) t, (Context) t);
    }

    public static void m13158a(Object obj, Context context) {
        ((PackageRemovedReporterService) obj).f11254a = PackageRemovedReporter.m13152a(FbInjector.get(context));
    }

    public static void m13155a(Context context, String str, String str2) {
        if (context.startService(new Intent("com.facebook.push.crossapp.REPORT_DELETION").setClass(context, PackageRemovedReporterService.class).putExtra("package_name", str).putExtra("source", str2)) == null) {
            BLog.b(f11253b, "Service not found");
        }
    }

    public PackageRemovedReporterService() {
        super("DisableReceiverComponent");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1215192943);
        super.onCreate();
        AppInitLockHelper.a(this);
        Class cls = PackageRemovedReporterService.class;
        m13158a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1138756414, a);
    }

    protected final void m13159a(Intent intent) {
        if ("com.facebook.push.crossapp.REPORT_DELETION".equals(intent.getAction())) {
            try {
                FutureDetour.a(this.f11254a.m13154a(intent.getStringExtra("package_name"), intent.getStringExtra("source")), -936706856);
            } catch (Throwable th) {
                BLog.b(f11253b, "", th);
            }
        }
    }

    private void m13156a(PackageRemovedReporter packageRemovedReporter) {
        this.f11254a = packageRemovedReporter;
    }
}
