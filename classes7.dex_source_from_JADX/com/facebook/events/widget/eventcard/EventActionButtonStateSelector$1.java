package com.facebook.events.widget.eventcard;

import com.facebook.events.connectionqe.EventsConnectionStyleExperiment.PublicEventAction;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;

/* compiled from: calculate_stats */
public /* synthetic */ class EventActionButtonStateSelector$1 {
    public static final /* synthetic */ int[] f17900a = new int[PublicEventAction.values().length];
    public static final /* synthetic */ int[] f17901b = new int[GraphQLEventGuestStatus.values().length];

    static {
        try {
            f17901b[GraphQLEventGuestStatus.GOING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f17901b[GraphQLEventGuestStatus.MAYBE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f17901b[GraphQLEventGuestStatus.NOT_GOING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f17900a[PublicEventAction.WATCH_INTERESTED.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f17900a[PublicEventAction.GOING.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f17900a[PublicEventAction.NOT_INTERESTED_OR_NOT_GOING_OR_IGNORE.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
    }
}
