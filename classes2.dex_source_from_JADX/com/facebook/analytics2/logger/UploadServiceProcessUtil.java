package com.facebook.analytics2.logger;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.crudolib.processname.ProcessNameHelper;
import com.facebook.debug.log.BLog;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: tab_dest_position */
class UploadServiceProcessUtil {
    static final String f3375a = AlarmBasedUploadService.class.getName();
    @GuardedBy("UploadServiceProcessUtil.class")
    private static UploadServiceProcessUtil f3376b;
    private final Context f3377c;
    @Nullable
    private volatile String f3378d;

    public static synchronized UploadServiceProcessUtil m5586a(Context context) {
        UploadServiceProcessUtil uploadServiceProcessUtil;
        synchronized (UploadServiceProcessUtil.class) {
            if (f3376b == null) {
                f3376b = new UploadServiceProcessUtil(context.getApplicationContext());
            }
            uploadServiceProcessUtil = f3376b;
        }
        return uploadServiceProcessUtil;
    }

    private UploadServiceProcessUtil(Context context) {
        this.f3377c = context;
    }

    public final boolean m5590a() {
        return m5587a(ProcessNameHelper.m2551a());
    }

    private boolean m5587a(@Nullable String str) {
        return m5588b().equals(str);
    }

    private synchronized String m5588b() {
        if (this.f3378d == null) {
            this.f3378d = m5589b(f3375a);
        }
        return this.f3378d;
    }

    @Nonnull
    private String m5589b(String str) {
        try {
            PackageInfo packageInfo = this.f3377c.getPackageManager().getPackageInfo(this.f3377c.getPackageName(), 4);
            if (packageInfo.services != null) {
                for (PackageItemInfo packageItemInfo : packageInfo.services) {
                    if (packageItemInfo.name.equals(str)) {
                        return packageItemInfo.processName;
                    }
                }
            }
            BLog.b("UploadServiceProcessUtil", "Unable to find the UploadService! Services registered: %s", new Object[]{Arrays.deepToString(packageInfo.services)});
            throw new IllegalStateException("Unable to find the UploadService!");
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("Package " + this.f3377c.getPackageName() + " cannot be found!");
        }
    }
}
