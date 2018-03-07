package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: passenger */
public class PhonebookContactMetadata implements Parcelable {
    public static final Creator<PhonebookContactMetadata> CREATOR = new C05151();
    public final String f8312a;
    public final int f8313b;
    public final boolean f8314c;
    public final long f8315d;
    public final boolean f8316e;
    public final boolean f8317f;
    public final boolean f8318g;
    public final boolean f8319h;
    private String f8320i;

    /* compiled from: passenger */
    final class C05151 implements Creator<PhonebookContactMetadata> {
        C05151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookContactMetadata(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookContactMetadata[i];
        }
    }

    public PhonebookContactMetadata(String str, int i, boolean z, long j, boolean z2, boolean z3, boolean z4, boolean z5, String str2) {
        this.f8312a = str;
        this.f8313b = i;
        this.f8314c = z;
        this.f8315d = j;
        this.f8316e = z2;
        this.f8317f = z3;
        this.f8318g = z4;
        this.f8319h = z5;
        this.f8320i = str2;
    }

    public PhonebookContactMetadata(Parcel parcel) {
        this.f8312a = parcel.readString();
        this.f8313b = parcel.readInt();
        this.f8314c = ParcelUtil.a(parcel);
        this.f8315d = parcel.readLong();
        this.f8316e = ParcelUtil.a(parcel);
        this.f8317f = ParcelUtil.a(parcel);
        this.f8318g = ParcelUtil.a(parcel);
        this.f8319h = ParcelUtil.a(parcel);
        this.f8320i = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8312a);
        parcel.writeInt(this.f8313b);
        ParcelUtil.a(parcel, this.f8314c);
        parcel.writeLong(this.f8315d);
        ParcelUtil.a(parcel, this.f8316e);
        ParcelUtil.a(parcel, this.f8317f);
        ParcelUtil.a(parcel, this.f8318g);
        ParcelUtil.a(parcel, this.f8319h);
        parcel.writeString(this.f8320i);
    }

    public final void m12110a(String str) {
        this.f8320i = str;
    }

    public final String m12109a() {
        return this.f8320i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhonebookContactMetadata)) {
            return false;
        }
        PhonebookContactMetadata phonebookContactMetadata = (PhonebookContactMetadata) obj;
        if (Objects.equal(this.f8312a, phonebookContactMetadata.f8312a) && this.f8313b == phonebookContactMetadata.f8313b && this.f8314c == phonebookContactMetadata.f8314c && this.f8315d == phonebookContactMetadata.f8315d && this.f8316e == phonebookContactMetadata.f8316e && this.f8317f == phonebookContactMetadata.f8317f && this.f8318g == phonebookContactMetadata.f8318g && this.f8319h == phonebookContactMetadata.f8319h && Objects.equal(this.f8320i, phonebookContactMetadata.f8320i)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8312a, Integer.valueOf(this.f8313b), Boolean.valueOf(this.f8314c), Long.valueOf(this.f8315d), Boolean.valueOf(this.f8316e), Boolean.valueOf(this.f8317f), Boolean.valueOf(this.f8318g), Boolean.valueOf(this.f8319h), this.f8320i});
    }
}
