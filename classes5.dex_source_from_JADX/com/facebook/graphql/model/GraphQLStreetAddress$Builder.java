package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: USER_CANCEL */
public class GraphQLStreetAddress$Builder extends Builder {
    @Nullable
    public String f13199d;
    @Nullable
    public String f13200e;
    @Nullable
    public String f13201f;
    @Nullable
    public String f13202g;
    @Nullable
    public String f13203h;
    @Nullable
    public String f13204i;
    @Nullable
    public String f13205j;
    @Nullable
    public String f13206k;

    public GraphQLStreetAddress$Builder() {
        Preconditions.checkState(this instanceof GraphQLStreetAddress$Builder);
    }

    public final GraphQLStreetAddress m21931a() {
        return new GraphQLStreetAddress(this);
    }
}
