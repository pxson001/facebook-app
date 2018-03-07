package com.facebook.facecastdisplay;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.executor.GraphQLResult;
import javax.annotation.Nullable;

/* compiled from: audio/vnd.dts.hd;profile=lbr */
class LiveStatusPoller$1 extends AbstractDisposableFutureCallback<GraphQLResult<VideoBroadcastFragmentModel>> {
    final /* synthetic */ LiveStatusPoller f18921a;

    LiveStatusPoller$1(LiveStatusPoller liveStatusPoller) {
        this.f18921a = liveStatusPoller;
    }

    protected final void m22520a(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null) {
            String str = LiveStatusPoller.a;
            str = this.f18921a.h;
            if (this.f18921a.g != null) {
                this.f18921a.g.a(this.f18921a.h);
                return;
            }
            return;
        }
        VideoBroadcastFragmentModel videoBroadcastFragmentModel = (VideoBroadcastFragmentModel) graphQLResult.e;
        GraphQLVideoBroadcastStatus d = videoBroadcastFragmentModel.m4015d();
        this.f18921a.l = d;
        Object obj2 = (d == GraphQLVideoBroadcastStatus.VOD_READY || d == GraphQLVideoBroadcastStatus.LEGACY) ? null : 1;
        int max = Math.max(videoBroadcastFragmentModel.m4023p(), videoBroadcastFragmentModel.m4024q());
        str = LiveStatusPoller.a;
        str = this.f18921a.h;
        String.valueOf(videoBroadcastFragmentModel.m4022o());
        Integer.valueOf(max);
        if (d != null) {
            String.valueOf(d);
        }
        if (this.f18921a.i != max) {
            this.f18921a.i = max;
            this.f18921a.j = Math.max(this.f18921a.i, this.f18921a.j);
            if (this.f18921a.g != null) {
                this.f18921a.g.r_(max);
            }
        }
        if (obj2 == null) {
            this.f18921a.a();
            if (this.f18921a.g != null) {
                this.f18921a.g.b(videoBroadcastFragmentModel);
            }
        } else if (this.f18921a.g != null) {
            this.f18921a.g.a(videoBroadcastFragmentModel);
        }
    }

    protected final void m22521a(Throwable th) {
        this.f18921a.b.a(LiveStatusPoller.a, "video broadcast poll failed for " + this.f18921a.h, th);
    }
}
