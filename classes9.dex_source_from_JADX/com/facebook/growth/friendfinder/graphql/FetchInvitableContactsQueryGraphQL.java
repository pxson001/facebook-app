package com.facebook.growth.friendfinder.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.growth.friendfinder.graphql.FetchInvitableContactsQueryGraphQLModels.InvitableContactsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: paging */
public final class FetchInvitableContactsQueryGraphQL {

    /* compiled from: paging */
    public class InvitableContactsQueryString extends TypedGraphQlQueryString<InvitableContactsQueryModel> {
        public InvitableContactsQueryString() {
            super(InvitableContactsQueryModel.class, false, "InvitableContactsQuery", "40cc239a37c2ee043ddce70d84373e52", "viewer", "10154666900726729", RegularImmutableSet.a);
        }

        public final String m7633a(String str) {
            switch (str.hashCode()) {
                case -1280109172:
                    return "1";
                case -1228028670:
                    return "4";
                case 92734940:
                    return "3";
                case 1332135073:
                    return "0";
                case 1399944782:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m7634a(String str, Object obj) {
            Object obj2 = -1;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        obj2 = null;
                        break;
                    }
                    break;
            }
            switch (obj2) {
                case null:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
