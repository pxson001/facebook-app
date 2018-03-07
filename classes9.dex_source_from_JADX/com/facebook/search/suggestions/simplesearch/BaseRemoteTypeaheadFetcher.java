package com.facebook.search.suggestions.simplesearch;

import com.facebook.inject.Lazy;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams.KeywordMode;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SuggestionsTypeaheadAnalyticHelper;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.suggestions.loader.RemoteTypeaheadLoader;
import com.facebook.search.suggestions.logging.DelegatingSuggestionsPerformanceLogger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.typeahead.BaseTypeaheadFetcher;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheSupplier;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

/* compiled from: voip_voice_clip */
public abstract class BaseRemoteTypeaheadFetcher extends BaseTypeaheadFetcher<TypeaheadUnit> implements TypeaheadSessionHandler {
    public final Lazy<RemoteTypeaheadLoader> f246a;
    private final KeywordMode f247b;
    private final GraphSearchErrorReporter f248c;
    private final DelegatingSuggestionsPerformanceLogger f249d;
    public SuggestionsTypeaheadAnalyticHelper f250e;
    public int f251f;

    public BaseRemoteTypeaheadFetcher(KeywordMode keywordMode, TasksManager tasksManager, GraphSearchErrorReporter graphSearchErrorReporter, DelegatingSuggestionsPerformanceLogger delegatingSuggestionsPerformanceLogger, Lazy<RemoteTypeaheadLoader> lazy, TypeaheadQueryCacheSupplier typeaheadQueryCacheSupplier) {
        super(tasksManager, typeaheadQueryCacheSupplier);
        this.f246a = lazy;
        this.f247b = keywordMode;
        this.f248c = graphSearchErrorReporter;
        this.f249d = delegatingSuggestionsPerformanceLogger;
    }

    public final void m366a(@Nullable TypeaheadRequest typeaheadRequest, Throwable th) {
        this.f249d.m261a(b(), typeaheadRequest);
        this.f248c.a(GraphSearchError.FETCH_SIMPLE_REMOTE_TYPEAHEAD_SUGGESTION_FAIL, th);
    }

    public final void m367a(@Nullable TypeaheadRequest typeaheadRequest, CancellationException cancellationException) {
        this.f249d.m261a(b(), typeaheadRequest);
    }

    public final void m364a(int i) {
        this.f251f = i;
    }

    public final void m369a(ImmutableMap<String, String> immutableMap) {
        super.a(immutableMap);
        this.f249d.m263a(b(), (ImmutableMap) immutableMap);
    }

    public ListenableFuture<SearchResponse<TypeaheadUnit>> mo39a(TypeaheadRequest typeaheadRequest) {
        Object obj = typeaheadRequest.d.get("DURATION_MS");
        this.f249d.m262a(b(), typeaheadRequest, obj != null ? ((Integer) obj).intValue() : 0);
        RemoteTypeaheadLoader remoteTypeaheadLoader = (RemoteTypeaheadLoader) this.f246a.get();
        KeywordMode keywordMode = this.f247b;
        GraphSearchQuery graphSearchQuery = (GraphSearchQuery) typeaheadRequest;
        int i = this.f251f;
        String str = "";
        if (this.f250e != null) {
            str = this.f250e.a();
        }
        String str2 = str;
        typeaheadRequest.d.get("CACHED_RESPONSE");
        return remoteTypeaheadLoader.m220a(keywordMode, graphSearchQuery, i, str2, (String) typeaheadRequest.d.get("FRIENDLY_NAME"));
    }

    protected final void m368a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        this.f249d.m264a(b(), (List) typeaheadResponse.b.b, typeaheadResponse.a);
        super.a(typeaheadResponse);
    }

    public final void mo38a(SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper) {
        this.f250e = suggestionsTypeaheadAnalyticHelper;
    }
}
