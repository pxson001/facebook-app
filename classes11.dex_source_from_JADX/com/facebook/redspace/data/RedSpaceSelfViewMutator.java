package com.facebook.redspace.data;

import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.ultralight.Inject;

/* compiled from: PostsByOthersFragmentQuery */
public class RedSpaceSelfViewMutator {
    @Inject
    public GraphQLQueryExecutor f11873a;
    @Inject
    @LoggedInUserId
    public String f11874b;
}
