package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.messaging.model.messages.Message;

/* compiled from: createGroup */
public class FetchMessageResult extends BaseResult implements Parcelable {
    public static final Creator<FetchMessageResult> CREATOR = new C20141();
    public final Message f17065a;

    /* compiled from: createGroup */
    final class C20141 implements Creator<FetchMessageResult> {
        C20141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMessageResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMessageResult[i];
        }
    }

    public FetchMessageResult(DataFreshnessResult dataFreshnessResult, Message message, long j) {
        super(dataFreshnessResult, j);
        this.f17065a = message;
    }

    public FetchMessageResult(Parcel parcel) {
        super(parcel);
        this.f17065a = (Message) parcel.readParcelable(Message.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f17065a, i);
    }
}
