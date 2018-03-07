package com.facebook.push.mqtt.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* compiled from: sound_ */
public interface SyncQueueTracker extends IInterface {

    /* compiled from: sound_ */
    public abstract class Stub extends Binder implements SyncQueueTracker {

        /* compiled from: sound_ */
        class Proxy implements SyncQueueTracker {
            private IBinder f4277a;

            Proxy(IBinder iBinder) {
                this.f4277a = iBinder;
            }

            public IBinder asBinder() {
                return this.f4277a;
            }

            public final List mo300a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.SyncQueueTracker");
                    this.f4277a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    List readArrayList = obtain2.readArrayList(getClass().getClassLoader());
                    return readArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo301b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.facebook.push.mqtt.ipc.SyncQueueTracker");
                    this.f4277a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.facebook.push.mqtt.ipc.SyncQueueTracker");
        }

        public static SyncQueueTracker m6395a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.facebook.push.mqtt.ipc.SyncQueueTracker");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof SyncQueueTracker)) {
                return new Proxy(iBinder);
            }
            return (SyncQueueTracker) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.SyncQueueTracker");
                    List a = mo300a();
                    parcel2.writeNoException();
                    parcel2.writeList(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.facebook.push.mqtt.ipc.SyncQueueTracker");
                    mo301b();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.facebook.push.mqtt.ipc.SyncQueueTracker");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    List mo300a();

    void mo301b();
}
