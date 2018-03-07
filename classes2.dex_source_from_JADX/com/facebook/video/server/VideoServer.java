package com.facebook.video.server;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.httpserver.GenericHttpServer;
import com.facebook.common.httpserver.JavaSocketHttpServerConnectionFactory;
import com.facebook.common.init.INeedInit;
import com.facebook.debug.log.BLog;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.abtest.ThrottlingConfig;
import com.facebook.video.exoserviceclient.ExoServiceClient;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.protocol.HttpRequestHandlerRegistry;

/* compiled from: isRequestSubmitted */
public class VideoServer implements INeedInit {
    public static final String f19333c = VideoServer.class.getName();
    protected final QeAccessor f19334a;
    protected final LoggedInUserSessionManager f19335b;
    private final AtomicInteger f19336d = new AtomicInteger(0);
    private final ExecutorService f19337e;
    private final HttpRequestHandlerRegistry f19338f = new HttpRequestHandlerRegistry();
    private final InetSocketAddress f19339g = new InetSocketAddress("127.0.0.1", 0);
    private final AbstractFbErrorReporter f19340h;
    private final VideoServerLogger f19341i;
    private final GatekeeperStoreImpl f19342j;
    private final BackgroundWorkLogger f19343k;
    private final Lazy<VideoServerWorker> f19344l;
    private final ExoServiceClient f19345m;
    private final TypedEventBus f19346n;
    public final DelegateBandwidthMeter f19347o;
    private final TimeoutStreamHelper f19348p;
    private GenericHttpServer f19349q;
    private Handler f19350r = new Handler(this);
    @Nullable
    private VideoServerWorker f19351s;

    /* compiled from: isRequestSubmitted */
    public class Handler implements HttpRequestHandler {
        final /* synthetic */ VideoServer f19352a;
        public Uri f19353b;

        public Handler(VideoServer videoServer) {
            this.f19352a = videoServer;
        }

        public final Uri m27019a() {
            return this.f19353b;
        }

        public final void m27020a(Uri uri) {
            this.f19353b = uri;
        }

        public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
            VideoServer.m27005e(this.f19352a).a(httpRequest, httpResponse);
        }
    }

    /* compiled from: isRequestSubmitted */
    class DelegateBandwidthMeter implements BandwidthMeter {
        private BandwidthMeter f19354a;

        public final synchronized void m27023a(BandwidthMeter bandwidthMeter) {
            this.f19354a = bandwidthMeter;
        }

        public final synchronized long m27021a() {
            return this.f19354a == null ? -1 : this.f19354a.a();
        }

        public final void m27024b() {
            throw new UnsupportedOperationException();
        }

        public final void m27022a(int i) {
            throw new UnsupportedOperationException();
        }

        public final void m27025c() {
            throw new UnsupportedOperationException();
        }
    }

    public VideoServer(FbErrorReporter fbErrorReporter, VideoServerListener videoServerListener, GatekeeperStore gatekeeperStore, QeAccessor qeAccessor, BackgroundWorkLogger backgroundWorkLogger, LoggedInUserAuthDataStore loggedInUserAuthDataStore, ExecutorService executorService, Lazy<VideoServerWorker> lazy, TimeoutStreamHelper timeoutStreamHelper, ExoServiceClient exoServiceClient) {
        this.f19340h = (AbstractFbErrorReporter) Preconditions.checkNotNull(fbErrorReporter);
        this.f19341i = (VideoServerLogger) Preconditions.checkNotNull(videoServerListener);
        this.f19342j = gatekeeperStore;
        this.f19334a = (QeAccessor) Preconditions.checkNotNull(qeAccessor);
        this.f19343k = backgroundWorkLogger;
        this.f19335b = loggedInUserAuthDataStore;
        this.f19337e = executorService;
        this.f19344l = lazy;
        this.f19348p = timeoutStreamHelper;
        this.f19338f.register("/cache-thru", this.f19350r);
        this.f19346n = new TypedEventBus();
        this.f19347o = new DelegateBandwidthMeter();
        this.f19345m = exoServiceClient;
    }

    public static synchronized VideoServerWorker m27005e(VideoServer videoServer) {
        VideoServerWorker videoServerWorker;
        synchronized (videoServer) {
            if (videoServer.f19351s == null) {
                videoServer.f19351s = (VideoServerWorker) videoServer.f19344l.get();
                videoServer.f19347o.m27023a(videoServer.f19351s.b());
                videoServer.f19351s.a().m14079a(videoServer.f19346n);
            }
            videoServerWorker = videoServer.f19351s;
        }
        return videoServerWorker;
    }

    public final TypedEventBus m27013a() {
        return this.f19346n;
    }

    public final Uri m27015b() {
        return this.f19350r.f19353b;
    }

    public final synchronized Uri m27011a(Uri uri, String str, boolean z) {
        TracerDetour.a("VideoServerBase.createLocalUriForRemoteUri", 1453042833);
        if (uri == null) {
            try {
                this.f19340h.m2340a(f19333c, "createLocalUri called with null!!");
                TracerDetour.a(1109612926);
                uri = null;
            } catch (Throwable th) {
                TracerDetour.a(1456037151);
            }
        } else if (m27006f()) {
            m27009g();
            Uri a = this.f19350r.m27019a();
            if (a == null) {
                this.f19340h.m2340a(f19333c, "BaseUri returned null!");
                TracerDetour.a(-451222782);
            } else {
                String valueOf = String.valueOf(this.f19336d.getAndIncrement());
                Builder appendQueryParameter = a.buildUpon().appendQueryParameter("remote-uri", uri.toString()).appendQueryParameter("vid", str);
                if (!(z && new ThrottlingConfig(this.f19334a).p)) {
                    appendQueryParameter.appendQueryParameter("sid", valueOf);
                }
                uri = appendQueryParameter.build();
                TracerDetour.a(-62842181);
            }
        } else {
            TracerDetour.a(-394566618);
        }
        return uri;
    }

    private boolean m27006f() {
        return this.f19342j.m2189a(493, false);
    }

    @Deprecated
    public final synchronized Uri m27012a(String str, String str2, boolean z) {
        Uri uri;
        if (Strings.isNullOrEmpty(str)) {
            uri = null;
        } else {
            uri = m27011a(Uri.parse(str), str2, z);
        }
        return uri;
    }

    public static int m26999a(Uri uri) {
        int i = -1;
        if (uri != null && (uri.getHost() == null || "127.0.0.1".equals(uri.getHost()))) {
            String queryParameter = uri.getQueryParameter("sid");
            if (queryParameter != null) {
                try {
                    i = Integer.parseInt(queryParameter);
                } catch (NumberFormatException e) {
                }
            }
        }
        return i;
    }

    public static boolean m27000b(Uri uri) {
        boolean z = false;
        if (uri != null && (uri.getHost() == null || "127.0.0.1".equals(uri.getHost()))) {
            String queryParameter = uri.getQueryParameter("disable-cache");
            if (queryParameter != null) {
                try {
                    z = Boolean.parseBoolean(queryParameter);
                } catch (NumberFormatException e) {
                }
            }
        }
        return z;
    }

    public static boolean m27001c(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (uri.getHost() != null && !"127.0.0.1".equals(uri.getHost())) {
            return false;
        }
        String queryParameter = uri.getQueryParameter("is-live");
        if (queryParameter == null) {
            return false;
        }
        try {
            if (Integer.parseInt(queryParameter) == 1) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private synchronized void m27009g() {
        if (this.f19349q == null) {
            m27010h();
        }
    }

    public static Uri m27002d(Uri uri) {
        String queryParameter = uri.getQueryParameter("remote-uri");
        if (queryParameter == null) {
            return null;
        }
        return Uri.parse(queryParameter);
    }

    public static Uri m27004e(Uri uri) {
        if (uri == null) {
            return null;
        }
        return (uri.getHost() == null || "127.0.0.1".equals(uri.getHost())) ? m27002d(uri) : uri;
    }

    public static boolean m27007f(Uri uri) {
        return (uri == null || uri.getHost() == null || !"127.0.0.1".equals(uri.getHost())) ? false : true;
    }

    public static String m27008g(Uri uri) {
        return uri.getQueryParameter("vid");
    }

    private synchronized void m27010h() {
        this.f19349q = new GenericHttpServer(new JavaSocketHttpServerConnectionFactory(), this.f19338f, this.f19343k, this.f19340h, this.f19337e);
        InetSocketAddress inetSocketAddress = (InetSocketAddress) this.f19349q.a(Collections.singletonList(this.f19339g)).get(0);
        if (inetSocketAddress == null) {
            BLog.b(f19333c, "Cannot bind to port");
        } else {
            int port = inetSocketAddress.getPort();
            this.f19350r.m27020a(new Builder().scheme("http").encodedAuthority("127.0.0.1:" + port).path("/cache-thru").build());
            Integer.valueOf(port);
            this.f19341i.m26998a(port);
            this.f19345m.m14055a(m27015b());
        }
    }

    public synchronized void init() {
        if (this.f19335b.m2522b() && m27006f()) {
            m27009g();
        }
    }

    public final void m27014a(Uri uri, long j, long j2, String str, int i, com.facebook.video.server.AsyncWriter.Handler handler) {
        m27005e(this).a(uri, j, j2, str, i, handler);
    }

    public final BandwidthMeter m27016c() {
        return this.f19347o;
    }

    public final long m27017h(Uri uri) {
        return m27005e(this).a(uri);
    }
}
