package com.facebook.search.results.fragment.entities;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.logging.api.SearchResultsAnalytics;
import com.facebook.search.logging.perf.GraphSearchPerformanceLogger;
import com.facebook.search.model.FilterType;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.results.environment.SearchResultsEntitiesEnvironmentGeneratedProvider;
import com.facebook.search.results.fragment.SearchResultsBaseFragment;
import com.facebook.search.results.fragment.common.ResultDataFetcher;
import com.facebook.search.results.fragment.common.ResultsDataAndListStateController;
import com.facebook.search.results.fragment.common.ResultsDataAndListStateControllerProvider;
import com.facebook.search.results.model.SearchResultsEntitiesCollection;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntitiesRootGroupPartDefinition;
import com.facebook.search.widget.resultspage.SearchResultsPageView;
import javax.inject.Inject;

/* compiled from: SHOW_FAB */
public class SearchResultsEntitiesFragment extends SearchResultsBaseFragment {
    @Inject
    MultiRowAdapterBuilder al;
    @Inject
    public SearchResultsEntitiesCollection am;
    @Inject
    Lazy<SearchResultsEntitiesRootGroupPartDefinition> an;
    @Inject
    public GraphSearchPerformanceLogger ao;
    private Context ap;
    public ResultsDataAndListStateController aq;
    public MultiRowAdapter ar;
    public boolean as = false;
    @Inject
    ResultsDataAndListStateControllerProvider f23001h;
    @Inject
    SearchResultsEntitiesEnvironmentGeneratedProvider f23002i;

    /* compiled from: SHOW_FAB */
    class C24551 implements Runnable {
        final /* synthetic */ SearchResultsEntitiesFragment f23000a;

        C24551(SearchResultsEntitiesFragment searchResultsEntitiesFragment) {
            this.f23000a = searchResultsEntitiesFragment;
        }

        public void run() {
            this.f23000a.ar.notifyDataSetChanged();
        }
    }

    public static void m26633a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SearchResultsEntitiesFragment) obj).m26632a((ResultsDataAndListStateControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ResultsDataAndListStateControllerProvider.class), (SearchResultsEntitiesEnvironmentGeneratedProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsEntitiesEnvironmentGeneratedProvider.class), MultiRowAdapterBuilder.b(injectorLike), new SearchResultsEntitiesCollection(), IdBasedLazy.a(injectorLike, 10686), GraphSearchPerformanceLogger.m25549a(injectorLike));
    }

    protected final Class<?> mo1294e() {
        return SearchResultsEntitiesFragment.class;
    }

    public final void mo1290c(Bundle bundle) {
        super.mo1290c(bundle);
        Class cls = SearchResultsEntitiesFragment.class;
        m26633a(this, getContext());
        this.ap = az();
        Builder a = this.al.a(this.an, this.am);
        a.f = this.f23002i.m26063a(this.ap, new C24551(this), this.am, this.f22960h, this.am);
        this.ar = a.e();
        this.aq = this.f23001h.m26623a(this.f22960h, this.ar);
        this.aq.f22988i = this;
    }

    public final View m26635a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1222252909);
        SearchResultsPageView searchResultsPageView = new SearchResultsPageView(this.ap, FilterType.from(this.f22960h.m27101u()));
        this.aq.m26619a(searchResultsPageView);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2121615627, a);
        return searchResultsPageView;
    }

    protected final void aq() {
        this.as = false;
        this.am.f23341a.clear();
        this.aq.m26618a((GraphSearchQuerySpec) this.f22960h);
    }

    protected final boolean ar() {
        return this.as;
    }

    private void m26632a(ResultsDataAndListStateControllerProvider resultsDataAndListStateControllerProvider, SearchResultsEntitiesEnvironmentGeneratedProvider searchResultsEntitiesEnvironmentGeneratedProvider, MultiRowAdapterBuilder multiRowAdapterBuilder, SearchResultsEntitiesCollection searchResultsEntitiesCollection, Lazy<SearchResultsEntitiesRootGroupPartDefinition> lazy, GraphSearchPerformanceLogger graphSearchPerformanceLogger) {
        this.f23001h = resultsDataAndListStateControllerProvider;
        this.f23002i = searchResultsEntitiesEnvironmentGeneratedProvider;
        this.al = multiRowAdapterBuilder;
        this.am = searchResultsEntitiesCollection;
        this.an = lazy;
        this.ao = graphSearchPerformanceLogger;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.ar.a(configuration);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1126344562);
        ResultsDataAndListStateController resultsDataAndListStateController = this.aq;
        ResultDataFetcher resultDataFetcher = resultsDataAndListStateController.f22980a;
        if (resultDataFetcher.f22979e != null) {
            resultDataFetcher.f22979e.cancel(false);
            resultDataFetcher.f22979e = null;
        }
        resultsDataAndListStateController.f22984e = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1352128413, a);
    }

    public final void m26634I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1767070164);
        this.ar.jc_();
        this.ap = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 948306980, a);
    }

    public final String am_() {
        String a = SearchResultsAnalytics.a(this.f22960h.mo1215f());
        return a != null ? a : "unknown";
    }
}
