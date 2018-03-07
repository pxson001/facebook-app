package com.facebook.notifications.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.NavigationLogger;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.lockscreen.db.PushNotificationDbHelper;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.logging.NotificationsLogger.Component;
import com.facebook.notifications.logging.NotificationsLogger.Event;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.notifications.util.SystemTrayNotificationManager;
import javax.inject.Inject;

/* compiled from: moments_in_feed_upsell_clicked */
public class SystemTrayLogService extends FbIntentService {
    public static String f8701a = "REDIRECT_INTENT";
    private NotificationsLogger f8702b;
    private NotificationsUtils f8703c;
    private SecureContextHelper f8704d;
    private PushNotificationDbHelper f8705e;
    private AbstractFbErrorReporter f8706f;
    private SystemTrayNotificationManager f8707g;
    private Lazy<NavigationLogger> f8708h;

    /* compiled from: moments_in_feed_upsell_clicked */
    /* synthetic */ class C07031 {
        static final /* synthetic */ int[] f8700a = new int[Component.values().length];

        static {
            try {
                f8700a[Component.SERVICE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8700a[Component.THIRD_PARTY_ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8700a[Component.ACTIVITY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static <T extends Context> void m10670a(Class<T> cls, T t) {
        m10671a((Object) t, (Context) t);
    }

    public static void m10671a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SystemTrayLogService) obj).m10669a(PushNotificationDbHelper.m9796a(fbInjector), NotificationsLogger.a(fbInjector), NotificationsUtils.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), SystemTrayNotificationManager.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 137));
    }

    public SystemTrayLogService() {
        super("SystemTrayLogService");
    }

    @Inject
    private void m10669a(PushNotificationDbHelper pushNotificationDbHelper, NotificationsLogger notificationsLogger, NotificationsUtils notificationsUtils, SecureContextHelper secureContextHelper, FbErrorReporter fbErrorReporter, SystemTrayNotificationManager systemTrayNotificationManager, Lazy<NavigationLogger> lazy) {
        this.f8705e = pushNotificationDbHelper;
        this.f8702b = notificationsLogger;
        this.f8703c = notificationsUtils;
        this.f8704d = secureContextHelper;
        this.f8706f = fbErrorReporter;
        this.f8708h = lazy;
        this.f8707g = systemTrayNotificationManager;
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1978895858);
        super.onCreate();
        Class cls = SystemTrayLogService.class;
        m10671a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -526268149, a);
    }

    protected final void m10672a(Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            Event event = (Event) extras.get("EVENT_TYPE");
            Component component = (Component) extras.get("COMPONENT_TYPE");
            NotificationLogObject notificationLogObject = (NotificationLogObject) extras.getParcelable("NOTIF_LOG");
            int intExtra = intent.getIntExtra("NOTIFICATION_ID", 0);
            if (intExtra != 0) {
                this.f8707g.a(intExtra);
                sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            }
            this.f8702b.a(notificationLogObject, event);
            ((NavigationLogger) this.f8708h.get()).a("tap_system_tray_notification");
            if (event != Event.CLEAR_FROM_TRAY) {
                this.f8703c.a(notificationLogObject);
                Intent intent2 = (Intent) extras.getParcelable(f8701a);
                intent2.setExtrasClassLoader(getClass().getClassLoader());
                switch (C07031.f8700a[component.ordinal()]) {
                    case 1:
                        startService(intent2);
                        return;
                    case 2:
                        this.f8704d.b(intent2, this);
                        return;
                    default:
                        intent2.setFlags(335544320);
                        this.f8704d.a(intent2, this);
                        return;
                }
            }
            this.f8705e.m9799b();
        } catch (Throwable e) {
            this.f8706f.b(SystemTrayLogService.class.getSimpleName(), "Error reading notification", e);
        }
    }
}
