package com.facebook.search.results.fragment.pps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.protocol.SnippetsUtil;
import com.facebook.search.suggestions.viewbinder.EntitySuggestionViewBinder;
import com.facebook.search.suggestions.viewbinder.TextResultsViewBinder;
import com.facebook.search.typeahead.rows.SearchTypeaheadEntityPartDefinition;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: SENDING */
public class SeeMoreResultsListAdapter extends FbBaseAdapter {
    private final EntitySuggestionViewBinder f23081a;
    private final TextResultsViewBinder f23082b;
    private final LayoutInflater f23083c;
    private final SnippetsUtil f23084d;
    public ImmutableList<SeeMoreResultPageUnit> f23085e;

    @Inject
    public SeeMoreResultsListAdapter(EntitySuggestionViewBinder entitySuggestionViewBinder, TextResultsViewBinder textResultsViewBinder, LayoutInflater layoutInflater, SnippetsUtil snippetsUtil) {
        this.f23081a = entitySuggestionViewBinder;
        this.f23082b = textResultsViewBinder;
        this.f23083c = layoutInflater;
        this.f23084d = snippetsUtil;
    }

    public int getCount() {
        return this.f23085e != null ? this.f23085e.size() : 0;
    }

    public Object getItem(int i) {
        return this.f23085e.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final View m26750a(int i, ViewGroup viewGroup) {
        return this.f23083c.inflate(2130904629, viewGroup, false);
    }

    public final void m26751a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        SeeMoreResultPageUnit seeMoreResultPageUnit = (SeeMoreResultPageUnit) obj;
        ContentView contentView = (ContentView) view;
        EntitySuggestionViewBinder entitySuggestionViewBinder = this.f23081a;
        EntityTypeaheadUnit entityTypeaheadUnit = seeMoreResultPageUnit.f22265a;
        contentView.setThumbnailUri(entityTypeaheadUnit.f22048d);
        contentView.setTitleText(SearchTypeaheadEntityPartDefinition.a(entitySuggestionViewBinder.a, entityTypeaheadUnit, entitySuggestionViewBinder.b));
        contentView.setSubtitleText(entityTypeaheadUnit.f22049e);
        contentView.setMetaText(entityTypeaheadUnit.f22050f);
    }

    public final void m26752a(ImmutableList<SeeMoreResultPageUnit> immutableList) {
        this.f23085e = immutableList;
        AdapterDetour.a(this, -464534319);
    }
}
