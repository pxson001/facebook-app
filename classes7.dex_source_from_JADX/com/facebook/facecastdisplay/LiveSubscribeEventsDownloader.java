package com.facebook.facecastdisplay;

import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.FetchLiveSubscriptionQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveSubscriptionQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: audio/opus */
public class LiveSubscribeEventsDownloader extends LiveEventsDownloader {
    public static final String f18943f = LiveSubscribeEventsDownloader.class.getName();
    private final ExecutorService f18944g;
    private final GraphQLQueryExecutor f18945h;
    public final AbstractFbErrorReporter f18946i;
    public final String f18947j;
    private final QeAccessor f18948k;
    private long f18949l;
    private long f18950m;
    @GuardedBy("this")
    @Nullable
    public volatile ListenableFuture<GraphQLResult<FetchLiveSubscriptionQueryModel>> f18951n;

    /* compiled from: audio/opus */
    class LiveSubscribeEventsGraphlQLCallback extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiveSubscriptionQueryModel>> {
        final /* synthetic */ LiveSubscribeEventsDownloader f18942a;

        public LiveSubscribeEventsGraphlQLCallback(LiveSubscribeEventsDownloader liveSubscribeEventsDownloader) {
            this.f18942a = liveSubscribeEventsDownloader;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void m22536a(@javax.annotation.Nullable java.lang.Object r5) {
            /*
            r4 = this;
            r5 = (com.facebook.graphql.executor.GraphQLResult) r5;
            r1 = r4.f18942a;
            monitor-enter(r1);
            r0 = r4.f18942a;	 Catch:{ all -> 0x001b }
            r0 = r0.f18951n;	 Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0015;
        L_0x000b:
            r0 = r4.f18942a;	 Catch:{ all -> 0x001b }
            r0 = r0.f18951n;	 Catch:{ all -> 0x001b }
            r0 = r0.isCancelled();	 Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0017;
        L_0x0015:
            monitor-exit(r1);	 Catch:{ all -> 0x001b }
        L_0x0016:
            return;
        L_0x0017:
            if (r5 != 0) goto L_0x001e;
        L_0x0019:
            monitor-exit(r1);	 Catch:{ all -> 0x001b }
            goto L_0x0016;
        L_0x001b:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x001b }
            throw r0;
        L_0x001e:
            r0 = r5.d();	 Catch:{  }
            r0 = (com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveSubscriptionQueryModel) r0;	 Catch:{  }
            r0 = com.facebook.facecastdisplay.LiveSubscribeEventModel.m22529a(r0);	 Catch:{  }
            if (r0 != 0) goto L_0x002c;
        L_0x002a:
            monitor-exit(r1);	 Catch:{  }
            goto L_0x0016;
        L_0x002c:
            r2 = r4.f18942a;	 Catch:{  }
            r2 = r2.f18947j;	 Catch:{  }
            r3 = r0.f2848k;	 Catch:{  }
            r3 = r3.f2903b;	 Catch:{  }
            r2 = r2.equals(r3);	 Catch:{  }
            if (r2 != 0) goto L_0x003e;
        L_0x003a:
            r2 = r0.f18935b;	 Catch:{  }
            if (r2 == 0) goto L_0x0040;
        L_0x003e:
            monitor-exit(r1);	 Catch:{  }
            goto L_0x0016;
        L_0x0040:
            r2 = new java.util.ArrayList;	 Catch:{  }
            r2.<init>();	 Catch:{  }
            r2.add(r0);	 Catch:{  }
            r0 = r4.f18942a;	 Catch:{  }
            r0 = r0.f2837b;	 Catch:{  }
            if (r0 == 0) goto L_0x0056;
        L_0x004e:
            r0 = r4.f18942a;	 Catch:{  }
            r0 = r0.f2837b;	 Catch:{  }
            r3 = 0;
            r0.m3267a(r2, r3);	 Catch:{  }
        L_0x0056:
            monitor-exit(r1);	 Catch:{  }
            goto L_0x0016;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.LiveSubscribeEventsDownloader.LiveSubscribeEventsGraphlQLCallback.a(java.lang.Object):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void m22537a(java.lang.Throwable r6) {
            /*
            r5 = this;
            r1 = r5.f18942a;
            monitor-enter(r1);
            r0 = r5.f18942a;	 Catch:{ all -> 0x005a }
            r0 = r0.f18951n;	 Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x0013;
        L_0x0009:
            r0 = r5.f18942a;	 Catch:{ all -> 0x005a }
            r0 = r0.f18951n;	 Catch:{ all -> 0x005a }
            r0 = r0.isCancelled();	 Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x0015;
        L_0x0013:
            monitor-exit(r1);	 Catch:{ all -> 0x005a }
        L_0x0014:
            return;
        L_0x0015:
            r0 = r5.f18942a;	 Catch:{ all -> 0x005a }
            r2 = r0.f18946i;	 Catch:{ all -> 0x005a }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005a }
            r0.<init>();	 Catch:{ all -> 0x005a }
            r3 = com.facebook.facecastdisplay.LiveSubscribeEventsDownloader.f18943f;	 Catch:{ all -> 0x005a }
            r0 = r0.append(r3);	 Catch:{ all -> 0x005a }
            r3 = "_graphFailure";
            r0 = r0.append(r3);	 Catch:{ all -> 0x005a }
            r3 = r0.toString();	 Catch:{ all -> 0x005a }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005a }
            r4 = "Failed to get subscribe events for ";
            r0.<init>(r4);	 Catch:{ all -> 0x005a }
            r4 = r5.f18942a;	 Catch:{ all -> 0x005a }
            r4 = r4.f2838c;	 Catch:{ all -> 0x005a }
            r0 = r0.append(r4);	 Catch:{ all -> 0x005a }
            r0 = r0.toString();	 Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x005d;
        L_0x0043:
            r0 = r5.f18942a;	 Catch:{ all -> 0x005a }
            r0 = r0.f2838c;	 Catch:{ all -> 0x005a }
        L_0x0047:
            r2.a(r3, r0, r6);	 Catch:{ all -> 0x005a }
            r0 = r5.f18942a;	 Catch:{ all -> 0x005a }
            r0 = r0.f2837b;	 Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x0058;
        L_0x0050:
            r0 = r5.f18942a;	 Catch:{ all -> 0x005a }
            r0 = r0.f2837b;	 Catch:{ all -> 0x005a }
            r2 = 0;
            r0.m3272c(r2);	 Catch:{ all -> 0x005a }
        L_0x0058:
            monitor-exit(r1);	 Catch:{ all -> 0x005a }
            goto L_0x0014;
        L_0x005a:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x005a }
            throw r0;
        L_0x005d:
            r0 = "no story id";
            goto L_0x0047;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.LiveSubscribeEventsDownloader.LiveSubscribeEventsGraphlQLCallback.a(java.lang.Throwable):void");
        }
    }

    @Inject
    public LiveSubscribeEventsDownloader(@Assisted ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter, String str, QeAccessor qeAccessor, Clock clock) {
        super(clock);
        this.f18944g = executorService;
        this.f18945h = graphQLQueryExecutor;
        this.f18946i = abstractFbErrorReporter;
        this.f18947j = str;
        this.f18948k = qeAccessor;
    }

    public final synchronized void mo125a(String str) {
        super.mo125a(str);
        this.e = true;
    }

    public final synchronized void mo119a() {
        super.mo119a();
        if (this.f18949l == 0) {
            this.f18949l = this.f2836a.a();
        }
        if (m22538i()) {
            if (TextUtils.isEmpty(this.f2838c)) {
                this.f18946i.a(f18943f + "_startFetching", "Tried to fetch without a story id.");
            } else {
                FetchLiveSubscriptionQueryString g = FetchLiveVideoEventsQuery.m3494g();
                g.a("targetID", this.f2838c);
                this.f18951n = this.f18945h.a(GraphQLRequest.a(g));
                Futures.a(this.f18951n, new LiveSubscribeEventsGraphlQLCallback(this), this.f18944g);
                this.f18950m = this.f2836a.a();
            }
        }
    }

    public final synchronized void mo120b() {
        if (this.f18951n != null) {
            this.f18951n.cancel(false);
        }
        this.f18950m = 0;
        this.f18949l = 0;
    }

    public final synchronized boolean mo121c() {
        boolean z;
        z = (this.f18951n == null || this.f18951n.isDone()) ? false : true;
        return z;
    }

    public final LiveEventType mo122d() {
        return LiveEventType.LIVE_SUBSCRIBE_EVENT;
    }

    private boolean m22538i() {
        if (this.f18948k.a(ExperimentsForVideoHomeAbTestModule.p, false)) {
            return false;
        }
        boolean z;
        if (this.f2836a.a() - this.f18949l > 3000) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (this.f2836a.a() - this.f18950m > 1800000) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }
}
