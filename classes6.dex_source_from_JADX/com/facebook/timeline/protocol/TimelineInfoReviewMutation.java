package com.facebook.timeline.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.timeline.protocol.TimelineInfoReviewMutationModels.TimelineInfoReviewItemHideMutationModel;
import com.facebook.timeline.protocol.TimelineInfoReviewMutationModels.TimelineInfoReviewQuestionSaveMutationModel;
import com.facebook.timeline.protocol.TimelineInfoReviewMutationModels.TimelineInfoReviewQuestionSkipMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: data_time */
public final class TimelineInfoReviewMutation {

    /* compiled from: data_time */
    public class TimelineInfoReviewItemHideMutationString extends TypedGraphQLMutationString<TimelineInfoReviewItemHideMutationModel> {
        public TimelineInfoReviewItemHideMutationString() {
            super(TimelineInfoReviewItemHideMutationModel.class, false, "TimelineInfoReviewItemHideMutation", "5b3a87b9194188b9f83c8ecd7efbf494", "timeline_info_review_item_hide", "0", "10154204805541729", RegularImmutableSet.a);
        }

        public final String m26383a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: data_time */
    public class TimelineInfoReviewQuestionSaveMutationString extends TypedGraphQLMutationString<TimelineInfoReviewQuestionSaveMutationModel> {
        public TimelineInfoReviewQuestionSaveMutationString() {
            super(TimelineInfoReviewQuestionSaveMutationModel.class, false, "TimelineInfoReviewQuestionSaveMutation", "daa424daec4f3e7f2386443387d633f0", "profile_question_save", "0", "10154429040251729", RegularImmutableSet.a);
        }

        public final String m26384a(String str) {
            switch (str.hashCode()) {
                case -1853231955:
                    return "4";
                case 112787:
                    return "3";
                case 100358090:
                    return "0";
                case 109250890:
                    return "2";
                case 1984987798:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: data_time */
    public class TimelineInfoReviewQuestionSkipMutationString extends TypedGraphQLMutationString<TimelineInfoReviewQuestionSkipMutationModel> {
        public TimelineInfoReviewQuestionSkipMutationString() {
            super(TimelineInfoReviewQuestionSkipMutationModel.class, false, "TimelineInfoReviewQuestionSkipMutation", "cf710cbe9e9b697be927bada17d801ba", "profile_question_skip", "0", "10154429040256729", RegularImmutableSet.a);
        }

        public final String m26385a(String str) {
            switch (str.hashCode()) {
                case -1853231955:
                    return "4";
                case 112787:
                    return "3";
                case 100358090:
                    return "0";
                case 109250890:
                    return "2";
                case 1984987798:
                    return "1";
                default:
                    return str;
            }
        }
    }

    public static final TimelineInfoReviewItemHideMutationString m26386a() {
        return new TimelineInfoReviewItemHideMutationString();
    }
}
