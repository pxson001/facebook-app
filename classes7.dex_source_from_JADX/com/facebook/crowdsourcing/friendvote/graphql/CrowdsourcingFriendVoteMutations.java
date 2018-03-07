package com.facebook.crowdsourcing.friendvote.graphql;

import com.facebook.crowdsourcing.friendvote.graphql.CrowdsourcingFriendVoteMutationsModels.CrowdsourcingFriendVoteInviteModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: com.facebook.react.devsupport. */
public final class CrowdsourcingFriendVoteMutations {

    /* compiled from: com.facebook.react.devsupport. */
    public class CrowdsourcingFriendVoteInviteString extends TypedGraphQLMutationString<CrowdsourcingFriendVoteInviteModel> {
        public CrowdsourcingFriendVoteInviteString() {
            super(CrowdsourcingFriendVoteInviteModel.class, false, "CrowdsourcingFriendVoteInvite", "f0fb962f65458dba4167c9dfb610dd5a", "crowdsourcing_friend_vote_invite", "0", "10154204802741729", RegularImmutableSet.a);
        }

        public final String m21314a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
