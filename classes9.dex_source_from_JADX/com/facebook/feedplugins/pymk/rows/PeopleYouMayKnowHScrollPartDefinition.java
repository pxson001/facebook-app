package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.pymk.ExperimentsForPymkModule;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.QPContextStateKey;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.QPPersistentState;
import com.facebook.feedplugins.pymk.PymkGatekeepers;
import com.facebook.feedplugins.pymk.fetcher.PaginatedPYMKFeedUnitFetcher;
import com.facebook.feedplugins.pymk.logging.PeopleYouMayKnowAnalyticsLogger;
import com.facebook.feedplugins.pymk.quickpromotion.QuickPromotionFeedPYMKController;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.HasFeedUnit;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TIME_LIMIT_REACHED_CANCELLED */
public class PeopleYouMayKnowHScrollPartDefinition<E extends HasPositionInformation & HasPersistentState & HasPrefetcher & HasInvalidate & HasContext & HasRowKey> extends MultiRowSinglePartDefinition<HScrollProps, Void, E, HScrollRecyclerView> {
    private static PeopleYouMayKnowHScrollPartDefinition f24800q;
    private static final Object f24801r = new Object();
    public final PeopleYouMayKnowAnalyticsLogger f24802a;
    private final BackgroundPartDefinition f24803b;
    public final PageStyleFactory f24804c;
    public final FeedLoggingViewportEventListener f24805d;
    public final PersonYouMayKnowPagePartDefinition f24806e;
    public final CCUPromoCardPartDefinition f24807f;
    public final PaginatedPYMKFeedUnitFetcher f24808g;
    private final PageSwitcherPartDefinition f24809h;
    public final PymkSeeAllPartDefinition f24810i;
    public final PymkLoadingPartDefinition f24811j;
    private final PersistentRecyclerPartDefinition<Object, E> f24812k;
    private final Resources f24813l;
    public final QeAccessor f24814m;
    private final GatekeeperStoreImpl f24815n;
    private final PymkGatekeepers f24816o;
    private final float f24817p;

    /* compiled from: TIME_LIMIT_REACHED_CANCELLED */
    public class HScrollProps implements HasFeedProps<GraphQLPaginatedPeopleYouMayKnowFeedUnit>, HasFeedUnit {
        public final FeedProps<GraphQLPaginatedPeopleYouMayKnowFeedUnit> f24798a;
        public final Controller f24799b;

        public HScrollProps(FeedProps<GraphQLPaginatedPeopleYouMayKnowFeedUnit> feedProps, Controller controller) {
            this.f24798a = feedProps;
            this.f24799b = controller;
        }

        public final FeedUnit m26623c() {
            return (FeedUnit) this.f24798a.a;
        }

        public final FeedProps<GraphQLPaginatedPeopleYouMayKnowFeedUnit> m26624f() {
            return this.f24798a;
        }
    }

    private static PeopleYouMayKnowHScrollPartDefinition m26629b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), PersonYouMayKnowPagePartDefinition.a(injectorLike), CCUPromoCardPartDefinition.a(injectorLike), PaginatedPYMKFeedUnitFetcher.m26577a(injectorLike), PageSwitcherPartDefinition.a(injectorLike), PymkSeeAllPartDefinition.a(injectorLike), PymkLoadingPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), PymkGatekeepers.m26572a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), PeopleYouMayKnowAnalyticsLogger.m26587a(injectorLike));
    }

    public final Object m26631a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        float f;
        HScrollProps hScrollProps = (HScrollProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        PaddingStyle paddingStyle = PageStyle.a;
        subParts.a(this.f24803b, new StylingData(hScrollProps.f24798a, paddingStyle));
        subParts.a(this.f24809h, hScrollProps.f24799b);
        if (this.f24816o.f24692a || this.f24816o.f24693b || this.f24816o.f24694c || this.f24816o.f24695d) {
            f = 304.0f;
        } else {
            f = 204.0f;
        }
        GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) hScrollProps.f24798a.a;
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f24812k;
        if (this.f24815n.a(656, false)) {
            f = this.f24817p;
        }
        subParts.a(persistentRecyclerPartDefinition, new Props(this.f24804c.a(f, paddingStyle), graphQLPaginatedPeopleYouMayKnowFeedUnit.ac_(), m26626a(graphQLPaginatedPeopleYouMayKnowFeedUnit, hScrollProps.f24799b, hasPositionInformation), graphQLPaginatedPeopleYouMayKnowFeedUnit.g(), graphQLPaginatedPeopleYouMayKnowFeedUnit));
        return null;
    }

    public static PeopleYouMayKnowHScrollPartDefinition m26627a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24801r) {
                PeopleYouMayKnowHScrollPartDefinition peopleYouMayKnowHScrollPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowHScrollPartDefinition = (PeopleYouMayKnowHScrollPartDefinition) a2.a(f24801r);
                } else {
                    peopleYouMayKnowHScrollPartDefinition = f24800q;
                }
                if (peopleYouMayKnowHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26629b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24801r, b3);
                        } else {
                            f24800q = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PeopleYouMayKnowHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, FeedLoggingViewportEventListener feedLoggingViewportEventListener, PersonYouMayKnowPagePartDefinition personYouMayKnowPagePartDefinition, CCUPromoCardPartDefinition cCUPromoCardPartDefinition, PaginatedPYMKFeedUnitFetcher paginatedPYMKFeedUnitFetcher, PageSwitcherPartDefinition pageSwitcherPartDefinition, PymkSeeAllPartDefinition pymkSeeAllPartDefinition, PymkLoadingPartDefinition pymkLoadingPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, Resources resources, GatekeeperStoreImpl gatekeeperStoreImpl, PymkGatekeepers pymkGatekeepers, QeAccessor qeAccessor, PeopleYouMayKnowAnalyticsLogger peopleYouMayKnowAnalyticsLogger) {
        this.f24803b = backgroundPartDefinition;
        this.f24804c = pageStyleFactory;
        this.f24805d = feedLoggingViewportEventListener;
        this.f24806e = personYouMayKnowPagePartDefinition;
        this.f24807f = cCUPromoCardPartDefinition;
        this.f24808g = paginatedPYMKFeedUnitFetcher;
        this.f24809h = pageSwitcherPartDefinition;
        this.f24810i = pymkSeeAllPartDefinition;
        this.f24811j = pymkLoadingPartDefinition;
        this.f24812k = persistentRecyclerPartDefinition;
        this.f24813l = resources;
        this.f24815n = gatekeeperStoreImpl;
        this.f24816o = pymkGatekeepers;
        this.f24814m = qeAccessor;
        this.f24802a = peopleYouMayKnowAnalyticsLogger;
        this.f24817p = m26625a(this.f24813l, this.f24816o.m26574a() ? 304.0f : 204.0f);
    }

    public final ViewType<HScrollRecyclerView> m26630a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m26632a(Object obj) {
        return true;
    }

    public static float m26625a(Resources resources, float f) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int a = displayMetrics.widthPixels - SizeUtil.a(resources, 8.0f);
        int a2 = SizeUtil.a(resources, f + 8.0f);
        int i = a % a2;
        if (((float) i) / ((float) a2) < 0.15f) {
            return ((float) SizeUtil.b(resources, ((float) a) / (((float) (a / a2)) + 0.15f))) - 8.0f;
        }
        if (((float) (a2 - i)) / ((float) a2) < 0.15f) {
            return ((float) SizeUtil.b(resources, ((float) a) / (((float) Math.ceil((double) (((float) a) / ((float) a2)))) - 0.15f))) - 8.0f;
        }
        return f;
    }

    private Callbacks<Object, E> m26626a(GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit, Controller controller, E e) {
        final ImmutableList a = ItemListFeedUnitImpl.a(graphQLPaginatedPeopleYouMayKnowFeedUnit);
        final GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit2 = graphQLPaginatedPeopleYouMayKnowFeedUnit;
        final Controller controller2 = controller;
        final E e2 = e;
        return new SimpleCallbacks<E>(this) {
            final /* synthetic */ PeopleYouMayKnowHScrollPartDefinition f24797e;

            public final void m26621a(PageSubParts<E> pageSubParts) {
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    PeopleYouMayKnowFeedUnitItem peopleYouMayKnowFeedUnitItem = (PeopleYouMayKnowFeedUnitItem) a.get(i);
                    PeopleYouMayKnowHScrollPartDefinition peopleYouMayKnowHScrollPartDefinition = this.f24797e;
                    GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = graphQLPaginatedPeopleYouMayKnowFeedUnit2;
                    int i2 = i + 1;
                    if (i2 == peopleYouMayKnowHScrollPartDefinition.f24814m.a(ExperimentsForPymkModule.f24680c, -1) && i2 <= graphQLPaginatedPeopleYouMayKnowFeedUnit.l().size() - 1) {
                        peopleYouMayKnowHScrollPartDefinition.f24802a.m26591b(i2);
                        pageSubParts.a(peopleYouMayKnowHScrollPartDefinition.f24807f, graphQLPaginatedPeopleYouMayKnowFeedUnit);
                    }
                    pageSubParts.a(this.f24797e.f24806e, new PersonYouMayKnowPagePartDefinition$Props(graphQLPaginatedPeopleYouMayKnowFeedUnit2, peopleYouMayKnowFeedUnitItem, controller2));
                }
                if (!a.isEmpty()) {
                    PaginatedPYMKFeedUnitFetcher paginatedPYMKFeedUnitFetcher = this.f24797e.f24808g;
                    if (PaginatedPYMKFeedUnitFetcher.m26578a(graphQLPaginatedPeopleYouMayKnowFeedUnit2)) {
                        pageSubParts.a(this.f24797e.f24811j, null);
                        return;
                    }
                }
                pageSubParts.a(this.f24797e.f24810i, null);
            }

            public final void m26622c(int i) {
                this.f24797e.f24805d.a(graphQLPaginatedPeopleYouMayKnowFeedUnit2, i);
                VisibleItemHelper.a(graphQLPaginatedPeopleYouMayKnowFeedUnit2, a, i);
                PeopleYouMayKnowHScrollPartDefinition peopleYouMayKnowHScrollPartDefinition = this.f24797e;
                GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = graphQLPaginatedPeopleYouMayKnowFeedUnit2;
                if (peopleYouMayKnowHScrollPartDefinition.f24808g.m26581a(graphQLPaginatedPeopleYouMayKnowFeedUnit, i)) {
                    if (PaginatedPYMKFeedUnitFetcher.m26578a(graphQLPaginatedPeopleYouMayKnowFeedUnit)) {
                        peopleYouMayKnowHScrollPartDefinition.f24808g.m26582b(graphQLPaginatedPeopleYouMayKnowFeedUnit);
                    } else {
                        peopleYouMayKnowHScrollPartDefinition.f24808g.m26583c(graphQLPaginatedPeopleYouMayKnowFeedUnit);
                    }
                }
                PeopleYouMayKnowHScrollPartDefinition.m26628a(this.f24797e, graphQLPaginatedPeopleYouMayKnowFeedUnit2, i, e2);
            }
        };
    }

    public static void m26628a(PeopleYouMayKnowHScrollPartDefinition peopleYouMayKnowHScrollPartDefinition, GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit, int i, HasPositionInformation hasPositionInformation) {
        if (i == peopleYouMayKnowHScrollPartDefinition.f24814m.a(ExperimentsForPymkModule.f24679b, -1) && i <= graphQLPaginatedPeopleYouMayKnowFeedUnit.l().size() - 2) {
            peopleYouMayKnowHScrollPartDefinition.f24802a.m26590a(i);
            QPContextStateKey qPContextStateKey = new QPContextStateKey(graphQLPaginatedPeopleYouMayKnowFeedUnit.g(), new QPPersistentState(true, QuickPromotionFeedPYMKController.b));
            ((HasPersistentState) hasPositionInformation).a(qPContextStateKey, graphQLPaginatedPeopleYouMayKnowFeedUnit);
            ((HasPersistentState) hasPositionInformation).a(qPContextStateKey, new QPPersistentState(true, QuickPromotionFeedPYMKController.b));
            ((HasInvalidate) hasPositionInformation).a(new Object[]{graphQLPaginatedPeopleYouMayKnowFeedUnit});
        }
    }
}
