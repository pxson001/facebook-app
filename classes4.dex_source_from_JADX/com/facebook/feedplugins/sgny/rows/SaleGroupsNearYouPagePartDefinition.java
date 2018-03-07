package com.facebook.feedplugins.sgny.rows;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feedcache.mutator.FeedUnitCacheMutator;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feedplugins.groupsuggestioncommon.GroupSuggestionExceptionHandler;
import com.facebook.feedplugins.sgny.fetcher.SaleGroupsNearYouFeedUnitFetcher;
import com.facebook.feedplugins.sgny.views.SaleGroupsNearYouPageView;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLGroupMembersConnection;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsEdge;
import com.facebook.graphql.model.GraphQLUser;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notification_request_source */
public class SaleGroupsNearYouPagePartDefinition<E extends HasInvalidate & HasPersistentState> extends BaseSinglePartDefinitionWithViewType<Props, State, E, SaleGroupsNearYouPageView> {
    public static final ViewType<SaleGroupsNearYouPageView> f6813a = new C03201();
    private static SaleGroupsNearYouPagePartDefinition f6814k;
    private static final Object f6815l = new Object();
    private final GroupsImagePartDefinition f6816b;
    public final DefaultFeedUnitRenderer f6817c;
    public final GroupsClient f6818d;
    public final Executor f6819e;
    public final GroupSuggestionExceptionHandler f6820f;
    public final SaleGroupsNearYouFeedUnitFetcher f6821g;
    public final FeedUnitCacheMutator f6822h;
    private final NewsFeedAnalyticsEventBuilder f6823i;
    private final AnalyticsLogger f6824j;

    /* compiled from: notification_request_source */
    final class C03201 extends ViewType<SaleGroupsNearYouPageView> {
        C03201() {
        }

        public final View m7179a(Context context) {
            return new SaleGroupsNearYouPageView(context);
        }
    }

    private static SaleGroupsNearYouPagePartDefinition m7173b(InjectorLike injectorLike) {
        return new SaleGroupsNearYouPagePartDefinition(GroupsImagePartDefinition.a(injectorLike), DefaultFeedUnitRenderer.a(injectorLike), GroupsClient.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GroupSuggestionExceptionHandler.b(injectorLike), SaleGroupsNearYouFeedUnitFetcher.a(injectorLike), FeedUnitCacheMutator.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public final Object m7176a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.a(this.f6816b, props.b);
        SgnyItemPersistentState sgnyItemPersistentState = (SgnyItemPersistentState) ((HasPersistentState) hasInvalidate).a(new SgnyItemPersistentKey(props.b), props.a);
        return new State(m7168a(hasInvalidate, props.a, props.b, sgnyItemPersistentState), sgnyItemPersistentState, m7174b(props.b), m7167a(props.b), new 2(this, props), new 3(this, props.a, props.b));
    }

    public final void m7178b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        SaleGroupsNearYouPageView saleGroupsNearYouPageView = (SaleGroupsNearYouPageView) view;
        saleGroupsNearYouPageView.setGroupJoiningButtonClickedListener(null);
        saleGroupsNearYouPageView.setNameClickListener(null);
        saleGroupsNearYouPageView.setOnBlacklistIconClickedListener(null);
        this.f6821g.f.c();
    }

    public static SaleGroupsNearYouPagePartDefinition m7169a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SaleGroupsNearYouPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6815l) {
                SaleGroupsNearYouPagePartDefinition saleGroupsNearYouPagePartDefinition;
                if (a2 != null) {
                    saleGroupsNearYouPagePartDefinition = (SaleGroupsNearYouPagePartDefinition) a2.a(f6815l);
                } else {
                    saleGroupsNearYouPagePartDefinition = f6814k;
                }
                if (saleGroupsNearYouPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7173b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6815l, b3);
                        } else {
                            f6814k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = saleGroupsNearYouPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SaleGroupsNearYouPagePartDefinition(GroupsImagePartDefinition groupsImagePartDefinition, DefaultFeedUnitRenderer defaultFeedUnitRenderer, GroupsClient groupsClient, Executor executor, GroupSuggestionExceptionHandler groupSuggestionExceptionHandler, SaleGroupsNearYouFeedUnitFetcher saleGroupsNearYouFeedUnitFetcher, FeedUnitCacheMutator feedUnitCacheMutator, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger) {
        this.f6816b = groupsImagePartDefinition;
        this.f6817c = defaultFeedUnitRenderer;
        this.f6818d = groupsClient;
        this.f6819e = executor;
        this.f6820f = groupSuggestionExceptionHandler;
        this.f6821g = saleGroupsNearYouFeedUnitFetcher;
        this.f6822h = feedUnitCacheMutator;
        this.f6823i = newsFeedAnalyticsEventBuilder;
        this.f6824j = analyticsLogger;
    }

    public final ViewType<SaleGroupsNearYouPageView> m7175a() {
        return f6813a;
    }

    private void m7171a(Props props, State state, SaleGroupsNearYouPageView saleGroupsNearYouPageView) {
        saleGroupsNearYouPageView.setGroupJoiningButtonClickedListener(state.a);
        GraphQLProfile a = FeedUnitItemProfileHelper.a(props.b);
        if (a != null) {
            int i;
            int i2;
            saleGroupsNearYouPageView.f6806f.setText(a.U());
            int L = a.L();
            if (L > 0) {
                saleGroupsNearYouPageView.f6807g.setText(saleGroupsNearYouPageView.getResources().getQuantityString(2131689701, L, new Object[]{Integer.valueOf(L)}));
                saleGroupsNearYouPageView.f6807g.setVisibility(0);
            } else {
                saleGroupsNearYouPageView.f6807g.setVisibility(8);
            }
            saleGroupsNearYouPageView.setMemberCount(a.K() != null ? a.K().a() : 0);
            saleGroupsNearYouPageView.setNameClickListener(state.e);
            saleGroupsNearYouPageView.f6812l.setOnClickListener(state.e);
            GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge = props.b;
            SgnyItemPersistentState sgnyItemPersistentState = state.b;
            Object obj = null;
            GraphQLGroupJoinState aB = FeedUnitItemProfileHelper.a(graphQLSaleGroupsNearYouFeedUnitGroupsEdge).aB();
            if (aB == GraphQLGroupJoinState.REQUESTED || aB == GraphQLGroupJoinState.CAN_REQUEST) {
                obj = 1;
            }
            GraphQLGroupJoinState graphQLGroupJoinState = sgnyItemPersistentState.a ? obj != null ? GraphQLGroupJoinState.REQUESTED : GraphQLGroupJoinState.MEMBER : obj != null ? GraphQLGroupJoinState.CAN_REQUEST : GraphQLGroupJoinState.CAN_JOIN;
            GraphQLGroupJoinState graphQLGroupJoinState2 = graphQLGroupJoinState;
            Resources resources = saleGroupsNearYouPageView.f6809i.getResources();
            if (graphQLGroupJoinState2 == GraphQLGroupJoinState.MEMBER || graphQLGroupJoinState2 == GraphQLGroupJoinState.REQUESTED) {
                i = 2130840191;
                i2 = 2131237970;
            } else {
                i = 2130840299;
                i2 = 2131237971;
            }
            saleGroupsNearYouPageView.f6809i.setImageDrawable(resources.getDrawable(i));
            saleGroupsNearYouPageView.f6809i.setBackgroundColor(0);
            saleGroupsNearYouPageView.f6809i.setContentDescription(resources.getString(i2));
            if (a.L() != 0 || state.d == null) {
                saleGroupsNearYouPageView.m7165a(state.c, CallerContext.a(SaleGroupsNearYouPagePartDefinition.class));
            } else {
                saleGroupsNearYouPageView.m7164a(state.d, CallerContext.a(SaleGroupsNearYouPagePartDefinition.class));
            }
            saleGroupsNearYouPageView.setOnBlacklistIconClickedListener(state.f);
            GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit = props.a;
            if (this.f6821g.a(graphQLSaleGroupsNearYouFeedUnit, graphQLSaleGroupsNearYouFeedUnit.ac_()) && SaleGroupsNearYouFeedUnitFetcher.a(graphQLSaleGroupsNearYouFeedUnit)) {
                this.f6821g.b(graphQLSaleGroupsNearYouFeedUnit);
            }
        }
    }

    private OnClickListener m7168a(E e, GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit, GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge, SgnyItemPersistentState sgnyItemPersistentState) {
        return new 4(this, sgnyItemPersistentState, graphQLSaleGroupsNearYouFeedUnitGroupsEdge, graphQLSaleGroupsNearYouFeedUnit, e);
    }

    public static void m7172a(SaleGroupsNearYouPagePartDefinition saleGroupsNearYouPagePartDefinition, GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit, GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge, String str) {
        saleGroupsNearYouPagePartDefinition.f6824j.a(NewsFeedAnalyticsEventBuilder.b(str, GraphQLHelper.a(graphQLSaleGroupsNearYouFeedUnitGroupsEdge, graphQLSaleGroupsNearYouFeedUnit)));
    }

    @Nullable
    public static Uri m7167a(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge) {
        GraphQLFocusedPhoto s = graphQLSaleGroupsNearYouFeedUnitGroupsEdge.j().s();
        if (s == null || s.j() == null || s.j().L() == null) {
            return null;
        }
        return Uri.parse(s.j().L().b());
    }

    @Nullable
    public static List<Uri> m7174b(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge) {
        GraphQLGroupMembersConnection C = graphQLSaleGroupsNearYouFeedUnitGroupsEdge.j().C();
        if (C == null) {
            return null;
        }
        ImmutableList k = C.k();
        if (k == null) {
            return null;
        }
        List<Uri> a = Lists.a(3);
        for (int i = 0; i < k.size(); i++) {
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
