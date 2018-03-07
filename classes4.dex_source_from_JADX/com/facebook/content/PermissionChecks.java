package com.facebook.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionInfo;
import android.os.Binder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fbpackage.FbAppPackageNames;
import com.facebook.common.fbpackage.FirstPartyAppSignatures;
import com.facebook.common.internal.ImmutableSet;
import com.facebook.common.internal.Sets;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.inject.FbInjector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: method/links.preview */
public class PermissionChecks {
    public static boolean m8080a(Context context) {
        int callingUid = Binder.getCallingUid();
        int i = context.getApplicationInfo().uid;
        if (callingUid == i || context.getPackageManager().checkSignatures(i, callingUid) == 0) {
            return true;
        }
        return false;
    }

    @SuppressLint({"BadMethodUse-android.content.pm.PackageManager.getPackageInfo"})
    public static boolean m8081b(Context context) {
        int callingUid = Binder.getCallingUid();
        PackageManager packageManager = context.getPackageManager();
        for (String str : packageManager.getPackagesForUid(callingUid)) {
            if (FbAppPackageNames.a.contains(str)) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length == 1 && FirstPartyAppSignatures.a.contains(SecureHashUtil.a(packageInfo.signatures[0].toByteArray()))) {
                        return true;
                    }
                } catch (NameNotFoundException e) {
                }
            }
        }
        return false;
    }

    private static Set<String> m8084e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PermissionInfo[] permissionInfoArr = packageManager.getPackageInfo(packageName, 4096).permissions;
            Set a = Sets.a();
            for (PackageItemInfo packageItemInfo : permissionInfoArr) {
                a.add(packageItemInfo.name);
            }
            return ImmutableSet.a(a);
        } catch (NameNotFoundException e) {
            ((AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(context))).a("PermissionChecks", "Package name not found: " + packageName);
            return null;
        }
    }

    public static List<PackageInfo> m8082c(Context context) {
        return m8078a(context, context.getPackageManager().getInstalledPackages(4096));
    }

    public static List<PackageInfo> m8083d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List arrayList = new ArrayList();
        for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(0)) {
            Object packageInfo;
            try {
                packageInfo = packageManager.getPackageInfo(applicationInfo.packageName, 4096);
            } catch (NameNotFoundException e) {
                packageInfo = null;
            }
            if (packageInfo != null) {
                arrayList.add(packageInfo);
            }
        }
        return m8078a(context, arrayList);
    }

    private static List<PackageInfo> m8078a(Context context, List<PackageInfo> list) {
        PackageManager packageManager = context.getPackageManager();
        int i = context.getApplicationInfo().uid;
        List arrayList = new ArrayList();
        Set e = m8084e(context);
        if (!(e == null || e.isEmpty())) {
            for (PackageInfo packageInfo : list) {
                int i2 = packageInfo.applicationInfo.uid;
                if (i != i2 && packageManager.checkSignatures(i, i2) != 0) {
                    PermissionInfo[] permissionInfoArr = packageInfo.permissions;
                    if (permissionInfoArr != null) {
                        for (PackageItemInfo packageItemInfo : permissionInfoArr) {
                            if (e.contains(packageItemInfo.name)) {
                                arrayList.add(packageInfo);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static final void m8079a() {
        throw new SecurityException("Component access not allowed.");
    }
}
