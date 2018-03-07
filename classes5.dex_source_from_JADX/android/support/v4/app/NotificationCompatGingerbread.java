package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import com.facebook.hiddenmethods.support.v4.NotificationHiddenMethods;

/* compiled from: welcome_feed_outgoing_unit */
class NotificationCompatGingerbread {
    NotificationCompatGingerbread() {
    }

    public static Notification m179a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        NotificationHiddenMethods.m9855a(notification, context, charSequence, charSequence2, pendingIntent);
        notification.fullScreenIntent = pendingIntent2;
        return notification;
    }
}
