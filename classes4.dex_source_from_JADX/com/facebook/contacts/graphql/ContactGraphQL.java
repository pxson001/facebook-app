package com.facebook.contacts.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: resetNow */
public final class ContactGraphQL {

    /* compiled from: resetNow */
    public class FetchContactsFullQueryString extends TypedGraphQlQueryString<ContactGraphQLModels$FetchContactsFullQueryModel> {
        public FetchContactsFullQueryString() {
            super(ContactGraphQLModels$FetchContactsFullQueryModel.class, false, "FetchContactsFullQuery", "57149c506aa0baa07e41b04e259d03ea", "viewer", "10154444360806729", RegularImmutableSet.a);
        }

        public final String m3646a(String str) {
            switch (str.hashCode()) {
                case -1906025967:
                    return "3";
                case -1439844555:
                    return "4";
                case -713514397:
                    return "0";
                case 102976443:
                    return "1";
                case 693548892:
                    return "2";
                default:
                    return str;
            }
        }
    }

    public static final FetchContactsByIdsQueryString m3644c() {
        return new FetchContactsByIdsQueryString();
    }

    public static final MessengerContactIdsQueryString m3645k() {
        return new MessengerContactIdsQueryString();
    }
}
