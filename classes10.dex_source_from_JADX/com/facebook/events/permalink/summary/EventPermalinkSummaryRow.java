package com.facebook.events.permalink.summary;

import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import javax.annotation.Nullable;

/* compiled from: background_location_settings */
public interface EventPermalinkSummaryRow {
    void mo851a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams, boolean z);

    boolean mo852a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel);
}
