package com.facebook.contacts.protocol.methods;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.graphql.ContactGraphQL.FetchTopContactsByCFPHatCoefficientQueryString;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchTopContactsByCFPHatCoefficientQueryModel;
import com.facebook.contacts.graphql.ContactsGraphQlParams;
import com.facebook.contacts.graphql.GraphQLContactDeserializer;
import com.facebook.contacts.server.FetchContactsResult;
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

/* compiled from: rtc_audio_level_indicator_android */
public class FetchTopContactsByCFPHatMethod extends AbstractPersistedGraphQlApiMethod<Integer, FetchContactsResult> {
    private static final Class<?> f3291c = FetchTopContactsByCFPHatMethod.class;
    private final GraphQLContactDeserializer f3292d;
    private final ContactsGraphQlParams f3293e;
    private final Clock f3294f;

    public static FetchTopContactsByCFPHatMethod m3499a(InjectorLike injectorLike) {
        return new FetchTopContactsByCFPHatMethod(GraphQLContactDeserializer.m3479a(injectorLike), ContactsGraphQlParams.m3484b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), GraphQLProtocolHelper.a(injectorLike));
    }

    public final GraphQlQueryString m3502f(Object obj) {
        FetchTopContactsByCFPHatCoefficientQueryString fetchTopContactsByCFPHatCoefficientQueryString = (FetchTopContactsByCFPHatCoefficientQueryString) new FetchTopContactsByCFPHatCoefficientQueryString().a("limit", (Integer) obj);
        this.f3293e.m3485a(fetchTopContactsByCFPHatCoefficientQueryString);
        return fetchTopContactsByCFPHatCoefficientQueryString.b(true);
    }

    @Inject
    public FetchTopContactsByCFPHatMethod(GraphQLContactDeserializer graphQLContactDeserializer, ContactsGraphQlParams contactsGraphQlParams, Clock clock, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f3292d = graphQLContactDeserializer;
        this.f3293e = contactsGraphQlParams;
        this.f3294f = clock;
    }

    public final Object m3500a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        ImmutableList a = ((FetchTopContactsByCFPHatCoefficientQueryModel) jsonParser.a(FetchTopContactsByCFPHatCoefficientQueryModel.class)).a().a();
        Builder builder = ImmutableList.builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(this.f3292d.m3483a((ContactGraphQLModels$ContactModel) a.get(i)).m4092P());
        }
        return new FetchContactsResult(DataFreshnessResult.FROM_SERVER, this.f3294f.a(), builder.b());
    }

    public final int m3501b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
