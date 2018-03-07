package com.facebook.video.exoserviceclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.exoplayer.VideoPlayerService;
import com.facebook.exoplayer.ipc.ExoServicePerformanceMetrics;
import com.facebook.exoplayer.ipc.VideoPlayerServiceApi;
import com.facebook.exoplayer.ipc.VideoPlayerServiceApi.Stub;
import com.facebook.exoplayer.ipc.VideoPrefetchRequest;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.exoserviceclient.NonPlayerSessionListener.ServiceListener;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: primary_chat_heads_enabled */
public class ExoServiceClient implements Provider<VideoPlayerServiceApi> {
    public static final String f9166a = ExoServiceClient.class.getName();
    private long f9167b = -6;
    public VideoPlayerServiceApi f9168c = null;
    private final Context f9169d;
    private final long f9170e;
    public final Map<String, String> f9171f;
    private final Set<Listener> f9172g;
    private final MonotonicClock f9173h;
    public final NonPlayerSessionListener f9174i;
    public final boolean f9175j;
    private final Lazy<FbErrorReporter> f9176k;
    private final BaseFbBroadcastManager f9177l;
    private final FbNetworkManager f9178m;
    private final boolean f9179n;
    private SelfRegistrableReceiverImpl f9180o;
    public ConnectionStatus f9181p = ConnectionStatus.UNKNOWN;
    private final Lazy<FbDataConnectionManager> f9182q;
    private final ImmutableMap<ConnectionQuality, Integer> f9183r;
    private final boolean f9184s;
    private final ServiceConnection f9185t = new C04041(this);

    /* compiled from: primary_chat_heads_enabled */
    public interface Listener {
        void mo1910a();

        void mo1911a(VideoPlayerServiceApi videoPlayerServiceApi);
    }

    /* compiled from: primary_chat_heads_enabled */
    public enum ConnectionStatus {
        UNKNOWN,
        NONE,
        WIFI,
        CELL
    }

    /* compiled from: primary_chat_heads_enabled */
    class C04041 implements ServiceConnection {
        final /* synthetic */ ExoServiceClient f9186a;

        C04041(ExoServiceClient exoServiceClient) {
            this.f9186a = exoServiceClient;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                this.f9186a.f9168c = Stub.a(iBinder);
                try {
                    this.f9186a.f9168c.a(this.f9186a.f9171f);
                    ExoServiceClient.m14053k(this.f9186a);
                } catch (Throwable e) {
                    BLog.b(ExoServiceClient.f9166a, "Service RemoteException when setExperimentationConfigs", e);
                }
                try {
                    this.f9186a.f9168c.a(this.f9186a.f9174i);
                } catch (Throwable e2) {
                    BLog.b(ExoServiceClient.f9166a, "Service RemoteException when setExperimentationConfigs", e2);
                }
                ExoServiceClient.m14049b(this.f9186a, true);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f9186a.f9168c = null;
            ExoServiceClient.m14049b(this.f9186a, false);
        }
    }

    public /* synthetic */ Object get() {
        return m14062b();
    }

    private void m14050h() {
        m14056a(null);
    }

    final void m14056a(Bundle bundle) {
        try {
            Intent intent = new Intent(this.f9169d, VideoPlayerService.class);
            intent.putExtra("ExoCacheRootDirectory", this.f9169d.getFilesDir().toString());
            intent.putExtra("ExoCacheSize", this.f9170e);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            ServiceConnectionDetour.a(this.f9169d, intent, this.f9185t, 0, -1624189229);
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f9176k.get()).m2346a(f9166a, e);
        }
    }

    public ExoServiceClient(Context context, long j, Map<String, String> map, MonotonicClock monotonicClock, boolean z, NonPlayerSessionListener nonPlayerSessionListener, Lazy<FbErrorReporter> lazy, FbBroadcastManager fbBroadcastManager, FbNetworkManager fbNetworkManager, boolean z2, Lazy<FbDataConnectionManager> lazy2, Map<ConnectionQuality, Integer> map2, boolean z3) {
        this.f9173h = monotonicClock;
        this.f9169d = context;
        this.f9171f = map;
        this.f9170e = j;
        this.f9172g = new HashSet();
        this.f9174i = nonPlayerSessionListener;
        this.f9175j = z;
        this.f9176k = lazy;
        this.f9177l = fbBroadcastManager;
        this.f9178m = fbNetworkManager;
        this.f9179n = z2;
        this.f9182q = lazy2;
        this.f9183r = new Builder().m608a((Map) map2).m610b();
        this.f9184s = z3;
    }

    public static ConnectionStatus m14051i(ExoServiceClient exoServiceClient) {
        if (exoServiceClient.f9178m.m3828d()) {
            return exoServiceClient.f9178m.m3844v() ? ConnectionStatus.WIFI : ConnectionStatus.CELL;
        } else {
            return ConnectionStatus.NONE;
        }
    }

    private void m14052j() {
        if (this.f9181p == ConnectionStatus.UNKNOWN && this.f9178m != null) {
            this.f9181p = m14051i(this);
        }
        if (this.f9180o == null && this.f9179n) {
            2 2 = new 2(this);
            this.f9180o = this.f9177l.m2951a().mo506a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", 2).mo506a(FbDataConnectionManager.f1876a, new 3(this)).mo503a();
            this.f9180o.m3296b();
        }
    }

    public static void m14053k(ExoServiceClient exoServiceClient) {
        if (exoServiceClient.f9184s) {
            VideoPlayerServiceApi videoPlayerServiceApi = exoServiceClient.f9168c;
            if (videoPlayerServiceApi != null) {
                try {
                    if (((FbDataConnectionManager) exoServiceClient.f9182q.get()) != null) {
                        Integer num = (Integer) exoServiceClient.f9183r.get(((FbDataConnectionManager) exoServiceClient.f9182q.get()).m3801c());
                        if (num != null) {
                            videoPlayerServiceApi.a(num.intValue());
                        }
                    }
                } catch (Throwable e) {
                    BLog.b(f9166a, "Exception occcurs while notifying connectivity change", e);
                }
            }
        }
    }

    public final synchronized void m14054a() {
        m14048b(null);
    }

    private synchronized void m14048b(Bundle bundle) {
        int now;
        TracerDetour.a("VideoPlayerManager.startExoPlayerServiceIfNeeded", -480439738);
        String str;
        try {
            m14052j();
            if (this.f9168c == null) {
                now = this.f9173h.now();
                if (str >= null) {
                    this.f9167b = r0;
                    Intent intent = new Intent(this.f9169d, VideoPlayerService.class);
                    if (bundle != null) {
                        intent.putExtras(bundle);
                    }
                    this.f9169d.startService(intent);
                    m14050h();
                }
            }
            TracerDetour.a(1560061218);
        } catch (Throwable e) {
            Throwable th = e;
            now = (AbstractFbErrorReporter) this.f9176k.get();
            str = f9166a;
            now.m2346a(str, th);
            TracerDetour.a(now);
        } finally {
            TracerDetour.a(29083478);
        }
    }

    public final synchronized VideoPlayerServiceApi m14062b() {
        return this.f9168c;
    }

    public static void m14049b(ExoServiceClient exoServiceClient, boolean z) {
        synchronized (exoServiceClient.f9172g) {
            VideoPlayerServiceApi videoPlayerServiceApi = exoServiceClient.f9168c;
        }
        for (Listener listener : (Listener[]) exoServiceClient.f9172g.toArray(new Listener[0])) {
            if (z) {
                listener.mo1911a(videoPlayerServiceApi);
            } else {
                listener.mo1910a();
            }
        }
    }

    public final void m14057a(Listener listener) {
        synchronized (this.f9172g) {
            this.f9172g.add(listener);
        }
    }

    public final boolean m14061a(VideoPrefetchRequest videoPrefetchRequest) {
        VideoPlayerServiceApi videoPlayerServiceApi = this.f9168c;
        if (videoPlayerServiceApi != null) {
            try {
                return videoPlayerServiceApi.b(videoPrefetchRequest);
            } catch (Throwable e) {
                BLog.b(f9166a, "Exception preconnect in exo service", e);
            }
        }
        return false;
    }

    public final long m14065c() {
        VideoPlayerServiceApi videoPlayerServiceApi = this.f9168c;
        if (videoPlayerServiceApi != null) {
            try {
                return videoPlayerServiceApi.a();
            } catch (Throwable e) {
                BLog.b(f9166a, "Exception getRtmpBandwidthEstimate in exo service", e);
            }
        }
        return -1;
    }

    public final boolean m14064b(VideoPrefetchRequest videoPrefetchRequest) {
        VideoPlayerServiceApi videoPlayerServiceApi = this.f9168c;
        if (videoPlayerServiceApi != null) {
            try {
                return videoPlayerServiceApi.a(videoPrefetchRequest);
            } catch (Throwable e) {
                BLog.b(f9166a, "Exception prefetching in exo service", e);
            }
        }
        return false;
    }

    public final void m14059a(String str) {
        VideoPlayerServiceApi videoPlayerServiceApi = this.f9168c;
        if (videoPlayerServiceApi != null) {
            try {
                videoPlayerServiceApi.b(str);
            } catch (Throwable e) {
                BLog.b(f9166a, "Exception disablePrefetchForOrigin in exo service", e);
            }
        }
    }

    public final void m14063b(String str) {
        VideoPlayerServiceApi videoPlayerServiceApi = this.f9168c;
        if (videoPlayerServiceApi != null) {
            try {
                videoPlayerServiceApi.a(str);
            } catch (Throwable e) {
                BLog.b(f9166a, "Exception enablePrefetchForOrigin in exo service", e);
            }
        }
    }

    public final void m14055a(Uri uri) {
        VideoPlayerServiceApi videoPlayerServiceApi = this.f9168c;
        if (videoPlayerServiceApi != null) {
            try {
                videoPlayerServiceApi.a(uri);
            } catch (Throwable e) {
                BLog.b(f9166a, "Exception setting video server base uri in exo service", e);
            }
        }
    }

    public final void m14060a(boolean z) {
        VideoPlayerServiceApi videoPlayerServiceApi = this.f9168c;
        if (videoPlayerServiceApi != null) {
            try {
                videoPlayerServiceApi.a(z);
            } catch (Throwable e) {
                BLog.b(f9166a, "Exception calling onPlayerActivityStateChange", e);
            }
        }
    }

    public final void m14066d() {
        VideoPlayerServiceApi videoPlayerServiceApi = this.f9168c;
        if (videoPlayerServiceApi != null) {
            try {
                videoPlayerServiceApi.c();
            } catch (Throwable e) {
                BLog.b(f9166a, "Exception occcurs while notifying connectivity change", e);
            }
        }
    }

    public final ExoServicePerformanceMetrics m14067f() {
        ExoServicePerformanceMetrics exoServicePerformanceMetrics = null;
        VideoPlayerServiceApi videoPlayerServiceApi = this.f9168c;
        if (videoPlayerServiceApi != null) {
            try {
                exoServicePerformanceMetrics = videoPlayerServiceApi.b();
            } catch (Throwable e) {
                BLog.b(f9166a, "Exception querying performance metrics in exo service", e);
            }
        }
        return exoServicePerformanceMetrics;
    }

    public final void m14058a(ServiceListener serviceListener) {
        this.f9174i.m14032a(serviceListener);
    }
}
