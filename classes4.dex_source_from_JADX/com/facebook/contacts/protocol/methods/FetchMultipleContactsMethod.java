package com.facebook.contacts.protocol.methods;

import com.facebook.common.time.Clock;
import com.facebook.contacts.graphql.ContactGraphQL.FetchContactsByProfileIdsQueryString;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactsByProfileIdsQueryModel;
import com.facebook.contacts.graphql.ContactsGraphQlParams;
import com.facebook.contacts.graphql.GraphQLContactDeserializer;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.contacts.server.FetchMultipleContactsByFbidParams;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: results_returned */
public class FetchMultipleContactsMethod extends AbstractPersistedGraphQlApiMethod<FetchMultipleContactsByFbidParams, FetchContactsResult> {
    private static final Class<?> f3386c = FetchMultipleContactsMethod.class;
    private final GraphQLContactDeserializer f3387d;
    private final ContactsGraphQlParams f3388e;
    private final Clock f3389f;

    public final GraphQlQueryString m3618f(Object obj) {
        FetchMultipleContactsByFbidParams fetchMultipleContactsByFbidParams = (FetchMultipleContactsByFbidParams) obj;
        GraphQlQueryString fetchContactsByProfileIdsQueryString = new FetchContactsByProfileIdsQueryString();
        this.f3388e.m3485a(fetchContactsByProfileIdsQueryString);
        Builder builder = new Builder();
        Iterator it = fetchMultipleContactsByFbidParams.a.iterator();
        while (it.hasNext()) {
            builder.c(((UserKey) it.next()).b());
        }
        fetchContactsByProfileIdsQueryString.a("profile_ids", builder.b());
        return fetchContactsByProfileIdsQueryString;
    }

    @Inject
    public FetchMultipleContactsMethod(GraphQLProtocolHelper graphQLProtocolHelper, GraphQLContactDeserializer graphQLContactDeserializer, ContactsGraphQlParams contactsGraphQlParams, Clock clock) {
        super(graphQLProtocolHelper);
        this.f3387d = graphQLContactDeserializer;
        this.f3388e = contactsGraphQlParams;
        this.f3389f = clock;
    }

    public final Object m3616a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        Builder builder = ImmutableList.builder();
        for (FetchContactsByProfileIdsQueryModel a : this.b.b(FetchContactsByProfileIdsQueryModel.class, jsonParser)) {
            ContactGraphQLModels$ContactModel a2 = a.a();
            if (a2 != null) {
                try {
                    builder.c(this.f3387d.m3483a(a2).m4092P());
                } catch (Throwable e) {
                    BLog.b(f3386c, e, "Couldn't deserialize contact", new Object[0]);
                    throw e;
                }
            }
        }
        return new FetchContactsResult(DataFreshnessResult.FROM_SERVER, this.f3389f.a(), builder.b());
    }

    public final int m3617b(Object obj, ApiResponse apiResponse) {
        return 0;
    }
}
