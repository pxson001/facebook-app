package com.facebook.facecastdisplay;

import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.LiveNotableLikedCommentsQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveNotableLikedCommentsQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: audio_fingerprint */
public class LiveLikeEventsDownloader extends LiveEventsDownloader {
    public static final String f18897f = LiveLikeEventsDownloader.class.getName();
    private final ExecutorService f18898g;
    private final GraphQLQueryExecutor f18899h;
    public final AbstractFbErrorReporter f18900i;
    public final String f18901j;
    private long f18902k;
    private boolean f18903l;
    @Nullable
    public volatile ListenableFuture<GraphQLResult<LiveNotableLikedCommentsQueryModel>> f18904m;

    /* compiled from: audio_fingerprint */
    class LiveLikeEventsGraphQLCallback extends AbstractDisposableFutureCallback<GraphQLResult<LiveNotableLikedCommentsQueryModel>> {
        final /* synthetic */ LiveLikeEventsDownloader f18896a;

        public LiveLikeEventsGraphQLCallback(LiveLikeEventsDownloader liveLikeEventsDownloader) {
            this.f18896a = liveLikeEventsDownloader;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void m22502a(@javax.annotation.Nullable java.lang.Object r8) {
            /*
            r7 = this;
            r8 = (com.facebook.graphql.executor.GraphQLResult) r8;
            r1 = 0;
            r2 = r7.f18896a;
            monitor-enter(r2);
            r0 = r7.f18896a;	 Catch:{ all -> 0x001c }
            r0 = r0.f18904m;	 Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0016;
        L_0x000c:
            r0 = r7.f18896a;	 Catch:{ all -> 0x001c }
            r0 = r0.f18904m;	 Catch:{ all -> 0x001c }
            r0 = r0.isCancelled();	 Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0018;
        L_0x0016:
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
        L_0x0017:
            return;
        L_0x0018:
            if (r8 != 0) goto L_0x001f;
        L_0x001a:
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
            goto L_0x0017;
        L_0x001c:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
            throw r0;
        L_0x001f:
            r0 = r8.d();	 Catch:{  }
            r0 = (com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveNotableLikedCommentsQueryModel) r0;	 Catch:{  }
            if (r0 != 0) goto L_0x0029;
        L_0x0027:
            monitor-exit(r2);	 Catch:{  }
            goto L_0x0017;
        L_0x0029:
            r0 = r0.m3849j();	 Catch:{  }
            if (r0 != 0) goto L_0x0031;
        L_0x002f:
            monitor-exit(r2);	 Catch:{  }
            goto L_0x0017;
        L_0x0031:
            r3 = r7.f18896a;	 Catch:{  }
            r4 = 1;
            r3.e = r4;	 Catch:{  }
            r0 = r0.m3840a();	 Catch:{  }
            if (r0 != 0) goto L_0x003e;
        L_0x003c:
            monitor-exit(r2);	 Catch:{  }
            goto L_0x0017;
        L_0x003e:
            r3 = r0.m3836a();	 Catch:{  }
            r4 = new java.util.LinkedList;	 Catch:{  }
            r4.<init>();	 Catch:{  }
            r5 = r3.size();	 Catch:{  }
        L_0x004b:
            if (r1 >= r5) goto L_0x0063;
        L_0x004d:
            r0 = r3.get(r1);	 Catch:{  }
            r0 = (com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveNotableLikedCommentsQueryModel.FeedbackModel.NotableLikedCommentsModel.EdgesModel) r0;	 Catch:{  }
            r6 = r7.f18896a;	 Catch:{  }
            r6 = r6.f18901j;	 Catch:{  }
            r0 = com.facebook.facecastdisplay.LiveLikeEventModel.m22500a(r0, r6);	 Catch:{  }
            r6 = 0;
            r4.add(r6, r0);	 Catch:{  }
            r0 = r1 + 1;
            r1 = r0;
            goto L_0x004b;
        L_0x0063:
            r0 = r7.f18896a;	 Catch:{  }
            r0 = r0.f2837b;	 Catch:{  }
            if (r0 == 0) goto L_0x0071;
        L_0x0069:
            r0 = r7.f18896a;	 Catch:{  }
            r0 = r0.f2837b;	 Catch:{  }
            r1 = 0;
            r0.m3267a(r4, r1);	 Catch:{  }
        L_0x0071:
            monitor-exit(r2);	 Catch:{  }
            goto L_0x0017;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.LiveLikeEventsDownloader.LiveLikeEventsGraphQLCallback.a(java.lang.Object):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void m22503a(java.lang.Throwable r7) {
            /*
            r6 = this;
            r0 = 1;
            r2 = r6.f18896a;
            monitor-enter(r2);
            r1 = r6.f18896a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f18904m;	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0014;
        L_0x000a:
            r1 = r6.f18896a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f18904m;	 Catch:{ all -> 0x0065 }
            r1 = r1.isCancelled();	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0016;
        L_0x0014:
            monitor-exit(r2);	 Catch:{ all -> 0x0065 }
        L_0x0015:
            return;
        L_0x0016:
            r1 = r6.f18896a;	 Catch:{ all -> 0x0065 }
            r3 = r1.f18900i;	 Catch:{ all -> 0x0065 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r1.<init>();	 Catch:{ all -> 0x0065 }
            r4 = com.facebook.facecastdisplay.LiveLikeEventsDownloader.f18897f;	 Catch:{ all -> 0x0065 }
            r1 = r1.append(r4);	 Catch:{ all -> 0x0065 }
            r4 = "_graphFailure";
            r1 = r1.append(r4);	 Catch:{ all -> 0x0065 }
            r4 = r1.toString();	 Catch:{ all -> 0x0065 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r5 = "Failed to get like events for ";
            r1.<init>(r5);	 Catch:{ all -> 0x0065 }
            r5 = r6.f18896a;	 Catch:{ all -> 0x0065 }
            r5 = r5.f2838c;	 Catch:{ all -> 0x0065 }
            r1 = r1.append(r5);	 Catch:{ all -> 0x0065 }
            r1 = r1.toString();	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0068;
        L_0x0044:
            r1 = r6.f18896a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2838c;	 Catch:{ all -> 0x0065 }
        L_0x0048:
            r3.a(r4, r1, r7);	 Catch:{ all -> 0x0065 }
            r1 = r6.f18896a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2840e;	 Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x006b;
        L_0x0051:
            r1 = r6.f18896a;	 Catch:{ all -> 0x0065 }
            r3 = 1;
            r1.e = r3;	 Catch:{ all -> 0x0065 }
            r1 = r6.f18896a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2837b;	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0063;
        L_0x005c:
            r1 = r6.f18896a;	 Catch:{ all -> 0x0065 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.LiveLikeEventsDownloader.LiveLikeEventsGraphQLCallback.a(java.lang.Throwable):void");
        }
    }

    @Inject
    public LiveLikeEventsDownloader(@Assisted ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter, String str, Clock clock) {
        super(clock);
        this.f18898g = executorService;
        this.f18899h = graphQLQueryExecutor;
        this.f18900i = abstractFbErrorReporter;
        this.f18901j = str;
    }

    public final synchronized void mo125a(String str) {
        super.mo125a(str);
        this.f18903l = false;
    }

    public final synchronized void mo119a() {
        super.mo119a();
        if (TextUtils.isEmpty(this.f2838c)) {
            this.f18900i.a(f18897f + "_startFetching", "Tried to fetch without a story id.");
        } else {
            Long valueOf = Long.valueOf(this.f2836a.a() / 1000);
            if (valueOf.longValue() - this.f18902k >= 5) {
                if (!this.f18903l) {
                    this.f18902k = valueOf.longValue() - 5;
                    this.f18903l = true;
                }
                Number valueOf2 = Long.valueOf((this.f18902k + 1) - 5);
                Number valueOf3 = Long.valueOf(valueOf.longValue() - 5);
                LiveNotableLikedCommentsQueryString h = FetchLiveVideoEventsQuery.m3495h();
                h.a("targetID", this.f2838c);
                h.a("after_timestamp", valueOf2);
                h.a("before_timestamp", valueOf3);
                h.a("count", Long.valueOf(2));
                this.f18904m = this.f18899h.a(GraphQLRequest.a(h));
                Futures.a(this.f18904m, new LiveLikeEventsGraphQLCallback(this), this.f18898g);
                this.f18902k = valueOf.longValue();
            }
        }
    }

    public final synchronized void mo120b() {
        if (this.f18904m != null) {
            this.f18904m.cancel(false);
        }
    }

    public final synchronized boolean mo121c() {
        boolean z;
        z = (this.f18904m == null || this.f18904m.isDone()) ? false : true;
        return z;
    }

    public final LiveEventType mo122d() {
        return LiveEventType.LIVE_LIKE_EVENT;
    }
}
