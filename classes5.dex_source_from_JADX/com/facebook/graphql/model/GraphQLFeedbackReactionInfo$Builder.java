package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: history */
public class GraphQLFeedbackReactionInfo$Builder extends Builder {
    @Nullable
    public String f3758d;
    @Nullable
    public String f3759e;
    public boolean f3760f;
    public int f3761g;
    @Nullable
    public GraphQLImage f3762h;
    @Nullable
    public String f3763i;
    @Nullable
    public GraphQLImage f3764j;
    @Nullable
    public GraphQLImage f3765k;
    @Nullable
    public String f3766l;

    public GraphQLFeedbackReactionInfo$Builder() {
        Preconditions.checkState(this instanceof GraphQLFeedbackReactionInfo$Builder);
    }

    public final GraphQLFeedbackReactionInfo m7486a() {
        return new GraphQLFeedbackReactionInfo(this);
    }
}
