package com.facebook.http.executors.liger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.androidinternals.android.os.SystemPropertiesInternal;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.android.LocationManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.carrier.CarrierMonitor;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.hardware.CellDiagnosticsSerializer;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.TriState;
import com.facebook.config.server.String_UserAgentStringMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.common.CachedNetworkInfoCollector;
import com.facebook.http.common.FbHttpParamsUtility;
import com.facebook.http.common.FbRequestState;
import com.facebook.http.config.DefaultNetworkConfig;
import com.facebook.http.config.NetworkConfig;
import com.facebook.http.engine.HttpPushCallback;
import com.facebook.http.engine.HttpRequestExecutor;
import com.facebook.http.engine.STATICDI_MULTIBIND_PROVIDER$HttpPushCallback;
import com.facebook.http.executors.liger.utils.NetworkEventLog;
import com.facebook.http.interfaces.ConnectionPrioritizerTrigger;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.http.observer.RequestContext;
import com.facebook.http.onion.OnionRewriteRule;
import com.facebook.http.onion.OnionRewriter;
import com.facebook.http.onion.OnionRewriter$RuleChangeListener;
import com.facebook.http.onion.TorProxy;
import com.facebook.http.onion.TorProxyMethodAutoProvider;
import com.facebook.http.onion.impl.FbOnionRewriter;
import com.facebook.http.performancelistener.CellTowerInfoHelper;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.http.protocol.HttpWireCallback;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.localstats.LocalStatsListener;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proxygen.AdaptiveIntegerParameters;
import com.facebook.proxygen.AdaptiveIntegerParameters.LatencyBasedParameter;
import com.facebook.proxygen.AdaptiveIntegerParameters.NetworkTypeBasedParameter;
import com.facebook.proxygen.HTTPClient;
import com.facebook.proxygen.HTTPRequestError;
import com.facebook.proxygen.HTTPRequestError.ProxygenError;
import com.facebook.proxygen.HTTPRequestHandler;
import com.facebook.proxygen.HTTPThread;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.proxygen.HttpNetworkException;
import com.facebook.proxygen.JniHandler;
import com.facebook.proxygen.LigerHttpResponseHandler;
import com.facebook.proxygen.LigerSamplePolicy;
import com.facebook.proxygen.NativeReadBuffer;
import com.facebook.proxygen.NetworkStatusMonitor;
import com.facebook.proxygen.PersistentSSLCacheSettings;
import com.facebook.proxygen.PushCallbacks;
import com.facebook.proxygen.ReadBuffer;
import com.facebook.proxygen.RequestStatsObserver;
import com.facebook.proxygen.RewriteRule;
import com.facebook.proxygen.SamplePolicy;
import com.facebook.proxygen.SchedulingParameters;
import com.facebook.proxygen.TraceEventContext;
import com.facebook.proxygen.TraceEventHandler;
import com.facebook.proxygen.TraceEventHandlerFactory;
import com.facebook.proxygen.TraceEventObserver;
import com.facebook.proxygen.ZeroProtocolSettings;
import com.facebook.proxygen.ZeroProtocolSettings.Builder;
import com.facebook.proxygen.utils.BLogWrapper;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ssl.trustmanager.FbTrustManagerFactory;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import com.google.common.base.Preconditions;
import java.io.File;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.AbortableHttpRequest;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.protocol.HttpContext;

@Singleton
/* compiled from: proxygenInfo */
public class LigerRequestExecutor implements HttpRequestExecutor {
    private static volatile LigerRequestExecutor f8672N;
    private static final Class<?> f8673a = LigerRequestExecutor.class;
    private static int f8674b;
    private static boolean f8675c;
    private static int f8676d;
    private static boolean f8677e;
    private static int f8678f = 30;
    private static String f8679g;
    private static boolean f8680h;
    private static String f8681i;
    private static boolean f8682j = false;
    private static int f8683k = 65535;
    private static boolean f8684l = false;
    private static Set<String> f8685m;
    private final FbDataConnectionManager f8686A;
    private final FbSharedPreferences f8687B;
    public HTTPClient f8688C;
    private final AbstractFbErrorReporter f8689D;
    private final TraceEventHandlerFactory f8690E;
    private final DefaultNetworkConfig f8691F;
    private final CellTowerInfoHelper f8692G;
    private final NetworkInfoCollector f8693H;
    private final LigerAnalyticsLogger f8694I;
    private final LocalStatsLoggerImpl f8695J;
    private final int f8696K;
    private final MostRecentHostsStorage f8697L;
    private final GatekeeperStoreImpl f8698M;
    private final Thread f8699n;
    private String f8700o;
    private int f8701p;
    private String f8702q;
    private int f8703r;
    private String f8704s;
    private final String f8705t;
    private final TorProxy f8706u;
    private final BLogWrapper f8707v;
    private final HTTPThread f8708w = new HTTPThread();
    private final QuickExperimentController f8709x;
    private final QeAccessor f8710y;
    private final Context f8711z;

    /* compiled from: proxygenInfo */
    class ThreadPriorityRunnable implements Runnable {
        final /* synthetic */ LigerRequestExecutor f8790a;
        private final Runnable f8791b;

        ThreadPriorityRunnable(LigerRequestExecutor ligerRequestExecutor, Runnable runnable) {
            this.f8790a = ligerRequestExecutor;
            this.f8791b = runnable;
        }

        public void run() {
            Process.setThreadPriority(10);
            this.f8791b.run();
        }
    }

    public static com.facebook.http.executors.liger.LigerRequestExecutor m13493a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8672N;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.executors.liger.LigerRequestExecutor.class;
        monitor-enter(r1);
        r0 = f8672N;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13501b(r0);	 Catch:{ all -> 0x0035 }
        f8672N = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8672N;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.executors.liger.LigerRequestExecutor.a(com.facebook.inject.InjectorLike):com.facebook.http.executors.liger.LigerRequestExecutor");
    }

    private static LigerRequestExecutor m13501b(InjectorLike injectorLike) {
        return new LigerRequestExecutor(String_UserAgentStringMethodAutoProvider.m12347a(injectorLike), NetworkEventLog.m13532a(injectorLike), LigerTraceEventHandlerFactory.m13537a(injectorLike), DefaultNetworkConfig.m12349a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), QuickExperimentControllerImpl.m10166a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FbTrustManagerFactory.m13569a(injectorLike), (Context) injectorLike.getInstance(Context.class), FbDataConnectionManager.m3787a(injectorLike), CellDiagnosticsSerializer.m13578a(injectorLike), LocationManagerMethodAutoProvider.m8261a(injectorLike), IdBasedProvider.m1811a(injectorLike, 694), CachedNetworkInfoCollector.m3227a(injectorLike), CarrierMonitor.m12302a(injectorLike), FbNetworkManager.m3811a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), AppStateManager.m2245a(injectorLike), FbOnionRewriter.m13596a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), TorProxyMethodAutoProvider.m3887a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), LocalStatsLoggerMethodAutoProvider.m13608a(injectorLike), STATICDI_MULTIBIND_PROVIDER$HttpPushCallback.m13630a(injectorLike), MostRecentHostsStorage.m13631a(injectorLike), (LigerForegroundManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LigerForegroundManagerProvider.class));
    }

    @Inject
    @SuppressLint({"BadMethodUse", "ConstructorMayLeakThis", "HardcodedIPAddressUse"})
    public LigerRequestExecutor(String str, NetworkEventLog networkEventLog, TraceEventHandlerFactory traceEventHandlerFactory, NetworkConfig networkConfig, FbErrorReporter fbErrorReporter, QuickExperimentController quickExperimentController, QeAccessor qeAccessor, FbTrustManagerFactory fbTrustManagerFactory, Context context, FbDataConnectionManager fbDataConnectionManager, CellDiagnosticsSerializer cellDiagnosticsSerializer, LocationManager locationManager, Provider<TriState> provider, NetworkInfoCollector networkInfoCollector, CarrierMonitor carrierMonitor, FbNetworkManager fbNetworkManager, FbBroadcastManager fbBroadcastManager, AppStateManager appStateManager, OnionRewriter onionRewriter, AnalyticsLogger analyticsLogger, TorProxy torProxy, FbSharedPreferences fbSharedPreferences, GatekeeperStore gatekeeperStore, LocalStatsLogger localStatsLogger, Set<HttpPushCallback> set, MostRecentHostsStorage mostRecentHostsStorage, LigerForegroundManagerProvider ligerForegroundManagerProvider) {
        try {
            String[] C;
            NetworkStatusMonitor networkStatusMonitor;
            boolean z;
            PushCallbacks pushCallbacks;
            this.f8698M = gatekeeperStore;
            this.f8695J = localStatsLogger;
            this.f8707v = new BLogWrapper(fbErrorReporter);
            this.f8707v.init();
            this.f8711z = context;
            this.f8705t = str;
            this.f8690E = traceEventHandlerFactory;
            this.f8691F = networkConfig;
            this.f8689D = fbErrorReporter;
            this.f8686A = fbDataConnectionManager;
            this.f8709x = quickExperimentController;
            this.f8710y = qeAccessor;
            this.f8693H = networkInfoCollector;
            this.f8706u = torProxy;
            this.f8687B = fbSharedPreferences;
            this.f8699n = ThreadInitDetour.a(new ThreadPriorityRunnable(this, this.f8708w), -1135918827);
            this.f8699n.setPriority(7);
            this.f8699n.start();
            this.f8708w.waitForInitialization();
            this.f8692G = new CellTowerInfoHelper(cellDiagnosticsSerializer, provider, locationManager);
            this.f8697L = mostRecentHostsStorage;
            NetworkEventLog.m13534a(this.f8708w.getEventBase());
            boolean c = networkConfig.m12354c();
            Pair h = m13506h();
            this.f8696K = this.f8710y.mo572a(ExperimentsForHttpQeModule.aC, 10000);
            boolean a = this.f8710y.mo596a(ExperimentsForHttpQeModule.af, false);
            String a2 = this.f8710y.mo581a(ExperimentsForHttpQeModule.ae, "31.13.73.1");
            int a3 = this.f8710y.mo572a(ExperimentsForHttpQeModule.ag, 1000);
            boolean a4 = this.f8710y.mo596a(ExperimentsForHttpQeModule.aa, false);
            String str2 = "";
            if (a4) {
                str2 = this.f8710y.mo585a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2731Z, "");
                if (str2.equals("local")) {
                    C = m13491C();
                    if (C.length > 0) {
                        str2 = C[0].split(":")[0];
                    } else {
                        a4 = false;
                    }
                }
            }
            if (this.f8693H.mo501f()) {
                com.facebook.proxygen.AnalyticsLogger ligerAnalyticsLogger = new LigerAnalyticsLogger(analyticsLogger, fbDataConnectionManager, fbNetworkManager, this.f8693H);
                boolean a5 = this.f8698M.m2189a(1058, false);
                final NetworkStatusMonitor ligerNetworkStatusMonitor = new LigerNetworkStatusMonitor(this.f8711z, this.f8708w.getEventBase(), this.f8693H.mo498c(), this.f8693H.mo499d(), this.f8693H.mo500e(), carrierMonitor, fbNetworkManager, fbBroadcastManager, cellDiagnosticsSerializer, a4, str2, this.f8710y.mo572a(ExperimentsForHttpQeModule.f2730Y, 53), this.f8710y.mo581a(ExperimentsForHttpQeModule.ab, ""), this.f8710y.mo572a(ExperimentsForHttpQeModule.ac, 1000000), this.f8710y.mo572a(ExperimentsForHttpQeModule.ad, 2000), appStateManager, ligerAnalyticsLogger, a5);
                ligerNetworkStatusMonitor.m13655g();
                this.f8693H.mo496a(ligerNetworkStatusMonitor);
                if (a5) {
                    this.f8695J.m13621a(new LocalStatsListener(this) {
                        final /* synthetic */ LigerRequestExecutor f8830b;

                        public final void mo1834a() {
                            LigerRequestExecutor.m13496a(this.f8830b, (Map) ligerNetworkStatusMonitor.getRadioData());
                        }
                    });
                }
                networkStatusMonitor = ligerNetworkStatusMonitor;
            } else {
                networkStatusMonitor = null;
            }
            this.f8694I = new LigerAnalyticsLogger(analyticsLogger, fbDataConnectionManager, fbNetworkManager, this.f8693H);
            double a6 = 1.0d / ((double) this.f8710y.mo572a(ExperimentsForHttpQeModule.aB, 10000));
            List a7 = onionRewriter.m13603a();
            List b = onionRewriter.m13607b();
            RewriteRule[] a8 = m13500a(a7);
            C = (String[]) b.toArray(new String[b.size()]);
            m13492D();
            m13504f();
            m13505g();
            if (f8682j && f8683k == 0) {
                this.f8689D.m2346a("liger_executor_init", new LigerInitializationException("Bad flow control parameters: mFlowControlEnabled = " + f8682j + ", mFlowControlWindow = " + f8683k + ", mSelectedTxnsOnly = " + f8684l));
                f8682j = false;
                f8683k = 65535;
                f8684l = false;
            }
            boolean a9 = this.f8710y.mo596a(ExperimentsForHttpQeModule.aj, false);
            HTTPClient isSandbox = new HTTPClient(this.f8708w.getEventBase()).setZlibFilter(true).setRetryFilter(false).setProxy(this.f8700o, this.f8701p, "", "").setSecureProxy(this.f8702q, this.f8703r, "", "").setBypassProxyDomains(this.f8704s).setProxyFallbackEnabled(true).setPersistentSSLCacheSettings(m13490B()).setIsSandbox(c);
            if (c) {
                z = false;
            } else {
                z = true;
            }
            HTTPClient enableCachingPushManager = isSandbox.setHTTPSEnforced(z).setHTTPSessionCacheType("adv").setBackupConnTimeout(m13514p()).setMaxIdleHTTPSessions(m13510l()).setMaxIdleSPDYSessions(m13511m()).setMaxIdleHTTPSessions2G(m13512n()).setMaxIdleSPDYSessions2G(m13513o()).setIdleTimeoutForUsed(55000).setIdleTimeoutForUnused(55000).setPerDomainLimitEnabled(m13515q()).setDynamicLimitRatio(m13516r()).setMaxConnectionRetryCount(m13518t()).setPerDomainLimitEnabled2G(m13517s()).setMaxConnectionRetryCount2G(m13519u()).setPreConnects(m13521w()).setActiveDomains(m13522x()).setMinDomainRefereshInterval(m13523y()).setRequestSchedulingEnabled(false, new SchedulingParameters(0, 0, 0)).setPersistentDNSCacheSettings(m13489A()).setNewConnectionTimeoutMillis(30000).setTransactionIdleTimeoutMillis(60000).setSessionWriteTimeoutMillis(60000).setDNSCacheEnabled(this.f8710y.mo596a(ExperimentsForHttpQeModule.aV, true)).setCAresEnabled(this.f8710y.mo593a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.aW, false)).setDnsRequestsOutstanding(this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.aX, 1)).setCircularLogSinkEnabled(this.f8710y.mo596a(ExperimentsForHttpQeModule.az, true)).setNetworkStatusMonitor(networkStatusMonitor).setSendPingForTcpRetransmission(this.f8710y.mo596a(ExperimentsForHttpQeModule.aF, false)).setPingTimeout(this.f8710y.mo572a(ExperimentsForHttpQeModule.aI, 100)).setMaxPingRetries(this.f8710y.mo572a(ExperimentsForHttpQeModule.aG, 3)).setPingRttThreshold(this.f8710y.mo572a(ExperimentsForHttpQeModule.aH, 150)).setAdaptivePing(this.f8710y.mo596a(ExperimentsForHttpQeModule.aD, false)).setRewriteRules(a8).setRewriteExemptions(C).setSocketBufferExperimentEnabled(f8675c, f8676d).setAnalyticsLogger(this.f8694I, a6).setHTTP2Enabled(this.f8698M.m2189a(884, true)).setTransportCallbackEnabled(true).setGatewayPingEnabled(a).setGatewayPingAddress(a2).setGatewayPingIntervalMs(a3).setCrossDomainTCPConnsEnabled(((Boolean) h.first).booleanValue()).setUpdateDNSAfterTCPReuse(((Boolean) h.second).booleanValue()).setAdaptiveConfigInterval(this.f8693H.mo500e()).setAdaptiveConnTOParam(m13507i()).setAdaptiveSessionTOParam(m13508j()).setZeroProtocolSettings(m13524z()).setFlowControl(f8682j, f8683k, f8684l).setMaxPriorityLevelForSession(f8674b).setUseRequestWeight(f8677e).setAllowGradientWeight(f8680h).setGradientWeights(f8681i).setEnableCachingPushManager(a9);
            if (set.isEmpty()) {
                pushCallbacks = null;
            } else {
                pushCallbacks = new PushCallbackAdaptor(set);
            }
            this.f8688C = enableCachingPushManager.setPushCallbacks(pushCallbacks).setLoadBalancing(m13520v());
            if (BuildConstants.e() && this.f8687B.mo286a(InternalHttpPrefKeys.f2516k, false)) {
                this.f8688C.setUserInstalledCertificates(fbTrustManagerFactory.m13575b());
            }
            final FbOnionRewriter fbOnionRewriter = onionRewriter;
            onionRewriter.m13606a(new OnionRewriter$RuleChangeListener(this) {
                final /* synthetic */ LigerRequestExecutor f8833b;

                public final void mo1836e() {
                    LigerRequestExecutor ligerRequestExecutor = this.f8833b;
                    ligerRequestExecutor.f8688C.updateUrlRewriteRules(LigerRequestExecutor.m13500a(fbOnionRewriter.m13603a()));
                }
            });
            this.f8688C.init();
            NetworkEventLog.m13533a();
            ligerForegroundManagerProvider.m13641a(this.f8688C);
        } catch (Throwable th) {
            LigerInitializationException ligerInitializationException = new LigerInitializationException(th);
        }
    }

    public final HTTPClient m13529d() {
        return this.f8688C;
    }

    public final HttpResponse mo1702a(HttpUriRequest httpUriRequest, FbRequestState fbRequestState, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics) {
        int i = 0;
        URI uri = httpUriRequest.getURI();
        this.f8697L.m13635a(String.format(Locale.US, "%s://%s", new Object[]{uri.getScheme(), uri.getHost()}));
        do {
            i++;
            try {
                return m13502b(httpUriRequest, fbRequestState, httpContext, httpFlowStatistics);
            } catch (HttpNetworkException e) {
                if (!m13499a(httpUriRequest, i, e)) {
                    throw e;
                }
            }
        } while (m13499a(httpUriRequest, i, e));
        throw e;
    }

    private static boolean m13499a(HttpUriRequest httpUriRequest, int i, HttpNetworkException httpNetworkException) {
        if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity();
            if (!(entity == null || entity.isRepeatable())) {
                return false;
            }
        }
        HTTPRequestError hTTPRequestError = httpNetworkException.mError;
        if (hTTPRequestError == null || ProxygenError.StreamUnacknowledged != hTTPRequestError.mErrCode || i > 1) {
            return false;
        }
        return true;
    }

    public final void m13530e() {
        synchronized (this.f8688C) {
            m13492D();
            this.f8688C.setProxy(this.f8700o, this.f8701p, "", "").setSecureProxy(this.f8702q, this.f8703r, "", "").setBypassProxyDomains(this.f8704s).setIsSandbox(this.f8691F.m12354c()).reInitializeIfNeeded();
        }
    }

    private HttpResponse m13502b(HttpUriRequest httpUriRequest, FbRequestState fbRequestState, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics) {
        m13530e();
        String host = httpUriRequest.getURI().getHost();
        if (httpUriRequest.getFirstHeader("Host") == null) {
            httpUriRequest.setHeader("Host", host);
        }
        if (httpUriRequest.getFirstHeader("User-Agent") == null) {
            httpUriRequest.setHeader("User-Agent", this.f8705t);
        }
        if (fbRequestState.m11638b()) {
            FbHttpParamsUtility.m17905a(httpUriRequest, fbRequestState.m11633a());
        }
        HttpUriRequest a = m13494a(httpUriRequest);
        RequestContext a2 = RequestContext.m17674a(httpContext);
        CallerContext d = a2.m17677d();
        if (d != null) {
            FbHttpParamsUtility.m17906b(httpUriRequest, d.m9066a());
        }
        m13497a((HttpRequest) httpUriRequest, a2.m17675a());
        m13503b(httpUriRequest, a2.m17675a());
        SamplePolicy ligerSamplePolicy = new LigerSamplePolicy(this.f8696K, this.f8687B.mo286a(InternalHttpPrefKeys.f2519n, false));
        TraceEventHandler create = this.f8690E.create(host, httpContext, this.f8686A.m3801c(), httpFlowStatistics, ligerSamplePolicy, this.f8692G, this.f8693H);
        ReadBuffer nativeReadBuffer = new NativeReadBuffer();
        nativeReadBuffer.init();
        TraceEventObserver[] traceEventObserverArr = new TraceEventObserver[1];
        RequestStatsObserver requestStatsObserver = new RequestStatsObserver();
        traceEventObserverArr[0] = requestStatsObserver;
        TraceEventContext traceEventContext = new TraceEventContext(traceEventObserverArr, ligerSamplePolicy);
        Object ligerHttpResponseHandler = new LigerHttpResponseHandler(host, nativeReadBuffer, create, this.f8689D, requestStatsObserver, httpFlowStatistics, traceEventContext.getParentID(), a2.m17675a());
        HTTPRequestHandler hTTPRequestHandler = new HTTPRequestHandler();
        HTTPTransportCallback hTTPTransportCallback = null;
        HttpWireCallback b = httpFlowStatistics.m17691b();
        if (b != null) {
            hTTPTransportCallback = new LigerHttpTransportCallback(b);
        }
        this.f8688C.make(new JniHandler(hTTPRequestHandler, ligerHttpResponseHandler, hTTPTransportCallback), nativeReadBuffer, traceEventContext);
        hTTPRequestHandler.executeWithDefragmentation(a);
        if ((httpUriRequest instanceof AbortableHttpRequest) || mo1705c()) {
            ConnectionPrioritizerTrigger ligerConnectionStateChangeTrigger = new LigerConnectionStateChangeTrigger(hTTPRequestHandler);
            if (httpUriRequest instanceof AbortableHttpRequest) {
                ((AbortableHttpRequest) httpUriRequest).setReleaseTrigger(ligerConnectionStateChangeTrigger);
                fbRequestState.f7189e = ligerConnectionStateChangeTrigger;
                if (httpUriRequest.isAborted()) {
                    hTTPRequestHandler.cancel();
                }
            }
            if (mo1705c()) {
                fbRequestState.m11634a(ligerConnectionStateChangeTrigger);
            }
        }
        return ligerHttpResponseHandler.getResponse();
    }

    private void m13504f() {
        int a = this.f8710y.mo572a(ExperimentsForHttpQeModule.bc, 0);
        f8674b = a;
        if (a > 0) {
            f8675c = this.f8710y.mo593a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.be, false);
            f8676d = this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.bd, 0);
            f8680h = this.f8710y.mo593a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.bg, false);
            f8681i = this.f8710y.mo585a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.bi, "");
        }
        f8677e = this.f8710y.mo593a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.bh, false);
        f8678f = this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.ba, 15);
        f8679g = this.f8710y.mo585a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.bb, "");
    }

    private void m13505g() {
        int i = 0;
        boolean a = this.f8710y.mo596a(ExperimentsForHttpQeModule.at, false);
        f8682j = a;
        if (a) {
            f8683k = this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.aw, 65535);
            a = this.f8710y.mo593a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.av, false);
            f8684l = a;
            if (a) {
                String a2 = this.f8710y.mo585a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.au, "");
                if (a2 != null && !a2.isEmpty()) {
                    f8685m = new HashSet();
                    String[] split = a2.split(";");
                    int length = split.length;
                    while (i < length) {
                        f8685m.add(split[i].toLowerCase());
                        i++;
                    }
                }
            }
        }
    }

    private static void m13497a(HttpRequest httpRequest, String str) {
        if (f8677e && str.equalsIgnoreCase(f8679g)) {
            int i = f8678f;
            Preconditions.checkNotNull(httpRequest);
            httpRequest.getParams().setIntParameter("http2_weight", i);
        }
    }

    private void m13503b(HttpRequest httpRequest, String str) {
        if (!f8682j || !f8684l || f8685m == null || !f8685m.contains(str.toLowerCase())) {
            return;
        }
        if (f8683k == 0) {
            this.f8689D.m2346a("liger_executor_init", new LigerInitializationException("Bad flow control parameters: mFlowControlEnabled = " + f8682j + ", mFlowControlWindow = " + f8683k + ", mSelectedTxnsOnly = " + f8684l));
            return;
        }
        int i = f8683k;
        Preconditions.checkNotNull(httpRequest);
        httpRequest.getParams().setIntParameter("flow_control_window", i);
    }

    private Pair<Boolean, Boolean> m13506h() {
        boolean a = this.f8710y.mo593a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2753v, false);
        boolean a2 = this.f8710y.mo593a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2706A, false);
        if (a && a2) {
            return Pair.create(Boolean.valueOf(true), Boolean.valueOf(false));
        }
        return Pair.create(Boolean.valueOf(this.f8710y.mo596a(ExperimentsForHttpQeModule.aJ, false)), Boolean.valueOf(this.f8710y.mo596a(ExperimentsForHttpQeModule.aK, false)));
    }

    private AdaptiveIntegerParameters m13507i() {
        CharSequence a = this.f8710y.mo581a(ExperimentsForHttpQeModule.f2732a, "disabled");
        Integer valueOf = Integer.valueOf(this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2733b, 30));
        if (TextUtils.equals(a, "latency_based")) {
            return new AdaptiveIntegerParameters(new LatencyBasedParameter(this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2734c, 30), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2738g, 30), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2739h, 30), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2740i, 30), valueOf.intValue()));
        }
        if (TextUtils.equals(a, "network_type_based")) {
            return new AdaptiveIntegerParameters(new NetworkTypeBasedParameter(this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2741j, 30), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2737f, 30), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2736e, 30), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2735d, 30), valueOf.intValue()));
        }
        return null;
    }

    private AdaptiveIntegerParameters m13508j() {
        CharSequence a = this.f8710y.mo581a(ExperimentsForHttpQeModule.f2742k, "disabled");
        Integer valueOf = Integer.valueOf(this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2743l, 60));
        if (TextUtils.equals(a, "latency_based")) {
            return new AdaptiveIntegerParameters(new LatencyBasedParameter(this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2744m, 60), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2748q, 60), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2749r, 60), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2750s, 60), valueOf.intValue()));
        }
        if (TextUtils.equals(a, "network_type_based")) {
            return new AdaptiveIntegerParameters(new NetworkTypeBasedParameter(this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2751t, 60), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2747p, 60), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2746o, 60), this.f8710y.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForHttpQeModule.f2745n, 60), valueOf.intValue()));
        }
        return null;
    }

    private boolean m13509k() {
        return this.f8710y.mo596a(ExperimentsForHttpQeModule.f2755x, false) && this.f8710y.mo596a(ExperimentsForHttpQeModule.f2707B, false);
    }

    private int m13510l() {
        return m13509k() ? 1 : this.f8710y.mo572a(ExperimentsForHttpQeModule.f2718M, 6);
    }

    private int m13511m() {
        return m13509k() ? 1 : this.f8710y.mo572a(ExperimentsForHttpQeModule.f2720O, 2);
    }

    private int m13512n() {
        return m13509k() ? 1 : this.f8710y.mo572a(ExperimentsForHttpQeModule.f2719N, 6);
    }

    private int m13513o() {
        return m13509k() ? 1 : this.f8710y.mo572a(ExperimentsForHttpQeModule.f2721P, 2);
    }

    private int m13514p() {
        return this.f8710y.mo572a(ExperimentsForHttpQeModule.f2713H, 0);
    }

    private boolean m13515q() {
        return m13509k() ? true : this.f8710y.mo596a(ExperimentsForHttpQeModule.f2723R, false);
    }

    private int m13516r() {
        return this.f8710y.mo572a(ExperimentsForHttpQeModule.f2714I, 0);
    }

    private boolean m13517s() {
        return m13509k() ? true : this.f8710y.mo596a(ExperimentsForHttpQeModule.f2724S, false);
    }

    private int m13518t() {
        return this.f8710y.mo572a(ExperimentsForHttpQeModule.f2716K, 0);
    }

    private int m13519u() {
        return this.f8710y.mo572a(ExperimentsForHttpQeModule.f2717L, 0);
    }

    private boolean m13520v() {
        return this.f8710y.mo596a(ExperimentsForHttpQeModule.f2715J, false);
    }

    private String[] m13521w() {
        return this.f8710y.mo581a(ExperimentsForHttpQeModule.f2725T, "").split(",");
    }

    private String[] m13522x() {
        return this.f8710y.mo581a(ExperimentsForHttpQeModule.f2712G, "").split(",");
    }

    private int m13523y() {
        return this.f8710y.mo572a(ExperimentsForHttpQeModule.f2722Q, 0);
    }

    private ZeroProtocolSettings m13524z() {
        String[] split = this.f8710y.mo581a(ExperimentsForHttpQeModule.bl, "").split(":");
        Builder builder = new Builder();
        builder.enabled = this.f8710y.mo596a(ExperimentsForHttpQeModule.bm, false);
        builder = builder;
        builder.enforceExpiration = this.f8710y.mo596a(ExperimentsForHttpQeModule.bn, true);
        builder = builder;
        builder.aeads = split;
        Builder builder2 = builder;
        builder2.hostnamePolicy = this.f8710y.mo581a(ExperimentsForHttpQeModule.bo, "");
        builder2 = builder2;
        builder2.zeroRttEnabled = this.f8710y.mo596a(ExperimentsForHttpQeModule.br, true);
        builder2 = builder2;
        builder2.retryEnabled = this.f8710y.mo596a(ExperimentsForHttpQeModule.bq, false);
        builder2 = builder2;
        if (this.f8710y.mo596a(ExperimentsForHttpQeModule.bp, false)) {
            File file = new File(this.f8711z.getFilesDir(), "fbzeroscfg.store");
            builder2.persistentCacheEnabled = true;
            Builder builder3 = builder2;
            PersistentSSLCacheSettings.Builder builder4 = new PersistentSSLCacheSettings.Builder(file.toString());
            builder4.cacheCapacity = 30;
            PersistentSSLCacheSettings.Builder builder5 = builder4;
            builder5.syncInterval = 150;
            builder3.cacheSettings = builder5.build();
        }
        return new ZeroProtocolSettings(builder2.enabled, builder2.enforceExpiration, builder2.zeroRttEnabled, builder2.persistentCacheEnabled, builder2.cacheSettings, builder2.aeads, builder2.hostnamePolicy, builder2.retryEnabled);
    }

    private PersistentSSLCacheSettings m13489A() {
        PersistentSSLCacheSettings.Builder builder = new PersistentSSLCacheSettings.Builder(new File(this.f8711z.getFilesDir(), "fbdns.store").toString());
        builder.cacheCapacity = 200;
        PersistentSSLCacheSettings.Builder builder2 = builder;
        builder2.syncInterval = 150;
        return builder2.build();
    }

    private PersistentSSLCacheSettings m13490B() {
        PersistentSSLCacheSettings.Builder builder = new PersistentSSLCacheSettings.Builder(new File(this.f8711z.getFilesDir(), "fbtlsx.store").toString());
        builder.cacheCapacity = 50;
        PersistentSSLCacheSettings.Builder builder2 = builder;
        builder2.syncInterval = 150;
        builder2 = builder2;
        builder2.enableCrossDomainTickets = true;
        return builder2.build();
    }

    private HttpUriRequest m13494a(HttpUriRequest httpUriRequest) {
        try {
            HttpUriRequest entityEnclosingRequestWrapper;
            if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
                HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpUriRequest;
                HttpEntity entity = httpEntityEnclosingRequest.getEntity();
                if (entity != null) {
                    m13498a(httpUriRequest, entity);
                }
                entityEnclosingRequestWrapper = new EntityEnclosingRequestWrapper(httpEntityEnclosingRequest);
            } else {
                entityEnclosingRequestWrapper = new RequestWrapper(httpUriRequest);
            }
            entityEnclosingRequestWrapper.resetHeaders();
            return entityEnclosingRequestWrapper;
        } catch (Throwable e) {
            throw new ClientProtocolException(e);
        }
    }

    private static void m13498a(HttpUriRequest httpUriRequest, HttpEntity httpEntity) {
        if (httpEntity.isChunked() || httpEntity.getContentLength() < 0) {
            httpUriRequest.setHeader("Transfer-Encoding", "chunked");
        } else {
            httpUriRequest.setHeader("Content-Length", String.valueOf((int) httpEntity.getContentLength()));
        }
        if (httpEntity.getContentEncoding() != null) {
            httpUriRequest.setHeader(httpEntity.getContentEncoding());
        }
        if (httpEntity.getContentType() != null) {
            httpUriRequest.setHeader(httpEntity.getContentType());
        }
    }

    private static String[] m13491C() {
        int i = 0;
        String[] strArr = new String[0];
        String a = SystemPropertiesInternal.a("net.dns1");
        String a2 = SystemPropertiesInternal.a("net.dns2");
        if (a != null && a2 != null) {
            strArr = new String[]{a, a2};
        } else if (a != null) {
            strArr = new String[]{a};
        } else if (a2 != null) {
            strArr = new String[]{a2};
        }
        while (i < strArr.length) {
            strArr[i] = strArr[i] + ":53";
            i++;
        }
        return strArr;
    }

    public static void m13496a(LigerRequestExecutor ligerRequestExecutor, Map map) {
        if (map != null && !map.isEmpty()) {
            ligerRequestExecutor.m13495a(7208969, (String) map.get("transfer_data_size"));
            ligerRequestExecutor.m13495a(7208971, (String) map.get("full_power_time"));
            ligerRequestExecutor.m13495a(7208970, (String) map.get("low_power_time"));
            ligerRequestExecutor.m13495a(7208973, (String) map.get("total_up_bytes"));
            ligerRequestExecutor.m13495a(7208974, (String) map.get("total_down_bytes"));
            ligerRequestExecutor.m13495a(7208975, (String) map.get("total_request_count"));
            ligerRequestExecutor.m13495a(7208976, (String) map.get("total_wakeup_count"));
            ligerRequestExecutor.f8695J.m13618a(7208972, (String) map.get("aggr_data_details"));
        }
    }

    private void m13495a(int i, String str) {
        try {
            this.f8695J.m13617a(i, Long.parseLong(str));
        } catch (Throwable e) {
            BLog.b(f8673a, e, "Invalid long value: %s for key: %s", new Object[]{str, Integer.valueOf(i)});
        }
    }

    private void m13492D() {
        int i = 1;
        HttpHost a = this.f8691F.m12353a();
        if (a != null) {
            this.f8700o = a.getHostName();
            this.f8701p = a.getPort();
            this.f8702q = a.getHostName();
            this.f8703r = a.getPort();
            this.f8704s = "";
            return;
        }
        int i2;
        this.f8700o = System.getProperty("http.proxyHost");
        this.f8702q = System.getProperty("https.proxyHost");
        this.f8704s = System.getProperty("http.nonProxyHosts");
        String property = System.getProperty("http.proxyPort");
        String property2 = System.getProperty("https.proxyPort");
        if (property != null) {
            try {
                this.f8701p = Integer.parseInt(property);
                i2 = (this.f8701p < 0 || this.f8701p >= 65536) ? 0 : 1;
            } catch (NumberFormatException e) {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            this.f8700o = "";
            this.f8701p = 0;
        }
        if (property2 != null) {
            try {
                this.f8703r = Integer.parseInt(property2);
                if (this.f8703r < 0 || this.f8703r >= 65536) {
                    i = 0;
                }
            } catch (NumberFormatException e2) {
                i = 0;
            }
        } else {
            i = 0;
        }
        if (i == 0) {
            this.f8702q = "";
            this.f8703r = 0;
        }
    }

    public static RewriteRule[] m13500a(List<OnionRewriteRule> list) {
        RewriteRule[] rewriteRuleArr = new RewriteRule[list.size()];
        for (int i = 0; i < rewriteRuleArr.length; i++) {
            rewriteRuleArr[i] = new RewriteRule(((OnionRewriteRule) list.get(i)).matcher, ((OnionRewriteRule) list.get(i)).format);
        }
        return rewriteRuleArr;
    }

    public final void mo1703a() {
    }

    public final String mo1704b() {
        return "Liger";
    }

    public final boolean mo1705c() {
        return f8674b > 0;
    }
}
