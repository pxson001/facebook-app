package com.facebook.feed.fragment.generatedenvironments;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.CanFollowUser;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.CanFriendPerson.FriendshipStatus;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRefresh;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.environment.HasScrollListenerSupport;
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
import com.facebook.feed.environment.impl.HasRefreshImpl;
import com.facebook.feed.environment.impl.HasRefreshImplProvider;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImplProvider;
import com.facebook.feed.environment.tooltip.TooltipAnchor;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.analytics.HasIsAsyncImpl;
import com.facebook.feed.rows.core.parts.EnvironmentController;
import com.facebook.feed.rows.core.parts.HasEnvironmentController;
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
import com.facebook.multirow.api.DirtyUnitObserver;
import javax.inject.Inject;

/* compiled from: nn */
public class NewsFeedEnvironmentGenerated implements CanFollowUser, CanFriendPerson, CanLikePage, CanShowVideoInFullScreen, FeedEnvironment, HasAnchoredTooltipProvider, HasContext, HasFeedListType, HasImageLoadListener, HasInvalidate, HasMenuButtonProvider, HasPersistentState, HasPositionInformation, HasPrefetcher, HasRefresh, HasRowKey, HasScrollListenerSupport, HasIsAsync, HasEnvironmentController, DirtyUnitObserver {
    private final CanFollowUserImpl f12266a;
    private final CanFriendPersonImpl f12267b;
    private final CanLikePageImpl f12268c;
    private final CanShowVideoInFullScreenImpl f12269d;
    private final HasAnchoredTooltipProviderImpl f12270e;
    private final HasContextImpl f12271f;
    private final HasEnvironmentControllerImpl f12272g;
    private final HasFeedListTypeImpl f12273h;
    private final HasImageLoadListenerImpl f12274i;
    private final HasInvalidateImpl f12275j;
    private final HasIsAsyncImpl f12276k;
    private final HasMenuButtonProviderImpl f12277l;
    private final HasMutationControllerManagerImpl f12278m;
    private final HasPersistentStateImpl f12279n;
    private final HasPositionInformationImpl f12280o;
    private final HasPrefetcherImpl f12281p;
    private final HasScrollListenerSupportImpl f12282q;
    private final HasRefreshImpl f12283r;

    @Inject
    public NewsFeedEnvironmentGenerated(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted MutationControllerManager mutationControllerManager, @Assisted MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper, @Assisted Delegate delegate, @Assisted Runnable runnable2, CanFollowUserImpl canFollowUserImpl, CanFriendPersonImpl canFriendPersonImpl, CanLikePageImplProvider canLikePageImplProvider, CanShowVideoInFullScreenImpl canShowVideoInFullScreenImpl, HasAnchoredTooltipProviderImpl hasAnchoredTooltipProviderImpl, HasContextImplProvider hasContextImplProvider, HasEnvironmentControllerImpl hasEnvironmentControllerImpl, HasFeedListTypeImplProvider hasFeedListTypeImplProvider, HasImageLoadListenerImpl hasImageLoadListenerImpl, HasInvalidateImplProvider hasInvalidateImplProvider, HasIsAsyncImpl hasIsAsyncImpl, HasMenuButtonProviderImplProvider hasMenuButtonProviderImplProvider, HasMutationControllerManagerImplProvider hasMutationControllerManagerImplProvider, HasPersistentStateImpl hasPersistentStateImpl, HasPositionInformationImpl hasPositionInformationImpl, HasPrefetcherImplProvider hasPrefetcherImplProvider, HasScrollListenerSupportImplProvider hasScrollListenerSupportImplProvider, HasRefreshImplProvider hasRefreshImplProvider) {
        this.f12266a = canFollowUserImpl;
        this.f12267b = canFriendPersonImpl;
        this.f12268c = canLikePageImplProvider.m18309a(this);
        this.f12269d = canShowVideoInFullScreenImpl;
        this.f12270e = hasAnchoredTooltipProviderImpl;
        this.f12271f = HasContextImplProvider.m18322a(context);
        this.f12272g = hasEnvironmentControllerImpl;
        this.f12273h = HasFeedListTypeImplProvider.m18332a(feedListType);
        this.f12274i = hasImageLoadListenerImpl;
        this.f12275j = HasInvalidateImplProvider.m18335a(runnable);
        this.f12276k = hasIsAsyncImpl;
        this.f12277l = hasMenuButtonProviderImplProvider.m18338a(this);
        this.f12278m = HasMutationControllerManagerImplProvider.m18339a(mutationControllerManager);
        this.f12279n = hasPersistentStateImpl;
        this.f12280o = hasPositionInformationImpl;
        this.f12281p = hasPrefetcherImplProvider.m18352a(multiRowImagePrefetcherWrapper);
        this.f12282q = hasScrollListenerSupportImplProvider.m18353a(delegate);
        this.f12283r = HasRefreshImplProvider.m18354a(runnable2);
    }

    public final void mo2436a(String str, String str2) {
        this.f12266a.mo2436a(str, str2);
    }

    public final void mo2444b(String str, String str2) {
        this.f12266a.mo2444b(str, str2);
    }

    public final FriendshipStatus mo2423a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, FriendingButtonControllerCallback friendingButtonControllerCallback) {
        return this.f12267b.mo2423a(str, str2, friendingLocation, graphQLFriendshipStatus, friendingButtonControllerCallback);
    }

    public final void mo2430a(FeedProps feedProps, String str, String str2, String str3) {
        this.f12268c.mo2430a(feedProps, str, str2, str3);
    }

    public final void mo2433a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        this.f12269d.mo2433a(graphQLStoryAttachment, view);
    }

    public final void mo2432a(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f12269d.mo2432a(graphQLStoryAttachment);
    }

    public final void mo2443b(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f12269d.mo2443b(graphQLStoryAttachment);
    }

    public final boolean mo2447c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f12269d.mo2447c(graphQLStoryAttachment);
    }

    public final void mo2431a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase) {
        this.f12270e.mo2431a(caretNuxTooltipDelegateBase);
    }

    public final void mo2427a(TooltipAnchor tooltipAnchor) {
        this.f12270e.mo2427a(tooltipAnchor);
    }

    public final void mo2442b(TooltipAnchor tooltipAnchor) {
        this.f12270e.mo2442b(tooltipAnchor);
    }

    public final EnvironmentController mo2441b() {
        return this.f12272g.mo2441b();
    }

    public Context getContext() {
        return this.f12271f.getContext();
    }

    public final FeedListType mo2446c() {
        return this.f12273h.mo2446c();
    }

    public final void mo2426a(DraweeController draweeController, String str, ImageRequest imageRequest) {
        this.f12274i.mo2426a(draweeController, str, imageRequest);
    }

    public final void hL_() {
        this.f12275j.hL_();
    }

    public final void mo2438a(Object[] objArr) {
        this.f12275j.mo2438a(objArr);
    }

    public final void mo2437a(FeedProps[] feedPropsArr) {
        this.f12275j.mo2437a(feedPropsArr);
    }

    public final void mo2445b(boolean z) {
        this.f12276k.mo2445b(z);
    }

    public final boolean hM_() {
        return this.f12276k.hM_();
    }

    public final BaseFeedStoryMenuHelper mo2448e() {
        return this.f12277l.mo2448e();
    }

    public final <K, T> T mo2424a(ContextStateKey<K, T> contextStateKey) {
        return this.f12279n.mo2424a((ContextStateKey) contextStateKey);
    }

    public final <K, T> T mo2425a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f12279n.mo2425a((ContextStateKey) contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean mo2439a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f12279n.mo2439a((ContextStateKey) contextStateKey, (Object) t);
    }

    public final MultiRowSinglePartDefinition mo2449f() {
        return this.f12280o.mo2449f();
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f12280o.hK_();
    }

    public final MultiRowSinglePartDefinition mo2451h() {
        return this.f12280o.mo2451h();
    }

    public final Object mo2455i() {
        return this.f12280o.mo2455i();
    }

    public final Object mo2456j() {
        return this.f12280o.mo2456j();
    }

    public final void mo2429a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f12280o.mo2429a(multiRowSinglePartDefinition, multiRowSinglePartDefinition2, multiRowSinglePartDefinition3, obj, obj2);
    }

    public final void mo2457k() {
        this.f12280o.mo2457k();
    }

    public final void mo2434a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f12281p.mo2434a(imageRequest, callerContext);
    }

    public final RowKey mo2459m() {
        return this.f12281p.mo2459m();
    }

    public final void mo2428a(RowKey rowKey) {
        this.f12281p.mo2428a(rowKey);
    }

    public final void mo2460n() {
        this.f12281p.mo2460n();
    }

    public final boolean mo2461o() {
        return this.f12281p.mo2461o();
    }

    public final void mo2420a(SimpleScrollListener simpleScrollListener) {
        this.f12282q.mo2420a(simpleScrollListener);
    }

    public final void mo2421b(SimpleScrollListener simpleScrollListener) {
        this.f12282q.mo2421b(simpleScrollListener);
    }

    public final void mo2435a(DirtyListener dirtyListener) {
        this.f12275j.mo2435a(dirtyListener);
    }

    public final void a_(boolean z) {
        this.f12275j.a_(z);
    }

    public final void mo2458l() {
        this.f12283r.mo2458l();
    }
}
