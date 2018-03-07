package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLQuickPromotionPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
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
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THREAD_NOT_MARKED_READ */
public class QuickPromotionPeopleYouMayKnowHScrollPartDefinition<E extends HasPositionInformation & HasPersistentState & HasPrefetcher & HasInvalidate & HasContext & HasRowKey> extends MultiRowSinglePartDefinition<FeedProps<GraphQLQuickPromotionPeopleYouMayKnowFeedUnit>, Void, E, HScrollRecyclerView> {
    private static QuickPromotionPeopleYouMayKnowHScrollPartDefinition f24858i;
    private static final Object f24859j = new Object();
    private final BackgroundPartDefinition f24860a;
    private final PageStyleFactory f24861b;
    public final FeedLoggingViewportEventListener f24862c;
    private final GatekeeperStoreImpl f24863d;
    private final PageSwitcherPartDefinition f24864e;
    public final PymkSeeAllPartDefinition f24865f;
    private final PersistentRecyclerPartDefinition<Object, E> f24866g;
    public final PersonYouMayKnowPagePartDefinition f24867h;

    private static QuickPromotionPeopleYouMayKnowHScrollPartDefinition m26647b(InjectorLike injectorLike) {
        return new QuickPromotionPeopleYouMayKnowHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), PageSwitcherPartDefinition.a(injectorLike), PymkSeeAllPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PersonYouMayKnowPagePartDefinition.a(injectorLike));
    }

    public final Object m26649a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        PaddingStyle paddingStyle = PaddingStyle.a;
        final Controller controller = new Controller();
        final GraphQLQuickPromotionPeopleYouMayKnowFeedUnit graphQLQuickPromotionPeopleYouMayKnowFeedUnit = (GraphQLQuickPromotionPeopleYouMayKnowFeedUnit) feedProps.a;
        float f = this.f24863d.a(659, false) ? 304.0f : 204.0f;
        subParts.a(this.f24860a, new StylingData(feedProps, paddingStyle));
        subParts.a(this.f24864e, controller);
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f24866g;
        PageStyle a = this.f24861b.a(f, paddingStyle);
        int ac_ = graphQLQuickPromotionPeopleYouMayKnowFeedUnit.ac_();
        final ImmutableList a2 = ScrollableItemListFeedUnitImpl.a(graphQLQuickPromotionPeopleYouMayKnowFeedUnit);
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new SimpleCallbacks<E>(this) {
            final /* synthetic */ QuickPromotionPeopleYouMayKnowHScrollPartDefinition f24857d;

            public final void m26644a(PageSubParts<E> pageSubParts) {
                for (PeopleYouMayKnowFeedUnitItem personYouMayKnowPagePartDefinition$Props : a2) {
                    pageSubParts.a(this.f24857d.f24867h, new PersonYouMayKnowPagePartDefinition$Props(graphQLQuickPromotionPeopleYouMayKnowFeedUnit, personYouMayKnowPagePartDefinition$Props, controller));
                }
                if (a2.isEmpty()) {
                    pageSubParts.a(this.f24857d.f24865f, null);
                }
            }

            public final void m26645c(int i) {
                this.f24857d.f24862c.a(graphQLQuickPromotionPeopleYouMayKnowFeedUnit, i);
                VisibleItemHelper.a(graphQLQuickPromotionPeopleYouMayKnowFeedUnit, a2, i);
            }
        }, graphQLQuickPromotionPeopleYouMayKnowFeedUnit.g(), graphQLQuickPromotionPeopleYouMayKnowFeedUnit));
        return null;
    }

    public static QuickPromotionPeopleYouMayKnowHScrollPartDefinition m26646a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionPeopleYouMayKnowHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24859j) {
                QuickPromotionPeopleYouMayKnowHScrollPartDefinition quickPromotionPeopleYouMayKnowHScrollPartDefinition;
                if (a2 != null) {
                    quickPromotionPeopleYouMayKnowHScrollPartDefinition = (QuickPromotionPeopleYouMayKnowHScrollPartDefinition) a2.a(f24859j);
                } else {
                    quickPromotionPeopleYouMayKnowHScrollPartDefinition = f24858i;
                }
                if (quickPromotionPeopleYouMayKnowHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26647b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24859j, b3);
                        } else {
                            f24858i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionPeopleYouMayKnowHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public QuickPromotionPeopleYouMayKnowHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, FeedLoggingViewportEventListener feedLoggingViewportEventListener, GatekeeperStoreImpl gatekeeperStoreImpl, PageSwitcherPartDefinition pageSwitcherPartDefinition, PymkSeeAllPartDefinition pymkSeeAllPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PersonYouMayKnowPagePartDefinition personYouMayKnowPagePartDefinition) {
        this.f24860a = backgroundPartDefinition;
        this.f24861b = pageStyleFactory;
        this.f24862c = feedLoggingViewportEventListener;
        this.f24864e = pageSwitcherPartDefinition;
        this.f24865f = pymkSeeAllPartDefinition;
        this.f24866g = persistentRecyclerPartDefinition;
        this.f24867h = personYouMayKnowPagePartDefinition;
        this.f24863d = gatekeeperStoreImpl;
    }

    public final ViewType<HScrollRecyclerView> m26648a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m26650a(Object obj) {
        return true;
    }
}
