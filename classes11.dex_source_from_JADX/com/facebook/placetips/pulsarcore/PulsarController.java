package com.facebook.placetips.pulsarcore;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.LazyFutures;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.bootstrap.PulsarDetectionEnabledFuture;
import com.facebook.placetips.bootstrap.data.BleScanResult;
import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceEvent;
import com.facebook.placetips.logging.PlaceTipsAnalyticsEvent;
import com.facebook.placetips.logging.PlaceTipsAnalyticsLogger;
import com.facebook.placetips.presence.PagePresenceManager;
import com.facebook.placetips.presence.PagePresenceManagerFuture;
import com.facebook.placetips.pulsarcore.abtest.PlaceTipsPulsarQe.Config;
import com.facebook.placetips.pulsarcore.abtest.PlaceTipsPulsarQeFuture;
import com.facebook.placetips.pulsarcore.presence.DefaultBleScanProcessor;
import com.facebook.placetips.pulsarcore.presence.DefaultBleScanProcessor.C12691;
import com.facebook.placetips.pulsarcore.presence.DefaultBleScanProcessor.C12702;
import com.facebook.placetips.pulsarcore.presence.DefaultBleScanProcessor.C12713;
import com.facebook.placetips.pulsarcore.presence.PulsarBleScanProcessor;
import com.facebook.placetips.pulsarcore.scan.BleScanException.BluetoothDiscoveryInterruptException;
import com.facebook.placetips.pulsarcore.scan.BleScanner;
import com.facebook.placetips.pulsarcore.service.BluetoothDiscoveryInterruptHandler;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.AccessorFuture;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: The gradient must contain at least 2 colors */
public class PulsarController {
    public final Lazy<ListenableFuture<Config>> f10661a;
    public final Lazy<BleScanner> f10662b;
    public final Lazy<PulsarBleScanProcessor> f10663c;
    public final Lazy<BluetoothDiscoveryInterruptHandler> f10664d;
    public final PlaceTipsAnalyticsLogger f10665e;
    private final Lazy<AccessorFuture> f10666f;
    public final Lazy<AppStateManager> f10667g;
    public final Lazy<ListeningScheduledExecutorService> f10668h;
    public final Lazy<ConnectivityManager> f10669i;
    public final Lazy<PagePresenceManagerFuture> f10670j;
    public final PulsarLocationStatusChecker f10671k;

    /* compiled from: The gradient must contain at least 2 colors */
    public class AnonymousClass10 implements Callable<ListenableFuture<PlaceTipsPresenceEvent>> {
        final /* synthetic */ PlaceTipsPresenceEvent f10648a;
        final /* synthetic */ PulsarController f10649b;

        public AnonymousClass10(PulsarController pulsarController, PlaceTipsPresenceEvent placeTipsPresenceEvent) {
            this.f10649b = pulsarController;
            this.f10648a = placeTipsPresenceEvent;
        }

        public Object call() {
            if (((AppStateManager) this.f10649b.f10667g.get()).j()) {
                return Futures.a(this.f10648a);
            }
            return this.f10649b.m11183a();
        }
    }

    /* compiled from: The gradient must contain at least 2 colors */
    class C12551 implements AsyncFunction<List<Object>, Config> {
        final /* synthetic */ PulsarController f10651a;

        C12551(PulsarController pulsarController) {
            this.f10651a = pulsarController;
        }

        public final ListenableFuture m11177a(Object obj) {
            List list = (List) obj;
            Config config = (Config) list.get(1);
            if (((Boolean) list.get(0)).booleanValue() && config.f10682a) {
                return Futures.a(config);
            }
            throw new IllegalAccessException("Pulsar detection not enabled");
        }
    }

    /* compiled from: The gradient must contain at least 2 colors */
    class C12562 implements AsyncFunction<Accessor, Config> {
        final /* synthetic */ PulsarController f10652a;

        C12562(PulsarController pulsarController) {
            this.f10652a = pulsarController;
        }

        public final ListenableFuture m11178a(Object obj) {
            if (!((Accessor) obj).c()) {
                throw new IllegalAccessException("Pulsar detection disabled in settings");
            } else if (this.f10652a.f10671k.a()) {
                Object obj2;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f10652a.f10669i.get()).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    return (ListenableFuture) this.f10652a.f10661a.get();
                }
                throw new IOException("No network connectivity detected");
            } else {
                throw new IllegalAccessException("Location is not supported on device");
            }
        }
    }

    /* compiled from: The gradient must contain at least 2 colors */
    class C12573 implements AsyncFunction<Config, BleScanResult> {
        final /* synthetic */ PulsarController f10653a;

        C12573(PulsarController pulsarController) {
            this.f10653a = pulsarController;
        }

        public final ListenableFuture m11179a(Object obj) {
            long j = 1000 * ((long) ((Config) obj).f10688g);
            this.f10653a.f10665e.a(PlaceTipsAnalyticsEvent.START_BLE_SCAN, PresenceSourceType.BLE);
            return ((BleScanner) this.f10653a.f10662b.get()).mo288a(j);
        }
    }

    /* compiled from: The gradient must contain at least 2 colors */
    class C12584 implements AsyncFunction<BleScanResult, PlaceTipsPresenceEvent> {
        final /* synthetic */ PulsarController f10654a;

        C12584(PulsarController pulsarController) {
            this.f10654a = pulsarController;
        }

        public final ListenableFuture m11180a(Object obj) {
            DefaultBleScanProcessor defaultBleScanProcessor = (DefaultBleScanProcessor) this.f10654a.f10663c.get();
            ListenableFuture b = Futures.b(Futures.a((ListenableFuture) defaultBleScanProcessor.f10756g.get(), new C12713(defaultBleScanProcessor, (BleScanResult) obj), MoreExecutors.a()), new C12691(defaultBleScanProcessor), MoreExecutors.a());
            return Futures.b(Futures.a(new ListenableFuture[]{b, (ListenableFuture) defaultBleScanProcessor.f10751b.get()}), new C12702(defaultBleScanProcessor), MoreExecutors.a());
        }
    }

    /* compiled from: The gradient must contain at least 2 colors */
    class C12595 implements AsyncFunction<List<Object>, PlaceTipsPresenceEvent> {
        final /* synthetic */ PulsarController f10655a;

        C12595(PulsarController pulsarController) {
            this.f10655a = pulsarController;
        }

        public final ListenableFuture m11181a(Object obj) {
            ListenableFuture a;
            List list = (List) obj;
            PlaceTipsPresenceEvent placeTipsPresenceEvent = (PlaceTipsPresenceEvent) list.get(0);
            Config config = (Config) list.get(1);
            PulsarController pulsarController = this.f10655a;
            if (((AppStateManager) pulsarController.f10667g.get()).j()) {
                a = Futures.a(placeTipsPresenceEvent);
            } else {
                a = Futures.b(((ListeningScheduledExecutorService) pulsarController.f10668h.get()).a(new AnonymousClass10(pulsarController, placeTipsPresenceEvent), (long) config.f10689h, TimeUnit.SECONDS), new AsyncFunction<ListenableFuture<PlaceTipsPresenceEvent>, PlaceTipsPresenceEvent>(pulsarController) {
                    final /* synthetic */ PulsarController f10650a;

                    {
                        this.f10650a = r1;
                    }

                    public final ListenableFuture m11176a(Object obj) {
                        return (ListenableFuture) obj;
                    }
                }, MoreExecutors.a());
            }
            return a;
        }
    }

    /* compiled from: The gradient must contain at least 2 colors */
    public class C12606 implements FutureCallback<BleScanResult> {
        final /* synthetic */ PulsarController f10656a;

        public C12606(PulsarController pulsarController) {
            this.f10656a = pulsarController;
        }

        public void onSuccess(Object obj) {
            this.f10656a.f10665e.a((BleScanResult) obj);
        }

        public void onFailure(Throwable th) {
            this.f10656a.f10665e.a(PlaceTipsAnalyticsEvent.END_BLE_SCAN_FAIL, PresenceSourceType.BLE, th);
        }
    }

    /* compiled from: The gradient must contain at least 2 colors */
    public class C12617 implements FutureCallback<PlaceTipsPresenceEvent> {
        final /* synthetic */ PulsarController f10657a;

        public C12617(PulsarController pulsarController) {
            this.f10657a = pulsarController;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            BluetoothDiscoveryInterruptHandler bluetoothDiscoveryInterruptHandler = (BluetoothDiscoveryInterruptHandler) this.f10657a.f10664d.get();
            if (th instanceof BluetoothDiscoveryInterruptException) {
                bluetoothDiscoveryInterruptHandler.f10783a.a("Trying to enable bluetooth discovery finished receiver");
                bluetoothDiscoveryInterruptHandler.f10784b.a(true);
            }
        }
    }

    /* compiled from: The gradient must contain at least 2 colors */
    public class C12628 implements FutureCallback<PlaceTipsPresenceEvent> {
        final /* synthetic */ PulsarController f10658a;

        public C12628(PulsarController pulsarController) {
            this.f10658a = pulsarController;
        }

        public void onSuccess(Object obj) {
            this.f10658a.f10665e.a(PlaceTipsAnalyticsEvent.END_SCAN_SESSION_SUCCESS, PresenceSourceType.BLE);
        }

        public void onFailure(Throwable th) {
            this.f10658a.f10665e.a(PlaceTipsAnalyticsEvent.END_SCAN_SESSION_FAIL, PresenceSourceType.BLE, th);
        }
    }

    /* compiled from: The gradient must contain at least 2 colors */
    public class C12649 implements FutureCallback<PlaceTipsPresenceEvent> {
        final /* synthetic */ PulsarController f10660a;

        /* compiled from: The gradient must contain at least 2 colors */
        class C12631 implements FutureCallback<PagePresenceManager> {
            final /* synthetic */ C12649 f10659a;

            C12631(C12649 c12649) {
                this.f10659a = c12649;
            }

            public void onSuccess(Object obj) {
                ((PagePresenceManager) obj).a(PresenceSourceType.BLE);
            }

            public void onFailure(Throwable th) {
            }
        }

        public C12649(PulsarController pulsarController) {
            this.f10660a = pulsarController;
        }

        public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
            if (!(th instanceof BluetoothDiscoveryInterruptException)) {
                Futures.a((ListenableFuture) this.f10660a.f10670j.get(), new C12631(this), MoreExecutors.a());
            }
        }
    }

    public static PulsarController m11182b(InjectorLike injectorLike) {
        return new PulsarController(IdBasedLazy.a(injectorLike, 3014), IdBasedLazy.a(injectorLike, 9599), IdBasedLazy.a(injectorLike, 9607), IdBasedLazy.a(injectorLike, 9604), IdBasedLazy.a(injectorLike, 9610), PlaceTipsAnalyticsLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 3023), IdBasedSingletonScopeProvider.b(injectorLike, 476), IdBasedSingletonScopeProvider.b(injectorLike, 3863), IdBasedLazy.a(injectorLike, 38), IdBasedSingletonScopeProvider.b(injectorLike, 3010), PulsarLocationStatusChecker.b(injectorLike));
    }

    @Inject
    public PulsarController(Lazy<PulsarDetectionEnabledFuture> lazy, Lazy<PlaceTipsPulsarQeFuture> lazy2, Lazy<BleScanner> lazy3, Lazy<PulsarBleScanProcessor> lazy4, Lazy<BluetoothDiscoveryInterruptHandler> lazy5, PlaceTipsAnalyticsLogger placeTipsAnalyticsLogger, Lazy<AccessorFuture> lazy6, Lazy<AppStateManager> lazy7, Lazy<ListeningScheduledExecutorService> lazy8, Lazy<ConnectivityManager> lazy9, Lazy<PagePresenceManagerFuture> lazy10, PulsarLocationStatusChecker pulsarLocationStatusChecker) {
        this.f10662b = lazy3;
        this.f10663c = lazy4;
        this.f10664d = lazy5;
        this.f10665e = placeTipsAnalyticsLogger;
        this.f10666f = lazy6;
        this.f10667g = lazy7;
        this.f10668h = lazy8;
        this.f10669i = lazy9;
        this.f10670j = lazy10;
        this.f10671k = pulsarLocationStatusChecker;
        this.f10661a = LazyFutures.a().a(lazy).a(lazy2).a(new C12551(this), MoreExecutors.a());
    }

    public final ListenableFuture<PlaceTipsPresenceEvent> m11183a() {
        this.f10665e.a(PlaceTipsAnalyticsEvent.START_SCAN_SESSION, PresenceSourceType.BLE);
        ListenableFuture b = Futures.b(Futures.b((ListenableFuture) this.f10666f.get(), new C12562(this), MoreExecutors.a()), new C12573(this), MoreExecutors.a());
        Futures.a(b, new C12606(this), MoreExecutors.a());
        b = Futures.b(b, new C12584(this), MoreExecutors.a());
        Futures.a(b, new C12617(this), MoreExecutors.a());
        Futures.a(b, new C12628(this), MoreExecutors.a());
        Futures.a(b, new C12649(this), MoreExecutors.a());
        return Futures.b(Futures.a(new ListenableFuture[]{b, (ListenableFuture) this.f10661a.get()}), new C12595(this), MoreExecutors.a());
    }
}
