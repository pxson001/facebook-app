package com.facebook.notifications.event;

/* compiled from: no logging debug info */
public class NotificationsEvents {

    /* compiled from: no logging debug info */
    public class NotificationsActionExecutedEvent implements NotificationsEvent {
        public final String f8155a;

        public NotificationsActionExecutedEvent(String str) {
            this.f8155a = str;
        }
    }

    /* compiled from: no logging debug info */
    public abstract class NotificationsActionExecutedSubscriber extends NotificationsEventSubscriber<NotificationsActionExecutedEvent> {
        public final Class m9780a() {
            return NotificationsActionExecutedEvent.class;
        }
    }

    /* compiled from: no logging debug info */
    public class NotificationsClickedEvent implements NotificationsEvent {
        public final String f8156a;

        public NotificationsClickedEvent(String str) {
            this.f8156a = str;
        }
    }

    /* compiled from: no logging debug info */
    public abstract class NotificationsClickedEventSubscriber extends NotificationsEventSubscriber<NotificationsClickedEvent> {
        public final Class m9781a() {
            return NotificationsClickedEvent.class;
        }
    }
}
