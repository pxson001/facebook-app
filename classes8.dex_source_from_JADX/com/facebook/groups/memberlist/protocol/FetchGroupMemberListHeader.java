package com.facebook.groups.memberlist.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberListHeaderModels.FetchGroupMemberListHeaderModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_fundraiser_progress_text */
public final class FetchGroupMemberListHeader {

    /* compiled from: extra_fundraiser_progress_text */
    public class FetchGroupMemberListHeaderString extends TypedGraphQlQueryString<FetchGroupMemberListHeaderModel> {
        public FetchGroupMemberListHeaderString() {
            super(FetchGroupMemberListHeaderModel.class, false, "FetchGroupMemberListHeader", "e962fb0e83ccef99024fca2e2dc6258a", "group_address", "10154500825796729", RegularImmutableSet.a);
        }

        public final String m16170a(String str) {
            switch (str.hashCode()) {
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
