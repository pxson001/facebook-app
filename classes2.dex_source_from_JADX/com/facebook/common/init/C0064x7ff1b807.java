package com.facebook.common.init;

import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.diagnostics.LogcatFbSdcardLogger;
import com.facebook.common.executors.CrashingFutureCallback;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.common.init.STATICDI_MULTIBIND_PROVIDER.INeedInit__com_facebook_common_noncriticalinit_NeedsAfterUILoadedInitOnBackgroundThread;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.noncriticalinit.NonCriticalInitializer;
import com.facebook.debug.watchdog.UiThreadWatchdog;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.katana.appirater.Fb4aAppiraterInitializer;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0064x7ff1b807 implements MultiBindIndexedProvider<INeedInit>, Provider<Set<INeedInit>> {
    private final InjectorLike f1042a;

    public C0064x7ff1b807(InjectorLike injectorLike) {
        this.f1042a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1042a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<INeedInit>> m2125a(InjectorLike injectorLike) {
        return ProviderLazy.m1699a(new C0064x7ff1b807(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 7;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return AppStateManager.m2245a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return LogcatFbSdcardLogger.a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return MemoryManager.m9807a((InjectorLike) injector);
            case 3:
                return new NonCriticalInitializer(ProviderLazy.m1699a(new INeedInit__com_facebook_common_noncriticalinit_NeedsAfterUILoadedInitOnBackgroundThread(injector.getScopeAwareInjector()), injector.getScopeAwareInjector()), IdBasedSingletonScopeProvider.m1810b(injector, 559), DefaultAppChoreographer.m1621a((InjectorLike) injector), Executor_SameThreadExecutorMethodAutoProvider.m1812a(injector), CrashingFutureCallback.m1825a(injector));
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return UiThreadWatchdog.a(injector);
            case 5:
                return Fb4aAppiraterInitializer.a(injector);
            case 6:
                return DefaultPresenceManager.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
