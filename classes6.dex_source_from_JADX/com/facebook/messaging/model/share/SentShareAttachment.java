package com.facebook.messaging.model.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.payment.SentPayment;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upload-video-chunk-start */
public class SentShareAttachment implements Parcelable {
    public static final Creator<SentShareAttachment> CREATOR = new C01071();
    public final Type f2179a;
    public final Share f2180b;
    public final SentPayment f2181c;

    /* compiled from: upload-video-chunk-start */
    final class C01071 implements Creator<SentShareAttachment> {
        C01071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SentShareAttachment(parcel);
        }

        public final Object[] newArray(int i) {
            return new SentShareAttachment[i];
        }
    }

    /* compiled from: upload-video-chunk-start */
    public enum Type {
        SHARE("share"),
        PAYMENT("payment");
        
        private static final ImmutableMap<String, Type> VALUE_MAP = null;
        public final String DBSerialValue;

        static {
            Builder builder = ImmutableMap.builder();
            Type[] values = values();
            int length = values.length;
            int i;
            while (i < length) {
                Type type = values[i];
                builder.b(type.DBSerialValue, type);
                i++;
            }
            VALUE_MAP = builder.b();
        }

        private Type(String str) {
            this.DBSerialValue = str;
        }

        public static Type fromDBSerialValue(String str) {
            if (VALUE_MAP.containsKey(str)) {
                return (Type) VALUE_MAP.get(str);
            }
            throw new IllegalArgumentException("Unsupported Type: " + str);
        }
    }

    public static SentShareAttachment m3469a(Share share) {
        return new SentShareAttachment(Type.SHARE, share, null);
    }

    public static SentShareAttachment m3468a(SentPayment sentPayment) {
        return new SentShareAttachment(Type.PAYMENT, null, sentPayment);
    }

    private SentShareAttachment(Type type, Share share, SentPayment sentPayment) {
        this.f2179a = type;
        this.f2180b = share;
        this.f2181c = sentPayment;
    }

    public SentShareAttachment(Parcel parcel) {
        this.f2179a = Type.fromDBSerialValue(parcel.readString());
        this.f2180b = (Share) parcel.readParcelable(Share.class.getClassLoader());
        this.f2181c = (SentPayment) parcel.readParcelable(SentPayment.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2179a.DBSerialValue);
        parcel.writeParcelable(this.f2180b, i);
        parcel.writeParcelable(this.f2181c, i);
    }
}
