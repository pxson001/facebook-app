package com.facebook.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageItemInfo;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import java.util.List;

/* compiled from: fresh_feed_new_data_fetch */
public final class IntentResolver {
    private static final String f23247a;
    private static final String f23248b;
    private static final String f23249c = f23247a.concat("_multiple_activities");

    static {
        String simpleName = IntentResolver.class.getSimpleName();
        f23247a = simpleName;
        f23248b = simpleName.concat("_no_activities");
    }

    public static boolean m31356b(String str, SecureContextHelperUtil secureContextHelperUtil, AbstractFbErrorReporter abstractFbErrorReporter, Intent intent) {
        if (intent.getComponent() == null || !intent.getComponent().getPackageName().equals(str)) {
            return m31354a(str, abstractFbErrorReporter, intent, SecureContextHelperUtil.m31348a(intent, secureContextHelperUtil.f23245a, secureContextHelperUtil.f23246b));
        }
        return true;
    }

    public static boolean m31354a(String str, FbErrorReporter fbErrorReporter, Intent intent, List<? extends ComponentInfo> list) {
        if (list.isEmpty()) {
            m31351a((AbstractFbErrorReporter) fbErrorReporter, f23248b, "no activities registered", intent);
            return false;
        }
        PackageItemInfo packageItemInfo;
        if (list.size() > 1) {
            for (PackageItemInfo packageItemInfo2 : list) {
                if (str.equals(packageItemInfo2.packageName)) {
                    break;
                }
            }
            packageItemInfo2 = null;
            if (packageItemInfo2 == null) {
                m31351a((AbstractFbErrorReporter) fbErrorReporter, f23249c, "multiple activities registered", intent);
                return false;
            }
        }
        packageItemInfo2 = (ComponentInfo) list.get(0);
        intent.setComponent(new ComponentName(packageItemInfo2.packageName, packageItemInfo2.name));
        return true;
    }

    private static void m31351a(AbstractFbErrorReporter abstractFbErrorReporter, String str, String str2, Intent intent) {
        StringBuilder append = new StringBuilder().append(str2).append(" (intent:");
        if (intent.getAction() != null) {
            append.append(" action=").append(intent.getAction());
        }
        if (intent.getComponent() != null) {
            append.append(" component=").append(intent.getComponent());
        }
        append.append(")");
        abstractFbErrorReporter.m2340a(str, append.toString());
    }

    public static boolean m31352a(Context context, Intent intent) {
        List a = SecureContextHelperUtil.m31348a(intent, context.getPackageManager(), context.getApplicationInfo());
        if (!a.isEmpty() && a.size() <= 1) {
            return true;
        }
        return false;
    }

    public static boolean m31353a(Context context, String str) {
        return m31355b(context, new Intent(str));
    }

    public static boolean m31355b(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
