package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.BoostInfoArchiveMutationModels.BoostInfoArchiveMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: YU */
public final class BoostInfoArchiveMutation {

    /* compiled from: YU */
    public class BoostInfotArchiveMutationString extends TypedGraphQLMutationString<BoostInfoArchiveMutationFieldsModel> {
        public BoostInfotArchiveMutationString() {
            super(BoostInfoArchiveMutationFieldsModel.class, false, "BoostInfotArchiveMutation", "a0e076095970dbf43ac9eb01a4b17ac6", "boost_info_archive", "0", "10154339186791729", RegularImmutableSet.a);
        }

        public final String m23955a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
