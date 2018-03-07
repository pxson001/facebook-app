package com.facebook.contacts.protocol.methods;

import com.facebook.contacts.graphql.ContactGraphQLInterfaces$ContactsPageInfo;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactsDeltaQueryModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactsDeltaQueryModel.MessengerContactsModel.DeltasModel.NodesModel;
import com.facebook.contacts.graphql.GraphQLContactDeserializer;
import com.facebook.contacts.graphql.GraphQLContactsQueryBuilder;
import com.facebook.contacts.graphql.GraphQLContactsQueryBuilder.QueryType;
import com.facebook.contacts.server.FetchDeltaContactsParams;
import com.facebook.contacts.server.FetchDeltaContactsResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: reused */
public class FetchDeltaContactsMethod extends AbstractPersistedGraphQlApiMethod<FetchDeltaContactsParams, FetchDeltaContactsResult> {
    private static final Class<?> f3363c = FetchDeltaContactsMethod.class;
    private final GraphQLContactsQueryBuilder f3364d;
    private final GraphQLContactDeserializer f3365e;

    public static FetchDeltaContactsMethod m3595b(InjectorLike injectorLike) {
        return new FetchDeltaContactsMethod(GraphQLContactsQueryBuilder.m3593b(injectorLike), GraphQLContactDeserializer.m3479a(injectorLike), GraphQLProtocolHelper.a(injectorLike));
    }

    public final GraphQlQueryString m3598f(Object obj) {
        FetchDeltaContactsParams fetchDeltaContactsParams = (FetchDeltaContactsParams) obj;
        return this.f3364d.m3594a(fetchDeltaContactsParams.a, fetchDeltaContactsParams.b, QueryType.DELTA);
    }

    @Inject
    public FetchDeltaContactsMethod(GraphQLContactsQueryBuilder graphQLContactsQueryBuilder, GraphQLContactDeserializer graphQLContactDeserializer, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f3364d = graphQLContactsQueryBuilder;
        this.f3365e = graphQLContactDeserializer;
    }

    public final Object m3596a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        FetchContactsDeltaQueryModel fetchContactsDeltaQueryModel = (FetchContactsDeltaQueryModel) jsonParser.a(FetchContactsDeltaQueryModel.class);
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        ImmutableList a = fetchContactsDeltaQueryModel.a().a().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a.get(i);
            ContactGraphQLModels$ContactModel a2 = nodesModel.a();
            String b = nodesModel.b();
            if (a2 != null) {
                new StringBuilder("Deserializing node: ").append(a2);
                builder.c(this.f3365e.m3483a(a2).m4092P());
            } else if (b != null) {
                builder2.c(b);
            }
        }
        ImmutableList b2 = builder.b();
        ImmutableList b3 = builder2.b();
        ContactGraphQLInterfaces$ContactsPageInfo b4 = fetchContactsDeltaQueryModel.a().a().b();
        if (b4 == null) {
            throw new ApiException(ApiErrorResult.m10830a(1675011, "Request returned without page info").m10840a());
        }
        return new FetchDeltaContactsResult(DataFreshnessResult.FROM_SERVER, b2, b3, b4.mo291a(), b4.mo292b(), System.currentTimeMillis());
    }

    public final int m3597b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
