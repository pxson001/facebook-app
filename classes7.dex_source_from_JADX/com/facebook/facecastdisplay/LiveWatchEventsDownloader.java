package com.facebook.facecastdisplay;

import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.LiveVideoViewersQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoViewersQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: audio/amr-wb */
public class LiveWatchEventsDownloader extends LiveEventsDownloader {
    public static final String f18990f = LiveWatchEventsDownloader.class.getName();
    private final ExecutorService f18991g;
    private final GraphQLQueryExecutor f18992h;
    public final AbstractFbErrorReporter f18993i;
    private long f18994j;
    @Nullable
    public volatile ListenableFuture<GraphQLResult<LiveVideoViewersQueryModel>> f18995k;

    /* compiled from: audio/amr-wb */
    class LiveWatchEventsGraphlQLCallback extends AbstractDisposableFutureCallback<GraphQLResult<LiveVideoViewersQueryModel>> {
        final /* synthetic */ LiveWatchEventsDownloader f18989a;

        public LiveWatchEventsGraphlQLCallback(LiveWatchEventsDownloader liveWatchEventsDownloader) {
            this.f18989a = liveWatchEventsDownloader;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void m22569a(@javax.annotation.Nullable java.lang.Object r7) {
            /*
            r6 = this;
            r7 = (com.facebook.graphql.executor.GraphQLResult) r7;
            r1 = 1;
            r2 = 0;
            r3 = r6.f18989a;
            monitor-enter(r3);
            r0 = r6.f18989a;	 Catch:{ all -> 0x001d }
            r0 = r0.f18995k;	 Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0017;
        L_0x000d:
            r0 = r6.f18989a;	 Catch:{ all -> 0x001d }
            r0 = r0.f18995k;	 Catch:{ all -> 0x001d }
            r0 = r0.isCancelled();	 Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0019;
        L_0x0017:
            monitor-exit(r3);	 Catch:{ all -> 0x001d }
        L_0x0018:
            return;
        L_0x0019:
            if (r7 != 0) goto L_0x0020;
        L_0x001b:
            monitor-exit(r3);	 Catch:{ all -> 0x001d }
            goto L_0x0018;
        L_0x001d:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x001d }
            throw r0;
        L_0x0020:
            r0 = r7.d();	 Catch:{  }
            r0 = (com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoViewersQueryModel) r0;	 Catch:{  }
            if (r0 != 0) goto L_0x002a;
        L_0x0028:
            monitor-exit(r3);	 Catch:{  }
            goto L_0x0018;
        L_0x002a:
            r0 = r0.m3911j();	 Catch:{  }
            if (r0 != 0) goto L_0x0032;
        L_0x0030:
            monitor-exit(r3);	 Catch:{  }
            goto L_0x0018;
        L_0x0032:
            r0 = r0.m3904j();	 Catch:{  }
            if (r0 != 0) goto L_0x003a;
        L_0x0038:
            monitor-exit(r3);	 Catch:{  }
            goto L_0x0018;
        L_0x003a:
            r4 = new java.util.LinkedList;	 Catch:{  }
            r4.<init>();	 Catch:{  }
            r5 = r6.f18989a;	 Catch:{  }
            r5 = r5.f2840e;	 Catch:{  }
            if (r5 != 0) goto L_0x0064;
        L_0x0045:
            r2 = r6.f18989a;	 Catch:{  }
            r5 = 1;
            r2.e = r5;	 Catch:{  }
            if (r1 == 0) goto L_0x0066;
        L_0x004c:
            r0 = com.facebook.facecastdisplay.LiveWatchEventModel.m22567a(r0);	 Catch:{  }
            if (r0 == 0) goto L_0x0055;
        L_0x0052:
            r4.add(r0);	 Catch:{  }
        L_0x0055:
            r0 = r6.f18989a;	 Catch:{  }
            r0 = r0.f2837b;	 Catch:{  }
            if (r0 == 0) goto L_0x0062;
        L_0x005b:
            r0 = r6.f18989a;	 Catch:{  }
            r0 = r0.f2837b;	 Catch:{  }
            r0.m3267a(r4, r1);	 Catch:{  }
        L_0x0062:
            monitor-exit(r3);	 Catch:{  }
            goto L_0x0018;
        L_0x0064:
            r1 = r2;
            goto L_0x0045;
        L_0x0066:
            r2 = r0.iterator();	 Catch:{  }
        L_0x006a:
            r0 = r2.hasNext();	 Catch:{  }
            if (r0 == 0) goto L_0x0055;
        L_0x0070:
            r0 = r2.next();	 Catch:{  }
            r0 = (com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoViewersCollectionFragmentModel.EdgesModel) r0;	 Catch:{  }
            r0 = com.facebook.facecastdisplay.LiveWatchEventModel.m22566a(r0);	 Catch:{  }
            if (r0 == 0) goto L_0x006a;
        L_0x007c:
            r5 = 0;
            r4.add(r5, r0);	 Catch:{  }
            goto L_0x006a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.LiveWatchEventsDownloader.LiveWatchEventsGraphlQLCallback.a(java.lang.Object):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void m22570a(java.lang.Throwable r7) {
            /*
            r6 = this;
            r0 = 1;
            r2 = r6.f18989a;
            monitor-enter(r2);
            r1 = r6.f18989a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f18995k;	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0014;
        L_0x000a:
            r1 = r6.f18989a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f18995k;	 Catch:{ all -> 0x0065 }
            r1 = r1.isCancelled();	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0016;
        L_0x0014:
            monitor-exit(r2);	 Catch:{ all -> 0x0065 }
        L_0x0015:
            return;
        L_0x0016:
            r1 = r6.f18989a;	 Catch:{ all -> 0x0065 }
            r3 = r1.f18993i;	 Catch:{ all -> 0x0065 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r1.<init>();	 Catch:{ all -> 0x0065 }
            r4 = com.facebook.facecastdisplay.LiveWatchEventsDownloader.f18990f;	 Catch:{ all -> 0x0065 }
            r1 = r1.append(r4);	 Catch:{ all -> 0x0065 }
            r4 = "_graphFailure";
            r1 = r1.append(r4);	 Catch:{ all -> 0x0065 }
            r4 = r1.toString();	 Catch:{ all -> 0x0065 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r5 = "Failed to get watch events for ";
            r1.<init>(r5);	 Catch:{ all -> 0x0065 }
            r5 = r6.f18989a;	 Catch:{ all -> 0x0065 }
            r5 = r5.f2838c;	 Catch:{ all -> 0x0065 }
            r1 = r1.append(r5);	 Catch:{ all -> 0x0065 }
            r1 = r1.toString();	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0068;
        L_0x0044:
            r1 = r6.f18989a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2838c;	 Catch:{ all -> 0x0065 }
        L_0x0048:
            r3.a(r4, r1, r7);	 Catch:{ all -> 0x0065 }
            r1 = r6.f18989a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2840e;	 Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x006b;
        L_0x0051:
            r1 = r6.f18989a;	 Catch:{ all -> 0x0065 }
            r3 = 1;
            r1.e = r3;	 Catch:{ all -> 0x0065 }
            r1 = r6.f18989a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2837b;	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0063;
        L_0x005c:
            r1 = r6.f18989a;	 Catch:{ all -> 0x0065 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.LiveWatchEventsDownloader.LiveWatchEventsGraphlQLCallback.a(java.lang.Throwable):void");
        }
    }

    @Inject
    public LiveWatchEventsDownloader(@Assisted ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter, Clock clock) {
        super(clock);
        this.f18991g = executorService;
        this.f18992h = graphQLQueryExecutor;
        this.f18993i = abstractFbErrorReporter;
    }

    public final synchronized void mo125a(String str) {
        super.mo125a(str);
    }

    public final synchronized void mo119a() {
        super.mo119a();
        if (TextUtils.isEmpty(this.f2838c)) {
            this.f18993i.a(f18990f + "_startFetching", "Tried to fetch without a story id.");
        } else {
            Number valueOf = Long.valueOf(this.f2836a.a() / 1000);
            if (!this.f2840e) {
                this.f18994j = valueOf.longValue() - 900;
            }
            LiveVideoViewersQueryString f = FetchLiveVideoEventsQuery.m3493f();
            f.a("targetID", this.f2838c);
            f.a("after_timestamp", Long.valueOf(this.f18994j));
            f.a("before_timestamp", valueOf);
            this.f18995k = this.f18992h.a(GraphQLRequest.a(f));
            Futures.a(this.f18995k, new LiveWatchEventsGraphlQLCallback(this), this.f18991g);
            this.f18994j = valueOf.longValue() + 1;
        }
    }

    public final synchronized void mo120b() {
        if (this.f18995k != null) {
            this.f18995k.cancel(false);
        }
    }

    public final synchronized boolean mo121c() {
        boolean z;
        z = (this.f18995k == null || this.f18995k.isDone()) ? false : true;
        return z;
    }

    public final LiveEventType mo122d() {
        return LiveEventType.LIVE_WATCH_EVENT;
    }
}
