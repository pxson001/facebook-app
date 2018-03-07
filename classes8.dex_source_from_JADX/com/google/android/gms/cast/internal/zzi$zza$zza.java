package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.JoinOptions;
import com.google.android.gms.cast.LaunchOptions;

public class zzi$zza$zza implements zzi {
    private IBinder f10172a;

    public zzi$zza$zza(IBinder iBinder) {
        this.f10172a = iBinder;
    }

    public final void mo662a() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.f10172a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo663a(double d, double d2, boolean z) {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeDouble(d);
            obtain.writeDouble(d2);
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            this.f10172a.transact(7, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo664a(String str) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(str);
            this.f10172a.transact(5, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo665a(String str, LaunchOptions launchOptions) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(str);
            if (launchOptions != null) {
                obtain.writeInt(1);
                launchOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f10172a.transact(13, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo666a(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f10172a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo667a(String str, String str2, long j) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeLong(j);
            this.f10172a.transact(9, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo668a(String str, String str2, JoinOptions joinOptions) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(str);
            obtain.writeString(str2);
            if (joinOptions != null) {
                obtain.writeInt(1);
                joinOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f10172a.transact(14, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo669a(String str, boolean z) {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(str);
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            this.f10172a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo670a(String str, byte[] bArr, long j) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(str);
            obtain.writeByteArray(bArr);
            obtain.writeLong(j);
            this.f10172a.transact(10, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo671a(boolean z, double d, boolean z2) {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeInt(z ? 1 : 0);
            obtain.writeDouble(d);
            if (!z2) {
                i = 0;
            }
            obtain.writeInt(i);
            this.f10172a.transact(8, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10172a;
    }

    public final void mo672b() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.f10172a.transact(4, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo673b(String str) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(str);
            this.f10172a.transact(11, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo674c() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.f10172a.transact(6, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo675c(String str) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(str);
            this.f10172a.transact(12, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
