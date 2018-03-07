package com.facebook.checkpoint;

import com.facebook.checkpoint.api.CheckpointMutationModels.CheckpointCancelMutationFragmentModel;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: raw_timestamp */
public class CheckpointBroadcaster$2 implements FutureCallback<GraphQLResult<CheckpointCancelMutationFragmentModel>> {
    final /* synthetic */ CheckpointBroadcaster f5878a;

    public CheckpointBroadcaster$2(CheckpointBroadcaster checkpointBroadcaster) {
        this.f5878a = checkpointBroadcaster;
    }

    public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
    }

    public void onFailure(Throwable th) {
        BLog.b(CheckpointBroadcaster.a, "Clear user from non-blocking checkpoint failed");
    }
}
