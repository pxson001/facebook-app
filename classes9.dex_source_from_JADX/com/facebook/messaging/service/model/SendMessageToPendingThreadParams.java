package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.messaging.model.messages.Message;
import com.facebook.user.model.UserIdentifier;
import com.google.common.collect.ImmutableList;

/* compiled from: consumption */
public class SendMessageToPendingThreadParams implements Parcelable {
    public static final Creator<SendMessageToPendingThreadParams> CREATOR = new C20591();
    public final Message f17320a;
    public final ImmutableList<UserIdentifier> f17321b;
    public final FbTraceNode f17322c;

    /* compiled from: consumption */
    final class C20591 implements Creator<SendMessageToPendingThreadParams> {
        C20591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendMessageToPendingThreadParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendMessageToPendingThreadParams[i];
        }
    }

    public SendMessageToPendingThreadParams(Message message, ImmutableList<UserIdentifier> immutableList, FbTraceNode fbTraceNode) {
        this.f17320a = message;
        this.f17321b = ImmutableList.copyOf(immutableList);
        this.f17322c = fbTraceNode;
    }

    public SendMessageToPendingThreadParams(Parcel parcel) {
        this.f17320a = (Message) parcel.readParcelable(Message.class.getClassLoader());
        this.f17321b = ImmutableList.copyOf(parcel.readArrayList(UserIdentifier.class.getClassLoader()));
        this.f17322c = (FbTraceNode) parcel.readParcelable(FbTraceNode.class.getClassLoader());
    }

    public final Message m17189a() {
        return this.f17320a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17320a, i);
        parcel.writeList(this.f17321b);
        parcel.writeParcelable(this.f17322c, i);
    }
}
