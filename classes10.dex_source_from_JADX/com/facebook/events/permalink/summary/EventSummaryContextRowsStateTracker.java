package com.facebook.events.permalink.summary;

import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.InjectorLike;

/* compiled from: background_location_nux_interstitial_eligibility_state */
public class EventSummaryContextRowsStateTracker {
    public int f18923a = 0;
    public int f18924b = 0;

    public static EventSummaryContextRowsStateTracker m19162a(InjectorLike injectorLike) {
        return new EventSummaryContextRowsStateTracker();
    }

    public static int m19161a(boolean z, GraphQLConnectionStyle graphQLConnectionStyle, GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventWatchStatus graphQLEventWatchStatus) {
        int i = 0;
        if (graphQLConnectionStyle == GraphQLConnectionStyle.RSVP) {
            if (z || graphQLEventGuestStatus == null) {
                i = 1;
            }
        } else if (graphQLConnectionStyle == GraphQLConnectionStyle.INTERESTED && graphQLEventWatchStatus == GraphQLEventWatchStatus.UNWATCHED) {
            i = 1;
        }
        if (i != 0) {
            return 2;
        }
        return 1;
    }
}
