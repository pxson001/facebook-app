package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLFeedbackRealTimeActivityType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: hideStory */
public class GraphQLFeedbackRealTimeActivityInfo$Builder extends Builder {
    @Nullable
    public GraphQLFeedbackRealTimeActivityActorsConnection f3769d;
    @Nullable
    public GraphQLTextWithEntities f3770e;
    public GraphQLFeedbackRealTimeActivityType f3771f = GraphQLFeedbackRealTimeActivityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

    public GraphQLFeedbackRealTimeActivityInfo$Builder() {
        Preconditions.checkState(this instanceof GraphQLFeedbackRealTimeActivityInfo$Builder);
    }
}
