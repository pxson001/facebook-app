package com.facebook.search.results.environment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.drawee.interfaces.DraweeController;
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
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.DirtyListener;
import com.facebook.multirow.api.DirtyUnitObserver;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImpl;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImplProvider;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntentImpl;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntentImplProvider;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImpl;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.feed.environment.HasReactionCardBackgroundImpl;
import com.facebook.reaction.feed.environment.HasReactionCardBackgroundImplProvider;
import com.facebook.reaction.feed.environment.HasReactionCardContainerImpl;
import com.facebook.reaction.feed.environment.HasReactionCardContainerImplProvider;
import com.facebook.reaction.feed.environment.HasReactionInteractionTrackerImpl;
import com.facebook.reaction.feed.environment.HasReactionInteractionTrackerImplProvider;
import com.facebook.reaction.feed.environment.HasReactionSessionImpl;
import com.facebook.reaction.feed.environment.HasReactionSessionImplProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandler;
import com.facebook.reaction.feed.environment.ReactionFeedEnvironment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel.ReactionPaginatedComponentsModel;
import com.facebook.search.results.environment.common.CanLogCollectionItemNavigation;
import com.facebook.search.results.environment.common.CanLogCollectionItemNavigationImpl;
import com.facebook.search.results.environment.common.CanLogCollectionItemNavigationImplProvider;
import com.facebook.search.results.environment.entity.CanApplyEntityInlineActionImpl;
import com.facebook.search.results.environment.entity.CanApplyEntityInlineActionImplProvider;
import com.facebook.search.results.environment.entity.CanLogEntityNavigationEntitiesImpl;
import com.facebook.search.results.environment.entity.CanLogEntityNavigationEntitiesImplProvider;
import com.facebook.search.results.environment.entity.CanLogEntityNavigationFeedImpl;
import com.facebook.search.results.environment.entity.CanLogEntityNavigationFeedImplProvider;
import com.facebook.search.results.environment.entity.CanProvideRoleForEntity;
import com.facebook.search.results.environment.entity.CanProvideRoleForEntityFeedImpl;
import com.facebook.search.results.environment.entity.CanProvideRoleForEntityFeedImplProvider;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineActionImpl;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineActionImplProvider;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.environment.tabs.CanSwitchResultPageTab;
import com.facebook.search.results.environment.tabs.CanSwitchResultPageTabImpl;
import com.facebook.search.results.environment.tabs.CanSwitchResultPageTabImplProvider;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentStateImpl;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentStateImplProvider;
import com.facebook.search.results.environment.videos.SearchResultsVideoStoryPersistentState;
import com.facebook.search.results.fragment.tabs.SearchResultsTabsFragment;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import javax.inject.Inject;

/* compiled from: Setting the API options is required. */
public class SearchResultsFeedEnvironmentGenerated implements FeedEnvironment, DirtyUnitObserver, ReactionFeedEnvironment, CanReplaceFeedItem, HasFeedItemPosition, HasSearchResultPosition, HasSearchResultsContext, HasSearchResultsPerformanceLogger, SearchResultsEnvironment, CanLogCollectionItemNavigation, CanProvideRoleForEntity, OldCanApplyEntityInlineAction, OldCanLogEntityNavigation, CanSwitchResultPageTab, HasSearchResultsVideoStoryPersistentState, HasFeedMenuHelper {
    private final HasFeedItemPositionFeedImpl f22585A;
    private final HasSearchResultPositionFeedImpl f22586B;
    private final HasSearchResultsContextImpl f22587C;
    private final HasSearchResultsPerformanceLoggerImpl f22588D;
    private final HasSearchResultsVideoStoryPersistentStateImpl f22589E;
    private final CanReplaceFeedItemFeedImpl f22590F;
    private final CanLogEntityNavigationFeedImpl f22591G;
    private final CanLogEntityNavigationEntitiesImpl f22592H;
    private final CanProvideRoleForEntityFeedImpl f22593I;
    private final OldCanApplyEntityInlineActionImpl f22594J;
    private final CanApplyEntityInlineActionImpl f22595K;
    private final CanSwitchResultPageTabImpl f22596L;
    private final CanLogCollectionItemNavigationImpl f22597M;
    private final CanReplaceSearchResultFeedImpl f22598N;
    private final CanAddReactionComponentsImpl f22599a = CanAddReactionComponentsImplProvider.m23141a(this);
    private final CanFollowUserImpl f22600b;
    private final CanFriendPersonImpl f22601c;
    private final CanHandleHScrollPageChangedEventsImpl f22602d;
    private final CanLaunchReactionIntentImpl f22603e;
    private final CanLikePageImpl f22604f;
    private final CanShowVideoInFullScreenImpl f22605g;
    private final HasAnchoredTooltipProviderImpl f22606h;
    private final HasContextImpl f22607i;
    private final HasEnvironmentControllerImpl f22608j;
    private final HasFeedListTypeImpl f22609k;
    private final HasFeedMenuHelperImpl f22610l;
    private final HasImageLoadListenerImpl f22611m;
    private final HasInvalidateImpl f22612n;
    private final HasIsAsyncImpl f22613o;
    private final HasMenuButtonProviderImpl f22614p;
    private final HasMutationControllerManagerImpl f22615q;
    private final HasPersistentStateImpl f22616r;
    private final HasPositionInformationImpl f22617s;
    private final HasPrefetcherImpl f22618t;
    private final HasReactionAnalyticsParamsImpl f22619u;
    private final HasReactionCardBackgroundImpl f22620v;
    private final HasReactionCardContainerImpl f22621w;
    private final HasReactionInteractionTrackerImpl f22622x;
    private final HasReactionSessionImpl f22623y;
    private final HasScrollListenerSupportImpl f22624z;

    @Inject
    public SearchResultsFeedEnvironmentGenerated(@Assisted ReactionFeedActionHandler reactionFeedActionHandler, @Assisted Context context, @Assisted FeedListType feedListType, @Assisted FeedMenuHelperReference feedMenuHelperReference, @Assisted Runnable runnable, @Assisted MutationControllerManager mutationControllerManager, @Assisted MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper, @Assisted ReactionAnalyticsParams reactionAnalyticsParams, @Assisted Context context2, @Assisted ReactionCardContainer reactionCardContainer, @Assisted ReactionInteractionTracker reactionInteractionTracker, @Assisted ReactionSession reactionSession, @Assisted Delegate delegate, @Assisted SearchResultsFeedCollection searchResultsFeedCollection, @Assisted SearchResultsFeedCollection searchResultsFeedCollection2, @Assisted SearchResultsMutableContext searchResultsMutableContext, @Assisted SearchResultsFeedCollection searchResultsFeedCollection3, @Assisted SearchResultsMutableContext searchResultsMutableContext2, @Assisted SearchResultsFeedCollection searchResultsFeedCollection4, @Assisted SearchResultsFeedCollection searchResultsFeedCollection5, @Assisted SearchResultsTabsFragment searchResultsTabsFragment, @Assisted SearchResultsMutableContext searchResultsMutableContext3, @Assisted SearchResultsFeedCollection searchResultsFeedCollection6, @Assisted SearchResultsFeedCollection searchResultsFeedCollection7, CanAddReactionComponentsImplProvider canAddReactionComponentsImplProvider, CanFollowUserImpl canFollowUserImpl, CanFriendPersonImpl canFriendPersonImpl, CanHandleHScrollPageChangedEventsImpl canHandleHScrollPageChangedEventsImpl, CanLaunchReactionIntentImplProvider canLaunchReactionIntentImplProvider, CanLikePageImplProvider canLikePageImplProvider, CanShowVideoInFullScreenImpl canShowVideoInFullScreenImpl, HasAnchoredTooltipProviderImpl hasAnchoredTooltipProviderImpl, HasContextImplProvider hasContextImplProvider, HasEnvironmentControllerImpl hasEnvironmentControllerImpl, HasFeedListTypeImplProvider hasFeedListTypeImplProvider, HasFeedMenuHelperImplProvider hasFeedMenuHelperImplProvider, HasImageLoadListenerImpl hasImageLoadListenerImpl, HasInvalidateImplProvider hasInvalidateImplProvider, HasIsAsyncImpl hasIsAsyncImpl, HasMenuButtonProviderImplProvider hasMenuButtonProviderImplProvider, HasMutationControllerManagerImplProvider hasMutationControllerManagerImplProvider, HasPersistentStateImpl hasPersistentStateImpl, HasPositionInformationImpl hasPositionInformationImpl, HasPrefetcherImplProvider hasPrefetcherImplProvider, HasReactionAnalyticsParamsImplProvider hasReactionAnalyticsParamsImplProvider, HasReactionCardBackgroundImplProvider hasReactionCardBackgroundImplProvider, HasReactionCardContainerImplProvider hasReactionCardContainerImplProvider, HasReactionInteractionTrackerImplProvider hasReactionInteractionTrackerImplProvider, HasReactionSessionImplProvider hasReactionSessionImplProvider, HasScrollListenerSupportImplProvider hasScrollListenerSupportImplProvider, HasFeedItemPositionFeedImplProvider hasFeedItemPositionFeedImplProvider, HasSearchResultPositionFeedImplProvider hasSearchResultPositionFeedImplProvider, HasSearchResultsContextImplProvider hasSearchResultsContextImplProvider, HasSearchResultsPerformanceLoggerImpl hasSearchResultsPerformanceLoggerImpl, HasSearchResultsVideoStoryPersistentStateImplProvider hasSearchResultsVideoStoryPersistentStateImplProvider, CanReplaceFeedItemFeedImplProvider canReplaceFeedItemFeedImplProvider, CanLogEntityNavigationFeedImplProvider canLogEntityNavigationFeedImplProvider, CanLogEntityNavigationEntitiesImplProvider canLogEntityNavigationEntitiesImplProvider, CanProvideRoleForEntityFeedImplProvider canProvideRoleForEntityFeedImplProvider, OldCanApplyEntityInlineActionImplProvider oldCanApplyEntityInlineActionImplProvider, CanApplyEntityInlineActionImplProvider canApplyEntityInlineActionImplProvider, CanSwitchResultPageTabImplProvider canSwitchResultPageTabImplProvider, CanLogCollectionItemNavigationImplProvider canLogCollectionItemNavigationImplProvider, CanReplaceSearchResultFeedImplProvider canReplaceSearchResultFeedImplProvider) {
        this.f22600b = canFollowUserImpl;
        this.f22601c = canFriendPersonImpl;
        this.f22602d = canHandleHScrollPageChangedEventsImpl;
        this.f22603e = CanLaunchReactionIntentImplProvider.m23148a(reactionFeedActionHandler);
        this.f22604f = canLikePageImplProvider.a(this);
        this.f22605g = canShowVideoInFullScreenImpl;
        this.f22606h = hasAnchoredTooltipProviderImpl;
        this.f22607i = HasContextImplProvider.a(context);
        this.f22608j = hasEnvironmentControllerImpl;
        this.f22609k = HasFeedListTypeImplProvider.a(feedListType);
        this.f22610l = HasFeedMenuHelperImplProvider.m26026a(feedMenuHelperReference);
        this.f22611m = hasImageLoadListenerImpl;
        this.f22612n = HasInvalidateImplProvider.a(runnable);
        this.f22613o = hasIsAsyncImpl;
        this.f22614p = hasMenuButtonProviderImplProvider.a(this);
        this.f22615q = HasMutationControllerManagerImplProvider.a(mutationControllerManager);
        this.f22616r = hasPersistentStateImpl;
        this.f22617s = hasPositionInformationImpl;
        this.f22618t = hasPrefetcherImplProvider.a(multiRowImagePrefetcherWrapper);
        this.f22619u = HasReactionAnalyticsParamsImplProvider.m23151a(reactionAnalyticsParams);
        this.f22620v = HasReactionCardBackgroundImplProvider.m23153a(context2);
        this.f22621w = HasReactionCardContainerImplProvider.m23155a(reactionCardContainer);
        this.f22622x = HasReactionInteractionTrackerImplProvider.m23156a(reactionInteractionTracker);
        this.f22623y = HasReactionSessionImplProvider.m23158a(reactionSession);
        this.f22624z = hasScrollListenerSupportImplProvider.a(delegate);
        this.f22585A = HasFeedItemPositionFeedImplProvider.m26024a(searchResultsFeedCollection);
        this.f22586B = HasSearchResultPositionFeedImplProvider.m26031a(searchResultsFeedCollection2);
        this.f22587C = HasSearchResultsContextImplProvider.m26037a(searchResultsMutableContext);
        this.f22588D = hasSearchResultsPerformanceLoggerImpl;
        this.f22589E = hasSearchResultsVideoStoryPersistentStateImplProvider.m26269a(this);
        this.f22590F = CanReplaceFeedItemFeedImplProvider.m26005a(searchResultsFeedCollection3);
        this.f22591G = canLogEntityNavigationFeedImplProvider.m26231a(searchResultsMutableContext2, searchResultsFeedCollection4);
        this.f22592H = canLogEntityNavigationEntitiesImplProvider.m26229a(this, this);
        this.f22593I = CanProvideRoleForEntityFeedImplProvider.m26238a(searchResultsFeedCollection5);
        this.f22594J = oldCanApplyEntityInlineActionImplProvider.m26246a(this, this, this, this, this);
        this.f22595K = canApplyEntityInlineActionImplProvider.m26227a(this, this, this, this);
        this.f22596L = CanSwitchResultPageTabImplProvider.m26266a(searchResultsTabsFragment);
        this.f22597M = canLogCollectionItemNavigationImplProvider.m26221a(searchResultsMutableContext3, searchResultsFeedCollection6);
        this.f22598N = CanReplaceSearchResultFeedImplProvider.m26012a(searchResultsFeedCollection7, this);
    }

    public final void m26137a(DirtyListener dirtyListener) {
        this.f22612n.a(dirtyListener);
    }

    public final void a_(boolean z) {
        this.f22612n.a_(z);
    }

    public final EnvironmentController m26152b() {
        return this.f22608j.b();
    }

    public final void m26160b(boolean z) {
        this.f22613o.b(z);
    }

    public final boolean hM_() {
        return this.f22613o.hM_();
    }

    public final void m26126a(SimpleScrollListener simpleScrollListener) {
        this.f22624z.a(simpleScrollListener);
    }

    public final void m26154b(SimpleScrollListener simpleScrollListener) {
        this.f22624z.b(simpleScrollListener);
    }

    public final RowKey m26174m() {
        return this.f22618t.m();
    }

    public final void m26128a(RowKey rowKey) {
        this.f22618t.a(rowKey);
    }

    public final void m26175n() {
        this.f22618t.n();
    }

    public final boolean m26176o() {
        return this.f22618t.o();
    }

    public final void m26136a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f22618t.a(imageRequest, callerContext);
    }

    public final MultiRowSinglePartDefinition m26168f() {
        return this.f22617s.f();
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f22617s.hK_();
    }

    public final MultiRowSinglePartDefinition m26169h() {
        return this.f22617s.h();
    }

    public final Object m26170i() {
        return this.f22617s.i();
    }

    public final Object m26171j() {
        return this.f22617s.j();
    }

    public final void m26129a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f22617s.a(multiRowSinglePartDefinition, multiRowSinglePartDefinition2, multiRowSinglePartDefinition3, obj, obj2);
    }

    public final void m26172k() {
        this.f22617s.k();
    }

    public final <K, T> T m26122a(ContextStateKey<K, T> contextStateKey) {
        return this.f22616r.a(contextStateKey);
    }

    public final <K, T> T m26123a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f22616r.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m26149a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f22616r.a(contextStateKey, t);
    }

    public final BaseFeedStoryMenuHelper m26167e() {
        return this.f22614p.e();
    }

    public final void hL_() {
        this.f22612n.hL_();
    }

    public final void m26148a(Object[] objArr) {
        this.f22612n.a(objArr);
    }

    public final void m26147a(FeedProps[] feedPropsArr) {
        this.f22612n.a(feedPropsArr);
    }

    public final void m26125a(DraweeController draweeController, String str, ImageRequest imageRequest) {
        this.f22611m.a(draweeController, str, imageRequest);
    }

    public final FeedListType m26161c() {
        return this.f22609k.c();
    }

    public Context getContext() {
        return this.f22607i.getContext();
    }

    public final void m26131a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase) {
        this.f22606h.a(caretNuxTooltipDelegateBase);
    }

    public final void m26127a(TooltipAnchor tooltipAnchor) {
        this.f22606h.a(tooltipAnchor);
    }

    public final void m26155b(TooltipAnchor tooltipAnchor) {
        this.f22606h.b(tooltipAnchor);
    }

    public final void m26135a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        this.f22605g.a(graphQLStoryAttachment, view);
    }

    public final void m26134a(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f22605g.a(graphQLStoryAttachment);
    }

    public final void m26157b(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f22605g.b(graphQLStoryAttachment);
    }

    public final boolean m26164c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f22605g.c(graphQLStoryAttachment);
    }

    public final void m26130a(FeedProps feedProps, String str, String str2, String str3) {
        this.f22604f.a(feedProps, str, str2, str3);
    }

    public final FriendshipStatus m26120a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, FriendingButtonControllerCallback friendingButtonControllerCallback) {
        return this.f22601c.a(str, str2, friendingLocation, graphQLFriendshipStatus, friendingButtonControllerCallback);
    }

    public final void m26144a(String str, String str2) {
        this.f22600b.a(str, str2);
    }

    public final void m26159b(String str, String str2) {
        this.f22600b.b(str, str2);
    }

    public final BaseFeedStoryMenuHelper m26173l() {
        return this.f22610l.m26025l();
    }

    public final SearchResultsVideoStoryPersistentState mo1254a(FeedProps<GraphQLStory> feedProps, int i) {
        return this.f22589E.mo1254a(feedProps, i);
    }

    public final SearchResultsVideoStoryPersistentState mo1257d(SearchResultsProps searchResultsProps) {
        return this.f22589E.mo1257d(searchResultsProps);
    }

    public final void mo1256c(SearchResultsProps searchResultsProps) {
        this.f22592H.mo1256c(searchResultsProps);
    }

    public final void mo1255b(SearchResultsProps searchResultsProps) {
        this.f22595K.mo1255b(searchResultsProps);
    }

    public final SearchResultsMutableContext mo1248s() {
        return this.f22587C.mo1248s();
    }

    public final int mo1247a(SearchResultsEdgeModel searchResultsEdgeModel) {
        return this.f22586B.mo1247a(searchResultsEdgeModel);
    }

    public final int mo1246a(SearchResultsProps searchResultsProps) {
        return this.f22586B.mo1246a(searchResultsProps);
    }

    public final boolean mo1244a(FeedUnit feedUnit) {
        return this.f22598N.mo1244a(feedUnit);
    }

    public final void mo1243a(SearchResultsEdgeModel searchResultsEdgeModel, SearchResultsEdgeModel searchResultsEdgeModel2) {
        this.f22598N.mo1243a(searchResultsEdgeModel, searchResultsEdgeModel2);
    }

    public final void mo1242a(GraphQLStory graphQLStory) {
        this.f22598N.mo1242a(graphQLStory);
    }

    public final ReactionSession mo704p() {
        return this.f22623y.mo704p();
    }

    public final ReactionInteractionTracker kE_() {
        return this.f22622x.kE_();
    }

    public final ReactionCardContainer mo705q() {
        return this.f22621w.mo705q();
    }

    public final Drawable mo697b(ReactionUnitComponentNode reactionUnitComponentNode) {
        return this.f22620v.mo697b(reactionUnitComponentNode);
    }

    public final ReactionAnalyticsParams mo706r() {
        return this.f22619u.mo706r();
    }

    public final void mo695a(String str, String str2, ReactionAttachmentIntent reactionAttachmentIntent) {
        this.f22603e.mo695a(str, str2, reactionAttachmentIntent);
    }

    public final void mo696a(String str, String str2, String str3, ReactionAttachmentIntent reactionAttachmentIntent) {
        this.f22603e.mo696a(str, str2, str3, reactionAttachmentIntent);
    }

    public final void mo689a(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f22602d.mo689a(i, reactionUnitComponentFields, reactionUnitComponentNode);
    }

    public final void mo698b(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f22602d.mo698b(i, reactionUnitComponentFields, reactionUnitComponentNode);
    }

    public final void mo692a(ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f22602d.mo692a(reactionUnitComponentNode);
    }

    public final void mo694a(ReactionPaginatedComponentsModel reactionPaginatedComponentsModel, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f22599a.mo694a(reactionPaginatedComponentsModel, reactionUnitComponentNode);
    }

    public final int mo1245a(Object obj) {
        return this.f22585A.mo1245a(obj);
    }

    public final void mo1249t() {
        this.f22588D.mo1249t();
    }

    public final void mo1241a(Object obj, Object obj2) {
        this.f22590F.mo1241a(obj, obj2);
    }

    public final void mo1251b(GraphQLNode graphQLNode) {
        this.f22591G.mo1251b(graphQLNode);
    }

    public final GraphQLGraphSearchResultRole mo1252c(GraphQLNode graphQLNode) {
        return this.f22593I.mo1252c(graphQLNode);
    }

    public final String mo1253d(GraphQLNode graphQLNode) {
        return this.f22593I.mo1253d(graphQLNode);
    }

    public final void mo1250a(GraphQLNode graphQLNode) {
        this.f22594J.mo1250a(graphQLNode);
    }

    public final void mo1258a(SearchResultsTab searchResultsTab) {
        this.f22596L.mo1258a(searchResultsTab);
    }

    public final void mo1259a(SearchResultsProductItemUnit searchResultsProductItemUnit) {
        this.f22597M.mo1259a(searchResultsProductItemUnit);
    }
}
