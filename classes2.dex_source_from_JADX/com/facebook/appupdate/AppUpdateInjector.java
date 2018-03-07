package com.facebook.appupdate;

import android.app.DownloadManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.selfupdate.AppUpdateLoggerFbImpl;
import com.facebook.selfupdate.FbandroidAppConfiguration;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Provider;

/* compiled from: ranking_policy */
public class AppUpdateInjector {
    @GuardedBy("AppUpdateInjector.class")
    private static AppUpdateInjector f8243a;
    @GuardedBy("AppUpdateInjector.class")
    private static final List<InitWithInjector> f8244b = new ArrayList();
    private final FbandroidAppConfiguration f8245c;
    private AppUpdateLoggerFbImpl f8246d;
    private AppUpdateOperationFactory f8247e;
    private Context f8248f;
    private DownloadManager f8249g;
    private int f8250h = -1;
    private PackageManager f8251i;
    private Provider<String> f8252j;
    private SelfUpdateLauncher f8253k;
    private AppInstallCallback f8254l;
    private AppUpdatePersistence f8255m;
    private Handler f8256n;
    private Handler f8257o;
    private AppUpdateNotificationsCreator f8258p;
    private NotificationManager f8259q;
    private SharedPreferences f8260r;
    private AppUpdateInitializer f8261s;
    private AppUpdateFilesCleaner f8262t;
    private AppUpdateFilesManager f8263u;

    private AppUpdateInjector(FbandroidAppConfiguration fbandroidAppConfiguration) {
        this.f8245c = fbandroidAppConfiguration;
    }

    public static synchronized void m12764a(FbandroidAppConfiguration fbandroidAppConfiguration) {
        synchronized (AppUpdateInjector.class) {
            boolean z;
            if (f8243a == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.m12787a(z);
            AppUpdateInjector appUpdateInjector = new AppUpdateInjector(fbandroidAppConfiguration);
            f8243a = appUpdateInjector;
            Handler j = f8243a.m12784j();
            for (InitWithInjector 1 : f8244b) {
                HandlerDetour.a(j, new 1(1, appUpdateInjector), 1031521427);
            }
            f8244b.clear();
        }
    }

    public static synchronized AppUpdateInjector m12762a() {
        AppUpdateInjector appUpdateInjector;
        synchronized (AppUpdateInjector.class) {
            Preconditions.m12787a(f8243a != null);
            appUpdateInjector = f8243a;
        }
        return appUpdateInjector;
    }

    public static synchronized boolean m12766b() {
        boolean z;
        synchronized (AppUpdateInjector.class) {
            z = f8243a != null;
        }
        return z;
    }

    public static synchronized void m12763a(InitWithInjector initWithInjector) {
        synchronized (AppUpdateInjector.class) {
            if (m12766b()) {
                AppUpdateInjector a = m12762a();
                HandlerDetour.a(a.m12784j(), new 2(initWithInjector, a), 2039238024);
            } else {
                f8244b.add(initWithInjector);
            }
        }
    }

    public static synchronized void m12765b(InitWithInjector initWithInjector) {
        synchronized (AppUpdateInjector.class) {
            f8244b.remove(initWithInjector);
        }
    }

    public final synchronized AppUpdateInitializer m12778d() {
        if (this.f8261s == null) {
            this.f8261s = new AppUpdateInitializer(m12779e(), m12767l(), m12784j());
        }
        return this.f8261s;
    }

    private synchronized AppUpdateFilesCleaner m12767l() {
        if (this.f8262t == null) {
            this.f8262t = new AppUpdateFilesCleaner(m12768m(), m12781g(), m12779e());
        }
        return this.f8262t;
    }

    private synchronized AppUpdateFilesManager m12768m() {
        if (this.f8263u == null) {
            this.f8263u = new AppUpdateFilesManager(m12785k());
        }
        return this.f8263u;
    }

    public final synchronized AppUpdateOperationFactory m12779e() {
        if (this.f8247e == null) {
            this.f8247e = new AppUpdateOperationFactory(m12785k(), m12769n(), m12773r(), this.f8245c.m12744b(), m12775t(), m12784j(), m12781g(), m12774s(), m12768m(), m12771p());
        }
        return this.f8247e;
    }

    private synchronized DownloadManager m12769n() {
        if (this.f8249g == null) {
            this.f8249g = (DownloadManager) m12785k().getSystemService("download");
        }
        return this.f8249g;
    }

    public final synchronized SelfUpdateLauncher m12780f() {
        if (this.f8253k == null) {
            this.f8253k = new SelfUpdateLauncher(m12781g(), m12779e(), m12777v(), m12770o());
        }
        return this.f8253k;
    }

    private synchronized Provider<Long> m12770o() {
        return this.f8245c.m12748g();
    }

    private synchronized int m12771p() {
        if (this.f8250h == -1) {
            try {
                this.f8250h = m12772q().getPackageInfo(m12785k().getPackageName(), 0).versionCode;
            } catch (Throwable e) {
                throw new RuntimeException("Own PackageInfo not found!", e);
            }
        }
        return this.f8250h;
    }

    private synchronized PackageManager m12772q() {
        if (this.f8251i == null) {
            this.f8251i = m12785k().getPackageManager();
        }
        return this.f8251i;
    }

    private synchronized Provider<String> m12773r() {
        if (this.f8252j == null) {
            this.f8252j = this.f8245c.m12745c();
        }
        return this.f8252j;
    }

    public final synchronized AppUpdateLoggerFbImpl m12781g() {
        if (this.f8246d == null) {
            this.f8246d = this.f8245c.m12746d();
        }
        return this.f8246d;
    }

    private synchronized AppUpdateNotificationsCreator m12774s() {
        if (this.f8258p == null) {
            this.f8258p = new AppUpdateNotificationsCreator(m12785k(), m12776u(), this.f8245c, m12782h());
        }
        return this.f8258p;
    }

    @Nullable
    public final synchronized AppInstallCallback m12782h() {
        if (this.f8254l == null) {
            this.f8254l = this.f8245c.m12747e();
        }
        return this.f8254l;
    }

    private synchronized AppUpdatePersistence m12775t() {
        if (this.f8255m == null) {
            this.f8255m = new AppUpdatePersistence(m12785k());
        }
        return this.f8255m;
    }

    public final synchronized Handler m12783i() {
        if (this.f8256n == null) {
            this.f8256n = new Handler(Looper.getMainLooper());
        }
        return this.f8256n;
    }

    public final synchronized Handler m12784j() {
        if (this.f8257o == null) {
            HandlerThread handlerThread = new HandlerThread("AppUpdate-background", 10);
            final AppUpdateLoggerFbImpl g = m12781g();
            handlerThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler(this) {
                final /* synthetic */ AppUpdateInjector f8265b;

                public void uncaughtException(Thread thread, Throwable th) {
                    g.m12753a(th.getMessage(), null, th);
                }
            });
            handlerThread.start();
            this.f8257o = new Handler(handlerThread.getLooper());
        }
        return this.f8257o;
    }

    private synchronized NotificationManager m12776u() {
        if (this.f8259q == null) {
            this.f8259q = (NotificationManager) m12785k().getSystemService("notification");
        }
        return this.f8259q;
    }

    private synchronized SharedPreferences m12777v() {
        if (this.f8260r == null) {
            this.f8260r = m12785k().getSharedPreferences("appupdate_preferences", 0);
        }
        return this.f8260r;
    }

    public final synchronized Context m12785k() {
        if (this.f8248f == null) {
            this.f8248f = this.f8245c.m12743a();
        }
        return this.f8248f;
    }
}
