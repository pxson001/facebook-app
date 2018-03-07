package com.facebook.search.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.marketplace.tab.MarketplaceTabFragmentFactory;
import com.facebook.marketplace.tab.fragment.MarketplaceHomeFragment;
import com.facebook.search.AwarenessNullStateFragment;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchTheme;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.GraphSearchQuerySpecHelper;
import com.facebook.search.results.fragment.entities.SearchResultsEntitiesFragment;
import com.facebook.search.results.fragment.feed.SearchResultsFeedFragment;
import com.facebook.search.results.fragment.marketplace.MarketplaceSearchResultsFragment;
import com.facebook.search.results.fragment.photos.SearchResultsPandoraPhotoFragment;
import com.facebook.search.results.fragment.pps.SeeMoreResultsListFragment;
import com.facebook.search.results.fragment.tabs.SearchResultsTabsFragment;
import com.facebook.search.suggestions.SuggestionsFragment;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: TimeToCoverPhotoOnSubmit */
public class GraphSearchChildFragmentInstanceManager {
    private final FragmentManager f21872a;
    private final int f21873b;

    public GraphSearchChildFragmentInstanceManager(FragmentManager fragmentManager, int i) {
        this.f21872a = fragmentManager;
        this.f21873b = i;
    }

    public final SearchResultsEntitiesFragment m25367a() {
        return (SearchResultsEntitiesFragment) m25364a(GraphSearchFragmentType.RESULTS_TEXT, null);
    }

    public final SearchResultsPandoraPhotoFragment m25372b() {
        return (SearchResultsPandoraPhotoFragment) m25364a(GraphSearchFragmentType.RESULTS_PHOTO, null);
    }

    public final MarketplaceSearchResultsFragment m25368a(Bundle bundle) {
        return (MarketplaceSearchResultsFragment) m25364a(GraphSearchFragmentType.REACT_NATIVE, bundle);
    }

    public final SearchResultsTabsFragment m25369a(GraphSearchQuerySpec graphSearchQuerySpec, @Nullable Bundle bundle, boolean z) {
        if (z) {
            GraphSearchChildFragment a = m25363a(GraphSearchFragmentType.RESULTS_KEYWORD_TABS);
            if (a != null) {
                this.f21872a.a().a(a.mo1192b()).b();
                this.f21872a.b();
            }
        }
        if (GraphSearchQuerySpecHelper.m25628a(graphSearchQuerySpec)) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSerializable("search_theme", SearchTheme.DARK);
        }
        return (SearchResultsTabsFragment) m25364a(GraphSearchFragmentType.RESULTS_KEYWORD_TABS, bundle);
    }

    public final SearchResultsFeedFragment m25371b(Bundle bundle) {
        return (SearchResultsFeedFragment) m25364a(GraphSearchFragmentType.RESULTS_KEYWORD, bundle);
    }

    public final SeeMoreResultsListFragment m25373c() {
        return (SeeMoreResultsListFragment) m25364a(GraphSearchFragmentType.RESULTS_SEE_MORE, null);
    }

    public final SuggestionsFragment m25370a(GraphSearchQuery graphSearchQuery) {
        Bundle bundle = null;
        if (graphSearchQuery != null) {
            bundle = new Bundle();
            bundle.putParcelable("initial_typeahead_query", graphSearchQuery);
        }
        return (SuggestionsFragment) m25364a(GraphSearchFragmentType.SUGGESTIONS, bundle);
    }

    public final AwarenessNullStateFragment m25374d() {
        return (AwarenessNullStateFragment) m25364a(GraphSearchFragmentType.AWARENESS_NULL_STATE, null);
    }

    public final SearchTypeaheadSession m25375e() {
        SuggestionsFragment suggestionsFragment = (SuggestionsFragment) m25363a(GraphSearchFragmentType.SUGGESTIONS);
        return suggestionsFragment != null ? suggestionsFragment.as() : SearchTypeaheadSession.a;
    }

    private <T extends GraphSearchChildFragment> T m25364a(GraphSearchFragmentType graphSearchFragmentType, Bundle bundle) {
        T a = m25363a(graphSearchFragmentType);
        if (a == null) {
            return m25365b(graphSearchFragmentType, bundle);
        }
        return a;
    }

    private GraphSearchChildFragment m25363a(GraphSearchFragmentType graphSearchFragmentType) {
        return (GraphSearchChildFragment) this.f21872a.a(graphSearchFragmentType.getTag());
    }

    private GraphSearchChildFragment m25365b(GraphSearchFragmentType graphSearchFragmentType, Bundle bundle) {
        GraphSearchChildFragment c = m25366c(graphSearchFragmentType, bundle);
        c.mo1192b().g(bundle);
        this.f21872a.a().a(this.f21873b, c.mo1192b(), graphSearchFragmentType.getTag()).b(c.mo1192b()).c();
        this.f21872a.b();
        return c;
    }

    private GraphSearchChildFragment m25366c(GraphSearchFragmentType graphSearchFragmentType, Bundle bundle) {
        switch (graphSearchFragmentType) {
            case RESULTS_TEXT:
                return new SearchResultsEntitiesFragment();
            case RESULTS_PHOTO:
                return new SearchResultsPandoraPhotoFragment();
            case RESULTS_KEYWORD_TABS:
                return new SearchResultsTabsFragment();
            case RESULTS_KEYWORD:
                return SearchResultsFeedFragment.m26674c("graph_search_results_page_blended");
            case SUGGESTIONS:
                return new SuggestionsFragment();
            case RESULTS_SEE_MORE:
                return new SeeMoreResultsListFragment();
            case AWARENESS_NULL_STATE:
                return new AwarenessNullStateFragment();
            case REACT_NATIVE:
                FragmentManager fragmentManager = this.f21872a;
                MarketplaceSearchResultsFragment marketplaceSearchResultsFragment = new MarketplaceSearchResultsFragment();
                Preconditions.checkArgument(marketplaceSearchResultsFragment.al == null);
                marketplaceSearchResultsFragment.ao = fragmentManager;
                Intent intent = new Intent();
                intent.putExtra("ReactRouteName", bundle.getString("marketplace_search_module"));
                intent.putExtra("ReactURI", bundle.getString("marketplace_search_uri"));
                marketplaceSearchResultsFragment.ap = bundle.getInt("marketplace_search_typeahead_react_tag");
                bundle.remove("marketplace_search_module");
                bundle.remove("marketplace_search_uri");
                bundle.remove("marketplace_search_typeahead_react_tag");
                marketplaceSearchResultsFragment.al = (MarketplaceHomeFragment) new MarketplaceTabFragmentFactory().m17721a(intent);
                FragmentTransaction a = fragmentManager.a();
                a.a(marketplaceSearchResultsFragment.al, null);
                a.b();
                fragmentManager.b();
                return marketplaceSearchResultsFragment;
            default:
                throw new RuntimeException("Unknown graph search fragment type: " + graphSearchFragmentType);
        }
    }
}
