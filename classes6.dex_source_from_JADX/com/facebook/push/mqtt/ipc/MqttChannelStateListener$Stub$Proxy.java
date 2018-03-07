package com.facebook.push.mqtt.ipc;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: sourceHeight */
class MqttChannelStateListener$Stub$Proxy implements MqttChannelStateListener {
    private IBinder f4274a;

    MqttChannelStateListener$Stub$Proxy(IBinder iBinder) {
        this.f4274a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4274a;
    }

    public final void m6384a(MqttChannelStateInfo mqttChannelStateInfo) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.MqttChannelStateListener");
            if (mqttChannelStateInfo != null) {
                obtain.writeInt(1);
                mqttChannelStateInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4274a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void m6383a() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.MqttChannelStateListener");
            this.f4274a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
