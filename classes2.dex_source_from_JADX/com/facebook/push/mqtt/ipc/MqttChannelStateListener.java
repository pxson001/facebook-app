package com.facebook.push.mqtt.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: prompts_server_controls_initial_state */
public interface MqttChannelStateListener extends IInterface {

    /* compiled from: prompts_server_controls_initial_state */
    public abstract class Stub extends Binder implements MqttChannelStateListener {
        public Stub() {
            attachInterface(this, "com.facebook.push.mqtt.ipc.MqttChannelStateListener");
        }

        public static MqttChannelStateListener m13557a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.facebook.push.mqtt.ipc.MqttChannelStateListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof MqttChannelStateListener)) {
                return new Proxy(iBinder);
            }
            return (MqttChannelStateListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    MqttChannelStateInfo mqttChannelStateInfo;
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.MqttChannelStateListener");
                    if (parcel.readInt() != 0) {
                        mqttChannelStateInfo = (MqttChannelStateInfo) MqttChannelStateInfo.CREATOR.createFromParcel(parcel);
                    } else {
                        mqttChannelStateInfo = null;
                    }
                    mo1826a(mqttChannelStateInfo);
                    return true;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.MqttChannelStateListener");
                    mo1825a();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.facebook.push.mqtt.ipc.MqttChannelStateListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo1825a();

    void mo1826a(MqttChannelStateInfo mqttChannelStateInfo);
}
