package com.facebook.notifications.logging;

/* compiled from: isSelectable */
class NotificationsLogger$PushNotificationEvent extends NotificationsLogger$NotificationLoggerEvent {
    final /* synthetic */ NotificationsLogger f12195c;

    public NotificationsLogger$PushNotificationEvent(NotificationsLogger notificationsLogger, NotificationsLogger$Event notificationsLogger$Event, NotificationsLogger$NotificationLogObject notificationsLogger$NotificationLogObject) {
        this.f12195c = notificationsLogger;
        super(notificationsLogger, notificationsLogger$Event, notificationsLogger$NotificationLogObject, "push_notifications_tray".toString());
    }

    protected final void mo1085a(NotificationsLogger$NotificationLogObject notificationsLogger$NotificationLogObject) {
        b("ct", notificationsLogger$NotificationLogObject.m19111c());
        b("ci", notificationsLogger$NotificationLogObject.f12171c);
        b("n", notificationsLogger$NotificationLogObject.f12169a);
        a("u", notificationsLogger$NotificationLogObject.f12172d);
        a("ib", notificationsLogger$NotificationLogObject.f12180l);
        a("hpp", notificationsLogger$NotificationLogObject.f12181m);
        a("it", notificationsLogger$NotificationLogObject.f12182n);
        a("lia", notificationsLogger$NotificationLogObject.f12183o);
        a("cia", notificationsLogger$NotificationLogObject.f12184p);
        if (notificationsLogger$NotificationLogObject.f12188t != null) {
            b("push_source", notificationsLogger$NotificationLogObject.f12187s);
            b("push_id", notificationsLogger$NotificationLogObject.f12188t);
            a("time_to_tray_ms", this.f12195c.c.a() - notificationsLogger$NotificationLogObject.f12189u);
        }
    }
}
