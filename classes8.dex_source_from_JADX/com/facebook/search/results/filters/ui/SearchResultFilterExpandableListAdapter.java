package com.facebook.search.results.filters.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import com.facebook.inject.Assisted;
import com.facebook.search.results.filters.definition.FilterPersistentState;
import com.facebook.search.results.filters.definition.SearchResultPageFilterDefinition;
import com.facebook.search.results.filters.definition.SearchResultPageFilterDefinitionRegistry;
import com.facebook.search.results.filters.ui.SearchResultPageFilterFragment.C24411;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsInterfaces.SearchResultPageMainFilterFragment.MainFilter;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageMainFilterFragmentModel.MainFilterModel;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: SINGLE_PHOTO_STORY */
public class SearchResultFilterExpandableListAdapter extends BaseExpandableListAdapter {
    private final C24411 f22921a;
    private final SearchResultPageFilterDefinitionRegistry f22922b;
    public ImmutableList<? extends MainFilter> f22923c;
    public final HashMap<String, FilterPersistentState> f22924d = new HashMap();
    public final C24401 f22925e = new C24401(this);

    /* compiled from: SINGLE_PHOTO_STORY */
    public class C24401 {
        final /* synthetic */ SearchResultFilterExpandableListAdapter f22920a;

        C24401(SearchResultFilterExpandableListAdapter searchResultFilterExpandableListAdapter) {
            this.f22920a = searchResultFilterExpandableListAdapter;
        }

        public final void m26546a(FilterPersistentState filterPersistentState) {
            if (this.f22920a.f22924d != null) {
                this.f22920a.f22924d.put(filterPersistentState.f22796a, filterPersistentState);
                this.f22920a.notifyDataSetChanged();
            }
        }
    }

    @Inject
    public SearchResultFilterExpandableListAdapter(@Assisted C24411 c24411, SearchResultPageFilterDefinitionRegistry searchResultPageFilterDefinitionRegistry) {
        this.f22921a = c24411;
        this.f22922b = searchResultPageFilterDefinitionRegistry;
    }

    public final void m26548a(ImmutableList<? extends MainFilter> immutableList) {
        this.f22923c = immutableList;
        this.f22924d.clear();
        notifyDataSetChanged();
    }

    public int getGroupCount() {
        return this.f22923c.size();
    }

    public int getChildrenCount(int i) {
        return ((MainFilterModel) this.f22923c.get(i)).m10187d().m10165a().isEmpty() ? 0 : 1;
    }

    public Object getGroup(int i) {
        return this.f22923c.get(i);
    }

    public Object getChild(int i, int i2) {
        return this.f22923c;
    }

    public long getGroupId(int i) {
        return (long) ((MainFilterModel) this.f22923c.get(i)).m10188g().hashCode();
    }

    public long getChildId(int i, int i2) {
        return (long) ((MainFilterModel) this.f22923c.get(i)).m10187d().m10165a().hashCode();
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        MainFilterModel mainFilterModel = (MainFilterModel) this.f22923c.get(i);
        SearchResultPageFilterDefinition b = this.f22922b.m26464b(mainFilterModel.jo_());
        View a = b.mo1275a().mo1272a(viewGroup.getContext());
        m26547a(b, mainFilterModel.jo_(), mainFilterModel.m10187d());
        b.mo1276a(mainFilterModel, a, (FilterPersistentState) this.f22924d.get(mainFilterModel.jo_()));
        return a;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        MainFilterModel mainFilterModel = (MainFilterModel) this.f22923c.get(i);
        SearchResultPageFilterDefinition b = this.f22922b.m26464b(mainFilterModel.jo_());
        View a = b.mo1278b().mo1272a(viewGroup.getContext());
        m26547a(b, mainFilterModel.jo_(), mainFilterModel.m10187d());
        b.mo1277a(mainFilterModel, a, (FilterPersistentState) this.f22924d.get(mainFilterModel.jo_()), this.f22921a, this.f22925e);
        return a;
    }

    public boolean isChildSelectable(int i, int i2) {
        return false;
    }

    private void m26547a(SearchResultPageFilterDefinition searchResultPageFilterDefinition, String str, FilterValuesModel filterValuesModel) {
        if (!this.f22924d.containsKey(str)) {
            FilterPersistentState a = searchResultPageFilterDefinition.mo1273a(str, filterValuesModel);
            if (a != null) {
                this.f22924d.put(str, a);
            }
        }
    }
}
