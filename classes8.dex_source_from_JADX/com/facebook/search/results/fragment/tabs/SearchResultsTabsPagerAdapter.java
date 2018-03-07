package com.facebook.search.results.fragment.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.inject.Assisted;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.fragment.GraphSearchChildFragment;
import com.facebook.search.fragment.GraphSearchChildFragment.OnResultClickListener;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.GraphSearchQuerySpecHelper;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.results.environment.tabs.CanSwitchResultPageTabImpl.OnSwitchTabListener;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.facebook.search.results.fragment.SearchResultsBaseFragment;
import com.facebook.search.results.fragment.feed.SearchResultsFeedFragment;
import com.facebook.search.results.fragment.spec.AbstractFragmentSpec;
import com.facebook.search.results.fragment.spec.GraphSearchResultFragmentSpecificationRegistry;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.SearchResultsNewsTitle;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: SECONDARY_ACTION */
public class SearchResultsTabsPagerAdapter extends FragmentPagerAdapter {
    private final KeywordTypeaheadUnit f23187a;
    public final SearchTypeaheadSession f23188b;
    private final SearchResultsSource f23189c;
    private final GraphSearchResultFragmentSpecificationRegistry f23190d;
    private final OnResultClickListener f23191e;
    private final SearchResultsTabsFragment f23192f;
    private final ImmutableList<SearchResultsTab> f23193g;
    private final RTLUtil f23194h;

    @Inject
    public SearchResultsTabsPagerAdapter(@Assisted FragmentManager fragmentManager, @Assisted KeywordTypeaheadUnit keywordTypeaheadUnit, @Assisted SearchTypeaheadSession searchTypeaheadSession, @Assisted SearchResultsSource searchResultsSource, @Assisted OnResultClickListener onResultClickListener, @Assisted OnSwitchTabListener onSwitchTabListener, @Assisted ImmutableList<SearchResultsTab> immutableList, GraphSearchResultFragmentSpecificationRegistry graphSearchResultFragmentSpecificationRegistry, RTLUtil rTLUtil) {
        super(fragmentManager);
        this.f23187a = keywordTypeaheadUnit;
        this.f23188b = searchTypeaheadSession;
        this.f23189c = searchResultsSource;
        this.f23190d = graphSearchResultFragmentSpecificationRegistry;
        this.f23191e = onResultClickListener;
        this.f23192f = onSwitchTabListener;
        this.f23193g = immutableList;
        this.f23194h = rTLUtil;
    }

    public final Fragment m26895a(int i) {
        GraphSearchChildFragment c = this.f23190d.m26830a((SearchResultsTab) this.f23193g.get(m26894h(i))).mo1308c();
        Bundle bundle = new Bundle();
        if (GraphSearchQuerySpecHelper.m25628a(this.f23187a)) {
            bundle.putSerializable("graph_search_scoped_entity_type", ScopedEntityType.VIDEO);
        }
        bundle.putBoolean("tab_bar_tap", true);
        c.mo1192b().g(bundle);
        c.mo1190a(this.f23191e);
        if (c instanceof SearchResultsFeedFragment) {
            ((SearchResultsFeedFragment) c).bG = this.f23192f;
        }
        return c.mo1192b();
    }

    public final void m26898e(int i) {
        Fragment a = a(i);
        if (a instanceof SearchResultsBaseFragment) {
            SearchResultsBaseFragment searchResultsBaseFragment = (SearchResultsBaseFragment) a;
            SearchResultsSource searchResultsSource = SearchResultsSource.j;
            searchResultsBaseFragment.mo1294e();
            SearchResultsMutableContext searchResultsMutableContext = searchResultsBaseFragment.f22960h;
            if (searchResultsSource != null) {
                searchResultsMutableContext.f23367b = searchResultsSource;
            }
        }
    }

    public final Object m26896a(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.a(viewGroup, i);
        if (!(this.f23187a.mo1211a() == null || this.f23187a.f22120i == null || !(fragment instanceof SearchResultsFeedFragment))) {
            ((SearchResultsFeedFragment) fragment).bm = new SearchResultsNewsTitle(this.f23187a.mo1211a(), this.f23187a.f22120i);
            ((SearchResultsFeedFragment) fragment).bn = this.f23187a.f22130s;
        }
        m26893g(i).m26817a(fragment, m26892f(i), this.f23188b, this.f23189c);
        return fragment;
    }

    public final int m26897b() {
        return this.f23193g.size();
    }

    public final CharSequence J_(int i) {
        return m26893g(m26894h(i)).f23145b;
    }

    private GraphSearchQuerySpec m26892f(int i) {
        return m26893g(m26894h(i)).mo1309a(this.f23187a.mo1211a(), this.f23187a.mo1212b(), this.f23187a.mo1213c(), this.f23187a.jH_(), this.f23187a.mo1221m(), this.f23187a.mo1214e());
    }

    private AbstractFragmentSpec m26893g(int i) {
        return this.f23190d.m26830a((SearchResultsTab) this.f23193g.get(i));
    }

    private int m26894h(int i) {
        return this.f23194h.a() ? (b() - i) - 1 : i;
    }
}
