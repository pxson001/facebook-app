package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLStorySaveNuxType;
import com.facebook.graphql.enums.GraphQLStorySaveType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;

/* compiled from: Unable to copy attachment for bug report. */
public class GraphQLStorySaveInfo$Builder extends Builder {
    public int f13168d;
    public int f13169e;
    public GraphQLStorySaveNuxType f13170f = GraphQLStorySaveNuxType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLStorySaveType f13171g = GraphQLStorySaveType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLSavedState f13172h = GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

    public GraphQLStorySaveInfo$Builder() {
        Preconditions.checkState(this instanceof GraphQLStorySaveInfo$Builder);
    }
}
