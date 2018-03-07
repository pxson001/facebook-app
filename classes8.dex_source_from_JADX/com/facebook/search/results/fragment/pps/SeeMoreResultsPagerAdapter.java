package com.facebook.search.results.fragment.pps;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.search.logging.SeeMoreAnalyticHelper;
import com.facebook.search.model.FilterType;
import com.facebook.search.model.NeedleFilter;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.results.filters.ui.PopoverFilterWindow.OnFilterSelectedListener;
import com.facebook.search.results.filters.ui.SearchResultsPageFilter;
import com.facebook.search.results.fragment.pps.SeeMoreResultsListFragment.C24771;
import com.facebook.search.results.util.SearchResultsThemeHelper;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.widget.resultspage.SearchResultsPage$NearEndOfResultsListener;
import com.facebook.search.widget.resultspage.SearchResultsPage.State;
import com.facebook.search.widget.resultspage.SearchResultsPageView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnItemClickListener;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: SEE_PAGE_LIKES_TAP */
public class SeeMoreResultsPagerAdapter extends PagerAdapter {
    @Inject
    public GatekeeperStoreImpl f23106a;
    public final Context f23107b;
    private final Provider<SeeMoreResultsListAdapter> f23108c;
    public final SimpleAndGraphSearchFetchHelper f23109d;
    public final Map<FilterType, SeeMoreResultsListAdapter> f23110e = new HashMap();
    public final Map<FilterType, SearchResultsPageView> f23111f = new HashMap();
    public final Map<FilterType, SearchResultsPageFilter> f23112g = new HashMap();
    public final Map<FilterType, SearchResultsPageFilter> f23113h = new HashMap();
    private final FragmentManager f23114i;
    private SeeMoreAnalyticHelper f23115j;
    private SearchResultsThemeHelper f23116k;
    private C24771 f23117l;
    public ViewPager f23118m;
    private GraphSearchTitleSearchBoxSupplier f23119n;

    @Inject
    public SeeMoreResultsPagerAdapter(Context context, Provider<SeeMoreResultsListAdapter> provider, SimpleAndGraphSearchFetchHelperProvider simpleAndGraphSearchFetchHelperProvider, @Assisted FragmentManager fragmentManager, @Assisted ViewPager viewPager, @Assisted Listener listener, @Assisted SeeMoreAnalyticHelper seeMoreAnalyticHelper, GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, SearchResultsThemeHelper searchResultsThemeHelper) {
        this.f23107b = context;
        this.f23108c = provider;
        this.f23109d = simpleAndGraphSearchFetchHelperProvider.m26795a(this);
        this.f23114i = fragmentManager;
        this.f23118m = viewPager;
        this.f23117l = listener;
        this.f23109d.f23132k = seeMoreAnalyticHelper;
        this.f23115j = seeMoreAnalyticHelper;
        this.f23119n = graphSearchTitleSearchBoxSupplier;
        this.f23116k = searchResultsThemeHelper;
    }

    public final int m26778b() {
        return FilterType.getCoreFilterTypeLength();
    }

    public final boolean m26777a(View view, Object obj) {
        return view == obj;
    }

    public final Object m26773a(ViewGroup viewGroup, int i) {
        FilterType coreFilterTypeAt = FilterType.getCoreFilterTypeAt(i);
        m26768a(this, coreFilterTypeAt, m26771e(coreFilterTypeAt));
        viewGroup.addView((View) this.f23111f.get(coreFilterTypeAt));
        m26770b(coreFilterTypeAt);
        return this.f23111f.get(coreFilterTypeAt);
    }

    public static void m26768a(SeeMoreResultsPagerAdapter seeMoreResultsPagerAdapter, final FilterType filterType, SeeMoreResultsListAdapter seeMoreResultsListAdapter) {
        ImmutableList c = seeMoreResultsPagerAdapter.f23109d.m26793c(filterType);
        SearchResultsPageView searchResultsPageView = (SearchResultsPageView) seeMoreResultsPagerAdapter.f23111f.get(filterType);
        if (searchResultsPageView == null) {
            SearchResultsPageView searchResultsPageView2 = new SearchResultsPageView(SearchResultsThemeHelper.m28569a(seeMoreResultsPagerAdapter.f23107b, null), filterType);
            if (filterType == FilterType.People) {
                LayoutInflater from = LayoutInflater.from(searchResultsPageView2.getContext());
                SearchResultsPageFilter searchResultsPageFilter = (SearchResultsPageFilter) from.inflate(2130907012, null);
                SearchResultsPageFilter searchResultsPageFilter2 = (SearchResultsPageFilter) from.inflate(2130907012, null);
                searchResultsPageFilter.setOnFilterSelectedListener(new OnFilterSelectedListener(seeMoreResultsPagerAdapter) {
                    final /* synthetic */ SeeMoreResultsPagerAdapter f23102b;

                    public final void mo1302a(NeedleFilter needleFilter) {
                        this.f23102b.f23109d.m26794d(filterType);
                        SeeMoreResultsPagerAdapter.m26768a(this.f23102b, filterType, (SeeMoreResultsListAdapter) this.f23102b.f23110e.get(filterType));
                        this.f23102b.f23109d.m26790a(SeeMoreResultsPagerAdapter.m26772i(this.f23102b), filterType, needleFilter);
                    }
                });
                searchResultsPageFilter2.setOnFilterSelectedListener(new OnFilterSelectedListener(seeMoreResultsPagerAdapter) {
                    final /* synthetic */ SeeMoreResultsPagerAdapter f23104b;

                    public final void mo1302a(NeedleFilter needleFilter) {
                        this.f23104b.f23109d.m26794d(filterType);
                        SeeMoreResultsPagerAdapter.m26768a(this.f23104b, filterType, (SeeMoreResultsListAdapter) this.f23104b.f23110e.get(filterType));
                        this.f23104b.f23109d.m26790a(SeeMoreResultsPagerAdapter.m26772i(this.f23104b), filterType, needleFilter);
                    }
                });
                searchResultsPageView2.a(searchResultsPageFilter);
                searchResultsPageView2.b(searchResultsPageFilter2);
                seeMoreResultsPagerAdapter.f23112g.put(filterType, searchResultsPageFilter);
                seeMoreResultsPagerAdapter.f23113h.put(filterType, searchResultsPageFilter2);
            }
            seeMoreResultsPagerAdapter.f23111f.put(filterType, searchResultsPageView2);
            searchResultsPageView = searchResultsPageView2;
        }
        SearchResultsPageView searchResultsPageView3 = searchResultsPageView;
        seeMoreResultsListAdapter.m26752a(c);
        ScrollingViewProxy scrollingViewProxy = searchResultsPageView3.k;
        if (c == null) {
            searchResultsPageView3.setState(State.LOADING);
        } else if (c.isEmpty()) {
            searchResultsPageView3.setState(State.EMPTY);
        }
        scrollingViewProxy.a(seeMoreResultsListAdapter);
        scrollingViewProxy.a(new OnItemClickListener(seeMoreResultsPagerAdapter) {
            final /* synthetic */ SeeMoreResultsPagerAdapter f23098b;

            public final void m26764a(int i) {
                ImmutableList c = this.f23098b.f23109d.m26793c(filterType);
                if (this.f23098b.f23112g.get(filterType) != null) {
                    if (c != null && i - 1 < c.size() && i - 1 >= 0) {
                        SeeMoreResultsPagerAdapter.m26769a(this.f23098b, (SeeMoreResultPageUnit) c.get(i - 1), filterType);
                    }
                } else if (c != null && i < c.size()) {
                    SeeMoreResultsPagerAdapter.m26769a(this.f23098b, (SeeMoreResultPageUnit) c.get(i), filterType);
                }
            }
        });
        AdapterDetour.a(seeMoreResultsListAdapter, -611353607);
    }

    public static void m26769a(SeeMoreResultsPagerAdapter seeMoreResultsPagerAdapter, SeeMoreResultPageUnit seeMoreResultPageUnit, FilterType filterType) {
        if (seeMoreResultsPagerAdapter.f23117l != null) {
            C24771 c24771 = seeMoreResultsPagerAdapter.f23117l;
            c24771.f23086a.f23090c.m25524a(seeMoreResultsPagerAdapter.m26771e(filterType).f23085e, seeMoreResultPageUnit, filterType, SeeMoreResultsListFragment.m26755e(c24771.f23086a));
            c24771.f23086a.f23091d.a(null, seeMoreResultPageUnit, SeeMoreResultsListFragment.m26755e(c24771.f23086a));
            c24771.f23086a.f23092e.a(seeMoreResultPageUnit);
            if (c24771.f23086a.f23093f != null) {
                c24771.f23086a.f23093f.mo1199a(seeMoreResultPageUnit);
            }
        }
    }

    private void m26770b(FilterType filterType) {
        if (this.f23109d.m26793c(filterType) == null) {
            SearchResultsPageView searchResultsPageView = (SearchResultsPageView) this.f23111f.get(filterType);
            if (searchResultsPageView != null) {
                searchResultsPageView.setState(State.LOADING);
            }
            this.f23109d.m26789a(m26772i(this), filterType);
        }
    }

    public final void m26775a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((SearchResultsPageView) obj);
    }

    public final ImmutableList<SeeMoreResultPageUnit> m26779f() {
        return m26771e(FilterType.getCoreFilterTypeAt(this.f23118m.k)).f23085e;
    }

    public final void m26776a(final FilterType filterType, ImmutableList<SeeMoreResultPageUnit> immutableList, ImmutableList<NeedleFilter> immutableList2, int i, int i2) {
        SeeMoreResultsListAdapter seeMoreResultsListAdapter = (SeeMoreResultsListAdapter) this.f23110e.get(filterType);
        if (seeMoreResultsListAdapter != null) {
            seeMoreResultsListAdapter.m26752a(immutableList);
            SearchResultsPageView searchResultsPageView = (SearchResultsPageView) this.f23111f.get(filterType);
            if (searchResultsPageView != null) {
                SearchResultsPageFilter searchResultsPageFilter = (SearchResultsPageFilter) this.f23112g.get(filterType);
                if (searchResultsPageFilter != null && i2 > 0 && i == 0) {
                    searchResultsPageFilter.setFilters(immutableList2);
                }
                searchResultsPageFilter = (SearchResultsPageFilter) this.f23113h.get(filterType);
                if (searchResultsPageFilter != null && i2 == 0) {
                    UnmodifiableIterator it = immutableList2.iterator();
                    int i3 = 0;
                    while (it.hasNext() && i3 == 0) {
                        i3 = ((NeedleFilter) it.next()).f22174d != null ? 1 : 0;
                    }
                    if (i3 == 0) {
                        immutableList2 = null;
                    }
                    searchResultsPageFilter.setFilters(immutableList2);
                }
                if (i == 0 && this.f23118m.k == FilterType.getPositionOfCoreFilterType(filterType)) {
                    this.f23115j.m25526a(Boolean.valueOf(immutableList.isEmpty()), FilterType.getCoreFilterTypeAt(this.f23118m.k), m26772i(this));
                }
                if (immutableList.isEmpty()) {
                    searchResultsPageView.setState(State.EMPTY);
                } else if (this.f23109d.m26792b(filterType)) {
                    searchResultsPageView.setState(State.LOADING_MORE);
                    ScrollingViewProxy scrollingViewProxy = searchResultsPageView.k;
                    if (i == 0) {
                        scrollingViewProxy.e(0);
                        searchResultsPageView.a(new SearchResultsPage$NearEndOfResultsListener(this) {
                            final /* synthetic */ SeeMoreResultsPagerAdapter f23100b;

                            public final void mo1293a() {
                                if (this.f23100b.f23109d.m26792b(filterType)) {
                                    SimpleAndGraphSearchFetchHelper simpleAndGraphSearchFetchHelper = this.f23100b.f23109d;
                                    if (!simpleAndGraphSearchFetchHelper.f23129h.contains(filterType)) {
                                        SeeMoreResultsPagerAdapter seeMoreResultsPagerAdapter = this.f23100b;
                                        seeMoreResultsPagerAdapter.f23109d.m26789a(SeeMoreResultsPagerAdapter.m26772i(seeMoreResultsPagerAdapter), filterType);
                                    }
                                }
                            }
                        }, 0);
                    }
                } else {
                    searchResultsPageView.setState(State.LOADING_FINISHED);
                }
            }
        }
    }

    private SeeMoreResultsListAdapter m26771e(FilterType filterType) {
        if (this.f23110e.containsKey(filterType)) {
            return (SeeMoreResultsListAdapter) this.f23110e.get(filterType);
        }
        SeeMoreResultsListAdapter seeMoreResultsListAdapter = (SeeMoreResultsListAdapter) this.f23108c.get();
        this.f23110e.put(filterType, seeMoreResultsListAdapter);
        return seeMoreResultsListAdapter;
    }

    public final CharSequence J_(int i) {
        int i2;
        FilterType coreFilterTypeAt = FilterType.getCoreFilterTypeAt(i);
        switch (coreFilterTypeAt) {
            case People:
                i2 = 2131237477;
                break;
            case Page:
                i2 = 2131237476;
                break;
            case Group:
                i2 = 2131237475;
                break;
            case Event:
                i2 = 2131237474;
                break;
            case App:
                i2 = 2131237473;
                break;
            case Search:
                i2 = 2131237481;
                break;
            default:
                throw new IllegalArgumentException("Unimplemented PPS tab of type " + coreFilterTypeAt);
        }
        return this.f23107b.getString(i2);
    }

    public final void m26774a(int i) {
        m26770b(FilterType.getCoreFilterTypeAt(i));
    }

    public static String m26772i(SeeMoreResultsPagerAdapter seeMoreResultsPagerAdapter) {
        return seeMoreResultsPagerAdapter.f23119n.f25334a.e.getText().toString();
    }
}
