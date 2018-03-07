package com.facebook.events.dashboard.multirow.environment;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.DashboardFilterType;
import com.facebook.events.dashboard.EventsDiscoveryDashboardFragment;
import com.facebook.events.dashboard.multirow.EventsDashboardItemCollection;
import com.facebook.feed.environment.CanFriendPerson.FriendshipStatus;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasScrollListenerSupport.SimpleScrollListener;
import com.facebook.feed.environment.impl.CanFollowUserImpl;
import com.facebook.feed.environment.impl.CanFriendPersonImpl;
import com.facebook.feed.environment.impl.CanLikePageImpl;
import com.facebook.feed.environment.impl.CanLikePageImplProvider;
import com.facebook.feed.environment.impl.CanShowVideoInFullScreenImpl;
import com.facebook.feed.environment.impl.HasAnchoredTooltipProviderImpl;
import com.facebook.feed.environment.impl.HasContextImpl;
import com.facebook.feed.environment.impl.HasContextImplProvider;
import com.facebook.feed.environment.impl.HasEnvironmentControllerImpl;
import com.facebook.feed.environment.impl.HasFeedListTypeImpl;
import com.facebook.feed.environment.impl.HasFeedListTypeImplProvider;
import com.facebook.feed.environment.impl.HasImageLoadListenerImpl;
import com.facebook.feed.environment.impl.HasInvalidateImpl;
import com.facebook.feed.environment.impl.HasInvalidateImplProvider;
import com.facebook.feed.environment.impl.HasMutationControllerManagerImpl;
import com.facebook.feed.environment.impl.HasMutationControllerManagerImplProvider;
import com.facebook.feed.environment.impl.HasPersistentStateImpl;
import com.facebook.feed.environment.impl.HasPositionInformationImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImplProvider;
import com.facebook.feed.environment.tooltip.TooltipAnchor;
import com.facebook.feed.fragment.generatedenvironments.HasMenuButtonProviderImpl;
import com.facebook.feed.fragment.generatedenvironments.HasMenuButtonProviderImplProvider;
import com.facebook.feed.fragment.generatedenvironments.HasPrefetcherImpl;
import com.facebook.feed.fragment.generatedenvironments.HasPrefetcherImplProvider;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsyncImpl;
import com.facebook.feed.rows.core.parts.EnvironmentController;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.feedplugins.saved.nux.CaretNuxTooltipDelegateBase;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.DirtyListener;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanAddReactionComponents;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImpl;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImplProvider;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEvents;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImpl;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandler;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandlerProvider;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel.ReactionPaginatedComponentsModel;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.webdialogs.ACTION_MANIFEST_PARCEL */
public class EventsDashboardEnvironmentGenerated implements HasEventAnalyticsParams, HasEventDashboardFilterType, HasEventDashboardFragment, ShouldExpandEvents, FeedEnvironment, CanAddReactionComponents, CanHandleHScrollPageChangedEvents, CanLaunchReactionIntent, HasReactionAnalyticsParams, HasReactionCardContainer, HasReactionInteractionTracker, HasReactionSession {
    private final CanAddReactionComponentsImpl f17106a = CanAddReactionComponentsImplProvider.a(this);
    private final CanFollowUserImpl f17107b;
    private final CanFriendPersonImpl f17108c;
    private final CanHandleHScrollPageChangedEventsImpl f17109d;
    private final CanLikePageImpl f17110e;
    private final CanShowVideoInFullScreenImpl f17111f;
    private final HasAnchoredTooltipProviderImpl f17112g;
    private final HasContextImpl f17113h;
    private final HasEnvironmentControllerImpl f17114i;
    private final HasFeedListTypeImpl f17115j;
    private final HasInvalidateImpl f17116k;
    private final HasIsAsyncImpl f17117l;
    private final HasImageLoadListenerImpl f17118m;
    private final HasMenuButtonProviderImpl f17119n;
    private final HasMutationControllerManagerImpl f17120o;
    private final HasPersistentStateImpl f17121p;
    private final HasPositionInformationImpl f17122q;
    private final HasPrefetcherImpl f17123r;
    private final HasScrollListenerSupportImpl f17124s;
    private final ReactionFeedActionHandler f17125t;
    private final ReactionFeedEnvironmentEventsImpl f17126u;
    private final HasEventAnalyticsParamsImpl f17127v;
    private final HasEventDashboardFilterTypeImpl f17128w;
    private final HasEventDashboardFragmentImpl f17129x;
    private final HasReactionAnalyticsParamsImpl f17130y;
    private final ShouldExpandEventsImpl f17131z;

    @Inject
    public EventsDashboardEnvironmentGenerated(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted MutationControllerManager mutationControllerManager, @Assisted MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper, @Assisted Delegate delegate, @Assisted Context context2, @Assisted ReactionCardContainer reactionCardContainer, @Assisted ReactionInteractionTracker reactionInteractionTracker, @Assisted ReactionSession reactionSession, @Assisted EventAnalyticsParams eventAnalyticsParams, @Assisted EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment, @Assisted ReactionAnalyticsParams reactionAnalyticsParams, @Assisted EventsDashboardItemCollection eventsDashboardItemCollection, CanAddReactionComponentsImplProvider canAddReactionComponentsImplProvider, CanFollowUserImpl canFollowUserImpl, CanFriendPersonImpl canFriendPersonImpl, CanHandleHScrollPageChangedEventsImpl canHandleHScrollPageChangedEventsImpl, CanLikePageImplProvider canLikePageImplProvider, CanShowVideoInFullScreenImpl canShowVideoInFullScreenImpl, HasAnchoredTooltipProviderImpl hasAnchoredTooltipProviderImpl, HasContextImplProvider hasContextImplProvider, HasEnvironmentControllerImpl hasEnvironmentControllerImpl, HasFeedListTypeImplProvider hasFeedListTypeImplProvider, HasInvalidateImplProvider hasInvalidateImplProvider, HasIsAsyncImpl hasIsAsyncImpl, HasImageLoadListenerImpl hasImageLoadListenerImpl, HasMenuButtonProviderImplProvider hasMenuButtonProviderImplProvider, HasMutationControllerManagerImplProvider hasMutationControllerManagerImplProvider, HasPersistentStateImpl hasPersistentStateImpl, HasPositionInformationImpl hasPositionInformationImpl, HasPrefetcherImplProvider hasPrefetcherImplProvider, HasScrollListenerSupportImplProvider hasScrollListenerSupportImplProvider, ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider, ReactionFeedEnvironmentEventsImplProvider reactionFeedEnvironmentEventsImplProvider, HasEventAnalyticsParamsImplProvider hasEventAnalyticsParamsImplProvider, HasEventDashboardFilterTypeImpl hasEventDashboardFilterTypeImpl, HasEventDashboardFragmentImplProvider hasEventDashboardFragmentImplProvider, HasReactionAnalyticsParamsImplProvider hasReactionAnalyticsParamsImplProvider, ShouldExpandEventsImplProvider shouldExpandEventsImplProvider) {
        this.f17107b = canFollowUserImpl;
        this.f17108c = canFriendPersonImpl;
        this.f17109d = canHandleHScrollPageChangedEventsImpl;
        this.f17110e = canLikePageImplProvider.a(this);
        this.f17111f = canShowVideoInFullScreenImpl;
        this.f17112g = hasAnchoredTooltipProviderImpl;
        this.f17113h = HasContextImplProvider.a(context);
        this.f17114i = hasEnvironmentControllerImpl;
        this.f17115j = HasFeedListTypeImplProvider.a(feedListType);
        this.f17116k = HasInvalidateImplProvider.a(runnable);
        this.f17117l = hasIsAsyncImpl;
        this.f17118m = hasImageLoadListenerImpl;
        this.f17119n = hasMenuButtonProviderImplProvider.a(this);
        this.f17120o = HasMutationControllerManagerImplProvider.a(mutationControllerManager);
        this.f17121p = hasPersistentStateImpl;
        this.f17122q = hasPositionInformationImpl;
        this.f17123r = hasPrefetcherImplProvider.a(multiRowImagePrefetcherWrapper);
        this.f17124s = hasScrollListenerSupportImplProvider.a(delegate);
        this.f17125t = reactionFeedActionHandlerProvider.a(context2, reactionCardContainer);
        this.f17126u = ReactionFeedEnvironmentEventsImplProvider.m17481a(reactionInteractionTracker, reactionSession);
        this.f17127v = HasEventAnalyticsParamsImplProvider.m17474a(eventAnalyticsParams);
        this.f17128w = hasEventDashboardFilterTypeImpl;
        this.f17129x = HasEventDashboardFragmentImplProvider.m17479a(eventsDiscoveryDashboardFragment);
        this.f17130y = HasReactionAnalyticsParamsImplProvider.a(reactionAnalyticsParams);
        this.f17131z = ShouldExpandEventsImplProvider.m17483a(eventsDashboardItemCollection);
    }

    public final void m17438a(DirtyListener dirtyListener) {
        this.f17116k.a(dirtyListener);
    }

    public final void a_(boolean z) {
        this.f17116k.a_(z);
    }

    public final void m17453b(boolean z) {
        this.f17117l.b(z);
    }

    public final boolean hM_() {
        return this.f17117l.hM_();
    }

    public final EnvironmentController m17447b() {
        return this.f17114i.b();
    }

    public final void m17429a(SimpleScrollListener simpleScrollListener) {
        this.f17124s.a(simpleScrollListener);
    }

    public final void m17449b(SimpleScrollListener simpleScrollListener) {
        this.f17124s.b(simpleScrollListener);
    }

    public final RowKey m17463m() {
        return this.f17123r.m();
    }

    public final void m17431a(RowKey rowKey) {
        this.f17123r.a(rowKey);
    }

    public final void m17464n() {
        this.f17123r.n();
    }

    public final boolean m17465o() {
        return this.f17123r.o();
    }

    public final void m17437a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f17123r.a(imageRequest, callerContext);
    }

    public final MultiRowSinglePartDefinition m17458f() {
        return this.f17122q.f();
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f17122q.hK_();
    }

    public final MultiRowSinglePartDefinition m17459h() {
        return this.f17122q.h();
    }

    public final Object m17460i() {
        return this.f17122q.i();
    }

    public final Object m17461j() {
        return this.f17122q.j();
    }

    public final void m17432a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f17122q.a(multiRowSinglePartDefinition, multiRowSinglePartDefinition2, multiRowSinglePartDefinition3, obj, obj2);
    }

    public final void m17462k() {
        this.f17122q.k();
    }

    public final <K, T> T m17424a(ContextStateKey<K, T> contextStateKey) {
        return this.f17121p.a(contextStateKey);
    }

    public final <K, T> T m17425a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f17121p.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m17446a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f17121p.a(contextStateKey, t);
    }

    public final BaseFeedStoryMenuHelper m17457e() {
        return this.f17119n.e();
    }

    public final void hL_() {
        this.f17116k.hL_();
    }

    public final void m17445a(Object[] objArr) {
        this.f17116k.a(objArr);
    }

    public final void m17444a(FeedProps[] feedPropsArr) {
        this.f17116k.a(feedPropsArr);
    }

    public final void m17427a(DraweeController draweeController, String str, ImageRequest imageRequest) {
        this.f17118m.a(draweeController, str, imageRequest);
    }

    public final FeedListType m17454c() {
        return this.f17115j.c();
    }

    public Context getContext() {
        return this.f17113h.getContext();
    }

    public final void m17434a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase) {
        this.f17112g.a(caretNuxTooltipDelegateBase);
    }

    public final void m17430a(TooltipAnchor tooltipAnchor) {
        this.f17112g.a(tooltipAnchor);
    }

    public final void m17450b(TooltipAnchor tooltipAnchor) {
        this.f17112g.b(tooltipAnchor);
    }

    public final void m17436a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        this.f17111f.a(graphQLStoryAttachment, view);
    }

    public final void m17435a(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f17111f.a(graphQLStoryAttachment);
    }

    public final void m17451b(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f17111f.b(graphQLStoryAttachment);
    }

    public final boolean m17456c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f17111f.c(graphQLStoryAttachment);
    }

    public final void m17433a(FeedProps feedProps, String str, String str2, String str3) {
        this.f17110e.a(feedProps, str, str2, str3);
    }

    public final FriendshipStatus m17423a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, FriendingButtonControllerCallback friendingButtonControllerCallback) {
        return this.f17108c.a(str, str2, friendingLocation, graphQLFriendshipStatus, friendingButtonControllerCallback);
    }

    public final void m17441a(String str, String str2) {
        this.f17107b.a(str, str2);
    }

    public final void m17452b(String str, String str2) {
        this.f17107b.b(str, str2);
    }

    public final void m17440a(ReactionPaginatedComponentsModel reactionPaginatedComponentsModel, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f17106a.a(reactionPaginatedComponentsModel, reactionUnitComponentNode);
    }

    public final void m17426a(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f17109d.a(i, reactionUnitComponentFields, reactionUnitComponentNode);
    }

    public final void m17448b(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f17109d.b(i, reactionUnitComponentFields, reactionUnitComponentNode);
    }

    public final void m17439a(ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f17109d.a(reactionUnitComponentNode);
    }

    public final void m17442a(String str, String str2, ReactionAttachmentIntent reactionAttachmentIntent) {
        this.f17125t.a(str, str2, reactionAttachmentIntent);
    }

    public final void m17443a(String str, String str2, String str3, ReactionAttachmentIntent reactionAttachmentIntent) {
        this.f17125t.a(str, str2, str3, reactionAttachmentIntent);
    }

    public final ReactionAnalyticsParams m17468r() {
        return this.f17130y.r();
    }

    public final ReactionCardContainer m17467q() {
        return this.f17125t.q();
    }

    public final ReactionSession m17466p() {
        return this.f17126u.m17480p();
    }

    public final ReactionInteractionTracker kE_() {
        return this.f17126u.kE_();
    }

    public final EventAnalyticsParams mo794s() {
        return this.f17127v.mo794s();
    }

    public final void mo792a(DashboardFilterType dashboardFilterType) {
        this.f17128w.mo792a(dashboardFilterType);
    }

    public final DashboardFilterType mo795t() {
        return this.f17128w.mo795t();
    }

    public final EventsDiscoveryDashboardFragment mo796u() {
        return this.f17129x.mo796u();
    }

    public final void mo793c(boolean z) {
        this.f17131z.mo793c(z);
    }
}
