package com.facebook.search.suggestions.simplesearch;

import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams.KeywordMode;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.suggestions.loader.RemoteTypeaheadLoader;
import com.facebook.search.suggestions.logging.DelegatingSuggestionsPerformanceLogger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheSupplier;
import javax.inject.Inject;

/* compiled from: voip_message */
public class RemoteEntityTypeaheadFetcher extends BaseRemoteTypeaheadFetcher {
    @Inject
    public RemoteEntityTypeaheadFetcher(TasksManager tasksManager, GraphSearchErrorReporter graphSearchErrorReporter, DelegatingSuggestionsPerformanceLogger delegatingSuggestionsPerformanceLogger, Lazy<RemoteTypeaheadLoader> lazy, TypeaheadQueryCacheSupplier typeaheadQueryCacheSupplier, QeAccessor qeAccessor) {
        super(qeAccessor.a(ExperimentsForSearchAbTestModule.M, false) ? KeywordMode.ENTITY_ONLY_MODE : KeywordMode.DEFAULT_KEYWORD_MODE, tasksManager, graphSearchErrorReporter, delegatingSuggestionsPerformanceLogger, lazy, typeaheadQueryCacheSupplier);
    }

    protected final FetchSource m392b() {
        return FetchSource.REMOTE_ENTITY;
    }

    public final String m391a() {
        return "fetch_entity_remote_typeahead";
    }
}
