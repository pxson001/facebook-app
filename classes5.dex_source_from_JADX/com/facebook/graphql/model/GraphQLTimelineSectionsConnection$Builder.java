package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: UNDO_BUTTON */
public class GraphQLTimelineSectionsConnection$Builder extends Builder {
    public ImmutableList<GraphQLTimelineSection> f13350d;
    @Nullable
    public GraphQLPageInfo f13351e;

    public GraphQLTimelineSectionsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLTimelineSectionsConnection$Builder);
    }
}
