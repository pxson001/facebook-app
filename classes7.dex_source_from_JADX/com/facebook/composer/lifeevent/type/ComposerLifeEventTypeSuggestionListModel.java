package com.facebook.composer.lifeevent.type;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventFieldsModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventFieldsModel.Builder;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: controlCategories */
public class ComposerLifeEventTypeSuggestionListModel implements Filterable {
    public ImmutableList<LifeEventFieldsModel> f16801a = RegularImmutableList.a;
    public ImmutableList<LifeEventFieldsModel> f16802b = RegularImmutableList.a;
    public ImmutableList<ComposerLifeEventTypeSuggestionCategoryModel> f16803c = RegularImmutableList.a;
    public LifeEventFieldsModel f16804d;
    private Filter f16805e;
    public String f16806f = "";
    public List<LifeEventFieldsModel> f16807g = RegularImmutableList.a;

    /* compiled from: controlCategories */
    class LifeEventTypeSuggestionsFilter extends Filter {
        final /* synthetic */ ComposerLifeEventTypeSuggestionListModel f16800a;

        public LifeEventTypeSuggestionsFilter(ComposerLifeEventTypeSuggestionListModel composerLifeEventTypeSuggestionListModel) {
            this.f16800a = composerLifeEventTypeSuggestionListModel;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            this.f16800a.f16806f = StringLocaleUtil.a(charSequence.toString().trim());
            FilterResults filterResults = new FilterResults();
            if (Strings.isNullOrEmpty(this.f16800a.f16806f)) {
                filterResults.count = 0;
                filterResults.values = Lists.a();
            } else {
                List a = Lists.a();
                int size = this.f16800a.f16801a.size();
                for (int i = 0; i < size; i++) {
                    LifeEventFieldsModel lifeEventFieldsModel = (LifeEventFieldsModel) this.f16800a.f16801a.get(i);
                    String a2 = StringLocaleUtil.a(lifeEventFieldsModel.a());
                    for (String startsWith : a2.split("\\s")) {
                        if (startsWith.startsWith(this.f16800a.f16806f) || a2.startsWith(this.f16800a.f16806f)) {
                            a.add(lifeEventFieldsModel);
                            break;
                        }
                    }
                }
                Builder builder = new Builder();
                builder.a = charSequence.toString();
                builder = builder;
                builder.d = this.f16800a.f16804d.l();
                builder = builder;
                builder.c = this.f16800a.f16804d.k();
                builder = builder;
                builder.e = this.f16800a.f16804d.m();
                a.add(builder.a());
                filterResults.count = a.size();
                filterResults.values = a;
            }
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (filterResults == null || filterResults.values == null) {
                this.f16800a.f16807g = Lists.a();
                return;
            }
            this.f16800a.f16807g = (List) filterResults.values;
        }
    }

    public Filter getFilter() {
        if (this.f16805e == null) {
            this.f16805e = new LifeEventTypeSuggestionsFilter(this);
        }
        return this.f16805e;
    }
}
