package com.facebook.video.videohome.protocol;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.video.videohome.protocol.VideoHomeMutationsModels.VideoHomeVisitMutationModel;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: disable_immersive_hooks */
public class VideoHomeMutationsHelper$1 implements Runnable {
    final /* synthetic */ ListenableFuture f15756a;
    final /* synthetic */ VideoHomeMutationsHelper f15757b;

    /* compiled from: disable_immersive_hooks */
    class C12061 implements FutureCallback<GraphQLResult<VideoHomeVisitMutationModel>> {
        final /* synthetic */ VideoHomeMutationsHelper$1 f15755a;

        public void onSuccess(@Nullable Object obj) {
            String str = VideoHomeMutationsHelper.a;
        }

        C12061(VideoHomeMutationsHelper$1 videoHomeMutationsHelper$1) {
            this.f15755a = videoHomeMutationsHelper$1;
        }

        public void onFailure(Throwable th) {
            BLog.b(VideoHomeMutationsHelper.a, "VideoHome visit mutation failed.");
        }
    }

    public VideoHomeMutationsHelper$1(VideoHomeMutationsHelper videoHomeMutationsHelper, ListenableFuture listenableFuture) {
        this.f15757b = videoHomeMutationsHelper;
        this.f15756a = listenableFuture;
    }

    public void run() {
        this.f15757b.b.a(this.f15756a, new C12061(this));
    }
}
