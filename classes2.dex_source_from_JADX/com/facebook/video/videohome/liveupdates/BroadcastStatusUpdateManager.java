package com.facebook.video.videohome.liveupdates;

import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.facecastdisplay.LiveStatusBatchPoller;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchViewerCountAndBroadcastStatusQueryModels.FetchViewerCountAndBroadcastStatusQueryModel;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.inject.Lazy;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsGraphQLHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: goodfriends/select_audience */
public class BroadcastStatusUpdateManager {
    Runnable f22170a;
    public final LiveStatusBatchPoller f22171b;
    public final Lazy<VideoHomeSubscriptionsGraphQLHelper> f22172c;
    public final Map<String, VideoTracker> f22173d = new HashMap();
    public final PollingQueue f22174e = new PollingQueue(this);
    private final NetworkMonitor f22175f;
    public SelfRegistrableReceiverImpl f22176g;

    /* compiled from: goodfriends/select_audience */
    public class PollingQueue {
        final /* synthetic */ BroadcastStatusUpdateManager f22191a;
        private final Set<String> f22192b = new HashSet();

        public PollingQueue(BroadcastStatusUpdateManager broadcastStatusUpdateManager) {
            this.f22191a = broadcastStatusUpdateManager;
        }

        public final synchronized void m30073a(String str) {
            this.f22192b.add(str);
        }

        public final synchronized void m30074a(Collection<String> collection) {
            this.f22192b.addAll(collection);
        }

        public final synchronized void m30075b(String str) {
            this.f22192b.remove(str);
        }

        public final synchronized void m30072a() {
            if (!this.f22192b.isEmpty()) {
                this.f22191a.f22171b.m30071c();
                for (String a : this.f22192b) {
                    this.f22191a.f22171b.m30068a(a);
                }
                this.f22191a.f22171b.m30067a();
                this.f22192b.clear();
            }
        }
    }

    /* compiled from: goodfriends/select_audience */
    class LiveStatusBatchPollerListener implements com.facebook.facecastdisplay.LiveStatusBatchPoller.LiveStatusBatchPollerListener {
        final /* synthetic */ BroadcastStatusUpdateManager f22193a;

        public LiveStatusBatchPollerListener(BroadcastStatusUpdateManager broadcastStatusUpdateManager) {
            this.f22193a = broadcastStatusUpdateManager;
        }

        public final void mo3240a(Map<String, FetchViewerCountAndBroadcastStatusQueryModel> map) {
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                FetchViewerCountAndBroadcastStatusQueryModel fetchViewerCountAndBroadcastStatusQueryModel = (FetchViewerCountAndBroadcastStatusQueryModel) entry.getValue();
                if (fetchViewerCountAndBroadcastStatusQueryModel == null) {
                    BroadcastStatusUpdateManager.m30060b(this.f22193a, str);
                } else {
                    BroadcastStatusUpdateManager.m30057a(this.f22193a, str, fetchViewerCountAndBroadcastStatusQueryModel.j());
                }
            }
        }
    }

    /* compiled from: goodfriends/select_audience */
    class C08941 implements Runnable {
        final /* synthetic */ BroadcastStatusUpdateManager f22194a;

        C08941(BroadcastStatusUpdateManager broadcastStatusUpdateManager) {
            this.f22194a = broadcastStatusUpdateManager;
        }

        public void run() {
            this.f22194a.f22174e.m30074a(this.f22194a.f22173d.keySet());
            this.f22194a.f22174e.m30072a();
        }
    }

    @Inject
    public BroadcastStatusUpdateManager(Lazy<VideoHomeSubscriptionsGraphQLHelper> lazy, LiveStatusBatchPoller liveStatusBatchPoller, NetworkMonitor networkMonitor) {
        this.f22172c = lazy;
        this.f22171b = liveStatusBatchPoller;
        this.f22171b.f22186j = true;
        this.f22171b.f22187k = 0;
        this.f22171b.f22188l = false;
        this.f22171b.f22184h = new LiveStatusBatchPollerListener(this);
        this.f22175f = networkMonitor;
        m30061d();
    }

    @Nullable
    public final GraphQLVideoBroadcastStatus m30062a(String str) {
        VideoTracker videoTracker = (VideoTracker) this.f22173d.get(str);
        return videoTracker == null ? null : videoTracker.e;
    }

    public final void m30063c() {
        m30061d();
        if (!this.f22173d.isEmpty()) {
            this.f22173d.keySet();
            for (VideoTracker b : this.f22173d.values()) {
                b.b();
            }
        }
        this.f22174e.m30074a(this.f22173d.keySet());
        this.f22174e.m30072a();
    }

    public static void m30057a(BroadcastStatusUpdateManager broadcastStatusUpdateManager, String str, GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus) {
        m30058a(broadcastStatusUpdateManager, str, graphQLVideoBroadcastStatus, null);
    }

    public static void m30058a(BroadcastStatusUpdateManager broadcastStatusUpdateManager, String str, @Nullable GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus, VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        VideoTracker videoTracker = (VideoTracker) broadcastStatusUpdateManager.f22173d.get(str);
        if (!(videoTracker == null || videoTracker.e == graphQLVideoBroadcastStatus)) {
            if (m30059a(graphQLVideoBroadcastStatus)) {
                videoTracker.e = graphQLVideoBroadcastStatus;
            } else {
                videoTracker.a();
                broadcastStatusUpdateManager.f22173d.remove(str);
            }
            videoTracker.a(graphQLVideoBroadcastStatus, videoBroadcastFragmentModel);
        }
        broadcastStatusUpdateManager.f22174e.m30075b(str);
    }

    public static void m30060b(BroadcastStatusUpdateManager broadcastStatusUpdateManager, String str) {
        VideoTracker videoTracker = (VideoTracker) broadcastStatusUpdateManager.f22173d.remove(str);
        if (videoTracker != null) {
            videoTracker.a();
            videoTracker.a(null, null);
        }
        broadcastStatusUpdateManager.f22174e.m30075b(str);
    }

    public static boolean m30059a(GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus) {
        return graphQLVideoBroadcastStatus == GraphQLVideoBroadcastStatus.LIVE || graphQLVideoBroadcastStatus == GraphQLVideoBroadcastStatus.LIVE_STOPPED || graphQLVideoBroadcastStatus == GraphQLVideoBroadcastStatus.SEAL_STARTED;
    }

    private void m30061d() {
        if (this.f22176g == null) {
            if (this.f22170a == null) {
                this.f22170a = new C08941(this);
            }
            this.f22176g = this.f22175f.m13136a(State.CONNECTED, this.f22170a);
        }
    }
}
