package com.facebook.notifications.sections;

import android.os.Bundle;
import android.util.Pair;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.today.abtest.TodayExperimentController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: moved_text_count */
public class UnseenNotificationsSectionSplitter implements NotificationsSectionSplitter {
    private TodayExperimentController f8683a;
    public final Map<String, NotificationsEdgeFields> f8684b = new HashMap();
    private boolean f8685c;

    @Inject
    public UnseenNotificationsSectionSplitter(TodayExperimentController todayExperimentController) {
        this.f8683a = todayExperimentController;
    }

    public final Pair<List<Object>, List<NotificationsEdgeFields>> mo469a(List<Object> list, List<NotificationsEdgeFields> list2) {
        if (list2.isEmpty()) {
            return new Pair(list2, list2);
        }
        int i;
        if (this.f8685c) {
            for (NotificationsEdgeFields notificationsEdgeFields : list2) {
                if (notificationsEdgeFields.k().au().equals(GraphQLStorySeenState.UNSEEN_AND_UNREAD)) {
                    this.f8684b.put(notificationsEdgeFields.k().c(), notificationsEdgeFields);
                }
            }
            this.f8685c = false;
        }
        if (this.f8684b.isEmpty()) {
            i = -1;
        } else {
            for (int size = list2.size() - 1; size >= 0; size--) {
                if (this.f8684b.containsKey(((NotificationsEdgeFields) list2.get(size)).k().c())) {
                    i = size;
                    break;
                }
            }
            i = -1;
        }
        int i2 = i;
        ArrayList arrayList = new ArrayList();
        if (i2 >= 0) {
            arrayList.add(new NotificationsSectionHeader(this.f8683a.t()));
            arrayList.addAll(list2.subList(0, i2 + 1));
        }
        return new Pair(arrayList, list2.subList(i2 + 1, list2.size()));
    }

    public final void mo470a(Bundle bundle) {
        if (bundle.containsKey("should_rebuild_sections")) {
            long j = bundle.getLong("latest_notification_creation_time");
            if (j > 0) {
                Iterator it = this.f8684b.entrySet().iterator();
                while (it.hasNext()) {
                    if (((NotificationsEdgeFields) ((Entry) it.next()).getValue()).k().V() <= j) {
                        it.remove();
                    }
                }
            }
        } else if (bundle.containsKey("has_new_data")) {
            this.f8685c = bundle.getBoolean("has_new_data");
        }
    }
}
