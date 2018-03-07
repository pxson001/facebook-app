package com.facebook.redspace.rows;

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
import com.facebook.timeline.environment.HasMenuButtonProviderImpl;
import com.facebook.timeline.environment.HasMenuButtonProviderImplProvider;
import com.facebook.timeline.environment.HasProfileNameImpl;
import com.facebook.timeline.environment.HasProfileNameImplProvider;
import com.facebook.timeline.environment.HasTimelineContextImpl;
import com.facebook.timeline.environment.HasTimelineContextImplProvider;
import com.facebook.timeline.environment.TimelineEnvironment;
import javax.inject.Inject;

/* compiled from: PageFetchCardsData */
public class RedSpaceEnvironmentGenerated implements TimelineEnvironment {
    private final CanFollowUserImpl f12168a;
    private final CanFriendPersonImpl f12169b;
    private final CanLikePageImpl f12170c;
    private final CanShowVideoInFullScreenImpl f12171d;
    private final HasAnchoredTooltipProviderImpl f12172e;
    private final HasContextImpl f12173f;
    private final HasEnvironmentControllerImpl f12174g;
    private final HasFeedListTypeImpl f12175h;
    private final HasInvalidateImpl f12176i;
    private final HasIsAsyncImpl f12177j;
    private final HasMenuButtonProviderImpl f12178k;
    private final HasMutationControllerManagerImpl f12179l;
    private final HasPersistentStateImpl f12180m;
    private final HasPositionInformationImpl f12181n;
    private final HasScrollListenerSupportImpl f12182o;
    private final HasPrefetcherImpl f12183p;
    private final HasImageLoadListenerImpl f12184q;
    private final HasTimelineContextImpl f12185r;
    private final HasProfileNameImpl f12186s;

    @Inject
    public RedSpaceEnvironmentGenerated(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted MutationControllerManager mutationControllerManager, @Assisted Delegate delegate, @Assisted MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper, @Assisted TimelineContext timelineContext, @Assisted String str, CanFollowUserImpl canFollowUserImpl, CanFriendPersonImpl canFriendPersonImpl, CanLikePageImplProvider canLikePageImplProvider, CanShowVideoInFullScreenImpl canShowVideoInFullScreenImpl, HasAnchoredTooltipProviderImpl hasAnchoredTooltipProviderImpl, HasContextImplProvider hasContextImplProvider, HasEnvironmentControllerImpl hasEnvironmentControllerImpl, HasFeedListTypeImplProvider hasFeedListTypeImplProvider, HasInvalidateImplProvider hasInvalidateImplProvider, HasIsAsyncImpl hasIsAsyncImpl, HasMenuButtonProviderImplProvider hasMenuButtonProviderImplProvider, HasMutationControllerManagerImplProvider hasMutationControllerManagerImplProvider, HasPersistentStateImpl hasPersistentStateImpl, HasPositionInformationImpl hasPositionInformationImpl, HasScrollListenerSupportImplProvider hasScrollListenerSupportImplProvider, HasPrefetcherImplProvider hasPrefetcherImplProvider, HasImageLoadListenerImpl hasImageLoadListenerImpl, HasTimelineContextImplProvider hasTimelineContextImplProvider, HasProfileNameImplProvider hasProfileNameImplProvider) {
        this.f12168a = canFollowUserImpl;
        this.f12169b = canFriendPersonImpl;
        this.f12170c = canLikePageImplProvider.a(this);
        this.f12171d = canShowVideoInFullScreenImpl;
        this.f12172e = hasAnchoredTooltipProviderImpl;
        this.f12173f = HasContextImplProvider.a(context);
        this.f12174g = hasEnvironmentControllerImpl;
        this.f12175h = HasFeedListTypeImplProvider.a(feedListType);
        this.f12176i = HasInvalidateImplProvider.a(runnable);
        this.f12177j = hasIsAsyncImpl;
        this.f12178k = hasMenuButtonProviderImplProvider.a(this);
        this.f12179l = HasMutationControllerManagerImplProvider.a(mutationControllerManager);
        this.f12180m = hasPersistentStateImpl;
        this.f12181n = hasPositionInformationImpl;
        this.f12182o = hasScrollListenerSupportImplProvider.a(delegate);
        this.f12183p = hasPrefetcherImplProvider.a(multiRowImagePrefetcherWrapper);
        this.f12184q = hasImageLoadListenerImpl;
        this.f12185r = HasTimelineContextImplProvider.a(timelineContext);
        this.f12186s = HasProfileNameImplProvider.a(str);
    }

    public final void m12630a(DirtyListener dirtyListener) {
        this.f12176i.a(dirtyListener);
    }

    public final void a_(boolean z) {
        this.f12176i.a_(z);
    }

    public final String m12649l() {
        return this.f12186s.l();
    }

    public final void m12640b(boolean z) {
        this.f12177j.b(z);
    }

    public final boolean hM_() {
        return this.f12177j.hM_();
    }

    public final EnvironmentController m12635b() {
        return this.f12174g.b();
    }

    public final void m12621a(SimpleScrollListener simpleScrollListener) {
        this.f12182o.a(simpleScrollListener);
    }

    public final void m12636b(SimpleScrollListener simpleScrollListener) {
        this.f12182o.b(simpleScrollListener);
    }

    public final RowKey m12650m() {
        return this.f12183p.m();
    }

    public final void m12623a(RowKey rowKey) {
        this.f12183p.a(rowKey);
    }

    public final void m12651n() {
        this.f12183p.n();
    }

    public final boolean m12652o() {
        return this.f12183p.o();
    }

    public final void m12629a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f12183p.a(imageRequest, callerContext);
    }

    public final MultiRowSinglePartDefinition m12644f() {
        return this.f12181n.f();
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f12181n.hK_();
    }

    public final MultiRowSinglePartDefinition m12645h() {
        return this.f12181n.h();
    }

    public final Object m12646i() {
        return this.f12181n.i();
    }

    public final Object m12647j() {
        return this.f12181n.j();
    }

    public final void m12624a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f12181n.a(multiRowSinglePartDefinition, multiRowSinglePartDefinition2, multiRowSinglePartDefinition3, obj, obj2);
    }

    public final void m12648k() {
        this.f12181n.k();
    }

    public final <K, T> T m12618a(ContextStateKey<K, T> contextStateKey) {
        return this.f12180m.a(contextStateKey);
    }

    public final <K, T> T m12619a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f12180m.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m12634a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f12180m.a(contextStateKey, t);
    }

    public final BaseFeedStoryMenuHelper m12643e() {
        return this.f12178k.e();
    }

    public final void hL_() {
        this.f12176i.hL_();
    }

    public final void m12633a(Object[] objArr) {
        this.f12176i.a(objArr);
    }

    public final void m12632a(FeedProps[] feedPropsArr) {
        this.f12176i.a(feedPropsArr);
    }

    public final void m12620a(DraweeController draweeController, String str, ImageRequest imageRequest) {
        this.f12184q.a(draweeController, str, imageRequest);
    }

    public final FeedListType m12641c() {
        return this.f12175h.c();
    }

    public Context getContext() {
        return this.f12173f.getContext();
    }

    public final void m12626a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase) {
        this.f12172e.a(caretNuxTooltipDelegateBase);
    }

    public final void m12622a(TooltipAnchor tooltipAnchor) {
        this.f12172e.a(tooltipAnchor);
    }

    public final void m12637b(TooltipAnchor tooltipAnchor) {
        this.f12172e.b(tooltipAnchor);
    }

    public final void m12628a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        this.f12171d.a(graphQLStoryAttachment, view);
    }

    public final void m12627a(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f12171d.a(graphQLStoryAttachment);
    }

    public final void m12638b(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f12171d.b(graphQLStoryAttachment);
    }

    public final boolean m12642c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f12171d.c(graphQLStoryAttachment);
    }

    public final void m12625a(FeedProps feedProps, String str, String str2, String str3) {
        this.f12170c.a(feedProps, str, str2, str3);
    }

    public final FriendshipStatus m12617a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, FriendingButtonControllerCallback friendingButtonControllerCallback) {
        return this.f12169b.a(str, str2, friendingLocation, graphQLFriendshipStatus, friendingButtonControllerCallback);
    }

    public final void m12631a(String str, String str2) {
        this.f12168a.a(str, str2);
    }

    public final void m12639b(String str, String str2) {
        this.f12168a.b(str, str2);
    }
}
