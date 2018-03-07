package com.facebook.notifications.sections;

import android.util.Pair;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.today.abtest.TodayExperimentController;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: mqt_ */
public class NotificationsSectionBuilder {
    public final List<NotificationsSectionSplitter> f8673a = new ArrayList();
    private final TodayExperimentController f8674b;

    @Inject
    public NotificationsSectionBuilder(UnseenNotificationsSectionSplitter unseenNotificationsSectionSplitter, StickyNotificationsSectionSplitter stickyNotificationsSectionSplitter, SeenNotificationsSectionSplitter seenNotificationsSectionSplitter, TodayExperimentController todayExperimentController) {
        this.f8673a.add(unseenNotificationsSectionSplitter);
        this.f8673a.add(stickyNotificationsSectionSplitter);
        this.f8673a.add(seenNotificationsSectionSplitter);
        this.f8674b = todayExperimentController;
    }

    public final ImmutableList<Object> m10658a(List<NotificationsEdgeFields> list) {
        if (this.f8674b.b()) {
            Builder builder = ImmutableList.builder();
            List arrayList = new ArrayList();
            for (NotificationsSectionSplitter a : this.f8673a) {
                Pair a2 = a.mo469a(arrayList, list);
                arrayList = (List) a2.first;
                builder.b(arrayList);
                list = (List) a2.second;
            }
            return builder.b();
        }
        Builder builder2 = ImmutableList.builder();
        builder2.b(list);
        return builder2.b();
    }
}
