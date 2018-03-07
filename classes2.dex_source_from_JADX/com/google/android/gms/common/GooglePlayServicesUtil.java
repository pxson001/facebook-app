package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zznx;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GooglePlayServicesUtil {
    @Deprecated
    public static final int f57a = 8298000;
    public static boolean f58b = false;
    public static boolean f59c = false;
    static final AtomicBoolean f60d = new AtomicBoolean();
    private static int f61e = -1;
    private static final Object f62f = new Object();
    private static String f63g = null;
    private static Integer f64h = null;
    private static final AtomicBoolean f65i = new AtomicBoolean();

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static int m153a(Context context) {
        if (zzd.f66a) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(2131233792);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            m168f(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            zzd.m171a();
            if (!zznj.m176a(context)) {
                try {
                    if (zzd.m170a(packageManager.getPackageInfo("com.android.vending", 8256), zzcg.f69a) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (zzd.m170a(packageInfo, zzd.m170a(packageManager.getPackageInfo("com.android.vending", 8256), zzcg.f69a)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return 9;
                }
            } else if (zzd.m170a(packageInfo, zzcg.f69a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (zznj.m175a(packageInfo.versionCode) < zznj.m175a(f57a)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + f57a + " but found " + packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static PendingIntent m154a(int i, Context context, int i2) {
        Intent a = GoogleApiAvailability.f56b.m152a(context, i, null);
        return a == null ? null : PendingIntent.getActivity(context, i2, a, 268435456);
    }

    public static void m155a(Activity activity, OnCancelListener onCancelListener, String str, Dialog dialog) {
        Dialog dialog2;
        if (activity instanceof FragmentActivity) {
            FragmentManager kO_ = ((FragmentActivity) activity).kO_();
            DialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
            dialog2 = (Dialog) zzx.m105a((Object) dialog, (Object) "Cannot display null dialog");
            dialog2.setOnCancelListener(null);
            dialog2.setOnDismissListener(null);
            supportErrorDialogFragment.al = dialog2;
            if (onCancelListener != null) {
                supportErrorDialogFragment.am = onCancelListener;
            }
            supportErrorDialogFragment.m213a(kO_, str);
        } else if (zznx.m283a()) {
            android.app.FragmentManager fragmentManager = activity.getFragmentManager();
            ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
            dialog2 = (Dialog) zzx.m105a((Object) dialog, (Object) "Cannot display null dialog");
            dialog2.setOnCancelListener(null);
            dialog2.setOnDismissListener(null);
            errorDialogFragment.f139a = dialog2;
            if (onCancelListener != null) {
                errorDialogFragment.f140b = onCancelListener;
            }
            errorDialogFragment.show(fragmentManager, str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    public static boolean m156a(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        Dialog b = m160b(i, activity, fragment, i2, onCancelListener);
        if (b == null) {
            return false;
        }
        m155a(activity, onCancelListener, "GooglePlayServicesErrorDialog", b);
        return true;
    }

    public static boolean m157a(Context context, int i) {
        if (m158a(context, i, "com.google.android.gms")) {
            if (zzd.f67a.m174a(context.getPackageManager(), "com.google.android.gms")) {
                return true;
            }
        }
        return false;
    }

    public static boolean m158a(Context context, int i, String str) {
        if (zznx.m285e()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m159a(Context context, String str) {
        if (zznx.m286f()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        if (m169g(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 8192).enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static Dialog m160b(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (zznj.m176a((Context) activity) && i == 2) {
            i = 42;
        }
        if (zznx.m284a(14)) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new Builder(activity);
        }
        builder.setMessage(zzg.m287a(activity, i, m167e(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent a = GoogleApiAvailability.f56b.m152a(activity, i, "d");
        OnClickListener com_google_android_gms_common_internal_zzh = fragment == null ? new zzh(activity, a, i2) : new zzh(fragment, a, i2);
        CharSequence b = zzg.m288b(activity, i);
        if (b != null) {
            builder.setPositiveButton(b, com_google_android_gms_common_internal_zzh);
        }
        String str = null;
        Resources resources = activity.getResources();
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                str = resources.getString(2131233775);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                str = resources.getString(2131233782);
                break;
            case 3:
                str = resources.getString(2131233779);
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 6:
                break;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                str = resources.getString(2131233790);
                break;
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                str = resources.getString(2131233788);
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                break;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                str = resources.getString(2131233793);
                break;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                break;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                break;
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                str = resources.getString(2131233798);
                break;
            case 18:
                str = resources.getString(2131233786);
                break;
            case 42:
                str = resources.getString(2131233783);
                break;
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                break;
        }
        String str2 = str;
        if (str2 != null) {
            builder.setTitle(str2);
        }
        return builder.create();
    }

    @Deprecated
    public static void m161b(Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.f56b;
        int a = GoogleApiAvailability.m148a(context);
        if (a != 0) {
            Intent a2 = GoogleApiAvailability.f56b.m152a(context, a, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + a);
            if (a2 == null) {
                throw new GooglePlayServicesNotAvailableException(a);
            }
            throw new GooglePlayServicesRepairableException(a, "Google Play Services not available", a2);
        }
    }

    @Deprecated
    public static boolean m162b(Context context, int i) {
        return i == 18 ? true : i == 1 ? m159a(context, "com.google.android.gms") : false;
    }

    public static boolean m163b(PackageManager packageManager) {
        boolean z = true;
        synchronized (f62f) {
            if (f61e == -1) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
                    zzd.m171a();
                    if (zzd.m170a(packageInfo, zzc.f146b[1]) != null) {
                        f61e = 1;
                    } else {
                        f61e = 0;
                    }
                } catch (NameNotFoundException e) {
                    f61e = 0;
                }
            }
            if (f61e == 0) {
                z = false;
            }
        }
        return z;
    }

    @Deprecated
    public static void m164c(Context context) {
        if (!f60d.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    @Deprecated
    public static boolean m165c(int i) {
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static Context m166d(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static String m167e(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    private static void m168f(Context context) {
        if (!f65i.get()) {
            Integer num;
            synchronized (f62f) {
                if (f63g == null) {
                    f63g = context.getPackageName();
                    try {
                        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), HTTPTransportCallback.BODY_BYTES_RECEIVED).metaData;
                        if (bundle != null) {
                            f64h = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                        } else {
                            f64h = null;
                        }
                    } catch (Throwable e) {
                        Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                    }
                } else if (!f63g.equals(context.getPackageName())) {
                    throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + f63g + "' and this call used package '" + context.getPackageName() + "'.");
                }
                num = f64h;
            }
            if (num == null) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (num.intValue() != f57a) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + f57a + " but found " + num + ".  You must have the following declaration within the <application> element: " + "    <meta-data android:name=\"com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
    }

    private static boolean m169g(Context context) {
        if (zznx.m284a(18)) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }
}
