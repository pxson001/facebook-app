package com.facebook.push.mqtt.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: sounds/ */
public interface MqttPublishListener extends IInterface {

    /* compiled from: sounds/ */
    public abstract class Stub extends Binder implements MqttPublishListener {

        /* compiled from: sounds/ */
        class Proxy implements MqttPublishListener {
            private IBinder f4276a;

            Proxy(IBinder iBinder) {
                this.f4276a = iBinder;
            }

            public IBinder asBinder() {
                return this.f4276a;
            }

            public final void mo298a() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.MqttPublishListener");
                    this.f4276a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo299b() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.MqttPublishListener");
                    this.f4276a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.facebook.push.mqtt.ipc.MqttPublishListener");
        }

        public static MqttPublishListener m6390a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.facebook.push.mqtt.ipc.MqttPublishListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof MqttPublishListener)) {
                return new Proxy(iBinder);
            }
            return (MqttPublishListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.MqttPublishListener");
                    mo298a();
                    return true;
                case 2:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.MqttPublishListener");
                    mo299b();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.facebook.push.mqtt.ipc.MqttPublishListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo298a();

    void mo299b();
}
