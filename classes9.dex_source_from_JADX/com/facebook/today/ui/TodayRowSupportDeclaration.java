package com.facebook.today.ui;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.multirow.api.ViewType;
import com.facebook.today.ui.components.partdefinition.EventDescriptionUnitComponentPartDefinition;
import com.facebook.today.ui.components.partdefinition.LargeMapUnitComponentPartDefinition;
import com.facebook.today.ui.components.partdefinition.MessageBlockUnitComponentPartDefinition;
import com.facebook.today.ui.components.partdefinition.PhotoGridPartDefinition;
import com.facebook.today.ui.components.partdefinition.VerticalListInnerCardUnitComponentPartDefinition;
import com.facebook.today.ui.notificationslist.TodayNotificationsSeeAllFlatPartDefinition;
import com.google.common.collect.ImmutableList;

/* compiled from: trending_topic */
public class TodayRowSupportDeclaration implements FeedRowSupportDeclaration {
    public final void m1425a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(EventDescriptionUnitComponentPartDefinition.f1273a, LargeMapUnitComponentPartDefinition.f1279a, MessageBlockUnitComponentPartDefinition.f1283a, PhotoGridPartDefinition.f1295a, TodayNotificationsSeeAllFlatPartDefinition.f1388a, VerticalListInnerCardUnitComponentPartDefinition.f1356a);
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }
}
