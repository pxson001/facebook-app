package com.facebook.groups.feed.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.feed.protocol.FeedStoryMutationsModels.FeedbackDisableCommentingMutationModel;
import com.facebook.groups.feed.protocol.FeedStoryMutationsModels.FeedbackEnableCommentingMutationModel;
import com.facebook.groups.feed.protocol.FeedStoryMutationsModels.GroupReportStoryToAdminMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: reaction_paginated_components */
public final class FeedStoryMutations {

    /* compiled from: reaction_paginated_components */
    public class FeedbackDisableCommentingMutationString extends TypedGraphQLMutationString<FeedbackDisableCommentingMutationModel> {
        public FeedbackDisableCommentingMutationString() {
            super(FeedbackDisableCommentingMutationModel.class, false, "FeedbackDisableCommentingMutation", "f01173d8630c17bcb00231d219031318", "feedback_disable_commenting", "0", "10154429038936729", RegularImmutableSet.a);
        }

        public final String m6197a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: reaction_paginated_components */
    public class FeedbackEnableCommentingMutationString extends TypedGraphQLMutationString<FeedbackEnableCommentingMutationModel> {
        public FeedbackEnableCommentingMutationString() {
            super(FeedbackEnableCommentingMutationModel.class, false, "FeedbackEnableCommentingMutation", "906efb97574b559e8902552ec3bf5434", "feedback_enable_commenting", "0", "10154429038931729", RegularImmutableSet.a);
        }

        public final String m6198a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: reaction_paginated_components */
    public class GroupReportStoryToAdminMutationString extends TypedGraphQLMutationString<GroupReportStoryToAdminMutationModel> {
        public GroupReportStoryToAdminMutationString() {
            super(GroupReportStoryToAdminMutationModel.class, false, "GroupReportStoryToAdminMutation", "5ba457ebea1ae361d2294db927f07131", "group_report_story_to_admin", "0", "10154204803446729", RegularImmutableSet.a);
        }

        public final String m6199a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
