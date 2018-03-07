package com.facebook.notifications.sections;

import android.os.Bundle;
import android.util.Pair;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.today.abtest.TodayExperimentController;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: mp42 */
public class SeenNotificationsSectionSplitter implements NotificationsSectionSplitter {
    public TodayExperimentController f8676a;

    @Inject
    public SeenNotificationsSectionSplitter(TodayExperimentController todayExperimentController) {
        this.f8676a = todayExperimentController;
    }

    public final Pair<List<Object>, List<NotificationsEdgeFields>> mo469a(List<Object> list, List<NotificationsEdgeFields> list2) {
        ArrayList arrayList = new ArrayList();
        if (!list2.isEmpty()) {
            Object obj;
            String o;
            if (list.isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                o = this.f8676a.o();
            } else {
                o = this.f8676a.p();
            }
            arrayList.add(new NotificationsSectionHeader(o));
            arrayList.addAll(list2);
        }
        return new Pair(arrayList, new ArrayList());
    }

    public final void mo470a(Bundle bundle) {
    }
}
