package com.facebook;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import com.facebook.Profile.C18751;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: eventTimezone */
public final class FacebookSdk {
    private static final String f13764a = FacebookSdk.class.getCanonicalName();
    private static final HashSet<LoggingBehavior> f13765b = new HashSet(Arrays.asList(new LoggingBehavior[]{LoggingBehavior.DEVELOPER_ERRORS}));
    private static volatile Executor f13766c;
    private static volatile String f13767d;
    private static volatile String f13768e;
    public static volatile String f13769f;
    private static volatile int f13770g;
    public static volatile String f13771h = "facebook.com";
    private static AtomicLong f13772i = new AtomicLong(65536);
    public static volatile boolean f13773j = false;
    public static boolean f13774k = false;
    private static LockOnGetVariable<File> f13775l;
    public static Context f13776m;
    public static int f13777n = 64206;
    private static final Object f13778o = new Object();
    private static final BlockingQueue<Runnable> f13779p = new LinkedBlockingQueue(10);
    private static final ThreadFactory f13780q = new C18681();
    private static Boolean f13781r = Boolean.valueOf(false);

    /* compiled from: eventTimezone */
    final class C18681 implements ThreadFactory {
        private final AtomicInteger f13762a = new AtomicInteger(0);

        C18681() {
        }

        public final Thread newThread(Runnable runnable) {
            return ThreadInitDetour.a(runnable, "FacebookSdk #" + this.f13762a.incrementAndGet(), -550904508);
        }
    }

    /* compiled from: eventTimezone */
    final class C18692 implements Callable<File> {
        C18692() {
        }

        public final Object call() {
            return FacebookSdk.f13776m.getCacheDir();
        }
    }

    /* compiled from: eventTimezone */
    final class C18703 implements Callable<Void> {
        final /* synthetic */ InitializeCallback f13763a;

        C18703(InitializeCallback initializeCallback) {
            this.f13763a = initializeCallback;
        }

        public final Object call() {
            AccessTokenManager.m14028a().m14035c();
            ProfileManager.m14138a().m14141c();
            if (AccessToken.m14004a() != null && ProfileManager.m14138a().f13843d == null) {
                AccessToken a = AccessToken.m14004a();
                if (a == null) {
                    Profile.m14135a(null);
                } else {
                    Utility.m25337a(a.f13711h, new C18751());
                }
            }
            return null;
        }
    }

    /* compiled from: eventTimezone */
    public interface InitializeCallback {
    }

    public static synchronized void m14044a(Context context) {
        synchronized (FacebookSdk.class) {
            m14045a(context, null);
        }
    }

    private static synchronized void m14045a(Context context, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            if (!f13781r.booleanValue()) {
                Validate.m25366a((Object) context, "applicationContext");
                Validate.m25369b(context, false);
                Validate.m25365a(context, false);
                Context applicationContext = context.getApplicationContext();
                f13776m = applicationContext;
                m14049c(applicationContext);
                f13781r = Boolean.valueOf(true);
                Utility.m25334a(f13776m, f13767d);
                NativeProtocol.m25300b();
                BoltsMeasurementEventListener.m25242a(f13776m);
                f13775l = new LockOnGetVariable(new C18692());
                ExecutorDetour.a(m14050d(), new FutureTask(new C18703(initializeCallback)), 1055587492);
            }
        }
    }

    public static synchronized boolean m14046a() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = f13781r.booleanValue();
        }
        return booleanValue;
    }

    public static boolean m14047a(LoggingBehavior loggingBehavior) {
        boolean z;
        synchronized (f13765b) {
            z = m14048b() && f13765b.contains(loggingBehavior);
        }
        return z;
    }

    public static boolean m14048b() {
        return f13773j;
    }

    public static Executor m14050d() {
        synchronized (f13778o) {
            if (f13766c == null) {
                f13766c = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return f13766c;
    }

    public static Context m14051f() {
        Validate.m25364a();
        return f13776m;
    }

    public static long m14052h() {
        Validate.m25364a();
        return f13772i.get();
    }

    private static void m14049c(Context context) {
        if (context != null) {
            try {
                PackageItemInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (f13767d == null) {
                        Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                                f13767d = str.substring(2);
                            } else {
                                f13767d = str;
                            }
                        } else if (obj instanceof Integer) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (f13768e == null) {
                        f13768e = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
                    }
                    if (f13769f == null) {
                        f13769f = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
                    }
                    if (f13770g == 0) {
                        m14043a(applicationInfo.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
                    }
                }
            } catch (NameNotFoundException e) {
            }
        }
    }

    public static String m14053i() {
        Validate.m25364a();
        return f13767d;
    }

    public static int m14054k() {
        Validate.m25364a();
        return f13770g;
    }

    private static void m14043a(int i) {
        if (i == 0) {
            i = 16973840;
        }
        f13770g = i;
    }
}
