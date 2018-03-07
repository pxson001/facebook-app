package com.facebook.timeline.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.timeline.protocol.TimelineVisitedMutationModels.TimelineVisitedMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: data_requested */
public final class TimelineVisitedMutation {

    /* compiled from: data_requested */
    public class TimelineVisitedMutationString extends TypedGraphQLMutationString<TimelineVisitedMutationModel> {
        public TimelineVisitedMutationString() {
            super(TimelineVisitedMutationModel.class, false, "TimelineVisitedMutation", "fbf31027bdb9441fc5a945820e04894d", "user_mark_profile_visited", "0", "10154204805571729", RegularImmutableSet.a);
        }

        public final String m26419a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
