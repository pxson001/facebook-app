package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLActivityTemplateTokenType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;

/* compiled from: launch_point_friend_invites */
public class GraphQLActivityTemplateToken$Builder extends Builder {
    public int f3272d;
    public GraphQLActivityTemplateTokenType f3273e = GraphQLActivityTemplateTokenType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

    public GraphQLActivityTemplateToken$Builder() {
        Preconditions.checkState(this instanceof GraphQLActivityTemplateToken$Builder);
    }

    public final GraphQLActivityTemplateToken m6389a() {
        return new GraphQLActivityTemplateToken(this);
    }
}
