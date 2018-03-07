package com.facebook.ui.typeahead;

import javax.inject.Inject;

/* compiled from: create_profile_video_android */
public class DefaultTypeaheadDispatchStrategy {
    private final TypeaheadSuggestionListUtil f18410a;

    @Inject
    public DefaultTypeaheadDispatchStrategy(TypeaheadSuggestionListUtilProvider typeaheadSuggestionListUtilProvider, TypeaheadSuggestionDeduper typeaheadSuggestionDeduper) {
        this.f18410a = TypeaheadSuggestionListUtilProvider.m27056a(typeaheadSuggestionDeduper);
    }

    public final TypeaheadResponse m27025a(TypeaheadResponse typeaheadResponse, SearchResponse searchResponse, SearchResponse searchResponse2, MatchType matchType) {
        return new TypeaheadResponse(typeaheadResponse.f18439a, this.f18410a.m27054a(searchResponse2, searchResponse, FetchSource.MEMORY_CACHE), typeaheadResponse.f18441c, matchType);
    }
}
