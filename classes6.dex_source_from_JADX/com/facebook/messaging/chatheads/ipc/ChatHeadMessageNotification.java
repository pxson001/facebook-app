package com.facebook.messaging.chatheads.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.messages.Message;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: video_list_videos */
public class ChatHeadMessageNotification implements Parcelable {
    public static final Creator<ChatHeadMessageNotification> CREATOR = new C00721();
    private final Message f729a;
    private final boolean f730b;
    private final boolean f731c;

    /* compiled from: video_list_videos */
    final class C00721 implements Creator<ChatHeadMessageNotification> {
        C00721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ChatHeadMessageNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new ChatHeadMessageNotification[i];
        }
    }

    /* compiled from: video_list_videos */
    public class Builder {
        public Message f726a;
        public boolean f727b;
        public boolean f728c;
    }

    public ChatHeadMessageNotification(Message message, boolean z, boolean z2) {
        this.f729a = message;
        this.f730b = z;
        this.f731c = z2;
    }

    public ChatHeadMessageNotification(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f729a = (Message) parcel.readParcelable(Message.class.getClassLoader());
        parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f730b = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f731c = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeParcelable(this.f729a, i);
        parcel.writeString(this.f729a.f2011b.toString());
        if (this.f730b) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f731c) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
