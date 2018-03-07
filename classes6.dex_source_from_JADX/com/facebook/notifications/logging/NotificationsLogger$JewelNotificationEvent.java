package com.facebook.notifications.logging;

/* compiled from: isSelectable */
public class NotificationsLogger$JewelNotificationEvent extends NotificationsLogger$NotificationLoggerEvent {
    final /* synthetic */ NotificationsLogger f12167c;

    public NotificationsLogger$JewelNotificationEvent(NotificationsLogger notificationsLogger, NotificationsLogger$Event notificationsLogger$Event, NotificationsLogger$NotificationLogObject notificationsLogger$NotificationLogObject) {
        this.f12167c = notificationsLogger;
        super(notificationsLogger, notificationsLogger$Event, notificationsLogger$NotificationLogObject, "notifications_jewel_module".toString());
    }

    protected final void mo1085a(NotificationsLogger$NotificationLogObject notificationsLogger$NotificationLogObject) {
        a("hn", notificationsLogger$NotificationLogObject.f12178j);
        a("iu", notificationsLogger$NotificationLogObject.f12179k);
        a("pos", notificationsLogger$NotificationLogObject.f12190v);
        a("highlight_enabled", notificationsLogger$NotificationLogObject.f12191w);
        b("highlight_type", notificationsLogger$NotificationLogObject.f12192x);
        b("highlight_state", notificationsLogger$NotificationLogObject.f12193y);
        a("like_count", notificationsLogger$NotificationLogObject.f12194z);
        b("seen_state", notificationsLogger$NotificationLogObject.f12168A);
    }
}
