package com.facebook.placetips.pulsarcore.service;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: TEXT_HEADER_VIEW */
public class C1281xd0395591 implements ActionReceiver {
    @Inject
    public BluetoothDiscoveryInterruptHandler f10786a;

    private static <T extends InjectableComponentWithoutContext> void m11284a(Class<T> cls, T t, Context context) {
        C1281xd0395591.m11285a(t, context);
    }

    public static void m11285a(Object obj, Context context) {
        ((C1281xd0395591) obj).f10786a = BluetoothDiscoveryInterruptHandler.m11282b(FbInjector.get(context));
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 288460795);
        Class cls = C1281xd0395591.class;
        C1281xd0395591.m11285a(this, context);
        BluetoothDiscoveryInterruptHandler bluetoothDiscoveryInterruptHandler = this.f10786a;
        bluetoothDiscoveryInterruptHandler.f10783a.a("Bluetooth discovery finished, disabling receiver and starting ble scan");
        bluetoothDiscoveryInterruptHandler.f10785c.a();
        bluetoothDiscoveryInterruptHandler.f10784b.a(false);
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1824942287, a);
    }

    private void m11283a(BluetoothDiscoveryInterruptHandler bluetoothDiscoveryInterruptHandler) {
        this.f10786a = bluetoothDiscoveryInterruptHandler;
    }
}
