package com.facebook.groups.feed.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.feed.protocol.GroupSuggestionMutationModels.GroupSuggestionLoggingMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: purpose_image */
public final class GroupSuggestionMutation {

    /* compiled from: purpose_image */
    public class GroupSuggestionLoggingMutationString extends TypedGraphQLMutationString<GroupSuggestionLoggingMutationModel> {
        public GroupSuggestionLoggingMutationString() {
            super(GroupSuggestionLoggingMutationModel.class, false, "GroupSuggestionLoggingMutation", "dc30cbd7510ad1eb0917564e3afc3647", "aymt_log_event", "0", "10154583349146729", RegularImmutableSet.a);
        }

        public final String m6933a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
