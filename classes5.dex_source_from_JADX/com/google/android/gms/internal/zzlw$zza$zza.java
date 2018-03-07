package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.clearcut.LogEventParcelable;

public class zzlw$zza$zza implements zzlw {
    private IBinder f6829a;

    public zzlw$zza$zza(IBinder iBinder) {
        this.f6829a = iBinder;
    }

    public final void mo823a(zzlv com_google_android_gms_internal_zzlv, LogEventParcelable logEventParcelable) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            if (com_google_android_gms_internal_zzlv != null) {
                iBinder = com_google_android_gms_internal_zzlv.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            if (logEventParcelable != null) {
                obtain.writeInt(1);
                logEventParcelable.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6829a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6829a;
    }
}
