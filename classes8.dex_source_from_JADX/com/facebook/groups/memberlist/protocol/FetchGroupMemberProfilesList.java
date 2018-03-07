package com.facebook.groups.memberlist.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.FetchGroupMemberProfilesListModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_friend_request_make_ref */
public final class FetchGroupMemberProfilesList {

    /* compiled from: extra_friend_request_make_ref */
    public class FetchGroupMemberProfilesListString extends TypedGraphQlQueryString<FetchGroupMemberProfilesListModel> {
        public FetchGroupMemberProfilesListString() {
            super(FetchGroupMemberProfilesListModel.class, false, "FetchGroupMemberProfilesList", "d969bfe6f6b3c1cbeea9e045d598d249", "group_address", "10154590671791729", RegularImmutableSet.a);
        }

        public final String m16189a(String str) {
            switch (str.hashCode()) {
                case -1369528544:
                    return "8";
                case -1101600581:
                    return "1";
                case -539238237:
                    return "2";
                case 70438958:
                    return "4";
                case 181254089:
                    return "7";
                case 506361563:
                    return "0";
                case 615430233:
                    return "6";
                case 1208944507:
                    return "3";
                case 1780777520:
                    return "5";
                default:
                    return str;
            }
        }
    }

    public static final FetchGroupMemberProfilesListString m16190a() {
        return new FetchGroupMemberProfilesListString();
    }
}
