package com.google.android.gms.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public interface zzd extends IInterface {

    public abstract class zza extends Binder implements zzd {
        public zza() {
            attachInterface(this, "com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
                    mo864a(parcel.readString(), parcel.createTypedArrayList(Scope.CREATOR), com.google.android.gms.signin.internal.zzf.zza.m13129a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
                    mo863a(parcel.readString(), parcel.readString(), com.google.android.gms.signin.internal.zzf.zza.m13129a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo863a(String str, String str2, zzf com_google_android_gms_signin_internal_zzf);

    void mo864a(String str, List<Scope> list, zzf com_google_android_gms_signin_internal_zzf);
}
