package com.facebook.http.protocol;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.carrier.CarrierMonitor;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.config.application.PlatformAppConfig;
import com.facebook.config.server.C0307xb160b519;
import com.facebook.config.server.C0308x7c2db9b2;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.common.C0309xb6c3435b;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: payments_deltas */
public class MethodBatcherImpl {
    public static final ImmutableSet<String> f10317C = ImmutableSet.of(BootstrapRequestName.BATCH_COMPONENT_FETCH_CONFIGURATION.requestNameString);
    private static volatile MethodBatcherImpl f10318D;
    public static final Class<?> f10319a = MethodBatcherImpl.class;
    public final Clock f10320A;
    public final TimeFormatUtil f10321B;
    public final Provider<PlatformAppHttpConfig> f10322b;
    public final PlatformAppHttpConfig f10323c;
    public final PlatformAppHttpConfig f10324d;
    public final FbHttpRequestProcessor f10325e;
    public final Provider<String> f10326f;
    public final Provider<ViewerContext> f10327g;
    public final Provider<Boolean> f10328h;
    public final Provider<Boolean> f10329i;
    public final Provider<Boolean> f10330j;
    public final Provider<Boolean> f10331k;
    public final Provider<Boolean> f10332l;
    public final Provider<Boolean> f10333m;
    public final JsonFactory f10334n;
    public final ObjectMapper f10335o;
    public final ApiResponseChecker f10336p;
    public final ApiRequestUtils f10337q;
    public final SingleMethodRunnerImpl f10338r;
    public final BatchControllerRegistry f10339s;
    public final UDPPrimingHelper f10340t;
    private final AbstractFbErrorReporter f10341u;
    public final BootstrapTierUtil f10342v;
    private final CarrierMonitor f10343w;
    public final ParamsCollectionPool f10344x;
    public final PlatformAppConfig f10345y;
    public final Provider<Boolean> f10346z;

    public static com.facebook.http.protocol.MethodBatcherImpl m15387a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10318D;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.protocol.MethodBatcherImpl.class;
        monitor-enter(r1);
        r0 = f10318D;	 Catch:{ all -> 0x003a }
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
        r0 = m15388b(r0);	 Catch:{ all -> 0x0035 }
        f10318D = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10318D;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.protocol.MethodBatcherImpl.a(com.facebook.inject.InjectorLike):com.facebook.http.protocol.MethodBatcherImpl");
    }

    private static MethodBatcherImpl m15388b(InjectorLike injectorLike) {
        return new MethodBatcherImpl(IdBasedProvider.m1811a(injectorLike, 2243), C0307xb160b519.m11748a(injectorLike), C0308x7c2db9b2.m11757a(injectorLike), FbHttpRequestProcessor.m12260a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442), IdBasedProvider.m1811a(injectorLike, 372), IdBasedProvider.m1811a(injectorLike, 4022), IdBasedProvider.m1811a(injectorLike, 4024), IdBasedProvider.m1811a(injectorLike, 4025), IdBasedProvider.m1811a(injectorLike, 4021), IdBasedProvider.m1811a(injectorLike, 3936), IdBasedProvider.m1811a(injectorLike, 4028), SingleMethodRunnerImpl.m11724a(injectorLike), JsonFactoryMethodAutoProvider.m8062a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), ApiResponseChecker.m11759a(injectorLike), ApiRequestUtils.m11769a(injectorLike), BatchControllerRegistry.m15390a(injectorLike), UDPPrimingHelper.m9443a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), BootstrapTierUtil.m11778a(injectorLike), CarrierMonitor.m12302a(injectorLike), C0309xb6c3435b.m11772a(injectorLike), (PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class), IdBasedProvider.m1811a(injectorLike, 4026), SystemClockMethodAutoProvider.m1498a(injectorLike), DefaultTimeFormatUtil.m11785a(injectorLike));
    }

    @Inject
    public MethodBatcherImpl(Provider<PlatformAppHttpConfig> provider, PlatformAppHttpConfig platformAppHttpConfig, PlatformAppHttpConfig platformAppHttpConfig2, FbHttpRequestProcessor fbHttpRequestProcessor, Provider<String> provider2, Provider<ViewerContext> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6, Provider<Boolean> provider7, Provider<Boolean> provider8, Provider<Boolean> provider9, SingleMethodRunnerImpl singleMethodRunnerImpl, JsonFactory jsonFactory, ObjectMapper objectMapper, ApiResponseChecker apiResponseChecker, ApiRequestUtils apiRequestUtils, BatchControllerRegistry batchControllerRegistry, UDPPrimingHelper uDPPrimingHelper, FbErrorReporter fbErrorReporter, BootstrapTierUtil bootstrapTierUtil, CarrierMonitor carrierMonitor, ParamsCollectionPool paramsCollectionPool, PlatformAppConfig platformAppConfig, Provider<Boolean> provider10, Clock clock, TimeFormatUtil timeFormatUtil) {
        this.f10322b = provider;
        this.f10323c = platformAppHttpConfig;
        this.f10324d = platformAppHttpConfig2;
        this.f10325e = fbHttpRequestProcessor;
        this.f10326f = provider2;
        this.f10327g = provider3;
        this.f10328h = provider4;
        this.f10329i = provider5;
        this.f10330j = provider6;
        this.f10331k = provider7;
        this.f10332l = provider8;
        this.f10333m = provider9;
        this.f10334n = jsonFactory;
        this.f10335o = objectMapper;
        this.f10336p = apiResponseChecker;
        this.f10337q = apiRequestUtils;
        this.f10338r = singleMethodRunnerImpl;
        this.f10339s = batchControllerRegistry;
        this.f10340t = uDPPrimingHelper;
        this.f10341u = fbErrorReporter;
        this.f10342v = bootstrapTierUtil;
        this.f10343w = carrierMonitor;
        this.f10344x = paramsCollectionPool;
        this.f10345y = platformAppConfig;
        this.f10346z = provider10;
        this.f10320A = clock;
        this.f10321B = timeFormatUtil;
    }

    public final Batch m15389a() {
        return new MethodBatchImpl(this);
    }
}
