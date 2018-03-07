package com.facebook.messengerwear.shared;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Strings;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: photo_view_fragment_mode */
public class Message implements Parcelable {
    public static final Creator<Message> CREATOR = new C06791();
    public final long f4955a;
    public final String f4956b;
    public final String f4957c;
    public final boolean f4958d;
    public final String f4959e;
    public final MessageType f4960f;
    public final MessageGrouping f4961g;
    public final Attachment f4962h;
    public final String f4963i;

    /* compiled from: photo_view_fragment_mode */
    final class C06791 implements Creator<Message> {
        C06791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Message(parcel);
        }

        public final Object[] newArray(int i) {
            return new Message[i];
        }
    }

    /* compiled from: photo_view_fragment_mode */
    public class Attachment implements Parcelable {
        public static final Creator<Attachment> CREATOR = new C06801();
        public final String f4944a;
        public final Type f4945b;

        /* compiled from: photo_view_fragment_mode */
        final class C06801 implements Creator<Attachment> {
            C06801() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Attachment(parcel);
            }

            public final Object[] newArray(int i) {
                return new Attachment[i];
            }
        }

        /* compiled from: photo_view_fragment_mode */
        public enum Type {
            PHOTO,
            UNKNOWN
        }

        public Attachment(String str, Type type) {
            this.f4944a = str;
            this.f4945b = type;
        }

        public Attachment(Parcel parcel) {
            this.f4944a = parcel.readString();
            this.f4945b = Type.values()[parcel.readInt()];
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f4944a);
            parcel.writeInt(this.f4945b.ordinal());
        }

        public String toString() {
            return "Attachment{fbid='" + this.f4944a + '\'' + ", type=" + this.f4945b + '}';
        }
    }

    /* compiled from: photo_view_fragment_mode */
    public class Builder {
        private long f4946a;
        private String f4947b;
        private String f4948c;
        private boolean f4949d;
        private String f4950e;
        private MessageType f4951f;
        private MessageGrouping f4952g = MessageGrouping.DEFAULT;
        public Attachment f4953h;
        private String f4954i;

        public Builder(MessageType messageType) {
            this.f4951f = messageType;
        }

        public final Builder m4485a(long j) {
            this.f4946a = j;
            return this;
        }

        public final Builder m4488a(String str) {
            this.f4947b = str;
            return this;
        }

        public final Builder m4491b(String str) {
            this.f4948c = str;
            return this;
        }

        public final Builder m4489a(boolean z) {
            this.f4949d = z;
            return this;
        }

        public final Builder m4492c(String str) {
            this.f4950e = str;
            return this;
        }

        public final Builder m4487a(MessageGrouping messageGrouping) {
            this.f4952g = messageGrouping;
            return this;
        }

        public final Builder m4486a(Attachment attachment) {
            this.f4953h = attachment;
            return this;
        }

        public final Builder m4493d(String str) {
            this.f4954i = str;
            return this;
        }

        public final Message m4490a() {
            return new Message(this.f4946a, this.f4947b, this.f4948c, this.f4949d, this.f4950e, this.f4951f, this.f4952g, this.f4953h, this.f4954i);
        }
    }

    public Message(long j, String str, String str2, boolean z, String str3, MessageType messageType, MessageGrouping messageGrouping, Attachment attachment, String str4) {
        this.f4955a = j;
        this.f4956b = str;
        this.f4957c = str2;
        this.f4958d = z;
        this.f4959e = str3;
        this.f4960f = messageType;
        this.f4961g = messageGrouping;
        this.f4962h = attachment;
        this.f4963i = str4;
    }

    public Message(Parcel parcel) {
        boolean z = true;
        this.f4955a = parcel.readLong();
        this.f4956b = parcel.readString();
        this.f4957c = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f4958d = z;
        this.f4959e = parcel.readString();
        this.f4960f = MessageType.values()[parcel.readInt()];
        this.f4961g = MessageGrouping.values()[parcel.readInt()];
        this.f4962h = (Attachment) parcel.readParcelable(getClass().getClassLoader());
        this.f4963i = parcel.readString();
    }

    public final boolean m4494a() {
        return !Strings.isNullOrEmpty(this.f4959e);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4955a);
        parcel.writeString(this.f4956b);
        parcel.writeString(this.f4957c);
        parcel.writeByte((byte) (this.f4958d ? 1 : 0));
        parcel.writeString(this.f4959e);
        parcel.writeInt(this.f4960f.ordinal());
        parcel.writeInt(this.f4961g.ordinal());
        parcel.writeParcelable(this.f4962h, 0);
        parcel.writeString(this.f4963i);
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Message.class.getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append("text=[");
        stringBuilder.append(this.f4956b);
        stringBuilder.append("], stickerId=[");
        stringBuilder.append(this.f4959e);
        stringBuilder.append("], senderName=[");
        stringBuilder.append(this.f4957c);
        stringBuilder.append("], me=");
        stringBuilder.append(this.f4958d);
        stringBuilder.append(", timestampMs=");
        stringBuilder.append(simpleDateFormat.format(new Date(this.f4955a)));
        stringBuilder.append(" (");
        stringBuilder.append(this.f4955a);
        stringBuilder.append("), messageType=[");
        stringBuilder.append(this.f4960f.name());
        stringBuilder.append("], messageGrouping=[");
        stringBuilder.append(this.f4961g.name());
        stringBuilder.append("], attachmment=[");
        stringBuilder.append(this.f4962h);
        stringBuilder.append("], attributionText=[");
        stringBuilder.append(this.f4963i);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
