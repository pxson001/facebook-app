package com.facebook.today.notifications;

import com.facebook.inject.InjectorLike;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import java.util.Comparator;

/* compiled from: u_tex */
public class NotificationHighlightsComparator implements Comparator<NotificationsEdgeFields> {
    public static NotificationHighlightsComparator m1359a(InjectorLike injectorLike) {
        return new NotificationHighlightsComparator();
    }

    public int compare(Object obj, Object obj2) {
        NotificationsEdgeFields notificationsEdgeFields = (NotificationsEdgeFields) obj;
        NotificationsEdgeFields notificationsEdgeFields2 = (NotificationsEdgeFields) obj2;
        int gr_ = notificationsEdgeFields2.gr_() - notificationsEdgeFields.gr_();
        return gr_ != 0 ? gr_ : (int) (notificationsEdgeFields.k().V() - notificationsEdgeFields2.k().V());
    }
}
