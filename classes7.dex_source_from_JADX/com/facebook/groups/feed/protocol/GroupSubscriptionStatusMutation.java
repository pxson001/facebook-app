package com.facebook.groups.feed.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.feed.protocol.GroupSubscriptionStatusMutationModels.GroupSubscribeMutationFragmentModel;
import com.facebook.groups.feed.protocol.GroupSubscriptionStatusMutationModels.GroupUnsubscribeMutationFragmentModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: push_channel */
public final class GroupSubscriptionStatusMutation {

    /* compiled from: push_channel */
    public class GroupSubscribeMutationString extends TypedGraphQLMutationString<GroupSubscribeMutationFragmentModel> {
        public GroupSubscribeMutationString() {
            super(GroupSubscribeMutationFragmentModel.class, false, "GroupSubscribeMutation", "a520892b4998c33fdc0e6e26bad339be", "group_subscribe", "0", "10154343224781729", RegularImmutableSet.a);
        }

        public final String m6869a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: push_channel */
    public class GroupUnsubscribeMutationString extends TypedGraphQLMutationString<GroupUnsubscribeMutationFragmentModel> {
        public GroupUnsubscribeMutationString() {
            super(GroupUnsubscribeMutationFragmentModel.class, false, "GroupUnsubscribeMutation", "7967f387670966eeae85fcbdfea80993", "group_unsubscribe", "0", "10154343224786729", RegularImmutableSet.a);
        }

        public final String m6870a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
