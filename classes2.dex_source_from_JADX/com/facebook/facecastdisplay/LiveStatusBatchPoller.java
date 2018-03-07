package com.facebook.facecastdisplay;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.facecastdisplay.protocol.FetchViewerCountAndBroadcastStatusQueryModels.FetchViewerCountAndBroadcastStatusQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: good_friends_feed_enabled */
public class LiveStatusBatchPoller {
    public static final String f22177a = LiveStatusBatchPoller.class.getName();
    public final AbstractFbErrorReporter f22178b;
    private final TasksManager f22179c;
    private final GraphQLQueryExecutor f22180d;
    private final Handler f22181e;
    public final String f22182f;
    private final VideoLivePlaybackConfig f22183g;
    @Nullable
    public LiveStatusBatchPollerListener f22184h;
    private HashSet<String> f22185i;
    public boolean f22186j;
    public int f22187k;
    public boolean f22188l = true;

    /* compiled from: good_friends_feed_enabled */
    public interface LiveStatusBatchPollerListener {
        void mo3240a(Map<String, FetchViewerCountAndBroadcastStatusQueryModel> map);
    }

    public static LiveStatusBatchPoller m30064b(InjectorLike injectorLike) {
        return new LiveStatusBatchPoller(FbErrorReporterImpl.m2317a(injectorLike), TasksManager.m14550b(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), VideoLivePlaybackConfig.m14002a(injectorLike));
    }

    @Inject
    public LiveStatusBatchPoller(AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, QeAccessor qeAccessor, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        this.f22178b = abstractFbErrorReporter;
        this.f22179c = tasksManager;
        this.f22180d = graphQLQueryExecutor;
        this.f22183g = videoLivePlaybackConfig;
        this.f22181e = new Handler(Looper.getMainLooper());
        this.f22187k = qeAccessor.mo572a(ExperimentsForFacecastDisplayModule.f22190b, 2);
        this.f22182f = "LiveStatusBatchPoller" + hashCode();
        this.f22185i = new HashSet();
    }

    public final void m30067a() {
        m30069b();
        HandlerDetour.b(this.f22181e, new 1(this), 10, -447504469);
    }

    public final void m30069b() {
        this.f22179c.m14561c(this.f22182f);
        this.f22181e.removeCallbacksAndMessages(null);
    }

    public final synchronized void m30068a(String str) {
        boolean isEmpty = this.f22185i.isEmpty();
        this.f22185i.add(str);
        if (isEmpty && this.f22188l) {
            m30067a();
        }
    }

    public final synchronized void m30070b(String str) {
        this.f22185i.remove(str);
        if (this.f22185i.isEmpty()) {
            m30069b();
        }
    }

    public final synchronized void m30071c() {
        this.f22185i.clear();
        m30069b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m30065e(com.facebook.facecastdisplay.LiveStatusBatchPoller r4) {
        /*
        r4.m30066f();
        r0 = com.facebook.facecastdisplay.protocol.FetchViewerCountAndBroadcastStatusQuery.a();
        monitor-enter(r4);
        r1 = r4.f22185i;	 Catch:{ all -> 0x0055 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0055 }
        if (r1 == 0) goto L_0x0015;
    L_0x0010:
        r4.m30069b();	 Catch:{ all -> 0x0055 }
        monitor-exit(r4);	 Catch:{ all -> 0x0055 }
    L_0x0014:
        return;
    L_0x0015:
        r1 = "video_ids";
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0055 }
        r3 = r4.f22185i;	 Catch:{ all -> 0x0055 }
        r2.<init>(r3);	 Catch:{ all -> 0x0055 }
        r0.m11316a(r1, r2);	 Catch:{ all -> 0x0055 }
        monitor-exit(r4);	 Catch:{ all -> 0x0055 }
        r1 = "enable_read_only_viewer_count";
        r2 = r4.f22186j;
        r2 = java.lang.Boolean.valueOf(r2);
        r0.m11312a(r1, r2);
        r1 = r4.f22183g;
        r1 = r1.f9121Y;
        if (r1 == 0) goto L_0x003a;
    L_0x0033:
        r1 = "scrubbing";
        r2 = "MPEG_DASH";
        r0.m11315a(r1, r2);
    L_0x003a:
        r0 = com.facebook.graphql.executor.GraphQLRequest.m11587a(r0);
        r1 = r4.f22180d;
        r0 = r1.m10446a(r0);
        r0 = com.facebook.graphql.executor.GraphQLQueryExecutor.m10444c(r0);
        r1 = r4.f22179c;
        r2 = r4.f22182f;
        r3 = new com.facebook.facecastdisplay.LiveStatusBatchPoller$2;
        r3.<init>(r4);
        r1.m14553a(r2, r0, r3);
        goto L_0x0014;
    L_0x0055:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.LiveStatusBatchPoller.e(com.facebook.facecastdisplay.LiveStatusBatchPoller):void");
    }

    private void m30066f() {
        if (this.f22187k > 0) {
            HandlerDetour.b(this.f22181e, new 3(this), ((long) this.f22187k) * 1000, -443800795);
        }
    }
}
