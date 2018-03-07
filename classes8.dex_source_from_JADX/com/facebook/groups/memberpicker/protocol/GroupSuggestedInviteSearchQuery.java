package com.facebook.groups.memberpicker.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQueryModels.GroupInviteMembersSearchQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: event_tip_view */
public final class GroupSuggestedInviteSearchQuery {

    /* compiled from: event_tip_view */
    public class GroupInviteMembersSearchQueryString extends TypedGraphQlQueryString<GroupInviteMembersSearchQueryModel> {
        public GroupInviteMembersSearchQueryString() {
            super(GroupInviteMembersSearchQueryModel.class, false, "GroupInviteMembersSearchQuery", "78a3fb15f9062ff2684523cdfa06bd71", "node", "10154358537441729", RegularImmutableSet.a);
        }

        public final String m16600a(String str) {
            switch (str.hashCode()) {
                case -249250188:
                    return "3";
                case -147132913:
                    return "0";
                case 104585017:
                    return "1";
                case 109250890:
                    return "5";
                case 120048402:
                    return "4";
                case 506361563:
                    return "2";
                default:
                    return str;
            }
        }
    }

    public static final GroupInviteMembersSearchQueryString m16601a() {
        return new GroupInviteMembersSearchQueryString();
    }
}
