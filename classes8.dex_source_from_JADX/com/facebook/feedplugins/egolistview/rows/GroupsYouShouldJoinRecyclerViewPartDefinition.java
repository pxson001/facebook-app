package com.facebook.feedplugins.egolistview.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
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
import com.facebook.feedplugins.egolistview.fetcher.PaginatedGYSJFeedUnitFetcher;
import com.facebook.feedplugins.egolistview.views.GroupsYouShouldJoinPageView;
import com.facebook.graphql.model.GraphQLGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnitItem;
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
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gravity_start_ble_scan */
public class GroupsYouShouldJoinRecyclerViewPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<? extends GroupsYouShouldJoinFeedUnit>, Void, E, HScrollRecyclerView> {
    public static final PagerViewType<GroupsYouShouldJoinPageView> f12086a = new C12911();
    private static GroupsYouShouldJoinRecyclerViewPartDefinition f12087h;
    private static final Object f12088i = new Object();
    private final BackgroundPartDefinition f12089b;
    private final PageStyleFactory f12090c;
    private final PersistentRecyclerPartDefinition<Object, E> f12091d;
    public final FeedLoggingViewportEventListener f12092e;
    public final GroupsYouShouldJoinPagePartDefinition f12093f;
    public final PaginatedGYSJFeedUnitFetcher f12094g;

    /* compiled from: gravity_start_ble_scan */
    final class C12911 implements PagerViewType<GroupsYouShouldJoinPageView> {
        C12911() {
        }

        public final Class m14103a() {
            return GroupsYouShouldJoinPageView.class;
        }

        public final View m14102a(Context context) {
            return new GroupsYouShouldJoinPageView(context);
        }
    }

    private static GroupsYouShouldJoinRecyclerViewPartDefinition m14107b(InjectorLike injectorLike) {
        return new GroupsYouShouldJoinRecyclerViewPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), GroupsYouShouldJoinPagePartDefinition.a(injectorLike), PaginatedGYSJFeedUnitFetcher.m14074a(injectorLike));
    }

    public final Object m14109a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GroupsYouShouldJoinFeedUnit groupsYouShouldJoinFeedUnit = (GroupsYouShouldJoinFeedUnit) feedProps.a;
        PaddingStyle paddingStyle = PageStyle.a;
        subParts.a(this.f12089b, new StylingData(feedProps, paddingStyle));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f12091d;
        PageStyle a = this.f12090c.a(282.0f, paddingStyle, true);
        int ac_ = groupsYouShouldJoinFeedUnit.ac_();
        final List v = groupsYouShouldJoinFeedUnit.v();
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new SimpleCallbacks<E>(this) {
            final /* synthetic */ GroupsYouShouldJoinRecyclerViewPartDefinition f12085c;

            public final void m14104a(PageSubParts<E> pageSubParts) {
                for (GroupsYouShouldJoinFeedUnitItem groupsYouShouldJoinPagePartDefinition$Props : v) {
                    pageSubParts.a(this.f12085c.f12093f, new GroupsYouShouldJoinPagePartDefinition$Props(groupsYouShouldJoinFeedUnit, groupsYouShouldJoinPagePartDefinition$Props));
                }
            }

            public final void m14105c(int i) {
                if (groupsYouShouldJoinFeedUnit instanceof GraphQLGroupsYouShouldJoinFeedUnit) {
                    this.f12085c.f12092e.a(groupsYouShouldJoinFeedUnit, i);
                } else if (groupsYouShouldJoinFeedUnit instanceof GraphQLPaginatedGroupsYouShouldJoinFeedUnit) {
                    this.f12085c.f12092e.a(groupsYouShouldJoinFeedUnit, i);
                    GroupsYouShouldJoinRecyclerViewPartDefinition groupsYouShouldJoinRecyclerViewPartDefinition = this.f12085c;
                    GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit = (GraphQLPaginatedGroupsYouShouldJoinFeedUnit) groupsYouShouldJoinFeedUnit;
                    if (groupsYouShouldJoinRecyclerViewPartDefinition.f12094g.m14078a(graphQLPaginatedGroupsYouShouldJoinFeedUnit, i) && PaginatedGYSJFeedUnitFetcher.m14075a(graphQLPaginatedGroupsYouShouldJoinFeedUnit)) {
                        groupsYouShouldJoinRecyclerViewPartDefinition.f12094g.m14079b(graphQLPaginatedGroupsYouShouldJoinFeedUnit);
                    }
                } else {
                    return;
                }
                VisibleItemHelper.a(groupsYouShouldJoinFeedUnit, v, i);
            }
        }, groupsYouShouldJoinFeedUnit.g(), groupsYouShouldJoinFeedUnit));
        return null;
    }

    public static GroupsYouShouldJoinRecyclerViewPartDefinition m14106a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsYouShouldJoinRecyclerViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12088i) {
                GroupsYouShouldJoinRecyclerViewPartDefinition groupsYouShouldJoinRecyclerViewPartDefinition;
                if (a2 != null) {
                    groupsYouShouldJoinRecyclerViewPartDefinition = (GroupsYouShouldJoinRecyclerViewPartDefinition) a2.a(f12088i);
                } else {
                    groupsYouShouldJoinRecyclerViewPartDefinition = f12087h;
                }
                if (groupsYouShouldJoinRecyclerViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14107b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12088i, b3);
                        } else {
                            f12087h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsYouShouldJoinRecyclerViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupsYouShouldJoinRecyclerViewPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, FeedLoggingViewportEventListener feedLoggingViewportEventListener, GroupsYouShouldJoinPagePartDefinition groupsYouShouldJoinPagePartDefinition, PaginatedGYSJFeedUnitFetcher paginatedGYSJFeedUnitFetcher) {
        this.f12089b = backgroundPartDefinition;
        this.f12090c = pageStyleFactory;
        this.f12091d = persistentRecyclerPartDefinition;
        this.f12092e = feedLoggingViewportEventListener;
        this.f12093f = groupsYouShouldJoinPagePartDefinition;
        this.f12094g = paginatedGYSJFeedUnitFetcher;
    }

    public final ViewType m14108a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m14110a(Object obj) {
        return true;
    }
}
