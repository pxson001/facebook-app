package com.facebook.feed.environment.impl;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.CanFriendPerson.FriendshipStatus;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasScrollListenerSupport.SimpleScrollListener;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.environment.tooltip.TooltipAnchor;
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
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.multirow.api.DirtyListener;
import com.facebook.multirow.api.DirtyUnitObserver;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: neko_ad */
public abstract class BaseFeedEnvironment implements FeedEnvironment, InjectableComponentWithContext, DirtyUnitObserver {
    @Inject
    HasRowKeyImpl f12855a;
    @Inject
    FeedEnvironmentController f12856b;
    @Inject
    HasPersistentStateImpl f12857c;
    @Inject
    CanLikePageImplProvider f12858d;
    @Inject
    CanShowVideoInFullScreenImpl f12859e;
    @Inject
    CanFollowUserImpl f12860f;
    @Inject
    HasAnchoredTooltipProviderImpl f12861g;
    @Inject
    HasScrollListenerSupportImplProvider f12862h;
    @Inject
    CanFriendPersonImpl f12863i;
    @Inject
    HasInvalidateImplProvider f12864j;
    @Inject
    HasIsAsyncImpl f12865k;
    @Inject
    HasMutationControllerManagerImplProvider f12866l;
    private final Context f12867m;
    private final HasPositionInformationImpl f12868n = new HasPositionInformationImpl();
    private final HasScrollListenerSupportImpl f12869o;
    private final CanLikePageImpl f12870p;
    private final HasInvalidateImpl f12871q;
    private final HasMutationControllerManagerImpl f12872r;

    public static void m18907a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BaseFeedEnvironment) obj).m18906a(HasRowKeyImpl.m18942a(injectorLike), FeedEnvironmentController.m18325a(injectorLike), HasPersistentStateImpl.m18341b(injectorLike), (CanLikePageImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CanLikePageImplProvider.class), CanShowVideoInFullScreenImpl.m18310a(injectorLike), CanFollowUserImpl.m18294b(injectorLike), HasAnchoredTooltipProviderImpl.m18316a(injectorLike), (HasScrollListenerSupportImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(HasScrollListenerSupportImplProvider.class), CanFriendPersonImpl.m18307b(injectorLike), (HasInvalidateImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(HasInvalidateImplProvider.class), HasIsAsyncImpl.m18336a(injectorLike), (HasMutationControllerManagerImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(HasMutationControllerManagerImplProvider.class));
    }

    private void m18906a(HasRowKeyImpl hasRowKeyImpl, FeedEnvironmentController feedEnvironmentController, HasPersistentStateImpl hasPersistentStateImpl, CanLikePageImplProvider canLikePageImplProvider, CanShowVideoInFullScreenImpl canShowVideoInFullScreenImpl, CanFollowUserImpl canFollowUserImpl, HasAnchoredTooltipProviderImpl hasAnchoredTooltipProviderImpl, HasScrollListenerSupportImplProvider hasScrollListenerSupportImplProvider, CanFriendPersonImpl canFriendPersonImpl, HasInvalidateImplProvider hasInvalidateImplProvider, HasIsAsyncImpl hasIsAsyncImpl, HasMutationControllerManagerImplProvider hasMutationControllerManagerImplProvider) {
        this.f12855a = hasRowKeyImpl;
        this.f12856b = feedEnvironmentController;
        this.f12857c = hasPersistentStateImpl;
        this.f12858d = canLikePageImplProvider;
        this.f12859e = canShowVideoInFullScreenImpl;
        this.f12860f = canFollowUserImpl;
        this.f12861g = hasAnchoredTooltipProviderImpl;
        this.f12862h = hasScrollListenerSupportImplProvider;
        this.f12863i = canFriendPersonImpl;
        this.f12864j = hasInvalidateImplProvider;
        this.f12865k = hasIsAsyncImpl;
        this.f12866l = hasMutationControllerManagerImplProvider;
    }

    public BaseFeedEnvironment(Context context, Runnable runnable, Delegate delegate) {
        this.f12867m = context;
        Class cls = BaseFeedEnvironment.class;
        m18907a((Object) this, getContext());
        this.f12871q = HasInvalidateImplProvider.m18335a(runnable);
        this.f12869o = this.f12862h.m18353a(delegate);
        this.f12870p = this.f12858d.m18309a(this);
        this.f12872r = HasMutationControllerManagerImplProvider.m18339a(null);
    }

    public Context getContext() {
        return this.f12867m;
    }

    public final void mo2430a(FeedProps feedProps, String str, String str2, String str3) {
        this.f12870p.mo2430a(feedProps, str, str2, str3);
    }

    public final <K, T> T mo2424a(ContextStateKey<K, T> contextStateKey) {
        return this.f12857c.mo2424a((ContextStateKey) contextStateKey);
    }

    public final <K, T> T mo2425a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f12857c.mo2425a((ContextStateKey) contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean mo2439a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f12857c.mo2439a((ContextStateKey) contextStateKey, (Object) t);
    }

    public final MultiRowSinglePartDefinition mo2449f() {
        return this.f12868n.mo2449f();
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f12868n.hK_();
    }

    public final MultiRowSinglePartDefinition mo2451h() {
        return this.f12868n.mo2451h();
    }

    public final Object mo2455i() {
        return this.f12868n.mo2455i();
    }

    public final Object mo2456j() {
        return this.f12868n.mo2456j();
    }

    public final void mo2429a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f12868n.mo2429a(multiRowSinglePartDefinition, multiRowSinglePartDefinition2, multiRowSinglePartDefinition3, obj, obj2);
    }

    public final void mo2457k() {
        this.f12868n.mo2457k();
    }

    public final void mo2428a(RowKey rowKey) {
        this.f12855a.mo2428a(rowKey);
    }

    public final boolean mo2461o() {
        return this.f12855a.mo2461o();
    }

    public final RowKey mo2459m() {
        return this.f12855a.mo2459m();
    }

    public EnvironmentController mo2441b() {
        return this.f12856b;
    }

    public final void mo2460n() {
        this.f12855a.mo2460n();
    }

    public void mo2434a(ImageRequest imageRequest, CallerContext callerContext) {
    }

    public void m18915a(RowKey rowKey, ImageRequest imageRequest, CallerContext callerContext) {
    }

    public final void mo2426a(DraweeController draweeController, String str, ImageRequest imageRequest) {
    }

    public final FriendshipStatus mo2423a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, @Nullable FriendingButtonControllerCallback friendingButtonControllerCallback) {
        return this.f12863i.mo2423a(str, str2, friendingLocation, graphQLFriendshipStatus, friendingButtonControllerCallback);
    }

    public final void hL_() {
        this.f12871q.hL_();
    }

    public final void a_(boolean z) {
        this.f12871q.a_(z);
    }

    public final void mo2420a(SimpleScrollListener simpleScrollListener) {
        this.f12869o.mo2420a(simpleScrollListener);
    }

    public final void mo2421b(SimpleScrollListener simpleScrollListener) {
        this.f12869o.mo2421b(simpleScrollListener);
    }

    public final void mo2438a(Object... objArr) {
        this.f12871q.mo2438a(objArr);
    }

    public final void mo2437a(FeedProps... feedPropsArr) {
        this.f12871q.mo2437a(feedPropsArr);
    }

    public final void mo2435a(@Nullable DirtyListener dirtyListener) {
        this.f12871q.mo2435a(dirtyListener);
    }

    public void mo2433a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        this.f12859e.mo2433a(graphQLStoryAttachment, view);
    }

    public void mo2432a(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f12859e.mo2432a(graphQLStoryAttachment);
    }

    public void mo2443b(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f12859e.mo2443b(graphQLStoryAttachment);
    }

    public boolean mo2447c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f12859e.mo2447c(graphQLStoryAttachment);
    }

    public final void mo2436a(String str, String str2) {
        this.f12860f.mo2436a(str, str2);
    }

    public final void mo2444b(String str, String str2) {
        this.f12860f.mo2444b(str, str2);
    }

    public final void mo2431a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase) {
        this.f12861g.mo2431a(caretNuxTooltipDelegateBase);
    }

    public final void mo2427a(TooltipAnchor tooltipAnchor) {
        this.f12861g.mo2427a(tooltipAnchor);
    }

    public final void mo2442b(TooltipAnchor tooltipAnchor) {
        this.f12861g.mo2442b(tooltipAnchor);
    }

    public final void mo2445b(boolean z) {
    }

    public final boolean hM_() {
        return this.f12865k.hM_();
    }
}
