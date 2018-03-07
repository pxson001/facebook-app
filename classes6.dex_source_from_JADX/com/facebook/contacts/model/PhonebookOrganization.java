package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: partition_end_offset */
public class PhonebookOrganization extends PhonebookContactField {
    public static final Creator<PhonebookOrganization> CREATOR = new C05201();
    public final String f8328a;
    public final String f8329b;
    public final String f8330c;
    public final String f8331d;
    public final String f8332e;
    public final String f8333f;
    public final String f8334g;

    /* compiled from: partition_end_offset */
    final class C05201 implements Creator<PhonebookOrganization> {
        C05201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookOrganization(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookOrganization[i];
        }
    }

    public PhonebookOrganization(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(i, str2);
        this.f8328a = str;
        this.f8329b = str3;
        this.f8330c = str4;
        this.f8331d = str5;
        this.f8332e = str6;
        this.f8333f = str7;
        this.f8334g = str8;
    }

    public PhonebookOrganization(Parcel parcel) {
        super(parcel);
        this.f8328a = parcel.readString();
        this.f8329b = parcel.readString();
        this.f8330c = parcel.readString();
        this.f8331d = parcel.readString();
        this.f8332e = parcel.readString();
        this.f8333f = parcel.readString();
        this.f8334g = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f8328a);
        parcel.writeString(this.f8329b);
        parcel.writeString(this.f8330c);
        parcel.writeString(this.f8331d);
        parcel.writeString(this.f8332e);
        parcel.writeString(this.f8333f);
        parcel.writeString(this.f8334g);
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof PhonebookOrganization) && Objects.equal(this.f8328a, ((PhonebookOrganization) obj).f8328a) && Objects.equal(this.f8329b, ((PhonebookOrganization) obj).f8329b) && Objects.equal(this.f8330c, ((PhonebookOrganization) obj).f8330c) && Objects.equal(this.f8331d, ((PhonebookOrganization) obj).f8331d) && Objects.equal(this.f8332e, ((PhonebookOrganization) obj).f8332e) && Objects.equal(this.f8333f, ((PhonebookOrganization) obj).f8333f) && Objects.equal(this.f8334g, ((PhonebookOrganization) obj).f8334g);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8328a, Integer.valueOf(this.f8256i), this.f8257j, this.f8329b, this.f8330c, this.f8331d, this.f8332e, this.f8333f, this.f8334g});
    }
}
