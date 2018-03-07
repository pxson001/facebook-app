package com.facebook.feedplugins.nearbyfriends.rows.friendslocations;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
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
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.nearbyfriends.rows.ui.FriendsLocationsPageView;
import com.facebook.feedplugins.nearbyfriends.rows.util.FriendsNearbyFeedUnitAnalyticsLogger;
import com.facebook.graphql.enums.GraphQLFriendsLocationsFeedType;
import com.facebook.graphql.model.GraphQLFriendLocationFeedUnitItem;
import com.facebook.graphql.model.GraphQLFriendsLocationsFeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: com.facebook.katana.activity.codegenerator.CodeGeneratorActivity */
public class FriendsLocationHScrollPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLFriendsLocationsFeedUnit>, Void, E, HScrollRecyclerView> {
    public static final PagerViewType<FriendsLocationsPageView> f8427a = new C10411();
    private static FriendsLocationHScrollPartDefinition f8428k;
    private static final Object f8429l = new Object();
    private final BackgroundPartDefinition f8430b;
    public final PageStyleFactory f8431c;
    private final PersistentRecyclerPartDefinition<FriendsNearbyItemPartDefinition$Props, E> f8432d;
    public final FeedLoggingViewportEventListener f8433e;
    public final FriendsNearbyItemPartDefinition f8434f;
    public final FriendsLocationPulseItemPartDefinition f8435g;
    public final FriendsNearbyFeedUnitAnalyticsLogger f8436h;
    public final Context f8437i;
    public final FeedRenderUtils f8438j;

    /* compiled from: com.facebook.katana.activity.codegenerator.CodeGeneratorActivity */
    final class C10411 implements PagerViewType<FriendsLocationsPageView> {
        C10411() {
        }

        public final Class m9338a() {
            return FriendsLocationsPageView.class;
        }

        public final View m9337a(Context context) {
            return new FriendsLocationsPageView(context);
        }
    }

    private static FriendsLocationHScrollPartDefinition m9345b(InjectorLike injectorLike) {
        return new FriendsLocationHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), FriendsNearbyItemPartDefinition.a(injectorLike), FriendsLocationPulseItemPartDefinition.m9353a(injectorLike), FriendsNearbyFeedUnitAnalyticsLogger.m9411b(injectorLike), (Context) injectorLike.getInstance(Context.class), FeedRenderUtils.a(injectorLike));
    }

    public final Object m9347a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PageStyle a;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit = (GraphQLFriendsLocationsFeedUnit) feedProps.a;
        subParts.a(this.f8430b, new StylingData(feedProps, PageStyle.a));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f8432d;
        if (ScrollableItemListFeedUnitImpl.a(graphQLFriendsLocationsFeedUnit).size() == 1) {
            a = PageStyle.a(SizeUtil.c(this.f8437i, (float) this.f8438j.a()) - 16, false, true);
        } else {
            a = this.f8431c.a((graphQLFriendsLocationsFeedUnit.u() == GraphQLFriendsLocationsFeedType.PULSE ? 304.0f : 234.0f) + 8.0f, PageStyle.a, true);
        }
        subParts.a(persistentRecyclerPartDefinition, new Props(a, graphQLFriendsLocationsFeedUnit.ac_(), m9344b(graphQLFriendsLocationsFeedUnit), graphQLFriendsLocationsFeedUnit.g(), graphQLFriendsLocationsFeedUnit));
        return null;
    }

    public static FriendsLocationHScrollPartDefinition m9343a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8429l) {
                FriendsLocationHScrollPartDefinition friendsLocationHScrollPartDefinition;
                if (a2 != null) {
                    friendsLocationHScrollPartDefinition = (FriendsLocationHScrollPartDefinition) a2.a(f8429l);
                } else {
                    friendsLocationHScrollPartDefinition = f8428k;
                }
                if (friendsLocationHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9345b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8429l, b3);
                        } else {
                            f8428k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsLocationHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FriendsLocationHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, FeedLoggingViewportEventListener feedLoggingViewportEventListener, FriendsNearbyItemPartDefinition friendsNearbyItemPartDefinition, FriendsLocationPulseItemPartDefinition friendsLocationPulseItemPartDefinition, FriendsNearbyFeedUnitAnalyticsLogger friendsNearbyFeedUnitAnalyticsLogger, Context context, FeedRenderUtils feedRenderUtils) {
        this.f8430b = backgroundPartDefinition;
        this.f8431c = pageStyleFactory;
        this.f8432d = persistentRecyclerPartDefinition;
        this.f8433e = feedLoggingViewportEventListener;
        this.f8434f = friendsNearbyItemPartDefinition;
        this.f8435g = friendsLocationPulseItemPartDefinition;
        this.f8436h = friendsNearbyFeedUnitAnalyticsLogger;
        this.f8437i = context;
        this.f8438j = feedRenderUtils;
    }

    public final ViewType m9346a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m9348a(Object obj) {
        return true;
    }

    private Callbacks<FriendsNearbyItemPartDefinition$Props, E> m9344b(final GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit) {
        final ImmutableList a = ScrollableItemListFeedUnitImpl.a(graphQLFriendsLocationsFeedUnit);
        return new Callbacks<FriendsNearbyItemPartDefinition$Props, E>(this) {
            final /* synthetic */ FriendsLocationHScrollPartDefinition f8425c;
            private int f8426d = 0;

            public final SinglePartDefinitionWithViewType<FriendsNearbyItemPartDefinition$Props, ?, ? super E, ?> m9340a(int i) {
                return graphQLFriendsLocationsFeedUnit.u() == GraphQLFriendsLocationsFeedType.PULSE ? this.f8425c.f8435g : this.f8425c.f8434f;
            }

            public final Object m9341b(int i) {
                return new FriendsNearbyItemPartDefinition$Props(graphQLFriendsLocationsFeedUnit, (GraphQLFriendLocationFeedUnitItem) a.get(i));
            }

            public final void m9342c(int i) {
                this.f8425c.f8433e.a(graphQLFriendsLocationsFeedUnit, i);
                VisibleItemHelper.a(graphQLFriendsLocationsFeedUnit, a, i);
                this.f8425c.f8436h.m9414a(graphQLFriendsLocationsFeedUnit, i > this.f8426d);
                this.f8426d = i;
                if (i >= m9339a() - 1) {
                    this.f8425c.f8436h.m9416b(graphQLFriendsLocationsFeedUnit);
                }
            }

            public final int m9339a() {
                return a.size();
            }
        };
    }
}
