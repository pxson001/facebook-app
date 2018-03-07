package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_receive */
public class UploadBulkFetchContactsResult implements Parcelable {
    public static final Creator<UploadBulkFetchContactsResult> CREATOR = new C05531();
    public final UploadBulkContactsResult f8480a;
    public final FetchContactsResult f8481b;

    /* compiled from: p2p_receive */
    final class C05531 implements Creator<UploadBulkFetchContactsResult> {
        C05531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadBulkFetchContactsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadBulkFetchContactsResult[i];
        }
    }

    public UploadBulkFetchContactsResult(UploadBulkContactsResult uploadBulkContactsResult, @Nullable FetchContactsResult fetchContactsResult) {
        this.f8480a = uploadBulkContactsResult;
        this.f8481b = fetchContactsResult;
    }

    public UploadBulkFetchContactsResult(Parcel parcel) {
        this.f8480a = (UploadBulkContactsResult) parcel.readParcelable(UploadBulkContactsResult.class.getClassLoader());
        this.f8481b = (FetchContactsResult) parcel.readParcelable(FetchContactsResult.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8480a, i);
        parcel.writeParcelable(this.f8481b, i);
    }
}
