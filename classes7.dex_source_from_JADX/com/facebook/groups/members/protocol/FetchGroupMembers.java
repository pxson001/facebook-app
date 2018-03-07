package com.facebook.groups.members.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.members.protocol.FetchGroupMembersModels.FetchGroupFriendMemberModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: progress_bar_color */
public final class FetchGroupMembers {

    /* compiled from: progress_bar_color */
    public class FetchGroupFriendMemberString extends TypedGraphQlQueryString<FetchGroupFriendMemberModel> {
        public FetchGroupFriendMemberString() {
            super(FetchGroupFriendMemberModel.class, false, "FetchGroupFriendMember", "5cc4d38d692d1a3c4808ed739261dbd9", "group_address", "10154358537461729", RegularImmutableSet.a);
        }

        public final String m7163a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "4";
                case -539238237:
                    return "1";
                case -59350230:
                    return "3";
                case 16907033:
                    return "2";
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
