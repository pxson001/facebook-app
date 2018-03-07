package com.facebook.search.results.filters.controller;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.results.filters.controller.SearchResultPageFilterController.OnFilterClearButtonClickListener;
import com.facebook.search.results.filters.definition.SearchResultPageFilterDefinition.FilterPillData;
import com.facebook.search.results.filters.ui.SearchResultPageFilterPill;
import com.google.common.collect.ImmutableList;

/* compiled from: SOCIAL_EMBED_WITH_CAPTION */
public class SearchFilterPillRecyclerViewAdapter extends Adapter<FilterPillViewHolder> {
    public ImmutableList<FilterPillData> f22783a;
    public OnFilterClearButtonClickListener f22784b;

    /* compiled from: SOCIAL_EMBED_WITH_CAPTION */
    class C24171 implements OnClickListener {
        final /* synthetic */ SearchFilterPillRecyclerViewAdapter f22781a;

        C24171(SearchFilterPillRecyclerViewAdapter searchFilterPillRecyclerViewAdapter) {
            this.f22781a = searchFilterPillRecyclerViewAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1266820302);
            if (this.f22781a.f22784b != null) {
                this.f22781a.f22784b.mo1284a((Filters) view.getTag());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 601817731, a);
        }
    }

    /* compiled from: SOCIAL_EMBED_WITH_CAPTION */
    public class FilterPillViewHolder extends ViewHolder {
        public final SearchResultPageFilterPill f22782l;

        public FilterPillViewHolder(View view) {
            super(view);
            this.f22782l = (SearchResultPageFilterPill) view.findViewById(2131567277);
        }
    }

    public final void m26424a(ViewHolder viewHolder, int i) {
        FilterPillViewHolder filterPillViewHolder = (FilterPillViewHolder) viewHolder;
        FilterPillData filterPillData = (FilterPillData) this.f22783a.get(i);
        filterPillViewHolder.f22782l.setFilterTitle(filterPillData.f22810a);
        filterPillViewHolder.f22782l.setFilterIcon(filterPillData.f22811b);
        filterPillViewHolder.f22782l.m26560a(new C24171(this), filterPillData.f22812c);
    }

    public final ViewHolder m26423a(ViewGroup viewGroup, int i) {
        return new FilterPillViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130906990, viewGroup, false));
    }

    public final int aZ_() {
        return this.f22783a.size();
    }
}
