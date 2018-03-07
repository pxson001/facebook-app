package com.facebook.push.mqtt.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: server_port */
public interface MqttPublishArrivedListener extends IInterface {

    /* compiled from: server_port */
    public abstract class Stub extends Binder implements MqttPublishArrivedListener {
        public Stub() {
            attachInterface(this, "com.facebook.push.mqtt.ipc.MqttPublishArrivedListener");
        }

        public static MqttPublishArrivedListener m9416a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.facebook.push.mqtt.ipc.MqttPublishArrivedListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof MqttPublishArrivedListener)) {
                return new Proxy(iBinder);
            }
            return (MqttPublishArrivedListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    Bundle bundle;
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.MqttPublishArrivedListener");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    mo1351a(bundle);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.facebook.push.mqtt.ipc.MqttPublishArrivedListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo1351a(Bundle bundle);
}
