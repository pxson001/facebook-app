package com.facebook.groups.settings;

import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;

/* compiled from: ThreadItemView.setThreadSummary */
public interface GroupSubscriptionController$GroupSubscriptionChangeListener {
    void mo990a(GraphQLGroupPushSubscriptionLevel graphQLGroupPushSubscriptionLevel);

    void mo991a(GraphQLGroupRequestToJoinSubscriptionLevel graphQLGroupRequestToJoinSubscriptionLevel);

    void mo992a(GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel);
}
