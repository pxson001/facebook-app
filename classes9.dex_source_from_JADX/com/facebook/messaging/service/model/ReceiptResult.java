package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.messaging.model.threads.ThreadSummary;

/* compiled from: contacts_persist/ */
public class ReceiptResult implements Parcelable {
    public static final Creator<ReceiptResult> CREATOR = new C20461();
    public final DataFetchDisposition f17269a;
    public final ThreadSummary f17270b;
    public final long f17271c;

    /* compiled from: contacts_persist/ */
    final class C20461 implements Creator<ReceiptResult> {
        C20461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReceiptResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReceiptResult[i];
        }
    }

    public ReceiptResult(DataFetchDisposition dataFetchDisposition, ThreadSummary threadSummary, long j) {
        this.f17269a = dataFetchDisposition;
        this.f17270b = threadSummary;
        this.f17271c = j;
    }

    public ReceiptResult(Parcel parcel) {
        this.f17269a = (DataFetchDisposition) parcel.readParcelable(DataFetchDisposition.class.getClassLoader());
        this.f17270b = (ThreadSummary) parcel.readParcelable(ThreadSummary.class.getClassLoader());
        this.f17271c = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17269a, i);
        parcel.writeParcelable(this.f17270b, i);
        parcel.writeLong(this.f17271c);
    }
}
