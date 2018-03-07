package com.facebook.feedplugins.pymi.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
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
import com.facebook.feedplugins.pymi.fetcher.PeopleYouMayInviteFeedUnitFetcher;
import com.facebook.feedplugins.pymi.logging.PeopleYouMayInviteLogger;
import com.facebook.feedplugins.pymi.logging.PeopleYouMayInviteLogger.Events;
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
/* compiled from: ckground_location/settings */
public class PeopleYouMayInvitePagerPartDefinition<E extends HasPositionInformation & HasPersistentState & HasPrefetcher & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLPeopleYouMayInviteFeedUnit>, Void, E, HScrollRecyclerView> {
    private static PeopleYouMayInvitePagerPartDefinition f8798i;
    private static final Object f8799j = new Object();
    private final BackgroundPartDefinition f8800a;
    private final PageStyleFactory f8801b;
    private final PersistentRecyclerPartDefinition<Object, E> f8802c;
    public final FeedLoggingViewportEventListener f8803d;
    public final PeopleYouMayInvitePagePartDefinition f8804e;
    public final PeopleYouMayInviteMorePartDefinition f8805f;
    public final PeopleYouMayInviteFeedUnitFetcher f8806g;
    public final PeopleYouMayInviteLogger f8807h;

    private static PeopleYouMayInvitePagerPartDefinition m9562b(InjectorLike injectorLike) {
        return new PeopleYouMayInvitePagerPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), PeopleYouMayInvitePagePartDefinition.a(injectorLike), PeopleYouMayInviteMorePartDefinition.a(injectorLike), PeopleYouMayInviteFeedUnitFetcher.m9507a(injectorLike), PeopleYouMayInviteLogger.m9512a(injectorLike));
    }

    public final Object m9564a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit = (GraphQLPeopleYouMayInviteFeedUnit) feedProps.a;
        subParts.a(this.f8800a, new StylingData(feedProps, PageStyle.a));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f8802c;
        PageStyle a = this.f8801b.a(308.0f, PageStyle.a, true);
        int ac_ = graphQLPeopleYouMayInviteFeedUnit.ac_();
        final ImmutableList r = graphQLPeopleYouMayInviteFeedUnit.r();
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new SimpleCallbacks<E>(this) {
            final /* synthetic */ PeopleYouMayInvitePagerPartDefinition f8797c;

            public final void m9559a(PageSubParts<E> pageSubParts) {
                int size = r.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.a(this.f8797c.f8804e, new PeopleYouMayInvitePagePartDefinition$Props((GraphQLPeopleYouMayInviteFeedUnitContactsEdge) r.get(i), graphQLPeopleYouMayInviteFeedUnit));
                }
                pageSubParts.a(this.f8797c.f8805f, null);
            }

            public final void m9560c(int i) {
                this.f8797c.f8803d.a(graphQLPeopleYouMayInviteFeedUnit, i);
                VisibleItemHelper.a(graphQLPeopleYouMayInviteFeedUnit, r, i);
                this.f8797c.f8807h.m9514a();
                this.f8797c.f8807h.m9515a(Events.SCROLL_INVITES);
                this.f8797c.f8806g.m9511a(graphQLPeopleYouMayInviteFeedUnit);
            }
        }, graphQLPeopleYouMayInviteFeedUnit.g(), graphQLPeopleYouMayInviteFeedUnit));
        return null;
    }

    public static PeopleYouMayInvitePagerPartDefinition m9561a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayInvitePagerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8799j) {
                PeopleYouMayInvitePagerPartDefinition peopleYouMayInvitePagerPartDefinition;
                if (a2 != null) {
                    peopleYouMayInvitePagerPartDefinition = (PeopleYouMayInvitePagerPartDefinition) a2.a(f8799j);
                } else {
                    peopleYouMayInvitePagerPartDefinition = f8798i;
                }
                if (peopleYouMayInvitePagerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9562b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8799j, b3);
                        } else {
                            f8798i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayInvitePagerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PeopleYouMayInvitePagerPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, FeedLoggingViewportEventListener feedLoggingViewportEventListener, PeopleYouMayInvitePagePartDefinition peopleYouMayInvitePagePartDefinition, PeopleYouMayInviteMorePartDefinition peopleYouMayInviteMorePartDefinition, PeopleYouMayInviteFeedUnitFetcher peopleYouMayInviteFeedUnitFetcher, PeopleYouMayInviteLogger peopleYouMayInviteLogger) {
        this.f8800a = backgroundPartDefinition;
        this.f8801b = pageStyleFactory;
        this.f8802c = persistentRecyclerPartDefinition;
        this.f8803d = feedLoggingViewportEventListener;
        this.f8804e = peopleYouMayInvitePagePartDefinition;
        this.f8805f = peopleYouMayInviteMorePartDefinition;
        this.f8806g = peopleYouMayInviteFeedUnitFetcher;
        this.f8807h = peopleYouMayInviteLogger;
    }

    public final ViewType m9563a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m9565a(Object obj) {
        return true;
    }
}
