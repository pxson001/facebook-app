package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackTargetType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: expected closing END_ARRAY after type information and deserialized value */
public class GraphQLNegativeFeedbackAction$Builder extends Builder {
    public boolean f4547d;
    @Nullable
    public GraphQLTextWithEntities f4548e;
    @Nullable
    public GraphQLTextWithEntities f4549f;
    @Nullable
    public GraphQLTextWithEntities f4550g;
    @Nullable
    public GraphQLTextWithEntities f4551h;
    @Nullable
    public String f4552i;
    public GraphQLNegativeFeedbackActionType f4553j = GraphQLNegativeFeedbackActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLTextWithEntities f4554k;
    @Nullable
    public GraphQLProfile f4555l;
    public GraphQLNegativeFeedbackTargetType f4556m = GraphQLNegativeFeedbackTargetType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLTextWithEntities f4557n;
    @Nullable
    public GraphQLTextWithEntities f4558o;
    @Nullable
    public String f4559p;

    public GraphQLNegativeFeedbackAction$Builder() {
        Preconditions.checkState(this instanceof GraphQLNegativeFeedbackAction$Builder);
    }

    public final GraphQLNegativeFeedbackAction m9231a() {
        return new GraphQLNegativeFeedbackAction(this);
    }
}
