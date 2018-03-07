package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threads.ThreadSummary;
import javax.annotation.Nullable;

/* compiled from: content_app_attribution */
public class NewMessageResult extends BaseResult implements Parcelable {
    public static final Creator<NewMessageResult> CREATOR = new C20421();
    public final Message f17253a;
    public final MessagesCollection f17254b;
    public final ThreadSummary f17255c;

    /* compiled from: content_app_attribution */
    final class C20421 implements Creator<NewMessageResult> {
        C20421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NewMessageResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new NewMessageResult[i];
        }
    }

    public NewMessageResult(DataFreshnessResult dataFreshnessResult, Message message, @Nullable MessagesCollection messagesCollection, @Nullable ThreadSummary threadSummary, long j) {
        super(dataFreshnessResult, j);
        this.f17253a = message;
        this.f17254b = messagesCollection;
        this.f17255c = threadSummary;
    }

    public NewMessageResult(Parcel parcel) {
        super(parcel);
        this.f17253a = (Message) parcel.readParcelable(Message.class.getClassLoader());
        this.f17254b = (MessagesCollection) parcel.readParcelable(MessagesCollection.class.getClassLoader());
        this.f17255c = (ThreadSummary) parcel.readParcelable(ThreadSummary.class.getClassLoader());
    }

    public final Message m17162c() {
        return this.f17253a;
    }

    public final MessagesCollection m17163d() {
        return this.f17254b;
    }

    public final ThreadSummary m17164e() {
        return this.f17255c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f17253a, i);
        parcel.writeParcelable(this.f17254b, i);
        parcel.writeParcelable(this.f17255c, i);
    }
}
