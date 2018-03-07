package com.facebook.feedplugins.reviews.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.logging.impression.FeedUnitImpressionLogger;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feedplugins.reviews.rows.PlaceReviewItemPartDefinition.Props;
import com.facebook.feedplugins.reviews.views.PlaceReviewItemView;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnitItem;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: frame_rate_logging_only_drops */
public class PlaceReviewSingleItemPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLPlaceReviewFeedUnit>, Void, HasPositionInformation, PlaceReviewItemView> {
    private static PlaceReviewSingleItemPartDefinition f12996e;
    private static final Object f12997f = new Object();
    private final BackgroundPartDefinition f12998a;
    private final DefaultPaddingStyleResolver f12999b;
    public final FeedUnitImpressionLogger f13000c;
    private final PlaceReviewItemPartDefinition f13001d;

    private static PlaceReviewSingleItemPartDefinition m14715b(InjectorLike injectorLike) {
        return new PlaceReviewSingleItemPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), FeedUnitImpressionLogger.a(injectorLike), PlaceReviewItemPartDefinition.m14694a(injectorLike));
    }

    public final Object m14717a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit = (GraphQLPlaceReviewFeedUnit) feedProps.a;
        subParts.a(this.f12998a, new StylingData(feedProps, this.f12999b.h()));
        subParts.a(this.f13001d, new Props((GraphQLPlaceReviewFeedUnitItem) ItemListFeedUnitImpl.a(graphQLPlaceReviewFeedUnit).get(0), graphQLPlaceReviewFeedUnit, true));
        return null;
    }

    public final /* synthetic */ void m14718a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1315514797);
        this.f13000c.a((GraphQLPlaceReviewFeedUnit) ((FeedProps) obj).a, 0);
        Logger.a(8, EntryType.MARK_POP, -1995744413, a);
    }

    @Inject
    public PlaceReviewSingleItemPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, FeedUnitImpressionLogger feedUnitImpressionLogger, PlaceReviewItemPartDefinition placeReviewItemPartDefinition) {
        this.f12998a = backgroundPartDefinition;
        this.f12999b = defaultPaddingStyleResolver;
        this.f13000c = feedUnitImpressionLogger;
        this.f13001d = placeReviewItemPartDefinition;
    }

    public final ViewType m14716a() {
        return PlaceReviewItemView.f13002a;
    }

    public static boolean m14714a(FeedProps<GraphQLPlaceReviewFeedUnit> feedProps) {
        ImmutableList a = ItemListFeedUnitImpl.a((GraphQLPlaceReviewFeedUnit) feedProps.a);
        return a != null && a.size() == 1;
    }

    public static PlaceReviewSingleItemPartDefinition m14713a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlaceReviewSingleItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12997f) {
                PlaceReviewSingleItemPartDefinition placeReviewSingleItemPartDefinition;
                if (a2 != null) {
                    placeReviewSingleItemPartDefinition = (PlaceReviewSingleItemPartDefinition) a2.a(f12997f);
                } else {
                    placeReviewSingleItemPartDefinition = f12996e;
                }
                if (placeReviewSingleItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14715b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12997f, b3);
                        } else {
                            f12996e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = placeReviewSingleItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
