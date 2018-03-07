package com.facebook.notifications.widget;

import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.widget.NotificationsAdapter.NotificationsList;
import java.util.Comparator;

/* compiled from: method/mobile.zeroBuyPromo */
public class NotificationsAdapter$NotificationsList$1 implements Comparator<NotificationsEdgeFields> {
    final /* synthetic */ NotificationsList f9037a;

    public NotificationsAdapter$NotificationsList$1(NotificationsList notificationsList) {
        this.f9037a = notificationsList;
    }

    public int compare(Object obj, Object obj2) {
        return ((NotificationsEdgeFields) obj2).gr_() - ((NotificationsEdgeFields) obj).gr_();
    }
}
