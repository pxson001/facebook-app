package com.facebook.search.results.environment;

import android.content.Context;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.impl.HasContextImpl;
import com.facebook.feed.environment.impl.HasContextImplProvider;
import com.facebook.feed.environment.impl.HasInvalidateImpl;
import com.facebook.feed.environment.impl.HasInvalidateImplProvider;
import com.facebook.feed.environment.impl.HasPersistentStateImpl;
import com.facebook.feed.environment.impl.HasPositionInformationImpl;
import com.facebook.feed.rows.core.analytics.HasIsAsyncImpl;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.Assisted;
import com.facebook.search.results.environment.entity.CanProvideRoleForEntity;
import com.facebook.search.results.environment.entity.CanProvideRoleForEntityEntitiesImpl;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineActionImpl;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineActionImplProvider;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigationEntitiesImpl;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigationEntitiesImplProvider;
import com.facebook.search.results.model.SearchResultsEntitiesCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;
import javax.inject.Inject;

/* compiled from: SpinnerAlbumMediaSetFragment */
public class SearchResultsEntitiesEnvironmentGenerated implements HasContext, HasInvalidate, HasPersistentState, HasPositionInformation, CanReplaceFeedItem, HasFeedItemPosition, HasSearchResultsContext, CanProvideRoleForEntity, OldCanApplyEntityInlineAction, OldCanLogEntityNavigation {
    private final HasContextImpl f22549a;
    private final HasInvalidateImpl f22550b;
    private final HasIsAsyncImpl f22551c;
    private final HasPersistentStateImpl f22552d;
    private final HasPositionInformationImpl f22553e;
    private final HasFeedItemPositionEntitiesImpl f22554f;
    private final HasSearchResultsContextImpl f22555g;
    private final OldCanApplyEntityInlineActionImpl f22556h;
    private final OldCanLogEntityNavigationEntitiesImpl f22557i;
    private final CanProvideRoleForEntityEntitiesImpl f22558j;
    private final CanReplaceFeedItemEntitiesImpl f22559k;

    @Inject
    public SearchResultsEntitiesEnvironmentGenerated(@Assisted Context context, @Assisted Runnable runnable, @Assisted SearchResultsEntitiesCollection searchResultsEntitiesCollection, @Assisted SearchResultsMutableContext searchResultsMutableContext, @Assisted SearchResultsEntitiesCollection searchResultsEntitiesCollection2, HasContextImplProvider hasContextImplProvider, HasInvalidateImplProvider hasInvalidateImplProvider, HasIsAsyncImpl hasIsAsyncImpl, HasPersistentStateImpl hasPersistentStateImpl, HasPositionInformationImpl hasPositionInformationImpl, HasFeedItemPositionEntitiesImplProvider hasFeedItemPositionEntitiesImplProvider, HasSearchResultsContextImplProvider hasSearchResultsContextImplProvider, OldCanApplyEntityInlineActionImplProvider oldCanApplyEntityInlineActionImplProvider, OldCanLogEntityNavigationEntitiesImplProvider oldCanLogEntityNavigationEntitiesImplProvider, CanProvideRoleForEntityEntitiesImpl canProvideRoleForEntityEntitiesImpl, CanReplaceFeedItemEntitiesImplProvider canReplaceFeedItemEntitiesImplProvider) {
        this.f22549a = HasContextImplProvider.a(context);
        this.f22550b = HasInvalidateImplProvider.a(runnable);
        this.f22551c = hasIsAsyncImpl;
        this.f22552d = hasPersistentStateImpl;
        this.f22553e = hasPositionInformationImpl;
        this.f22554f = HasFeedItemPositionEntitiesImplProvider.m26022a(searchResultsEntitiesCollection);
        this.f22555g = HasSearchResultsContextImplProvider.m26037a(searchResultsMutableContext);
        this.f22556h = oldCanApplyEntityInlineActionImplProvider.m26246a(this, this, this, this, this);
        this.f22557i = oldCanLogEntityNavigationEntitiesImplProvider.m26248a(this, this);
        this.f22558j = canProvideRoleForEntityEntitiesImpl;
        this.f22559k = CanReplaceFeedItemEntitiesImplProvider.m26003a(searchResultsEntitiesCollection2, this);
    }

    public Context getContext() {
        return this.f22549a.getContext();
    }

    public final void hL_() {
        this.f22550b.hL_();
    }

    public final void m26052a(Object[] objArr) {
        this.f22550b.a(objArr);
    }

    public final void m26051a(FeedProps[] feedPropsArr) {
        this.f22550b.a(feedPropsArr);
    }

    public final <K, T> T m26046a(ContextStateKey<K, T> contextStateKey) {
        return this.f22552d.a(contextStateKey);
    }

    public final <K, T> T m26047a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f22552d.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m26053a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f22552d.a(contextStateKey, t);
    }

    public final MultiRowSinglePartDefinition m26057f() {
        return this.f22553e.f();
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f22553e.hK_();
    }

    public final MultiRowSinglePartDefinition m26058h() {
        return this.f22553e.h();
    }

    public final Object m26059i() {
        return this.f22553e.i();
    }

    public final Object m26060j() {
        return this.f22553e.j();
    }

    public final void m26048a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f22553e.a(multiRowSinglePartDefinition, multiRowSinglePartDefinition2, multiRowSinglePartDefinition3, obj, obj2);
    }

    public final void m26061k() {
        this.f22553e.k();
    }

    public final int mo1245a(Object obj) {
        return this.f22554f.mo1245a(obj);
    }

    public final SearchResultsMutableContext mo1248s() {
        return this.f22555g.mo1248s();
    }

    public final void mo1250a(GraphQLNode graphQLNode) {
        this.f22556h.mo1250a(graphQLNode);
    }

    public final void mo1251b(GraphQLNode graphQLNode) {
        this.f22557i.mo1251b(graphQLNode);
    }

    public final GraphQLGraphSearchResultRole mo1252c(GraphQLNode graphQLNode) {
        return this.f22558j.mo1252c(graphQLNode);
    }

    public final String mo1253d(GraphQLNode graphQLNode) {
        return this.f22558j.mo1253d(graphQLNode);
    }

    public final void mo1241a(Object obj, Object obj2) {
        this.f22559k.mo1241a(obj, obj2);
    }
}
