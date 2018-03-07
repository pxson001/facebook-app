package com.facebook.contacts.service;

import com.facebook.contacts.graphql.ContactGraphQL.FetchContactsCoefficientQueryString;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactCoefficientModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactsCoefficientQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.UnmodifiableIterator;
import javax.inject.Inject;

/* compiled from: return_structure */
public class GQLContactsCoefficientQueryHelper {
    private final GraphQLQueryExecutor f3366a;

    public static GQLContactsCoefficientQueryHelper m3599b(InjectorLike injectorLike) {
        return new GQLContactsCoefficientQueryHelper(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public GQLContactsCoefficientQueryHelper(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f3366a = graphQLQueryExecutor;
    }

    public final ImmutableList<ContactCoefficientModel> m3600a() {
        FetchContactsCoefficientQueryModel fetchContactsCoefficientQueryModel = (FetchContactsCoefficientQueryModel) ((GraphQLResult) FutureDetour.a(this.f3366a.a(GraphQLRequest.a(new FetchContactsCoefficientQueryString())), 209059195)).e;
        if (fetchContactsCoefficientQueryModel == null) {
            throw new RuntimeException("Contacts coefficient query returned no results");
        }
        UnmodifiableIterator it = fetchContactsCoefficientQueryModel.a().a().iterator();
        Builder builder = ImmutableList.builder();
        while (it.hasNext()) {
            builder.c((ContactCoefficientModel) it.next());
        }
        return builder.b();
    }
}
