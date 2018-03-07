package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public class zzu$zza$zza implements zzu {
    private IBinder f6588a;

    public zzu$zza$zza(IBinder iBinder) {
        this.f6588a = iBinder;
    }

    public final zzd mo794a(zzd com_google_android_gms_dynamic_zzd, int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
            obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f6588a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            zzd a = zza.m12697a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final zzd mo795a(zzd com_google_android_gms_dynamic_zzd, SignInButtonConfig signInButtonConfig) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
            obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
            if (signInButtonConfig != null) {
                obtain.writeInt(1);
                signInButtonConfig.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6588a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            zzd a = zza.m12697a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6588a;
    }
}
