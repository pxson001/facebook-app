package com.facebook.search.results.rows.sections.local;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.android.maps.model.BitmapDescriptor;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.android.maps.model.LatLngBounds.Builder;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.maps.delegate.CameraUpdateDelegate;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapDelegate.OnMapClickListener;
import com.facebook.maps.delegate.MapDelegate.OnMarkerClickListener;
import com.facebook.maps.delegate.MarkerDelegate;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.SearchResultsLogger.Event;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.contract.SearchResultsSeeMoreFeedUnit;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.google.common.collect.ImmutableList;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageView not attached to controller */
public class SearchResultsFbMapViewDelegatePartDefinition<E extends HasContext & HasPositionInformation & HasSearchResultPosition & HasSearchResultsContext> extends BaseSinglePartDefinition<SearchResultsCollectionUnit<GraphQLNode>, State, E, FbMapViewDelegate> {
    private static SearchResultsFbMapViewDelegatePartDefinition f24576f;
    private static final Object f24577g = new Object();
    public final Lazy<Resources> f24578a;
    public final Lazy<QeAccessor> f24579b;
    private final Lazy<SearchResultsLogger> f24580c;
    private final Lazy<SearchResultsIntentBuilder> f24581d;
    private final Lazy<SecureContextHelper> f24582e;

    /* compiled from: PageView not attached to controller */
    public class State {
        public Bundle f24573a = new Bundle();
        public boolean f24574b = false;
        public final OnMapReadyDelegateCallback f24575c;

        public State(OnMapReadyDelegateCallback onMapReadyDelegateCallback) {
            this.f24575c = onMapReadyDelegateCallback;
        }
    }

    private static SearchResultsFbMapViewDelegatePartDefinition m28021b(InjectorLike injectorLike) {
        return new SearchResultsFbMapViewDelegatePartDefinition(IdBasedSingletonScopeProvider.b(injectorLike, 30), IdBasedSingletonScopeProvider.b(injectorLike, 3219), IdBasedSingletonScopeProvider.b(injectorLike, 10491), IdBasedSingletonScopeProvider.b(injectorLike, 3375), IdBasedSingletonScopeProvider.b(injectorLike, 968));
    }

    public static SearchResultsFbMapViewDelegatePartDefinition m28019a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsFbMapViewDelegatePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24577g) {
                SearchResultsFbMapViewDelegatePartDefinition searchResultsFbMapViewDelegatePartDefinition;
                if (a2 != null) {
                    searchResultsFbMapViewDelegatePartDefinition = (SearchResultsFbMapViewDelegatePartDefinition) a2.a(f24577g);
                } else {
                    searchResultsFbMapViewDelegatePartDefinition = f24576f;
                }
                if (searchResultsFbMapViewDelegatePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28021b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24577g, b3);
                        } else {
                            f24576f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsFbMapViewDelegatePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsFbMapViewDelegatePartDefinition(Lazy<Resources> lazy, Lazy<QeAccessor> lazy2, Lazy<SearchResultsLogger> lazy3, Lazy<SearchResultsIntentBuilder> lazy4, Lazy<SecureContextHelper> lazy5) {
        this.f24578a = lazy;
        this.f24579b = lazy2;
        this.f24580c = lazy3;
        this.f24581d = lazy4;
        this.f24582e = lazy5;
    }

    private OnMapReadyDelegateCallback m28017a(E e, SearchResultsSeeMoreFeedUnit searchResultsSeeMoreFeedUnit, List<LatLng> list, LatLngBounds latLngBounds) {
        final E e2 = e;
        final SearchResultsSeeMoreFeedUnit searchResultsSeeMoreFeedUnit2 = searchResultsSeeMoreFeedUnit;
        final List<LatLng> list2 = list;
        final LatLngBounds latLngBounds2 = latLngBounds;
        return new OnMapReadyDelegateCallback(this) {
            final /* synthetic */ SearchResultsFbMapViewDelegatePartDefinition f24572e;

            /* compiled from: PageView not attached to controller */
            class C25961 implements OnMarkerClickListener {
                final /* synthetic */ C25981 f24566a;

                C25961(C25981 c25981) {
                    this.f24566a = c25981;
                }

                public final boolean m28014a(MarkerDelegate markerDelegate) {
                    SearchResultsFbMapViewDelegatePartDefinition.m28020a(this.f24566a.f24572e, e2, searchResultsSeeMoreFeedUnit2);
                    return true;
                }
            }

            /* compiled from: PageView not attached to controller */
            class C25972 implements OnMapClickListener {
                final /* synthetic */ C25981 f24567a;

                C25972(C25981 c25981) {
                    this.f24567a = c25981;
                }

                public final void m28015a() {
                    SearchResultsFbMapViewDelegatePartDefinition.m28020a(this.f24567a.f24572e, e2, searchResultsSeeMoreFeedUnit2);
                }
            }

            public final void m28016a(MapDelegate mapDelegate) {
                CameraUpdateDelegate a;
                BitmapDescriptor a2 = BitmapDescriptorFactory.a(2130841143);
                mapDelegate.a();
                mapDelegate.a(((QeAccessor) this.f24572e.f24579b.get()).a(ExperimentsForSearchAbTestModule.Z, false));
                mapDelegate.a(new C25961(this));
                mapDelegate.a(new C25972(this));
                mapDelegate.c().c(false);
                mapDelegate.c().b(false);
                mapDelegate.c().a(false);
                for (LatLng latLng : list2) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.b = latLng;
                    MarkerOptions markerOptions2 = markerOptions;
                    markerOptions2.c = a2;
                    mapDelegate.a(markerOptions2.a(0.5f, 0.5f));
                }
                if (list2.size() == 1) {
                    a = CameraUpdateFactoryDelegate.a(new CameraPosition((LatLng) list2.get(0), 11.0f, 90.0f, 0.0f));
                } else {
                    a = CameraUpdateFactoryDelegate.a(latLngBounds2, ((Resources) this.f24572e.f24578a.get()).getDimensionPixelOffset(2131432648) + ((Resources) this.f24572e.f24578a.get()).getDimensionPixelOffset(2131432649));
                }
                mapDelegate.a(a);
            }
        };
    }

    public static void m28020a(SearchResultsFbMapViewDelegatePartDefinition searchResultsFbMapViewDelegatePartDefinition, HasContext hasContext, SearchResultsSeeMoreFeedUnit searchResultsSeeMoreFeedUnit) {
        GraphQLGraphSearchResultRole k;
        SearchResultsIntentBuilder searchResultsIntentBuilder = (SearchResultsIntentBuilder) searchResultsFbMapViewDelegatePartDefinition.f24581d.get();
        GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle = GraphQLGraphSearchResultsDisplayStyle.PLACES;
        String str = (String) searchResultsSeeMoreFeedUnit.mo1329f().get();
        String str2 = (String) searchResultsSeeMoreFeedUnit.mo1330m().get();
        String str3 = ((HasSearchResultsContext) hasContext).mo1248s().f23382q;
        SearchResultsSource searchResultsSource = SearchResultsSource.x;
        if (searchResultsSeeMoreFeedUnit instanceof SearchResultsFeedImpressionTrackable) {
            k = ((SearchResultsFeedImpressionTrackable) searchResultsSeeMoreFeedUnit).mo1321k();
        } else {
            k = null;
        }
        ((SecureContextHelper) searchResultsFbMapViewDelegatePartDefinition.f24582e.get()).a(searchResultsIntentBuilder.a(graphQLGraphSearchResultsDisplayStyle, str, str2, str3, searchResultsSource, k, ((HasSearchResultsContext) hasContext).mo1248s().f23369d), hasContext.getContext());
        SearchResultsLogger searchResultsLogger = (SearchResultsLogger) searchResultsFbMapViewDelegatePartDefinition.f24580c.get();
        HoneyClientEvent a = SearchResultsLogger.m25459a(Event.PLACE_MAP_INTERACTION, ((HasSearchResultsContext) hasContext).mo1248s());
        searchResultsLogger.f21958c.a(a);
        if (BLog.b(3)) {
            String str4 = a.d;
            a.u();
        }
    }

    private State m28018a(SearchResultsCollectionUnit<GraphQLNode> searchResultsCollectionUnit, E e) {
        Builder a = LatLngBounds.a();
        List linkedList = new LinkedList();
        ImmutableList immutableList = searchResultsCollectionUnit.f23463d;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLLocation er = ((GraphQLNode) immutableList.get(i)).er();
            if (er != null) {
                LatLng latLng = new LatLng(er.a(), er.b());
                linkedList.add(latLng);
                a.a(latLng);
            }
        }
        return new State(m28017a((HasContext) e, (SearchResultsSeeMoreFeedUnit) searchResultsCollectionUnit, linkedList, a.a()));
    }
}
