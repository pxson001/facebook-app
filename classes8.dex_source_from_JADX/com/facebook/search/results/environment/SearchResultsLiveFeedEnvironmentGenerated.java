package com.facebook.search.results.environment;

import android.content.Context;
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
import com.facebook.feed.environment.impl.HasPrefetcherNoOpImpl;
import com.facebook.feed.environment.impl.HasRowKeyImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImplProvider;
import com.facebook.feed.environment.tooltip.TooltipAnchor;
import com.facebook.feed.fragment.generatedenvironments.HasMenuButtonProviderImpl;
import com.facebook.feed.fragment.generatedenvironments.HasMenuButtonProviderImplProvider;
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
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.DirtyListener;
import com.facebook.search.results.model.SearchResultsMutableContext;
import javax.inject.Inject;

/* compiled from: SetCoverPhotoMethod must be called withsetCoverPhotoParams.getUseExistingPhoto() == true */
public class SearchResultsLiveFeedEnvironmentGenerated implements FeedEnvironment, HasSearchResultsContext {
    private final CanFollowUserImpl f22625a;
    private final CanFriendPersonImpl f22626b;
    private final CanLikePageImpl f22627c;
    private final CanShowVideoInFullScreenImpl f22628d;
    private final HasAnchoredTooltipProviderImpl f22629e;
    private final HasContextImpl f22630f;
    private final HasEnvironmentControllerImpl f22631g;
    private final HasFeedListTypeImpl f22632h;
    private final HasImageLoadListenerImpl f22633i;
    private final HasInvalidateImpl f22634j;
    private final HasIsAsyncImpl f22635k;
    private final HasMenuButtonProviderImpl f22636l;
    private final HasMutationControllerManagerImpl f22637m;
    private final HasPersistentStateImpl f22638n;
    private final HasPositionInformationImpl f22639o;
    private final HasPrefetcherNoOpImpl f22640p;
    private final HasRowKeyImpl f22641q;
    private final HasSearchResultsContextImpl f22642r;
    private final HasScrollListenerSupportImpl f22643s;

    @Inject
    public SearchResultsLiveFeedEnvironmentGenerated(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted MutationControllerManager mutationControllerManager, @Assisted SearchResultsMutableContext searchResultsMutableContext, @Assisted Delegate delegate, CanFollowUserImpl canFollowUserImpl, CanFriendPersonImpl canFriendPersonImpl, CanLikePageImplProvider canLikePageImplProvider, CanShowVideoInFullScreenImpl canShowVideoInFullScreenImpl, HasAnchoredTooltipProviderImpl hasAnchoredTooltipProviderImpl, HasContextImplProvider hasContextImplProvider, HasEnvironmentControllerImpl hasEnvironmentControllerImpl, HasFeedListTypeImplProvider hasFeedListTypeImplProvider, HasImageLoadListenerImpl hasImageLoadListenerImpl, HasInvalidateImplProvider hasInvalidateImplProvider, HasIsAsyncImpl hasIsAsyncImpl, HasMenuButtonProviderImplProvider hasMenuButtonProviderImplProvider, HasMutationControllerManagerImplProvider hasMutationControllerManagerImplProvider, HasPersistentStateImpl hasPersistentStateImpl, HasPositionInformationImpl hasPositionInformationImpl, HasPrefetcherNoOpImpl hasPrefetcherNoOpImpl, HasRowKeyImpl hasRowKeyImpl, HasSearchResultsContextImplProvider hasSearchResultsContextImplProvider, HasScrollListenerSupportImplProvider hasScrollListenerSupportImplProvider) {
        this.f22625a = canFollowUserImpl;
        this.f22626b = canFriendPersonImpl;
        this.f22627c = canLikePageImplProvider.a(this);
        this.f22628d = canShowVideoInFullScreenImpl;
        this.f22629e = hasAnchoredTooltipProviderImpl;
        this.f22630f = HasContextImplProvider.a(context);
        this.f22631g = hasEnvironmentControllerImpl;
        this.f22632h = HasFeedListTypeImplProvider.a(feedListType);
        this.f22633i = hasImageLoadListenerImpl;
        this.f22634j = HasInvalidateImplProvider.a(runnable);
        this.f22635k = hasIsAsyncImpl;
        this.f22636l = hasMenuButtonProviderImplProvider.a(this);
        this.f22637m = HasMutationControllerManagerImplProvider.a(mutationControllerManager);
        this.f22638n = hasPersistentStateImpl;
        this.f22639o = hasPositionInformationImpl;
        this.f22640p = hasPrefetcherNoOpImpl;
        this.f22641q = hasRowKeyImpl;
        this.f22642r = HasSearchResultsContextImplProvider.m26037a(searchResultsMutableContext);
        this.f22643s = hasScrollListenerSupportImplProvider.a(delegate);
    }

    public final void m26196a(DirtyListener dirtyListener) {
        this.f22634j.a(dirtyListener);
    }

    public final void a_(boolean z) {
        this.f22634j.a_(z);
    }

    public final EnvironmentController m26201b() {
        return this.f22631g.b();
    }

    public final void m26206b(boolean z) {
        this.f22635k.b(z);
    }

    public final boolean hM_() {
        return this.f22635k.hM_();
    }

    public final void m26187a(SimpleScrollListener simpleScrollListener) {
        this.f22643s.a(simpleScrollListener);
    }

    public final void m26202b(SimpleScrollListener simpleScrollListener) {
        this.f22643s.b(simpleScrollListener);
    }

    public final RowKey m26215m() {
        return this.f22641q.m();
    }

    public final void m26189a(RowKey rowKey) {
        this.f22641q.a(rowKey);
    }

    public final void m26216n() {
        this.f22641q.n();
    }

    public final boolean m26217o() {
        return this.f22641q.o();
    }

    public final void m26195a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f22640p.a(imageRequest, callerContext);
    }

    public final MultiRowSinglePartDefinition m26210f() {
        return this.f22639o.f();
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f22639o.hK_();
    }

    public final MultiRowSinglePartDefinition m26211h() {
        return this.f22639o.h();
    }

    public final Object m26212i() {
        return this.f22639o.i();
    }

    public final Object m26213j() {
        return this.f22639o.j();
    }

    public final void m26190a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f22639o.a(multiRowSinglePartDefinition, multiRowSinglePartDefinition2, multiRowSinglePartDefinition3, obj, obj2);
    }

    public final void m26214k() {
        this.f22639o.k();
    }

    public final <K, T> T m26184a(ContextStateKey<K, T> contextStateKey) {
        return this.f22638n.a(contextStateKey);
    }

    public final <K, T> T m26185a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f22638n.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m26200a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f22638n.a(contextStateKey, t);
    }

    public final BaseFeedStoryMenuHelper m26209e() {
        return this.f22636l.e();
    }

    public final void hL_() {
        this.f22634j.hL_();
    }

    public final void m26199a(Object[] objArr) {
        this.f22634j.a(objArr);
    }

    public final void m26198a(FeedProps[] feedPropsArr) {
        this.f22634j.a(feedPropsArr);
    }

    public final void m26186a(DraweeController draweeController, String str, ImageRequest imageRequest) {
        this.f22633i.a(draweeController, str, imageRequest);
    }

    public final FeedListType m26207c() {
        return this.f22632h.c();
    }

    public Context getContext() {
        return this.f22630f.getContext();
    }

    public final void m26192a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase) {
        this.f22629e.a(caretNuxTooltipDelegateBase);
    }

    public final void m26188a(TooltipAnchor tooltipAnchor) {
        this.f22629e.a(tooltipAnchor);
    }

    public final void m26203b(TooltipAnchor tooltipAnchor) {
        this.f22629e.b(tooltipAnchor);
    }

    public final void m26194a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        this.f22628d.a(graphQLStoryAttachment, view);
    }

    public final void m26193a(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f22628d.a(graphQLStoryAttachment);
    }

    public final void m26204b(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f22628d.b(graphQLStoryAttachment);
    }

    public final boolean m26208c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f22628d.c(graphQLStoryAttachment);
    }

    public final void m26191a(FeedProps feedProps, String str, String str2, String str3) {
        this.f22627c.a(feedProps, str, str2, str3);
    }

    public final FriendshipStatus m26183a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, FriendingButtonControllerCallback friendingButtonControllerCallback) {
        return this.f22626b.a(str, str2, friendingLocation, graphQLFriendshipStatus, friendingButtonControllerCallback);
    }

    public final void m26197a(String str, String str2) {
        this.f22625a.a(str, str2);
    }

    public final void m26205b(String str, String str2) {
        this.f22625a.b(str, str2);
    }

    public final SearchResultsMutableContext mo1248s() {
        return this.f22642r.mo1248s();
    }
}
