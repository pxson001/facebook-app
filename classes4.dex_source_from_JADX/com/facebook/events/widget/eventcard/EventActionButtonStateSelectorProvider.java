package com.facebook.events.widget.eventcard;

import android.content.Context;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: order_ride */
public class EventActionButtonStateSelectorProvider extends AbstractAssistedProvider<EventActionButtonStateSelector> {
    public final EventActionButtonStateSelector m6427a(EventsRsvpActionListener eventsRsvpActionListener) {
        return new EventActionButtonStateSelector(eventsRsvpActionListener, (Context) getInstance(Context.class), GlyphColorizer.a(this), EventsConnectionExperimentController.m6527a(this));
    }
}
