package com.facebook.groups.discover.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.discover.protocol.DiscoverMutationsModels.GroupHideSuggestionMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: UserTriggeredReport */
public final class DiscoverMutations {

    /* compiled from: UserTriggeredReport */
    public class GroupHideSuggestionMutationString extends TypedGraphQLMutationString<GroupHideSuggestionMutationModel> {
        public GroupHideSuggestionMutationString() {
            super(GroupHideSuggestionMutationModel.class, false, "GroupHideSuggestionMutation", "57a48dfca3a736248d495d5f5a758bd2", "group_hide_suggestion", "0", "10154204803441729", RegularImmutableSet.a);
        }

        public final String m22182a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
