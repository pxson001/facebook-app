package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: payload_attachment_source */
public class PhonebookAddress extends PhonebookContactField {
    public static final Creator<PhonebookAddress> CREATOR = new C05111();
    public final String f8258a;
    public final String f8259b;
    public final String f8260c;
    public final String f8261d;
    public final String f8262e;
    public final String f8263f;
    public final String f8264g;
    public final String f8265h;

    /* compiled from: payload_attachment_source */
    final class C05111 implements Creator<PhonebookAddress> {
        C05111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookAddress(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookAddress[i];
        }
    }

    public PhonebookAddress(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        super(i, str2);
        this.f8258a = str;
        this.f8259b = str3;
        this.f8260c = str4;
        this.f8261d = str5;
        this.f8262e = str6;
        this.f8263f = str7;
        this.f8264g = str8;
        this.f8265h = str9;
    }

    public PhonebookAddress(Parcel parcel) {
        super(parcel);
        this.f8258a = parcel.readString();
        this.f8259b = parcel.readString();
        this.f8260c = parcel.readString();
        this.f8261d = parcel.readString();
        this.f8262e = parcel.readString();
        this.f8263f = parcel.readString();
        this.f8264g = parcel.readString();
        this.f8265h = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f8258a);
        parcel.writeString(this.f8259b);
        parcel.writeString(this.f8260c);
        parcel.writeString(this.f8261d);
        parcel.writeString(this.f8262e);
        parcel.writeString(this.f8263f);
        parcel.writeString(this.f8264g);
        parcel.writeString(this.f8265h);
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof PhonebookAddress) && Objects.equal(this.f8258a, ((PhonebookAddress) obj).f8258a) && Objects.equal(this.f8259b, ((PhonebookAddress) obj).f8259b) && Objects.equal(this.f8260c, ((PhonebookAddress) obj).f8260c) && Objects.equal(this.f8261d, ((PhonebookAddress) obj).f8261d) && Objects.equal(this.f8262e, ((PhonebookAddress) obj).f8262e) && Objects.equal(this.f8263f, ((PhonebookAddress) obj).f8263f) && Objects.equal(this.f8264g, ((PhonebookAddress) obj).f8264g) && Objects.equal(this.f8265h, ((PhonebookAddress) obj).f8265h);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8258a, Integer.valueOf(this.f8256i), this.f8257j, this.f8259b, this.f8260c, this.f8261d, this.f8262e, this.f8263f, this.f8264g, this.f8265h});
    }
}
