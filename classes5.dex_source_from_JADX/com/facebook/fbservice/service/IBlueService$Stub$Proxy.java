package com.facebook.fbservice.service;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.interfaces.RequestPriority;

/* compiled from: response_responders */
class IBlueService$Stub$Proxy implements IBlueService {
    private IBinder f3053a;

    IBlueService$Stub$Proxy(IBinder iBinder) {
        this.f3053a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3053a;
    }

    public final String m4205a(String str, Bundle bundle, boolean z, CallerContext callerContext) {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.fbservice.service.IBlueService");
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            if (callerContext != null) {
                obtain.writeInt(1);
                callerContext.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3053a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final String m4206a(String str, Bundle bundle, boolean z, ICompletionHandler iCompletionHandler, CallerContext callerContext) {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.fbservice.service.IBlueService");
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            obtain.writeStrongBinder(iCompletionHandler != null ? iCompletionHandler.asBinder() : null);
            if (callerContext != null) {
                obtain.writeInt(1);
                callerContext.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3053a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m4207a(String str) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.fbservice.service.IBlueService");
            obtain.writeString(str);
            this.f3053a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m4209a(String str, RequestPriority requestPriority) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.fbservice.service.IBlueService");
            obtain.writeString(str);
            if (requestPriority != null) {
                obtain.writeInt(1);
                requestPriority.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3053a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m4208a(String str, ICompletionHandler iCompletionHandler) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.fbservice.service.IBlueService");
            obtain.writeString(str);
            obtain.writeStrongBinder(iCompletionHandler != null ? iCompletionHandler.asBinder() : null);
            this.f3053a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
