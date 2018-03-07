package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLRedirectionReason;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: VIDEO_ONLY */
public class GraphQLRedirectionInfo$Builder extends Builder {
    @Nullable
    public GraphQLNode f12911d;
    public GraphQLRedirectionReason f12912e = GraphQLRedirectionReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String f12913f;

    public GraphQLRedirectionInfo$Builder() {
        Preconditions.checkState(this instanceof GraphQLRedirectionInfo$Builder);
    }
}
