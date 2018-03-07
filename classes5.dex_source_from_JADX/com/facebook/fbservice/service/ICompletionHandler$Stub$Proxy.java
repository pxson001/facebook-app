package com.facebook.fbservice.service;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: response_options */
class ICompletionHandler$Stub$Proxy implements ICompletionHandler {
    private IBinder f3054a;

    ICompletionHandler$Stub$Proxy(IBinder iBinder) {
        this.f3054a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3054a;
    }

    public final void m4210a(OperationResult operationResult) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.fbservice.service.ICompletionHandler");
            if (operationResult != null) {
                obtain.writeInt(1);
                operationResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3054a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m4211b(OperationResult operationResult) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.fbservice.service.ICompletionHandler");
            if (operationResult != null) {
                obtain.writeInt(1);
                operationResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3054a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
