package com.facebook.push.mqtt.ipc;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* compiled from: sourceRotationDegreesClockwise */
class IMqttPushService$Stub$Proxy implements IMqttPushService {
    private IBinder f4273a;

    IMqttPushService$Stub$Proxy(IBinder iBinder) {
        this.f4273a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4273a;
    }

    public final void m6364a(MqttChannelStateListener mqttChannelStateListener) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeStrongBinder(mqttChannelStateListener != null ? mqttChannelStateListener.asBinder() : null);
            this.f4273a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m6374b(MqttChannelStateListener mqttChannelStateListener) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeStrongBinder(mqttChannelStateListener != null ? mqttChannelStateListener.asBinder() : null);
            this.f4273a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m6370a() {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            this.f4273a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m6376b() {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            this.f4273a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m6371a(long j) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeLong(j);
            this.f4273a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m6365a(SyncQueueTracker syncQueueTracker) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeStrongBinder(syncQueueTracker != null ? syncQueueTracker.asBinder() : null);
            this.f4273a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int m6363a(String str, byte[] bArr, int i, MqttPublishListener mqttPublishListener) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeString(str);
            obtain.writeByteArray(bArr);
            obtain.writeInt(i);
            obtain.writeStrongBinder(mqttPublishListener != null ? mqttPublishListener.asBinder() : null);
            this.f4273a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m6372a(String str, byte[] bArr, long j, MqttPublishListener mqttPublishListener, long j2) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeString(str);
            obtain.writeByteArray(bArr);
            obtain.writeLong(j);
            obtain.writeStrongBinder(mqttPublishListener != null ? mqttPublishListener.asBinder() : null);
            obtain.writeLong(j2);
            this.f4273a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m6373a(String str, byte[] bArr, long j, MqttPublishListener mqttPublishListener, long j2, String str2) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeString(str);
            obtain.writeByteArray(bArr);
            obtain.writeLong(j);
            obtain.writeStrongBinder(mqttPublishListener != null ? mqttPublishListener.asBinder() : null);
            obtain.writeLong(j2);
            obtain.writeString(str2);
            this.f4273a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m6367a(List<SubscribeTopic> list, MqttPublishArrivedListener mqttPublishArrivedListener) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeTypedList(list);
            obtain.writeStrongBinder(mqttPublishArrivedListener != null ? mqttPublishArrivedListener.asBinder() : null);
            this.f4273a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m6375b(List<String> list, MqttPublishArrivedListener mqttPublishArrivedListener) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeStringList(list);
            obtain.writeStrongBinder(mqttPublishArrivedListener != null ? mqttPublishArrivedListener.asBinder() : null);
            this.f4273a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m6378c(List<String> list, MqttPublishArrivedListener mqttPublishArrivedListener) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeStringList(list);
            obtain.writeStrongBinder(mqttPublishArrivedListener != null ? mqttPublishArrivedListener.asBinder() : null);
            this.f4273a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m6380d(List<String> list, MqttPublishArrivedListener mqttPublishArrivedListener) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeStringList(list);
            obtain.writeStrongBinder(mqttPublishArrivedListener != null ? mqttPublishArrivedListener.asBinder() : null);
            this.f4273a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m6366a(List<StickySubscribeTopic> list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            obtain.writeTypedList(list);
            this.f4273a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m6368a(boolean z) {
        int i = 0;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            if (z) {
                i = 1;
            }
            obtain.writeInt(i);
            this.f4273a.transact(15, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m6369a(boolean z, List<SubscribeTopic> list, List<String> list2) {
        int i = 0;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            if (z) {
                i = 1;
            }
            obtain.writeInt(i);
            obtain.writeTypedList(list);
            obtain.writeStringList(list2);
            this.f4273a.transact(16, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final String m6377c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            this.f4273a.transact(17, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final String m6379d() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            this.f4273a.transact(18, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final String m6381e() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            this.f4273a.transact(19, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final MqttChannelStateInfo m6382f() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            MqttChannelStateInfo mqttChannelStateInfo;
            obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.IMqttPushService");
            this.f4273a.transact(20, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                mqttChannelStateInfo = (MqttChannelStateInfo) MqttChannelStateInfo.CREATOR.createFromParcel(obtain2);
            } else {
                mqttChannelStateInfo = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return mqttChannelStateInfo;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
