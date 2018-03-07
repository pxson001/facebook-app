package com.facebook.tagging.graphql.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.tagging.graphql.protocol.FetchGroupMembersToMentionQueryModels.FetchGroupMembersToMentionQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: descriptionForShareLink */
public final class FetchGroupMembersToMentionQuery {

    /* compiled from: descriptionForShareLink */
    public class FetchGroupMembersToMentionQueryString extends TypedGraphQlQueryString<FetchGroupMembersToMentionQueryModel> {
        public FetchGroupMembersToMentionQueryString() {
            super(FetchGroupMembersToMentionQueryModel.class, false, "FetchGroupMembersToMentionQuery", "1303b786b225e90b323d7b2215e83bc0", "group", "10154588198221729", RegularImmutableSet.a);
        }

        public final String m25263a(String str) {
            switch (str.hashCode()) {
                case -815576439:
                    return "0";
                case 3530753:
                    return "3";
                case 97440432:
                    return "2";
                case 1281710614:
                    return "4";
                case 1595298664:
                    return "1";
                default:
                    return str;
            }
        }
    }

    public static final FetchGroupMembersToMentionQueryString m25264a() {
        return new FetchGroupMembersToMentionQueryString();
    }
}
