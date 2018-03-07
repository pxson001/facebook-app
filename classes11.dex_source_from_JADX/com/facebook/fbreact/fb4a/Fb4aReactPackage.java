package com.facebook.fbreact.fb4a;

import com.facebook.adinterfaces.react.AdInterfacesCallbackModule;
import com.facebook.adinterfaces.react.AdInterfacesCallbackModuleProvider;
import com.facebook.analytics2.logger.Analytics2Logger;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.catalyst.modules.appstate.HostStateModule;
import com.facebook.catalyst.modules.media.SoundsModule;
import com.facebook.catalyst.modules.permissions.PermissionsModule;
import com.facebook.catalyst.modules.persistedqueries.RelayPersistedQueriesPreloaderModule;
import com.facebook.catalyst.views.gradient.ReactAxialGradientManager;
import com.facebook.catalyst.views.maps.ReactFbMapViewManager;
import com.facebook.catalyst.views.maps.ReactMapViewManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.config.server.UserAgentFactory;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.fbreact.activity.SetResultModule;
import com.facebook.fbreact.activity.SetResultModuleProvider;
import com.facebook.fbreact.analytics.Fb4aAnalyticsModule;
import com.facebook.fbreact.events.FBEventsNativeModuleProvider;
import com.facebook.fbreact.exceptionmanager.FbReactExceptionManager;
import com.facebook.fbreact.fragment.ImmersiveReactFragmentHooks;
import com.facebook.fbreact.funnellogger.AnalyticsFunnelLoggerNativeModule;
import com.facebook.fbreact.funnellogger.AnalyticsFunnelLoggerNativeModuleProvider;
import com.facebook.fbreact.goodwill.GoodwillVideoNativeModuleProvider;
import com.facebook.fbreact.i18n.FbLocaleProvider;
import com.facebook.fbreact.i18n.FbReactI18nModule;
import com.facebook.fbreact.interfaces.RCTViewEventEmitter;
import com.facebook.fbreact.jscperf.JSCPerfRecorder;
import com.facebook.fbreact.jscperf.JSCPerfRecorderModule;
import com.facebook.fbreact.jscperf.JSCPerfRecorderModuleProvider;
import com.facebook.fbreact.marketplace.FBMarketplaceComposerBridgeModuleProvider;
import com.facebook.fbreact.marketplace.FBMarketplaceImagePickerModule;
import com.facebook.fbreact.marketplace.FBMarketplaceImagePickerModuleProvider;
import com.facebook.fbreact.marketplace.FBMarketplaceNativeModule;
import com.facebook.fbreact.marketplace.FBMarketplaceNativeModuleProvider;
import com.facebook.fbreact.marketplace.FBReactSearchInputNativeModule;
import com.facebook.fbreact.marketplace.FBReactSearchInputNativeModuleProvider;
import com.facebook.fbreact.navigation.FbReactNavigationJavaModuleProvider;
import com.facebook.fbreact.pageserviceaddedit.PageServiceAddEditPickerNativeModule;
import com.facebook.fbreact.pageserviceaddedit.PageServiceAddEditPickerNativeModuleProvider;
import com.facebook.fbreact.privacy.PrivacyCheckupReactModuleProvider;
import com.facebook.fbreact.search.ReactSearchEventBus;
import com.facebook.fbreact.views.fbperflogger.FbReactPerfLoggerFlagManager;
import com.facebook.fbreact.views.fbvpvlogger.FbReactVpvLoggerFlagManager;
import com.facebook.fbreact.views.shimmer.FbReactShimmerFrameLayoutManager;
import com.facebook.fbreactcomponents.stickers.StickerViewInputManager;
import com.facebook.fbreactcomponents.stickers.StickerViewManager;
import com.facebook.fbreactmodules.network.FBNetworkingModule;
import com.facebook.fbreactmodules.network.FbRelayConfigModule;
import com.facebook.fbreactmodules.perf.FBPerformanceLogger;
import com.facebook.fbreactmodules.relay.FbRelayNativeAdapter;
import com.facebook.fbreactmodules.relay.FbRelayNativeAdapterProvider;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.graphql.executor.GraphQLCacheAggregator;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.groups.fb4a.react.FB4AGroupsManagerJavaModuleProvider;
import com.facebook.groups.fb4a.react.ReactGYSCViewManager;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.camera.CameraRollManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.netinfo.NetInfoModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.art.ARTRenderableViewManager;
import com.facebook.react.views.art.ARTSurfaceViewManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.views.viewpager.ReactViewPagerManager;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_viewer_profile_permissions */
public class Fb4aReactPackage implements ReactPackage {
    private static final CallerContext f7292a = CallerContext.b(Fb4aReactPackage.class, "ReactNative");
    private static volatile Fb4aReactPackage f7293y;
    private final Lazy<Analytics2Logger> f7294b;
    private final GoodwillVideoNativeModuleProvider f7295c;
    private final PrivacyCheckupReactModuleProvider f7296d;
    private final FbDraweeControllerBuilder f7297e;
    private final FBEventsNativeModuleProvider f7298f;
    private final FbHttpRequestProcessor f7299g;
    private final FbReactNavigationJavaModuleProvider f7300h;
    private final FbRelayNativeAdapterProvider f7301i;
    private final Lazy<FbRelayConfigModule> f7302j;
    private final UserAgentFactory f7303k;
    private final AdInterfacesCallbackModuleProvider f7304l;
    private final Fb4aReactPerfFlagListener f7305m;
    private final FbReactExceptionManager f7306n;
    private final FBPerformanceLogger f7307o;
    private final FB4AGroupsManagerJavaModuleProvider f7308p;
    private final PageServiceAddEditPickerNativeModuleProvider f7309q;
    private final JSCPerfRecorderModuleProvider f7310r;
    private final FBMarketplaceComposerBridgeModuleProvider f7311s;
    private final FBMarketplaceNativeModuleProvider f7312t;
    private final FBMarketplaceImagePickerModuleProvider f7313u;
    private final FBReactSearchInputNativeModuleProvider f7314v;
    private final AnalyticsFunnelLoggerNativeModuleProvider f7315w;
    private final SetResultModuleProvider f7316x;

    public static com.facebook.fbreact.fb4a.Fb4aReactPackage m8507a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7293y;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbreact.fb4a.Fb4aReactPackage.class;
        monitor-enter(r1);
        r0 = f7293y;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8508b(r0);	 Catch:{ all -> 0x0035 }
        f7293y = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7293y;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbreact.fb4a.Fb4aReactPackage.a(com.facebook.inject.InjectorLike):com.facebook.fbreact.fb4a.Fb4aReactPackage");
    }

    private static Fb4aReactPackage m8508b(InjectorLike injectorLike) {
        return new Fb4aReactPackage((FB4AGroupsManagerJavaModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FB4AGroupsManagerJavaModuleProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 207), (GoodwillVideoNativeModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GoodwillVideoNativeModuleProvider.class), (PrivacyCheckupReactModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PrivacyCheckupReactModuleProvider.class), FbDraweeControllerBuilder.a(injectorLike), (FBEventsNativeModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FBEventsNativeModuleProvider.class), FbHttpRequestProcessor.a(injectorLike), (FbReactNavigationJavaModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FbReactNavigationJavaModuleProvider.class), (FbRelayNativeAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FbRelayNativeAdapterProvider.class), IdBasedLazy.a(injectorLike, 5791), UserAgentFactory.a(injectorLike), (AdInterfacesCallbackModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AdInterfacesCallbackModuleProvider.class), Fb4aReactPerfFlagListener.m8512a(injectorLike), FbReactExceptionManager.a(injectorLike), FBPerformanceLogger.m8714a(injectorLike), (PageServiceAddEditPickerNativeModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PageServiceAddEditPickerNativeModuleProvider.class), (JSCPerfRecorderModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(JSCPerfRecorderModuleProvider.class), (FBMarketplaceComposerBridgeModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FBMarketplaceComposerBridgeModuleProvider.class), (FBMarketplaceNativeModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FBMarketplaceNativeModuleProvider.class), (FBMarketplaceImagePickerModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FBMarketplaceImagePickerModuleProvider.class), (FBReactSearchInputNativeModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FBReactSearchInputNativeModuleProvider.class), (AnalyticsFunnelLoggerNativeModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AnalyticsFunnelLoggerNativeModuleProvider.class), (SetResultModuleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SetResultModuleProvider.class));
    }

    @Inject
    public Fb4aReactPackage(FB4AGroupsManagerJavaModuleProvider fB4AGroupsManagerJavaModuleProvider, Lazy<Analytics2Logger> lazy, GoodwillVideoNativeModuleProvider goodwillVideoNativeModuleProvider, PrivacyCheckupReactModuleProvider privacyCheckupReactModuleProvider, FbDraweeControllerBuilder fbDraweeControllerBuilder, FBEventsNativeModuleProvider fBEventsNativeModuleProvider, FbHttpRequestProcessor fbHttpRequestProcessor, FbReactNavigationJavaModuleProvider fbReactNavigationJavaModuleProvider, FbRelayNativeAdapterProvider fbRelayNativeAdapterProvider, Lazy<FbRelayConfigModule> lazy2, UserAgentFactory userAgentFactory, AdInterfacesCallbackModuleProvider adInterfacesCallbackModuleProvider, Fb4aReactPerfFlagListener fb4aReactPerfFlagListener, FbReactExceptionManager fbReactExceptionManager, FBPerformanceLogger fBPerformanceLogger, PageServiceAddEditPickerNativeModuleProvider pageServiceAddEditPickerNativeModuleProvider, JSCPerfRecorderModuleProvider jSCPerfRecorderModuleProvider, FBMarketplaceComposerBridgeModuleProvider fBMarketplaceComposerBridgeModuleProvider, FBMarketplaceNativeModuleProvider fBMarketplaceNativeModuleProvider, FBMarketplaceImagePickerModuleProvider fBMarketplaceImagePickerModuleProvider, FBReactSearchInputNativeModuleProvider fBReactSearchInputNativeModuleProvider, AnalyticsFunnelLoggerNativeModuleProvider analyticsFunnelLoggerNativeModuleProvider, SetResultModuleProvider setResultModuleProvider) {
        this.f7308p = fB4AGroupsManagerJavaModuleProvider;
        this.f7294b = lazy;
        this.f7295c = goodwillVideoNativeModuleProvider;
        this.f7296d = privacyCheckupReactModuleProvider;
        this.f7297e = fbDraweeControllerBuilder;
        this.f7298f = fBEventsNativeModuleProvider;
        this.f7299g = fbHttpRequestProcessor;
        this.f7300h = fbReactNavigationJavaModuleProvider;
        this.f7301i = fbRelayNativeAdapterProvider;
        this.f7302j = lazy2;
        this.f7303k = userAgentFactory;
        this.f7304l = adInterfacesCallbackModuleProvider;
        this.f7305m = fb4aReactPerfFlagListener;
        this.f7306n = fbReactExceptionManager;
        this.f7307o = fBPerformanceLogger;
        this.f7309q = pageServiceAddEditPickerNativeModuleProvider;
        this.f7310r = jSCPerfRecorderModuleProvider;
        this.f7311s = fBMarketplaceComposerBridgeModuleProvider;
        this.f7312t = fBMarketplaceNativeModuleProvider;
        this.f7313u = fBMarketplaceImagePickerModuleProvider;
        this.f7314v = fBReactSearchInputNativeModuleProvider;
        this.f7315w = analyticsFunnelLoggerNativeModuleProvider;
        this.f7316x = setResultModuleProvider;
    }

    public final List<NativeModule> m8510a(ReactApplicationContext reactApplicationContext) {
        r1 = new NativeModule[35];
        AdInterfacesCallbackModuleProvider adInterfacesCallbackModuleProvider = this.f7304l;
        r1[6] = new AdInterfacesCallbackModule(reactApplicationContext, (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(adInterfacesCallbackModuleProvider), ImmersiveReactFragmentHooks.a(adInterfacesCallbackModuleProvider), ImagePipelineMethodAutoProvider.a(adInterfacesCallbackModuleProvider));
        r1[7] = new CameraRollManager(reactApplicationContext);
        r1[8] = new ClipboardModule(reactApplicationContext);
        r1[9] = new NetInfoModule(reactApplicationContext);
        r1[10] = new Fb4aAnalyticsModule(reactApplicationContext, this.f7294b);
        r1[11] = this.f7306n;
        r1[12] = this.f7298f.m8492a(reactApplicationContext);
        r1[13] = new FBNetworkingModule(reactApplicationContext, this.f7299g, f7292a, this.f7303k);
        r1[14] = this.f7307o;
        r1[15] = this.f7295c.m8523a(reactApplicationContext);
        r1[16] = this.f7296d.m8644a(reactApplicationContext);
        r1[17] = new PageServiceAddEditPickerNativeModule(BitmapUtils.a(this.f7309q), reactApplicationContext);
        FbRelayNativeAdapterProvider fbRelayNativeAdapterProvider = this.f7301i;
        r1[18] = new FbRelayNativeAdapter(reactApplicationContext, ConsistencyCacheFactoryImpl.b(fbRelayNativeAdapterProvider), GraphQLCacheAggregator.b(fbRelayNativeAdapterProvider));
        r1[19] = (NativeModule) this.f7302j.get();
        r1[20] = new FbReactI18nModule(reactApplicationContext, 2131165243, new FbLocaleProvider());
        r1[21] = this.f7300h.a(reactApplicationContext);
        r1[22] = new HostStateModule(reactApplicationContext);
        r1[23] = new IntentModule(reactApplicationContext);
        r1[24] = new PermissionsModule(reactApplicationContext);
        r1[25] = new SoundsModule(reactApplicationContext);
        r1[26] = new ToastModule(reactApplicationContext);
        r1[27] = new JSCPerfRecorderModule(reactApplicationContext, JSCPerfRecorder.m8532a(this.f7310r));
        r1[28] = this.f7311s.m8552a(reactApplicationContext);
        FBMarketplaceNativeModuleProvider fBMarketplaceNativeModuleProvider = this.f7312t;
        r1[29] = new FBMarketplaceNativeModule(reactApplicationContext, JewelCounters.a(fBMarketplaceNativeModuleProvider), (SecureContextHelper) DefaultSecureContextHelper.a(fBMarketplaceNativeModuleProvider), (UriIntentMapper) Fb4aUriIntentMapper.a(fBMarketplaceNativeModuleProvider));
        FBMarketplaceImagePickerModuleProvider fBMarketplaceImagePickerModuleProvider = this.f7313u;
        r1[30] = new FBMarketplaceImagePickerModule(reactApplicationContext, (UriIntentMapper) Fb4aUriIntentMapper.a(fBMarketplaceImagePickerModuleProvider), (SecureContextHelper) DefaultSecureContextHelper.a(fBMarketplaceImagePickerModuleProvider), Fb4aReactInstanceManager.a(fBMarketplaceImagePickerModuleProvider));
        FBReactSearchInputNativeModuleProvider fBReactSearchInputNativeModuleProvider = this.f7314v;
        r1[31] = new FBReactSearchInputNativeModule(reactApplicationContext, ReactSearchEventBus.a(fBReactSearchInputNativeModuleProvider), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fBReactSearchInputNativeModuleProvider));
        r1[32] = new SetResultModule(reactApplicationContext, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this.f7316x));
        r1[33] = new RelayPersistedQueriesPreloaderModule(reactApplicationContext);
        r1[34] = new AnalyticsFunnelLoggerNativeModule(reactApplicationContext, FunnelLoggerImpl.a(this.f7315w));
        return Arrays.asList(r1);
    }

    public final List<Class<? extends JavaScriptModule>> m8509a() {
        return Arrays.asList(new Class[]{RCTViewEventEmitter.class});
    }

    public final List<ViewManager> m8511b(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[]{ARTRenderableViewManager.m11769d(), ARTRenderableViewManager.m11770e(), ARTRenderableViewManager.m11771k(), new ARTSurfaceViewManager(), new FbReactPerfLoggerFlagManager(this.f7305m), new FbReactShimmerFrameLayoutManager(), new FbReactVpvLoggerFlagManager(), new ReactAxialGradientManager(), new ReactDrawerLayoutManager(), new ReactHorizontalScrollViewManager(), new FrescoBasedReactTextInlineImageViewManager(this.f7297e, f7292a), new ReactImageManager(this.f7297e, f7292a), new ReactFbMapViewManager(), new ReactMapViewManager(reactApplicationContext), new ReactModalHostManager(reactApplicationContext), new ReactProgressBarViewManager(), new ReactRawTextManager(), new ReactScrollViewManager(), new ReactTextInputManager(), new ReactTextViewManager(), new ReactViewManager(), new ReactViewPagerManager(), new ReactVirtualTextViewManager(), new StickerViewInputManager(), new StickerViewManager(), new SwipeRefreshLayoutManager(), new ReactGYSCViewManager()});
    }
}
