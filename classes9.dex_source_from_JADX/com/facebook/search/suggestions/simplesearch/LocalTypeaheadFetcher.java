package com.facebook.search.suggestions.simplesearch;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.bootstrap.db.DbBootstrapPerformanceLogger;
import com.facebook.search.bootstrap.db.resolvers.BootstrapSuggestionResolver;
import com.facebook.search.bootstrap.db.resolvers.BootstrapSuggestionResolver.2;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.module.TypeaheadQueryCacheSupplierMethodAutoProvider;
import com.facebook.search.suggestions.logging.DelegatingSuggestionsPerformanceLogger;
import com.facebook.search.suggestions.logging.SuggestionsPerformanceLogger;
import com.facebook.search.suggestions.simplesearch.LocalTypeaheadLoader.C00311;
import com.facebook.search.suggestions.simplesearch.LocalTypeaheadLoader.C00322;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.typeahead.BaseTypeaheadFetcher;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheSupplier;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: voip_vibrate_enabled */
public class LocalTypeaheadFetcher extends BaseTypeaheadFetcher<TypeaheadUnit> {
    private final GraphSearchErrorReporter f252a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<LocalTypeaheadLoader> f253b = UltralightRuntime.b;
    private final DelegatingSuggestionsPerformanceLogger f254c;
    private final DbBootstrapPerformanceLogger f255d;
    private final GatekeeperStoreImpl f256e;

    public static LocalTypeaheadFetcher m370b(InjectorLike injectorLike) {
        LocalTypeaheadFetcher localTypeaheadFetcher = new LocalTypeaheadFetcher(TasksManager.b(injectorLike), GraphSearchErrorReporter.a(injectorLike), DelegatingSuggestionsPerformanceLogger.m258a(injectorLike), DbBootstrapPerformanceLogger.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), TypeaheadQueryCacheSupplierMethodAutoProvider.a(injectorLike));
        localTypeaheadFetcher.f253b = IdBasedSingletonScopeProvider.b(injectorLike, 10864);
        return localTypeaheadFetcher;
    }

    @Inject
    public LocalTypeaheadFetcher(TasksManager tasksManager, GraphSearchErrorReporter graphSearchErrorReporter, DelegatingSuggestionsPerformanceLogger delegatingSuggestionsPerformanceLogger, DbBootstrapPerformanceLogger dbBootstrapPerformanceLogger, GatekeeperStoreImpl gatekeeperStoreImpl, TypeaheadQueryCacheSupplier typeaheadQueryCacheSupplier) {
        super(tasksManager, typeaheadQueryCacheSupplier);
        this.f252a = graphSearchErrorReporter;
        this.f254c = delegatingSuggestionsPerformanceLogger;
        this.f255d = dbBootstrapPerformanceLogger;
        this.f256e = gatekeeperStoreImpl;
    }

    public final String m372a() {
        return "fetch_simple_local_typeahead";
    }

    public final ListenableFuture<SearchResponse<TypeaheadUnit>> m371a(TypeaheadRequest typeaheadRequest) {
        if (typeaheadRequest.b.trim().startsWith("#") && this.f256e.a(SearchAbTestGatekeepers.f).asBoolean(false)) {
            return Futures.a(new SearchResponse(RegularImmutableList.a));
        }
        List list;
        ListenableFuture listenableFuture;
        this.f254c.f145a.mo36c(typeaheadRequest);
        LocalTypeaheadLoader localTypeaheadLoader = (LocalTypeaheadLoader) this.f253b.get();
        localTypeaheadLoader.f262b.a(typeaheadRequest);
        Object obj = typeaheadRequest.d.get("CACHED_RESPONSE");
        if (obj != null) {
            list = ((SearchResponse) obj).b;
        } else {
            list = RegularImmutableList.a;
        }
        if (GraphSearchConfig.a(typeaheadRequest)) {
            SettableFuture f = SettableFuture.f();
            FutureDetour.a(f, RegularImmutableList.a, 1533087093);
            listenableFuture = f;
        } else {
            ListenableFuture a;
            int a2 = localTypeaheadLoader.f263c.a(ExperimentsForSearchAbTestModule.K, 12);
            if (list.isEmpty() && localTypeaheadLoader.f264d.a(SearchAbTestGatekeepers.f).asBoolean(false) && !localTypeaheadLoader.f263c.a(ExperimentsForSearchAbTestModule.bs, false)) {
                BootstrapSuggestionResolver bootstrapSuggestionResolver = localTypeaheadLoader.f261a;
                a = bootstrapSuggestionResolver.a.a(new 2(bootstrapSuggestionResolver, typeaheadRequest.b, localTypeaheadLoader.f264d.a(SearchAbTestGatekeepers.x).asBoolean(false) ? 2 : 3, a2));
            } else {
                a = Futures.a(localTypeaheadLoader.f261a.a(typeaheadRequest.b, a2, list), new C00322(localTypeaheadLoader), MoreExecutors.a());
            }
            listenableFuture = a;
        }
        return Futures.a(listenableFuture, new C00311(localTypeaheadLoader, typeaheadRequest));
    }

    protected final FetchSource m377b() {
        return FetchSource.LOCAL;
    }

    public final void m373a(@Nullable TypeaheadRequest typeaheadRequest, Throwable th) {
        this.f254c.m265d(typeaheadRequest);
        this.f252a.a(GraphSearchError.FETCH_SIMPLE_LOCAL_TYPEAHEAD_SUGGESTION_FAIL, th);
    }

    public final void m374a(@Nullable TypeaheadRequest typeaheadRequest, CancellationException cancellationException) {
        this.f254c.m265d(typeaheadRequest);
        this.f252a.a(GraphSearchError.FETCH_SIMPLE_LOCAL_TYPEAHEAD_SUGGESTION_CANCELLED, cancellationException);
    }

    public final void m376a(ImmutableMap<String, String> immutableMap) {
        super.a(immutableMap);
        DelegatingSuggestionsPerformanceLogger delegatingSuggestionsPerformanceLogger = this.f254c;
        SuggestionsPerformanceLogger suggestionsPerformanceLogger = delegatingSuggestionsPerformanceLogger.f145a;
        if (suggestionsPerformanceLogger.f152a.e(suggestionsPerformanceLogger.mo31a()) != null) {
            suggestionsPerformanceLogger.f152a.b(suggestionsPerformanceLogger.mo31a(), immutableMap);
        }
        suggestionsPerformanceLogger.f156e.clear();
        suggestionsPerformanceLogger.f154c.clear();
        suggestionsPerformanceLogger.f158g.clear();
        suggestionsPerformanceLogger.f157f.clear();
        suggestionsPerformanceLogger.f155d = 0;
        suggestionsPerformanceLogger = delegatingSuggestionsPerformanceLogger.f149e;
        if (suggestionsPerformanceLogger.f152a.e(suggestionsPerformanceLogger.mo31a()) != null) {
            suggestionsPerformanceLogger.f152a.b(suggestionsPerformanceLogger.mo31a(), immutableMap);
        }
        suggestionsPerformanceLogger.f156e.clear();
        suggestionsPerformanceLogger.f154c.clear();
        suggestionsPerformanceLogger.f158g.clear();
        suggestionsPerformanceLogger.f157f.clear();
        suggestionsPerformanceLogger.f155d = 0;
    }

    protected final void m375a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        DelegatingSuggestionsPerformanceLogger delegatingSuggestionsPerformanceLogger = this.f254c;
        List list = typeaheadResponse.b.b;
        delegatingSuggestionsPerformanceLogger.f145a.mo34a(typeaheadResponse.a, list);
        this.f255d.c(typeaheadResponse.a);
        super.a(typeaheadResponse);
    }
}
