package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: ViewUtils */
public class GraphQLPrivacyAudienceMember$Builder extends Builder {
    @Nullable
    public String f12687d;
    @Nullable
    public String f12688e;
    @Nullable
    public GraphQLObjectType f12689f = null;

    public GraphQLPrivacyAudienceMember$Builder() {
        Preconditions.checkState(this instanceof GraphQLPrivacyAudienceMember$Builder);
    }

    public final GraphQLPrivacyAudienceMember m20976a() {
        return new GraphQLPrivacyAudienceMember(this);
    }
}
