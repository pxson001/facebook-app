package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.util.TypedValue;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.model.SearchSpotlightCardUnit;
import com.facebook.search.model.SearchSpotlightCollectionUnit;
import com.facebook.search.model.SearchSpotlightIntroUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.results.rows.SearchBackgroundPartDefinition;
import com.facebook.ultralight.Inject;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;

@ContextScoped
/* compiled from: videoHome */
public class SearchSpotlightHScrollRecyclerPartDefinition<E extends HasPersistentState & HasPositionInformation & HasContext> extends MultiRowSinglePartDefinition<SearchSpotlightCollectionUnit, Void, E, HScrollRecyclerView> {
    private static SearchSpotlightHScrollRecyclerPartDefinition f457j;
    private static final Object f458k = new Object();
    public final Context f459a;
    private final SearchBackgroundPartDefinition f460b;
    private final PersistentRecyclerPartDefinition f461c;
    public final HScrollSearchSpotlightCardPagePartDefinition f462d;
    public final HScrollSearchSpotlightIntroPagePartDefinition f463e;
    public final SearchAwarenessLogger f464f;
    public final PageStyleFactory f465g;
    public final ScreenUtil f466h;
    private final GatekeeperStoreImpl f467i;

    private static SearchSpotlightHScrollRecyclerPartDefinition m568b(InjectorLike injectorLike) {
        return new SearchSpotlightHScrollRecyclerPartDefinition((Context) injectorLike.getInstance(Context.class), SearchBackgroundPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), HScrollSearchSpotlightCardPagePartDefinition.m538a(injectorLike), HScrollSearchSpotlightIntroPagePartDefinition.m545a(injectorLike), SearchAwarenessLogger.b(injectorLike), PageStyleFactory.b(injectorLike), ScreenUtil.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m570a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchSpotlightCollectionUnit searchSpotlightCollectionUnit = (SearchSpotlightCollectionUnit) obj;
        subParts.a(this.f460b, new StylingData(FeedProps.c(searchSpotlightCollectionUnit), PaddingStyle.a, Position.BOTTOM));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f461c;
        TypedValue typedValue = new TypedValue();
        this.f459a.getResources().getValue(2131431632, typedValue, true);
        subParts.a(persistentRecyclerPartDefinition, new Props(this.f465g.a((((float) SizeUtil.c(this.f459a, (float) Math.min(this.f466h.c(), this.f466h.d()))) * typedValue.getFloat()) + 8.0f, PageStyle.a, true), 0, new SimpleCallbacks<E>(this) {
            final /* synthetic */ SearchSpotlightHScrollRecyclerPartDefinition f456b;

            public final void m565a(PageSubParts<E> pageSubParts) {
                ImmutableList f = searchSpotlightCollectionUnit.f();
                int size = f.size();
                for (int i = 0; i < size; i++) {
                    TypeaheadUnit typeaheadUnit = (TypeaheadUnit) f.get(i);
                    if (typeaheadUnit instanceof SearchSpotlightCardUnit) {
                        pageSubParts.a(this.f456b.f462d, (SearchSpotlightCardUnit) typeaheadUnit);
                    } else if (typeaheadUnit instanceof SearchSpotlightIntroUnit) {
                        pageSubParts.a(this.f456b.f463e, (SearchSpotlightIntroUnit) typeaheadUnit);
                    }
                }
                if (!searchSpotlightCollectionUnit.f().isEmpty()) {
                    this.f456b.f464f.b(1);
                }
            }

            public final void m566c(int i) {
                this.f456b.f464f.b(i + 1);
            }
        }, searchSpotlightCollectionUnit.g(), searchSpotlightCollectionUnit));
        return null;
    }

    public static SearchSpotlightHScrollRecyclerPartDefinition m567a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchSpotlightHScrollRecyclerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f458k) {
                SearchSpotlightHScrollRecyclerPartDefinition searchSpotlightHScrollRecyclerPartDefinition;
                if (a2 != null) {
                    searchSpotlightHScrollRecyclerPartDefinition = (SearchSpotlightHScrollRecyclerPartDefinition) a2.a(f458k);
                } else {
                    searchSpotlightHScrollRecyclerPartDefinition = f457j;
                }
                if (searchSpotlightHScrollRecyclerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m568b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f458k, b3);
                        } else {
                            f457j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchSpotlightHScrollRecyclerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    private SearchSpotlightHScrollRecyclerPartDefinition(Context context, SearchBackgroundPartDefinition searchBackgroundPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, HScrollSearchSpotlightCardPagePartDefinition hScrollSearchSpotlightCardPagePartDefinition, HScrollSearchSpotlightIntroPagePartDefinition hScrollSearchSpotlightIntroPagePartDefinition, SearchAwarenessLogger searchAwarenessLogger, PageStyleFactory pageStyleFactory, ScreenUtil screenUtil, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f459a = context;
        this.f460b = searchBackgroundPartDefinition;
        this.f461c = persistentRecyclerPartDefinition;
        this.f462d = hScrollSearchSpotlightCardPagePartDefinition;
        this.f463e = hScrollSearchSpotlightIntroPagePartDefinition;
        this.f464f = searchAwarenessLogger;
        this.f465g = pageStyleFactory;
        this.f466h = screenUtil;
        this.f467i = gatekeeperStoreImpl;
    }

    public final boolean m571a(Object obj) {
        return this.f467i.a(SearchAbTestGatekeepers.y, false);
    }

    public final ViewType<HScrollRecyclerView> m569a() {
        return HScrollRecyclerViewRowType.a;
    }
}
