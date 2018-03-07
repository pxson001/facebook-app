package com.facebook.dialtone.protocol;

import com.facebook.dialtone.protocol.DialtoneGraphQLModels.DialtonePhotoUnblockMutationModel;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.FetchDialtonePhotoQuotaModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: [anySetter] */
public final class DialtoneGraphQL {

    /* compiled from: [anySetter] */
    public class DialtonePhotoUnblockMutationString extends TypedGraphQLMutationString<DialtonePhotoUnblockMutationModel> {
        public DialtonePhotoUnblockMutationString() {
            super(DialtonePhotoUnblockMutationModel.class, false, "DialtonePhotoUnblockMutation", "2888ea5920712eb4410fbf90ddbc6c2b", "image_unblock_for_dialtone", "0", "10154597822456729", RegularImmutableSet.a);
        }

        public final String m19881a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: [anySetter] */
    public class FetchDialtonePhotoQuotaString extends TypedGraphQlQueryString<FetchDialtonePhotoQuotaModel> {
        public FetchDialtonePhotoQuotaString() {
            super(FetchDialtonePhotoQuotaModel.class, false, "FetchDialtonePhotoQuota", "e657e24d3a569ee6008a63ff58b81b33", "viewer", "10154597822451729", RegularImmutableSet.a);
        }
    }

    public static final FetchDialtonePhotoQuotaString m19882a() {
        return new FetchDialtonePhotoQuotaString();
    }
}
