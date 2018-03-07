package com.facebook.userfilter;

import android.content.Context;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.C15121;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadMatcherFilter;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

/* compiled from: content_type */
public class TypeaheadUserSearchFilter extends TypeaheadMatcherFilter {
    private static final String f18489a = TypeaheadUserSearchFilter.class.getSimpleName();
    private final UserSearchService f18490b;
    private final Boolean f18491c;
    private final String f18492d;
    private final C15121 f18493e;

    @Inject
    public TypeaheadUserSearchFilter(FbHandlerThreadFactory fbHandlerThreadFactory, Context context, UserTokenMatcher userTokenMatcher, UserSearchService userSearchService, Boolean bool, @Assisted C15121 c15121) {
        super(fbHandlerThreadFactory, userTokenMatcher, c15121);
        this.f18490b = userSearchService;
        this.f18491c = bool;
        this.f18493e = c15121;
        this.f18492d = context.getString(2131236186);
    }

    protected final FilterResults mo1400b(CharSequence charSequence) {
        if (m27120c(charSequence) || !this.f18491c.booleanValue()) {
            return super.mo1400b(charSequence);
        }
        FilterResults filterResults = new FilterResults();
        try {
            m27119b(charSequence, filterResults);
            return filterResults;
        } catch (Exception e) {
            return super.mo1400b(charSequence);
        }
    }

    private static boolean m27120c(CharSequence charSequence) {
        return StringUtil.c(charSequence) || charSequence.length() < 2;
    }

    private void m27119b(CharSequence charSequence, FilterResults filterResults) {
        ImmutableList a = this.f18490b.m27125a(charSequence);
        List arrayList = new ArrayList();
        arrayList.add(new ImmutableSectionedListSection(this.f18492d, a));
        int size = this.f18493e.m28794a().size() - 1;
        for (int i = 0; i < size; i++) {
            arrayList.add(new ImmutableSectionedListSection());
        }
        filterResults.f5739a = arrayList;
        filterResults.f5740b = arrayList.size();
    }

    public final void m27121a(Collection<String> collection) {
        UserSearchService userSearchService = this.f18490b;
        userSearchService.f18498e.clear();
        userSearchService.f18498e.addAll(collection);
    }

    public final void m27123b(Collection<String> collection) {
        UserSearchService userSearchService = this.f18490b;
        userSearchService.f18499f.clear();
        userSearchService.f18499f.addAll(collection);
    }
}
