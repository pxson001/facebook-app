package com.facebook.search.suggestions.simplesearch;

import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.Builder;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams.KeywordMode;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.module.TypeaheadQueryCacheSupplierMethodAutoProvider;
import com.facebook.search.suggestions.loader.RemoteTypeaheadLoader;
import com.facebook.search.suggestions.logging.DelegatingSuggestionsPerformanceLogger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheSupplier;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: voice_clip */
public class RemoteTypeaheadFetcher extends BaseRemoteTypeaheadFetcher {
    public static RemoteTypeaheadFetcher m396b(InjectorLike injectorLike) {
        return new RemoteTypeaheadFetcher(TasksManager.b(injectorLike), GraphSearchErrorReporter.a(injectorLike), DelegatingSuggestionsPerformanceLogger.m258a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10845), TypeaheadQueryCacheSupplierMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RemoteTypeaheadFetcher(TasksManager tasksManager, GraphSearchErrorReporter graphSearchErrorReporter, DelegatingSuggestionsPerformanceLogger delegatingSuggestionsPerformanceLogger, Lazy<RemoteTypeaheadLoader> lazy, TypeaheadQueryCacheSupplier typeaheadQueryCacheSupplier) {
        super(KeywordMode.DEFAULT_KEYWORD_MODE, tasksManager, graphSearchErrorReporter, delegatingSuggestionsPerformanceLogger, lazy, typeaheadQueryCacheSupplier);
    }

    protected final FetchSource m399b() {
        return FetchSource.REMOTE;
    }

    public final String m398a() {
        return "fetch_remote_typeahead";
    }

    public final ListenableFuture<SearchResponse<TypeaheadUnit>> m400g() {
        Builder l = GraphSearchQuery.e.l();
        l.a(ImmutableBiMap.b("FRIENDLY_NAME", "search_typeahead_pre_connect"));
        return a(l.b());
    }

    public final ListenableFuture<SearchResponse<TypeaheadUnit>> mo39a(TypeaheadRequest typeaheadRequest) {
        ((RemoteTypeaheadLoader) this.f246a.get()).f127c.d();
        return super.mo39a(typeaheadRequest);
    }
}
