package com.facebook.feedplugins.gysc.protocols;

import com.facebook.feedplugins.gysc.protocols.blacklistGroupsYouShouldCreateMutationModels.GroupsYouShouldCreateXoutMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: friends_tab_search */
public final class blacklistGroupsYouShouldCreateMutation {

    /* compiled from: friends_tab_search */
    public class GroupsYouShouldCreateXoutMutationString extends TypedGraphQLMutationString<GroupsYouShouldCreateXoutMutationModel> {
        public GroupsYouShouldCreateXoutMutationString() {
            super(GroupsYouShouldCreateXoutMutationModel.class, false, "GroupsYouShouldCreateXoutMutation", "985431c94249300f375c412343997cae", "gysc_suggestion_xout", "0", "10154354471836729", RegularImmutableSet.a);
        }

        public final String m14616a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
