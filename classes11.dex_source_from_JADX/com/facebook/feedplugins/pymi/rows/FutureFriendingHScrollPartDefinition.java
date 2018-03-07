package com.facebook.feedplugins.pymi.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
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
import com.facebook.feedplugins.pymi.fetcher.PeopleYouMayInviteFeedUnitFetcher;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;
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
/* compiled from: cluster_tapped_to_open_places_list */
public class FutureFriendingHScrollPartDefinition<E extends HasContext & HasInvalidate & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLPeopleYouMayInviteFeedUnit>, Void, E, HScrollRecyclerView> {
    private static FutureFriendingHScrollPartDefinition f8744h;
    private static final Object f8745i = new Object();
    private final BackgroundPartDefinition f8746a;
    public final FeedLoggingViewportEventListener f8747b;
    public final PeopleYouMayInviteFeedUnitFetcher f8748c;
    public final FutureFriendingPagePartDefinition<E> f8749d;
    private final PageStyleFactory f8750e;
    private final PageSwitcherPartDefinition f8751f;
    private final PersistentRecyclerPartDefinition<Object, E> f8752g;

    private static FutureFriendingHScrollPartDefinition m9534b(InjectorLike injectorLike) {
        return new FutureFriendingHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), PeopleYouMayInviteFeedUnitFetcher.m9507a(injectorLike), FutureFriendingPagePartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PageSwitcherPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike));
    }

    public final Object m9536a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit = (GraphQLPeopleYouMayInviteFeedUnit) feedProps.a;
        final Controller controller = new Controller();
        subParts.a(this.f8746a, new StylingData(feedProps, PageStyle.a));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f8752g;
        PageStyle a = this.f8750e.a(308.0f, PageStyle.a, true);
        int ac_ = graphQLPeopleYouMayInviteFeedUnit.ac_();
        final ImmutableList r = graphQLPeopleYouMayInviteFeedUnit.r();
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new SimpleCallbacks<E>(this) {
            final /* synthetic */ FutureFriendingHScrollPartDefinition f8743d;

            public final void m9531a(PageSubParts<E> pageSubParts) {
                int size = r.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.a(this.f8743d.f8749d, new FutureFriendingPagePartDefinition$Props(graphQLPeopleYouMayInviteFeedUnit, (GraphQLPeopleYouMayInviteFeedUnitContactsEdge) r.get(i), controller));
                }
            }

            public final void m9532c(int i) {
                this.f8743d.f8747b.a(graphQLPeopleYouMayInviteFeedUnit, i);
                VisibleItemHelper.a(graphQLPeopleYouMayInviteFeedUnit, r, i);
                this.f8743d.f8748c.m9511a(graphQLPeopleYouMayInviteFeedUnit);
            }
        }, graphQLPeopleYouMayInviteFeedUnit.g(), graphQLPeopleYouMayInviteFeedUnit));
        subParts.a(this.f8751f, controller);
        return null;
    }

    @Inject
    public FutureFriendingHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, FeedLoggingViewportEventListener feedLoggingViewportEventListener, PeopleYouMayInviteFeedUnitFetcher peopleYouMayInviteFeedUnitFetcher, FutureFriendingPagePartDefinition futureFriendingPagePartDefinition, PageStyleFactory pageStyleFactory, PageSwitcherPartDefinition pageSwitcherPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition) {
        this.f8746a = backgroundPartDefinition;
        this.f8747b = feedLoggingViewportEventListener;
        this.f8748c = peopleYouMayInviteFeedUnitFetcher;
        this.f8749d = futureFriendingPagePartDefinition;
        this.f8750e = pageStyleFactory;
        this.f8751f = pageSwitcherPartDefinition;
        this.f8752g = persistentRecyclerPartDefinition;
    }

    public static FutureFriendingHScrollPartDefinition m9533a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FutureFriendingHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8745i) {
                FutureFriendingHScrollPartDefinition futureFriendingHScrollPartDefinition;
                if (a2 != null) {
                    futureFriendingHScrollPartDefinition = (FutureFriendingHScrollPartDefinition) a2.a(f8745i);
                } else {
                    futureFriendingHScrollPartDefinition = f8744h;
                }
                if (futureFriendingHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9534b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8745i, b3);
                        } else {
                            f8744h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = futureFriendingHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m9537a(Object obj) {
        return true;
    }

    public final ViewType<HScrollRecyclerView> m9535a() {
        return HScrollRecyclerViewRowType.a;
    }
}
