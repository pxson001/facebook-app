package com.facebook.notifications.cache;

import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.google.common.annotations.VisibleForTesting;
import java.util.Comparator;

@VisibleForTesting
/* compiled from: mobile2 */
class NotificationStoryCreationTimeComparator implements Comparator<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> {
    public int compare(Object obj, Object obj2) {
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) obj;
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2 = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) obj2;
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k().V() > fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2.mo822k().V()) {
            return -1;
        }
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k().V() < fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2.mo822k().V()) {
            return 1;
        }
        return 0;
    }

    NotificationStoryCreationTimeComparator() {
    }
}
