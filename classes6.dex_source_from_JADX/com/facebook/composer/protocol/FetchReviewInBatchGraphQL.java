package com.facebook.composer.protocol;

import com.facebook.common.util.TriState;
import com.facebook.composer.protocol.FetchReviewInBatchGraphQLModels.FetchReviewInBatchModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: placeTypes */
public final class FetchReviewInBatchGraphQL {

    /* compiled from: placeTypes */
    public class FetchReviewInBatchString extends TypedGraphQlQueryString<FetchReviewInBatchModel> {
        public FetchReviewInBatchString() {
            super(FetchReviewInBatchModel.class, false, "FetchReviewInBatch", "f55852ea321ad8b1699e751877117738", "node", "10154686241011729", RegularImmutableSet.a);
        }

        public final TriState m11452g() {
            return TriState.NO;
        }

        public final String m11451a(String str) {
            switch (str.hashCode()) {
                case -1012194872:
                    return "1";
                case 334980221:
                    return "2";
                case 493034338:
                    return "0";
                case 1018939763:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
