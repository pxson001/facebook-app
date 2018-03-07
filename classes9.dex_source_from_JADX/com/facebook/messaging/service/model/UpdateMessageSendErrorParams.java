package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: confirmation_data */
public class UpdateMessageSendErrorParams implements Parcelable {
    public static final Creator<UpdateMessageSendErrorParams> CREATOR = new C20651();
    public final SendError f17340a;
    public final String f17341b;
    public final ThreadKey f17342c;

    /* compiled from: confirmation_data */
    final class C20651 implements Creator<UpdateMessageSendErrorParams> {
        C20651() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpdateMessageSendErrorParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpdateMessageSendErrorParams[i];
        }
    }

    public UpdateMessageSendErrorParams(Parcel parcel) {
        this.f17340a = (SendError) parcel.readParcelable(SendError.class.getClassLoader());
        this.f17341b = parcel.readString();
        this.f17342c = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17340a, i);
        parcel.writeString(this.f17341b);
        parcel.writeParcelable(this.f17342c, i);
    }
}
