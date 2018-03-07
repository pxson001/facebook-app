package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.user.model.UserKey;

/* compiled from: contentAppAttribution.appId */
public class ReadReceiptParams implements Parcelable {
    public static final Creator<ReadReceiptParams> CREATOR = new C20451();
    public final ThreadSummary f17266a;
    public final UserKey f17267b;
    public final long f17268c;

    /* compiled from: contentAppAttribution.appId */
    final class C20451 implements Creator<ReadReceiptParams> {
        C20451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReadReceiptParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReadReceiptParams[i];
        }
    }

    public ReadReceiptParams(Parcel parcel) {
        this.f17266a = (ThreadSummary) parcel.readParcelable(ThreadSummary.class.getClassLoader());
        this.f17267b = UserKey.a(parcel.readString());
        this.f17268c = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17266a, i);
        parcel.writeString(this.f17267b.c());
        parcel.writeLong(this.f17268c);
    }
}
