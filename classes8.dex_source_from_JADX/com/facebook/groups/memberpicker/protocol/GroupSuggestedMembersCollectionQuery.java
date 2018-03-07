package com.facebook.groups.memberpicker.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersCollectionQueryModels.GroupSuggestedMembersCollectionQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: event_message_friends */
public final class GroupSuggestedMembersCollectionQuery {

    /* compiled from: event_message_friends */
    public class GroupSuggestedMembersCollectionQueryString extends TypedGraphQlQueryString<GroupSuggestedMembersCollectionQueryModel> {
        public GroupSuggestedMembersCollectionQueryString() {
            super(GroupSuggestedMembersCollectionQueryModel.class, false, "GroupSuggestedMembersCollectionQuery", "fb928eec0717d56ef31ffab0984bbccd", "node", "10154358997921729", RegularImmutableSet.a);
        }

        public final String m16709a(String str) {
            switch (str.hashCode()) {
                case -767546005:
                    return "5";
                case -381590603:
                    return "4";
                case -230346670:
                    return "3";
                case 109250890:
                    return "7";
                case 120048402:
                    return "6";
                case 506361563:
                    return "0";
                case 1349961252:
                    return "2";
                case 1653058771:
                    return "1";
                default:
                    return str;
            }
        }
    }

    public static final GroupSuggestedMembersCollectionQueryString m16710a() {
        return new GroupSuggestedMembersCollectionQueryString();
    }
}
