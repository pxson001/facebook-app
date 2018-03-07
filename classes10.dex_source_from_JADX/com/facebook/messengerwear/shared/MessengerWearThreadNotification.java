package com.facebook.messengerwear.shared;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: photo_save_thread_view */
public class MessengerWearThreadNotification implements Parcelable {
    public static final Creator<MessengerWearThreadNotification> CREATOR = new C06811();
    public final String f4973a;
    public final int f4974b;
    public final String f4975c;
    public final Message f4976d;
    public final ImmutableList<Message> f4977e;
    public final ImmutableList<String> f4978f;

    /* compiled from: photo_save_thread_view */
    final class C06811 implements Creator<MessengerWearThreadNotification> {
        C06811() {
        }

        public final Object[] newArray(int i) {
            return new MessengerWearThreadNotification[i];
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessengerWearThreadNotification(parcel);
        }
    }

    /* compiled from: photo_save_thread_view */
    public class Builder {
        private String f4967a;
        private int f4968b;
        private String f4969c;
        private Message f4970d;
        private final List<Message> f4971e = new ArrayList();
        private List<String> f4972f;

        public final Builder m4511a(String str) {
            this.f4967a = str;
            return this;
        }

        public final Builder m4509a(int i) {
            this.f4968b = i;
            return this;
        }

        public final Builder m4515b(String str) {
            this.f4969c = str;
            return this;
        }

        public final Builder m4510a(Message message) {
            this.f4970d = message;
            return this;
        }

        public final Builder m4514b(Message message) {
            this.f4971e.add(message);
            return this;
        }

        public final Builder m4512a(List<String> list) {
            this.f4972f = list;
            return this;
        }

        public final MessengerWearThreadNotification m4513a() {
            return new MessengerWearThreadNotification(this.f4967a, this.f4968b, this.f4969c, this.f4970d, ImmutableList.copyOf(this.f4971e), this.f4972f == null ? RegularImmutableList.a : ImmutableList.copyOf(this.f4972f));
        }
    }

    public MessengerWearThreadNotification(String str, int i, String str2, Message message, ImmutableList<Message> immutableList, ImmutableList<String> immutableList2) {
        this.f4973a = str;
        this.f4974b = i;
        this.f4975c = str2;
        this.f4976d = message;
        this.f4977e = immutableList;
        this.f4978f = immutableList2;
    }

    public MessengerWearThreadNotification(Parcel parcel) {
        this.f4973a = parcel.readString();
        this.f4974b = parcel.readInt();
        this.f4975c = parcel.readString();
        this.f4976d = (Message) parcel.readParcelable(getClass().getClassLoader());
        Collection arrayList = new ArrayList();
        parcel.readTypedList(arrayList, Message.CREATOR);
        this.f4977e = ImmutableList.copyOf(arrayList);
        arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f4978f = ImmutableList.copyOf(arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4973a);
        parcel.writeInt(this.f4974b);
        parcel.writeString(this.f4975c);
        parcel.writeParcelable(this.f4976d, 0);
        parcel.writeTypedList(this.f4977e);
        parcel.writeStringList(this.f4978f);
    }
}
