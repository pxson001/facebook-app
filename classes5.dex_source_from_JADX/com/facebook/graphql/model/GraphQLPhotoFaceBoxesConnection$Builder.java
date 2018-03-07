package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: WINDOWS_10_STORE */
public class GraphQLPhotoFaceBoxesConnection$Builder extends Builder {
    public ImmutableList<GraphQLFaceBox> f12553d;

    public GraphQLPhotoFaceBoxesConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLPhotoFaceBoxesConnection$Builder);
    }

    public final GraphQLPhotoFaceBoxesConnection m20725a() {
        return new GraphQLPhotoFaceBoxesConnection(this);
    }
}
