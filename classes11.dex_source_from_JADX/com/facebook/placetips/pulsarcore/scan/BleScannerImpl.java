package com.facebook.placetips.pulsarcore.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.bootstrap.data.BleBroadcast;
import com.facebook.placetips.bootstrap.data.BleBroadcastSummary;
import com.facebook.placetips.bootstrap.data.BleScanResult;
import com.facebook.placetips.bootstrap.event.BleBroadcastDetectedEvent;
import com.facebook.placetips.bootstrap.event.BleScanFinishedEvent;
import com.facebook.placetips.bootstrap.event.BleScanStartedEvent;
import com.facebook.placetips.bootstrap.event.PlaceTipsEventBus;
import com.facebook.placetips.pulsarcore.bluetooth.BluetoothSupportChecker;
import com.facebook.placetips.pulsarcore.scan.BleScanException.BleNotAllowedException;
import com.facebook.placetips.pulsarcore.scan.BleScanException.BleNotSupportedException;
import com.facebook.placetips.pulsarcore.scan.BleScanException.BluetoothDiscoveryInterruptException;
import com.facebook.placetips.pulsarcore.scan.BleScanException.BluetoothTurnedOffException;
import com.facebook.placetips.pulsarcore.scan.BleScanResultBuilder.C12781;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@TargetApi(18)
/* compiled from: TOP_OVERFLOW */
public class BleScannerImpl implements BleScanner {
    public final Context f10777a;
    @Nullable
    public final Lazy<BluetoothAdapter> f10778b;
    private final Lazy<BluetoothSupportChecker> f10779c;
    public final Handler f10780d;
    private final Provider<BleScanResultBuilder> f10781e;
    public final PlaceTipsEventBus f10782f;

    /* compiled from: TOP_OVERFLOW */
    public class BleScanCallback implements LeScanCallback {
        public final /* synthetic */ BleScannerImpl f10771a;
        public final SettableFuture<BleScanResult> f10772b = SettableFuture.f();
        public final BleScanResultBuilder f10773c;
        private final BroadcastReceiver f10774d;
        private final Runnable f10775e;
        public final Runnable f10776f;

        /* compiled from: TOP_OVERFLOW */
        class BluetoothDiscoveryStartedActionReceiver implements ActionReceiver {
            final /* synthetic */ BleScanCallback f10770a;

            public BluetoothDiscoveryStartedActionReceiver(BleScanCallback bleScanCallback) {
                this.f10770a = bleScanCallback;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 306427675);
                this.f10770a.m11276a(new BluetoothDiscoveryInterruptException());
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 790945144, a);
            }
        }

        BleScanCallback(final BleScannerImpl bleScannerImpl, BleScanResultBuilder bleScanResultBuilder) {
            this.f10771a = bleScannerImpl;
            this.f10773c = bleScanResultBuilder;
            this.f10774d = new DynamicSecureBroadcastReceiver("android.bluetooth.adapter.action.DISCOVERY_STARTED", new BluetoothDiscoveryStartedActionReceiver(this));
            this.f10775e = new Runnable(this) {
                final /* synthetic */ BleScanCallback f10767b;

                public void run() {
                    BleScanCallback bleScanCallback = this.f10767b;
                    if (!bleScanCallback.f10772b.isDone()) {
                        ((BluetoothAdapter) bleScanCallback.f10771a.f10778b.get()).stopLeScan(bleScanCallback);
                        BleScanResultBuilder bleScanResultBuilder = bleScanCallback.f10773c;
                        Object obj = null;
                        long now = bleScanResultBuilder.f10761b.now() - bleScanResultBuilder.f10765f;
                        if (now > 0) {
                            if (bleScanResultBuilder.f10763d / ((int) (now / 1000)) >= 4) {
                                obj = 1;
                            }
                        }
                        if (obj != null) {
                            bleScanCallback.m11277b();
                        } else {
                            HandlerDetour.b(bleScanCallback.f10771a.f10780d, bleScanCallback.f10776f, 3000, 760770428);
                        }
                    }
                }
            };
            this.f10776f = new Runnable(this) {
                final /* synthetic */ BleScanCallback f10769b;

                public void run() {
                    this.f10769b.m11277b();
                }
            };
        }

        final ListenableFuture<BleScanResult> m11275a(long j) {
            this.f10771a.f10782f.a(new BleScanStartedEvent());
            this.f10771a.f10777a.registerReceiver(this.f10774d, new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_STARTED"));
            BleScanResultBuilder bleScanResultBuilder = this.f10773c;
            bleScanResultBuilder.f10762c = Maps.c();
            bleScanResultBuilder.f10763d = 0;
            bleScanResultBuilder.f10764e = bleScanResultBuilder.f10760a.a();
            bleScanResultBuilder.f10765f = bleScanResultBuilder.f10761b.now();
            if (((BluetoothAdapter) this.f10771a.f10778b.get()).startLeScan(this)) {
                HandlerDetour.b(this.f10771a.f10780d, this.f10775e, j, 1959637494);
            } else {
                m11276a(new BleScanException("Unknown error occurred"));
            }
            return this.f10772b;
        }

        public final void m11277b() {
            if (!this.f10772b.isDone()) {
                this.f10771a.f10777a.unregisterReceiver(this.f10774d);
                BleScanResultBuilder bleScanResultBuilder = this.f10773c;
                long j = bleScanResultBuilder.f10764e;
                long a = bleScanResultBuilder.f10760a.a();
                long now = bleScanResultBuilder.f10761b.now() - bleScanResultBuilder.f10765f;
                int i = bleScanResultBuilder.f10763d;
                List a2 = Lists.a(bleScanResultBuilder.f10762c.values());
                Collections.sort(a2, new C12781(bleScanResultBuilder));
                BleScanResult bleScanResult = new BleScanResult(a2, j, a, now, i);
                this.f10771a.f10782f.a(new BleScanFinishedEvent(bleScanResult));
                FutureDetour.a(this.f10772b, bleScanResult, -487888410);
            }
        }

        final void m11276a(Throwable th) {
            if (!this.f10772b.isDone()) {
                HandlerDetour.a(this.f10771a.f10780d, this.f10775e);
                HandlerDetour.a(this.f10771a.f10780d, this.f10776f);
                ((BluetoothAdapter) this.f10771a.f10778b.get()).stopLeScan(this);
                this.f10771a.f10777a.unregisterReceiver(this.f10774d);
                this.f10772b.a(th);
            }
        }

        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            BleBroadcast bleBroadcast = new BleBroadcast(bluetoothDevice, bArr);
            BleScanResultBuilder bleScanResultBuilder = this.f10773c;
            if (bleScanResultBuilder.f10762c.containsKey(bleBroadcast)) {
                ((BleBroadcastSummary) bleScanResultBuilder.f10762c.get(bleBroadcast)).a(i);
            } else {
                bleScanResultBuilder.f10762c.put(bleBroadcast, new BleBroadcastSummary(bleBroadcast).a(i));
            }
            bleScanResultBuilder.f10763d++;
            this.f10771a.f10782f.a(new BleBroadcastDetectedEvent(bleBroadcast, i));
        }
    }

    public static BleScannerImpl m11279b(InjectorLike injectorLike) {
        return new BleScannerImpl((Context) injectorLike.getInstance(Context.class), IdBasedLazy.a(injectorLike, 10), IdBasedLazy.a(injectorLike, 3018), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 9606), PlaceTipsEventBus.a(injectorLike));
    }

    @Inject
    public BleScannerImpl(Context context, Lazy<BluetoothAdapter> lazy, Lazy<BluetoothSupportChecker> lazy2, Handler handler, Provider<BleScanResultBuilder> provider, PlaceTipsEventBus placeTipsEventBus) {
        this.f10777a = context;
        this.f10778b = lazy;
        this.f10779c = lazy2;
        this.f10780d = handler;
        this.f10781e = provider;
        this.f10782f = placeTipsEventBus;
    }

    public final ListenableFuture<BleScanResult> mo288a(long j) {
        try {
            Preconditions.checkArgument(j > 0, "Tried to perform a BLE scan for <0 millis");
            return m11278a().m11275a(j);
        } catch (Throwable th) {
            return Futures.a(th);
        }
    }

    private BleScanCallback m11278a() {
        if (!((BluetoothSupportChecker) this.f10779c.get()).b() || this.f10778b.get() == null) {
            throw new BleNotSupportedException();
        } else if (!((BluetoothSupportChecker) this.f10779c.get()).c()) {
            throw new BleNotAllowedException();
        } else if (!((BluetoothAdapter) this.f10778b.get()).isEnabled()) {
            throw new BluetoothTurnedOffException();
        } else if (!((BluetoothAdapter) this.f10778b.get()).isDiscovering()) {
            return new BleScanCallback(this, (BleScanResultBuilder) this.f10781e.get());
        } else {
            throw new BluetoothDiscoveryInterruptException();
        }
    }
}
