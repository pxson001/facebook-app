package com.facebook.notifications.multirow;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.multirow.api.ViewType;
import com.facebook.notifications.multirow.partdefinition.NotificationsSectionHeaderPartDefinition;
import com.facebook.notifications.multirow.partdefinition.TodayNotificationSinglePartDefinition;
import com.google.common.collect.ImmutableList;

/* compiled from: custom_cta_mobile_click_entity_link */
public class NotificationsRowSupportDeclaration implements FeedRowSupportDeclaration {
    public final void m18959a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(TodayNotificationSinglePartDefinition.f16159a, NotificationsSectionHeaderPartDefinition.f16149a);
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }
}
