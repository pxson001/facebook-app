package com.facebook.confirmation.graphql;

import com.facebook.confirmation.graphql.FBResendContactpointCodeFragmentsModels.FBResendContactpointCodeCoreMutationFragmentModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: interaction */
public final class FBResendContactpointCodeFragments {

    /* compiled from: interaction */
    public class FBResendContactpointCodeCoreMutationString extends TypedGraphQLMutationString<FBResendContactpointCodeCoreMutationFragmentModel> {
        public FBResendContactpointCodeCoreMutationString() {
            super(FBResendContactpointCodeCoreMutationFragmentModel.class, false, "FBResendContactpointCodeCoreMutation", "a1f60936cfccdf338c72b6b001a74fad", "resend_contactpoint_code", "0", "10154609589176729", RegularImmutableSet.a);
        }

        public final String m12691a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
