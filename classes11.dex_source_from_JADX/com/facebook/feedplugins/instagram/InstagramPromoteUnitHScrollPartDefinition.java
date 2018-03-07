package com.facebook.feedplugins.instagram;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.instagram.InstagramPromoteUnitItemPartDefinition.Props;
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
/* compiled from: creationTimeMs */
public class InstagramPromoteUnitHScrollPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLInstagramPhotosFromFriendsFeedUnit>, Void, E, HScrollRecyclerView> {
    private static InstagramPromoteUnitHScrollPartDefinition f7925g;
    private static final Object f7926h = new Object();
    private final BackgroundPartDefinition f7927a;
    private final PageSwitcherPartDefinition f7928b;
    private final PersistentRecyclerPartDefinition<Props, E> f7929c;
    public final InstagramPromoteUnitItemPartDefinition f7930d;
    private final Context f7931e;
    private final FeedRenderUtils f7932f;

    private static InstagramPromoteUnitHScrollPartDefinition m9016b(InjectorLike injectorLike) {
        return new InstagramPromoteUnitHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PageSwitcherPartDefinition.a(injectorLike), InstagramPromoteUnitItemPartDefinition.m9032a(injectorLike), (Context) injectorLike.getInstance(Context.class), FeedRenderUtils.a(injectorLike));
    }

    public final Object m9018a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLInstagramPhotosFromFriendsFeedUnit graphQLInstagramPhotosFromFriendsFeedUnit = (GraphQLInstagramPhotosFromFriendsFeedUnit) feedProps.a;
        final Controller controller = new Controller();
        subParts.a(this.f7927a, new StylingData(feedProps, PageStyle.a));
        subParts.a(this.f7928b, controller);
        int c = SizeUtil.c(this.f7931e, (float) this.f7932f.a());
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f7929c;
        PageStyle a = PageStyle.a(c, true, true);
        int ac_ = graphQLInstagramPhotosFromFriendsFeedUnit.ac_();
        final ImmutableList a2 = ScrollableItemListFeedUnitImpl.a(graphQLInstagramPhotosFromFriendsFeedUnit);
        subParts.a(persistentRecyclerPartDefinition, new PersistentRecyclerPartDefinition.Props(a, ac_, new Callbacks<Props, E>(this) {
            final /* synthetic */ InstagramPromoteUnitHScrollPartDefinition f7924d;

            public final SinglePartDefinitionWithViewType<Props, ?, ? super E, ?> m9012a(int i) {
                return this.f7924d.f7930d;
            }

            public final Object m9013b(int i) {
                return new Props((InstagramPhotosFromFriendsPhoto) a2.get(i), controller);
            }

            public final void m9014c(int i) {
                VisibleItemHelper.a(graphQLInstagramPhotosFromFriendsFeedUnit, a2, i);
            }

            public final int m9011a() {
                return a2.size();
            }
        }, graphQLInstagramPhotosFromFriendsFeedUnit.g(), new CacheableEntity(this) {
            final /* synthetic */ InstagramPromoteUnitHScrollPartDefinition f7920b;

            public final String m9010g() {
                return graphQLInstagramPhotosFromFriendsFeedUnit.g();
            }
        }));
        return null;
    }

    @Inject
    public InstagramPromoteUnitHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PageSwitcherPartDefinition pageSwitcherPartDefinition, InstagramPromoteUnitItemPartDefinition instagramPromoteUnitItemPartDefinition, Context context, FeedRenderUtils feedRenderUtils) {
        this.f7927a = backgroundPartDefinition;
        this.f7929c = persistentRecyclerPartDefinition;
        this.f7928b = pageSwitcherPartDefinition;
        this.f7930d = instagramPromoteUnitItemPartDefinition;
        this.f7931e = context;
        this.f7932f = feedRenderUtils;
    }

    public static InstagramPromoteUnitHScrollPartDefinition m9015a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramPromoteUnitHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7926h) {
                InstagramPromoteUnitHScrollPartDefinition instagramPromoteUnitHScrollPartDefinition;
                if (a2 != null) {
                    instagramPromoteUnitHScrollPartDefinition = (InstagramPromoteUnitHScrollPartDefinition) a2.a(f7926h);
                } else {
                    instagramPromoteUnitHScrollPartDefinition = f7925g;
                }
                if (instagramPromoteUnitHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9016b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7926h, b3);
                        } else {
                            f7925g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramPromoteUnitHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m9017a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m9019a(Object obj) {
        return true;
    }
}
