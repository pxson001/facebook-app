package com.facebook.timeline.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.timeline.protocol.RevertTemporaryMutationModels.RevertTemporaryMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: db_configs_in_quarantine */
public final class RevertTemporaryMutation {

    /* compiled from: db_configs_in_quarantine */
    public class RevertTemporaryMutationString extends TypedGraphQLMutationString<RevertTemporaryMutationModel> {
        public RevertTemporaryMutationString() {
            super(RevertTemporaryMutationModel.class, false, "RevertTemporaryMutation", "0fedbf3c00fd91e89b280c99ca45c1be", "profile_pic_revert_temporary", "0", "10154204805561729", RegularImmutableSet.a);
        }

        public final String m26296a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
