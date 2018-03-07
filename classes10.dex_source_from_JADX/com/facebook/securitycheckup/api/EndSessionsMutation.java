package com.facebook.securitycheckup.api;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.securitycheckup.api.EndSessionsMutationModels.EndSessionsMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: inbox_filter_impression */
public final class EndSessionsMutation {

    /* compiled from: inbox_filter_impression */
    public class EndSessionsMutationString extends TypedGraphQLMutationString<EndSessionsMutationModel> {
        public EndSessionsMutationString() {
            super(EndSessionsMutationModel.class, false, "EndSessionsMutation", "48503f2a29bbde5656d686f19eba26fa", "end_sessions", "0", "10154204805411729", RegularImmutableSet.a);
        }

        public final String m9935a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
