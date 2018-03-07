package com.facebook.search.suggestions;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.event.FbEvent;
import com.facebook.fbreact.search.ReactSearchEventBus;
import com.facebook.fbreact.search.ReactSearchEvents.LaunchReachSearchResultEventSubscriberImpl;
import com.facebook.fbreact.search.ReactSearchEvents.ReactNativeInfoHandler;
import com.facebook.fbreact.search.ReactSearchEvents.ResignKeyboardEvent;
import com.facebook.fbreact.search.ReactSearchEvents.ResignKeyboardEventSubscriber;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.inject.Assisted;
import com.facebook.marketplace.tab.MarketplaceTabFragmentFactory;
import com.facebook.marketplace.tab.fragment.MarketplaceHomeFragment;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.logging.SuggestionsTypeaheadAnalyticHelper;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.suggestions.SuggestionsFragment.DispatchTypeaheadSuggestionClickVisitor;
import com.facebook.search.suggestions.SuggestionsFragment.ExternalStateChangeListener;
import com.facebook.search.suggestions.SuggestionsFragment.ListInteractionListener;
import com.facebook.search.suggestions.nullstate.NullStateSupplier;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import com.facebook.search.suggestions.systems.ReactSearchTypeaheadSystem;
import com.facebook.search.suggestions.systems.SearchTypeaheadSystem;
import com.facebook.search.typeahead.TypeaheadUnitCollection;
import com.facebook.ui.typeahead.BaseTypeaheadController.OnNewSuggestionsListener;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: 💩 */
public class SingleSearchSuggestionsReactController implements SearchSuggestionListController {
    private final Context f67a;
    private final FragmentManager f68b;
    private final MarketplaceTabFragmentFactory f69c;
    private final ReactSearchSugestionsTypeaheadControllerProvider f70d;
    public final ReactSearchTypeaheadSystem f71e;
    private final ReactSearchEventBus f72f;
    private ResignKeyboardEventSubscriberImpl f73g;
    private GraphSearchQuery f74h;
    public MarketplaceHomeFragment f75i;
    private boolean f76j;
    private ReactSearchSugestionsTypeaheadController f77k;
    private LaunchReachSearchResultEventSubscriberImpl f78l;

    /* compiled from: 💩 */
    class ResignKeyboardEventSubscriberImpl extends ResignKeyboardEventSubscriber {
        final /* synthetic */ SingleSearchSuggestionsReactController f64a;
        private final ListInteractionListener f65b;
        private final MarketplaceHomeFragment f66c;

        public final void m118b(FbEvent fbEvent) {
            if (((ResignKeyboardEvent) fbEvent).a == this.f66c.av()) {
                this.f65b.m167b();
            }
        }

        public ResignKeyboardEventSubscriberImpl(SingleSearchSuggestionsReactController singleSearchSuggestionsReactController, ListInteractionListener listInteractionListener, MarketplaceHomeFragment marketplaceHomeFragment) {
            this.f64a = singleSearchSuggestionsReactController;
            this.f65b = listInteractionListener;
            this.f66c = marketplaceHomeFragment;
        }
    }

    public final ImmutableList<TypeaheadUnit> mo2a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        return RegularImmutableList.a;
    }

    public final ImmutableList<View> mo15c() {
        return RegularImmutableList.a;
    }

    @Inject
    public SingleSearchSuggestionsReactController(@Assisted Context context, @Assisted GraphSearchQuery graphSearchQuery, @Assisted FragmentManager fragmentManager, MarketplaceTabFragmentFactory marketplaceTabFragmentFactory, ReactSearchSugestionsTypeaheadControllerProvider reactSearchSugestionsTypeaheadControllerProvider, ReactSearchTypeaheadSystem reactSearchTypeaheadSystem, ReactSearchEventBus reactSearchEventBus) {
        this.f67a = context;
        this.f74h = graphSearchQuery;
        this.f69c = marketplaceTabFragmentFactory;
        this.f68b = fragmentManager;
        this.f70d = reactSearchSugestionsTypeaheadControllerProvider;
        this.f71e = reactSearchTypeaheadSystem;
        this.f72f = reactSearchEventBus;
    }

    @Nullable
    public final MultiRowAdapter mo16d() {
        return null;
    }

    public final FetchState mo17e() {
        return FetchState.ACTIVE;
    }

    @Nullable
    public final View mo18f() {
        return this.f75i != null ? this.f75i.T : null;
    }

    @Nullable
    public final ScrollingViewProxy mo19g() {
        return null;
    }

    @Nullable
    public final NullStateSupplier mo20h() {
        return null;
    }

    public final GraphSearchQuery mo21i() {
        return this.f74h;
    }

    @Nullable
    public final BaseSuggestionsTypeaheadController mo22j() {
        return this.f77k;
    }

    @Nullable
    public final SearchTypeaheadSystem mo23k() {
        return this.f71e;
    }

    @Nullable
    public final TypeaheadUnitCollection mo24l() {
        return null;
    }

    @Nullable
    public final TypeaheadUnitCollection mo1a(String str) {
        return null;
    }

    public final void mo4a(Context context, DispatchTypeaheadSuggestionClickVisitor dispatchTypeaheadSuggestionClickVisitor) {
    }

    public final void mo5a(@Nullable View view, final ListInteractionListener listInteractionListener, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("ReactRouteName", "SearchTypeaheadResultsRoute");
        intent.putExtra("ReactURI", "search_typeahead_results/?module=MarketplaceSearch");
        this.f75i = (MarketplaceHomeFragment) this.f69c.a(intent);
        FragmentTransaction a = this.f68b.a();
        a.a(this.f75i, null);
        a.b();
        this.f77k = this.f70d.a(this.f75i);
        this.f73g = new ResignKeyboardEventSubscriberImpl(this, listInteractionListener, this.f75i);
        this.f78l = new LaunchReachSearchResultEventSubscriberImpl(new ReactNativeInfoHandler(this) {
            final /* synthetic */ SingleSearchSuggestionsReactController f63b;

            public final int m115a() {
                if (this.f63b.f75i == null) {
                    return 0;
                }
                return this.f63b.f75i.av();
            }

            public final void m116a(String str) {
            }

            public final void m117a(String str, String str2) {
                ReactSearchTypeaheadSystem reactSearchTypeaheadSystem = this.f63b.f71e;
                int av = this.f63b.f75i.av();
                if (!(Strings.isNullOrEmpty(str) || Strings.isNullOrEmpty(str2))) {
                    reactSearchTypeaheadSystem.f312b.putString("marketplace_search_uri", str.substring(1));
                    reactSearchTypeaheadSystem.f312b.putString("marketplace_search_module", str2);
                    reactSearchTypeaheadSystem.f312b.putInt("marketplace_search_typeahead_react_tag", av);
                }
                ListInteractionListener listInteractionListener = listInteractionListener;
                if (listInteractionListener.f96a.ba.mo23k() != null) {
                    listInteractionListener.f96a.ba.mo3a(8);
                    listInteractionListener.f96a.f105h.a.k = null;
                    listInteractionListener.f96a.ba.mo23k().mo43a(listInteractionListener.f96a.ba.mo21i()).a(listInteractionListener.f96a.f101d);
                    listInteractionListener.f96a.f105h.a.k = listInteractionListener.f96a.f103f;
                    SuggestionsFragment.aN(listInteractionListener.f96a);
                }
            }
        });
        this.f72f.a(this.f73g);
        this.f72f.a(this.f78l);
    }

    public final void mo11a(@Nullable LazyView<ProgressBar> lazyView, @Nullable View view, boolean z) {
    }

    public final void mo8a(SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper) {
    }

    public final void mo25m() {
    }

    public final void mo26n() {
    }

    public final void mo27o() {
        if (this.f75i != null) {
            this.f75i.mY_();
            this.f75i.I();
            this.f75i = null;
        }
        if (this.f73g != null) {
            this.f72f.b(this.f73g);
            this.f73g = null;
        }
        if (this.f78l != null) {
            this.f72f.b(this.f78l);
            this.f78l = null;
        }
        if (this.f77k != null) {
            this.f77k.b(null);
            this.f77k = null;
        }
    }

    public final void mo28p() {
    }

    public final void mo6a(CallerContext callerContext, RefreshPolicy refreshPolicy) {
    }

    public final void mo29q() {
    }

    public final void mo9a(ExternalStateChangeListener externalStateChangeListener) {
    }

    public final void mo7a(GraphSearchQuery graphSearchQuery) {
        this.f74h = graphSearchQuery;
    }

    public final void mo10a(OnNewSuggestionsListener onNewSuggestionsListener) {
    }

    public final void mo13a(String str, ImmutableList<TypeaheadUnit> immutableList) {
    }

    public final void mo3a(int i) {
        if (this.f75i != null && this.f75i.T != null) {
            this.f75i.g(i == 0);
            this.f75i.T.setVisibility(i);
        }
    }

    public final void mo12a(String str, NullStateStatus nullStateStatus, boolean z) {
    }

    public final void mo14a(boolean z) {
        this.f76j = z;
    }
}
