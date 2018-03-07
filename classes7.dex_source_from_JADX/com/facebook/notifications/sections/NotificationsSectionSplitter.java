package com.facebook.notifications.sections;

import android.os.Bundle;
import android.util.Pair;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import java.util.List;

/* compiled from: mp4a */
public interface NotificationsSectionSplitter {
    Pair<List<Object>, List<NotificationsEdgeFields>> mo469a(List<Object> list, List<NotificationsEdgeFields> list2);

    void mo470a(Bundle bundle);
}
