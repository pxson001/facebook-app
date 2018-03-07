package com.facebook.notifications.sections;

import android.os.Bundle;
import android.util.Pair;
import com.facebook.common.time.Clock;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.today.abtest.TodayExperimentController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: mp41 */
public class StickyNotificationsSectionSplitter implements NotificationsSectionSplitter {
    private final Set<String> f8677a = new HashSet();
    private final TodayExperimentController f8678b;
    private final Clock f8679c;
    private boolean f8680d = true;
    private long f8681e;
    private boolean f8682f = false;

    @Inject
    public StickyNotificationsSectionSplitter(TodayExperimentController todayExperimentController, Clock clock) {
        this.f8678b = todayExperimentController;
        this.f8679c = clock;
    }

    public final Pair<List<Object>, List<NotificationsEdgeFields>> mo469a(List<Object> list, List<NotificationsEdgeFields> list2) {
        if (this.f8680d && !list2.isEmpty()) {
            this.f8681e = ((NotificationsEdgeFields) list2.get(list2.size() - 1)).k().V();
            this.f8680d = false;
        }
        m10663a((List) list2);
        if (this.f8682f) {
            m10664b(list2);
            this.f8682f = false;
        }
        Collection arrayList = new ArrayList();
        int i = 0;
        long j = 0;
        for (NotificationsEdgeFields notificationsEdgeFields : list2) {
            if (i >= this.f8678b.r()) {
                break;
            }
            int i2;
            long j2;
            long a = this.f8679c.a() - (1000 * notificationsEdgeFields.k().V());
            long q = 1000 * this.f8678b.q();
            if (notificationsEdgeFields.k().V() < this.f8681e || a >= q || !this.f8677a.contains(notificationsEdgeFields.k().c())) {
                long j3 = j;
                i2 = i;
                j2 = j3;
            } else {
                if (list.isEmpty() && arrayList.isEmpty()) {
                    arrayList.add(new NotificationsSectionHeader(this.f8678b.t()));
                }
                arrayList.add(notificationsEdgeFields);
                i++;
                i2 = i;
                j2 = notificationsEdgeFields.k().V();
            }
            i = i2;
            j = j2;
        }
        if (j > 0) {
            this.f8681e = j;
        }
        list2.removeAll(arrayList);
        return new Pair(arrayList, list2);
    }

    public final void mo470a(Bundle bundle) {
        if (bundle.containsKey("should_rebuild_sections")) {
            this.f8682f = bundle.getBoolean("should_rebuild_sections");
        }
    }

    private void m10663a(List<NotificationsEdgeFields> list) {
        for (NotificationsEdgeFields notificationsEdgeFields : list) {
            Object obj = (notificationsEdgeFields.k().au().equals(GraphQLStorySeenState.SEEN_BUT_UNREAD) || notificationsEdgeFields.k().au().equals(GraphQLStorySeenState.UNSEEN_AND_UNREAD)) ? 1 : null;
            if (obj != null && notificationsEdgeFields.g().equals(GraphQLNotifImportanceType.IMPORTANT)) {
                this.f8677a.add(notificationsEdgeFields.k().c());
            }
        }
    }

    private void m10664b(List<NotificationsEdgeFields> list) {
        for (NotificationsEdgeFields notificationsEdgeFields : list) {
            if (notificationsEdgeFields.k().au().equals(GraphQLStorySeenState.SEEN_AND_READ) && this.f8677a.contains(notificationsEdgeFields.k().c())) {
                this.f8677a.remove(notificationsEdgeFields.k().c());
            }
        }
    }
}
