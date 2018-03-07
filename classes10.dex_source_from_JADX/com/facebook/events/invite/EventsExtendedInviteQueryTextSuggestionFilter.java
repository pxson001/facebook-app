package com.facebook.events.invite;

import com.facebook.search.util.TypeaheadTextMatcherFactory;
import com.facebook.ui.typeahead.BaseSuggestionFilter;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import javax.inject.Inject;

/* compiled from: clearCookies */
public class EventsExtendedInviteQueryTextSuggestionFilter extends BaseSuggestionFilter<SimpleUserToken> {
    private final TypeaheadTextMatcherFactory f17678a;

    public final boolean m18005a(Object obj, TypeaheadResponse typeaheadResponse, String str) {
        return this.f17678a.a(str).a(((SimpleUserToken) obj).b());
    }

    @Inject
    public EventsExtendedInviteQueryTextSuggestionFilter(TypeaheadTextMatcherFactory typeaheadTextMatcherFactory) {
        this.f17678a = typeaheadTextMatcherFactory;
    }
}
