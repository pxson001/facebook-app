package com.facebook.search.suggestions.nullstate.mutator;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryScheduler;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.converter.RecentSearchSuggestionGraphQLModelConverter;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: wait_time_ms */
public class RecentSearchCacheMutator {
    private final AddRecentSearchCacheVisitorProvider f241a;
    private final ListeningExecutorService f242b;
    public final GraphQLQueryExecutor f243c;
    private final GraphQLCacheManager f244d;
    private final GraphQLQueryScheduler f245e;

    @Inject
    public RecentSearchCacheMutator(AddRecentSearchCacheVisitorProvider addRecentSearchCacheVisitorProvider, ListeningExecutorService listeningExecutorService, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLCacheManager graphQLCacheManager, GraphQLQueryScheduler graphQLQueryScheduler) {
        this.f241a = addRecentSearchCacheVisitorProvider;
        this.f242b = listeningExecutorService;
        this.f243c = graphQLQueryExecutor;
        this.f244d = graphQLCacheManager;
        this.f245e = graphQLQueryScheduler;
    }

    public final ListenableFuture<Void> m361a(String str, NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit, int i) {
        final GraphQLWriteLock a = this.f245e.a(new AddRecentSearchCacheVisitor(str, nullStateSuggestionTypeaheadUnit, Integer.valueOf(i), RecentSearchSuggestionGraphQLModelConverter.a(this.f241a)));
        return this.f242b.a(new Callable<Void>(this) {
            final /* synthetic */ RecentSearchCacheMutator f240b;

            public Object call() {
                try {
                    a.a(true);
                    this.f240b.f243c.a(a);
                    return null;
                } finally {
                    a.e();
                }
            }
        });
    }

    public final ListenableFuture<Void> m360a(String str) {
        return this.f244d.a(Sets.a(new String[]{str}));
    }
}
