package com.facebook.messaging.inbox2.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mSelectedMailingAddress */
public final class InboxV2Query {

    /* compiled from: mSelectedMailingAddress */
    public class InboxV2QueryString extends TypedGraphQlQueryString<InboxV2QueryModel> {
        public InboxV2QueryString() {
            super(InboxV2QueryModel.class, false, "InboxV2Query", "b62773fab0651951e92ad5bbe079af1a", "viewer", "10154651826231729", RegularImmutableSet.a);
        }

        public final String m11544a(String str) {
            switch (str.hashCode()) {
                case -1380913837:
                    return "4";
                case -20088988:
                    return "2";
                case 385063962:
                    return "3";
                case 1878273094:
                    return "0";
                case 1983661319:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
