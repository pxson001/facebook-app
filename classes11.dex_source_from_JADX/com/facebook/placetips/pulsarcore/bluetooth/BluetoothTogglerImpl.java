package com.facebook.placetips.pulsarcore.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.pulsarcore.BluetoothAdapterMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.util.concurrent.SettableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: The ViewPager must be bound before changing items */
public class BluetoothTogglerImpl {
    private final Context f10694a;
    @Nullable
    private final BluetoothAdapter f10695b;
    private final BluetoothSupportChecker f10696c;
    private final SecureContextHelper f10697d;
    private final Handler f10698e;
    private BroadcastReceiver f10699f = null;
    private SettableFuture<Boolean> f10700g = null;
    private final ActionReceiver f10701h = new C12661(this);

    /* compiled from: The ViewPager must be bound before changing items */
    class C12661 implements ActionReceiver {
        final /* synthetic */ BluetoothTogglerImpl f10691a;

        C12661(BluetoothTogglerImpl bluetoothTogglerImpl) {
            this.f10691a = bluetoothTogglerImpl;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -289222622);
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)) {
                case 10:
                    BluetoothTogglerImpl.m11196a(this.f10691a, false);
                    break;
                case 12:
                    BluetoothTogglerImpl.m11196a(this.f10691a, true);
                    break;
            }
            LogUtils.e(-1914663428, a);
        }
    }

    private static BluetoothTogglerImpl m11197b(InjectorLike injectorLike) {
        return new BluetoothTogglerImpl((Context) injectorLike.getInstance(Context.class), BluetoothAdapterMethodAutoProvider.m11174b(injectorLike), BluetoothSupportChecker.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public BluetoothTogglerImpl(Context context, BluetoothAdapter bluetoothAdapter, BluetoothSupportChecker bluetoothSupportChecker, SecureContextHelper secureContextHelper, Handler handler) {
        this.f10694a = context;
        this.f10695b = bluetoothAdapter;
        this.f10696c = bluetoothSupportChecker;
        this.f10697d = secureContextHelper;
        this.f10698e = handler;
    }

    public static synchronized void m11196a(BluetoothTogglerImpl bluetoothTogglerImpl, final boolean z) {
        synchronized (bluetoothTogglerImpl) {
            if (bluetoothTogglerImpl.f10699f != null) {
                bluetoothTogglerImpl.f10694a.unregisterReceiver(bluetoothTogglerImpl.f10699f);
                bluetoothTogglerImpl.f10699f = null;
            }
            HandlerDetour.b(bluetoothTogglerImpl.f10698e, new Runnable(bluetoothTogglerImpl) {
                final /* synthetic */ BluetoothTogglerImpl f10693b;

                public void run() {
                    BluetoothTogglerImpl.m11198b(this.f10693b, z);
                }
            }, 1000, 1762857403);
        }
    }

    public static synchronized void m11198b(BluetoothTogglerImpl bluetoothTogglerImpl, boolean z) {
        synchronized (bluetoothTogglerImpl) {
            if (bluetoothTogglerImpl.f10700g != null) {
                FutureDetour.a(bluetoothTogglerImpl.f10700g, Boolean.valueOf(z), 898469007);
                bluetoothTogglerImpl.f10700g = null;
            }
        }
    }
}
