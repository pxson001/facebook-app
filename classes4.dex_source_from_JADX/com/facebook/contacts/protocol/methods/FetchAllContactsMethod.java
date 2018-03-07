package com.facebook.contacts.protocol.methods;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.graphql.ContactGraphQLInterfaces$ContactsSyncFull;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel;
import com.facebook.contacts.graphql.ContactGraphQLModels$FetchContactsFullQueryModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactsFullWithAfterQueryModel;
import com.facebook.contacts.graphql.GraphQLContactDeserializer;
import com.facebook.contacts.graphql.GraphQLContactsQueryBuilder;
import com.facebook.contacts.graphql.GraphQLContactsQueryBuilder.QueryType;
import com.facebook.contacts.server.FetchAllContactsParams;
import com.facebook.contacts.server.FetchAllContactsResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: reused_later */
public class FetchAllContactsMethod extends AbstractPersistedGraphQlApiMethod<FetchAllContactsParams, FetchAllContactsResult> {
    private static final Class<?> f3358c = FetchAllContactsMethod.class;
    private final GraphQLContactsQueryBuilder f3359d;
    private final GraphQLContactDeserializer f3360e;
    private final Clock f3361f;

    public static FetchAllContactsMethod m3589b(InjectorLike injectorLike) {
        return new FetchAllContactsMethod(GraphQLContactsQueryBuilder.m3593b(injectorLike), GraphQLContactDeserializer.m3479a(injectorLike), GraphQLProtocolHelper.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public final Object m3590a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        ContactGraphQLInterfaces$ContactsSyncFull a;
        String str = null;
        if (((FetchAllContactsParams) obj).f3428b != null) {
            a = ((FetchContactsFullWithAfterQueryModel) jsonParser.a(FetchContactsFullWithAfterQueryModel.class)).a();
        } else {
            ContactGraphQLModels$FetchContactsFullQueryModel contactGraphQLModels$FetchContactsFullQueryModel = (ContactGraphQLModels$FetchContactsFullQueryModel) jsonParser.a(ContactGraphQLModels$FetchContactsFullQueryModel.class);
            ContactGraphQLInterfaces$ContactsSyncFull a2 = contactGraphQLModels$FetchContactsFullQueryModel.m3649a();
            str = contactGraphQLModels$FetchContactsFullQueryModel.m3649a().m4007c();
            a = a2;
        }
        ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel b = a.mo290b();
        String a3 = b.mo291a();
        boolean b2 = b.mo292b();
        String c = b.m4015c();
        ImmutableList a4 = a.mo289a();
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < a4.size(); i++) {
            builder.c(this.f3360e.m3483a((ContactGraphQLModels$ContactModel) a4.get(i)).m4092P());
        }
        a4 = builder.b();
        new StringBuilder("Got result: ").append(a4);
        return new FetchAllContactsResult(DataFreshnessResult.FROM_SERVER, a4, a3, b2, c, this.f3361f.a(), str);
    }

    public final GraphQlQueryString m3592f(Object obj) {
        FetchAllContactsParams fetchAllContactsParams = (FetchAllContactsParams) obj;
        return this.f3359d.m3594a(fetchAllContactsParams.f3427a, fetchAllContactsParams.f3428b, QueryType.FULL);
    }

    @Inject
    public FetchAllContactsMethod(GraphQLContactsQueryBuilder graphQLContactsQueryBuilder, GraphQLContactDeserializer graphQLContactDeserializer, GraphQLProtocolHelper graphQLProtocolHelper, Clock clock) {
        super(graphQLProtocolHelper);
        this.f3359d = graphQLContactsQueryBuilder;
        this.f3360e = graphQLContactDeserializer;
        this.f3361f = clock;
    }

    public final int m3591b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
