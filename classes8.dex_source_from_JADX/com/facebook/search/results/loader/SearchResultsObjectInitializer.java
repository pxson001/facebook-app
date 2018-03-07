package com.facebook.search.results.loader;

import com.facebook.search.results.loader.modules.SearchResultsCollectionGraphQLConverter;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* compiled from: SCRUBBER_CLOSED */
public class SearchResultsObjectInitializer {
    private final ExecutorService f23245a;
    public final SearchResultsCollectionGraphQLConverter f23246b;
    private final AtomicBoolean f23247c = new AtomicBoolean(false);

    /* compiled from: SCRUBBER_CLOSED */
    class C25031 implements Runnable {
        final /* synthetic */ SearchResultsObjectInitializer f23244a;

        C25031(SearchResultsObjectInitializer searchResultsObjectInitializer) {
            this.f23244a = searchResultsObjectInitializer;
        }

        public void run() {
            this.f23244a.f23246b.m26964b();
        }
    }

    @Inject
    public SearchResultsObjectInitializer(ExecutorService executorService, SearchResultsCollectionGraphQLConverter searchResultsCollectionGraphQLConverter) {
        this.f23245a = executorService;
        this.f23246b = searchResultsCollectionGraphQLConverter;
    }

    public final void m26951a() {
        if (!this.f23247c.getAndSet(true)) {
            ExecutorDetour.a(this.f23245a, new C25031(this), 1905965265);
        }
    }
}
