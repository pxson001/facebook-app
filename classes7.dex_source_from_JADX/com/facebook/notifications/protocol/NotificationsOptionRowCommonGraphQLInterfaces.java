package com.facebook.notifications.protocol;

import com.facebook.graphql.enums.GraphQLNotifOptionRowSetDisplayStyle;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: negativeFeedbackActionParams */
public class NotificationsOptionRowCommonGraphQLInterfaces {

    /* compiled from: negativeFeedbackActionParams */
    public interface SubmenuOptionSetFragment {
        @Nonnull
        ImmutableList<? extends NotifOptionSetFragment> mo454c();
    }

    /* compiled from: negativeFeedbackActionParams */
    public interface StyleOnlyNotifOptionSetDisplayFragment {
        @Nullable
        GraphQLNotifOptionRowSetDisplayStyle mo465c();
    }
}
