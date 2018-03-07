package com.facebook.notifications.logging;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: isSelectable */
abstract class NotificationsLogger$NotificationLoggerEvent extends HoneyClientEvent {
    final /* synthetic */ NotificationsLogger f12166d;

    protected abstract void mo1085a(NotificationsLogger$NotificationLogObject notificationsLogger$NotificationLogObject);

    public NotificationsLogger$NotificationLoggerEvent(NotificationsLogger notificationsLogger, NotificationsLogger$Event notificationsLogger$Event, NotificationsLogger$NotificationLogObject notificationsLogger$NotificationLogObject, String str) {
        this.f12166d = notificationsLogger;
        super(notificationsLogger$Event.toString());
        this.e = notificationsLogger$NotificationLogObject.f12175g;
        this.d = notificationsLogger$NotificationLogObject.f12176h;
        this.c = str;
        a("id", notificationsLogger$NotificationLogObject.f12173e);
        b("l", notificationsLogger$NotificationLogObject.f12177i);
        mo1085a(notificationsLogger$NotificationLogObject);
    }
}
