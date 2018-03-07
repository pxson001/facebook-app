package com.facebook.friends;

import com.facebook.fbservice.ops.BlueServiceOperationFactory$Operation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: frame_scale */
public class FriendingStartOperationHelper {
    public final GraphQLQueryExecutor f23311a;
    public final QeAccessor f23312b;

    public static FriendingStartOperationHelper m31459b(InjectorLike injectorLike) {
        return new FriendingStartOperationHelper(GraphQLQueryExecutor.m10435a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public FriendingStartOperationHelper(GraphQLQueryExecutor graphQLQueryExecutor, QeAccessor qeAccessor) {
        this.f23311a = graphQLQueryExecutor;
        this.f23312b = qeAccessor;
    }

    public static ListenableFuture<OperationResult> m31458a(BlueServiceOperationFactory$Operation blueServiceOperationFactory$Operation) {
        return blueServiceOperationFactory$Operation.mo3452a();
    }

    public final <T> ListenableFuture<GraphQLResult<T>> m31460a(MutationRequest<T> mutationRequest) {
        return this.f23311a.m10448a((MutationRequest) mutationRequest);
    }
}
