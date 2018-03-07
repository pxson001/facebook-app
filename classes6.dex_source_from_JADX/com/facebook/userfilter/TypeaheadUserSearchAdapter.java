package com.facebook.userfilter;

import android.view.inputmethod.InputMethodManager;
import com.facebook.widget.filter.CustomFilter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadMatcherFilterProvider;
import javax.inject.Inject;

/* compiled from: context_status */
public class TypeaheadUserSearchAdapter extends TypeaheadAdapter {
    private final TypeaheadUserSearchFilter f18486e;

    @Inject
    public TypeaheadUserSearchAdapter(InputMethodManager inputMethodManager, TypeaheadMatcherFilterProvider typeaheadMatcherFilterProvider, TypeaheadUserSearchFilterProvider typeaheadUserSearchFilterProvider) {
        super(inputMethodManager, typeaheadMatcherFilterProvider);
        this.f18486e = typeaheadUserSearchFilterProvider.m27124a(m27114e());
    }

    public final CustomFilter mo438a() {
        return this.f18486e;
    }
}
