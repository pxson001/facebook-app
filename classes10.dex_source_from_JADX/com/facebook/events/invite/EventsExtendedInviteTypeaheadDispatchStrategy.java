package com.facebook.events.invite;

import com.facebook.events.EventsExtendedInviteTypeaheadSuggestionDeduper;
import com.facebook.ui.typeahead.DefaultTypeaheadDispatchStrategy;
import com.facebook.ui.typeahead.TypeaheadSuggestionListUtilProvider;
import javax.inject.Inject;

/* compiled from: choose_photo */
public class EventsExtendedInviteTypeaheadDispatchStrategy extends DefaultTypeaheadDispatchStrategy {
    @Inject
    public EventsExtendedInviteTypeaheadDispatchStrategy(TypeaheadSuggestionListUtilProvider typeaheadSuggestionListUtilProvider, EventsExtendedInviteTypeaheadSuggestionDeduper eventsExtendedInviteTypeaheadSuggestionDeduper) {
        super(typeaheadSuggestionListUtilProvider, eventsExtendedInviteTypeaheadSuggestionDeduper);
    }
}
