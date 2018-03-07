package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLPlaceSuggestionType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: WATCHED_RECOMMENDATIONS */
public class GraphQLPlaceSuggestionInfo$Builder extends Builder {
    @Nullable
    public GraphQLPage f12667d;
    @Nullable
    public String f12668e;
    public GraphQLPlaceSuggestionType f12669f = GraphQLPlaceSuggestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

    public GraphQLPlaceSuggestionInfo$Builder() {
        Preconditions.checkState(this instanceof GraphQLPlaceSuggestionInfo$Builder);
    }
}
