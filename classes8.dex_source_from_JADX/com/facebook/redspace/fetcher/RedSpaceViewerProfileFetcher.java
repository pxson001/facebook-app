package com.facebook.redspace.fetcher;

import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ultralight.Inject;

/* compiled from: USER_REVIEW */
public class RedSpaceViewerProfileFetcher {
    @Inject
    @LoggedInUserId
    public String f21326a;
    @Inject
    public GraphQLQueryExecutor f21327b;
    @Inject
    public RedSpaceRequests f21328c;
    @Inject
    public TasksManager f21329d;
}
