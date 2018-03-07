package com.facebook.search.results.rows.sections.local;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageNewLikesInteractionSequence */
public class SearchResultsPlacesMapPartDefinition<E extends HasContext & HasPositionInformation & HasSearchResultPosition & HasSearchResultsContext> extends MultiRowSinglePartDefinition<SearchResultsCollectionUnit<GraphQLNode>, Void, E, CustomFrameLayout> {
    public static final ViewType<CustomFrameLayout> f24609a = new C26011();
    private static SearchResultsPlacesMapPartDefinition f24610d;
    private static final Object f24611e = new Object();
    private final GatekeeperStoreImpl f24612b;
    private final SearchResultsFbMapViewDelegatePartDefinition f24613c;

    /* compiled from: PageNewLikesInteractionSequence */
    final class C26011 extends ViewType<CustomFrameLayout> {
        C26011() {
        }

        public final View m28033a(Context context) {
            CustomFrameLayout customFrameLayout = (CustomFrameLayout) LayoutInflater.from(context).inflate(2130906265, null);
            ((FbMapViewDelegate) customFrameLayout.findViewById(2131566015)).a(null);
            return customFrameLayout;
        }
    }

    private static SearchResultsPlacesMapPartDefinition m28035b(InjectorLike injectorLike) {
        return new SearchResultsPlacesMapPartDefinition(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), SearchResultsFbMapViewDelegatePartDefinition.m28019a(injectorLike));
    }

    public final Object m28037a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131566015, this.f24613c, (SearchResultsCollectionUnit) obj);
        return null;
    }

    public final boolean m28038a(Object obj) {
        if (((SearchResultsCollectionUnit) obj).f23463d.isEmpty() || !this.f24612b.a(408, false)) {
            return false;
        }
        return true;
    }

    public static SearchResultsPlacesMapPartDefinition m28034a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsPlacesMapPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24611e) {
                SearchResultsPlacesMapPartDefinition searchResultsPlacesMapPartDefinition;
                if (a2 != null) {
                    searchResultsPlacesMapPartDefinition = (SearchResultsPlacesMapPartDefinition) a2.a(f24611e);
                } else {
                    searchResultsPlacesMapPartDefinition = f24610d;
                }
                if (searchResultsPlacesMapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28035b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24611e, b3);
                        } else {
                            f24610d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsPlacesMapPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsPlacesMapPartDefinition(GatekeeperStoreImpl gatekeeperStoreImpl, SearchResultsFbMapViewDelegatePartDefinition searchResultsFbMapViewDelegatePartDefinition) {
        this.f24612b = gatekeeperStoreImpl;
        this.f24613c = searchResultsFbMapViewDelegatePartDefinition;
    }

    public final ViewType<CustomFrameLayout> m28036a() {
        return f24609a;
    }
}
