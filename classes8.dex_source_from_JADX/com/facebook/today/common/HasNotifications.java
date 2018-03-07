package com.facebook.today.common;

import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.annotation.Nullable;

/* compiled from: custom_cta_uncheck_setup_deeplink */
public interface HasNotifications extends AnyEnvironment {
    @Nullable
    NotificationsEdgeFields mo971a(String str);

    void mo972a();

    void mo973a(GraphQLStory graphQLStory, @Nullable GraphQLNotifHighlightState graphQLNotifHighlightState);

    void mo974a(NotificationsEdgeFields notificationsEdgeFields);

    void mo975a(String str, ReactionUnitComponentFields reactionUnitComponentFields);

    boolean mo976a(NotificationsEdgeFields notificationsEdgeFields, boolean z);

    boolean mo977a(String str, boolean z);

    void mo978b(String str);
}
