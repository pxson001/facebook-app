package com.facebook.feedplugins.sgny.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.sgny.fetcher.SaleGroupsNearYouFeedUnitFetcher;
import com.facebook.feedplugins.sgny.views.SaleGroupsNearYouPageView;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsEdge;
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
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: buildDirectProxy */
public class SaleGroupsNearYouRecyclerViewPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<? extends GraphQLSaleGroupsNearYouFeedUnit>, Void, E, HScrollRecyclerView> {
    public static final PagerViewType<SaleGroupsNearYouPageView> f9423a = new C11261();
    private static SaleGroupsNearYouRecyclerViewPartDefinition f9424h;
    private static final Object f9425i = new Object();
    private final BackgroundPartDefinition f9426b;
    private final PageStyleFactory f9427c;
    private final PersistentRecyclerPartDefinition<Object, E> f9428d;
    public final FeedLoggingViewportEventListener f9429e;
    public final SaleGroupsNearYouPagePartDefinition f9430f;
    public final SaleGroupsNearYouFeedUnitFetcher f9431g;

    /* compiled from: buildDirectProxy */
    final class C11261 implements PagerViewType<SaleGroupsNearYouPageView> {
        C11261() {
        }

        public final Class m9989a() {
            return SaleGroupsNearYouPageView.class;
        }

        public final View m9988a(Context context) {
            return new SaleGroupsNearYouPageView(context);
        }
    }

    private static SaleGroupsNearYouRecyclerViewPartDefinition m9993b(InjectorLike injectorLike) {
        return new SaleGroupsNearYouRecyclerViewPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), SaleGroupsNearYouPagePartDefinition.a(injectorLike), SaleGroupsNearYouFeedUnitFetcher.m9960a(injectorLike));
    }

    public final Object m9995a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit = (GraphQLSaleGroupsNearYouFeedUnit) feedProps.a;
        PaddingStyle paddingStyle = PageStyle.a;
        subParts.a(this.f9426b, new StylingData(feedProps, paddingStyle));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f9428d;
        PageStyle a = this.f9427c.a(282.0f, paddingStyle, true);
        int ac_ = graphQLSaleGroupsNearYouFeedUnit.ac_();
        final ImmutableList l = graphQLSaleGroupsNearYouFeedUnit.l();
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new SimpleCallbacks<E>(this) {
            final /* synthetic */ SaleGroupsNearYouRecyclerViewPartDefinition f9422c;

            public final void m9990a(PageSubParts<E> pageSubParts) {
                for (GraphQLSaleGroupsNearYouFeedUnitGroupsEdge saleGroupsNearYouPagePartDefinition$Props : l) {
                    pageSubParts.a(this.f9422c.f9430f, new SaleGroupsNearYouPagePartDefinition$Props(graphQLSaleGroupsNearYouFeedUnit, saleGroupsNearYouPagePartDefinition$Props));
                }
            }

            public final void m9991c(int i) {
                if (graphQLSaleGroupsNearYouFeedUnit instanceof GraphQLSaleGroupsNearYouFeedUnit) {
                    this.f9422c.f9429e.a(graphQLSaleGroupsNearYouFeedUnit, i);
                    SaleGroupsNearYouRecyclerViewPartDefinition saleGroupsNearYouRecyclerViewPartDefinition = this.f9422c;
                    GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit = graphQLSaleGroupsNearYouFeedUnit;
                    if (saleGroupsNearYouRecyclerViewPartDefinition.f9431g.m9964a(graphQLSaleGroupsNearYouFeedUnit, i) && SaleGroupsNearYouFeedUnitFetcher.m9961a(graphQLSaleGroupsNearYouFeedUnit)) {
                        saleGroupsNearYouRecyclerViewPartDefinition.f9431g.m9965b(graphQLSaleGroupsNearYouFeedUnit);
                    }
                    VisibleItemHelper.a(graphQLSaleGroupsNearYouFeedUnit, l, i);
                }
            }
        }, graphQLSaleGroupsNearYouFeedUnit.g(), graphQLSaleGroupsNearYouFeedUnit));
        return null;
    }

    public static SaleGroupsNearYouRecyclerViewPartDefinition m9992a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SaleGroupsNearYouRecyclerViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9425i) {
                SaleGroupsNearYouRecyclerViewPartDefinition saleGroupsNearYouRecyclerViewPartDefinition;
                if (a2 != null) {
                    saleGroupsNearYouRecyclerViewPartDefinition = (SaleGroupsNearYouRecyclerViewPartDefinition) a2.a(f9425i);
                } else {
                    saleGroupsNearYouRecyclerViewPartDefinition = f9424h;
                }
                if (saleGroupsNearYouRecyclerViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9993b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9425i, b3);
                        } else {
                            f9424h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = saleGroupsNearYouRecyclerViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SaleGroupsNearYouRecyclerViewPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, FeedLoggingViewportEventListener feedLoggingViewportEventListener, SaleGroupsNearYouPagePartDefinition saleGroupsNearYouPagePartDefinition, SaleGroupsNearYouFeedUnitFetcher saleGroupsNearYouFeedUnitFetcher) {
        this.f9426b = backgroundPartDefinition;
        this.f9427c = pageStyleFactory;
        this.f9428d = persistentRecyclerPartDefinition;
        this.f9429e = feedLoggingViewportEventListener;
        this.f9430f = saleGroupsNearYouPagePartDefinition;
        this.f9431g = saleGroupsNearYouFeedUnitFetcher;
    }

    public final ViewType m9994a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m9996a(Object obj) {
        return true;
    }
}
