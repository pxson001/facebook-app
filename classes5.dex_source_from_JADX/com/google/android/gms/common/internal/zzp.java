package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface zzp extends IInterface {

    public abstract class zza extends Binder implements zzp {

        class zza implements zzp {
            private IBinder f6584a;

            zza(IBinder iBinder) {
                this.f6584a = iBinder;
            }

            public final Account mo741a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
                    this.f6584a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    Account account = obtain2.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return account;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6584a;
            }
        }

        public static zzp m12262a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzp)) ? new zza(iBinder) : (zzp) queryLocalInterface;
        }
    }

    Account mo741a();
}
