package com.facebook.contacts.protocol.methods;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.graphql.ContactGraphQL.FetchPaymentEligibleContactsQueryString;
import com.facebook.contacts.graphql.ContactGraphQL.FetchPaymentEligibleContactsSearchQueryString;
import com.facebook.contacts.graphql.ContactGraphQLInterfaces$ContactsSyncFull;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchPaymentEligibleContactsQueryModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchPaymentEligibleContactsSearchQueryModel;
import com.facebook.contacts.graphql.ContactsGraphQlParams;
import com.facebook.contacts.graphql.GraphQLContactDeserializer;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.contacts.server.FetchPaymentEligibleContactsParams;
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

/* compiled from: rtc_fast_probe */
public class FetchPaymentEligibleContactsMethod extends AbstractPersistedGraphQlApiMethod<FetchPaymentEligibleContactsParams, FetchContactsResult> {
    private static final Class<?> f3271c = FetchPaymentEligibleContactsMethod.class;
    private final GraphQLContactDeserializer f3272d;
    public final ContactsGraphQlParams f3273e;
    private final Clock f3274f;

    public static FetchPaymentEligibleContactsMethod m3472b(InjectorLike injectorLike) {
        return new FetchPaymentEligibleContactsMethod(GraphQLContactDeserializer.m3479a(injectorLike), ContactsGraphQlParams.m3484b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), GraphQLProtocolHelper.a(injectorLike));
    }

    public final Object m3473a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        ContactGraphQLInterfaces$ContactsSyncFull a;
        if (FetchPaymentEligibleContactsParams.a(((FetchPaymentEligibleContactsParams) obj).a)) {
            a = ((FetchPaymentEligibleContactsSearchQueryModel) jsonParser.a(FetchPaymentEligibleContactsSearchQueryModel.class)).a();
        } else {
            a = ((FetchPaymentEligibleContactsQueryModel) jsonParser.a(FetchPaymentEligibleContactsQueryModel.class)).a();
        }
        ImmutableList a2 = a.mo289a();
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < a2.size(); i++) {
            builder.c(this.f3272d.m3483a((ContactGraphQLModels$ContactModel) a2.get(i)).m4092P());
        }
        return new FetchContactsResult(DataFreshnessResult.FROM_SERVER, this.f3274f.a(), builder.b());
    }

    public final GraphQlQueryString m3475f(Object obj) {
        FetchPaymentEligibleContactsParams fetchPaymentEligibleContactsParams = (FetchPaymentEligibleContactsParams) obj;
        if (FetchPaymentEligibleContactsParams.a(fetchPaymentEligibleContactsParams.a)) {
            FetchPaymentEligibleContactsSearchQueryString fetchPaymentEligibleContactsSearchQueryString = (FetchPaymentEligibleContactsSearchQueryString) new FetchPaymentEligibleContactsSearchQueryString().a("search_constraint", fetchPaymentEligibleContactsParams.a).a("limit", Integer.valueOf(fetchPaymentEligibleContactsParams.b));
            this.f3273e.m3485a(fetchPaymentEligibleContactsSearchQueryString);
            return fetchPaymentEligibleContactsSearchQueryString.b(true);
        }
        FetchPaymentEligibleContactsQueryString fetchPaymentEligibleContactsQueryString = (FetchPaymentEligibleContactsQueryString) new FetchPaymentEligibleContactsQueryString().a("limit", Integer.valueOf(fetchPaymentEligibleContactsParams.b));
        this.f3273e.m3485a(fetchPaymentEligibleContactsQueryString);
        return fetchPaymentEligibleContactsQueryString.b(true);
    }

    @Inject
    public FetchPaymentEligibleContactsMethod(GraphQLContactDeserializer graphQLContactDeserializer, ContactsGraphQlParams contactsGraphQlParams, Clock clock, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f3272d = graphQLContactDeserializer;
        this.f3273e = contactsGraphQlParams;
        this.f3274f = clock;
    }

    public static FetchPaymentEligibleContactsMethod m3471a(InjectorLike injectorLike) {
        return m3472b(injectorLike);
    }

    public final int m3474b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
