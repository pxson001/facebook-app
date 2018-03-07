package com.facebook.feedplugins.egolistview.rows;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feedcache.mutator.FeedUnitCacheMutator;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feedplugins.egolistview.fetcher.PaginatedGYSJFeedUnitFetcher;
import com.facebook.feedplugins.egolistview.views.GroupsYouShouldJoinPageView;
import com.facebook.feedplugins.groupsuggestioncommon.GroupSuggestionExceptionHandler;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLGroupMembersConnection;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnitItem;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: num_full_relevant_comments */
public class GroupsYouShouldJoinPagePartDefinition<E extends HasInvalidate & HasPersistentState> extends BaseSinglePartDefinitionWithViewType<Props, State, E, GroupsYouShouldJoinPageView> {
    public static final ViewType<GroupsYouShouldJoinPageView> f6579a = new C02981();
    private static GroupsYouShouldJoinPagePartDefinition f6580k;
    private static final Object f6581l = new Object();
    private final GroupsImagePartDefinition f6582b;
    public final DefaultFeedUnitRenderer f6583c;
    private final NewsFeedAnalyticsEventBuilder f6584d;
    private final AnalyticsLogger f6585e;
    public final GroupsClient f6586f;
    public final Executor f6587g;
    public final GroupSuggestionExceptionHandler f6588h;
    private final PaginatedGYSJFeedUnitFetcher f6589i;
    public final FeedUnitCacheMutator f6590j;

    /* compiled from: num_full_relevant_comments */
    final class C02981 extends ViewType<GroupsYouShouldJoinPageView> {
        C02981() {
        }

        public final View m7005a(Context context) {
            return new GroupsYouShouldJoinPageView(context);
        }
    }

    private static GroupsYouShouldJoinPagePartDefinition m6999b(InjectorLike injectorLike) {
        return new GroupsYouShouldJoinPagePartDefinition(GroupsImagePartDefinition.a(injectorLike), DefaultFeedUnitRenderer.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), GroupsClient.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GroupSuggestionExceptionHandler.b(injectorLike), PaginatedGYSJFeedUnitFetcher.a(injectorLike), FeedUnitCacheMutator.a(injectorLike));
    }

    public final Object m7002a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.a(this.f6582b, props.b);
        GysjItemPersistentState gysjItemPersistentState = (GysjItemPersistentState) ((HasPersistentState) hasInvalidate).a(new GysjItemPersistentKey(props.b), props.a);
        return new State(m6993a(hasInvalidate, props.a, props.b, gysjItemPersistentState), gysjItemPersistentState, m7000b(props.b), m6992a(props.b), new 2(this, props), new 3(this, props.b, props.a));
    }

    public final void m7004b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        GroupsYouShouldJoinPageView groupsYouShouldJoinPageView = (GroupsYouShouldJoinPageView) view;
        groupsYouShouldJoinPageView.setGroupJoiningButtonClickedListener(null);
        groupsYouShouldJoinPageView.setNameClickListener(null);
        groupsYouShouldJoinPageView.setOnBlacklistIconClickedListener(null);
        this.f6589i.g.c();
    }

    public static GroupsYouShouldJoinPagePartDefinition m6994a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsYouShouldJoinPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6581l) {
                GroupsYouShouldJoinPagePartDefinition groupsYouShouldJoinPagePartDefinition;
                if (a2 != null) {
                    groupsYouShouldJoinPagePartDefinition = (GroupsYouShouldJoinPagePartDefinition) a2.a(f6581l);
                } else {
                    groupsYouShouldJoinPagePartDefinition = f6580k;
                }
                if (groupsYouShouldJoinPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6999b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6581l, b3);
                        } else {
                            f6580k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsYouShouldJoinPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupsYouShouldJoinPagePartDefinition(GroupsImagePartDefinition groupsImagePartDefinition, DefaultFeedUnitRenderer defaultFeedUnitRenderer, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, GroupsClient groupsClient, Executor executor, GroupSuggestionExceptionHandler groupSuggestionExceptionHandler, PaginatedGYSJFeedUnitFetcher paginatedGYSJFeedUnitFetcher, FeedUnitCacheMutator feedUnitCacheMutator) {
        this.f6582b = groupsImagePartDefinition;
        this.f6583c = defaultFeedUnitRenderer;
        this.f6584d = newsFeedAnalyticsEventBuilder;
        this.f6585e = analyticsLogger;
        this.f6586f = groupsClient;
        this.f6587g = executor;
        this.f6588h = groupSuggestionExceptionHandler;
        this.f6589i = paginatedGYSJFeedUnitFetcher;
        this.f6590j = feedUnitCacheMutator;
    }

    public final ViewType<GroupsYouShouldJoinPageView> m7001a() {
        return f6579a;
    }

    private void m6996a(Props props, State state, GroupsYouShouldJoinPageView groupsYouShouldJoinPageView) {
        groupsYouShouldJoinPageView.setGroupJoiningButtonClickedListener(state.a);
        GraphQLProfile a = FeedUnitItemProfileHelper.a(props.b);
        if (a != null) {
            int i;
            int i2;
            groupsYouShouldJoinPageView.f.setText(a.U());
            int L = a.L();
            if (L > 0) {
                groupsYouShouldJoinPageView.g.setText(groupsYouShouldJoinPageView.getResources().getQuantityString(2131689701, L, new Object[]{Integer.valueOf(L)}));
                groupsYouShouldJoinPageView.g.setVisibility(0);
            } else {
                groupsYouShouldJoinPageView.g.setVisibility(8);
            }
            groupsYouShouldJoinPageView.setMemberCount(a.K() != null ? a.K().a() : 0);
            groupsYouShouldJoinPageView.setNameClickListener(state.e);
            groupsYouShouldJoinPageView.l.setOnClickListener(state.e);
            GroupsYouShouldJoinFeedUnitItem groupsYouShouldJoinFeedUnitItem = props.b;
            GysjItemPersistentState gysjItemPersistentState = state.b;
            Object obj = null;
            GraphQLGroupJoinState aB = FeedUnitItemProfileHelper.a(groupsYouShouldJoinFeedUnitItem).aB();
            if (aB == GraphQLGroupJoinState.REQUESTED || aB == GraphQLGroupJoinState.CAN_REQUEST) {
                obj = 1;
            }
            GraphQLGroupJoinState graphQLGroupJoinState = gysjItemPersistentState.a ? obj != null ? GraphQLGroupJoinState.REQUESTED : GraphQLGroupJoinState.MEMBER : obj != null ? GraphQLGroupJoinState.CAN_REQUEST : GraphQLGroupJoinState.CAN_JOIN;
            GraphQLGroupJoinState graphQLGroupJoinState2 = graphQLGroupJoinState;
            Resources resources = groupsYouShouldJoinPageView.i.getResources();
            if (graphQLGroupJoinState2 == GraphQLGroupJoinState.MEMBER || graphQLGroupJoinState2 == GraphQLGroupJoinState.REQUESTED) {
                i = 2130840191;
                i2 = 2131237970;
            } else {
                i = 2130840299;
                i2 = 2131237971;
            }
            groupsYouShouldJoinPageView.i.setImageDrawable(resources.getDrawable(i));
            groupsYouShouldJoinPageView.i.setBackgroundColor(0);
            groupsYouShouldJoinPageView.i.setContentDescription(resources.getString(i2));
            if (a.L() != 0 || state.d == null) {
                groupsYouShouldJoinPageView.a(state.c, CallerContext.a(GroupsYouShouldJoinPagePartDefinition.class));
            } else {
                groupsYouShouldJoinPageView.a(state.d, CallerContext.a(GroupsYouShouldJoinPagePartDefinition.class));
            }
            groupsYouShouldJoinPageView.setOnBlacklistIconClickedListener(state.f);
            m6998a(props.a);
        }
    }

    private OnClickListener m6993a(E e, GroupsYouShouldJoinFeedUnit groupsYouShouldJoinFeedUnit, GroupsYouShouldJoinFeedUnitItem groupsYouShouldJoinFeedUnitItem, GysjItemPersistentState gysjItemPersistentState) {
        return new 4(this, gysjItemPersistentState, groupsYouShouldJoinFeedUnitItem, groupsYouShouldJoinFeedUnit, e);
    }

    public static void m6997a(GroupsYouShouldJoinPagePartDefinition groupsYouShouldJoinPagePartDefinition, GroupsYouShouldJoinFeedUnit groupsYouShouldJoinFeedUnit, GroupsYouShouldJoinFeedUnitItem groupsYouShouldJoinFeedUnitItem, String str) {
        HoneyAnalyticsEvent honeyAnalyticsEvent;
        ArrayNode a = GraphQLHelper.a(groupsYouShouldJoinFeedUnitItem, groupsYouShouldJoinFeedUnit);
        if (NewsFeedAnalyticsEventBuilder.B(a)) {
            honeyAnalyticsEvent = null;
        } else {
            HoneyClientEvent a2 = new HoneyClientEvent(str).a("tracking", a);
            a2.c = "native_newsfeed";
            honeyAnalyticsEvent = a2;
        }
        groupsYouShouldJoinPagePartDefinition.f6585e.a(honeyAnalyticsEvent);
    }

    private void m6998a(GroupsYouShouldJoinFeedUnit groupsYouShouldJoinFeedUnit) {
        if (groupsYouShouldJoinFeedUnit instanceof GraphQLPaginatedGroupsYouShouldJoinFeedUnit) {
            GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit = (GraphQLPaginatedGroupsYouShouldJoinFeedUnit) groupsYouShouldJoinFeedUnit;
            if (this.f6589i.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit, graphQLPaginatedGroupsYouShouldJoinFeedUnit.ac_()) && PaginatedGYSJFeedUnitFetcher.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit)) {
                this.f6589i.b(graphQLPaginatedGroupsYouShouldJoinFeedUnit);
            }
        }
    }

    @Nullable
    public static Uri m6992a(GroupsYouShouldJoinFeedUnitItem groupsYouShouldJoinFeedUnitItem) {
        GraphQLFocusedPhoto s = groupsYouShouldJoinFeedUnitItem.j().s();
        if (s == null || s.j() == null || s.j().L() == null) {
            return null;
        }
        return Uri.parse(s.j().L().b());
    }

    @Nullable
    public static List<Uri> m7000b(GroupsYouShouldJoinFeedUnitItem groupsYouShouldJoinFeedUnitItem) {
        GraphQLGroupMembersConnection C = groupsYouShouldJoinFeedUnitItem.j().C();
        if (C == null) {
            return null;
        }
        ImmutableList k = C.k();
        if (k == null) {
            return null;
        }
        List<Uri> a = Lists.a(3);
        int size = k.size();
        for (int i = 0; i != size; i++) {
            GraphQLImage aI = ((GraphQLUser) k.get(i)).aI();
            if (aI != null) {
                Uri a2 = ImageUtil.a(aI);
                if (a2 != null) {
                    a.add(a2);
                    if (a.size() == 3) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return a;
    }
}
