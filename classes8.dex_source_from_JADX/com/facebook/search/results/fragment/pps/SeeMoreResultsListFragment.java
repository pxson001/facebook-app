package com.facebook.search.results.fragment.pps;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.fragment.GraphSearchChildFragment;
import com.facebook.search.fragment.GraphSearchChildFragment.OnResultClickListener;
import com.facebook.search.logging.SeeMoreAnalyticHelper;
import com.facebook.search.model.FilterType;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.suggestions.log.LogSelectedSuggestionToActivityLogHelper;
import com.facebook.search.suggestions.nullstate.RecentSearchesNullStateSupplier;
import com.facebook.search.widget.resultspage.SearchResultsPage.State;
import com.facebook.search.widget.resultspage.SearchResultsPageView;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: SELECT_PRIVACY */
public class SeeMoreResultsListFragment extends FbFragment implements AnalyticsFragmentWithExtraData, GraphSearchChildFragment {
    public SeeMoreResultsPagerAdapter f23088a;
    public String al;
    public int am;
    public GraphSearchTitleSearchBoxSupplier f23089b;
    public SeeMoreAnalyticHelper f23090c;
    public LogSelectedSuggestionToActivityLogHelper f23091d;
    public RecentSearchesNullStateSupplier f23092e;
    public OnResultClickListener f23093f;
    public TabbedViewPagerIndicator f23094g;
    private SeeMoreResultsPagerAdapterProvider f23095h;
    public ViewPager f23096i;

    /* compiled from: SELECT_PRIVACY */
    public class C24771 {
        public final /* synthetic */ SeeMoreResultsListFragment f23086a;

        C24771(SeeMoreResultsListFragment seeMoreResultsListFragment) {
            this.f23086a = seeMoreResultsListFragment;
        }
    }

    /* compiled from: SELECT_PRIVACY */
    class C24782 extends SimpleOnPageChangeListener {
        final /* synthetic */ SeeMoreResultsListFragment f23087a;

        C24782(SeeMoreResultsListFragment seeMoreResultsListFragment) {
            this.f23087a = seeMoreResultsListFragment;
        }

        public final void e_(int i) {
            State state;
            SeeMoreResultsListFragment seeMoreResultsListFragment = this.f23087a;
            FilterType coreFilterTypeAt = FilterType.getCoreFilterTypeAt(i);
            SearchResultsPageView searchResultsPageView = (SearchResultsPageView) seeMoreResultsListFragment.f23088a.f23111f.get(coreFilterTypeAt);
            if (searchResultsPageView == null) {
                state = null;
            } else {
                state = searchResultsPageView.r;
            }
            State state2 = state;
            if (!(state2 == null || state2 == State.LOADING)) {
                seeMoreResultsListFragment.f23090c.m25526a(Boolean.valueOf(seeMoreResultsListFragment.f23088a.m26779f().isEmpty()), coreFilterTypeAt, SeeMoreResultsListFragment.m26755e(seeMoreResultsListFragment));
            }
            this.f23087a.f23088a.m26774a(i);
            this.f23087a.am = i;
        }
    }

    public static void m26754a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SeeMoreResultsListFragment) obj).m26753a((SeeMoreResultsPagerAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SeeMoreResultsPagerAdapterProvider.class), GraphSearchTitleSearchBoxSupplier.m28576a(fbInjector), new SeeMoreAnalyticHelper(AnalyticsLoggerMethodAutoProvider.a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), GraphSearchErrorReporter.a(fbInjector)), LogSelectedSuggestionToActivityLogHelper.b(fbInjector), RecentSearchesNullStateSupplier.a(fbInjector));
    }

    public final void m26761c(Bundle bundle) {
        super.c(bundle);
        Class cls = SeeMoreResultsListFragment.class;
        m26754a(this, getContext());
    }

    @Inject
    private void m26753a(SeeMoreResultsPagerAdapterProvider seeMoreResultsPagerAdapterProvider, GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, SeeMoreAnalyticHelper seeMoreAnalyticHelper, LogSelectedSuggestionToActivityLogHelper logSelectedSuggestionToActivityLogHelper, RecentSearchesNullStateSupplier recentSearchesNullStateSupplier) {
        this.f23089b = graphSearchTitleSearchBoxSupplier;
        this.f23090c = seeMoreAnalyticHelper;
        this.f23091d = logSelectedSuggestionToActivityLogHelper;
        this.f23092e = recentSearchesNullStateSupplier;
        this.f23095h = seeMoreResultsPagerAdapterProvider;
    }

    public final View m26756a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2038778374);
        View inflate = layoutInflater.inflate(2130904452, viewGroup, false);
        this.f23094g = (TabbedViewPagerIndicator) FindViewUtil.b(inflate, 2131562216);
        this.f23096i = (ViewPager) FindViewUtil.b(inflate, 2131562217);
        this.f23088a = this.f23095h.m26780a(s(), this.f23096i, new C24771(this), this.f23090c);
        this.f23094g.l = new C24782(this);
        this.f23096i.setAdapter(this.f23088a);
        this.f23094g.setViewPager(this.f23096i);
        if (bundle != null) {
            this.al = bundle.getString("typeahead_text");
            this.am = bundle.getInt("tab_position");
            this.f23090c.m25520a(bundle);
        }
        if (this.al != null) {
            this.f23089b.f25334a.e.setText(this.al);
            this.f23096i.setCurrentItem(this.am);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2085761611, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 583132796);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1204879410, a);
    }

    public final Fragment mo1192b() {
        return this;
    }

    public final boolean mo1191a(boolean z) {
        this.f23090c.m25525a(this.f23088a.m26779f(), m26755e(this));
        return false;
    }

    public final void m26762c(boolean z) {
        super.c(z);
        if (z && this.f23088a != null) {
            this.f23088a.f23109d.m26791b();
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 55038803);
        super.mY_();
        SeeMoreResultsPagerAdapter seeMoreResultsPagerAdapter = this.f23088a;
        seeMoreResultsPagerAdapter.f23112g.clear();
        seeMoreResultsPagerAdapter.f23113h.clear();
        seeMoreResultsPagerAdapter.f23111f.clear();
        seeMoreResultsPagerAdapter.f23110e.clear();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 619454630, a);
    }

    public final void m26763e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("typeahead_text", this.al);
        bundle.putInt("tab_position", this.am);
        SeeMoreAnalyticHelper seeMoreAnalyticHelper = this.f23090c;
        bundle.putString("typeahead_session_id", seeMoreAnalyticHelper.f21981e.b);
        bundle.putString("candidate_results_id", seeMoreAnalyticHelper.f21981e.c);
        bundle.putString("see_more_session_id", seeMoreAnalyticHelper.f21982f);
        bundle.putLong("see_more_session_start_time_ms", seeMoreAnalyticHelper.f21983g);
        bundle.putInt("see_more_results_clicked", seeMoreAnalyticHelper.f21984h);
    }

    public final void mo1190a(OnResultClickListener onResultClickListener) {
        this.f23093f = onResultClickListener;
    }

    public static String m26755e(SeeMoreResultsListFragment seeMoreResultsListFragment) {
        return seeMoreResultsListFragment.f23089b.f25334a.e.getText().toString();
    }

    public final Map<String, Object> m26760c() {
        return new Builder().b("search_sid", this.f23090c.f21982f).b();
    }

    public final String am_() {
        return "pps";
    }
}
