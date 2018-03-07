package com.facebook.groups.widget.groupeventrow;

import com.facebook.events.model.Event;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;

/* compiled from: UPDATE_NO_APPROVAL */
public interface GroupEventRsvpViewListener {
    void mo957a();

    void mo958a(Event event, GraphQLEventGuestStatus graphQLEventGuestStatus);

    void mo959a(Event event, GraphQLEventWatchStatus graphQLEventWatchStatus);

    void mo960b(Event event, GraphQLEventGuestStatus graphQLEventGuestStatus);

    void mo961b(Event event, GraphQLEventWatchStatus graphQLEventWatchStatus);
}
