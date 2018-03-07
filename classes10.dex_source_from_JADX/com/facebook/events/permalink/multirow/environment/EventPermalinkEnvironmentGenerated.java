package com.facebook.events.permalink.multirow.environment;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.events.feed.ui.EventFeedStoryPinMutator;
import com.facebook.events.feed.ui.EventFeedStoryPinMutatorProvider;
import com.facebook.events.feed.ui.environment.EventFeedEnvironment;
import com.facebook.events.feed.ui.environment.HasEventFeedMenuButtonProviderImpl;
import com.facebook.events.feed.ui.environment.HasEventFeedMenuButtonProviderImplProvider;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.EventPermalinkFragment;
import com.facebook.events.permalink.multirow.CanPostToEventWall;
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
import com.facebook.feed.environment.impl.HasPrefetcherNoOpImpl;
import com.facebook.feed.environment.impl.HasRowKeyImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImplProvider;
import com.facebook.feed.environment.tooltip.TooltipAnchor;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsyncImpl;
import com.facebook.feed.rows.core.parts.EnvironmentController;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.saved.nux.CaretNuxTooltipDelegateBase;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.DirtyListener;
import javax.inject.Inject;

/* compiled from: batch-invite- */
public class EventPermalinkEnvironmentGenerated implements EventFeedEnvironment, CanPostToEventWall {
    private final CanFollowUserImpl f18729a;
    private final CanFriendPersonImpl f18730b;
    private final CanLikePageImpl f18731c;
    private final CanPostToEventWallImpl f18732d;
    private final CanShowVideoInFullScreenImpl f18733e;
    private final EventFeedStoryPinMutator f18734f;
    private final HasAnchoredTooltipProviderImpl f18735g;
    private final HasContextImpl f18736h;
    private final HasEnvironmentControllerImpl f18737i;
    private final HasEventFeedMenuButtonProviderImpl f18738j;
    private final HasFeedListTypeImpl f18739k;
    private final HasImageLoadListenerImpl f18740l;
    private final HasInvalidateImpl f18741m;
    private final HasIsAsyncImpl f18742n;
    private final HasMutationControllerManagerImpl f18743o;
    private final HasPersistentStateImpl f18744p;
    private final HasPositionInformationImpl f18745q;
    private final HasPrefetcherNoOpImpl f18746r;
    private final HasRowKeyImpl f18747s;
    private final HasScrollListenerSupportImpl f18748t;

    @Inject
    public EventPermalinkEnvironmentGenerated(@Assisted EventPermalinkFragment eventPermalinkFragment, @Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted MutationControllerManager mutationControllerManager, @Assisted Delegate delegate, CanFollowUserImpl canFollowUserImpl, CanFriendPersonImpl canFriendPersonImpl, CanLikePageImplProvider canLikePageImplProvider, CanPostToEventWallImpl canPostToEventWallImpl, CanShowVideoInFullScreenImpl canShowVideoInFullScreenImpl, EventFeedStoryPinMutatorProvider eventFeedStoryPinMutatorProvider, HasAnchoredTooltipProviderImpl hasAnchoredTooltipProviderImpl, HasContextImplProvider hasContextImplProvider, HasEnvironmentControllerImpl hasEnvironmentControllerImpl, HasEventFeedMenuButtonProviderImplProvider hasEventFeedMenuButtonProviderImplProvider, HasFeedListTypeImplProvider hasFeedListTypeImplProvider, HasImageLoadListenerImpl hasImageLoadListenerImpl, HasInvalidateImplProvider hasInvalidateImplProvider, HasIsAsyncImpl hasIsAsyncImpl, HasMutationControllerManagerImplProvider hasMutationControllerManagerImplProvider, HasPersistentStateImpl hasPersistentStateImpl, HasPositionInformationImpl hasPositionInformationImpl, HasPrefetcherNoOpImpl hasPrefetcherNoOpImpl, HasRowKeyImpl hasRowKeyImpl, HasScrollListenerSupportImplProvider hasScrollListenerSupportImplProvider) {
        this.f18729a = canFollowUserImpl;
        this.f18730b = canFriendPersonImpl;
        this.f18731c = canLikePageImplProvider.a(this);
        this.f18732d = canPostToEventWallImpl;
        this.f18733e = canShowVideoInFullScreenImpl;
        this.f18734f = eventFeedStoryPinMutatorProvider.m17793a(eventPermalinkFragment);
        this.f18735g = hasAnchoredTooltipProviderImpl;
        this.f18736h = HasContextImplProvider.a(context);
        this.f18737i = hasEnvironmentControllerImpl;
        this.f18738j = hasEventFeedMenuButtonProviderImplProvider.m17843a(this, this);
        this.f18739k = HasFeedListTypeImplProvider.a(feedListType);
        this.f18740l = hasImageLoadListenerImpl;
        this.f18741m = HasInvalidateImplProvider.a(runnable);
        this.f18742n = hasIsAsyncImpl;
        this.f18743o = HasMutationControllerManagerImplProvider.a(mutationControllerManager);
        this.f18744p = hasPersistentStateImpl;
        this.f18745q = hasPositionInformationImpl;
        this.f18746r = hasPrefetcherNoOpImpl;
        this.f18747s = hasRowKeyImpl;
        this.f18748t = hasScrollListenerSupportImplProvider.a(delegate);
    }

    public final void mo847a(Context context, Event event) {
        this.f18732d.mo847a(context, event);
    }

    public final void mo848b(Context context, Event event) {
        this.f18732d.mo848b(context, event);
    }

    public final void m19029a(DirtyListener dirtyListener) {
        this.f18741m.a(dirtyListener);
    }

    public final void a_(boolean z) {
        this.f18741m.a_(z);
    }

    public final void m19041b(boolean z) {
        this.f18742n.b(z);
    }

    public final boolean hM_() {
        return this.f18742n.hM_();
    }

    public final EnvironmentController m19034b() {
        return this.f18737i.b();
    }

    public final void m19019a(SimpleScrollListener simpleScrollListener) {
        this.f18748t.a(simpleScrollListener);
    }

    public final void m19036b(SimpleScrollListener simpleScrollListener) {
        this.f18748t.b(simpleScrollListener);
    }

    public final RowKey m19050m() {
        return this.f18747s.m();
    }

    public final void m19021a(RowKey rowKey) {
        this.f18747s.a(rowKey);
    }

    public final void m19051n() {
        this.f18747s.n();
    }

    public final boolean m19052o() {
        return this.f18747s.o();
    }

    public final void m19028a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f18746r.a(imageRequest, callerContext);
    }

    public final MultiRowSinglePartDefinition m19045f() {
        return this.f18745q.f();
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f18745q.hK_();
    }

    public final MultiRowSinglePartDefinition m19046h() {
        return this.f18745q.h();
    }

    public final Object m19047i() {
        return this.f18745q.i();
    }

    public final Object m19048j() {
        return this.f18745q.j();
    }

    public final void m19022a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f18745q.a(multiRowSinglePartDefinition, multiRowSinglePartDefinition2, multiRowSinglePartDefinition3, obj, obj2);
    }

    public final void m19049k() {
        this.f18745q.k();
    }

    public final <K, T> T m19015a(ContextStateKey<K, T> contextStateKey) {
        return this.f18744p.a(contextStateKey);
    }

    public final <K, T> T m19016a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f18744p.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m19033a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f18744p.a(contextStateKey, t);
    }

    public final BaseFeedStoryMenuHelper m19044e() {
        return this.f18738j.m17842e();
    }

    public final void hL_() {
        this.f18741m.hL_();
    }

    public final void m19032a(Object[] objArr) {
        this.f18741m.a(objArr);
    }

    public final void m19031a(FeedProps[] feedPropsArr) {
        this.f18741m.a(feedPropsArr);
    }

    public final void m19018a(DraweeController draweeController, String str, ImageRequest imageRequest) {
        this.f18740l.a(draweeController, str, imageRequest);
    }

    public final FeedListType m19042c() {
        return this.f18739k.c();
    }

    public Context getContext() {
        return this.f18736h.getContext();
    }

    public final void m19024a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase) {
        this.f18735g.a(caretNuxTooltipDelegateBase);
    }

    public final void m19020a(TooltipAnchor tooltipAnchor) {
        this.f18735g.a(tooltipAnchor);
    }

    public final void m19037b(TooltipAnchor tooltipAnchor) {
        this.f18735g.b(tooltipAnchor);
    }

    public final void m19027a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        this.f18733e.a(graphQLStoryAttachment, view);
    }

    public final void m19026a(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f18733e.a(graphQLStoryAttachment);
    }

    public final void m19039b(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f18733e.b(graphQLStoryAttachment);
    }

    public final boolean m19043c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f18733e.c(graphQLStoryAttachment);
    }

    public final void m19025a(GraphQLStory graphQLStory, Context context) {
        this.f18734f.m17791a(graphQLStory, context);
    }

    public final void m19038b(GraphQLStory graphQLStory, Context context) {
        this.f18734f.m17792b(graphQLStory, context);
    }

    public final void m19023a(FeedProps feedProps, String str, String str2, String str3) {
        this.f18731c.a(feedProps, str, str2, str3);
    }

    public final FriendshipStatus m19014a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, FriendingButtonControllerCallback friendingButtonControllerCallback) {
        return this.f18730b.a(str, str2, friendingLocation, graphQLFriendshipStatus, friendingButtonControllerCallback);
    }

    public final void m19030a(String str, String str2) {
        this.f18729a.a(str, str2);
    }

    public final void m19040b(String str, String str2) {
        this.f18729a.b(str, str2);
    }
}
