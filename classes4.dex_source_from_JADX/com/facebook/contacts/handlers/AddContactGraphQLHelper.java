package com.facebook.contacts.handlers;

import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLShimmedMutation.AddContactString;
import com.facebook.contacts.graphql.ContactsGraphQlParams;
import com.facebook.contacts.graphql.GraphQLContactDeserializer;
import com.facebook.contacts.server.AddContactParams;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.shimmedcalls.ContactCreateInputData;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.util.UserPhoneNumberUtil;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: resultAction */
public class AddContactGraphQLHelper {
    private final GraphQLContactDeserializer f3407a;
    public final UserPhoneNumberUtil f3408b;
    public final Provider<String> f3409c;
    private final ContactsGraphQlParams f3410d;

    public static AddContactGraphQLHelper m3627b(InjectorLike injectorLike) {
        return new AddContactGraphQLHelper(GraphQLContactDeserializer.m3479a(injectorLike), UserPhoneNumberUtil.m3630a(injectorLike), IdBasedProvider.a(injectorLike, 4446), ContactsGraphQlParams.m3484b(injectorLike));
    }

    @Inject
    public AddContactGraphQLHelper(GraphQLContactDeserializer graphQLContactDeserializer, UserPhoneNumberUtil userPhoneNumberUtil, Provider<String> provider, ContactsGraphQlParams contactsGraphQlParams) {
        this.f3407a = graphQLContactDeserializer;
        this.f3408b = userPhoneNumberUtil;
        this.f3409c = provider;
        this.f3410d = contactsGraphQlParams;
    }

    public final Contact m3628a(ContactGraphQLModels$ContactModel contactGraphQLModels$ContactModel) {
        return this.f3407a.m3483a(contactGraphQLModels$ContactModel).m4092P();
    }

    public final AddContactString m3629a(AddContactParams addContactParams) {
        GraphQlQueryString addContactString = new AddContactString();
        this.f3410d.m3485a(addContactString);
        String str = "input";
        ContactCreateInputData contactCreateInputData = new ContactCreateInputData();
        if (addContactParams.a != null) {
            contactCreateInputData.a("user_id", addContactParams.a);
        } else if (addContactParams.b != null) {
            contactCreateInputData.a("phone", this.f3408b.m3635c(addContactParams.b));
            contactCreateInputData.a("country_code", (String) this.f3409c.get());
        }
        addContactString.a(str, contactCreateInputData);
        return addContactString;
    }
}
