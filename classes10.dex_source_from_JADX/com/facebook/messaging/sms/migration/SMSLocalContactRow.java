package com.facebook.messaging.sms.migration;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.contacts.picker.PickableContactPickerRow;

/* compiled from: q1wxrfzaq */
public class SMSLocalContactRow extends PickableContactPickerRow implements Parcelable {
    public static final Creator<SMSLocalContactRow> CREATOR = new C06301();
    public final String f4181a;
    public final String f4182b;
    public final int f4183c;
    public final int f4184d;
    private boolean f4185e;
    public boolean f4186f = true;

    /* compiled from: q1wxrfzaq */
    final class C06301 implements Creator<SMSLocalContactRow> {
        C06301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SMSLocalContactRow(parcel);
        }

        public final Object[] newArray(int i) {
            return new SMSLocalContactRow[i];
        }
    }

    public static SMSLocalContactRowBuilder m3835c() {
        return new SMSLocalContactRowBuilder();
    }

    SMSLocalContactRow(SMSLocalContactRowBuilder sMSLocalContactRowBuilder) {
        this.f4182b = sMSLocalContactRowBuilder.f4188b;
        this.f4181a = sMSLocalContactRowBuilder.f4187a;
        this.f4183c = sMSLocalContactRowBuilder.f4189c;
        this.f4184d = sMSLocalContactRowBuilder.f4190d;
    }

    public SMSLocalContactRow(Parcel parcel) {
        this.f4181a = parcel.readString();
        this.f4182b = parcel.readString();
        this.f4183c = parcel.readInt();
        this.f4184d = parcel.readInt();
        this.f4185e = ParcelUtil.a(parcel);
    }

    public final void m3836a(boolean z) {
        this.f4185e = z;
    }

    public final boolean m3837d() {
        return this.f4185e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4181a);
        parcel.writeString(this.f4182b);
        parcel.writeInt(this.f4183c);
        parcel.writeInt(this.f4184d);
        ParcelUtil.a(parcel, this.f4185e);
    }
}
