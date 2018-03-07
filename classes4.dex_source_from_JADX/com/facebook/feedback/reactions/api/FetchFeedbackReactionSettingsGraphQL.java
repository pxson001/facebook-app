package com.facebook.feedback.reactions.api;

import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: search_type */
public final class FetchFeedbackReactionSettingsGraphQL {

    /* compiled from: search_type */
    public class FetchFeedbackReactionsVectorDataQueryString extends TypedGraphQlQueryString<FetchFeedbackReactionsVectorDataQueryModel> {
        public FetchFeedbackReactionsVectorDataQueryString() {
            super(FetchFeedbackReactionsVectorDataQueryModel.class, false, "FetchFeedbackReactionsVectorDataQuery", "cf8ae9d1e8de833923854c1d57c7cea0", "viewer", "10154390353051729", RegularImmutableSet.a);
        }
    }
}
