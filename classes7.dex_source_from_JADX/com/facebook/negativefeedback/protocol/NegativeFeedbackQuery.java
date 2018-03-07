package com.facebook.negativefeedback.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryModels.NegativeFeedbackFlowForMessageThreadQueryModel;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryModels.NegativeFeedbackFlowStepQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: notification_unbatched_true_impression */
public final class NegativeFeedbackQuery {

    /* compiled from: notification_unbatched_true_impression */
    public class NegativeFeedbackFlowForMessageThreadQueryString extends TypedGraphQlQueryString<NegativeFeedbackFlowForMessageThreadQueryModel> {
        public NegativeFeedbackFlowForMessageThreadQueryString() {
            super(NegativeFeedbackFlowForMessageThreadQueryModel.class, false, "NegativeFeedbackFlowForMessageThreadQuery", "a9080d3eb0efacd93554dfcc50a0b51e", "message_thread", "10154354464491729", RegularImmutableSet.a);
        }

        public final String m9610a(String str) {
            switch (str.hashCode()) {
                case -1562235024:
                    return "0";
                case -226345212:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: notification_unbatched_true_impression */
    public class NegativeFeedbackFlowStepQueryString extends TypedGraphQlQueryString<NegativeFeedbackFlowStepQueryModel> {
        public NegativeFeedbackFlowStepQueryString() {
            super(NegativeFeedbackFlowStepQueryModel.class, false, "NegativeFeedbackFlowStepQuery", "55bbd5c2fdf70e4870b7600c7afae753", "node", "10154354464496729", RegularImmutableSet.a);
        }

        public final String m9611a(String str) {
            switch (str.hashCode()) {
                case -1662763611:
                    return "1";
                case 1555612028:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
