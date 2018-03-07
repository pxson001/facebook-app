package com.facebook.ui.typeahead;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: creative_editing_metadata */
public abstract class BaseSuggestionFilter<T> implements SuggestionFilter<T> {
    public final ImmutableList<T> mo1390a(TypeaheadResponse<T> typeaheadResponse, String str) {
        Builder builder = new Builder();
        ImmutableList immutableList = typeaheadResponse.f18440b.f18413b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Object obj = immutableList.get(i);
            if (mo1396a(obj, typeaheadResponse, str)) {
                builder.c(obj);
            }
        }
        return builder.b();
    }
}
