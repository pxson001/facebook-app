package com.facebook.timeline.environment;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.CanFriendPerson.FriendshipStatus;
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
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.multirow.api.DirtyListener;
import javax.inject.Inject;

/* compiled from: full_bypass */
public class TimelineEnvironmentGenerated implements TimelineEnvironment {
    private final CanFollowUserImpl f10997a;
    private final CanFriendPersonImpl f10998b;
    private final CanLikePageImpl f10999c;
    private final CanShowVideoInFullScreenImpl f11000d;
    private final HasAnchoredTooltipProviderImpl f11001e;
    private final HasContextImpl f11002f;
    private final HasEnvironmentControllerImpl f11003g;
    private final HasFeedListTypeImpl f11004h;
    private final HasInvalidateImpl f11005i;
    private final HasIsAsyncImpl f11006j;
    private final HasMenuButtonProviderImpl f11007k;
    private final HasMutationControllerManagerImpl f11008l;
    private final HasPersistentStateImpl f11009m;
    private final HasPositionInformationImpl f11010n;
    private final HasScrollListenerSupportImpl f11011o;
    private final HasPrefetcherImpl f11012p;
    private final HasImageLoadListenerImpl f11013q;
    private final HasTimelineContextImpl f11014r;
    public final HasProfileNameImpl f11015s;

    @Inject
    public TimelineEnvironmentGenerated(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted MutationControllerManager mutationControllerManager, @Assisted Delegate delegate, @Assisted MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper, @Assisted TimelineContext timelineContext, @Assisted String str, CanFollowUserImpl canFollowUserImpl, CanFriendPersonImpl canFriendPersonImpl, CanLikePageImplProvider canLikePageImplProvider, CanShowVideoInFullScreenImpl canShowVideoInFullScreenImpl, HasAnchoredTooltipProviderImpl hasAnchoredTooltipProviderImpl, HasContextImplProvider hasContextImplProvider, HasEnvironmentControllerImpl hasEnvironmentControllerImpl, HasFeedListTypeImplProvider hasFeedListTypeImplProvider, HasInvalidateImplProvider hasInvalidateImplProvider, HasIsAsyncImpl hasIsAsyncImpl, HasMenuButtonProviderImplProvider hasMenuButtonProviderImplProvider, HasMutationControllerManagerImplProvider hasMutationControllerManagerImplProvider, HasPersistentStateImpl hasPersistentStateImpl, HasPositionInformationImpl hasPositionInformationImpl, HasScrollListenerSupportImplProvider hasScrollListenerSupportImplProvider, HasPrefetcherImplProvider hasPrefetcherImplProvider, HasImageLoadListenerImpl hasImageLoadListenerImpl, HasTimelineContextImplProvider hasTimelineContextImplProvider, HasProfileNameImplProvider hasProfileNameImplProvider) {
        this.f10997a = canFollowUserImpl;
        this.f10998b = canFriendPersonImpl;
        this.f10999c = canLikePageImplProvider.a(this);
        this.f11000d = canShowVideoInFullScreenImpl;
        this.f11001e = hasAnchoredTooltipProviderImpl;
        this.f11002f = HasContextImplProvider.a(context);
        this.f11003g = hasEnvironmentControllerImpl;
        this.f11004h = HasFeedListTypeImplProvider.a(feedListType);
        this.f11005i = HasInvalidateImplProvider.a(runnable);
        this.f11006j = hasIsAsyncImpl;
        this.f11007k = hasMenuButtonProviderImplProvider.m11105a(this);
        this.f11008l = HasMutationControllerManagerImplProvider.a(mutationControllerManager);
        this.f11009m = hasPersistentStateImpl;
        this.f11010n = hasPositionInformationImpl;
        this.f11011o = hasScrollListenerSupportImplProvider.a(delegate);
        this.f11012p = hasPrefetcherImplProvider.a(multiRowImagePrefetcherWrapper);
        this.f11013q = hasImageLoadListenerImpl;
        this.f11014r = HasTimelineContextImplProvider.m11109a(timelineContext);
        this.f11015s = HasProfileNameImplProvider.m11108a(str);
    }

    public final void m11124a(String str, String str2) {
        this.f10997a.a(str, str2);
    }

    public final void m11132b(String str, String str2) {
        this.f10997a.b(str, str2);
    }

    public final void m11118a(FeedProps feedProps, String str, String str2, String str3) {
        this.f10999c.a(feedProps, str, str2, str3);
    }

    public final void m11121a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        this.f11000d.a(graphQLStoryAttachment, view);
    }

    public final void m11120a(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f11000d.a(graphQLStoryAttachment);
    }

    public final void m11131b(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f11000d.b(graphQLStoryAttachment);
    }

    public final boolean m11135c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f11000d.c(graphQLStoryAttachment);
    }

    public Context getContext() {
        return this.f11002f.getContext();
    }

    public final EnvironmentController m11128b() {
        return this.f11003g.b();
    }

    public final FeedListType m11134c() {
        return this.f11004h.c();
    }

    public final void hL_() {
        this.f11005i.hL_();
    }

    public final void m11126a(Object[] objArr) {
        this.f11005i.a(objArr);
    }

    public final void m11125a(FeedProps[] feedPropsArr) {
        this.f11005i.a(feedPropsArr);
    }

    public final BaseFeedStoryMenuHelper m11136e() {
        return this.f11007k.m11104e();
    }

    public final <K, T> T m11111a(ContextStateKey<K, T> contextStateKey) {
        return this.f11009m.a(contextStateKey);
    }

    public final <K, T> T m11112a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f11009m.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m11127a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f11009m.a(contextStateKey, t);
    }

    public final MultiRowSinglePartDefinition m11137f() {
        return this.f11010n.f();
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f11010n.hK_();
    }

    public final MultiRowSinglePartDefinition m11138h() {
        return this.f11010n.h();
    }

    public final Object m11139i() {
        return this.f11010n.i();
    }

    public final Object m11140j() {
        return this.f11010n.j();
    }

    public final void m11117a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f11010n.a(multiRowSinglePartDefinition, multiRowSinglePartDefinition2, multiRowSinglePartDefinition3, obj, obj2);
    }

    public final void m11141k() {
        this.f11010n.k();
    }

    public final RowKey m11143m() {
        return this.f11012p.m();
    }

    public final void m11116a(RowKey rowKey) {
        this.f11012p.a(rowKey);
    }

    public final void m11144n() {
        this.f11012p.n();
    }

    public final boolean m11145o() {
        return this.f11012p.o();
    }

    public final void m11114a(SimpleScrollListener simpleScrollListener) {
        this.f11011o.a(simpleScrollListener);
    }

    public final void m11129b(SimpleScrollListener simpleScrollListener) {
        this.f11011o.b(simpleScrollListener);
    }

    public final void m11123a(DirtyListener dirtyListener) {
        this.f11005i.a(dirtyListener);
    }

    public final void a_(boolean z) {
        this.f11005i.a_(z);
    }

    public final String mo519l() {
        return this.f11015s.mo519l();
    }

    public final void m11133b(boolean z) {
        this.f11006j.b(z);
    }

    public final boolean hM_() {
        return this.f11006j.hM_();
    }

    public final void m11122a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f11012p.a(imageRequest, callerContext);
    }

    public final void m11113a(DraweeController draweeController, String str, ImageRequest imageRequest) {
        this.f11013q.a(draweeController, str, imageRequest);
    }

    public final void m11119a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase) {
        this.f11001e.a(caretNuxTooltipDelegateBase);
    }

    public final void m11115a(TooltipAnchor tooltipAnchor) {
        this.f11001e.a(tooltipAnchor);
    }

    public final void m11130b(TooltipAnchor tooltipAnchor) {
        this.f11001e.b(tooltipAnchor);
    }

    public final FriendshipStatus m11110a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, FriendingButtonControllerCallback friendingButtonControllerCallback) {
        return this.f10998b.a(str, str2, friendingLocation, graphQLFriendshipStatus, friendingButtonControllerCallback);
    }
}
