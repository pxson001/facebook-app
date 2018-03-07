package com.facebook.fbservice.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: firstName */
public interface IBlueService extends IInterface {

    /* compiled from: firstName */
    public abstract class Stub extends Binder implements IBlueService {
        public Stub() {
            attachInterface(this, "com.facebook.fbservice.service.IBlueService");
        }

        public static IBlueService m32049a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.facebook.fbservice.service.IBlueService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBlueService)) {
                return new Proxy(iBinder);
            }
            return (IBlueService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            CallerContext callerContext = null;
            int i3 = 0;
            String a;
            String readString;
            boolean a2;
            switch (i) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    Bundle bundle;
                    boolean z;
                    CallerContext callerContext2;
                    parcel.enforceInterface("com.facebook.fbservice.service.IBlueService");
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (parcel.readInt() != 0) {
                        callerContext2 = (CallerContext) CallerContext.CREATOR.createFromParcel(parcel);
                    } else {
                        callerContext2 = null;
                    }
                    a = mo3498a(readString2, bundle, z, callerContext2);
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    Bundle bundle2;
                    boolean z2;
                    parcel.enforceInterface("com.facebook.fbservice.service.IBlueService");
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    }
                    ICompletionHandler a3 = com.facebook.fbservice.service.ICompletionHandler.Stub.m32072a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        callerContext = (CallerContext) CallerContext.CREATOR.createFromParcel(parcel);
                    }
                    a = mo3499a(readString, bundle2, z2, a3, callerContext);
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 3:
                    parcel.enforceInterface("com.facebook.fbservice.service.IBlueService");
                    a2 = mo3500a(parcel.readString());
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    RequestPriority requestPriority;
                    parcel.enforceInterface("com.facebook.fbservice.service.IBlueService");
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        requestPriority = (RequestPriority) RequestPriority.CREATOR.createFromParcel(parcel);
                    } else {
                        requestPriority = null;
                    }
                    a2 = mo3502a(readString, requestPriority);
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.facebook.fbservice.service.IBlueService");
                    a2 = mo3501a(parcel.readString(), com.facebook.fbservice.service.ICompletionHandler.Stub.m32072a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.facebook.fbservice.service.IBlueService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String mo3498a(String str, Bundle bundle, boolean z, CallerContext callerContext);

    String mo3499a(String str, Bundle bundle, boolean z, ICompletionHandler iCompletionHandler, CallerContext callerContext);

    boolean mo3500a(String str);

    boolean mo3501a(String str, ICompletionHandler iCompletionHandler);

    boolean mo3502a(String str, RequestPriority requestPriority);
}
