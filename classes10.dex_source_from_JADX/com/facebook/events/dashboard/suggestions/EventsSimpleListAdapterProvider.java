package com.facebook.events.dashboard.suggestions;

import android.content.Context;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: com.facebook.orca.login.AuthStateMachineMonitor.LOGOUT_COMPLETE */
public class EventsSimpleListAdapterProvider extends AbstractAssistedProvider<EventsSimpleListAdapter> {
    public final EventsSimpleListAdapter m17520a(EventAnalyticsParams eventAnalyticsParams) {
        return new EventsSimpleListAdapter(eventAnalyticsParams, (Context) getInstance(Context.class));
    }
}
