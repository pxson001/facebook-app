package com.facebook.api.graphql.fetchfeedback;

import com.facebook.api.graphql.fetchfeedback.FetchFeedbackGraphQLModels.FetchFeedbackBaseFeedbackModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: animated_image */
public class FetchFeedbackGraphQL$StaticBaseFeedbackBatchQueryString extends TypedGraphQlQueryString<Map<String, FetchFeedbackBaseFeedbackModel>> {
    public FetchFeedbackGraphQL$StaticBaseFeedbackBatchQueryString() {
        super(FetchFeedbackBaseFeedbackModel.class, true, "StaticBaseFeedbackBatchQuery", "67bd6999a7ae63fd2c7f185529c5eb0c", "nodes", "10154633954826729", RegularImmutableSet.a);
    }

    public final String m16503a(String str) {
        switch (str.hashCode()) {
            case -1302586347:
                return "0";
            case -1101600581:
                return "1";
            case -1012194872:
                return "4";
            case -817257615:
                return "2";
            case 1963391292:
                return "3";
            default:
                return str;
        }
    }
}
