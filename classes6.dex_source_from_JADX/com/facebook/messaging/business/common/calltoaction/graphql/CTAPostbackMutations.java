package com.facebook.messaging.business.common.calltoaction.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.business.common.calltoaction.graphql.CTAPostbackMutationsModels.CTAPostbackMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: video_publishers */
public final class CTAPostbackMutations {

    /* compiled from: video_publishers */
    public class CTAPostbackMutationString extends TypedGraphQLMutationString<CTAPostbackMutationModel> {
        public CTAPostbackMutationString() {
            super(CTAPostbackMutationModel.class, false, "CTAPostbackMutation", "7d82af3157e632da91447f45a44d199c", "messenger_call_to_action_postback", "0", "10154468971416729", RegularImmutableSet.a);
        }

        public final String m715a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
