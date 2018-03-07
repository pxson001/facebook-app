package com.facebook.groups.groupsasprofiles.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.groupsasprofiles.protocol.FetchGroupGraphQLModels.GroupsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: video_thumbnail_width */
public final class FetchGroupGraphQL {

    /* compiled from: video_thumbnail_width */
    public class GroupsQueryString extends TypedGraphQlQueryString<GroupsQueryModel> {
        public GroupsQueryString() {
            super(GroupsQueryModel.class, false, "GroupsQuery", "75ee4f071d3cc1aa05df7177c4ff7758", "viewer", "10154358997916729", RegularImmutableSet.a);
        }

        public final String m497a(String str) {
            switch (str.hashCode()) {
                case 109250890:
                    return "2";
                case 268639542:
                    return "1";
                case 1098237326:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final GroupsQueryString m498a() {
        return new GroupsQueryString();
    }
}
