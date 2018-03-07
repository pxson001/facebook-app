package com.facebook.search.results.environment;

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
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.DirtyListener;
import com.facebook.search.results.environment.entity.CanApplyEntityInlineActionImpl;
import com.facebook.search.results.environment.entity.CanApplyEntityInlineActionImplProvider;
import com.facebook.search.results.environment.entity.CanLogEntityNavigationEntitiesImpl;
import com.facebook.search.results.environment.entity.CanLogEntityNavigationEntitiesImplProvider;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentStateImpl;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentStateImplProvider;
import com.facebook.search.results.environment.videos.SearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import javax.inject.Inject;

/* compiled from: Show all segues */
public class SearchResultsEnvironmentGenerated implements SearchResultsEnvironment {
    private final CanApplyEntityInlineActionImpl f22560a;
    private final CanFollowUserImpl f22561b;
    private final CanFriendPersonImpl f22562c;
    private final CanLikePageImpl f22563d;
    private final CanLogEntityNavigationEntitiesImpl f22564e;
    private final CanShowVideoInFullScreenImpl f22565f;
    private final HasAnchoredTooltipProviderImpl f22566g;
    private final HasContextImpl f22567h;
    private final HasEnvironmentControllerImpl f22568i;
    private final HasFeedListTypeImpl f22569j;
    private final HasFeedMenuHelperImpl f22570k;
    private final HasImageLoadListenerImpl f22571l;
    private final HasInvalidateImpl f22572m;
    private final HasIsAsyncImpl f22573n;
    private final HasMenuButtonProviderImpl f22574o;
    private final HasMutationControllerManagerImpl f22575p;
    private final HasPersistentStateImpl f22576q;
    private final HasPositionInformationImpl f22577r;
    private final HasPrefetcherNoOpImpl f22578s;
    private final HasRowKeyImpl f22579t;
    private final HasScrollListenerSupportImpl f22580u;
    private final HasSearchResultPositionImpl f22581v;
    private final HasSearchResultsContextImpl f22582w;
    private final HasSearchResultsVideoStoryPersistentStateImpl f22583x;
    private final CanReplaceSearchResultImpl f22584y;

    @Inject
    public SearchResultsEnvironmentGenerated(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted FeedMenuHelperReference feedMenuHelperReference, @Assisted Runnable runnable, @Assisted MutationControllerManager mutationControllerManager, @Assisted Delegate delegate, @Assisted SearchResultsCollection searchResultsCollection, @Assisted SearchResultsMutableContext searchResultsMutableContext, @Assisted SearchResultsCollection searchResultsCollection2, CanApplyEntityInlineActionImplProvider canApplyEntityInlineActionImplProvider, CanFollowUserImpl canFollowUserImpl, CanFriendPersonImpl canFriendPersonImpl, CanLikePageImplProvider canLikePageImplProvider, CanLogEntityNavigationEntitiesImplProvider canLogEntityNavigationEntitiesImplProvider, CanShowVideoInFullScreenImpl canShowVideoInFullScreenImpl, HasAnchoredTooltipProviderImpl hasAnchoredTooltipProviderImpl, HasContextImplProvider hasContextImplProvider, HasEnvironmentControllerImpl hasEnvironmentControllerImpl, HasFeedListTypeImplProvider hasFeedListTypeImplProvider, HasFeedMenuHelperImplProvider hasFeedMenuHelperImplProvider, HasImageLoadListenerImpl hasImageLoadListenerImpl, HasInvalidateImplProvider hasInvalidateImplProvider, HasIsAsyncImpl hasIsAsyncImpl, HasMenuButtonProviderImplProvider hasMenuButtonProviderImplProvider, HasMutationControllerManagerImplProvider hasMutationControllerManagerImplProvider, HasPersistentStateImpl hasPersistentStateImpl, HasPositionInformationImpl hasPositionInformationImpl, HasPrefetcherNoOpImpl hasPrefetcherNoOpImpl, HasRowKeyImpl hasRowKeyImpl, HasScrollListenerSupportImplProvider hasScrollListenerSupportImplProvider, HasSearchResultPositionImplProvider hasSearchResultPositionImplProvider, HasSearchResultsContextImplProvider hasSearchResultsContextImplProvider, HasSearchResultsVideoStoryPersistentStateImplProvider hasSearchResultsVideoStoryPersistentStateImplProvider, CanReplaceSearchResultImplProvider canReplaceSearchResultImplProvider) {
        this.f22560a = canApplyEntityInlineActionImplProvider.m26227a(this, this, this, this);
        this.f22561b = canFollowUserImpl;
        this.f22562c = canFriendPersonImpl;
        this.f22563d = canLikePageImplProvider.a(this);
        this.f22564e = canLogEntityNavigationEntitiesImplProvider.m26229a(this, this);
        this.f22565f = canShowVideoInFullScreenImpl;
        this.f22566g = hasAnchoredTooltipProviderImpl;
        this.f22567h = HasContextImplProvider.a(context);
        this.f22568i = hasEnvironmentControllerImpl;
        this.f22569j = HasFeedListTypeImplProvider.a(feedListType);
        this.f22570k = HasFeedMenuHelperImplProvider.m26026a(feedMenuHelperReference);
        this.f22571l = hasImageLoadListenerImpl;
        this.f22572m = HasInvalidateImplProvider.a(runnable);
        this.f22573n = hasIsAsyncImpl;
        this.f22574o = hasMenuButtonProviderImplProvider.a(this);
        this.f22575p = HasMutationControllerManagerImplProvider.a(mutationControllerManager);
        this.f22576q = hasPersistentStateImpl;
        this.f22577r = hasPositionInformationImpl;
        this.f22578s = hasPrefetcherNoOpImpl;
        this.f22579t = hasRowKeyImpl;
        this.f22580u = hasScrollListenerSupportImplProvider.a(delegate);
        this.f22581v = HasSearchResultPositionImplProvider.m26034a(searchResultsCollection);
        this.f22582w = HasSearchResultsContextImplProvider.m26037a(searchResultsMutableContext);
        this.f22583x = hasSearchResultsVideoStoryPersistentStateImplProvider.m26269a(this);
        this.f22584y = CanReplaceSearchResultImplProvider.m26018a(searchResultsCollection2, this);
    }

    public final void m26085a(DirtyListener dirtyListener) {
        this.f22572m.a(dirtyListener);
    }

    public final void a_(boolean z) {
        this.f22572m.a_(z);
    }

    public final EnvironmentController m26092b() {
        return this.f22568i.b();
    }

    public final void m26098b(boolean z) {
        this.f22573n.b(z);
    }

    public final boolean hM_() {
        return this.f22573n.hM_();
    }

    public final void m26075a(SimpleScrollListener simpleScrollListener) {
        this.f22580u.a(simpleScrollListener);
    }

    public final void m26093b(SimpleScrollListener simpleScrollListener) {
        this.f22580u.b(simpleScrollListener);
    }

    public final RowKey m26110m() {
        return this.f22579t.m();
    }

    public final void m26077a(RowKey rowKey) {
        this.f22579t.a(rowKey);
    }

    public final void m26111n() {
        this.f22579t.n();
    }

    public final boolean m26112o() {
        return this.f22579t.o();
    }

    public final void m26084a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f22578s.a(imageRequest, callerContext);
    }

    public final MultiRowSinglePartDefinition m26104f() {
        return this.f22577r.f();
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f22577r.hK_();
    }

    public final MultiRowSinglePartDefinition m26105h() {
        return this.f22577r.h();
    }

    public final Object m26106i() {
        return this.f22577r.i();
    }

    public final Object m26107j() {
        return this.f22577r.j();
    }

    public final void m26078a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f22577r.a(multiRowSinglePartDefinition, multiRowSinglePartDefinition2, multiRowSinglePartDefinition3, obj, obj2);
    }

    public final void m26108k() {
        this.f22577r.k();
    }

    public final <K, T> T m26072a(ContextStateKey<K, T> contextStateKey) {
        return this.f22576q.a(contextStateKey);
    }

    public final <K, T> T m26073a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f22576q.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m26090a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f22576q.a(contextStateKey, t);
    }

    public final BaseFeedStoryMenuHelper m26103e() {
        return this.f22574o.e();
    }

    public final void hL_() {
        this.f22572m.hL_();
    }

    public final void m26089a(Object[] objArr) {
        this.f22572m.a(objArr);
    }

    public final void m26088a(FeedProps[] feedPropsArr) {
        this.f22572m.a(feedPropsArr);
    }

    public final void m26074a(DraweeController draweeController, String str, ImageRequest imageRequest) {
        this.f22571l.a(draweeController, str, imageRequest);
    }

    public final FeedListType m26099c() {
        return this.f22569j.c();
    }

    public Context getContext() {
        return this.f22567h.getContext();
    }

    public final void m26080a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase) {
        this.f22566g.a(caretNuxTooltipDelegateBase);
    }

    public final void m26076a(TooltipAnchor tooltipAnchor) {
        this.f22566g.a(tooltipAnchor);
    }

    public final void m26094b(TooltipAnchor tooltipAnchor) {
        this.f22566g.b(tooltipAnchor);
    }

    public final void m26083a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        this.f22565f.a(graphQLStoryAttachment, view);
    }

    public final void m26082a(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f22565f.a(graphQLStoryAttachment);
    }

    public final void m26095b(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f22565f.b(graphQLStoryAttachment);
    }

    public final boolean m26101c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f22565f.c(graphQLStoryAttachment);
    }

    public final void m26079a(FeedProps feedProps, String str, String str2, String str3) {
        this.f22563d.a(feedProps, str, str2, str3);
    }

    public final FriendshipStatus m26070a(String str, String str2, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, FriendingButtonControllerCallback friendingButtonControllerCallback) {
        return this.f22562c.a(str, str2, friendingLocation, graphQLFriendshipStatus, friendingButtonControllerCallback);
    }

    public final void m26087a(String str, String str2) {
        this.f22561b.a(str, str2);
    }

    public final void m26097b(String str, String str2) {
        this.f22561b.b(str, str2);
    }

    public final void mo1255b(SearchResultsProps searchResultsProps) {
        this.f22560a.mo1255b(searchResultsProps);
    }

    public final void mo1256c(SearchResultsProps searchResultsProps) {
        this.f22564e.mo1256c(searchResultsProps);
    }

    public final BaseFeedStoryMenuHelper m26109l() {
        return this.f22570k.m26025l();
    }

    public final int mo1247a(SearchResultsEdgeModel searchResultsEdgeModel) {
        return this.f22581v.mo1247a(searchResultsEdgeModel);
    }

    public final int mo1246a(SearchResultsProps searchResultsProps) {
        return this.f22581v.mo1246a(searchResultsProps);
    }

    public final SearchResultsMutableContext mo1248s() {
        return this.f22582w.mo1248s();
    }

    public final SearchResultsVideoStoryPersistentState mo1254a(FeedProps<GraphQLStory> feedProps, int i) {
        return this.f22583x.mo1254a(feedProps, i);
    }

    public final SearchResultsVideoStoryPersistentState mo1257d(SearchResultsProps searchResultsProps) {
        return this.f22583x.mo1257d(searchResultsProps);
    }

    public final boolean mo1244a(FeedUnit feedUnit) {
        return this.f22584y.mo1244a(feedUnit);
    }

    public final void mo1243a(SearchResultsEdgeModel searchResultsEdgeModel, SearchResultsEdgeModel searchResultsEdgeModel2) {
        this.f22584y.mo1243a(searchResultsEdgeModel, searchResultsEdgeModel2);
    }

    public final void mo1242a(GraphQLStory graphQLStory) {
        this.f22584y.mo1242a(graphQLStory);
    }
}
