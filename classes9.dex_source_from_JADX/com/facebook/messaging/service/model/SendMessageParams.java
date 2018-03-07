package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.messaging.model.messages.Message;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: contact_id=? */
public class SendMessageParams implements Parcelable {
    public static final Creator<SendMessageParams> CREATOR = new C20581();
    @Nonnull
    public final Message f17308a;
    public final boolean f17309b;
    public final FbTraceNode f17310c;
    public final int f17311d;
    public final long f17312e;
    public final long f17313f;

    /* compiled from: contact_id=? */
    final class C20581 implements Creator<SendMessageParams> {
        C20581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendMessageParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendMessageParams[i];
        }
    }

    SendMessageParams(@Nonnull Message message, boolean z, FbTraceNode fbTraceNode, int i, long j, long j2) {
        this.f17308a = message;
        this.f17309b = z;
        this.f17310c = fbTraceNode;
        this.f17311d = i;
        this.f17312e = j;
        this.f17313f = j2;
    }

    public SendMessageParams(Parcel parcel) {
        this.f17308a = (Message) parcel.readParcelable(Message.class.getClassLoader());
        this.f17309b = parcel.readInt() != 0;
        this.f17310c = (FbTraceNode) parcel.readParcelable(FbTraceNode.class.getClassLoader());
        this.f17311d = parcel.readInt();
        this.f17312e = parcel.readLong();
        this.f17313f = parcel.readLong();
    }

    public static SendMessageParamsBuilder m17181a() {
        return new SendMessageParamsBuilder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17308a, i);
        parcel.writeInt(this.f17309b ? 1 : 0);
        parcel.writeParcelable(this.f17310c, i);
        parcel.writeInt(this.f17311d);
        parcel.writeLong(this.f17312e);
        parcel.writeLong(this.f17313f);
    }
}
