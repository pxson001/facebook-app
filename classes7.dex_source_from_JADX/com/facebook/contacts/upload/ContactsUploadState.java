package com.facebook.contacts.upload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: tapped_directions_button */
public final class ContactsUploadState implements Parcelable {
    public static final Creator<ContactsUploadState> CREATOR = new C02241();
    public final Status f2185a;
    public final int f2186b;
    public final int f2187c;
    public final int f2188d;
    private final OperationResult f2189e;
    private final ServiceException f2190f;

    /* compiled from: tapped_directions_button */
    final class C02241 implements Creator<ContactsUploadState> {
        C02241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContactsUploadState(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContactsUploadState[i];
        }
    }

    /* compiled from: tapped_directions_button */
    public enum Status {
        NOT_STARTED,
        RUNNING,
        SUCCEEDED,
        FAILED
    }

    public ContactsUploadState(Status status, int i, int i2, int i3, @Nullable OperationResult operationResult, @Nullable ServiceException serviceException) {
        Preconditions.checkArgument(status != null);
        this.f2185a = status;
        this.f2186b = i;
        this.f2187c = i2;
        this.f2188d = i3;
        this.f2189e = operationResult;
        this.f2190f = serviceException;
    }

    public ContactsUploadState(Parcel parcel) {
        this.f2185a = (Status) Enum.valueOf(Status.class, parcel.readString());
        this.f2186b = parcel.readInt();
        this.f2187c = parcel.readInt();
        this.f2188d = parcel.readInt();
        this.f2189e = (OperationResult) parcel.readParcelable(OperationResult.class.getClassLoader());
        this.f2190f = (ServiceException) parcel.readParcelable(ServiceException.class.getClassLoader());
    }

    public static ContactsUploadState m2132e() {
        return new ContactsUploadState(Status.NOT_STARTED, 0, 0, 0, null, null);
    }

    public static ContactsUploadState m2131a(int i, int i2, int i3) {
        return new ContactsUploadState(Status.RUNNING, i, i2, i3, null, null);
    }

    public static ContactsUploadState m2133f() {
        return new ContactsUploadState(Status.FAILED, 0, 0, 0, null, null);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2185a.toString());
        parcel.writeInt(this.f2186b);
        parcel.writeInt(this.f2187c);
        parcel.writeInt(this.f2188d);
        parcel.writeParcelable(this.f2189e, 0);
        parcel.writeParcelable(this.f2190f, 0);
    }

    public final String toString() {
        return "ContactsUploadState (" + this.f2185a + ") (processed/matched/total): " + this.f2186b + "/" + this.f2187c + "/" + this.f2188d;
    }
}
