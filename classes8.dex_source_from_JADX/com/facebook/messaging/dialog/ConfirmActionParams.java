package com.facebook.messaging.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.Nullable;

/* compiled from: total_shown */
public class ConfirmActionParams implements Parcelable {
    public static final Creator<ConfirmActionParams> CREATOR = new C01581();
    public final String f1501a;
    public final String f1502b;
    @Nullable
    public final String f1503c;
    public final ButtonStyle f1504d;
    @Nullable
    public final String f1505e;
    public final ButtonStyle f1506f;
    @Nullable
    public final String f1507g;
    public final boolean f1508h;

    /* compiled from: total_shown */
    final class C01581 implements Creator<ConfirmActionParams> {
        C01581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ConfirmActionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ConfirmActionParams[i];
        }
    }

    /* compiled from: total_shown */
    public final class Builder {
        public final String f1493a;
        public final String f1494b;
        @Nullable
        public String f1495c;
        @Nullable
        public String f1496d;
        @Nullable
        public String f1497e;
        public boolean f1498f;
        public ButtonStyle f1499g = ButtonStyle.NORMAL;
        public ButtonStyle f1500h = ButtonStyle.NORMAL;

        public Builder(String str, String str2) {
            this.f1493a = str;
            this.f1494b = str2;
        }

        public final ConfirmActionParams m1678a() {
            return new ConfirmActionParams(this);
        }
    }

    /* compiled from: total_shown */
    public enum ButtonStyle {
        NORMAL,
        DELETE
    }

    public ConfirmActionParams(Builder builder) {
        this.f1501a = builder.f1493a;
        this.f1503c = builder.f1496d;
        this.f1502b = builder.f1494b;
        this.f1504d = builder.f1499g;
        this.f1505e = builder.f1495c;
        this.f1506f = builder.f1500h;
        this.f1507g = builder.f1497e;
        this.f1508h = builder.f1498f;
    }

    public ConfirmActionParams(Parcel parcel) {
        this.f1501a = parcel.readString();
        this.f1502b = parcel.readString();
        this.f1503c = parcel.readString();
        this.f1504d = (ButtonStyle) parcel.readSerializable();
        this.f1505e = parcel.readString();
        this.f1506f = (ButtonStyle) parcel.readSerializable();
        this.f1507g = parcel.readString();
        this.f1508h = ParcelUtil.a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1501a);
        parcel.writeString(this.f1502b);
        parcel.writeString(this.f1503c);
        parcel.writeSerializable(this.f1504d);
        parcel.writeString(this.f1505e);
        parcel.writeSerializable(this.f1506f);
        parcel.writeString(this.f1507g);
        ParcelUtil.a(parcel, this.f1508h);
    }

    public int describeContents() {
        return 0;
    }
}
