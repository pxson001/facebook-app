package com.facebook.timeline.editfeaturedcontainers.utils;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.calls.SectionTypesInputFeaturedPageSuggestionsSectionType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQL.NullStateMorePageSuggestionsQueryString;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.FeaturedPageSectionModel;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.IntroCardModel;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.NullStateMorePageSuggestionsQueryModel;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.UserModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: geofence_exited */
public class NullStateSuggestionsDataFetcher {
    public static final CallerContext f10966a = CallerContext.a(NullStateSuggestionsDataFetcher.class, "afc_null_state");
    private static NullStateSuggestionsDataFetcher f10967c;
    private static final Object f10968d = new Object();
    public final GraphQLQueryExecutor f10969b;

    /* compiled from: geofence_exited */
    public class C15921 implements Function<GraphQLResult<UserModel>, IntroCardModel> {
        final /* synthetic */ NullStateSuggestionsDataFetcher f10964a;

        public C15921(NullStateSuggestionsDataFetcher nullStateSuggestionsDataFetcher) {
            this.f10964a = nullStateSuggestionsDataFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return (graphQLResult == null || ((UserModel) graphQLResult.e).m10898a() == null) ? null : ((UserModel) graphQLResult.e).m10898a();
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    /* compiled from: geofence_exited */
    class C15932 implements Function<GraphQLResult<NullStateMorePageSuggestionsQueryModel>, ImmutableList<FeaturedPageSectionModel>> {
        final /* synthetic */ NullStateSuggestionsDataFetcher f10965a;

        C15932(NullStateSuggestionsDataFetcher nullStateSuggestionsDataFetcher) {
            this.f10965a = nullStateSuggestionsDataFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return (graphQLResult == null || ((NullStateMorePageSuggestionsQueryModel) graphQLResult.e).m10884a() == null || ((NullStateMorePageSuggestionsQueryModel) graphQLResult.e).m10884a().m10831a() == null) ? null : ((NullStateMorePageSuggestionsQueryModel) graphQLResult.e).m10884a().m10831a().m10827a();
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    private static NullStateSuggestionsDataFetcher m11091b(InjectorLike injectorLike) {
        return new NullStateSuggestionsDataFetcher(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public NullStateSuggestionsDataFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f10969b = graphQLQueryExecutor;
    }

    public static NullStateSuggestionsDataFetcher m11090a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateSuggestionsDataFetcher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10968d) {
                NullStateSuggestionsDataFetcher nullStateSuggestionsDataFetcher;
                if (a2 != null) {
                    nullStateSuggestionsDataFetcher = (NullStateSuggestionsDataFetcher) a2.a(f10968d);
                } else {
                    nullStateSuggestionsDataFetcher = f10967c;
                }
                if (nullStateSuggestionsDataFetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11091b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10968d, b3);
                        } else {
                            f10967c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateSuggestionsDataFetcher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ListenableFuture<ImmutableList<FeaturedPageSectionModel>> m11092a(int i, int i2, ImmutableList<SectionTypesInputFeaturedPageSuggestionsSectionType> immutableList) {
        GraphQlQueryString nullStateMorePageSuggestionsQueryString = new NullStateMorePageSuggestionsQueryString();
        nullStateMorePageSuggestionsQueryString.a("page_suggestions_count", Integer.valueOf(i)).a("page_icon_size", Integer.valueOf(i2)).a("page_section_types", immutableList);
        GraphQLRequest a = GraphQLRequest.a(nullStateMorePageSuggestionsQueryString);
        a.f = f10966a;
        return Futures.a(this.f10969b.a(a.a(RequestPriority.INTERACTIVE).a(86400).a(GraphQLCachePolicy.a)), new C15932(this), DirectExecutor.INSTANCE);
    }
}
