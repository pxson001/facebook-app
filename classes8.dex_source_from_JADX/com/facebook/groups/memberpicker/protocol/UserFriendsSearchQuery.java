package com.facebook.groups.memberpicker.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberpicker.protocol.UserFriendsSearchQueryModels.UserFriendsSearchQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: error inflating media gallery */
public final class UserFriendsSearchQuery {

    /* compiled from: error inflating media gallery */
    public class UserFriendsSearchQueryString extends TypedGraphQlQueryString<UserFriendsSearchQueryModel> {
        public UserFriendsSearchQueryString() {
            super(UserFriendsSearchQueryModel.class, false, "UserFriendsSearchQuery", "68c112d05919c36760c06bc721d05efd", "node", "10154358997846729", RegularImmutableSet.a);
        }

        public final String m16904a(String str) {
            switch (str.hashCode()) {
                case -767546005:
                    return "4";
                case -710473164:
                    return "1";
                case -381590603:
                    return "3";
                case -230346670:
                    return "2";
                case -147132913:
                    return "0";
                case 109250890:
                    return "6";
                case 120048402:
                    return "5";
                default:
                    return str;
            }
        }
    }

    public static final UserFriendsSearchQueryString m16905a() {
        return new UserFriendsSearchQueryString();
    }
}
