package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.MessengerContactIdsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_attachment_length */
public class ContactGraphQL$MessengerContactIdsQueryString extends TypedGraphQlQueryString<MessengerContactIdsQueryModel> {
    public ContactGraphQL$MessengerContactIdsQueryString() {
        super(MessengerContactIdsQueryModel.class, false, "MessengerContactIdsQuery", "8b056042789d413c1271ef941ea6e6f8", "viewer", "10154220581406729", RegularImmutableSet.a);
    }

    public final String m11765a(String str) {
        switch (str.hashCode()) {
            case -713514397:
                return "0";
            default:
                return str;
        }
    }
}
