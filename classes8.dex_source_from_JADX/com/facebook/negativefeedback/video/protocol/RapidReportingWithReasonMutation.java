package com.facebook.negativefeedback.video.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.negativefeedback.video.protocol.RapidReportingWithReasonMutationModels.RapidReportingWithReasonMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: textFields */
public final class RapidReportingWithReasonMutation {

    /* compiled from: textFields */
    public class RapidReportingWithReasonMutationString extends TypedGraphQLMutationString<RapidReportingWithReasonMutationModel> {
        public RapidReportingWithReasonMutationString() {
            super(RapidReportingWithReasonMutationModel.class, false, "RapidReportingWithReasonMutation", "5b4279fe736ec3512fcfea9b1422bde1", "story_add_report_reason", "0", "10154494100291729", RegularImmutableSet.a);
        }

        public final String m1869a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
