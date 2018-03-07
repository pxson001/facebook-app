package com.facebook.goodwill.publish;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: yy-MM-dd */
public class GoodwillPublishPhoto implements Parcelable {
    public static final Creator<GoodwillPublishPhoto> CREATOR = new C00221();
    public String f158a;
    public String f159b;
    public boolean f160c;

    /* compiled from: yy-MM-dd */
    final class C00221 implements Creator<GoodwillPublishPhoto> {
        C00221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GoodwillPublishPhoto(parcel);
        }

        public final Object[] newArray(int i) {
            return new GoodwillPublishPhoto[i];
        }
    }

    public GoodwillPublishPhoto(String str, String str2) {
        this.f158a = str;
        this.f159b = str2;
        boolean z = (this.f159b == null || this.f159b.startsWith("http")) ? false : true;
        this.f160c = z;
    }

    public int hashCode() {
        return this.f158a.hashCode() + this.f159b.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GoodwillPublishPhoto)) {
            return false;
        }
        boolean z;
        GoodwillPublishPhoto goodwillPublishPhoto = (GoodwillPublishPhoto) obj;
        if (!(this.f158a == null && goodwillPublishPhoto.f158a == null) && (this.f158a == null || !this.f158a.equals(goodwillPublishPhoto.f158a))) {
            z = false;
        } else {
            z = true;
        }
        boolean z2;
        if (!(this.f159b == null && goodwillPublishPhoto.f159b == null) && (this.f159b == null || !this.f159b.equals(goodwillPublishPhoto.f159b))) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && r3 && this.f160c == goodwillPublishPhoto.f160c) {
            return true;
        }
        return false;
    }

    public GoodwillPublishPhoto(Parcel parcel) {
        this.f158a = parcel.readString();
        this.f159b = parcel.readString();
        this.f160c = ParcelUtil.a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f158a);
        parcel.writeString(this.f159b);
        ParcelUtil.a(parcel, this.f160c);
    }

    public int describeContents() {
        return 0;
    }
}
