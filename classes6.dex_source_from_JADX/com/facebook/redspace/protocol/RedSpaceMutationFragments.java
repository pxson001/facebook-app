package com.facebook.redspace.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsModels.RedSpaceFriendDemoteMutationModel;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsModels.RedSpaceFriendPromoteMutationModel;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsModels.RedSpaceFriendViewMutationModel;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsModels.RedSpaceHomeViewMutationModel;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsModels.RedSpaceSelfViewMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: shouldUpdateRelationshipStatus */
public final class RedSpaceMutationFragments {

    /* compiled from: shouldUpdateRelationshipStatus */
    public class RedSpaceFriendDemoteMutationString extends TypedGraphQLMutationString<RedSpaceFriendDemoteMutationModel> {
        public RedSpaceFriendDemoteMutationString() {
            super(RedSpaceFriendDemoteMutationModel.class, false, "RedSpaceFriendDemoteMutation", "32a5bfc990879337878af6ab39400368", "redspace_user_demote", "0", "10154204805271729", RegularImmutableSet.a);
        }

        public final String m6918a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: shouldUpdateRelationshipStatus */
    public class RedSpaceFriendPromoteMutationString extends TypedGraphQLMutationString<RedSpaceFriendPromoteMutationModel> {
        public RedSpaceFriendPromoteMutationString() {
            super(RedSpaceFriendPromoteMutationModel.class, false, "RedSpaceFriendPromoteMutation", "22e0f7c6fef901055e2c6b87ee218d06", "redspace_user_promote", "0", "10154561332621729", RegularImmutableSet.a);
        }

        public final String m6919a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                case 853187141:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: shouldUpdateRelationshipStatus */
    public class RedSpaceFriendViewMutationString extends TypedGraphQLMutationString<RedSpaceFriendViewMutationModel> {
        public RedSpaceFriendViewMutationString() {
            super(RedSpaceFriendViewMutationModel.class, false, "RedSpaceFriendViewMutation", "642297967783a20b3021b659fbe72a79", "redspace_user_view", "0", "10154561332631729", RegularImmutableSet.a);
        }

        public final String m6920a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                case 853187141:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: shouldUpdateRelationshipStatus */
    public class RedSpaceHomeViewMutationString extends TypedGraphQLMutationString<RedSpaceHomeViewMutationModel> {
        public RedSpaceHomeViewMutationString() {
            super(RedSpaceHomeViewMutationModel.class, false, "RedSpaceHomeViewMutation", "da41209781b42d6b70d86635a403e095", "redspace_home_view", "0", "10154204805286729", RegularImmutableSet.a);
        }

        public final String m6921a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: shouldUpdateRelationshipStatus */
    public class RedSpaceSelfViewMutationString extends TypedGraphQLMutationString<RedSpaceSelfViewMutationModel> {
        public RedSpaceSelfViewMutationString() {
            super(RedSpaceSelfViewMutationModel.class, false, "RedSpaceSelfViewMutation", "511325e4792fa64642d0f7310d2b6da6", "redspace_self_view", "0", "10154677147691729", RegularImmutableSet.a);
        }

        public final String m6922a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
