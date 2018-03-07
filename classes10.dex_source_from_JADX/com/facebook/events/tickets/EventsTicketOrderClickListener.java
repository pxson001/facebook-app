package com.facebook.events.tickets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.tickets.modal.EventTicketsOrdersActivity;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: asset_ */
public class EventsTicketOrderClickListener implements OnClickListener {
    private final FetchEventPermalinkFragmentModel f19195a;
    private final String f19196b;
    private final EventEventLogger f19197c;
    private final SecureContextHelper f19198d;

    @Inject
    public EventsTicketOrderClickListener(@Assisted FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, @Assisted String str, EventEventLogger eventEventLogger, SecureContextHelper secureContextHelper) {
        this.f19195a = fetchEventPermalinkFragmentModel;
        this.f19196b = str;
        this.f19197c = eventEventLogger;
        this.f19198d = secureContextHelper;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1124627627);
        Context context = view.getContext();
        Intent a2 = EventTicketsOrdersActivity.m19432a(context, this.f19195a, this.f19196b);
        Activity activity = (Activity) ContextUtils.a(context, Activity.class);
        if (activity != null) {
            activity.finish();
        }
        this.f19198d.a(a2, activity);
        EventEventLogger eventEventLogger = this.f19197c;
        String dL_ = this.f19195a.dL_();
        String str = this.f19196b;
        HoneyClientEventFast a3 = eventEventLogger.f17787i.a("event_purchased_tickets_button_tapped", false);
        if (a3.a()) {
            a3.a("event_ticketing").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(dL_).a("event_id", dL_).a("order_id", str).b();
        }
        Logger.a(2, EntryType.UI_INPUT_END, 393318737, a);
    }
}
