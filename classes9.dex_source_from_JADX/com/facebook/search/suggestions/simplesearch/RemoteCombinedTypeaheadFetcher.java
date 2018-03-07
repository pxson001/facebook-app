package com.facebook.search.suggestions.simplesearch;

import com.facebook.common.executors.ConstrainedListeningExecutorService;
import com.facebook.common.executors.QueueingListeningExecutorService;
import com.facebook.common.executors.QueueingListeningExecutorService_SearchTypeaheadNetworkExecutorMethodAutoProvider;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SuggestionsTypeaheadAnalyticHelper;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.module.TypeaheadQueryCacheSupplierMethodAutoProvider;
import com.facebook.search.suggestions.logging.DelegatingSuggestionsPerformanceLogger;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.OnFetchStateChangedListener;
import com.facebook.ui.typeahead.TypeaheadFetcher;
import com.facebook.ui.typeahead.TypeaheadFetcher.OnSuggestionsFetchedListener;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCache;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: voip_ringtone_uri */
public class RemoteCombinedTypeaheadFetcher implements TypeaheadSessionHandler, OnFetchStateChangedListener, TypeaheadFetcher<TypeaheadUnit> {
    public final GraphSearchConfig f265a;
    private final RemoteTypeaheadFetcher f266b;
    private final RemoteEntityTypeaheadFetcher f267c;
    private final RemoteKeywordTypeaheadFetcher f268d;
    private final ConstrainedListeningExecutorService f269e;
    public final FbDataConnectionManager f270f;
    public final GatekeeperStoreImpl f271g;
    private OnFetchStateChangedListener f272h;

    public static RemoteCombinedTypeaheadFetcher m381b(InjectorLike injectorLike) {
        return new RemoteCombinedTypeaheadFetcher(GraphSearchConfig.a(injectorLike), QueueingListeningExecutorService_SearchTypeaheadNetworkExecutorMethodAutoProvider.a(injectorLike), RemoteTypeaheadFetcher.m396b(injectorLike), new RemoteEntityTypeaheadFetcher(TasksManager.b(injectorLike), GraphSearchErrorReporter.a(injectorLike), DelegatingSuggestionsPerformanceLogger.m258a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10845), TypeaheadQueryCacheSupplierMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike)), RemoteKeywordTypeaheadFetcher.m393b(injectorLike), FbDataConnectionManager.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RemoteCombinedTypeaheadFetcher(GraphSearchConfig graphSearchConfig, QueueingListeningExecutorService queueingListeningExecutorService, RemoteTypeaheadFetcher remoteTypeaheadFetcher, RemoteEntityTypeaheadFetcher remoteEntityTypeaheadFetcher, RemoteKeywordTypeaheadFetcher remoteKeywordTypeaheadFetcher, FbDataConnectionManager fbDataConnectionManager, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f271g = gatekeeperStoreImpl;
        this.f265a = graphSearchConfig;
        this.f266b = remoteTypeaheadFetcher;
        this.f267c = remoteEntityTypeaheadFetcher;
        this.f268d = remoteKeywordTypeaheadFetcher;
        this.f269e = (ConstrainedListeningExecutorService) queueingListeningExecutorService;
        this.f270f = fbDataConnectionManager;
        this.f266b.a(this);
        this.f267c.a(this);
        this.f268d.a(this);
        this.f269e.a(4);
    }

    public final Map<FetchSource, TypeaheadQueryCache<TypeaheadUnit>> m383a() {
        return ImmutableMap.of(FetchSource.REMOTE, this.f266b.c, FetchSource.REMOTE_ENTITY, this.f267c.c, FetchSource.REMOTE_KEYWORD, this.f268d.c);
    }

    public final void m389b(TypeaheadRequest typeaheadRequest) {
        this.f269e.d();
        GraphSearchQuery graphSearchQuery = (GraphSearchQuery) typeaheadRequest;
        boolean z = false;
        if (this.f265a.h(graphSearchQuery) || this.f265a.e(graphSearchQuery)) {
            z = true;
        } else {
            ConnectionQuality c = this.f270f.c();
            if (!(c == ConnectionQuality.EXCELLENT || c == ConnectionQuality.GOOD)) {
                z = this.f271g.a(SearchAbTestGatekeepers.i).asBoolean(false);
            }
        }
        if (z) {
            this.f266b.b(typeaheadRequest);
            return;
        }
        this.f268d.b(typeaheadRequest);
        this.f267c.b(typeaheadRequest);
    }

    public final void m388a(ImmutableMap<String, String> immutableMap) {
        this.f266b.a(immutableMap);
        this.f267c.a(immutableMap);
        this.f268d.a(immutableMap);
    }

    public final boolean m390d() {
        return this.f266b.d() || this.f267c.d() || this.f268d.d();
    }

    public final void m386a(OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f272h = onFetchStateChangedListener;
    }

    public final void m387a(OnSuggestionsFetchedListener onSuggestionsFetchedListener) {
        this.f266b.a(onSuggestionsFetchedListener);
        this.f267c.a(onSuggestionsFetchedListener);
        this.f268d.a(onSuggestionsFetchedListener);
    }

    public final RemoteCombinedTypeaheadFetcher m382a(int i, int i2) {
        this.f266b.f251f = i;
        this.f267c.f251f = i;
        this.f268d.f251f = i2;
        return this;
    }

    public final void mo38a(SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper) {
        this.f266b.mo38a(suggestionsTypeaheadAnalyticHelper);
        this.f267c.mo38a(suggestionsTypeaheadAnalyticHelper);
        this.f268d.mo38a(suggestionsTypeaheadAnalyticHelper);
    }

    public final void m385a(FetchState fetchState) {
        FetchState fetchState2 = this.f266b.f;
        FetchState fetchState3 = this.f267c.f;
        FetchState fetchState4 = this.f268d.f;
        if (fetchState2 == FetchState.ERROR || fetchState3 == FetchState.ERROR || fetchState4 == FetchState.ERROR) {
            fetchState2 = FetchState.ERROR;
        } else if (fetchState2 == FetchState.IDLE && fetchState3 == FetchState.IDLE && fetchState4 == FetchState.IDLE) {
            fetchState2 = FetchState.IDLE;
        } else {
            fetchState2 = FetchState.ACTIVE;
        }
        if (this.f272h != null) {
            this.f272h.a(fetchState2);
        }
    }
}
