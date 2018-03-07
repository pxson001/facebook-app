package com.facebook.common.init;

import com.facebook.abtest.qe.QuickExperimentINeedInit;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.LazyCustomErrorDataInitializer;
import com.facebook.common.errorreporting.STATICDI_MULTIBIND_PROVIDER$FbCustomReportDataSupplier;
import com.facebook.common.errorreporting.init.ErrorReporterSecondaryInit;
import com.facebook.common.init.impl.INeedInitForBroadcastReceiverRegister;
import com.facebook.common.init.impl.INeedInitForEventBusRegister;
import com.facebook.common.init.impl.INeedInitForGatekeepersListenerRegister;
import com.facebook.common.init.impl.INeedInitForSharedPrefsListenerRegister;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore.PendingStoryStoreInitializer;
import com.facebook.composer.savedsession.ComposerSavedSessionStore.ComposerSavedSessionStoreInitializer;
import com.facebook.http.executors.delaybased.DelayBasedResponseHandlerWrapper;
import com.facebook.http.onion.TorProxyMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.languages.switcher.LanguageSwitcher;
import com.facebook.logcontroller.LogController;
import com.facebook.loom.module.LoomBridge;
import com.facebook.loom.module.LoomBridgeFactoryImpl;
import com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider;
import com.facebook.orca.app.OrcaDataManager;
import com.facebook.photos.upload.manager.UploadCrashMonitor;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.resources.impl.StringResourcesDelegate;
import com.facebook.upnp.UpnpDiscovery;
import com.facebook.xconfig.core.XConfigInitializer;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0063xb7b69945 implements MultiBindIndexedProvider<INeedInit>, Provider<Set<INeedInit>> {
    private final InjectorLike f1041a;

    public C0063xb7b69945(InjectorLike injectorLike) {
        this.f1041a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1041a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<INeedInit>> m2124a(InjectorLike injectorLike) {
        return ProviderLazy.m1699a(new C0063xb7b69945(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 20;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return QuickExperimentINeedInit.m3602a(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new LazyCustomErrorDataInitializer(FbErrorReporterImpl.m2317a((InjectorLike) injector), ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$FbCustomReportDataSupplier(injector.getScopeAwareInjector()), injector.getScopeAwareInjector()));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return ErrorReporterSecondaryInit.m4337b(injector);
            case 3:
                return INeedInitForBroadcastReceiverRegister.m4476a((InjectorLike) injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return INeedInitForEventBusRegister.m4550a(injector);
            case 5:
                return INeedInitForGatekeepersListenerRegister.m4616a(injector);
            case 6:
                return INeedInitForSharedPrefsListenerRegister.m4666a(injector);
            case 7:
                return PendingStoryStoreInitializer.m4719a(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return ComposerSavedSessionStoreInitializer.m4722a(injector);
            case 9:
                return DelayBasedResponseHandlerWrapper.m4731a(injector);
            case 10:
                return TorProxyMethodAutoProvider.m3888b(injector);
            case 11:
                return LanguageSwitcher.m4742a((InjectorLike) injector);
            case 12:
                return LogController.m4814a(injector);
            case 13:
                LoomBridgeFactoryImpl loomBridgeFactoryImpl = new LoomBridgeFactoryImpl(LoomBridge.m4827b(injector));
                loomBridgeFactoryImpl.f2822a = IdBasedLazy.m1808a(injector, 2509);
                return loomBridgeFactoryImpl;
            case 14:
                return StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.m4828a(injector);
            case 15:
                return OrcaDataManager.m4902a(injector);
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return UploadCrashMonitor.m4914a((InjectorLike) injector);
            case 17:
                return StringResourcesDelegate.m2562a((InjectorLike) injector);
            case 18:
                return UpnpDiscovery.m4997a((InjectorLike) injector);
            case 19:
                return new XConfigInitializer(IdBasedSingletonScopeProvider.m1810b(injector, 3751), IdBasedProvider.m1811a(injector, 4443));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
