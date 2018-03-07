package com.facebook.ui.typeahead;

import com.google.common.collect.ImmutableList;

/* compiled from: creative_high_img_size */
public interface SuggestionFilter<T> {
    ImmutableList<T> mo1390a(TypeaheadResponse<T> typeaheadResponse, String str);

    boolean mo1396a(T t, TypeaheadResponse<T> typeaheadResponse, String str);
}
