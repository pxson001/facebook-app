package com.facebook.privacy.checkup.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import javax.annotation.Nullable;

/* compiled from: page/{#%s}/reaction */
public class FetchGenericPrivacyReviewParams implements Parcelable {
    public static final Creator<FetchGenericPrivacyReviewParams> CREATOR = new C06141();
    public final int f4420a;
    public final String f4421b;
    public final int f4422c;
    @Nullable
    public final String f4423d;
    public final String f4424e;
    @Nullable
    public final String f4425f;

    /* compiled from: page/{#%s}/reaction */
    final class C06141 implements Creator<FetchGenericPrivacyReviewParams> {
        C06141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchGenericPrivacyReviewParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchGenericPrivacyReviewParams[i];
        }
    }

    public FetchGenericPrivacyReviewParams(Parcel parcel) {
        String str = null;
        this.f4420a = parcel.readInt();
        this.f4421b = parcel.readString();
        this.f4422c = parcel.readInt();
        String readString = parcel.readString();
        if (TextUtils.isEmpty(readString)) {
            readString = null;
        }
        this.f4423d = readString;
        this.f4424e = parcel.readString();
        CharSequence readString2 = parcel.readString();
        if (!TextUtils.isEmpty(readString2)) {
            str = readString2;
        }
        this.f4425f = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4420a);
        parcel.writeString(this.f4421b);
        parcel.writeInt(this.f4422c);
        parcel.writeString(this.f4423d == null ? "" : this.f4423d);
        parcel.writeString(this.f4424e);
        parcel.writeString(this.f4425f == null ? "" : this.f4425f);
    }

    public int describeContents() {
        return 0;
    }
}
