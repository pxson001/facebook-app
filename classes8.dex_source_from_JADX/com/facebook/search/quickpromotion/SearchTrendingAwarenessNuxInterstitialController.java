package com.facebook.search.quickpromotion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialControllerWithExtraLogData;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.SearchResultsLogger.Event;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.util.SearchPivotData;
import com.facebook.ui.search.SearchEditText;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TAGGED_MEDIA_SET */
public class SearchTrendingAwarenessNuxInterstitialController implements InterstitialActionController, InterstitialController, InterstitialControllerWithExtraLogData {
    public final SearchResultsIntentBuilder f22521a;
    public final SecureContextHelper f22522b;
    public final Provider<ComponentName> f22523c;
    public final Provider<SearchResultsLogger> f22524d;
    private final QeAccessor f22525e;
    public final NUXParameters f22526f;
    public Runnable f22527g;
    public ImmutableList<SearchPivotData> f22528h = RegularImmutableList.a;
    public SearchEditText f22529i;
    public SearchResultsMutableContext f22530j;

    /* compiled from: TAGGED_MEDIA_SET */
    public class NUXParameters {
        public String f22515a;
        public int f22516b;
        public int f22517c;
        public String f22518d;
        @Nullable
        public String f22519e;
        public boolean f22520f;

        public NUXParameters(String str, int i, int i2, String str2, @Nullable String str3, boolean z) {
            this.f22515a = str;
            this.f22516b = i;
            this.f22517c = i2;
            this.f22518d = str2;
            this.f22519e = str3;
            this.f22520f = z;
        }
    }

    @Inject
    public SearchTrendingAwarenessNuxInterstitialController(SearchResultsIntentBuilder searchResultsIntentBuilder, SecureContextHelper secureContextHelper, @FragmentChromeActivity Provider<ComponentName> provider, Provider<SearchResultsLogger> provider2, QeAccessor qeAccessor) {
        this.f22521a = searchResultsIntentBuilder;
        this.f22522b = secureContextHelper;
        this.f22523c = provider;
        this.f22524d = provider2;
        this.f22525e = qeAccessor;
        this.f22526f = new NUXParameters(this.f22525e.a(ExperimentsForSearchAbTestModule.bJ, "none"), this.f22525e.a(ExperimentsForSearchAbTestModule.bH, 2), this.f22525e.a(ExperimentsForSearchAbTestModule.bI, 0), this.f22525e.a(ExperimentsForSearchAbTestModule.bM, "none"), this.f22525e.a(ExperimentsForSearchAbTestModule.bG, null), this.f22525e.a(ExperimentsForSearchAbTestModule.bL, false));
    }

    public final void m25989a(Context context, Object obj) {
        boolean z = false;
        String str = this.f22526f.f22518d;
        boolean z2 = true;
        switch (str.hashCode()) {
            case -1140076541:
                if (str.equals("tooltip")) {
                    z2 = true;
                    break;
                }
                break;
            case 109457:
                if (str.equals("nux")) {
                    z2 = false;
                    break;
                }
                break;
        }
        switch (z2) {
            case false:
                z = m25986a(context);
                break;
            case true:
                boolean z3;
                if (this.f22526f.f22519e == null) {
                    z3 = false;
                } else {
                    Tooltip tooltip = new Tooltip(context, 2);
                    tooltip.b(this.f22526f.f22519e);
                    tooltip.a(Position.BELOW);
                    tooltip.t = -1;
                    tooltip.f(this.f22529i);
                    z3 = true;
                }
                z = z3;
                break;
        }
        if (z) {
            SearchResultsLogger searchResultsLogger = (SearchResultsLogger) this.f22524d.get();
            SearchResultsMutableContext searchResultsMutableContext = this.f22530j;
            HoneyClientEvent b = SearchResultsLogger.m25459a(Event.MODULE_IMPRESSION, searchResultsMutableContext).b("results_module_type", "trending_awareness").a("query_pivots", SearchResultsLogger.m25465b(this.f22528h)).b("trending_awareness_unit_type", this.f22526f.f22518d);
            searchResultsLogger.f21958c.a(b);
            if (BLog.b(3)) {
                String str2 = b.d;
                b.u();
            }
        }
    }

    public final String m25991b() {
        return "3699";
    }

    public final void m25990a(Parcelable parcelable) {
    }

    public final void m25988a(long j) {
    }

    public final InterstitialControllerState m25987a(InterstitialTrigger interstitialTrigger) {
        if (!this.f22526f.f22520f || this.f22529i == null || this.f22526f.f22519e == null || this.f22526f.f22518d == null || this.f22530j == null) {
            return InterstitialControllerState.INELIGIBLE;
        }
        String str = this.f22526f.f22518d;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1140076541:
                if (str.equals("tooltip")) {
                    obj = 1;
                    break;
                }
                break;
            case 109457:
                if (str.equals("nux")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return (this.f22528h.size() > this.f22526f.f22516b || this.f22528h.isEmpty() || this.f22527g == null) ? InterstitialControllerState.INELIGIBLE : InterstitialControllerState.ELIGIBLE;
            case 1:
                return InterstitialControllerState.ELIGIBLE;
            default:
                return InterstitialControllerState.INELIGIBLE;
        }
    }

    public final ImmutableList<InterstitialTrigger> m25992c() {
        return ImmutableList.of(new InterstitialTrigger(Action.SEARCH_TRENDING_TOPIC_LOADED));
    }

    public final ImmutableMap<String, String> m25993e() {
        SearchResultsMutableContext searchResultsMutableContext = this.f22530j;
        String str = this.f22526f.f22515a;
        String str2 = this.f22526f.f22518d;
        int i = this.f22526f.f22517c;
        ImmutableList immutableList = this.f22528h;
        Builder builder = new Builder();
        if (searchResultsMutableContext.mo1211a() != null) {
            builder.b("query", searchResultsMutableContext.mo1211a());
        }
        if (searchResultsMutableContext.mo1212b() != null) {
            builder.b("query_function", searchResultsMutableContext.mo1212b());
        }
        builder.b("query_pivots", SearchResultsLogger.m25465b(immutableList).toString());
        builder.b("trending_awareness_tap_target", str);
        builder.b("trending_awareness_unit_type", str2);
        builder.b("trending_awareness_launch_time", Integer.toString(i));
        return builder.b();
    }

    public final long hI_() {
        return 86400000;
    }

    private boolean m25986a(final Context context) {
        if (this.f22526f.f22519e == null) {
            return false;
        }
        PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(context);
        PopoverMenu c = popoverMenuWindow.c();
        for (int i = 0; i < this.f22528h.size(); i++) {
            final SearchPivotData searchPivotData = (SearchPivotData) this.f22528h.get(i);
            MenuItemImpl a = c.a(searchPivotData.f8923a);
            a.setIcon(2130840590);
            a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ SearchTrendingAwarenessNuxInterstitialController f22514d;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    String str = this.f22514d.f22526f.f22515a;
                    boolean z = true;
                    switch (str.hashCode()) {
                        case 3526672:
                            if (str.equals("serp")) {
                                z = false;
                                break;
                            }
                            break;
                        case 520854215:
                            if (str.equals("typeahead")) {
                                z = true;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                            this.f22514d.f22522b.a(this.f22514d.f22521a.a(menuItem.getTitle().toString(), searchPivotData.f8924b, "content", SearchResultsSource.r, this.f22514d.f22530j.f23369d, ExactMatchInputExactMatch.FALSE), context);
                            break;
                        case true:
                            GraphSearchQuery a = GraphSearchQuery.a(menuItem.getTitle().toString());
                            a.l = true;
                            this.f22514d.f22522b.a(new Intent().setComponent((ComponentName) this.f22514d.f22523c.get()).putExtra("target_fragment", ContentFragmentType.SEARCH_FRAGMENT.ordinal()).putExtra("initial_typeahead_query", a), context);
                            break;
                        default:
                            return false;
                    }
                    ((SearchResultsLogger) this.f22514d.f22524d.get()).m25478a(this.f22514d.f22530j, i, searchPivotData.f8923a, searchPivotData.f8924b, this.f22514d.f22526f.f22515a);
                    this.f22514d.f22527g.run();
                    return true;
                }
            });
        }
        TrendingAwarenessPopoverView trendingAwarenessPopoverView = new TrendingAwarenessPopoverView(context);
        trendingAwarenessPopoverView.f22531a.setText(this.f22526f.f22519e);
        popoverMenuWindow.o = trendingAwarenessPopoverView;
        popoverMenuWindow.b(0.0f);
        popoverMenuWindow.f(this.f22529i);
        return true;
    }
}
