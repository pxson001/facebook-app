package com.facebook.events.widget.eventcard;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: calculate_stats */
class EventActionButtonStateSelector$PrivateEventOneClickRsvpChanger implements OnClickListener {
    final /* synthetic */ EventActionButtonStateSelector f17902a;
    private final GraphQLEventGuestStatus f17903b;
    private final GraphQLEventGuestStatus f17904c;

    public EventActionButtonStateSelector$PrivateEventOneClickRsvpChanger(EventActionButtonStateSelector eventActionButtonStateSelector, GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
        this.f17902a = eventActionButtonStateSelector;
        this.f17903b = graphQLEventGuestStatus;
        this.f17904c = graphQLEventGuestStatus2;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1983930954);
        this.f17902a.e.a(this.f17903b, this.f17904c);
        Logger.a(2, EntryType.UI_INPUT_END, 1447656604, a);
    }
}
