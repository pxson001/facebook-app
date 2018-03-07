package com.facebook.negativefeedback.video.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.negativefeedback.video.protocol.RapidReportingMutationModels.RapidReportingMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: text_selection_dismissed */
public final class RapidReportingMutation {

    /* compiled from: text_selection_dismissed */
    public class RapidReportingMutationString extends TypedGraphQLMutationString<RapidReportingMutationModel> {
        public RapidReportingMutationString() {
            super(RapidReportingMutationModel.class, false, "RapidReportingMutation", "ca7fdbdd015edfd7851418cc901fda0c", "story_report", "0", "10154499973101729", RegularImmutableSet.a);
        }

        public final String m1816a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
