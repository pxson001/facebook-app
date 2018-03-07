package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_request */
public class UploadBulkContactsResult extends BaseResult implements Parcelable {
    public static final Creator<UploadBulkContactsResult> CREATOR = new C05521();
    private final String f8478a;
    public final ImmutableList<UploadBulkContactChangeResult> f8479b;

    /* compiled from: p2p_request */
    final class C05521 implements Creator<UploadBulkContactsResult> {
        C05521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadBulkContactsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadBulkContactsResult[i];
        }
    }

    public UploadBulkContactsResult(String str, ImmutableList<UploadBulkContactChangeResult> immutableList, DataFreshnessResult dataFreshnessResult, long j) {
        super(dataFreshnessResult, j);
        this.f8478a = str;
        this.f8479b = immutableList;
    }

    public UploadBulkContactsResult(Parcel parcel) {
        super(parcel);
        this.f8478a = parcel.readString();
        this.f8479b = ImmutableList.copyOf(parcel.readArrayList(UploadBulkContactsResult.class.getClassLoader()));
    }

    public final String m12302c() {
        return this.f8478a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f8478a);
        parcel.writeList(this.f8479b);
    }

    public String toString() {
        return "UploadBulkContactsResult<" + this.f8478a + ">: " + this.f8479b;
    }
}
