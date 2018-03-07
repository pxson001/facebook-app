package com.facebook.search.results.fragment.tabs;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.api.SearchTheme;
import com.facebook.search.fragment.GraphSearchChildFragment.OnResultClickListener;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.SearchResultsLogger.Event;
import com.facebook.search.logging.api.SearchResultsAnalytics.ActionSource;
import com.facebook.search.logging.api.SearchResultsAnalytics.ExitAction;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.logging.perf.NullStatePerformanceLogger;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.facebook.search.results.fragment.GraphSearchResultFragment;
import com.facebook.search.results.util.SearchResultsThemeHelper;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox$OnClearClickedListener;
import com.facebook.search.util.SearchThemeHelper;
import com.facebook.search.util.bugreporter.SearchBugReportEvent;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: SECONDS_SINCE_FOREGROUND */
public class SearchResultsTabsFragment extends FbFragment implements AnalyticsFragment, GraphSearchResultFragment, GraphSearchTitleSearchBox$OnClearClickedListener {
    public static final String al = SearchResultsTabsFragment.class.getSimpleName();
    @Inject
    SearchResultsTabsPagerAdapterProvider f23178a;
    public ImmutableList<SearchResultsTab> am;
    public ViewPager an;
    public SearchResultsTabsPagerAdapter ao;
    private OnResultClickListener ap;
    public KeywordTypeaheadUnit aq;
    public SearchTypeaheadSession ar = SearchTypeaheadSession.a;
    private SearchResultsSource as;
    public SearchResultsTab at;
    private TabbedViewPagerIndicator au;
    private GraphSearchTitleSearchBox av;
    private OnTouchListener aw;
    public boolean ax;
    public boolean ay = false;
    @Inject
    SearchResultsLogger f23179b;
    @Inject
    NullStatePerformanceLogger f23180c;
    @Inject
    @ForUiThread
    Handler f23181d;
    @Inject
    SearchBugReportExtraDataProvider f23182e;
    @Inject
    RTLUtil f23183f;
    @Inject
    SearchResultsTabConfig f23184g;
    @Inject
    SearchThemeHelper f23185h;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerPublishServiceHelper> f23186i = UltralightRuntime.b;

    /* compiled from: SECONDS_SINCE_FOREGROUND */
    class C24911 extends SimpleOnPageChangeListener {
        final /* synthetic */ SearchResultsTabsFragment f23174a;

        C24911(SearchResultsTabsFragment searchResultsTabsFragment) {
            this.f23174a = searchResultsTabsFragment;
        }

        public final void e_(int i) {
            Object obj;
            SearchResultsTab searchResultsTab = (SearchResultsTab) this.f23174a.am.get(i);
            String searchResultsTab2 = this.f23174a.at.toString();
            String searchResultsTab3 = searchResultsTab.toString();
            this.f23174a.f23182e.a(SearchResultsTabsFragment.al, SearchBugReportEvent.SERP_TAB_CLICKED, "Current tab: " + searchResultsTab2 + ", Clicked Tab: " + searchResultsTab3);
            SearchResultsLogger searchResultsLogger = this.f23174a.f23179b;
            SearchTypeaheadSession searchTypeaheadSession = this.f23174a.ao.f23188b;
            if (this.f23174a.ay) {
                obj = ActionSource.BACK_BUTTON;
            } else {
                obj = null;
            }
            HoneyClientEvent a = SearchResultsLogger.m25458a(Event.CLICK, searchTypeaheadSession).b("action", "tab_impression").b("destination_filter_type", searchResultsTab3).b("source_filter_type", searchResultsTab2).a("action_source", obj);
            searchResultsLogger.f21958c.a(a);
            if (BLog.b(3)) {
                String str = a.d;
                a.u();
            }
            this.f23174a.ao.m26898e(i);
            this.f23174a.ay = false;
            this.f23174a.at = searchResultsTab;
        }
    }

    /* compiled from: SECONDS_SINCE_FOREGROUND */
    class C24922 implements OnTouchListener {
        final /* synthetic */ SearchResultsTabsFragment f23175a;

        C24922(SearchResultsTabsFragment searchResultsTabsFragment) {
            this.f23175a = searchResultsTabsFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f23175a.f23179b.m25467a(this.f23175a.ar, ExitAction.EDIT_TEXT);
            }
            return false;
        }
    }

    public static void m26879a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SearchResultsTabsFragment) obj).m26878a((SearchResultsTabsPagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsTabsPagerAdapterProvider.class), SearchResultsLogger.m25460a(injectorLike), IdBasedLazy.a(injectorLike, 5272), NullStatePerformanceLogger.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), SearchBugReportExtraDataProvider.a(injectorLike), RTLUtil.a(injectorLike), SearchResultsTabConfig.m26873a(injectorLike), SearchThemeHelper.m10662a(injectorLike));
    }

    public final void m26891c(Bundle bundle) {
        super.c(bundle);
        Class cls = SearchResultsTabsFragment.class;
        m26879a(this, getContext());
    }

    public final View m26884a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 179002467);
        SearchTheme a2 = SearchResultsThemeHelper.m28570a(this.s);
        SearchTheme searchTheme = SearchTheme.DARK;
        Context a3 = SearchThemeHelper.m10661a(getContext(), a2);
        if (VERSION.SDK_INT >= 21) {
            FragmentActivity o = o();
            o.getWindow().setStatusBarColor(ContextUtils.c(a3, 16843857, 0));
        }
        View inflate = LayoutInflater.from(a3).inflate(2130904452, viewGroup, false);
        this.an = (ViewPager) FindViewUtil.b(inflate, 2131562217);
        this.au = (TabbedViewPagerIndicator) FindViewUtil.b(inflate, 2131562216);
        this.au.l = new C24911(this);
        this.ax = true;
        au();
        LogUtils.f(-618377865, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -532149585);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            View lh_ = hasTitleBar.lh_();
            if (lh_ != null && (lh_ instanceof GraphSearchTitleSearchBox)) {
                this.av = (GraphSearchTitleSearchBox) lh_;
                this.av.a(this);
                this.aw = new C24922(this);
                this.av.e.a(this.aw);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1717288617, a);
    }

    public final void m26882H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -841064279);
        this.f23182e.a(al, SearchBugReportEvent.FRAGMENT_PAUSED);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 901253473, a);
    }

    public final void m26881G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1609165607);
        super.G();
        this.f23182e.a(al, SearchBugReportEvent.FRAGMENT_RESUMED);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1968490698, a);
    }

    public final void m26885a(int i, int i2, Intent intent) {
        if (i == 1756 && i2 == -1) {
            ((ComposerPublishServiceHelper) this.f23186i.get()).c(intent);
        }
    }

    public final void mo1281a(GraphSearchQuerySpec graphSearchQuerySpec, SearchTypeaheadSession searchTypeaheadSession, SearchResultsSource searchResultsSource) {
        Preconditions.checkArgument(graphSearchQuerySpec instanceof KeywordTypeaheadUnit);
        this.aq = (KeywordTypeaheadUnit) graphSearchQuerySpec;
        this.ar = searchTypeaheadSession;
        this.as = searchResultsSource;
        au();
    }

    public final Fragment mo1192b() {
        return this;
    }

    public final boolean mo1191a(boolean z) {
        boolean z2;
        if (this.an == null || this.an.k <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z || !r2) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            this.ay = true;
            this.an.a(0, true);
            return true;
        }
        this.f23179b.m25467a(this.ar, z ? ExitAction.UP_BUTTON : ExitAction.BACK_BUTTON);
        return false;
    }

    public final void m26883I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 379958448);
        super.I();
        if (this.av != null) {
            this.av.b(this);
            this.av.e.b(this.aw);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 785731811, a);
    }

    public final void mo1190a(OnResultClickListener onResultClickListener) {
        this.ap = onResultClickListener;
    }

    public final void aq() {
        this.f23179b.m25467a(this.ar, ExitAction.CLEAR_BUTTON);
    }

    private void au() {
        Object obj;
        if (this.aq == null || !this.ax) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            Object obj2;
            int indexOf;
            if (this.s == null || !this.s.containsKey("tabs_override")) {
                this.am = this.f23184g.m26877a(this.aq);
            } else {
                this.am = ImmutableList.copyOf((List) this.s.getSerializable("tabs_override"));
            }
            this.ao = this.f23178a.m26899a(s(), this.aq, this.ar, this.as, this.ap, this, this.am);
            this.an.setAdapter(this.ao);
            if (this.aq == null) {
                obj2 = null;
            } else {
                KeywordType keywordType = this.aq.f22118g;
            }
            if (KeywordType.local_category.equals(obj2) && this.am.contains(SearchResultsTab.PLACES)) {
                indexOf = this.am.indexOf(SearchResultsTab.PLACES);
            } else {
                indexOf = m26880g(0);
            }
            if (this.au != null) {
                this.au.setViewPager(this.an);
                if (this.f23183f.a()) {
                    this.au.fullScroll(0);
                } else {
                    this.au.scrollTo(0, 0);
                }
                this.au.a(indexOf, 0.0f, 0);
            }
            this.at = (SearchResultsTab) this.am.get(indexOf);
            if (indexOf != this.an.k) {
                HandlerDetour.a(this.f23181d, new Runnable(this) {
                    final /* synthetic */ SearchResultsTabsFragment f23177b;

                    public void run() {
                        this.f23177b.an.a(indexOf, false);
                    }
                }, 1669565395);
            }
        }
    }

    private void m26878a(SearchResultsTabsPagerAdapterProvider searchResultsTabsPagerAdapterProvider, SearchResultsLogger searchResultsLogger, com.facebook.inject.Lazy<ComposerPublishServiceHelper> lazy, NullStatePerformanceLogger nullStatePerformanceLogger, Handler handler, SearchBugReportExtraDataProvider searchBugReportExtraDataProvider, RTLUtil rTLUtil, SearchResultsTabConfig searchResultsTabConfig, SearchThemeHelper searchThemeHelper) {
        this.f23178a = searchResultsTabsPagerAdapterProvider;
        this.f23179b = searchResultsLogger;
        this.f23186i = lazy;
        this.f23180c = nullStatePerformanceLogger;
        this.f23181d = handler;
        this.f23182e = searchBugReportExtraDataProvider;
        this.f23183f = rTLUtil;
        this.f23184g = searchResultsTabConfig;
        this.f23185h = searchThemeHelper;
    }

    private int m26880g(int i) {
        return this.f23183f.a() ? (this.am.size() - i) - 1 : i;
    }

    public final String am_() {
        return "graph_search_results_page";
    }

    public final void m26888a(SearchResultsTab searchResultsTab) {
        int indexOf = this.am.indexOf(searchResultsTab);
        if (indexOf != -1) {
            this.an.a(m26880g(indexOf), true);
        }
    }
}
