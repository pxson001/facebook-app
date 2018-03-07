package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: UNSELECTED */
public class GraphQLTaggableActivityPreviewTemplate$Builder extends Builder {
    @Nullable
    public String f13261d;
    public ImmutableList<GraphQLActivityTemplateToken> f13262e;

    public GraphQLTaggableActivityPreviewTemplate$Builder() {
        Preconditions.checkState(this instanceof GraphQLTaggableActivityPreviewTemplate$Builder);
    }

    public final GraphQLTaggableActivityPreviewTemplate m22056a() {
        return new GraphQLTaggableActivityPreviewTemplate(this);
    }
}
