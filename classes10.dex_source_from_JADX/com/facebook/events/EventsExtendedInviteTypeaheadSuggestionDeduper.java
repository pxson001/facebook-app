package com.facebook.events;

import com.facebook.inject.InjectorLike;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.TypeaheadSuggestionDeduper;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;

/* compiled from: context_banner_impression */
public class EventsExtendedInviteTypeaheadSuggestionDeduper implements TypeaheadSuggestionDeduper<SimpleUserToken> {
    public static EventsExtendedInviteTypeaheadSuggestionDeduper m16329a(InjectorLike injectorLike) {
        return new EventsExtendedInviteTypeaheadSuggestionDeduper();
    }

    public final Object m16330a(Object obj, Object obj2, FetchSource fetchSource) {
        return fetchSource != FetchSource.REMOTE ? (SimpleUserToken) obj2 : (SimpleUserToken) obj;
    }
}
