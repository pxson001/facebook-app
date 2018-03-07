package com.facebook.groups.memberpicker.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: event_card_tap */
public final class GroupSuggestedMembersSearchQuery {

    /* compiled from: event_card_tap */
    public class GroupSuggestedMembersSearchQueryString extends TypedGraphQlQueryString<GroupSuggestedMembersSearchQueryModel> {
        public GroupSuggestedMembersSearchQueryString() {
            super(GroupSuggestedMembersSearchQueryModel.class, false, "GroupSuggestedMembersSearchQuery", "d5498645fc0b702aab67315fabe5daab", "node", "10154358997856729", RegularImmutableSet.a);
        }

        public final String m16765a(String str) {
            switch (str.hashCode()) {
                case -767546005:
                    return "3";
                case -539238237:
                    return "1";
                case -230346670:
                    return "2";
                case 109250890:
                    return "5";
                case 120048402:
                    return "4";
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final GroupSuggestedMembersSearchQueryString m16766a() {
        return new GroupSuggestedMembersSearchQueryString();
    }
}
