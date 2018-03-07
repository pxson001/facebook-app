package com.facebook.placetips.pulsarcore;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.placetips.bootstrap.PlaceTipsLocalLogger;
import com.facebook.placetips.bootstrap.PulsarDetectionEnabledFuture;
import com.facebook.placetips.bootstrap.PulsarScanTrigger;
import com.facebook.placetips.logging.PlaceTipsLocalLoggerImpl;
import com.facebook.placetips.pulsarcore.service.PulsarService;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_pay_request */
public class PulsarScanTriggerImpl implements PulsarScanTrigger {
    private final Provider<PulsarDetectionEnabledFuture> f13839a;
    public final Context f13840b;
    public final SecureContextHelper f13841c;
    @ForUiThread
    private final Executor f13842d;
    public final Provider<BluetoothAdapter> f13843e;
    public final PlaceTipsLocalLogger f13844f;

    /* compiled from: messenger_pay_request */
    class C05711 implements FutureCallback<Boolean> {
        final /* synthetic */ PulsarScanTriggerImpl f13845a;

        C05711(PulsarScanTriggerImpl pulsarScanTriggerImpl) {
            this.f13845a = pulsarScanTriggerImpl;
        }

        @TargetApi(5)
        public void onSuccess(Object obj) {
            if (((Boolean) obj).booleanValue()) {
                BluetoothAdapter bluetoothAdapter = (BluetoothAdapter) this.f13845a.f13843e.get();
                if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
                    this.f13845a.f13841c.mo666c(new Intent(this.f13845a.f13840b, PulsarService.class), this.f13845a.f13840b);
                }
            }
        }

        public void onFailure(Throwable th) {
            this.f13845a.f13844f.mo655a(th, "Failed to load pulsarDetectionEnabledFuture");
        }
    }

    public static PulsarScanTriggerImpl m20239b(InjectorLike injectorLike) {
        return new PulsarScanTriggerImpl(IdBasedProvider.m1811a(injectorLike, 3014), (Context) injectorLike.getInstance(Context.class), DefaultSecureContextHelper.m4636a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), IdBasedProvider.m1811a(injectorLike, 10), PlaceTipsLocalLoggerImpl.m4594a(injectorLike));
    }

    @Inject
    public PulsarScanTriggerImpl(Provider<PulsarDetectionEnabledFuture> provider, Context context, SecureContextHelper secureContextHelper, Executor executor, Provider<BluetoothAdapter> provider2, PlaceTipsLocalLogger placeTipsLocalLogger) {
        this.f13839a = provider;
        this.f13840b = context;
        this.f13841c = secureContextHelper;
        this.f13842d = executor;
        this.f13843e = provider2;
        this.f13844f = placeTipsLocalLogger;
    }

    public final void mo2676a() {
        Futures.m2458a((ListenableFuture) this.f13839a.get(), new C05711(this), this.f13842d);
    }
}
