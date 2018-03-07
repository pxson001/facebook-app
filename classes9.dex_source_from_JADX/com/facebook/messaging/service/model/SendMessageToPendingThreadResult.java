package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: connections_db */
public class SendMessageToPendingThreadResult implements Parcelable {
    public static final Creator<SendMessageToPendingThreadResult> CREATOR = new C20601();
    public final ThreadKey f17326a;

    /* compiled from: connections_db */
    final class C20601 implements Creator<SendMessageToPendingThreadResult> {
        C20601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendMessageToPendingThreadResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendMessageToPendingThreadResult[i];
        }
    }

    public SendMessageToPendingThreadResult(ThreadKey threadKey) {
        this.f17326a = threadKey;
    }

    public SendMessageToPendingThreadResult(Parcel parcel) {
        this.f17326a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17326a, i);
    }
}
