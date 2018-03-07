package com.facebook.fbservice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: findfriends?ci_flow=%s&ccu_ref=%s&force_show_legal_screen=true */
public interface ICompletionHandler extends IInterface {

    /* compiled from: findfriends?ci_flow=%s&ccu_ref=%s&force_show_legal_screen=true */
    public abstract class Stub extends Binder implements ICompletionHandler {
        public Stub() {
            attachInterface(this, "com.facebook.fbservice.service.ICompletionHandler");
        }

        public static ICompletionHandler m32072a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.facebook.fbservice.service.ICompletionHandler");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ICompletionHandler)) {
                return new Proxy(iBinder);
            }
            return (ICompletionHandler) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            OperationResult operationResult = null;
            switch (i) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    parcel.enforceInterface("com.facebook.fbservice.service.ICompletionHandler");
                    if (parcel.readInt() != 0) {
                        operationResult = (OperationResult) OperationResult.CREATOR.createFromParcel(parcel);
                    }
                    mo3503a(operationResult);
                    parcel2.writeNoException();
                    return true;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    parcel.enforceInterface("com.facebook.fbservice.service.ICompletionHandler");
                    if (parcel.readInt() != 0) {
                        operationResult = (OperationResult) OperationResult.CREATOR.createFromParcel(parcel);
                    }
                    mo3504b(operationResult);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.facebook.fbservice.service.ICompletionHandler");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo3503a(OperationResult operationResult);

    void mo3504b(OperationResult operationResult);
}
