package com.facebook.ui.typeahead;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: created_place */
public class CompoundSuggestionFilter<T> extends BaseSuggestionFilter<T> {
    private final ImmutableList<SuggestionFilter<T>> f18409a;

    public CompoundSuggestionFilter(ImmutableList<SuggestionFilter<T>> immutableList) {
        this.f18409a = immutableList;
        Preconditions.checkArgument(!immutableList.isEmpty(), "No filters were supplied.");
    }

    public final boolean mo1396a(T t, TypeaheadResponse<T> typeaheadResponse, String str) {
        int size = this.f18409a.size();
        for (int i = 0; i < size; i++) {
            if (!((SuggestionFilter) this.f18409a.get(i)).mo1396a(t, typeaheadResponse, str)) {
                return false;
            }
        }
        return true;
    }
}
