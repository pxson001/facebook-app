package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLAttributionSource;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: is_save_primary_action */
public class GraphQLAttributionEntry$Builder extends Builder {
    @Nullable
    public GraphQLTextWithEntities f3390d;
    @Nullable
    public GraphQLEntityCardContextItemIcon f3391e;
    @Nullable
    public String f3392f;
    public GraphQLAttributionSource f3393g = GraphQLAttributionSource.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

    public GraphQLAttributionEntry$Builder() {
        Preconditions.checkState(this instanceof GraphQLAttributionEntry$Builder);
    }

    public final GraphQLAttributionEntry m6611a() {
        return new GraphQLAttributionEntry(this);
    }
}
