package com.facebook.ufiservices.data;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.Tuple;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.ipc.feed.ProfileListParamType;
import com.facebook.ufiservices.flyout.ProfileListParams;
import java.util.List;

/* compiled from: data11 */
public interface ProfilesListLoader {
    ProfileListParamType mo1345a();

    void mo1346a(ProfileListParams profileListParams, AbstractDisposableFutureCallback<Tuple<List<GraphQLActor>, GraphQLPageInfo>> abstractDisposableFutureCallback, boolean z, String str, CallerContext callerContext);

    boolean mo1347b();
}
