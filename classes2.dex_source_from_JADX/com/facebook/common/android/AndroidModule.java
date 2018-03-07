package com.facebook.common.android;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.Service;
import android.app.admin.DevicePolicyManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.location.Geocoder;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.TelephonyManager;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.support.v4.net.ConnectivityManagerCompat;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: video_channel_feed */
public class AndroidModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static LocationManager m2399a(Context context) {
        return (LocationManager) context.getSystemService("location");
    }

    @ProviderMethod
    static WindowManager m2402b(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    @ProviderMethod
    static LayoutInflater m2403c(Context context) {
        return (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @ProviderMethod
    static ActivityManager m2405d(Context context) {
        return (ActivityManager) context.getSystemService("activity");
    }

    @ProviderMethod
    static PowerManager m2407e(Context context) {
        return (PowerManager) context.getSystemService("power");
    }

    @ProviderMethod
    static DevicePolicyManager m2409f(Context context) {
        return (DevicePolicyManager) context.getSystemService("device_policy");
    }

    @ProviderMethod
    static AlarmManager m2410g(Context context) {
        return (AlarmManager) context.getSystemService("alarm");
    }

    @ProviderMethod
    static NotificationManager m2411h(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }

    @ProviderMethod
    static KeyguardManager m2412i(Context context) {
        return (KeyguardManager) context.getSystemService("keyguard");
    }

    @ProviderMethod
    static SearchManager m2413j(Context context) {
        return (SearchManager) context.getSystemService("search");
    }

    @ProviderMethod
    static Vibrator m2414k(Context context) {
        return (Vibrator) context.getSystemService("vibrator");
    }

    @ProviderMethod
    static ConnectivityManager m2415l(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    @ProviderMethod
    static WifiManager m2416m(Context context) {
        return (WifiManager) context.getSystemService("wifi");
    }

    @ProviderMethod
    static InputMethodManager m2417n(Context context) {
        return (InputMethodManager) context.getSystemService("input_method");
    }

    @ProviderMethod
    static SensorManager m2418o(Context context) {
        return (SensorManager) context.getSystemService("sensor");
    }

    @ProviderMethod
    public static ClipboardManager m2419p(Context context) {
        return (ClipboardManager) context.getSystemService("clipboard");
    }

    @ProviderMethod
    static TelephonyManager m2420q(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    @ProviderMethod
    static AudioManager m2421r(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    @ProviderMethod
    static AccountManager m2422s(Context context) {
        return (AccountManager) context.getSystemService("account");
    }

    @ProviderMethod
    static AccessibilityManager m2423t(Context context) {
        return (AccessibilityManager) context.getSystemService("accessibility");
    }

    @ProviderMethod
    static DownloadManager m2424u(Context context) {
        return (DownloadManager) context.getSystemService("download");
    }

    @WifiP2pManagerSystemService
    @ProviderMethod
    static Object m2425v(Context context) {
        return context.getSystemService("wifip2p");
    }

    @ProviderMethod
    @Singleton
    static PackageManager m2426w(Context context) {
        return context.getApplicationContext().getPackageManager();
    }

    @ProviderMethod
    @Singleton
    static PackageInfo m2398a(PackageManager packageManager, Context context) {
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @ProviderMethod
    @Singleton
    static LocalBroadcastManager m2427x(Context context) {
        return LocalBroadcastManager.m3051a(context.getApplicationContext());
    }

    @ProviderMethod
    @Singleton
    static Resources m2428y(Context context) {
        return context.getApplicationContext().getResources();
    }

    @ProviderMethod
    static ContentResolver m2429z(Context context) {
        return context.getContentResolver();
    }

    @ProviderMethod
    @Singleton
    static Geocoder m2392A(Context context) {
        return new Geocoder(context.getApplicationContext());
    }

    @ProviderMethod
    static MediaRecorder m2400a() {
        return new MediaRecorder();
    }

    @ProviderMethod
    public static MediaPlayer m2401b() {
        return new MediaPlayer();
    }

    @ProviderMethod
    @Singleton
    static ConnectivityManagerCompat m2404c() {
        return new ConnectivityManagerCompat();
    }

    @ProviderMethod
    static Activity m2393B(Context context) {
        return (Activity) ContextUtils.m2500a(context, Activity.class);
    }

    @ProviderMethod
    static FragmentActivity m2394C(Context context) {
        return (FragmentActivity) ContextUtils.m2500a(context, FragmentActivity.class);
    }

    @ProviderMethod
    static Service m2395D(Context context) {
        if (context instanceof Service) {
            return (Service) context;
        }
        return null;
    }

    @ProviderMethod
    @Singleton
    @PackageName
    static String m2396E(Context context) {
        return context.getPackageName();
    }

    @ProviderMethod
    static ApplicationInfo m2397F(Context context) {
        return context.getApplicationInfo();
    }

    @ProviderMethod
    static Runtime m2406d() {
        return Runtime.getRuntime();
    }

    @ProviderMethod
    @AndroidSdkVersion
    public static Integer m2408e() {
        return Integer.valueOf(VERSION.SDK_INT);
    }
}
