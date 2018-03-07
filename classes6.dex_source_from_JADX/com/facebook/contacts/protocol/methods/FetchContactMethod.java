package com.facebook.contacts.protocol.methods;

import com.facebook.contacts.graphql.ContactGraphQL$FetchContactByProfileIdQueryString;
import com.facebook.contacts.graphql.ContactGraphQL$FetchContactQueryString;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactByProfileIdQueryModel;
import com.facebook.contacts.graphql.ContactsGraphQlParams;
import com.facebook.contacts.graphql.GraphQLContactDeserializer;
import com.facebook.contacts.server.FetchContactParams;
import com.facebook.contacts.server.FetchContactResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: page_product_lists */
public class FetchContactMethod extends AbstractPersistedGraphQlApiMethod<FetchContactParams, FetchContactResult> {
    private final GraphQLContactDeserializer f8385c;
    public final ContactsGraphQlParams f8386d;

    private static FetchContactMethod m12237b(InjectorLike injectorLike) {
        return new FetchContactMethod(GraphQLContactDeserializer.a(injectorLike), ContactsGraphQlParams.b(injectorLike), GraphQLProtocolHelper.a(injectorLike));
    }

    public final Object m12238a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        ContactModel a;
        UserKey userKey = ((FetchContactParams) obj).f8440a;
        if (userKey.a() == Type.FACEBOOK) {
            FetchContactByProfileIdQueryModel fetchContactByProfileIdQueryModel = (FetchContactByProfileIdQueryModel) jsonParser.a(FetchContactByProfileIdQueryModel.class);
            a = fetchContactByProfileIdQueryModel != null ? fetchContactByProfileIdQueryModel.m11860a() : null;
        } else {
            a = (ContactModel) jsonParser.a(ContactModel.class);
        }
        return new FetchContactResult(DataFreshnessResult.FROM_SERVER, System.currentTimeMillis(), this.f8385c.a(a).P(), userKey);
    }

    public final GraphQlQueryString m12240f(Object obj) {
        GraphQlQueryString contactGraphQL$FetchContactByProfileIdQueryString;
        UserKey userKey = ((FetchContactParams) obj).f8440a;
        boolean z = userKey.a() == Type.FACEBOOK || userKey.a() == Type.FACEBOOK_CONTACT;
        Preconditions.checkArgument(z);
        if (userKey.a() == Type.FACEBOOK) {
            contactGraphQL$FetchContactByProfileIdQueryString = new ContactGraphQL$FetchContactByProfileIdQueryString();
            this.f8386d.a(contactGraphQL$FetchContactByProfileIdQueryString);
            contactGraphQL$FetchContactByProfileIdQueryString.a("profile_id", userKey.b());
        } else {
            contactGraphQL$FetchContactByProfileIdQueryString = new ContactGraphQL$FetchContactQueryString();
            contactGraphQL$FetchContactByProfileIdQueryString.a("contact_id", userKey.b());
            this.f8386d.a(contactGraphQL$FetchContactByProfileIdQueryString);
        }
        return contactGraphQL$FetchContactByProfileIdQueryString;
    }

    @Inject
    public FetchContactMethod(GraphQLContactDeserializer graphQLContactDeserializer, ContactsGraphQlParams contactsGraphQlParams, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f8385c = graphQLContactDeserializer;
        this.f8386d = contactsGraphQlParams;
    }

    public final int m12239b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
