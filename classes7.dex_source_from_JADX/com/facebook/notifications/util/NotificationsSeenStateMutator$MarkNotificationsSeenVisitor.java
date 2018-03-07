package com.facebook.notifications.util;

import com.facebook.graphql.consistency.visitors.ConditionalFieldUpdatingVisitor;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;

@VisibleForTesting
/* compiled from: minutiae_composer_nux */
public class NotificationsSeenStateMutator$MarkNotificationsSeenVisitor extends ConditionalFieldUpdatingVisitor<GraphQLStorySeenState> {
    public NotificationsSeenStateMutator$MarkNotificationsSeenVisitor(Collection<String> collection) {
        super(collection, 80218325, "seen_state", ImmutableSet.of(GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE, GraphQLStorySeenState.UNSEEN_AND_UNREAD), GraphQLStorySeenState.SEEN_BUT_UNREAD);
    }

    public final String m10820b() {
        return "MarkNotificationsSeen";
    }
}
