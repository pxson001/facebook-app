package com.facebook.messaging.prefs.notifications;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.viewercontext.PushedViewerContext;
import com.facebook.base.service.FbService;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: device_oid */
public class NotificationPrefsSyncService extends FbService {
    private static final Class<?> f16342a = NotificationPrefsSyncService.class;
    private Looper f16343b;
    public ServiceHandler f16344c;
    private ThreadNotificationPrefsSynchronizer f16345d;
    private GlobalNotificationPrefsSynchronizer f16346e;
    private int f16347f;

    /* compiled from: device_oid */
    public class C19251 {
        final /* synthetic */ NotificationPrefsSyncService f16338a;

        /* compiled from: device_oid */
        class C19241 implements Runnable {
            final /* synthetic */ C19251 f16337a;

            C19241(C19251 c19251) {
                this.f16337a = c19251;
            }

            public void run() {
                this.f16337a.f16338a.f16344c;
            }
        }

        C19251(NotificationPrefsSyncService notificationPrefsSyncService) {
            this.f16338a = notificationPrefsSyncService;
        }

        public final void m16407a() {
            HandlerDetour.a(this.f16338a.f16344c, new C19241(this), -553190437);
        }
    }

    /* compiled from: device_oid */
    public class C19272 {
        final /* synthetic */ NotificationPrefsSyncService f16340a;

        /* compiled from: device_oid */
        class C19261 implements Runnable {
            final /* synthetic */ C19272 f16339a;

            C19261(C19272 c19272) {
                this.f16339a = c19272;
            }

            public void run() {
                this.f16339a.f16340a.f16344c;
            }
        }

        C19272(NotificationPrefsSyncService notificationPrefsSyncService) {
            this.f16340a = notificationPrefsSyncService;
        }

        public final void m16408a() {
            HandlerDetour.a(this.f16340a.f16344c, new C19261(this), 2016733466);
        }
    }

    /* compiled from: device_oid */
    final class ServiceHandler extends Handler {
        final /* synthetic */ NotificationPrefsSyncService f16341a;

        public ServiceHandler(NotificationPrefsSyncService notificationPrefsSyncService, Looper looper) {
            this.f16341a = notificationPrefsSyncService;
            super(looper);
        }

        public final void handleMessage(Message message) {
            Throwable th;
            Intent intent = (Intent) message.obj;
            PushedViewerContext a = this.f16341a.b(intent);
            Throwable th2 = null;
            try {
                this.f16341a.m16410a(intent, message.arg1);
                if (a != null) {
                    a.close();
                    return;
                }
                return;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            throw th;
            if (a != null) {
                if (th22 != null) {
                    try {
                        a.close();
                    } catch (Throwable th4) {
                        AndroidCompat.addSuppressed(th22, th4);
                    }
                } else {
                    a.close();
                }
            }
            throw th;
        }
    }

    public final void m16416a() {
        super.a();
        InjectorLike l = l();
        HandlerThread a = FbHandlerThreadFactory.a(l).a("NotificationPrefsService");
        a.start();
        this.f16343b = a.getLooper();
        this.f16344c = new ServiceHandler(this, this.f16343b);
        this.f16345d = ThreadNotificationPrefsSynchronizer.m16433a(l);
        this.f16345d.f16380l = new C19251(this);
        this.f16346e = GlobalNotificationPrefsSynchronizer.m16396a(l);
        this.f16346e.f16336l = new C19272(this);
    }

    public final void m16417k() {
        super.k();
        this.f16343b.quit();
        this.f16345d.f16380l = null;
    }

    public final int m16415a(Intent intent, int i, int i2) {
        Message obtainMessage = this.f16344c.obtainMessage();
        obtainMessage.arg1 = i2;
        obtainMessage.obj = intent;
        this.f16344c.sendMessage(obtainMessage);
        return 2;
    }

    private void m16410a(Intent intent, int i) {
        this.f16347f = i;
        if (intent == null) {
            BLog.b(f16342a, "Received a null intent");
            this.f16344c;
            return;
        }
        String action = intent.getAction();
        if ("NotificationsPrefsService.SYNC_THREAD_FROM_CLIENT".equals(action)) {
            this.f16345d.m16441a(ThreadKey.a(intent.getStringExtra("THREAD_KEY_STRING")));
        } else if ("NotificationsPrefsService.SYNC_THREAD_FROM_SERVER".equals(action)) {
            this.f16345d.m16443b(ThreadKey.a(intent.getStringExtra("THREAD_KEY_STRING")));
        } else if ("NotificationsPrefsService.SYNC_GLOBAL_FROM_CLIENT".equals(action)) {
            this.f16346e.m16404a();
        } else if ("NotificationsPrefsService.SYNC_GLOBAL_FROM_SERVER".equals(action)) {
            this.f16346e.m16405b();
        }
        this.f16344c;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void m16414b(NotificationPrefsSyncService notificationPrefsSyncService) {
        if (!notificationPrefsSyncService.f16345d.m16442a() && !notificationPrefsSyncService.f16346e.m16406c()) {
            notificationPrefsSyncService.stopSelf(notificationPrefsSyncService.f16347f);
        }
    }
}
