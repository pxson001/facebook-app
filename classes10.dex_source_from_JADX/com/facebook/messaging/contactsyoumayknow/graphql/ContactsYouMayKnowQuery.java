package com.facebook.messaging.contactsyoumayknow.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowQueryModels.ContactsYouMayKnowQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: switch_account */
public final class ContactsYouMayKnowQuery {

    /* compiled from: switch_account */
    public class ContactsYouMayKnowQueryString extends TypedGraphQlQueryString<ContactsYouMayKnowQueryModel> {
        public ContactsYouMayKnowQueryString() {
            super(ContactsYouMayKnowQueryModel.class, false, "ContactsYouMayKnowQuery", "db607d3a9631a9078a1a1ea19fd57cfd", "viewer", "10154559475691729", RegularImmutableSet.a);
        }

        public final String m1977a(String str) {
            switch (str.hashCode()) {
                case -1198366833:
                    return "1";
                case -249250188:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
