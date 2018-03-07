package com.facebook.notifications.intent;

import android.content.Context;
import android.content.Intent;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.logging.NotificationsLogger.Component;
import com.facebook.notifications.logging.NotificationsLogger.Event;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.service.SystemTrayLogService;
import javax.inject.Inject;

/* compiled from: fetch_bitrate_est */
public class NotificationsLoggingIntentBuilder {
    public final Context f11666a;

    public static NotificationsLoggingIntentBuilder m12213b(InjectorLike injectorLike) {
        return new NotificationsLoggingIntentBuilder((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public NotificationsLoggingIntentBuilder(Context context) {
        this.f11666a = context;
    }

    public final Intent m12214a(NotificationLogObject notificationLogObject, Intent intent, Component component, Event event, int i) {
        Intent putExtra = new Intent(this.f11666a, SystemTrayLogService.class).putExtra("NOTIF_LOG", notificationLogObject);
        String str = "EVENT_TYPE";
        if (event == null) {
            event = Event.CLICK_FROM_TRAY;
        }
        return putExtra.putExtra(str, event).putExtra("COMPONENT_TYPE", component).putExtra("NOTIFICATION_ID", i).putExtra(SystemTrayLogService.a, intent.addFlags(268435456));
    }

    public static NotificationsLoggingIntentBuilder m12212a(InjectorLike injectorLike) {
        return m12213b(injectorLike);
    }
}
