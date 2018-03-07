package com.facebook.pages.common.friendinviter.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.common.friendinviter.protocol.FriendsYouMayInviteModels.FriendsYouMayInviteQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: cta_icon_scale */
public final class FriendsYouMayInvite {

    /* compiled from: cta_icon_scale */
    public class FriendsYouMayInviteQueryString extends TypedGraphQlQueryString<FriendsYouMayInviteQueryModel> {
        public FriendsYouMayInviteQueryString() {
            super(FriendsYouMayInviteQueryModel.class, false, "FriendsYouMayInviteQuery", "edeea1a5f168d381e62aea435570270d", "page", "10154429039326729", RegularImmutableSet.a);
        }

        public final String m19537a(String str) {
            switch (str.hashCode()) {
                case -1564907514:
                    return "1";
                case -1101600581:
                    return "2";
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
