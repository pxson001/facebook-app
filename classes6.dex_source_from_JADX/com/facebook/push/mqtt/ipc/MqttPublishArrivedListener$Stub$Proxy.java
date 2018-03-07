package com.facebook.push.mqtt.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: sounds_preferences/ */
class MqttPublishArrivedListener$Stub$Proxy implements MqttPublishArrivedListener {
    private IBinder f4275a;

    MqttPublishArrivedListener$Stub$Proxy(IBinder iBinder) {
        this.f4275a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4275a;
    }

    public final void m6385a(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.MqttPublishArrivedListener");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4275a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
