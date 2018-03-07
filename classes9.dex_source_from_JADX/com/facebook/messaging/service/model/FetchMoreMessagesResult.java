package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.messaging.model.messages.MessagesCollection;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: create session result is null */
public class FetchMoreMessagesResult implements Parcelable {
    public static final Creator<FetchMoreMessagesResult> CREATOR = new C20161();
    public static final FetchMoreMessagesResult f17070a = new FetchMoreMessagesResult(DataFetchDisposition.a, null, -1);
    public final DataFetchDisposition f17071b;
    public final MessagesCollection f17072c;
    public final long f17073d;

    /* compiled from: create session result is null */
    final class C20161 implements Creator<FetchMoreMessagesResult> {
        C20161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMoreMessagesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMoreMessagesResult[i];
        }
    }

    public FetchMoreMessagesResult(DataFetchDisposition dataFetchDisposition, @Nullable MessagesCollection messagesCollection, long j) {
        this.f17071b = dataFetchDisposition;
        this.f17072c = messagesCollection;
        this.f17073d = j;
    }

    public FetchMoreMessagesResult(Parcel parcel) {
        this.f17071b = (DataFetchDisposition) parcel.readParcelable(DataFetchDisposition.class.getClassLoader());
        this.f17072c = (MessagesCollection) parcel.readParcelable(MessagesCollection.class.getClassLoader());
        this.f17073d = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17071b, i);
        parcel.writeParcelable(this.f17072c, i);
        parcel.writeLong(this.f17073d);
    }
}
