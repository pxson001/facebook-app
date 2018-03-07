package com.facebook.reaction.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsModels.CrisisMarkSelfSafeMutationModel;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsModels.DeclareCrisisLocationOutMutationModel;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsModels.PageAdminInviteAcceptMutationModel;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsModels.PageAdminInviteDeclineMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: fetching_media_for_ */
public final class ReactionMutationFragments {

    /* compiled from: fetching_media_for_ */
    public class CrisisMarkSelfSafeMutationString extends TypedGraphQLMutationString<CrisisMarkSelfSafeMutationModel> {
        public CrisisMarkSelfSafeMutationString() {
            super(CrisisMarkSelfSafeMutationModel.class, false, "CrisisMarkSelfSafeMutation", "111a7dd22330c79218355c24acbd411e", "mark_self_safe", "0", "10154594439901729", RegularImmutableSet.a);
        }

        public final String m16636a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: fetching_media_for_ */
    public class DeclareCrisisLocationOutMutationString extends TypedGraphQLMutationString<DeclareCrisisLocationOutMutationModel> {
        public DeclareCrisisLocationOutMutationString() {
            super(DeclareCrisisLocationOutMutationModel.class, false, "DeclareCrisisLocationOutMutation", "7391cd54cadf559f86d67cc6f4d72175", "declare_crisis_location_out", "0", "10154594439891729", RegularImmutableSet.a);
        }

        public final String m16637a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: fetching_media_for_ */
    public class PageAdminInviteAcceptMutationString extends TypedGraphQLMutationString<PageAdminInviteAcceptMutationModel> {
        public PageAdminInviteAcceptMutationString() {
            super(PageAdminInviteAcceptMutationModel.class, false, "PageAdminInviteAcceptMutation", "9ebd5d19dd1acdb394297a94e86492f0", "page_admin_invite_accept", "0", "10154346623836729", RegularImmutableSet.a);
        }

        public final String m16638a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: fetching_media_for_ */
    public class PageAdminInviteDeclineMutationString extends TypedGraphQLMutationString<PageAdminInviteDeclineMutationModel> {
        public PageAdminInviteDeclineMutationString() {
            super(PageAdminInviteDeclineMutationModel.class, false, "PageAdminInviteDeclineMutation", "ad520371982c81d0a3af45bbb7240bd5", "page_admin_invite_decline", "0", "10154426577686729", RegularImmutableSet.a);
        }

        public final String m16639a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
