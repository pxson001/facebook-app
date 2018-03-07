package com.facebook.widget.tokenizedtypeahead.ui.listview;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.filter.AbstractCustomFilter;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.facebook.widget.listview.ExpandableSectionedListSection;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseTokenMatcher;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.C15121;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: context_items */
public class TypeaheadMatcherFilter extends AbstractCustomFilter {
    private final BaseTokenMatcher f18487a;
    private final C15121 f18488b;

    @Inject
    public TypeaheadMatcherFilter(FbHandlerThreadFactory fbHandlerThreadFactory, @Assisted BaseTokenMatcher baseTokenMatcher, @Assisted C15121 c15121) {
        super(fbHandlerThreadFactory);
        this.f18487a = baseTokenMatcher;
        this.f18488b = c15121;
    }

    protected FilterResults mo1400b(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();
        List<SectionedListSection> a = this.f18488b.m28794a();
        filterResults.f5740b = a.size();
        if (StringUtil.c(charSequence)) {
            filterResults.f5739a = a;
            return filterResults;
        }
        this.f18487a.mo1197a(charSequence.toString());
        List arrayList = new ArrayList();
        for (SectionedListSection sectionedListSection : a) {
            Builder builder = ImmutableList.builder();
            List e;
            if (sectionedListSection instanceof ExpandableSectionedListSection) {
                e = ((ExpandableSectionedListSection) sectionedListSection).mo1212e();
            } else {
                e = sectionedListSection.mo434b();
            }
            for (BaseToken baseToken : r1) {
                if (this.f18487a.mo1198a(baseToken)) {
                    builder.c(baseToken);
                }
            }
            arrayList.add(new ImmutableSectionedListSection(sectionedListSection.mo432a(), builder.b()));
        }
        filterResults.f5739a = arrayList;
        return filterResults;
    }

    protected final void mo1399a(CharSequence charSequence, FilterResults filterResults) {
        C15121 c15121 = this.f18488b;
        if (filterResults.f5739a != null) {
            c15121.f20129a.f18480d = (List) filterResults.f5739a;
        } else {
            c15121.f20129a.f18480d = c15121.f20129a.f18479c;
        }
        AdapterDetour.a(c15121.f20129a, 921893090);
    }
}
