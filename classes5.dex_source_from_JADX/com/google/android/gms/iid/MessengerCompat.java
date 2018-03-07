package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR = new C07861();
    Messenger f6810a;
    zzb f6811b;

    final class C07861 implements Creator<MessengerCompat> {
        C07861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
        }

        public final Object[] newArray(int i) {
            return new MessengerCompat[i];
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.f6810a = new Messenger(iBinder);
            return;
        }
        zzb com_google_android_gms_iid_zzb;
        if (iBinder == null) {
            com_google_android_gms_iid_zzb = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            com_google_android_gms_iid_zzb = (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new zzb$zza$zza(iBinder) : (zzb) queryLocalInterface;
        }
        this.f6811b = com_google_android_gms_iid_zzb;
    }

    private IBinder m12713a() {
        return this.f6810a != null ? this.f6810a.getBinder() : this.f6811b.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = m12713a().equals(((MessengerCompat) obj).m12713a());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        return m12713a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f6810a != null) {
            parcel.writeStrongBinder(this.f6810a.getBinder());
        } else {
            parcel.writeStrongBinder(this.f6811b.asBinder());
        }
    }
}
