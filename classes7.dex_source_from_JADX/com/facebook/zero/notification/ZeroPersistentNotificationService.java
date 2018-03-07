package com.facebook.zero.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.service.FbService;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.content.SecurePendingIntent;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: zip_placeholder_text */
public class ZeroPersistentNotificationService extends FbService {
    private static final Class<?> f121b = ZeroPersistentNotificationService.class;
    @Inject
    AnalyticsLogger f122a;
    private Notification f123c;
    private String f124d = "";
    private String f125e = "";

    public final void m123a() {
        super.a();
        AppInitLockHelper.a(getApplicationContext());
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public final int m122a(Intent intent, int i, int i2) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (intent == null) {
            ImmutableList a = ZeroPersistentNotificationIDs.m119a();
            int size = a.size();
            for (int i3 = 0; i3 < size; i3++) {
                notificationManager.cancel(((Integer) a.get(i3)).intValue());
            }
        } else {
            synchronized (this) {
                String action = intent.getAction();
                if ("com.facebook.zero.notification.ZeroPersistentNotificationService.SHOW".equals(action)) {
                    if (m120a(intent)) {
                        notificationManager.notify(intent.getIntExtra("id", 0), this.f123c);
                        return 1;
                    }
                } else if ("com.facebook.zero.notification.ZeroPersistentNotificationService.TAP".equals(action)) {
                    m121b();
                    return 1;
                } else if ("com.facebook.zero.notification.ZeroPersistentNotificationService.HIDE".equals(action)) {
                    Integer.valueOf(intent.getIntExtra("id", 0));
                    notificationManager.cancel(intent.getIntExtra("id", 0));
                }
            }
        }
        stopSelf(i2);
        return 2;
    }

    private boolean m120a(Intent intent) {
        if (!intent.hasExtra("title") || !intent.hasExtra("text") || !ZeroPersistentNotificationIDs.m119a().contains(Integer.valueOf(intent.getIntExtra("id", 0)))) {
            return false;
        }
        CharSequence stringExtra = intent.getStringExtra("title");
        CharSequence stringExtra2 = intent.getStringExtra("text");
        if (this.f123c != null && this.f124d.equals(stringExtra) && this.f125e.equals(stringExtra2)) {
            return true;
        }
        this.f124d = stringExtra;
        this.f125e = stringExtra2;
        Intent intent2 = new Intent(this, ZeroPersistentNotificationService.class);
        intent.setAction("com.facebook.zero.notification.ZeroPersistentNotificationService.TAP");
        PendingIntent a = SecurePendingIntent.a(this, 0, intent2, 134217728);
        Builder b = new Builder(this).a(0).a(true).a(2130840416).a(stringExtra).b(stringExtra2);
        b.v = true;
        b = b;
        b.d = a;
        Builder builder = b;
        builder.j = 2;
        this.f123c = builder.b(true).c();
        return true;
    }

    private void m121b() {
        HoneyClientEventFast a = this.f122a.a("messenger_free_data_notification_click", false);
        if (a.a()) {
            a.b();
        }
    }
}
