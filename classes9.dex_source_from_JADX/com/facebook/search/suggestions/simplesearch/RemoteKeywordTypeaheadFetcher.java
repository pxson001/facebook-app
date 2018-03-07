package com.facebook.search.suggestions.simplesearch;

import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams.KeywordMode;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.module.TypeaheadQueryCacheSupplierMethodAutoProvider;
import com.facebook.search.suggestions.loader.RemoteTypeaheadLoader;
import com.facebook.search.suggestions.logging.DelegatingSuggestionsPerformanceLogger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheSupplier;
import javax.inject.Inject;

/* compiled from: voice_distortion */
public class RemoteKeywordTypeaheadFetcher extends BaseRemoteTypeaheadFetcher {
    public static RemoteKeywordTypeaheadFetcher m393b(InjectorLike injectorLike) {
        return new RemoteKeywordTypeaheadFetcher(TasksManager.b(injectorLike), GraphSearchErrorReporter.a(injectorLike), DelegatingSuggestionsPerformanceLogger.m258a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10845), TypeaheadQueryCacheSupplierMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RemoteKeywordTypeaheadFetcher(TasksManager tasksManager, GraphSearchErrorReporter graphSearchErrorReporter, DelegatingSuggestionsPerformanceLogger delegatingSuggestionsPerformanceLogger, Lazy<RemoteTypeaheadLoader> lazy, TypeaheadQueryCacheSupplier typeaheadQueryCacheSupplier) {
        super(KeywordMode.KEYWORD_ONLY_MODE, tasksManager, graphSearchErrorReporter, delegatingSuggestionsPerformanceLogger, lazy, typeaheadQueryCacheSupplier);
    }

    protected final FetchSource m395b() {
        return FetchSource.REMOTE_KEYWORD;
    }

    public final String m394a() {
        return "fetch_keyword_remote_typeahead";
    }
}
