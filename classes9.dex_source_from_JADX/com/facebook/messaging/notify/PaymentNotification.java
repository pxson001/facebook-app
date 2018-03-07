package com.facebook.messaging.notify;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.push.PushProperty;
import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.Nullable;

/* compiled from: inviter_name */
public class PaymentNotification extends MessagingNotification {
    public static final Creator<PaymentNotification> CREATOR = new C14321();
    public final String f12752a;
    public final Type f12753b;
    @Nullable
    public final String f12754c;
    @Nullable
    public final String f12755d;
    public final String f12756e;
    public final String f12757f;
    public final String f12758g;
    public final PushProperty f12759h;
    public final int f12760i;
    public boolean f12761k;

    /* compiled from: inviter_name */
    final class C14321 implements Creator<PaymentNotification> {
        C14321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentNotification[i];
        }
    }

    /* compiled from: inviter_name */
    public class Builder {
        public String f12743a;
        public Type f12744b;
        public String f12745c;
        public String f12746d;
        public String f12747e;
        public String f12748f;
        public String f12749g;
        public PushProperty f12750h;
        public int f12751i;

        public static PaymentNotification m13129a(Builder builder) {
            return new PaymentNotification(builder);
        }
    }

    /* compiled from: inviter_name */
    public enum Type {
        REQUEST,
        TRANSFER
    }

    @Nullable
    public static PaymentNotification m13131a(String str, String str2, JsonNode jsonNode, PushProperty pushProperty) {
        int i = 0;
        String a = m13132a(jsonNode, "t");
        if (a == null) {
            return null;
        }
        if (StringUtil.a(new CharSequence[]{m13132a(jsonNode, "o")})) {
            return null;
        }
        Builder builder = new Builder();
        builder.f12743a = r3;
        Builder builder2 = builder;
        builder2.f12745c = m13132a(jsonNode, "oui");
        builder2 = builder2;
        builder2.f12746d = m13132a(jsonNode, "gti");
        builder2 = builder2;
        builder2.f12747e = str2;
        builder2 = builder2;
        builder2.f12748f = str;
        builder2 = builder2;
        builder2.f12749g = str;
        builder2 = builder2;
        builder2.f12750h = pushProperty;
        builder2 = builder2;
        if (a.equals("p2pr")) {
            String a2 = m13132a(jsonNode, "st");
            if (!StringUtil.a(a2) && a2.matches("^\\d+$")) {
                i = Integer.parseInt(a2);
            }
            builder2.f12744b = Type.REQUEST;
            Builder builder3 = builder2;
            builder3.f12751i = i;
            return Builder.m13129a(builder3);
        } else if (!a.equals("p2pt")) {
            return null;
        } else {
            builder2.f12744b = Type.TRANSFER;
            return Builder.m13129a(builder2);
        }
    }

    public PaymentNotification(Builder builder) {
        super(com.facebook.messaging.notify.MessagingNotification.Type.P2P_PAYMENT);
        this.f12752a = builder.f12743a;
        this.f12753b = builder.f12744b;
        this.f12754c = builder.f12745c;
        this.f12755d = builder.f12746d;
        this.f12756e = builder.f12747e;
        this.f12757f = builder.f12748f;
        this.f12758g = builder.f12749g;
        this.f12759h = builder.f12750h;
        this.f12760i = builder.f12751i;
    }

    public PaymentNotification(Parcel parcel) {
        super(parcel);
        this.f12752a = parcel.readString();
        this.f12753b = (Type) parcel.readSerializable();
        this.f12754c = parcel.readString();
        this.f12755d = parcel.readString();
        this.f12756e = parcel.readString();
        this.f12757f = parcel.readString();
        this.f12758g = parcel.readString();
        this.f12759h = (PushProperty) parcel.readParcelable(PushProperty.class.getClassLoader());
        this.f12761k = ParcelUtil.a(parcel);
        this.f12760i = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12752a);
        parcel.writeSerializable(this.f12753b);
        parcel.writeString(this.f12754c);
        parcel.writeString(this.f12755d);
        parcel.writeString(this.f12756e);
        parcel.writeString(this.f12757f);
        parcel.writeString(this.f12758g);
        parcel.writeParcelable(this.f12759h, i);
        ParcelUtil.a(parcel, this.f12761k);
        parcel.writeInt(this.f12760i);
    }

    @Nullable
    private static String m13132a(JsonNode jsonNode, String str) {
        return jsonNode.b(str) == null ? null : jsonNode.b(str).B();
    }

    public static Uri m13130a(String str, String str2) {
        return Uri.parse(MessengerLinks.q).buildUpon().appendPath(str).appendPath(str2).build();
    }
}
