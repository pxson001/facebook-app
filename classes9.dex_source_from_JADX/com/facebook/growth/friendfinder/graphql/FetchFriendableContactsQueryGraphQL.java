package com.facebook.growth.friendfinder.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.growth.friendfinder.graphql.FetchFriendableContactsQueryGraphQLModels.FetchFriendableContactsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: parcelable_share_extras */
public final class FetchFriendableContactsQueryGraphQL {

    /* compiled from: parcelable_share_extras */
    public class FetchFriendableContactsQueryString extends TypedGraphQlQueryString<FetchFriendableContactsQueryModel> {
        public FetchFriendableContactsQueryString() {
            super(FetchFriendableContactsQueryModel.class, false, "FetchFriendableContactsQuery", "e023c4a4979deb01f12bdcb276ffd1bd", "viewer", "10154666900741729", RegularImmutableSet.a);
        }

        public final String m7558a(String str) {
            switch (str.hashCode()) {
                case -1784113457:
                    return "6";
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
                case 1939875509:
                    return "5";
                default:
                    return str;
            }
        }

        protected final boolean m7559a(String str, Object obj) {
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
