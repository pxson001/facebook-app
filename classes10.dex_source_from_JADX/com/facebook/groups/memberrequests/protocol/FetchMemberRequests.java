package com.facebook.groups.memberrequests.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TVF.onFragmentCreate */
public final class FetchMemberRequests {

    /* compiled from: TVF.onFragmentCreate */
    public class FetchMemberRequestsString extends TypedGraphQlQueryString<FetchMemberRequestsModel> {
        public FetchMemberRequestsString() {
            super(FetchMemberRequestsModel.class, false, "FetchMemberRequests", "e98984334f8a76f473604f70e5e4f94c", "group_address", "10154686077856729", RegularImmutableSet.a);
        }

        public final String m24042a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "4";
                case -147799178:
                    return "1";
                case 502454736:
                    return "2";
                case 506361563:
                    return "0";
                case 707132667:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
