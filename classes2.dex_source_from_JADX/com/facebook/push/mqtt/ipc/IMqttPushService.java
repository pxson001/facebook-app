package com.facebook.push.mqtt.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.List;

/* compiled from: fr_FR */
public interface IMqttPushService extends IInterface {

    /* compiled from: fr_FR */
    public abstract class Stub extends Binder implements IMqttPushService {
        public Stub() {
            attachInterface(this, "com.facebook.push.mqtt.ipc.IMqttPushService");
        }

        public static IMqttPushService m31615a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMqttPushService)) {
                return new Proxy(iBinder);
            }
            return (IMqttPushService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            boolean a;
            int i3;
            String c;
            switch (i) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    mo3416a(com.facebook.push.mqtt.ipc.MqttChannelStateListener.Stub.m13557a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    mo3426b(com.facebook.push.mqtt.ipc.MqttChannelStateListener.Stub.m13557a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    a = mo3422a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    a = mo3428b();
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    a = mo3423a(parcel.readLong());
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    mo3417a(com.facebook.push.mqtt.ipc.SyncQueueTracker.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    int a2 = mo3415a(parcel.readString(), parcel.createByteArray(), parcel.readInt(), com.facebook.push.mqtt.ipc.MqttPublishListener.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    return true;
                case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    a = mo3424a(parcel.readString(), parcel.createByteArray(), parcel.readLong(), com.facebook.push.mqtt.ipc.MqttPublishListener.Stub.a(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    a = mo3425a(parcel.readString(), parcel.createByteArray(), parcel.readLong(), com.facebook.push.mqtt.ipc.MqttPublishListener.Stub.a(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    mo3419a(parcel.createTypedArrayList(SubscribeTopic.CREATOR), com.facebook.push.mqtt.ipc.MqttPublishArrivedListener.Stub.m9416a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    mo3427b(parcel.createStringArrayList(), com.facebook.push.mqtt.ipc.MqttPublishArrivedListener.Stub.m9416a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    mo3430c(parcel.createStringArrayList(), com.facebook.push.mqtt.ipc.MqttPublishArrivedListener.Stub.m9416a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    mo3432d(parcel.createStringArrayList(), com.facebook.push.mqtt.ipc.MqttPublishArrivedListener.Stub.m9416a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    mo3418a(parcel.createTypedArrayList(StickySubscribeTopic.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo3420a(z);
                    parcel2.writeNoException();
                    return true;
                case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo3421a(z, parcel.createTypedArrayList(SubscribeTopic.CREATOR), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    c = mo3429c();
                    parcel2.writeNoException();
                    parcel2.writeString(c);
                    return true;
                case 18:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    c = mo3431d();
                    parcel2.writeNoException();
                    parcel2.writeString(c);
                    return true;
                case 19:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    c = mo3433e();
                    parcel2.writeNoException();
                    parcel2.writeString(c);
                    return true;
                case 20:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.IMqttPushService");
                    MqttChannelStateInfo f = mo3434f();
                    parcel2.writeNoException();
                    if (f != null) {
                        parcel2.writeInt(1);
                        f.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.facebook.push.mqtt.ipc.IMqttPushService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int mo3415a(String str, byte[] bArr, int i, MqttPublishListener mqttPublishListener);

    void mo3416a(MqttChannelStateListener mqttChannelStateListener);

    void mo3417a(SyncQueueTracker syncQueueTracker);

    void mo3418a(List<StickySubscribeTopic> list);

    void mo3419a(List<SubscribeTopic> list, MqttPublishArrivedListener mqttPublishArrivedListener);

    void mo3420a(boolean z);

    void mo3421a(boolean z, List<SubscribeTopic> list, List<String> list2);

    boolean mo3422a();

    boolean mo3423a(long j);

    boolean mo3424a(String str, byte[] bArr, long j, MqttPublishListener mqttPublishListener, long j2);

    boolean mo3425a(String str, byte[] bArr, long j, MqttPublishListener mqttPublishListener, long j2, String str2);

    void mo3426b(MqttChannelStateListener mqttChannelStateListener);

    void mo3427b(List<String> list, MqttPublishArrivedListener mqttPublishArrivedListener);

    boolean mo3428b();

    String mo3429c();

    void mo3430c(List<String> list, MqttPublishArrivedListener mqttPublishArrivedListener);

    String mo3431d();

    void mo3432d(List<String> list, MqttPublishArrivedListener mqttPublishArrivedListener);

    String mo3433e();

    MqttChannelStateInfo mo3434f();
}
