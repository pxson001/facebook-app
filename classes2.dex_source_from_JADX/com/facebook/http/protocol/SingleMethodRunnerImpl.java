package com.facebook.http.protocol;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Pair;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontext.DefaultCallerContextHolder;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.PlatformAppConfig;
import com.facebook.config.server.C0307xb160b519;
import com.facebook.config.server.C0308x7c2db9b2;
import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.debug.log.BLog;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.http.FbHttpConnectionPrioritizerTrigger;
import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.FbRequestState;
import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.http.entity.mime.FilePartEntityWithProgressListener;
import com.facebook.http.entity.mime.MultipartEntityWithProgressListener;
import com.facebook.http.entity.mime.UrlEncodingEntityWithProgressListener;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.entity.mime.apache.MultipartEntity;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.http.protocol.ApiMethodRunnerParams.HttpConfig;
import com.facebook.http.protocol.ApiRequest.PostEntityType;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

@Singleton
/* compiled from: requests_submitted */
public class SingleMethodRunnerImpl extends AbstractSingleMethodRunner {
    private static volatile SingleMethodRunnerImpl f7240C;
    private static final ImmutableSet<String> f7241a = ImmutableSet.of(BootstrapRequestName.CONFIRM_CONTACTPOINT_PRECONFIRMATION.requestNameString, BootstrapRequestName.INITIATE_PRECONFIRMATION.requestNameString, BootstrapRequestName.REGISTER_ACCOUNT.requestNameString, BootstrapRequestName.RESET_PASSWORD_PRECONFIRMATION.requestNameString, BootstrapRequestName.VALIDATE_REGISTRATION_DATA.requestNameString, BootstrapRequestName.SYNC_X_CONFIGS.requestNameString, BootstrapRequestName.SESSIONLESS_GK.requestNameString, BootstrapRequestName.GK_INFO.requestNameString, BootstrapRequestName.REGISTER_PUSH.requestNameString, BootstrapRequestName.UNREGISTER_PUSH.requestNameString, BootstrapRequestName.LOGOUT.requestNameString, BootstrapRequestName.AUTHENTICATE.requestNameString, BootstrapRequestName.BOOKMARK_SYNC.requestNameString, BootstrapRequestName.GET_LOGGED_IN_USER_QUERY.requestNameString, BootstrapRequestName.REQUEST_MESSENGER_ONLY_CODE.requestNameString, BootstrapRequestName.CONFIRM_MESSENGER_ONLY_CODE.requestNameString, BootstrapRequestName.LOGIN_MESSENGER_CREDS_BYPASS.requestNameString, BootstrapRequestName.CREATE_MESSENGER_ACCOUNT.requestNameString, BootstrapRequestName.MQTT_CONFIG.requestNameString, BootstrapRequestName.FETCH_ZERO_TOKEN_QUERY.requestNameString, BootstrapRequestName.FETCH_ZERO_MESSAGE_QUOTA_QUERY.requestNameString, BootstrapRequestName.FETCH_ZERO_IP_TEST.requestNameString, BootstrapRequestName.ZERO_IP_TEST_SUBMIT.requestNameString, BootstrapRequestName.SMS_INVITE.requestNameString);
    private final QeAccessor f7242A;
    private ImmutableSet<String> f7243B;
    private final Provider<PlatformAppHttpConfig> f7244b;
    private final PlatformAppHttpConfig f7245c;
    private final PlatformAppHttpConfig f7246d;
    private final Lazy<FbHttpRequestProcessor> f7247e;
    private final Provider<String> f7248f;
    private final Provider<ViewerContext> f7249g;
    private final Provider<Boolean> f7250h;
    private final Provider<Boolean> f7251i;
    private final Provider<Boolean> f7252j;
    private final Provider<Boolean> f7253k;
    private final Provider<Boolean> f7254l;
    private final Provider<Boolean> f7255m;
    private final PlatformAppConfig f7256n;
    private final JsonFactory f7257o;
    private final ObjectMapper f7258p;
    private final ApiResponseChecker f7259q;
    private final ApiRequestUtils f7260r;
    private final PerfTestConfig f7261s;
    private final ApiRequestResultCache f7262t;
    private final BootstrapTierUtil f7263u;
    private final UDPPrimingHelper f7264v;
    private final Clock f7265w;
    private final TimeFormatUtil f7266x;
    private final FbDataConnectionManager f7267y;
    private final LoggedInUserSessionManager f7268z;

    /* compiled from: requests_submitted */
    /* synthetic */ class C03215 {
        static final /* synthetic */ int[] f7571a = new int[HttpConfig.values().length];

        static {
            try {
                f7571a[HttpConfig.PROD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7571a[HttpConfig.BOOTSTRAP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7571a[HttpConfig.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static com.facebook.http.protocol.SingleMethodRunnerImpl m11724a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7240C;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.protocol.SingleMethodRunnerImpl.class;
        monitor-enter(r1);
        r0 = f7240C;	 Catch:{ all -> 0x003a }
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
        r0 = m11735b(r0);	 Catch:{ all -> 0x0035 }
        f7240C = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7240C;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.protocol.SingleMethodRunnerImpl.a(com.facebook.inject.InjectorLike):com.facebook.http.protocol.SingleMethodRunnerImpl");
    }

    private static SingleMethodRunnerImpl m11735b(InjectorLike injectorLike) {
        return new SingleMethodRunnerImpl(IdBasedProvider.m1811a(injectorLike, 2243), C0307xb160b519.m11748a(injectorLike), C0308x7c2db9b2.m11757a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2217), IdBasedProvider.m1811a(injectorLike, 4442), IdBasedProvider.m1811a(injectorLike, 372), IdBasedProvider.m1811a(injectorLike, 4022), IdBasedProvider.m1811a(injectorLike, 4024), IdBasedProvider.m1811a(injectorLike, 4025), IdBasedProvider.m1811a(injectorLike, 4021), IdBasedProvider.m1811a(injectorLike, 3936), IdBasedProvider.m1811a(injectorLike, 4028), (PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class), JsonFactoryMethodAutoProvider.m8062a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), ApiResponseChecker.m11759a(injectorLike), ApiRequestUtils.m11769a(injectorLike), PerfTestConfig.m2936a(injectorLike), ApiRequestResultCache.m11773a(injectorLike), BootstrapTierUtil.m11778a(injectorLike), UDPPrimingHelper.m9443a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), DefaultTimeFormatUtil.m11785a(injectorLike), LoggedInUserSessionManager.m2511a(injectorLike), FbDataConnectionManager.m3787a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    private static void m11731a(HttpUriRequest httpUriRequest, ApiMethodRunnerParams apiMethodRunnerParams) {
        if (apiMethodRunnerParams.f7562g != null) {
            ImmutableList immutableList = apiMethodRunnerParams.f7562g;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                httpUriRequest.addHeader((Header) immutableList.get(i));
            }
        }
    }

    @Inject
    public SingleMethodRunnerImpl(Provider<PlatformAppHttpConfig> provider, PlatformAppHttpConfig platformAppHttpConfig, PlatformAppHttpConfig platformAppHttpConfig2, Lazy<FbHttpRequestProcessor> lazy, Provider<String> provider2, Provider<ViewerContext> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6, Provider<Boolean> provider7, Provider<Boolean> provider8, Provider<Boolean> provider9, PlatformAppConfig platformAppConfig, JsonFactory jsonFactory, ObjectMapper objectMapper, ApiResponseChecker apiResponseChecker, ApiRequestUtils apiRequestUtils, PerfTestConfig perfTestConfig, ApiRequestResultCache apiRequestResultCache, BootstrapTierUtil bootstrapTierUtil, UDPPrimingHelper uDPPrimingHelper, Clock clock, TimeFormatUtil timeFormatUtil, LoggedInUserAuthDataStore loggedInUserAuthDataStore, FbDataConnectionManager fbDataConnectionManager, QeAccessor qeAccessor) {
        this.f7244b = provider;
        this.f7245c = platformAppHttpConfig;
        this.f7246d = platformAppHttpConfig2;
        this.f7247e = lazy;
        this.f7248f = provider2;
        this.f7249g = provider3;
        this.f7250h = provider4;
        this.f7251i = provider5;
        this.f7252j = provider6;
        this.f7253k = provider7;
        this.f7254l = provider8;
        this.f7255m = provider9;
        this.f7256n = platformAppConfig;
        this.f7257o = jsonFactory;
        this.f7258p = objectMapper;
        this.f7259q = apiResponseChecker;
        this.f7260r = apiRequestUtils;
        this.f7261s = perfTestConfig;
        this.f7262t = apiRequestResultCache;
        this.f7263u = bootstrapTierUtil;
        this.f7264v = uDPPrimingHelper;
        this.f7265w = clock;
        this.f7266x = timeFormatUtil;
        this.f7267y = fbDataConnectionManager;
        this.f7268z = loggedInUserAuthDataStore;
        this.f7242A = qeAccessor;
    }

    private static void m11732a(HttpUriRequest httpUriRequest, ApiRequest apiRequest) {
        if (apiRequest.f7500e != null) {
            ImmutableList immutableList = apiRequest.f7500e;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                httpUriRequest.addHeader((Header) immutableList.get(i));
            }
        }
    }

    private HttpEntity m11727a(ApiRequest apiRequest, @Nullable ApiMethodProgressListener apiMethodProgressListener) {
        FilePartDescriptor filePartDescriptor = apiRequest.f7521z;
        int i = filePartDescriptor.c;
        int i2 = filePartDescriptor.b;
        long length = filePartDescriptor.a.length();
        FilePartEntityWithProgressListener filePartEntityWithProgressListener = new FilePartEntityWithProgressListener(filePartDescriptor.a, i2, i);
        if (apiMethodProgressListener != null) {
            filePartEntityWithProgressListener.d = new 2(this, apiMethodProgressListener, i2, length);
        }
        return filePartEntityWithProgressListener;
    }

    protected final <PARAMS, RESULT> RESULT mo1648b(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params, @Nullable ApiMethodRunnerParams apiMethodRunnerParams, @Nullable CallerContext callerContext) {
        CallerContext b = DefaultCallerContextHolder.m11833b(callerContext);
        if (apiMethod instanceof AbstractPersistedGraphQlApiMethod) {
            AbstractPersistedGraphQlApiMethod abstractPersistedGraphQlApiMethod = (AbstractPersistedGraphQlApiMethod) apiMethod;
            ApiRequest d = abstractPersistedGraphQlApiMethod.m10127d(params);
            if (d != null) {
                if (!PerfTestConfigBase.m2942q() || !this.f7262t.m11776a(d)) {
                    return m11725a(abstractPersistedGraphQlApiMethod, d, params, apiMethodRunnerParams, b);
                }
                RESULT b2 = this.f7262t.m11777b(d);
                if (b2 != null) {
                    return b2;
                }
                b2 = m11725a(abstractPersistedGraphQlApiMethod, d, params, apiMethodRunnerParams, b);
                this.f7262t.m11775a(d, b2);
                return b2;
            }
        }
        return m11741a(apiMethod.mo672a(params), apiMethodRunnerParams, apiMethod, m11723a((ApiMethod) apiMethod), params, b).m25142a();
    }

    private <PARAMS, RESULT> RESULT m11725a(GraphQlPersistedApiMethod<PARAMS, RESULT> graphQlPersistedApiMethod, ApiRequest apiRequest, @Nullable PARAMS params, @Nullable ApiMethodRunnerParams apiMethodRunnerParams, @Nullable CallerContext callerContext) {
        ApiResponseAndResult a;
        try {
            a = m11741a(apiRequest, apiMethodRunnerParams, graphQlPersistedApiMethod, m11723a((ApiMethod) graphQlPersistedApiMethod), params, callerContext);
        } catch (GraphQlInvalidQueryIdException e) {
            BLog.c("SingleMethodRunnerImpl", e, "Invalid persisted graphql query id", new Object[0]);
            a = m11741a(graphQlPersistedApiMethod.mo672a(params), apiMethodRunnerParams, graphQlPersistedApiMethod, m11723a((ApiMethod) graphQlPersistedApiMethod), params, callerContext);
        } catch (GraphQlUnpersistableQueryException e2) {
            a = m11741a(graphQlPersistedApiMethod.mo672a(params), apiMethodRunnerParams, graphQlPersistedApiMethod, m11723a((ApiMethod) graphQlPersistedApiMethod), params, callerContext);
        }
        return a.m25142a();
    }

    @VisibleForTesting
    public final <PARAMS, RESULT> ApiResponseAndResult<RESULT> m11741a(ApiRequest apiRequest, @Nullable ApiMethodRunnerParams apiMethodRunnerParams, ApiMethod<PARAMS, RESULT> apiMethod, @Nullable ApiMethodEvents<PARAMS> apiMethodEvents, @Nullable PARAMS params, @Nullable CallerContext callerContext) {
        PlatformAppHttpConfig platformAppHttpConfig;
        Builder c;
        String str;
        HttpUriRequest httpGet;
        CallerContext a = m11720a(callerContext, (ApiMethod) apiMethod, apiRequest);
        if (apiMethodRunnerParams == null) {
            apiMethodRunnerParams = new ApiMethodRunnerParams();
        }
        if (f7241a.contains(apiRequest.m12102a())) {
            this.f7263u.m11782a(apiMethodRunnerParams);
        }
        String f = apiRequest.m12105f();
        switch (C03215.f7571a[apiMethodRunnerParams.m12152b().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                platformAppHttpConfig = this.f7245c;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (!((Boolean) this.f7254l.get()).booleanValue()) {
                    platformAppHttpConfig = this.f7246d;
                    break;
                }
                platformAppHttpConfig = (PlatformAppHttpConfig) this.f7244b.get();
                break;
            default:
                platformAppHttpConfig = (PlatformAppHttpConfig) this.f7244b.get();
                break;
        }
        if (apiRequest.m12113o()) {
            c = platformAppHttpConfig.mo1361c();
        } else if (apiRequest.m12114p()) {
            c = platformAppHttpConfig.mo1362d();
        } else if (apiRequest.m12117s()) {
            c = platformAppHttpConfig.mo1364f();
        } else if (apiRequest.m12118t()) {
            c = platformAppHttpConfig.mo1363e();
        } else if (apiRequest.m12116r()) {
            c = platformAppHttpConfig.mo1365g();
        } else if (f.startsWith("method")) {
            c = platformAppHttpConfig.mo1359a();
        } else {
            c = platformAppHttpConfig.mo1360b();
        }
        c.appendEncodedPath(f);
        if (!m11736b(apiRequest)) {
            if (((Boolean) this.f7250h.get()).booleanValue()) {
                c.appendQueryParameter("phprof_sample", "1");
                str = (String) this.f7248f.get();
                if (str != null) {
                    c.appendQueryParameter("phprof_user", str);
                }
            }
            if (((Boolean) this.f7251i.get()).booleanValue()) {
                c.appendQueryParameter("teak_sample", "1");
                str = (String) this.f7248f.get();
                if (str != null) {
                    c.appendQueryParameter("teak_user", str);
                }
            }
            if (((Boolean) this.f7252j.get()).booleanValue()) {
                c.appendQueryParameter("wirehog_sample", "1");
                str = (String) this.f7248f.get();
                if (str != null) {
                    c.appendQueryParameter("wirehog_user", str);
                }
            }
            if (((Boolean) this.f7253k.get()).booleanValue()) {
                c.appendQueryParameter("artillery_sample", "1");
            }
        }
        PostEntityType v = apiRequest.m12120v();
        if (v == PostEntityType.AUTO) {
            if (apiRequest.m12111m() == null || apiRequest.m12111m().size() <= 0) {
                v = PostEntityType.SINGLE_STRING_ENTITY;
            } else {
                v = PostEntityType.MULTI_PART_ENTITY;
            }
        }
        if ((apiRequest.m12116r() || apiRequest.m12101A()) && "GET".equals(apiRequest.m12104d())) {
            c.encodedQuery(UrlEncodingEntityWithProgressListener.m12187a(this.f7260r.m11771a(apiRequest)));
            httpGet = new HttpGet(c.build().toString());
        } else if (apiRequest.m12114p()) {
            httpGet = m11728a(c.build(), apiRequest, apiMethodRunnerParams.m12145a());
        } else if ("GET".equals(apiRequest.m12104d()) || "POST".equals(apiRequest.m12104d()) || "DELETE".equals(apiRequest.m12104d())) {
            HttpEntity a2;
            HttpUriRequest httpPost = new HttpPost(c.build().toString());
            ParamsCollectionMap a3 = m11721a(apiRequest, apiMethodRunnerParams, a);
            if (v == PostEntityType.SINGLE_STRING_ENTITY) {
                Object obj = (m11740e(apiRequest) && this.f7242A.mo596a(ExperimentsForHttpQeModule.ah, false)) ? 1 : null;
                if (apiRequest.m12109k() && obj == null) {
                    this.f7264v.m9452a(a3);
                    UDPPrimingHelper.m9445a(httpPost);
                }
                if (apiRequest.m12110l()) {
                    this.f7264v.m9451a(c.build());
                }
                a2 = m11726a(apiRequest, a3, apiMethodRunnerParams.m12145a());
            } else {
                a2 = m11734b(apiRequest, a3, apiMethodRunnerParams.m12145a());
            }
            httpPost.setEntity(MethodRunnerUtil.m12191a(a2));
            httpGet = httpPost;
        } else {
            throw new Exception("Unsupported method: " + apiRequest.m12104d());
        }
        if (m11733a(apiRequest)) {
            ViewerContext viewerContext = (ViewerContext) this.f7249g.get();
            str = viewerContext != null ? viewerContext.m1526b() : null;
            if (str != null || m11738c(apiRequest) || m11739d(apiRequest)) {
                httpGet.addHeader("Authorization", "OAuth " + str);
            } else {
                throw new AuthTokenNullException("auth token is null, user logged out?");
            }
        }
        str = apiRequest.m12103b();
        if (str == null) {
            str = platformAppHttpConfig.mo1366h();
        }
        if (str != null) {
            httpGet.addHeader("User-Agent", str);
        }
        if (this.f7242A.mo596a(ExperimentsForHttpQeModule.aj, false) && m11740e(apiRequest)) {
            httpGet.addHeader("X-FB-Image-Push-Requested", "true");
        }
        m11732a(httpGet, apiRequest);
        m11731a(httpGet, apiMethodRunnerParams);
        str = platformAppHttpConfig.mo1367i();
        if (str != null) {
            httpGet.addHeader("X-FB-Connection-Type", str);
        }
        ConnectionQuality c2 = this.f7267y.m3801c();
        if (c2 != null) {
            httpGet.addHeader("X-FB-Connection-Quality", c2.name());
        }
        if (apiMethodRunnerParams.m12155f() != FbTraceNode.f7566a) {
            httpGet.addHeader("X-FBTrace-Sampled", "true");
            httpGet.addHeader("X-FBTrace-Meta", apiMethodRunnerParams.m12155f().m12159a());
        }
        if (apiRequest.m12113o() && apiRequest.m12115q()) {
            httpGet.addHeader("X-FB-Video-Upload-Method", "chunked");
            httpGet.addHeader("X_FB_VIDEO_WATERFALL_ID", apiRequest.m12122z());
        }
        if (((Boolean) this.f7255m.get()).booleanValue()) {
            httpGet.addHeader("Date", this.f7266x.mo1649a(TimeFormatStyle.RFC1123_STYLE, this.f7265w.mo211a()));
        }
        if (apiMethodEvents != null) {
            apiMethodEvents.mo1429b(params);
        }
        HttpRequestAbortHandler c3 = apiMethodRunnerParams.m12153c();
        if (c3 != null) {
            c3.a(httpGet);
        }
        FbHttpRequest a4 = MethodRunnerUtil.m12190a(apiRequest.m12102a(), httpGet, m11722a(apiRequest, apiMethodRunnerParams), apiRequest.m12119u(), new ApiResponseHandler(apiRequest, params, apiMethod, this.f7259q, this.f7257o, this.f7258p), apiMethodRunnerParams, a, apiRequest.m12121w());
        apiRequest.m12106g().m11634a(new FbHttpConnectionPrioritizerTrigger((FbHttpRequestProcessor) this.f7247e.get(), a4));
        try {
            ApiResponseAndResult<RESULT> apiResponseAndResult = (ApiResponseAndResult) ((FbHttpRequestProcessor) this.f7247e.get()).m12267a(a4);
            if (apiMethodEvents != null) {
                apiMethodEvents.mo1434c(params);
            }
            MethodRunnerUtil.m12192a(httpGet);
            if (c3 != null) {
                c3.a(null);
            }
            return apiResponseAndResult;
        } catch (Exception exception) {
            Exception exception2 = IOExecutionExceptionWrapper.b(exception2);
            if (apiMethodEvents != null) {
                apiMethodEvents.mo1427a(params, exception2);
            }
            throw exception2;
        } catch (Throwable th) {
            MethodRunnerUtil.m12192a(httpGet);
            if (c3 != null) {
                c3.a(null);
            }
        }
    }

    private HttpUriRequest m11728a(Uri uri, ApiRequest apiRequest, @Nullable ApiMethodProgressListener apiMethodProgressListener) {
        HttpUriRequest httpGet;
        if ("GET".equals(apiRequest.f7497b)) {
            httpGet = new HttpGet(uri.toString());
        } else if ("POST".equals(apiRequest.f7497b)) {
            HttpPost httpPost = new HttpPost(uri.toString());
            if (apiRequest.f7517v == PostEntityType.FILE_PART_ENTITY) {
                httpPost.setEntity(m11727a(apiRequest, apiMethodProgressListener));
            }
            Object obj = httpPost;
        } else {
            throw new IllegalArgumentException("Unsupported method: " + apiRequest.f7497b);
        }
        ImmutableList h = apiRequest.m12107h();
        int size = h.size();
        for (int i = 0; i < size; i++) {
            NameValuePair nameValuePair = (NameValuePair) h.get(i);
            httpGet.addHeader(nameValuePair.getName(), nameValuePair.getValue());
        }
        return httpGet;
    }

    private static RequestPriority m11722a(ApiRequest apiRequest, ApiMethodRunnerParams apiMethodRunnerParams) {
        FbRequestState g = apiRequest.m12106g();
        RequestPriority requestPriority = apiMethodRunnerParams.f7561f;
        if (requestPriority != null) {
            g.m11635a(requestPriority);
        }
        return g.m11633a();
    }

    @Nullable
    @VisibleForTesting
    private static <PARAMS> ApiMethodEvents<PARAMS> m11723a(ApiMethod<PARAMS, ?> apiMethod) {
        if (apiMethod == null || !(apiMethod instanceof ApiMethodEvents)) {
            return null;
        }
        return (ApiMethodEvents) apiMethod;
    }

    private static CallerContext m11720a(@Nullable CallerContext callerContext, ApiMethod apiMethod, ApiRequest apiRequest) {
        if (callerContext != null) {
            return CallerContext.m9059a(callerContext, apiRequest.f7496a);
        }
        return CallerContext.m9064b(apiMethod.getClass(), apiRequest.f7496a);
    }

    private ParamsCollectionMap m11721a(ApiRequest apiRequest, @Nullable ApiMethodRunnerParams apiMethodRunnerParams, CallerContext callerContext) {
        ParamsCollectionMap a = this.f7260r.m11771a(apiRequest);
        String str = apiRequest.f7498c;
        if (str.startsWith("method/")) {
            a.m5421a("method", str.substring(7));
        } else if ("DELETE".equals(apiRequest.f7497b)) {
            a.m5421a("method", "DELETE");
        } else if ("GET".equals(apiRequest.f7497b)) {
            a.m5421a("method", "GET");
        }
        a.m5421a("fb_api_req_friendly_name", apiRequest.f7496a);
        a.m5421a("fb_api_caller_class", callerContext.f5181b);
        if (m11736b(apiRequest)) {
            m11729a(a);
        }
        str = null;
        if (m11739d(apiRequest) && apiMethodRunnerParams != null && apiMethodRunnerParams.f7565j != null) {
            str = apiMethodRunnerParams.f7565j;
        } else if (m11738c(apiRequest)) {
            str = StringUtil.m3597b("|", this.f7256n.c(), this.f7256n.e());
        }
        if (str != null) {
            a.m5421a("access_token", str);
        }
        return a;
    }

    private HttpEntity m11726a(ApiRequest apiRequest, ParamsCollectionMap paramsCollectionMap, @Nullable ApiMethodProgressListener apiMethodProgressListener) {
        if (apiRequest.m12111m() == null || apiRequest.m12111m().size() <= 0) {
            HttpEntity urlEncodingEntityWithProgressListener = new UrlEncodingEntityWithProgressListener(paramsCollectionMap);
            if (apiMethodProgressListener != null) {
                urlEncodingEntityWithProgressListener.f7614b = new 1(this, apiMethodProgressListener);
            }
            return urlEncodingEntityWithProgressListener;
        }
        throw new IllegalArgumentException("Cannot add attachment to string entities");
    }

    private MultipartEntity m11734b(ApiRequest apiRequest, ParamsCollectionMap paramsCollectionMap, @Nullable ApiMethodProgressListener apiMethodProgressListener) {
        MultipartEntityWithProgressListener multipartEntityWithProgressListener = new MultipartEntityWithProgressListener();
        multipartEntityWithProgressListener.a(paramsCollectionMap);
        List<FormBodyPart> m = apiRequest.m12111m();
        if (!(m == null || m.isEmpty())) {
            for (FormBodyPart formBodyPart : m) {
                multipartEntityWithProgressListener.a(formBodyPart.a, formBodyPart.c);
            }
        }
        if (apiMethodProgressListener != null) {
            long contentLength = multipartEntityWithProgressListener.getContentLength();
            if (contentLength > 0) {
                multipartEntityWithProgressListener.a = new 3(this, apiMethodProgressListener, contentLength);
            }
        }
        return multipartEntityWithProgressListener;
    }

    private void m11729a(ParamsCollectionMap paramsCollectionMap) {
        paramsCollectionMap.m5421a("api_key", this.f7256n.d());
        int[] b = m11737b(paramsCollectionMap);
        Writer stringWriter = new StringWriter();
        try {
            m11730a(stringWriter, paramsCollectionMap, b);
            stringWriter.append(this.f7256n.e());
            paramsCollectionMap.m5421a("sig", SecureHashUtil.b(stringWriter.toString()));
        } catch (IOException e) {
            throw new RuntimeException("StringWriter cannot throw IOException");
        }
    }

    private static void m11730a(Writer writer, ParamsCollectionMap paramsCollectionMap, int[] iArr) {
        for (int i : iArr) {
            writer.write(paramsCollectionMap.m5423b(i));
            writer.write(61);
            Object c = paramsCollectionMap.m5426c(i);
            if (c == null) {
                writer.write("null");
            } else if ((c instanceof String) || (c instanceof Number) || (c instanceof Boolean)) {
                writer.write(c.toString());
            } else if (c instanceof ParamsCollection) {
                ((ParamsCollection) c).m5439a(writer);
            } else {
                throw new IllegalArgumentException("Unsupported value type " + c.getClass());
            }
        }
    }

    private static int[] m11737b(ParamsCollectionMap paramsCollectionMap) {
        int i;
        int i2 = paramsCollectionMap.f3273c;
        int[] iArr = new int[i2];
        Pair[] pairArr = new Pair[i2];
        for (i = 0; i < i2; i++) {
            pairArr[i] = Pair.create(paramsCollectionMap.m5423b(i), Integer.valueOf(i));
        }
        Arrays.sort(pairArr, new 4());
        for (i = 0; i < i2; i++) {
            iArr[i] = ((Integer) pairArr[i].second).intValue();
        }
        return iArr;
    }

    private static boolean m11733a(ApiRequest apiRequest) {
        if (apiRequest.f7512q || apiRequest.f7515t) {
            return false;
        }
        String str = apiRequest.f7498c;
        if ("method/auth.login".equalsIgnoreCase(str) || "method/auth.getSessionForApp".equalsIgnoreCase(str) || "method/user.confirmContactpointPreconfirmation".equalsIgnoreCase(str) || "method/user.initiatePreconfirmation".equalsIgnoreCase(str) || "method/user.register".equalsIgnoreCase(str) || "method/user.prefillorautocompletecontactpoint".equalsIgnoreCase(str) || "method/user.resetPasswordPreconfirmation".equalsIgnoreCase(str) || "method/user.validateregistrationdata".equalsIgnoreCase(str) || "recover_accounts".equalsIgnoreCase(str) || "getSsoUserMethod".equals(apiRequest.f7496a) || "method/auth.extendSSOAccessToken".equalsIgnoreCase(str) || "method/user.sendMessengerOnlyPhoneConfirmationCode".equalsIgnoreCase(str) || "method/user.confirmMessengerOnlyPhone".equalsIgnoreCase(str) || "method/user.createMessengerOnlyAccount".equalsIgnoreCase(str) || "method/user.bypassLoginWithConfirmedMessengerCredentials".equalsIgnoreCase(str) || "method/intl.getLocaleSuggestions".equalsIgnoreCase(str) || "350685531728/nonuserpushtokens".equalsIgnoreCase(str) || "256002347743983/nonuserpushtokens".equalsIgnoreCase(str) || "181425161904154/nonuserpushtokens".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    private static boolean m11736b(ApiRequest apiRequest) {
        if (apiRequest.f7512q || !apiRequest.f7516u) {
            return false;
        }
        if (apiRequest.f7515t) {
            return true;
        }
        String str = apiRequest.f7498c;
        if ("method/auth.login".equalsIgnoreCase(str) || "method/user.confirmContactpointPreconfirmation".equalsIgnoreCase(str) || "method/user.initiatePreconfirmation".equalsIgnoreCase(str) || "method/user.register".equalsIgnoreCase(str) || "method/user.prefillorautocompletecontactpoint".equalsIgnoreCase(str) || "method/user.resetPasswordPreconfirmation".equalsIgnoreCase(str) || "method/user.validateregistrationdata".equalsIgnoreCase(str) || "recover_accounts".equalsIgnoreCase(str) || "method/user.sendMessengerOnlyPhoneConfirmationCode".equalsIgnoreCase(str) || "method/user.confirmMessengerOnlyPhone".equalsIgnoreCase(str) || "method/user.createMessengerOnlyAccount".equalsIgnoreCase(str) || "method/user.bypassLoginWithConfirmedMessengerCredentials".equalsIgnoreCase(str) || "method/intl.getLocaleSuggestions".equalsIgnoreCase(str) || "accountRecoverySendConfirmationCode".equals(apiRequest.f7496a) || "accountRecoveryValidateCode".equals(apiRequest.f7496a) || "requestCaptcha".equals(apiRequest.f7496a) || "validateCaptcha".equals(apiRequest.f7496a)) {
            return true;
        }
        return false;
    }

    private boolean m11738c(ApiRequest apiRequest) {
        return "aldrin_logged_out_status".equalsIgnoreCase(apiRequest.f7498c) || "getLanguagePackInfo".equals(apiRequest.f7496a) || "method/logging.clientevent".equalsIgnoreCase(apiRequest.f7498c) || "logging_client_events".equalsIgnoreCase(apiRequest.f7498c) || "dbl_remove_nonce".equals(apiRequest.f7496a) || "dbl_change_nonce".equals(apiRequest.f7496a) || "dbl_check_nonce".equals(apiRequest.f7496a) || "dbl_check_password".equals(apiRequest.f7496a) || "dbl_password_set_nonce".equals(apiRequest.f7496a) || "messenger_invites".equals(apiRequest.f7496a) || "accountRecoverySendConfirmationCode".equals(apiRequest.f7496a) || "accountRecoveryValidateCode".equals(apiRequest.f7496a) || "requestCaptcha".equals(apiRequest.f7496a) || "validateCaptcha".equals(apiRequest.f7496a) || "at_work_self_invite".equals(apiRequest.f7496a) || "checkApprovedMachine".equals(apiRequest.f7496a) || "login_approval_resend_code".equals(apiRequest.f7496a) || "at_work_pre_login_info".equals(apiRequest.f7496a) || "at_work_invite_check".equals(apiRequest.f7496a) || "at_work_claim_account".equals(apiRequest.f7496a) || ("UserSemClickTrackingMutation".equals(apiRequest.f7496a) && !this.f7268z.m2522b());
    }

    private static boolean m11739d(ApiRequest apiRequest) {
        return "FetchWorkCommunitiesFromPersonalAccountQuery".equals(apiRequest.f7496a) || "at_work_claim_account".equals(apiRequest.f7496a) || "at_work_fetch_account_details".equals(apiRequest.f7496a) || "FetchEmailQuery".equals(apiRequest.f7496a) || BootstrapRequestName.LOGOUT.requestNameString.equals(apiRequest.f7496a) || "at_work_get_name".equals(apiRequest.f7496a);
    }

    private synchronized boolean m11740e(ApiRequest apiRequest) {
        boolean z;
        if (this.f7243B == null) {
            String a = this.f7242A.mo581a(ExperimentsForHttpQeModule.ak, null);
            if (a == null) {
                this.f7243B = ImmutableSet.of();
                z = false;
            } else {
                this.f7243B = ImmutableSet.copyOf(a.split(","));
            }
        }
        z = this.f7243B.contains(apiRequest.m12102a());
        return z;
    }
}
