package com.facebook.feedplugins.reviews.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.logging.impression.FeedUnitImpressionLogger;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnitItem;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friendRecommendationsCount */
public class PlaceReviewHScrollPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLPlaceReviewFeedUnit>, Void, E, HScrollRecyclerView> {
    private static PlaceReviewHScrollPartDefinition f12949f;
    private static final Object f12950g = new Object();
    private final BackgroundPartDefinition f12951a;
    public final PlaceReviewPageItemPartDefinition f12952b;
    public final FeedUnitImpressionLogger f12953c;
    private final PersistentRecyclerPartDefinition<PlaceReviewPageItemPartDefinition$Props, E> f12954d;
    private final PageStyleFactory f12955e;

    private static PlaceReviewHScrollPartDefinition m14681b(InjectorLike injectorLike) {
        return new PlaceReviewHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), PlaceReviewPageItemPartDefinition.a(injectorLike), FeedUnitImpressionLogger.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike));
    }

    public final Object m14683a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit = (GraphQLPlaceReviewFeedUnit) feedProps.a;
        subParts.a(this.f12951a, new StylingData(feedProps, PageStyle.a));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f12954d;
        PageStyle a = this.f12955e.a(275.0f, PageStyle.a, true);
        int ac_ = graphQLPlaceReviewFeedUnit.ac_();
        final ImmutableList a2 = ItemListFeedUnitImpl.a(graphQLPlaceReviewFeedUnit);
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new Callbacks<PlaceReviewPageItemPartDefinition$Props, E>(this) {
            final /* synthetic */ PlaceReviewHScrollPartDefinition f12948c;

            public final SinglePartDefinitionWithViewType<PlaceReviewPageItemPartDefinition$Props, ?, ? super E, ?> m14676a(int i) {
                return this.f12948c.f12952b;
            }

            public final Object m14677b(int i) {
                return new PlaceReviewPageItemPartDefinition$Props((GraphQLPlaceReviewFeedUnitItem) a2.get(i), graphQLPlaceReviewFeedUnit);
            }

            public final void m14678c(int i) {
                VisibleItemHelper.a(graphQLPlaceReviewFeedUnit, a2, i);
                this.f12948c.f12953c.a(graphQLPlaceReviewFeedUnit, i);
            }

            public final int m14675a() {
                return a2.size();
            }
        }, graphQLPlaceReviewFeedUnit.g(), graphQLPlaceReviewFeedUnit));
        return null;
    }

    public final /* synthetic */ void m14684a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 67054031);
        GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit = (GraphQLPlaceReviewFeedUnit) ((FeedProps) obj).a;
        this.f12953c.a(graphQLPlaceReviewFeedUnit, graphQLPlaceReviewFeedUnit.ac_());
        Logger.a(8, EntryType.MARK_POP, -641920556, a);
    }

    @Inject
    public PlaceReviewHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PlaceReviewPageItemPartDefinition placeReviewPageItemPartDefinition, FeedUnitImpressionLogger feedUnitImpressionLogger, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PageStyleFactory pageStyleFactory) {
        this.f12951a = backgroundPartDefinition;
        this.f12952b = placeReviewPageItemPartDefinition;
        this.f12953c = feedUnitImpressionLogger;
        this.f12954d = persistentRecyclerPartDefinition;
        this.f12955e = pageStyleFactory;
    }

    public static PlaceReviewHScrollPartDefinition m14679a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlaceReviewHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12950g) {
                PlaceReviewHScrollPartDefinition placeReviewHScrollPartDefinition;
                if (a2 != null) {
                    placeReviewHScrollPartDefinition = (PlaceReviewHScrollPartDefinition) a2.a(f12950g);
                } else {
                    placeReviewHScrollPartDefinition = f12949f;
                }
                if (placeReviewHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14681b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12950g, b3);
                        } else {
                            f12949f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = placeReviewHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m14682a() {
        return HScrollRecyclerViewRowType.a;
    }

    public static boolean m14680a(FeedProps<GraphQLPlaceReviewFeedUnit> feedProps) {
        ImmutableList a = ItemListFeedUnitImpl.a((GraphQLPlaceReviewFeedUnit) feedProps.a);
        return (a == null || a.isEmpty()) ? false : true;
    }
}
