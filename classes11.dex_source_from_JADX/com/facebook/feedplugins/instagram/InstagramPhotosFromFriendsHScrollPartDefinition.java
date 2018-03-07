package com.facebook.feedplugins.instagram;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feedplugins.instagram.InstagramPhotoFromFriendsItemPartDefinition.Props;
import com.facebook.graphql.model.GraphQLInstagramPhotosFromFriendsFeedUnit;
import com.facebook.graphql.model.InstagramPhotosFromFriendsPhoto;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: cuids */
public class InstagramPhotosFromFriendsHScrollPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLInstagramPhotosFromFriendsFeedUnit>, Void, E, HScrollRecyclerView> {
    private static InstagramPhotosFromFriendsHScrollPartDefinition f7899f;
    private static final Object f7900g = new Object();
    private final BackgroundPartDefinition f7901a;
    private final PageStyleFactory f7902b;
    private final PageSwitcherPartDefinition f7903c;
    private final PersistentRecyclerPartDefinition<Props, E> f7904d;
    public final InstagramPhotoFromFriendsItemPartDefinition f7905e;

    private static InstagramPhotosFromFriendsHScrollPartDefinition m8996b(InjectorLike injectorLike) {
        return new InstagramPhotosFromFriendsHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PageSwitcherPartDefinition.a(injectorLike), InstagramPhotoFromFriendsItemPartDefinition.m8977a(injectorLike));
    }

    public final Object m8998a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLInstagramPhotosFromFriendsFeedUnit graphQLInstagramPhotosFromFriendsFeedUnit = (GraphQLInstagramPhotosFromFriendsFeedUnit) feedProps.a;
        final Controller controller = new Controller();
        subParts.a(this.f7901a, new StylingData(feedProps, PageStyle.a));
        subParts.a(this.f7903c, controller);
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f7904d;
        PageStyle a = this.f7902b.a(200.0f, PageStyle.a, true);
        int ac_ = graphQLInstagramPhotosFromFriendsFeedUnit.ac_();
        final ImmutableList a2 = ScrollableItemListFeedUnitImpl.a(graphQLInstagramPhotosFromFriendsFeedUnit);
        subParts.a(persistentRecyclerPartDefinition, new PersistentRecyclerPartDefinition.Props(a, ac_, new Callbacks<Props, E>(this) {
            final /* synthetic */ InstagramPhotosFromFriendsHScrollPartDefinition f7898d;

            public final SinglePartDefinitionWithViewType<Props, ?, ? super E, ?> m8992a(int i) {
                return this.f7898d.f7905e;
            }

            public final Object m8993b(int i) {
                return new Props((InstagramPhotosFromFriendsPhoto) a2.get(i), controller);
            }

            public final void m8994c(int i) {
                VisibleItemHelper.a(graphQLInstagramPhotosFromFriendsFeedUnit, a2, i);
            }

            public final int m8991a() {
                return a2.size();
            }
        }, graphQLInstagramPhotosFromFriendsFeedUnit.g(), new CacheableEntity(this) {
            final /* synthetic */ InstagramPhotosFromFriendsHScrollPartDefinition f7894b;

            public final String m8990g() {
                return graphQLInstagramPhotosFromFriendsFeedUnit.g();
            }
        }));
        return null;
    }

    @Inject
    public InstagramPhotosFromFriendsHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PageStyleFactory pageStyleFactory, PageSwitcherPartDefinition pageSwitcherPartDefinition, InstagramPhotoFromFriendsItemPartDefinition instagramPhotoFromFriendsItemPartDefinition) {
        this.f7901a = backgroundPartDefinition;
        this.f7904d = persistentRecyclerPartDefinition;
        this.f7902b = pageStyleFactory;
        this.f7903c = pageSwitcherPartDefinition;
        this.f7905e = instagramPhotoFromFriendsItemPartDefinition;
    }

    public static InstagramPhotosFromFriendsHScrollPartDefinition m8995a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramPhotosFromFriendsHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7900g) {
                InstagramPhotosFromFriendsHScrollPartDefinition instagramPhotosFromFriendsHScrollPartDefinition;
                if (a2 != null) {
                    instagramPhotosFromFriendsHScrollPartDefinition = (InstagramPhotosFromFriendsHScrollPartDefinition) a2.a(f7900g);
                } else {
                    instagramPhotosFromFriendsHScrollPartDefinition = f7899f;
                }
                if (instagramPhotosFromFriendsHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8996b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7900g, b3);
                        } else {
                            f7899f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramPhotosFromFriendsHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m8997a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m8999a(Object obj) {
        return true;
    }
}
