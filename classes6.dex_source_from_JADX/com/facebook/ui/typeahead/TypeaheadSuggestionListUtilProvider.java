package com.facebook.ui.typeahead;

import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: create-page-album */
public class TypeaheadSuggestionListUtilProvider extends AbstractAssistedProvider<TypeaheadSuggestionListUtil> {
    public static <T> TypeaheadSuggestionListUtil<T> m27056a(TypeaheadSuggestionDeduper typeaheadSuggestionDeduper) {
        return new TypeaheadSuggestionListUtil(typeaheadSuggestionDeduper);
    }
}
