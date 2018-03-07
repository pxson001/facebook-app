package com.facebook.ui.typeahead;

import com.google.common.collect.ImmutableList;

/* compiled from: createPagePhotoAlbum */
public class NoOpSuggestionFilter<T> implements SuggestionFilter<T> {
    public static final NoOpSuggestionFilter f18411a = new NoOpSuggestionFilter();

    private NoOpSuggestionFilter() {
    }

    public final boolean mo1396a(T t, TypeaheadResponse<T> typeaheadResponse, String str) {
        return true;
    }

    public final ImmutableList<T> mo1390a(TypeaheadResponse<T> typeaheadResponse, String str) {
        return typeaheadResponse.f18440b.f18413b;
    }
}
