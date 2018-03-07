package com.facebook.contacts.protocol.methods;

import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.graphql.ContactGraphQL$FetchContactsByIdsQueryString;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel;
import com.facebook.contacts.graphql.ContactsGraphQlParams;
import com.facebook.contacts.graphql.GraphQLContactDeserializer;
import com.facebook.contacts.server.FetchContactsParams;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.debug.log.BLog;
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

/* compiled from: page_product_like */
public class FetchContactsMethod extends AbstractPersistedGraphQlApiMethod<FetchContactsParams, FetchContactsResult> {
    private static final Class<?> f8387c = FetchContactsMethod.class;
    private final GraphQLContactDeserializer f8388d;
    private final ContactsGraphQlParams f8389e;

    public static FetchContactsMethod m12241a(InjectorLike injectorLike) {
        return new FetchContactsMethod(GraphQLContactDeserializer.a(injectorLike), ContactsGraphQlParams.b(injectorLike), GraphQLProtocolHelper.a(injectorLike));
    }

    public final GraphQlQueryString m12244f(Object obj) {
        FetchContactsParams fetchContactsParams = (FetchContactsParams) obj;
        ContactGraphQL$FetchContactsByIdsQueryString c = ContactGraphQL.c();
        this.f8389e.a(c);
        c.a("contact_ids", fetchContactsParams.f8446a.asList());
        return c;
    }

    @Inject
    public FetchContactsMethod(GraphQLContactDeserializer graphQLContactDeserializer, ContactsGraphQlParams contactsGraphQlParams, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f8388d = graphQLContactDeserializer;
        this.f8389e = contactsGraphQlParams;
    }

    public final Object m12242a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        Builder builder = ImmutableList.builder();
        for (ContactModel contactModel : this.b.b(ContactModel.class, jsonParser)) {
            String g = contactModel.g();
            try {
                builder.c(this.f8388d.a(contactModel).P());
            } catch (Throwable e) {
                BLog.b(f8387c, e, "Couldn't deserialize contact. ID = %s", new Object[]{g});
                throw e;
            }
        }
        ImmutableList b = builder.b();
        new StringBuilder("Got result: ").append(b);
        return new FetchContactsResult(DataFreshnessResult.FROM_SERVER, System.currentTimeMillis(), b);
    }

    public final int m12243b(Object obj, ApiResponse apiResponse) {
        return 0;
    }
}
