package com.facebook.search.suggestions;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.logging.SuggestionsTypeaheadAnalyticHelper;
import com.facebook.search.logging.perf.SearchWaterfallLogger;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.quickpromotion.SearchAwarenessController;
import com.facebook.search.quickpromotion.SearchAwarenessNullStateController;
import com.facebook.search.suggestions.SuggestionsFragment.C00135;
import com.facebook.search.suggestions.SuggestionsFragment.DispatchTypeaheadSuggestionClickVisitor;
import com.facebook.search.suggestions.SuggestionsFragment.ExternalStateChangeListener;
import com.facebook.search.suggestions.SuggestionsFragment.ListInteractionListener;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironmentProvider;
import com.facebook.search.suggestions.nullstate.ActivityLogPopoverView;
import com.facebook.search.suggestions.nullstate.NullStateSupplier;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.NullStateStatusListener;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import com.facebook.search.suggestions.nullstate.NullStateViewController;
import com.facebook.search.suggestions.nullstate.NullStateViewControllerProvider;
import com.facebook.search.suggestions.nullstate.mutator.NullStateSupplierFactory;
import com.facebook.search.suggestions.systems.BaseSearchTypeaheadSystem;
import com.facebook.search.suggestions.systems.SearchTypeaheadSystem;
import com.facebook.search.suggestions.systems.SearchTypeaheadSystemFactory;
import com.facebook.search.typeahead.TypeaheadUnitCollection;
import com.facebook.search.typeahead.rows.SearchTypeaheadFeedListType;
import com.facebook.search.typeahead.rows.SearchTypeaheadRootGroupPartDefinition;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.search.util.bugreporter.SearchBugReportEvent;
import com.facebook.ui.typeahead.BaseTypeaheadController.OnNewSuggestionsListener;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.OnFetchStateChangedListener;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.widget.LazyView;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnItemClickListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnItemLongClickListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnTouchDownListener;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: 😂 */
public class SingleSearchSuggestionListController implements SearchSuggestionListController, NullStateStatusListener, OnFetchStateChangedListener {
    private final Context f39a;
    private final Lazy<SearchTypeaheadSystemFactory> f40b;
    private final BaseSuggestionsTypeaheadController f41c;
    public final TypeaheadUnitCollection f42d;
    private final SearchSuggestionsEnvironmentProvider f43e;
    public final NullStateSupplierFactory f44f;
    private final Lazy<SearchTypeaheadRootGroupPartDefinition> f45g;
    private final MultiRowAdapterBuilder f46h;
    public final SearchWaterfallLogger f47i;
    private final MultipleRowsStoriesRecycleCallback f48j;
    private final NullStateViewControllerProvider f49k;
    private final TypeaheadListItemComparator f50l;
    private SearchTypeaheadSystem f51m;
    public NullStateSupplier f52n;
    public MultiRowAdapter f53o;
    public ScrollingViewProxy f54p;
    private NullStateViewController f55q;
    public GraphSearchQuery f56r = GraphSearchQuery.e;
    public ExternalStateChangeListener f57s;
    private View f58t;
    private SearchSuggestionsListView f59u;
    public FetchState f60v = FetchState.IDLE;
    private ProgressBar f61w;

    /* compiled from: 😂 */
    class C00011 implements Runnable {
        final /* synthetic */ SingleSearchSuggestionListController f27a;

        C00011(SingleSearchSuggestionListController singleSearchSuggestionListController) {
            this.f27a = singleSearchSuggestionListController;
        }

        public void run() {
            this.f27a.f53o.notifyDataSetChanged();
        }
    }

    /* compiled from: 😂 */
    class C00022 extends DataSetObserver {
        final /* synthetic */ SingleSearchSuggestionListController f28a;

        C00022(SingleSearchSuggestionListController singleSearchSuggestionListController) {
            this.f28a = singleSearchSuggestionListController;
        }

        public void onChanged() {
            this.f28a.f47i.a(this.f28a.f53o.getCount());
        }
    }

    /* compiled from: 😂 */
    class LayoutManagerWithNoPredictiveItemAnimation extends BetterLinearLayoutManager {
        public LayoutManagerWithNoPredictiveItemAnimation(Context context) {
            super(context);
        }

        public final boolean m77e() {
            return false;
        }
    }

    @Inject
    public SingleSearchSuggestionListController(@Assisted Context context, @Assisted GraphSearchQuery graphSearchQuery, Lazy<SearchTypeaheadSystemFactory> lazy, BaseSuggestionsTypeaheadController baseSuggestionsTypeaheadController, TypeaheadUnitCollection typeaheadUnitCollection, SearchSuggestionsEnvironmentProvider searchSuggestionsEnvironmentProvider, NullStateSupplierFactory nullStateSupplierFactory, Lazy<SearchTypeaheadRootGroupPartDefinition> lazy2, MultiRowAdapterBuilder multiRowAdapterBuilder, SearchWaterfallLogger searchWaterfallLogger, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, NullStateViewControllerProvider nullStateViewControllerProvider, TypeaheadListItemComparator typeaheadListItemComparator) {
        this.f39a = context;
        this.f56r = graphSearchQuery;
        this.f40b = lazy;
        this.f41c = baseSuggestionsTypeaheadController;
        this.f42d = typeaheadUnitCollection;
        this.f43e = searchSuggestionsEnvironmentProvider;
        this.f44f = nullStateSupplierFactory;
        this.f45g = lazy2;
        this.f46h = multiRowAdapterBuilder;
        this.f47i = searchWaterfallLogger;
        this.f48j = multipleRowsStoriesRecycleCallback;
        this.f49k = nullStateViewControllerProvider;
        this.f50l = typeaheadListItemComparator;
        mo7a(this.f56r);
    }

    public final void mo26n() {
        this.f53o.jc_();
    }

    public final ImmutableList<View> mo15c() {
        return ImmutableList.of(this.f58t);
    }

    @Nullable
    public final MultiRowAdapter mo16d() {
        return this.f53o;
    }

    public final FetchState mo17e() {
        return this.f60v;
    }

    @Nullable
    public final View mo18f() {
        return this.f58t;
    }

    @Nullable
    public final ScrollingViewProxy mo19g() {
        return this.f54p;
    }

    @Nullable
    public final NullStateSupplier mo20h() {
        return this.f52n;
    }

    public final GraphSearchQuery mo21i() {
        return this.f56r;
    }

    public final BaseSuggestionsTypeaheadController mo22j() {
        return this.f41c;
    }

    @Nullable
    public final SearchTypeaheadSystem mo23k() {
        return this.f51m;
    }

    public final TypeaheadUnitCollection mo24l() {
        return this.f42d;
    }

    public final ImmutableList<TypeaheadUnit> mo2a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        return this.f51m.mo44a(this.f56r, typeaheadResponse.b, this.f41c.i(), this.f60v);
    }

    public final TypeaheadUnitCollection mo1a(String str) {
        return mo24l();
    }

    public final void mo4a(Context context, DispatchTypeaheadSuggestionClickVisitor dispatchTypeaheadSuggestionClickVisitor) {
        SearchSuggestionsEnvironment a = this.f43e.m209a(context, SearchTypeaheadFeedListType.f518a, new C00011(this), dispatchTypeaheadSuggestionClickVisitor, this.f42d);
        Builder a2 = this.f46h.a(this.f45g, this.f42d);
        a2.f = a;
        Builder builder = a2;
        builder.m = true;
        builder = builder;
        builder.e = this.f50l;
        this.f53o = builder.e();
        this.f53o.registerDataSetObserver(new C00022(this));
    }

    public final void mo5a(@Nullable View view, final ListInteractionListener listInteractionListener, boolean z) {
        View view2;
        if (view == null) {
            this.f59u = new SearchSuggestionsListView(this.f39a, z);
            this.f58t = this.f59u;
            view2 = this.f59u.f14a;
        } else {
            this.f58t = view;
            view2 = view;
        }
        if (z) {
            BetterRecyclerView betterRecyclerView = (BetterRecyclerView) view2;
            betterRecyclerView.setLayoutManager(new LayoutManagerWithNoPredictiveItemAnimation(betterRecyclerView.getContext()));
            betterRecyclerView.setItemAnimator(null);
            this.f54p = new RecyclerViewProxy(betterRecyclerView);
        } else {
            this.f54p = new ListViewProxy((BetterListView) view2);
            m79r();
        }
        this.f54p.a(this.f53o);
        this.f54p.a(this.f48j.a());
        this.f54p.a(new OnItemClickListener(this) {
            final /* synthetic */ SingleSearchSuggestionListController f30b;

            public final void m72a(int i) {
                ListInteractionListener listInteractionListener = listInteractionListener;
                ScrollingViewProxy scrollingViewProxy = this.f30b.f54p;
                MultiRowAdapter multiRowAdapter = this.f30b.f53o;
                TypeaheadUnitCollection typeaheadUnitCollection = this.f30b.f42d;
                if (scrollingViewProxy != null) {
                    int u = i - scrollingViewProxy.u();
                    if (u >= 0 && u < multiRowAdapter.getCount()) {
                        TypeaheadUnit typeaheadUnit;
                        if (multiRowAdapter.getItem(u) instanceof BoundedAdapter) {
                            typeaheadUnit = (TypeaheadUnit) ((BoundedAdapter) multiRowAdapter.getItem(u)).c();
                        } else {
                            typeaheadUnit = (TypeaheadUnit) multiRowAdapter.getItem(u);
                        }
                        listInteractionListener.f96a.aM.a(SuggestionsFragment.f99b, SearchBugReportEvent.TYPEAHEAD_UNIT_CLICKED, typeaheadUnit.toString());
                        if (typeaheadUnit.x()) {
                            ((SuggestionsTypeaheadAnalyticHelper) listInteractionListener.f96a.an.get()).a("keyword", typeaheadUnit, listInteractionListener.f96a.aY.b, SuggestionsFragment.m178b(typeaheadUnitCollection.f422a), SuggestionsFragment.aw(listInteractionListener.f96a), listInteractionListener.f96a.bb, listInteractionListener.f96a.aY.h);
                        } else if (listInteractionListener.f96a.aK.c() && (typeaheadUnit instanceof EntityTypeaheadUnit) && SuggestionsFragment.aR(listInteractionListener.f96a) != null) {
                            SuggestionsFragment.aN(listInteractionListener.f96a);
                            SearchAwarenessController searchAwarenessController = listInteractionListener.f96a.aK;
                            View aR = SuggestionsFragment.aR(listInteractionListener.f96a);
                            SearchAwarenessNullStateController searchAwarenessNullStateController = (SearchAwarenessNullStateController) searchAwarenessController.h.get(GraphQLSearchAwarenessTemplatesEnum.LEARNING_NUX_SECOND_STEP);
                            if (searchAwarenessNullStateController != null) {
                                searchAwarenessNullStateController.a(aR);
                            }
                        } else {
                            if (listInteractionListener.f96a.bf) {
                                listInteractionListener.f96a.aK.b(SuggestionsFragment.f100c, false);
                            }
                            ((NavigationLogger) listInteractionListener.f96a.av.get()).a("tap_search_result");
                            listInteractionListener.f96a.f105h.a.k = null;
                            typeaheadUnit.a(listInteractionListener.f96a.f101d);
                            listInteractionListener.f96a.f105h.a.k = listInteractionListener.f96a.f103f;
                            SuggestionsFragment.aN(listInteractionListener.f96a);
                        }
                    }
                }
            }
        });
        this.f54p.a(new OnItemLongClickListener(this) {
            final /* synthetic */ SingleSearchSuggestionListController f32b;

            public final boolean m73a(View view, int i) {
                boolean z;
                ListInteractionListener listInteractionListener = listInteractionListener;
                ScrollingViewProxy scrollingViewProxy = this.f32b.f54p;
                MultiRowAdapter multiRowAdapter = this.f32b.f53o;
                if (scrollingViewProxy == null) {
                    z = false;
                } else {
                    int u = i - scrollingViewProxy.u();
                    if (u < 0 || u >= multiRowAdapter.getCount()) {
                        listInteractionListener.f96a.ay.a(GraphSearchError.TYPEAHEAD_LONG_PRESS_INDEX_OUT_OF_BOUNDS, "Long click index out of bounds. Index: " + u + ", Size: " + multiRowAdapter.getCount());
                        z = false;
                    } else if (u >= multiRowAdapter.getCount()) {
                        z = false;
                    } else {
                        Object obj;
                        if (multiRowAdapter.getItem(u) instanceof BoundedAdapter) {
                            obj = (TypeaheadUnit) ((BoundedAdapter) multiRowAdapter.getItem(u)).c();
                        } else {
                            TypeaheadUnit typeaheadUnit = (TypeaheadUnit) multiRowAdapter.getItem(u);
                        }
                        listInteractionListener.f96a.aM.a(SuggestionsFragment.f99b, SearchBugReportEvent.TYPEAHEAD_UNIT_LONG_CLICKED, obj.toString());
                        ((NavigationLogger) listInteractionListener.f96a.av.get()).a("tap_search_result");
                        if (obj instanceof NullStateSuggestionTypeaheadUnit) {
                            SuggestionsFragment suggestionsFragment = listInteractionListener.f96a;
                            View view2 = listInteractionListener.f96a.T;
                            PopoverWindow popoverWindow = new PopoverWindow(suggestionsFragment.getContext());
                            ActivityLogPopoverView activityLogPopoverView = new ActivityLogPopoverView(suggestionsFragment.getContext());
                            activityLogPopoverView.f175c = popoverWindow;
                            activityLogPopoverView.f174b = new C00135(suggestionsFragment);
                            popoverWindow.d(activityLogPopoverView);
                            popoverWindow.c(view2);
                            popoverWindow.a(Position.CENTER);
                            popoverWindow.d();
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                }
                return z;
            }
        });
        this.f54p.a(new OnTouchDownListener(this) {
            final /* synthetic */ SingleSearchSuggestionListController f34b;

            public final void m74a(ScrollingViewProxy scrollingViewProxy) {
                listInteractionListener.m167b();
            }
        });
        this.f54p.b(new OnScrollListener(this) {
            final /* synthetic */ SingleSearchSuggestionListController f36b;

            public final void m75a(ScrollingViewProxy scrollingViewProxy, int i) {
                switch (i) {
                    case 1:
                        listInteractionListener.f96a.f105h.a.e.c();
                        return;
                    default:
                        return;
                }
            }

            public final void m76a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            }
        });
        this.f54p.b(new OnDrawListener(this) {
            final /* synthetic */ SingleSearchSuggestionListController f38b;

            public final boolean gD_() {
                return listInteractionListener.m166a(this.f38b.f42d, this.f38b.f53o, this.f38b.f52n);
            }
        });
    }

    public final void mo11a(@Nullable LazyView<ProgressBar> lazyView, @Nullable View view, boolean z) {
        if (lazyView == null) {
            lazyView = this.f59u.f15b;
        }
        this.f55q = new NullStateViewController(lazyView, this.f54p, view);
        if (StringUtil.c(mo22j().c())) {
            this.f55q.m329a(this.f52n.c(), z);
        }
    }

    public final void mo8a(SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper) {
        this.f41c.a(this.f56r);
        this.f41c.a(suggestionsTypeaheadAnalyticHelper);
    }

    public final void mo25m() {
        if (this.f56r != GraphSearchQuery.e) {
            this.f56r = GraphSearchQuery.e;
            m78b(GraphSearchQuery.e);
        }
    }

    public final void mo27o() {
        this.f54p = null;
        this.f61w = null;
        this.f55q.m328a();
    }

    public final void mo28p() {
        this.f41c.h();
    }

    public final void mo6a(CallerContext callerContext, RefreshPolicy refreshPolicy) {
        this.f52n.a(callerContext, refreshPolicy);
    }

    public final void mo29q() {
        if (this.f54p != null) {
            this.f54p.h(0);
        }
    }

    public final void mo9a(@Nullable ExternalStateChangeListener externalStateChangeListener) {
        SingleSearchSuggestionListController singleSearchSuggestionListController;
        OnFetchStateChangedListener onFetchStateChangedListener = null;
        this.f57s = externalStateChangeListener;
        if (this.f52n != null) {
            if (externalStateChangeListener != null) {
                this.f52n.a(this, this);
            } else {
                this.f52n.a(null, null);
            }
        }
        BaseSuggestionsTypeaheadController baseSuggestionsTypeaheadController = this.f41c;
        if (externalStateChangeListener == null) {
            singleSearchSuggestionListController = null;
        } else {
            singleSearchSuggestionListController = this;
        }
        baseSuggestionsTypeaheadController.a(singleSearchSuggestionListController);
        BaseSuggestionsTypeaheadController baseSuggestionsTypeaheadController2 = this.f41c;
        if (externalStateChangeListener != null) {
            onFetchStateChangedListener = this;
        }
        baseSuggestionsTypeaheadController2.a(onFetchStateChangedListener);
    }

    public final void mo7a(GraphSearchQuery graphSearchQuery) {
        this.f56r = graphSearchQuery;
        if (this.f52n != null) {
            this.f52n.a(null, null);
        }
        this.f52n = this.f44f.m359a(this.f56r);
        if (this.f57s != null) {
            this.f52n.a(this, this);
        }
        m78b(graphSearchQuery);
    }

    public final void mo10a(OnNewSuggestionsListener onNewSuggestionsListener) {
        this.f41c.n = onNewSuggestionsListener;
    }

    public final void mo13a(String str, ImmutableList<TypeaheadUnit> immutableList) {
        this.f42d.m529a((List) immutableList);
        this.f53o.notifyDataSetChanged();
    }

    public final void mo3a(int i) {
        if (this.f54p != null) {
            this.f54p.a(i);
        }
    }

    public final void mo12a(String str, NullStateStatus nullStateStatus, boolean z) {
        if (this.f55q != null) {
            this.f55q.m329a(NullStateStatus.READY, z);
        }
    }

    public final void mo14a(boolean z) {
    }

    private void m78b(GraphSearchQuery graphSearchQuery) {
        SearchTypeaheadSystem searchTypeaheadSystem;
        SearchTypeaheadSystemFactory searchTypeaheadSystemFactory = (SearchTypeaheadSystemFactory) this.f40b.get();
        if (!searchTypeaheadSystemFactory.f331k.a(SearchAbTestGatekeepers.f).asBoolean(false) || searchTypeaheadSystemFactory.f331k.a(SearchAbTestGatekeepers.u, false)) {
            searchTypeaheadSystem = (SearchTypeaheadSystem) searchTypeaheadSystemFactory.f321a.get();
        } else if (GraphSearchConfig.b(graphSearchQuery)) {
            searchTypeaheadSystem = (SearchTypeaheadSystem) searchTypeaheadSystemFactory.f323c.get();
        } else if (searchTypeaheadSystemFactory.f329i.e(graphSearchQuery)) {
            searchTypeaheadSystem = (SearchTypeaheadSystem) searchTypeaheadSystemFactory.f324d.get();
        } else if (searchTypeaheadSystemFactory.f329i.h(graphSearchQuery)) {
            BaseSearchTypeaheadSystem baseSearchTypeaheadSystem = searchTypeaheadSystemFactory.f330j.a(ExperimentsForSearchAbTestModule.bh, false) ? (BaseSearchTypeaheadSystem) searchTypeaheadSystemFactory.f326f.get() : (BaseSearchTypeaheadSystem) searchTypeaheadSystemFactory.f325e.get();
        } else {
            searchTypeaheadSystem = searchTypeaheadSystemFactory.f330j.a(ExperimentsForSearchAbTestModule.B, false) ? (SearchTypeaheadSystem) searchTypeaheadSystemFactory.f327g.get() : searchTypeaheadSystemFactory.f330j.a(ExperimentsForSearchAbTestModule.A, false) ? (SearchTypeaheadSystem) searchTypeaheadSystemFactory.f328h.get() : searchTypeaheadSystemFactory.f331k.a(SearchAbTestGatekeepers.j).asBoolean(true) ? (SearchTypeaheadSystem) searchTypeaheadSystemFactory.f323c.get() : (SearchTypeaheadSystem) searchTypeaheadSystemFactory.f322b.get();
        }
        this.f51m = searchTypeaheadSystem;
    }

    public final FetchState m97b() {
        return this.f60v;
    }

    public final void m98b(FetchState fetchState) {
        this.f60v = fetchState;
    }

    public final void m88a(NullStateStatus nullStateStatus) {
        if (this.f57s != null) {
            ExternalStateChangeListener externalStateChangeListener = this.f57s;
            NullStateViewController nullStateViewController = this.f55q;
            BaseSuggestionsTypeaheadController baseSuggestionsTypeaheadController = this.f41c;
            if (StringUtil.c(SuggestionsFragment.aG(externalStateChangeListener.f95a))) {
                nullStateViewController.m329a(nullStateStatus, SuggestionsFragment.aO(externalStateChangeListener.f95a));
                baseSuggestionsTypeaheadController.h();
            }
        }
    }

    public final void m82a() {
        if (this.f57s != null) {
            this.f57s.m165a(m79r(), this.f54p, this.f52n, this.f55q, this.f42d, this.f53o, this);
        }
    }

    public final void m92a(FetchState fetchState) {
        if (this.f57s != null) {
            ExternalStateChangeListener externalStateChangeListener = this.f57s;
            ProgressBar r = m79r();
            ScrollingViewProxy scrollingViewProxy = this.f54p;
            externalStateChangeListener.f95a.aM.a(SuggestionsFragment.f99b, SearchBugReportEvent.FETCH_STATE_CHANGED, "Old: " + this.f60v + ", New: " + fetchState);
            this.f60v = fetchState;
            if (fetchState != FetchState.ACTIVE) {
                SuggestionsFragment.m182c(externalStateChangeListener.f95a, SuggestionsFragment.aG(externalStateChangeListener.f95a));
            }
            SuggestionsFragment.m171a(externalStateChangeListener.f95a, r, scrollingViewProxy, fetchState);
            SuggestionsFragment.m174a(externalStateChangeListener.f95a, fetchState);
        }
    }

    private ProgressBar m79r() {
        if (this.f61w == null) {
            this.f61w = (ProgressBar) LayoutInflater.from(this.f54p.ix_().getContext()).inflate(2130904626, null, false);
            this.f54p.e(this.f61w);
        }
        return this.f61w;
    }
}
