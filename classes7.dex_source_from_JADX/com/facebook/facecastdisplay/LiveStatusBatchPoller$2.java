package com.facebook.facecastdisplay;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.facecastdisplay.protocol.FetchViewerCountAndBroadcastStatusQueryModels.FetchViewerCountAndBroadcastStatusQueryModel;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: audio/vorbis */
class LiveStatusBatchPoller$2 extends AbstractDisposableFutureCallback<Map<String, FetchViewerCountAndBroadcastStatusQueryModel>> {
    final /* synthetic */ LiveStatusBatchPoller f18919a;

    LiveStatusBatchPoller$2(LiveStatusBatchPoller liveStatusBatchPoller) {
        this.f18919a = liveStatusBatchPoller;
    }

    protected final void m22518a(@Nullable Object obj) {
        Map map = (Map) obj;
        if (map != null && this.f18919a.h != null) {
            this.f18919a.h.a(map);
        }
    }

    protected final void m22519a(Throwable th) {
        this.f18919a.b.a(LiveStatusBatchPoller.a, "video broadcast poll failed for " + this.f18919a.f, th);
    }
}
