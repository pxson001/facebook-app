package com.facebook.notifications.settings;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.multirow.api.ViewType;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsGapPartDefinition;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsSelectorPartDefinition;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsTextWithButtonPartDefinition;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsTogglePartDefinition;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsWashTextPartDefinition;
import com.google.common.collect.ImmutableList;

/* compiled from: minutiae_verb_picker_time_to_fetch_end */
public class NotificationSettingsRowSupportDeclaration implements FeedRowSupportDeclaration {
    public final void m10718a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(NotificationSettingsGapPartDefinition.f8774a, NotificationSettingsHeaderPartDefinition.f8723a, NotificationSettingsPartDefinition.f8739a, NotificationSettingsSelectorPartDefinition.f8796a, NotificationSettingsTogglePartDefinition.f8825a, NotificationSettingsTextWithButtonPartDefinition.f8810a, NotificationSettingsWashTextPartDefinition.f8834a);
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }
}
