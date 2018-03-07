package com.facebook.facecastdisplay;

import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.FetchLiveVideoAnnouncementsQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoAnnouncementsQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: subheader */
public class LiveAnnouncementsDownloader extends LiveEventsDownloader {
    public static final String f2841f = LiveAnnouncementsDownloader.class.getName();
    private final ExecutorService f2842g;
    private final GraphQLQueryExecutor f2843h;
    public final AbstractFbErrorReporter f2844i;
    public final Map<String, Integer> f2845j = new HashMap();
    private long f2846k;
    @Nullable
    public volatile ListenableFuture<GraphQLResult<FetchLiveVideoAnnouncementsQueryModel>> f2847l;

    /* compiled from: subheader */
    class LiveAnnouncementGraphQLCallback extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiveVideoAnnouncementsQueryModel>> {
        final /* synthetic */ LiveAnnouncementsDownloader f2835a;

        public LiveAnnouncementGraphQLCallback(LiveAnnouncementsDownloader liveAnnouncementsDownloader) {
            this.f2835a = liveAnnouncementsDownloader;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void m3132a(@javax.annotation.Nullable java.lang.Object r10) {
            /*
            r9 = this;
            r10 = (com.facebook.graphql.executor.GraphQLResult) r10;
            r1 = 0;
            r3 = r9.f2835a;
            monitor-enter(r3);
            r0 = r9.f2835a;	 Catch:{ all -> 0x001c }
            r0 = r0.f2847l;	 Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0016;
        L_0x000c:
            r0 = r9.f2835a;	 Catch:{ all -> 0x001c }
            r0 = r0.f2847l;	 Catch:{ all -> 0x001c }
            r0 = r0.isCancelled();	 Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0018;
        L_0x0016:
            monitor-exit(r3);	 Catch:{ all -> 0x001c }
        L_0x0017:
            return;
        L_0x0018:
            if (r10 != 0) goto L_0x001f;
        L_0x001a:
            monitor-exit(r3);	 Catch:{ all -> 0x001c }
            goto L_0x0017;
        L_0x001c:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x001c }
            throw r0;
        L_0x001f:
            r0 = r10.d();	 Catch:{  }
            r0 = (com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoAnnouncementsQueryModel) r0;	 Catch:{  }
            if (r0 != 0) goto L_0x0029;
        L_0x0027:
            monitor-exit(r3);	 Catch:{  }
            goto L_0x0017;
        L_0x0029:
            r0 = r0.m3691j();	 Catch:{  }
            if (r0 != 0) goto L_0x0031;
        L_0x002f:
            monitor-exit(r3);	 Catch:{  }
            goto L_0x0017;
        L_0x0031:
            r4 = r0.m3684a();	 Catch:{  }
            if (r4 != 0) goto L_0x0039;
        L_0x0037:
            monitor-exit(r3);	 Catch:{  }
            goto L_0x0017;
        L_0x0039:
            r0 = r9.f2835a;	 Catch:{  }
            r2 = 1;
            r0.e = r2;	 Catch:{  }
            r5 = new java.util.LinkedList;	 Catch:{  }
            r5.<init>();	 Catch:{  }
            r6 = r4.size();	 Catch:{  }
            r2 = r1;
        L_0x0048:
            if (r2 >= r6) goto L_0x0089;
        L_0x004a:
            r0 = r4.get(r2);	 Catch:{  }
            r0 = (com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.VideoAnnouncementFragmentModel) r0;	 Catch:{  }
            r7 = r0.m3921m();	 Catch:{  }
            r8 = r0.m3919k();	 Catch:{  }
            r1 = r9.f2835a;	 Catch:{  }
            r1 = r1.f2845j;	 Catch:{  }
            r1 = r1.containsKey(r7);	 Catch:{  }
            if (r1 == 0) goto L_0x0072;
        L_0x0062:
            r1 = r9.f2835a;	 Catch:{  }
            r1 = r1.f2845j;	 Catch:{  }
            r1 = r1.get(r7);	 Catch:{  }
            r1 = (java.lang.Integer) r1;	 Catch:{  }
            r1 = r1.intValue();	 Catch:{  }
            if (r1 == r8) goto L_0x0085;
        L_0x0072:
            r1 = r9.f2835a;	 Catch:{  }
            r1 = r1.f2845j;	 Catch:{  }
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{  }
            r1.put(r7, r8);	 Catch:{  }
            r1 = 0;
            r0 = com.facebook.facecastdisplay.LiveAnnouncementEventModel.m3126a(r0);	 Catch:{  }
            r5.add(r1, r0);	 Catch:{  }
        L_0x0085:
            r0 = r2 + 1;
            r2 = r0;
            goto L_0x0048;
        L_0x0089:
            r0 = r9.f2835a;	 Catch:{  }
            r0 = r0.f2837b;	 Catch:{  }
            if (r0 == 0) goto L_0x0097;
        L_0x008f:
            r0 = r9.f2835a;	 Catch:{  }
            r0 = r0.f2837b;	 Catch:{  }
            r1 = 0;
            r0.m3267a(r5, r1);	 Catch:{  }
        L_0x0097:
            monitor-exit(r3);	 Catch:{  }
            goto L_0x0017;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.LiveAnnouncementsDownloader.LiveAnnouncementGraphQLCallback.a(java.lang.Object):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void m3133a(java.lang.Throwable r7) {
            /*
            r6 = this;
            r0 = 1;
            r2 = r6.f2835a;
            monitor-enter(r2);
            r1 = r6.f2835a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2847l;	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0014;
        L_0x000a:
            r1 = r6.f2835a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2847l;	 Catch:{ all -> 0x0065 }
            r1 = r1.isCancelled();	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0016;
        L_0x0014:
            monitor-exit(r2);	 Catch:{ all -> 0x0065 }
        L_0x0015:
            return;
        L_0x0016:
            r1 = r6.f2835a;	 Catch:{ all -> 0x0065 }
            r3 = r1.f2844i;	 Catch:{ all -> 0x0065 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r1.<init>();	 Catch:{ all -> 0x0065 }
            r4 = com.facebook.facecastdisplay.LiveAnnouncementsDownloader.f2841f;	 Catch:{ all -> 0x0065 }
            r1 = r1.append(r4);	 Catch:{ all -> 0x0065 }
            r4 = "_graphFailure";
            r1 = r1.append(r4);	 Catch:{ all -> 0x0065 }
            r4 = r1.toString();	 Catch:{ all -> 0x0065 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r5 = "Failed to get announcement events for ";
            r1.<init>(r5);	 Catch:{ all -> 0x0065 }
            r5 = r6.f2835a;	 Catch:{ all -> 0x0065 }
            r5 = r5.f2838c;	 Catch:{ all -> 0x0065 }
            r1 = r1.append(r5);	 Catch:{ all -> 0x0065 }
            r1 = r1.toString();	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0068;
        L_0x0044:
            r1 = r6.f2835a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2838c;	 Catch:{ all -> 0x0065 }
        L_0x0048:
            r3.a(r4, r1, r7);	 Catch:{ all -> 0x0065 }
            r1 = r6.f2835a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2840e;	 Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x006b;
        L_0x0051:
            r1 = r6.f2835a;	 Catch:{ all -> 0x0065 }
            r3 = 1;
            r1.e = r3;	 Catch:{ all -> 0x0065 }
            r1 = r6.f2835a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2837b;	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0063;
        L_0x005c:
            r1 = r6.f2835a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2837b;	 Catch:{ all -> 0x0065 }
            r1.m3272c(r0);	 Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r2);	 Catch:{ all -> 0x0065 }
            goto L_0x0015;
        L_0x0065:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0065 }
            throw r0;
        L_0x0068:
            r1 = "no story id";
            goto L_0x0048;
        L_0x006b:
            r0 = 0;
            goto L_0x0051;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.LiveAnnouncementsDownloader.LiveAnnouncementGraphQLCallback.a(java.lang.Throwable):void");
        }
    }

    @Inject
    public LiveAnnouncementsDownloader(@Assisted ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter, Clock clock) {
        super(clock);
        this.f2842g = executorService;
        this.f2843h = graphQLQueryExecutor;
        this.f2844i = abstractFbErrorReporter;
    }

    public final synchronized void mo119a() {
        if (TextUtils.isEmpty(this.f2838c)) {
            this.f2844i.a(f2841f + "_startFetching", "Tried to fetch without a story id.");
        } else {
            long a = this.f2836a.a() / 1000;
            if (a - this.f2846k >= 10) {
                super.mo119a();
                FetchLiveVideoAnnouncementsQueryString j = FetchLiveVideoEventsQuery.m3496j();
                j.a("targetID", this.f2838c);
                this.f2847l = this.f2843h.a(GraphQLRequest.a(j));
                Futures.a(this.f2847l, new LiveAnnouncementGraphQLCallback(this), this.f2842g);
                this.f2846k = a;
            }
        }
    }

    public final synchronized void mo120b() {
        if (this.f2847l != null) {
            this.f2847l.cancel(false);
            this.f2847l = null;
            this.f2845j.clear();
        }
    }

    public final synchronized boolean mo121c() {
        boolean z;
        z = (this.f2847l == null || this.f2847l.isDone()) ? false : true;
        return z;
    }

    public final LiveEventType mo122d() {
        return LiveEventType.LIVE_ANNOUNCEMENT_EVENT;
    }
}
