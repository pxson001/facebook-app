package com.facebook.fbservice.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: in_sticker_tray */
public class ServiceException extends Exception implements Parcelable {
    public static final Creator<ServiceException> CREATOR = new C04711();
    public final ErrorCode errorCode;
    public final OperationResult result;

    /* compiled from: in_sticker_tray */
    final class C04711 implements Creator<ServiceException> {
        C04711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ServiceException(parcel);
        }

        public final Object[] newArray(int i) {
            return new ServiceException[i];
        }
    }

    public static ServiceException m10950a(Throwable th) {
        if (th instanceof ServiceException) {
            return (ServiceException) th;
        }
        return new ServiceException(OperationResult.a(ErrorCodeUtil.m10889a(th), ErrorCodeUtil.m10890b(th), th));
    }

    public ServiceException(OperationResult operationResult) {
        super(operationResult.e + ": " + operationResult.f, operationResult.g);
        this.errorCode = operationResult.e;
        this.result = operationResult;
    }

    public ServiceException(Parcel parcel) {
        this.errorCode = (ErrorCode) parcel.readSerializable();
        this.result = (OperationResult) parcel.readParcelable(OperationResult.class.getClassLoader());
    }

    public final ErrorCode m10951a() {
        return this.errorCode;
    }

    public final OperationResult m10952b() {
        return this.result;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.errorCode);
        parcel.writeParcelable(this.result, i);
    }
}
