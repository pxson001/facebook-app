package com.facebook.events.permalink.adapters;

import com.facebook.events.model.Event;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import javax.annotation.Nullable;

/* compiled from: byte */
public class EventFeedComposerItemCollection extends OneItemListItemCollection<Event> {
    public final void m18514a(@Nullable Event event) {
        if (event == null || !event.a(EventViewerCapability.POST)) {
            event = null;
        }
        this.a = event;
    }
}
