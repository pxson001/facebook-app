package com.facebook.feedplugins.gysc.partdefinitions;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feed.environment.FeedEnvironment;
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
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnit;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnitItem;
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
/* compiled from: friendversary_card_collage */
public class GroupsYouShouldCreateHScrollPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGroupsYouShouldCreateFeedUnit>, Void, FeedEnvironment, HScrollRecyclerView> {
    private static final PaddingStyle f12818c = PageStyle.a;
    private static GroupsYouShouldCreateHScrollPartDefinition f12819i;
    private static final Object f12820j = new Object();
    public final float f12821a = ((this.f12827h.getDimension(2131430263) / this.f12827h.getDisplayMetrics().density) + 8.0f);
    protected final GroupsYouShouldCreateMessengerTypePagePartDefinition f12822b;
    private final BackgroundPartDefinition f12823d;
    private final PageStyleFactory f12824e;
    private final PersistentRecyclerPartDefinition<Object, FeedEnvironment> f12825f;
    public final FeedLoggingViewportEventListener f12826g;
    private final Resources f12827h;

    private static GroupsYouShouldCreateHScrollPartDefinition m14595b(InjectorLike injectorLike) {
        return new GroupsYouShouldCreateHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), GroupsYouShouldCreateMessengerTypePagePartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m14597a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit = (GraphQLGroupsYouShouldCreateFeedUnit) feedProps.a;
        subParts.a(this.f12823d, new StylingData(feedProps, f12818c));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f12825f;
        PageStyle a = this.f12824e.a(this.f12821a, f12818c, true);
        int ac_ = graphQLGroupsYouShouldCreateFeedUnit.ac_();
        final ImmutableList l = graphQLGroupsYouShouldCreateFeedUnit.l();
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new SimpleCallbacks<FeedEnvironment>(this) {
            final /* synthetic */ GroupsYouShouldCreateHScrollPartDefinition f12817c;

            public final void m14592a(PageSubParts<FeedEnvironment> pageSubParts) {
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.a(this.f12817c.f12822b, new GroupsYouShouldCreateUtil.Props(graphQLGroupsYouShouldCreateFeedUnit, (GraphQLGroupsYouShouldCreateFeedUnitItem) l.get(i)));
                }
            }

            public final void m14593c(int i) {
                if (graphQLGroupsYouShouldCreateFeedUnit instanceof GraphQLGroupsYouShouldCreateFeedUnit) {
                    this.f12817c.f12826g.a(graphQLGroupsYouShouldCreateFeedUnit, i);
                }
                VisibleItemHelper.a(graphQLGroupsYouShouldCreateFeedUnit, l, i);
            }
        }, graphQLGroupsYouShouldCreateFeedUnit.g(), graphQLGroupsYouShouldCreateFeedUnit));
        return null;
    }

    public final boolean m14598a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps.a == null) {
            return false;
        }
        return CollectionUtil.b(((GraphQLGroupsYouShouldCreateFeedUnit) feedProps.a).l());
    }

    @Inject
    public GroupsYouShouldCreateHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, FeedLoggingViewportEventListener feedLoggingViewportEventListener, GroupsYouShouldCreateMessengerTypePagePartDefinition groupsYouShouldCreateMessengerTypePagePartDefinition, Resources resources) {
        this.f12823d = backgroundPartDefinition;
        this.f12824e = pageStyleFactory;
        this.f12825f = persistentRecyclerPartDefinition;
        this.f12826g = feedLoggingViewportEventListener;
        this.f12822b = groupsYouShouldCreateMessengerTypePagePartDefinition;
        this.f12827h = resources;
    }

    public static GroupsYouShouldCreateHScrollPartDefinition m14594a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsYouShouldCreateHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12820j) {
                GroupsYouShouldCreateHScrollPartDefinition groupsYouShouldCreateHScrollPartDefinition;
                if (a2 != null) {
                    groupsYouShouldCreateHScrollPartDefinition = (GroupsYouShouldCreateHScrollPartDefinition) a2.a(f12820j);
                } else {
                    groupsYouShouldCreateHScrollPartDefinition = f12819i;
                }
                if (groupsYouShouldCreateHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14595b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12820j, b3);
                        } else {
                            f12819i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsYouShouldCreateHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m14596a() {
        return HScrollRecyclerViewRowType.a;
    }
}
