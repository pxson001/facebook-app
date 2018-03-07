package com.facebook.events.feed.ui.environment;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.events.feed.ui.EventFeedStoryPinMutator;
import com.facebook.events.feed.ui.EventFeedStoryPinMutatorProvider;
import com.facebook.events.permalink.EventPermalinkFragment;
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

/* compiled from: com.facebook.AccessTokenManager.SharedPreferences */
public class EventFeedEnvironmentGenerated implements EventFeedEnvironment {
    private final CanFollowUserImpl f17457a;
    private final CanFriendPersonImpl f17458b;
    private final CanLikePageImpl f17459c;
    private final CanShowVideoInFullScreenImpl f17460d;
    private final EventFeedStoryPinMutator f17461e;
    private final HasAnchoredTooltipProviderImpl f17462f;
    private final HasContextImpl f17463g;
    private final HasEnvironmentControllerImpl f17464h;
    private final HasEventFeedMenuButtonProviderImpl f17465i;
    private final HasFeedListTypeImpl f17466j;
    private final HasImageLoadListenerImpl f17467k;
    private final HasInvalidateImpl f17468l;
    private final HasIsAsyncImpl f17469m;
    private final HasMutationControllerManagerImpl f17470n;
    private final HasPersistentStateImpl f17471o;
    private final HasPositionInformationImpl f17472p;
    private final HasPrefetcherNoOpImpl f17473q;
    private final HasRowKeyImpl f17474r;
    private final HasScrollListenerSupportImpl f17475s;

    @Inject
    public EventFeedEnvironmentGenerated(@Assisted EventPermalinkFragment eventPermalinkFragment, @Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted MutationControllerManager mutationControllerManager, @Assisted Delegate delegate, CanFollowUserImpl canFollowUserImpl, CanFriendPersonImpl canFriendPersonImpl, CanLikePageImplProvider canLikePageImplProvider, CanShowVideoInFullScreenImpl canShowVideoInFullScreenImpl, EventFeedStoryPinMutatorProvider eventFeedStoryPinMutatorProvider, HasAnchoredTooltipProviderImpl hasAnchoredTooltipProviderImpl, HasContextImplProvider hasContextImplProvider, HasEnvironmentControllerImpl hasEnvironmentControllerImpl, HasEventFeedMenuButtonProviderImplProvider hasEventFeedMenuButtonProviderImplProvider, HasFeedListTypeImplProvider hasFeedListTypeImplProvider, HasImageLoadListenerImpl hasImageLoadListenerImpl, HasInvalidateImplProvider hasInvalidateImplProvider, HasIsAsyncImpl hasIsAsyncImpl, HasMutationControllerManagerImplProvider hasMutationControllerManagerImplProvider, HasPersistentStateImpl hasPersistentStateImpl, HasPositionInformationImpl hasPositionInformationImpl, HasPrefetcherNoOpImpl hasPrefetcherNoOpImpl, HasRowKeyImpl hasRowKeyImpl, HasScrollListenerSupportImplProvider hasScrollListenerSupportImplProvider) {
        this.f17457a = canFollowUserImpl;
        this.f17458b = canFriendPersonImpl;
        this.f17459c = canLikePageImplProvider.a(this);
        this.f17460d = canShowVideoInFullScreenImpl;
        this.f17461e = eventFeedStoryPinMutatorProvider.m17793a(eventPermalinkFragment);
        this.f17462f = hasAnchoredTooltipProviderImpl;
        this.f17463g = HasContextImplProvider.a(context);
        this.f17464h = hasEnvironmentControllerImpl;
        this.f17465i = hasEventFeedMenuButtonProviderImplProvider.m17843a(this, this);
        this.f17466j = HasFeedListTypeImplProvider.a(feedListType);
        this.f17467k = hasImageLoadListenerImpl;
        this.f17468l = HasInvalidateImplProvider.a(runnable);
        this.f17469m = hasIsAsyncImpl;
        this.f17470n = HasMutationControllerManagerImplProvider.a(mutationControllerManager);
        this.f17471o = hasPersistentStateImpl;
        this.f17472p = hasPositionInformationImpl;
        this.f17473q = hasPrefetcherNoOpImpl;
        this.f17474r = hasRowKeyImpl;
        this.f17475s = hasScrollListenerSupportImplProvider.a(delegate);
    }

    public final void m17814a(GraphQLStory graphQLStory, Context context) {
        this.f17461e.m17791a(graphQLStory, context);
    }

    public final void m17826b(GraphQLStory graphQLStory, Context context) {
        this.f17461e.m17792b(graphQLStory, context);
    }

    public final void m17818a(DirtyListener dirtyListener) {
        this.f17468l.a(dirtyListener);
    }

    public final void a_(boolean z) {
        this.f17468l.a_(z);
    }

    public final void m17829b(boolean z) {
        this.f17469m.b(z);
    }

    public final boolean hM_() {
        return this.f17469m.hM_();
    }

    public final EnvironmentController m17823b() {
        return this.f17464h.b();
    }

    public final void m17808a(SimpleScrollListener simpleScrollListener) {
        this.f17475s.a(simpleScrollListener);
    }

    public final void m17824b(SimpleScrollListener simpleScrollListener) {
        this.f17475s.b(simpleScrollListener);
    }

    public final RowKey m17838m() {
        return this.f17474r.m();
    }

    public final void m17810a(RowKey rowKey) {
        this.f17474r.a(rowKey);
    }

    public final void m17839n() {
        this.f17474r.n();
    }

    public final boolean m17840o() {
        return this.f17474r.o();
    }

    public final void m17817a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f17473q.a(imageRequest, callerContext);
    }

    public final MultiRowSinglePartDefinition m17833f() {
        return this.f17472p.f();
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f17472p.hK_();
    }

    public final MultiRowSinglePartDefinition m17834h() {
        return this.f17472p.h();
    }

    public final Object m17835i() {
        return this.f17472p.i();
    }

    public final Object m17836j() {
        return this.f17472p.j();
    }

    public final void m17811a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f17472p.a(multiRowSinglePartDefinition, multiRowSinglePartDefinition2, multiRowSinglePartDefinition3, obj, obj2);
    }

    public final void m17837k() {
        this.f17472p.k();
    }

    public final <K, T> T m17805a(ContextStateKey<K, T> contextStateKey) {
        return this.f17471o.a(contextStateKey);
    }

    public final <K, T> T m17806a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f17471o.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m17822a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f17471o.a(contextStateKey, t);
    }

    public final BaseFeedStoryMenuHelper m17832e() {
        return this.f17465i.m17842e();
    }

    public final void hL_() {
        this.f17468l.hL_();
    }

    public final void m17821a(Object[] objArr) {
        this.f17468l.a(objArr);
    }

    public final void m17820a(FeedProps[] feedPropsArr) {
        this.f17468l.a(feedPropsArr);
    }

    public final void m17807a(DraweeController draweeController, String str, ImageRequest imageRequest) {
        this.f17467k.a(draweeController, str, imageRequest);
    }

    public final FeedListType m17830c() {
        return this.f17466j.c();
    }

    public Context getContext() {
        return this.f17463g.getContext();
    }

    public final void m17813a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase) {
        this.f17462f.a(caretNuxTooltipDelegateBase);
    }

    public final void m17809a(TooltipAnchor tooltipAnchor) {
        this.f17462f.a(tooltipAnchor);
    }

    public final void m17825b(TooltipAnchor tooltipAnchor) {
        this.f17462f.b(tooltipAnchor);
    }

    public final void m17816a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        this.f17460d.a(graphQLStoryAttachment, view);
    }

    public final void m17815a(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f17460d.a(graphQLStoryAttachment);
    }

    public final void m17827b(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f17460d.b(graphQLStoryAttachment);
    }

    public final boolean m17831c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f17460d.c(graphQLStoryAttachment);
    }

    public final void m17812a(FeedProps feedProps, String str, String str2, String str3) {
        this.f17459c.a(feedProps, str, str2, str3);
    }

    public final FriendshipStatus m17804a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, FriendingButtonControllerCallback friendingButtonControllerCallback) {
        return this.f17458b.a(str, str2, friendingLocation, graphQLFriendshipStatus, friendingButtonControllerCallback);
    }

    public final void m17819a(String str, String str2) {
        this.f17457a.a(str, str2);
    }

    public final void m17828b(String str, String str2) {
        this.f17457a.b(str, str2);
    }
}
