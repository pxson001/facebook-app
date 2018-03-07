package com.facebook.search.results.filters.controller;

import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters;
import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.results.filters.definition.FilterPersistentState;
import com.facebook.search.results.filters.definition.SearchResultPageFilterDefinitionRegistry;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsInterfaces.SearchResultPageMainFilterFragment.MainFilter;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageMainFilterFragmentModel.MainFilterModel;
import com.facebook.search.widget.resultspage.SearchResultsPageView;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: SOCIAL_EMBED_WITHOUT_CAPTION */
public class SearchResultPageFilterController {
    private static final String f22785a = SearchResultPageFilterController.class.getSimpleName();
    private final GraphSearchErrorReporter f22786b;
    private final GlyphColorizer f22787c;
    public final SearchResultPageFilterDefinitionRegistry f22788d;
    private final SearchFilterPillRecyclerViewAdapter f22789e;
    public SearchResultsPageView f22790f;
    public HScrollRecyclerView f22791g;
    private ImmutableList<? extends MainFilter> f22792h;
    private ImmutableList<FilterPersistentState> f22793i;
    public OnFilterClearButtonClickListener f22794j;
    private boolean f22795k = false;

    /* compiled from: SOCIAL_EMBED_WITHOUT_CAPTION */
    public interface OnFilterClearButtonClickListener {
        void mo1284a(Filters filters);
    }

    public static SearchResultPageFilterController m26426b(InjectorLike injectorLike) {
        return new SearchResultPageFilterController(GraphSearchErrorReporter.a(injectorLike), GlyphColorizer.a(injectorLike), SearchResultPageFilterDefinitionRegistry.m26462b(injectorLike), new SearchFilterPillRecyclerViewAdapter());
    }

    @Inject
    public SearchResultPageFilterController(GraphSearchErrorReporter graphSearchErrorReporter, GlyphColorizer glyphColorizer, SearchResultPageFilterDefinitionRegistry searchResultPageFilterDefinitionRegistry, SearchFilterPillRecyclerViewAdapter searchFilterPillRecyclerViewAdapter) {
        this.f22786b = graphSearchErrorReporter;
        this.f22787c = glyphColorizer;
        this.f22788d = searchResultPageFilterDefinitionRegistry;
        this.f22789e = searchFilterPillRecyclerViewAdapter;
    }

    public final void m26431a(SearchResultsPageView searchResultsPageView) {
        this.f22790f = searchResultsPageView;
    }

    public final void m26432a(HScrollRecyclerView hScrollRecyclerView) {
        this.f22791g = hScrollRecyclerView;
    }

    public final void m26429a() {
        this.f22790f = null;
    }

    public final void m26434b() {
        this.f22791g = null;
    }

    public final void m26436c() {
        if (this.f22790f != null) {
            if (this.f22792h != null) {
                this.f22790f.a();
            }
            if (this.f22793i != null) {
                m26427f();
            }
        }
    }

    public final void m26433a(ImmutableList<? extends MainFilter> immutableList) {
        if (this.f22790f == null) {
            this.f22786b.a(GraphSearchError.FILTER_CONTROLLER, "PageView not attached to controller");
            return;
        }
        this.f22792h = immutableList;
        if (!this.f22795k) {
            this.f22795k = true;
            this.f22790f.a();
        }
    }

    public final ImmutableList<? extends MainFilter> m26437d() {
        ImmutableList immutableList = this.f22792h;
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MainFilterModel mainFilterModel = (MainFilterModel) immutableList.get(i);
            if (this.f22788d.m26463a(mainFilterModel.jo_())) {
                builder.c(mainFilterModel);
            }
        }
        return builder.b();
    }

    public final ImmutableList<Filters> m26438e() {
        if (this.f22793i == null) {
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        int size = this.f22793i.size();
        for (int i = 0; i < size; i++) {
            builder.c(((FilterPersistentState) this.f22793i.get(i)).f22798c);
        }
        return builder.b();
    }

    public final void m26435b(ImmutableList<FilterPersistentState> immutableList) {
        this.f22793i = immutableList;
        m26427f();
    }

    public final ImmutableList<Filters> m26428a(Filters filters) {
        Builder builder = new Builder();
        Builder builder2 = new Builder();
        int size = this.f22793i.size();
        for (int i = 0; i < size; i++) {
            FilterPersistentState filterPersistentState = (FilterPersistentState) this.f22793i.get(i);
            if (!filterPersistentState.f22798c.equals(filters)) {
                builder2.c(filterPersistentState);
                builder.c(filterPersistentState.f22798c);
            }
        }
        m26435b(builder2.b());
        return builder.b();
    }

    public final void m26430a(OnFilterClearButtonClickListener onFilterClearButtonClickListener) {
        this.f22794j = onFilterClearButtonClickListener;
    }

    private void m26427f() {
        this.f22791g.removeAllViews();
        if (this.f22793i == null || this.f22793i.isEmpty()) {
            this.f22791g.setVisibility(8);
            return;
        }
        Builder builder = new Builder();
        int size = this.f22793i.size();
        for (int i = 0; i < size; i++) {
            FilterPersistentState filterPersistentState = (FilterPersistentState) this.f22793i.get(i);
            builder.c(this.f22788d.m26464b((String) filterPersistentState.f22798c.b().get("name")).mo1274a(filterPersistentState));
        }
        SearchFilterPillRecyclerViewAdapter searchFilterPillRecyclerViewAdapter = this.f22789e;
        ImmutableList b = builder.b();
        OnFilterClearButtonClickListener onFilterClearButtonClickListener = this.f22794j;
        searchFilterPillRecyclerViewAdapter.f22783a = b;
        searchFilterPillRecyclerViewAdapter.f22784b = onFilterClearButtonClickListener;
        searchFilterPillRecyclerViewAdapter.notifyDataSetChanged();
        this.f22791g.setAdapter(this.f22789e);
        this.f22791g.setVisibility(0);
    }
}
