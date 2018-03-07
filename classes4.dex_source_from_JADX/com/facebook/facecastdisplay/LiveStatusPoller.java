package com.facebook.facecastdisplay;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQuery.FetchVideoBroadcastQueryString;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_tagged_in_checkin */
public class LiveStatusPoller {
    public static final String f4656a = LiveStatusPoller.class.getName();
    public final AbstractFbErrorReporter f4657b;
    private final TasksManager f4658c;
    private final GraphQLQueryExecutor f4659d;
    private final Handler f4660e;
    private final int f4661f;
    @Nullable
    public LiveStatusListener f4662g;
    @Nullable
    public String f4663h;
    public int f4664i = -1;
    public int f4665j = -1;
    public boolean f4666k;
    public GraphQLVideoBroadcastStatus f4667l;
    private final HashMap<String, String> f4668m;
    private final VideoLivePlaybackConfig f4669n;

    /* compiled from: place_tagged_in_checkin */
    public interface LiveStatusListener {
        void mo404a(VideoBroadcastFragmentModel videoBroadcastFragmentModel);

        void mo405a(String str);

        void mo406b(VideoBroadcastFragmentModel videoBroadcastFragmentModel);

        void r_(int i);
    }

    public static LiveStatusPoller m5140b(InjectorLike injectorLike) {
        return new LiveStatusPoller((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), TasksManager.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), VideoLivePlaybackConfig.a(injectorLike));
    }

    @Inject
    public LiveStatusPoller(AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, QeAccessor qeAccessor, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        this.f4657b = abstractFbErrorReporter;
        this.f4658c = tasksManager;
        this.f4659d = graphQLQueryExecutor;
        this.f4660e = new Handler(Looper.getMainLooper());
        this.f4661f = qeAccessor.a(ExperimentsForFacecastDisplayModule.b, 2);
        this.f4667l = GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        this.f4668m = new HashMap();
        this.f4669n = videoLivePlaybackConfig;
    }

    public final void m5145a(String str) {
        this.f4663h = str;
        this.f4664i = -1;
        this.f4667l = GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        m5141b(this, false);
    }

    public final void m5144a() {
        this.f4658c.c(m5142d());
        this.f4660e.removeCallbacksAndMessages(null);
        this.f4667l = GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    private String m5142d() {
        return "liveStatusPoller" + this.f4663h;
    }

    public static void m5141b(LiveStatusPoller liveStatusPoller, boolean z) {
        if (!z) {
            m5143f(liveStatusPoller);
        }
        GraphQlQueryString fetchVideoBroadcastQueryString = new FetchVideoBroadcastQueryString();
        fetchVideoBroadcastQueryString.a("video_id", liveStatusPoller.f4663h);
        fetchVideoBroadcastQueryString.a("enable_read_only_viewer_count", Boolean.valueOf(liveStatusPoller.f4666k));
        if (liveStatusPoller.f4669n.Y) {
            fetchVideoBroadcastQueryString.a("scrubbing", "MPEG_DASH");
        }
        liveStatusPoller.f4658c.a(liveStatusPoller.m5142d(), liveStatusPoller.f4659d.a(GraphQLRequest.a(fetchVideoBroadcastQueryString)), new 1(liveStatusPoller));
    }

    public static void m5143f(LiveStatusPoller liveStatusPoller) {
        Object obj;
        if (liveStatusPoller.f4666k && liveStatusPoller.f4667l == GraphQLVideoBroadcastStatus.LIVE) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            HandlerDetour.b(liveStatusPoller.f4660e, new 2(liveStatusPoller), ((long) liveStatusPoller.f4661f) * 1000, -682485724);
        } else {
            HandlerDetour.b(liveStatusPoller.f4660e, new 3(liveStatusPoller), ((long) liveStatusPoller.f4661f) * 1000, 756864208);
        }
    }

    public final Map<String, String> m5146b() {
        this.f4668m.clear();
        this.f4668m.put("current_viewers", Integer.toString(this.f4664i));
        this.f4668m.put("max_viewers", Integer.toString(this.f4665j));
        return this.f4668m;
    }
}
