package com.facebook.notifications.protocol;

import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationHighlightOperationFragment;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationOptionRow;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.ImportanceReasonTextModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.NotifOptionSetsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: hash_id */
public interface FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields {
    @Nullable
    String mo813a();

    @Nonnull
    ImmutableList<? extends NotificationHighlightOperationFragment> mo814b();

    @Nullable
    GraphQLNotifHighlightState mo815c();

    @Nullable
    ImportanceReasonTextModel mo816d();

    @Nullable
    GraphQLNotifImportanceType mo817g();

    int gr_();

    boolean gs_();

    int gt_();

    int mo821j();

    @Nullable
    GraphQLStory mo822k();

    @Nonnull
    ImmutableList<? extends NotificationOptionRow> mo823l();

    @Nullable
    NotifOptionSetsModel mo824m();

    @Nullable
    ReactionUnitFragment mo825n();
}
