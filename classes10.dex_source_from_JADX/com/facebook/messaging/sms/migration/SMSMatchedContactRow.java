package com.facebook.messaging.sms.migration;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.contacts.picker.PickableContactPickerRow;

/* compiled from: q1qzaqxrf */
public class SMSMatchedContactRow extends PickableContactPickerRow implements Parcelable {
    public static final Creator<SMSMatchedContactRow> CREATOR = new C06311();
    public final String f4191a;
    public final String f4192b;
    public final Uri f4193c;
    public final String f4194d;
    private boolean f4195e;

    /* compiled from: q1qzaqxrf */
    final class C06311 implements Creator<SMSMatchedContactRow> {
        C06311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SMSMatchedContactRow(parcel);
        }

        public final Object[] newArray(int i) {
            return new SMSMatchedContactRow[i];
        }
    }

    public static SMSMatchedContactRow m3839a(Bundle bundle) {
        SMSMatchedContactRowBuilder sMSMatchedContactRowBuilder = new SMSMatchedContactRowBuilder();
        sMSMatchedContactRowBuilder.f4196a = bundle.getString("id");
        sMSMatchedContactRowBuilder = sMSMatchedContactRowBuilder;
        sMSMatchedContactRowBuilder.f4197b = bundle.getString("name");
        sMSMatchedContactRowBuilder = sMSMatchedContactRowBuilder;
        sMSMatchedContactRowBuilder.f4198c = Uri.parse(bundle.getString("profile_pic"));
        sMSMatchedContactRowBuilder = sMSMatchedContactRowBuilder;
        sMSMatchedContactRowBuilder.f4199d = bundle.getString("phone_number");
        return new SMSMatchedContactRow(sMSMatchedContactRowBuilder);
    }

    public SMSMatchedContactRow(SMSMatchedContactRowBuilder sMSMatchedContactRowBuilder) {
        this.f4191a = sMSMatchedContactRowBuilder.f4196a;
        this.f4192b = sMSMatchedContactRowBuilder.f4197b;
        this.f4193c = sMSMatchedContactRowBuilder.f4198c;
        this.f4194d = sMSMatchedContactRowBuilder.f4199d;
    }

    public SMSMatchedContactRow(Parcel parcel) {
        this.f4191a = parcel.readString();
        this.f4192b = parcel.readString();
        this.f4193c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4194d = parcel.readString();
        this.f4195e = ParcelUtil.a(parcel);
    }

    public final void m3840a(boolean z) {
        this.f4195e = z;
    }

    public final boolean m3841d() {
        return this.f4195e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4191a);
        parcel.writeString(this.f4192b);
        parcel.writeParcelable(this.f4193c, i);
        parcel.writeString(this.f4194d);
        ParcelUtil.a(parcel, this.f4195e);
    }
}
