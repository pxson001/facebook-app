package android.support.v4.app;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: wifi_power */
public class INotificationSideChannel$Stub$Proxy implements INotificationSideChannel {
    private IBinder f133a;

    public INotificationSideChannel$Stub$Proxy(IBinder iBinder) {
        this.f133a = iBinder;
    }

    public IBinder asBinder() {
        return this.f133a;
    }

    public final void mo17a(String str, int i, String str2, Notification notification) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeString(str2);
            if (notification != null) {
                obtain.writeInt(1);
                notification.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f133a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo16a(String str, int i, String str2) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeString(str2);
            this.f133a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo15a(String str) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            obtain.writeString(str);
            this.f133a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
