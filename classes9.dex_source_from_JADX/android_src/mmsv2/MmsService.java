package android_src.mmsv2;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: setRates failed */
public class MmsService extends Service {
    private static volatile int f3795a = 4;
    private static volatile boolean f3796b = true;
    private static volatile WakeLock f3797c = null;
    private static final Object f3798d = new Object();
    public static volatile CarrierConfigValuesLoader f3799e = null;
    private static volatile DefaultApnSettingsLoader f3800f = null;
    public static volatile DefaultUserAgentInfoLoader f3801g = null;
    private static volatile int f3802h = -1;
    private ExecutorService[] f3803i = new ExecutorService[2];
    private int f3804j;
    private int f3805k;
    public MmsNetworkManager f3806l;
    private final Handler f3807m = new Handler();
    private final Runnable f3808n = new C03421(this);

    /* compiled from: setRates failed */
    class C03421 implements Runnable {
        final /* synthetic */ MmsService f3792a;

        C03421(MmsService mmsService) {
            this.f3792a = mmsService;
        }

        public void run() {
            MmsService.m3574k(this.f3792a);
        }
    }

    static CarrierConfigValuesLoader m3558a() {
        return f3799e;
    }

    static DefaultApnSettingsLoader m3565b() {
        return f3800f;
    }

    static DefaultUserAgentInfoLoader m3567c() {
        return f3801g;
    }

    private static void m3560a(Context context) {
        if (f3801g == null) {
            f3801g = new DefaultUserAgentInfoLoader(context);
        }
        if (f3799e == null) {
            f3799e = new DefaultCarrierConfigValuesLoader(context);
        }
        if (f3800f == null) {
            f3800f = new DefaultApnSettingsLoader(context);
        }
    }

    private static void m3566b(Context context) {
        synchronized (f3798d) {
            if (f3797c == null) {
                f3797c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "mmslib_wakelock");
            }
            f3797c.acquire();
        }
    }

    public static void m3568e() {
        Object obj = null;
        synchronized (f3798d) {
            if (f3797c != null) {
                f3797c.release();
            } else {
                obj = 1;
            }
        }
        if (obj != null) {
            BLog.a("MmsLib", "Releasing empty wake lock");
        }
    }

    private static void m3569f() {
        synchronized (f3798d) {
            Object obj = (f3797c == null || !f3797c.isHeld()) ? null : 1;
        }
        if (obj != null) {
            BLog.b("MmsLib", "Wake lock still held!");
        }
    }

    private static int m3570g() {
        if (f3802h < 0) {
            f3802h = Process.myPid();
        }
        return f3802h;
    }

    private static boolean m3564a(Intent intent) {
        return intent.getIntExtra("mypid", -1) == m3570g();
    }

    public static void m3561a(Context context, MmsRequest mmsRequest) {
        boolean z = f3796b;
        mmsRequest.f3773e = z;
        Intent intent = new Intent(context, MmsService.class);
        intent.putExtra("request", mmsRequest);
        intent.putExtra("mypid", m3570g());
        if (z) {
            m3566b(context);
        }
        if (context.startService(intent) == null && z) {
            m3568e();
        }
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 2014805041);
        super.onCreate();
        m3560a((Context) this);
        for (int i = 0; i < this.f3803i.length; i++) {
            this.f3803i[i] = Executors.newFixedThreadPool(f3795a);
        }
        this.f3806l = new MmsNetworkManager(this);
        synchronized (this) {
            try {
                this.f3804j = 0;
                this.f3805k = -1;
            } finally {
                LogUtils.d(-1147439921, a);
            }
        }
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 331562722);
        super.onDestroy();
        for (ExecutorService shutdown : this.f3803i) {
            shutdown.shutdown();
        }
        LogUtils.d(1626451101, a);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3;
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 805604041);
        synchronized (this) {
            try {
                this.f3805k = i2;
            } catch (Throwable th) {
                LogUtils.d(652123870, a);
            }
        }
        if (intent == null) {
            BLog.a("MmsLib", "Empty intent");
            i3 = 0;
        } else if (m3564a(intent)) {
            final MmsRequest mmsRequest = (MmsRequest) intent.getParcelableExtra("request");
            if (mmsRequest != null) {
                try {
                    m3562a(mmsRequest, new Runnable(this) {
                        final /* synthetic */ MmsService f3794b;

                        public void run() {
                            try {
                                mmsRequest.m3514a(this.f3794b, this.f3794b.f3806l, MmsService.m3565b(), MmsService.m3558a(), MmsService.m3567c());
                            } catch (Throwable e) {
                                BLog.a("MmsLib", "Unexpected execution failure", e);
                            } finally {
                                if (mmsRequest.m3515a()) {
                                    MmsService.m3568e();
                                }
                                MmsService.m3571h(this.f3794b);
                            }
                        }
                    });
                    i3 = 1;
                } catch (RejectedExecutionException e) {
                    BLog.a("MmsLib", "Executing request failed " + e);
                    mmsRequest.m3513a(this, 1, null, 0);
                    if (mmsRequest.m3515a()) {
                        m3568e();
                    }
                    i3 = 0;
                }
            } else {
                BLog.a("MmsLib", "Empty request");
                i3 = 0;
            }
        } else {
            BLog.a("MmsLib", "Got a restarted intent from previous incarnation");
            i3 = 0;
        }
        if (i3 == 0) {
            m3572i();
        }
        LogUtils.d(1556609416, a);
        return 2;
    }

    private void m3562a(MmsRequest mmsRequest, Runnable runnable) {
        Executor a = m3559a(mmsRequest);
        synchronized (this) {
            ExecutorDetour.a(a, runnable, -268209614);
            this.f3804j++;
        }
    }

    public static void m3571h(MmsService mmsService) {
        synchronized (mmsService) {
            mmsService.f3804j--;
            if (mmsService.f3804j <= 0) {
                mmsService.f3804j = 0;
                mmsService.m3573j();
            }
        }
    }

    private void m3572i() {
        synchronized (this) {
            if (this.f3804j == 0) {
                m3573j();
            }
        }
    }

    private void m3573j() {
        HandlerDetour.a(this.f3807m, this.f3808n);
        HandlerDetour.b(this.f3807m, this.f3808n, 2000, 1982607256);
    }

    public static void m3574k(MmsService mmsService) {
        Boolean bool = null;
        synchronized (mmsService) {
            if (mmsService.f3804j == 0) {
                bool = Boolean.valueOf(mmsService.stopSelfResult(mmsService.f3805k));
            }
        }
        m3563a(bool);
    }

    private static void m3563a(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            m3569f();
        }
    }

    private ExecutorService m3559a(MmsRequest mmsRequest) {
        if (mmsRequest instanceof SendRequest) {
            return this.f3803i[0];
        }
        return this.f3803i[1];
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
