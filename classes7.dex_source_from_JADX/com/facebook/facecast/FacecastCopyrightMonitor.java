package com.facebook.facecast;

import android.os.Handler;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.facecast.abtest.ExperimentsForFacecastAbtestModule;
import com.facebook.facecast.plugin.FacecastAnalyticsLogger;
import com.facebook.facecast.protocol.FetchBroadcastCopyrightsState.FetchBroadcastCopyrightsStateQueryString;
import com.facebook.facecast.protocol.FetchBroadcastCopyrightsStateModels.FetchBroadcastCopyrightsStateQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: c58e3deeeb1fa8e881a9aac5d2930860 */
public class FacecastCopyrightMonitor {
    public static final String f17994a = FacecastCopyrightMonitor.class.getName();
    public final AbstractFbErrorReporter f17995b;
    private final FacecastAnalyticsLogger f17996c;
    public final ScheduledExecutorService f17997d;
    public final GraphQLQueryExecutor f17998e;
    private final DefaultAndroidThreadUtil f17999f;
    public final Handler f18000g;
    public final Clock f18001h;
    public final String f18002i;
    public final CopyrightStateListener f18003j;
    public final FetchingCallback f18004k = new FetchingCallback(this);
    private final int f18005l;
    private int f18006m;
    private Future<?> f18007n;

    /* compiled from: c58e3deeeb1fa8e881a9aac5d2930860 */
    public interface CopyrightStateListener {
        void mo1384a(CopyrightViolationInfo copyrightViolationInfo);
    }

    /* compiled from: c58e3deeeb1fa8e881a9aac5d2930860 */
    class C15221 implements Runnable {
        ListenableFuture<GraphQLResult<FetchBroadcastCopyrightsStateQueryModel>> f17983a;
        long f17984b;
        boolean f17985c = true;
        final /* synthetic */ FacecastCopyrightMonitor f17986d;

        C15221(FacecastCopyrightMonitor facecastCopyrightMonitor) {
            this.f17986d = facecastCopyrightMonitor;
        }

        public void run() {
            if (this.f17983a == null || this.f17983a.isDone()) {
                GraphQlQueryString fetchBroadcastCopyrightsStateQueryString = new FetchBroadcastCopyrightsStateQueryString();
                fetchBroadcastCopyrightsStateQueryString.a("targetID", this.f17986d.f18002i);
                this.f17983a = this.f17986d.f17998e.a(GraphQLRequest.a(fetchBroadcastCopyrightsStateQueryString));
                Futures.a(this.f17983a, this.f17986d.f18004k, this.f17986d.f17997d);
                this.f17984b = this.f17986d.f18001h.a();
                if (this.f17985c) {
                    FacecastCopyrightMonitor.m21854a(this.f17986d, "copyright_monitor_fetching");
                    this.f17985c = false;
                    return;
                }
                return;
            }
            long a = (this.f17986d.f18001h.a() - this.f17984b) / 1000;
            String str = FacecastCopyrightMonitor.f17994a;
            Long.valueOf(a);
        }
    }

    /* compiled from: c58e3deeeb1fa8e881a9aac5d2930860 */
    public class C15232 implements Runnable {
        final /* synthetic */ List f17987a;
        final /* synthetic */ FacecastCopyrightMonitor f17988b;

        public C15232(FacecastCopyrightMonitor facecastCopyrightMonitor, List list) {
            this.f17988b = facecastCopyrightMonitor;
            this.f17987a = list;
        }

        public void run() {
            FacecastCopyrightMonitor.m21854a(this.f17988b, "copyright_monitor_notify");
            this.f17988b.f18003j.mo1384a(new CopyrightViolationInfo(this.f17987a));
        }
    }

    /* compiled from: c58e3deeeb1fa8e881a9aac5d2930860 */
    public class CopyrightViolationInfo {
        public final String f17989a;
        public final String f17990b;
        public final String f17991c;
        public final String f17992d;

        public CopyrightViolationInfo(List<String> list) {
            this.f17989a = (String) list.get(0);
            this.f17990b = (String) list.get(1);
            this.f17991c = (String) list.get(2);
            this.f17992d = (String) list.get(3);
        }
    }

    /* compiled from: c58e3deeeb1fa8e881a9aac5d2930860 */
    class FetchingCallback implements FutureCallback<GraphQLResult<FetchBroadcastCopyrightsStateQueryModel>> {
        final /* synthetic */ FacecastCopyrightMonitor f17993a;

        public FetchingCallback(FacecastCopyrightMonitor facecastCopyrightMonitor) {
            this.f17993a = facecastCopyrightMonitor;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                FetchBroadcastCopyrightsStateQueryModel fetchBroadcastCopyrightsStateQueryModel = (FetchBroadcastCopyrightsStateQueryModel) graphQLResult.e;
                String a = fetchBroadcastCopyrightsStateQueryModel.m22321a();
                if ("private_broadcast_msg_sent".equals(a) || "public_broadcast_msg_sent".equals(a)) {
                    FacecastCopyrightMonitor.m21854a(this.f17993a, "copyright_monitor_violated");
                    ImmutableList j = fetchBroadcastCopyrightsStateQueryModel.m22322j();
                    if (j == null || j.size() < 4) {
                        this.f17993a.f17995b.a(FacecastCopyrightMonitor.f17994a + "_graphCallback", "Copyright violation texts is not sufficient: " + j);
                        return;
                    }
                    FacecastCopyrightMonitor facecastCopyrightMonitor = this.f17993a;
                    HandlerDetour.a(facecastCopyrightMonitor.f18000g, new C15232(facecastCopyrightMonitor, j), -788846006);
                }
            }
        }

        public void onFailure(Throwable th) {
            this.f17993a.f17995b.a(FacecastCopyrightMonitor.f17994a + "_graphFailure", "Failed to get copyright state for " + this.f17993a.f18002i, th);
        }
    }

    @Inject
    public FacecastCopyrightMonitor(AbstractFbErrorReporter abstractFbErrorReporter, FacecastAnalyticsLogger facecastAnalyticsLogger, ScheduledExecutorService scheduledExecutorService, GraphQLQueryExecutor graphQLQueryExecutor, DefaultAndroidThreadUtil defaultAndroidThreadUtil, Handler handler, Clock clock, QeAccessor qeAccessor, @Assisted String str, @Assisted CopyrightStateListener copyrightStateListener) {
        this.f17995b = abstractFbErrorReporter;
        this.f17996c = facecastAnalyticsLogger;
        this.f17997d = scheduledExecutorService;
        this.f17998e = graphQLQueryExecutor;
        this.f17999f = defaultAndroidThreadUtil;
        this.f18000g = handler;
        this.f18001h = clock;
        this.f18002i = str;
        this.f18003j = (CopyrightStateListener) Preconditions.checkNotNull(copyrightStateListener);
        this.f18006m = qeAccessor.a(ExperimentsForFacecastAbtestModule.f2787h, 30);
        this.f18005l = qeAccessor.a(ExperimentsForFacecastAbtestModule.f2788i, 5);
    }

    public final void m21857a() {
        this.f17999f.a();
        if (m21855e()) {
            BLog.a(f17994a, "The service has already shutdown, it cannot be started any more.");
        } else if (!m21856f()) {
            this.f18007n = this.f17997d.scheduleAtFixedRate(new C15221(this), (long) this.f18006m, (long) this.f18005l, TimeUnit.SECONDS);
            m21854a(this, "copyright_monitor_start");
            this.f18006m = 0;
        }
    }

    public final void m21858b() {
        this.f17999f.a();
        if (m21856f()) {
            this.f18007n.cancel(false);
            this.f18007n = null;
            m21854a(this, "copyright_monitor_suspend");
        }
    }

    public final void m21859c() {
        if (!m21855e()) {
            m21858b();
            this.f17997d.shutdown();
            m21854a(this, "copyright_monitor_stop");
        }
    }

    private boolean m21855e() {
        return this.f17997d.isShutdown();
    }

    private boolean m21856f() {
        return (this.f18007n == null || this.f18007n.isDone()) ? false : true;
    }

    public static void m21854a(FacecastCopyrightMonitor facecastCopyrightMonitor, String str) {
        FacecastAnalyticsLogger facecastAnalyticsLogger = facecastCopyrightMonitor.f17996c;
        Map hashMap = new HashMap();
        hashMap.put("copyright_monitor_state", str);
        facecastAnalyticsLogger.m21965a(hashMap);
    }
}
