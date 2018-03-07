package com.facebook.placetips.pulsarcore;

import android.os.Build.VERSION;
import com.facebook.inject.Lazy;
import com.facebook.inject.LazyFutures;
import com.facebook.placetips.bootstrap.PulsarDetectionEnabledFuture;
import com.facebook.placetips.pulsarcore.abtest.PlaceTipsPulsarQeFuture;
import com.facebook.placetips.pulsarcore.bluetooth.BluetoothSupportChecker;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.AccessorFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Future;
import javax.inject.Inject;

/* compiled from: method/user.prefillorautocompletecontactpoint */
public class PulsarDetectionEnabledFutureImpl extends ForwardingListenableFuture<Boolean> implements PulsarDetectionEnabledFuture {
    private final Lazy<ListenableFuture<Boolean>> f13555a;

    protected final /* synthetic */ Future mo1830a() {
        return mo2648b();
    }

    protected final /* synthetic */ Object mo105e() {
        return mo2648b();
    }

    @Inject
    public PulsarDetectionEnabledFutureImpl(BluetoothSupportChecker bluetoothSupportChecker, PulsarLocationStatusChecker pulsarLocationStatusChecker, Lazy<PlaceTipsPulsarQeFuture> lazy, Lazy<AccessorFuture> lazy2) {
        if (VERSION.SDK_INT >= 18 && bluetoothSupportChecker.m19942b() && bluetoothSupportChecker.m19943c() && pulsarLocationStatusChecker.m19946a()) {
            this.f13555a = LazyFutures.m19933a().a(lazy).a(lazy2).a(new 1(this), MoreExecutors.m1813a());
        } else {
            this.f13555a = LazyFutures.m19932a(Futures.m2452a(Boolean.valueOf(false)));
        }
    }

    protected final ListenableFuture<Boolean> mo2648b() {
        return (ListenableFuture) this.f13555a.get();
    }
}
