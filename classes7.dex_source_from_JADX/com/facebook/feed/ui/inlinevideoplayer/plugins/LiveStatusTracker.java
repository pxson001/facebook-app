package com.facebook.feed.ui.inlinevideoplayer.plugins;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.facecastdisplay.LiveStatusBatchPoller;
import com.facebook.facecastdisplay.LiveStatusBatchPoller.LiveStatusBatchPollerListener;
import com.facebook.facecastdisplay.LiveStatusPoller;
import com.facebook.facecastdisplay.LiveStatusPoller.LiveStatusListener;
import com.facebook.facecastdisplay.protocol.FetchViewerCountAndBroadcastStatusQueryModels.FetchViewerCountAndBroadcastStatusQueryModel;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: The activity must be a subclass of FragmentActivity */
public class LiveStatusTracker implements LiveStatusBatchPollerListener {
    private static final String f22260a = LiveStatusTracker.class.getName();
    private HashMap<String, LiveStatusBundle> f22261b;
    private LiveStatusBatchPoller f22262c;
    private LiveStatusBatchPoller f22263d;
    private Provider<LiveStatusPoller> f22264e;
    private WeakReference<LiveStatusListener> f22265f;

    @VisibleForTesting
    /* compiled from: The activity must be a subclass of FragmentActivity */
    class LiveStatusBundle {
        public String f22254a;
        public GraphQLVideoBroadcastStatus f22255b;
        public int f22256c;
        public WeakReference<LiveStatusListener> f22257d;
        public LiveStatusBatchPoller f22258e;
        final /* synthetic */ LiveStatusTracker f22259f;

        LiveStatusBundle(LiveStatusTracker liveStatusTracker) {
            this.f22259f = liveStatusTracker;
        }
    }

    public static LiveStatusTracker m24895a(InjectorLike injectorLike) {
        return new LiveStatusTracker(IdBasedProvider.a(injectorLike, 1136), IdBasedProvider.a(injectorLike, 1135), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LiveStatusTracker(Provider<LiveStatusPoller> provider, Provider<LiveStatusBatchPoller> provider2, QeAccessor qeAccessor) {
        this.f22264e = provider;
        this.f22263d = (LiveStatusBatchPoller) provider2.get();
        this.f22263d.k = qeAccessor.a(ExperimentsForVideoHomeAbTestModule.w, 5);
        this.f22263d.j = true;
        this.f22263d.h = this;
        this.f22262c = (LiveStatusBatchPoller) provider2.get();
        this.f22262c.j = false;
        this.f22262c.h = this;
        this.f22261b = new HashMap();
        this.f22265f = new WeakReference(null);
    }

    public final void m24902a(Map<String, FetchViewerCountAndBroadcastStatusQueryModel> map) {
        for (Entry entry : map.entrySet()) {
            FetchViewerCountAndBroadcastStatusQueryModel fetchViewerCountAndBroadcastStatusQueryModel = (FetchViewerCountAndBroadcastStatusQueryModel) entry.getValue();
            String str = (String) entry.getKey();
            LiveStatusBundle liveStatusBundle = (LiveStatusBundle) this.f22261b.get(str);
            if (liveStatusBundle != null) {
                LiveStatusListener liveStatusListener = (LiveStatusListener) liveStatusBundle.f22257d.get();
                if (fetchViewerCountAndBroadcastStatusQueryModel == null) {
                    if (liveStatusListener != null) {
                        liveStatusListener.a(str);
                    }
                    m24904b(str);
                } else {
                    int max = Math.max(fetchViewerCountAndBroadcastStatusQueryModel.m4038k(), fetchViewerCountAndBroadcastStatusQueryModel.m4039l());
                    GraphQLVideoBroadcastStatus j = fetchViewerCountAndBroadcastStatusQueryModel.m4037j();
                    Integer.valueOf(max);
                    if (j != null) {
                        String.valueOf(j);
                    }
                    if (liveStatusListener != null) {
                        if (liveStatusBundle.f22256c != max) {
                            liveStatusBundle.f22256c = max;
                            liveStatusListener.r_(max);
                        }
                        if (j != liveStatusBundle.f22255b) {
                            liveStatusBundle.f22255b = j;
                            LiveStatusPoller liveStatusPoller = (LiveStatusPoller) this.f22264e.get();
                            liveStatusPoller.k = true;
                            liveStatusPoller.g = liveStatusListener;
                            liveStatusPoller.h = str;
                            liveStatusPoller.i = -1;
                            liveStatusPoller.l = GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                            LiveStatusPoller.b(liveStatusPoller, true);
                        }
                    }
                }
            }
        }
    }

    public final synchronized void m24900a(String str, GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus, LiveStatusListener liveStatusListener) {
        LiveStatusBundle liveStatusBundle = (LiveStatusBundle) this.f22261b.get(str);
        if (liveStatusBundle == null) {
            liveStatusBundle = new LiveStatusBundle(this);
            liveStatusBundle.f22254a = str;
            this.f22261b.put(str, liveStatusBundle);
        } else if (liveStatusBundle.f22258e != this.f22263d) {
            liveStatusBundle.f22258e.b(str);
            liveStatusBundle.f22258e = null;
        }
        liveStatusBundle.f22255b = graphQLVideoBroadcastStatus;
        liveStatusBundle.f22258e = this.f22263d;
        this.f22263d.a(str);
        liveStatusBundle.f22257d = new WeakReference(liveStatusListener);
    }

    public final synchronized void m24898a(String str) {
        LiveStatusBundle liveStatusBundle = (LiveStatusBundle) this.f22261b.get(str);
        if (liveStatusBundle != null) {
            m24901a(str, true);
            liveStatusBundle.f22257d = this.f22265f;
        }
    }

    public final synchronized void m24899a(String str, GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus) {
        LiveStatusBundle liveStatusBundle = (LiveStatusBundle) this.f22261b.get(str);
        if (liveStatusBundle != null) {
            liveStatusBundle.f22255b = graphQLVideoBroadcastStatus;
        } else {
            liveStatusBundle = new LiveStatusBundle(this);
            liveStatusBundle.f22254a = str;
            this.f22261b.put(str, liveStatusBundle);
            liveStatusBundle.f22255b = graphQLVideoBroadcastStatus;
            liveStatusBundle.f22258e = this.f22263d;
            liveStatusBundle.f22257d = this.f22265f;
            this.f22263d.a(str);
        }
    }

    public final void m24897a(LiveStatusListener liveStatusListener) {
        this.f22265f = new WeakReference(liveStatusListener);
    }

    public final synchronized void m24904b(String str) {
        LiveStatusBundle liveStatusBundle = (LiveStatusBundle) this.f22261b.remove(str);
        if (!(liveStatusBundle == null || liveStatusBundle.f22258e == null)) {
            liveStatusBundle.f22258e.b(str);
        }
    }

    public final synchronized void m24896a() {
        ArrayList arrayList = new ArrayList(this.f22261b.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m24904b((String) arrayList.get(i));
        }
    }

    public final synchronized void m24901a(String str, boolean z) {
        LiveStatusBundle liveStatusBundle = (LiveStatusBundle) this.f22261b.get(str);
        if (liveStatusBundle != null) {
            Object obj = liveStatusBundle.f22258e != this.f22262c ? 1 : null;
            if ((obj == null || !z) && (obj != null || z)) {
                LiveStatusBatchPoller liveStatusBatchPoller = liveStatusBundle.f22258e;
                LiveStatusBatchPoller liveStatusBatchPoller2 = z ? this.f22263d : this.f22262c;
                liveStatusBatchPoller.b(str);
                liveStatusBatchPoller2.a(str);
                liveStatusBundle.f22258e = liveStatusBatchPoller2;
                if (!z) {
                    liveStatusBatchPoller2.a();
                }
            }
        }
    }

    public final synchronized void m24903b() {
        this.f22262c.b();
        this.f22263d.b();
    }

    public final synchronized void m24905c() {
        this.f22262c.a();
        this.f22263d.a();
    }
}
