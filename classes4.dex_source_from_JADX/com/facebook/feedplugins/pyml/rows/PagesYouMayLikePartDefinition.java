package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitPagerIndicatorPartDefinition;
import com.facebook.feedplugins.pyml.rows.components.PagesYouMayLikeComponentPartDefinition;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.ItemListFeedUnitHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: onInfo MEDIA_INFO_BAD_INTERLEAVING */
public class PagesYouMayLikePartDefinition<E extends HasFeedListType & HasPositionInformation & HasMenuButtonProvider & HasPersistentState & HasPrefetcher & HasRowKey & HasContext & HasIsAsync> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLPYMLWithLargeImageFeedUnit>, Void, E> {
    private static PagesYouMayLikePartDefinition f6183e;
    private static final Object f6184f = new Object();
    private final PagesYouMayLikeViewPagerPartDefinition<E> f6185a;
    private final PagesYouMayLikeRecyclerViewPartDefinition<E> f6186b;
    private final PagesYouMayLikeComponentPartDefinition<E> f6187c;
    private final FeedUnitPagerIndicatorPartDefinition<GraphQLPYMLWithLargeImageFeedUnit, E> f6188d;

    private static PagesYouMayLikePartDefinition m6662b(InjectorLike injectorLike) {
        return new PagesYouMayLikePartDefinition(PagesYouMayLikeViewPagerPartDefinition.m6665a(injectorLike), PagesYouMayLikeRecyclerViewPartDefinition.m6714a(injectorLike), PagesYouMayLikeComponentPartDefinition.m6720a(injectorLike), FeedUnitPagerIndicatorPartDefinition.m6736a(injectorLike));
    }

    public final Object m6663a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit = (GraphQLPYMLWithLargeImageFeedUnit) feedProps.a;
        FeedUnitAndChangePageListener feedUnitAndChangePageListener = new FeedUnitAndChangePageListener(feedProps, ItemListFeedUnitHelper.m6752a(graphQLPYMLWithLargeImageFeedUnit) ? null : FeedUnitPagerIndicatorPartDefinition.m6738b());
        SubPartsSelector.a(baseMultiRowSubParts, this.f6187c, feedUnitAndChangePageListener).a(this.f6186b, feedUnitAndChangePageListener).a(this.f6185a, feedUnitAndChangePageListener);
        if (!ItemListFeedUnitHelper.m6752a(graphQLPYMLWithLargeImageFeedUnit)) {
            baseMultiRowSubParts.a(this.f6188d, feedUnitAndChangePageListener);
        }
        return null;
    }

    @Inject
    public PagesYouMayLikePartDefinition(PagesYouMayLikeViewPagerPartDefinition pagesYouMayLikeViewPagerPartDefinition, PagesYouMayLikeRecyclerViewPartDefinition pagesYouMayLikeRecyclerViewPartDefinition, PagesYouMayLikeComponentPartDefinition pagesYouMayLikeComponentPartDefinition, FeedUnitPagerIndicatorPartDefinition feedUnitPagerIndicatorPartDefinition) {
        this.f6188d = feedUnitPagerIndicatorPartDefinition;
        this.f6185a = pagesYouMayLikeViewPagerPartDefinition;
        this.f6187c = pagesYouMayLikeComponentPartDefinition;
        this.f6186b = pagesYouMayLikeRecyclerViewPartDefinition;
    }

    public static PagesYouMayLikePartDefinition m6661a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6184f) {
                PagesYouMayLikePartDefinition pagesYouMayLikePartDefinition;
                if (a2 != null) {
                    pagesYouMayLikePartDefinition = (PagesYouMayLikePartDefinition) a2.a(f6184f);
                } else {
                    pagesYouMayLikePartDefinition = f6183e;
                }
                if (pagesYouMayLikePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6662b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6184f, b3);
                        } else {
                            f6183e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m6664a(Object obj) {
        return true;
    }
}
