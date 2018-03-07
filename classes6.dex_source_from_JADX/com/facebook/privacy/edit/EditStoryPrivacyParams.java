package com.facebook.privacy.edit;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: fetch */
public class EditStoryPrivacyParams implements Parcelable {
    public static final Creator<EditStoryPrivacyParams> CREATOR = new C10231();
    public String f15063a;
    public String f15064b;
    public String f15065c;
    public boolean f15066d;

    /* compiled from: fetch */
    final class C10231 implements Creator<EditStoryPrivacyParams> {
        C10231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditStoryPrivacyParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditStoryPrivacyParams[i];
        }
    }

    /* compiled from: fetch */
    public final class Builder {
        public String f15059a;
        public String f15060b;
        public String f15061c;
        public boolean f15062d;
    }

    EditStoryPrivacyParams() {
        this.f15063a = null;
        this.f15064b = null;
        this.f15065c = null;
        this.f15066d = false;
    }

    public EditStoryPrivacyParams(Builder builder) {
        this.f15063a = builder.f15059a;
        this.f15064b = builder.f15060b;
        this.f15065c = builder.f15061c;
        this.f15066d = builder.f15062d;
    }

    public EditStoryPrivacyParams(Parcel parcel) {
        this.f15063a = parcel.readString();
        this.f15064b = parcel.readString();
        this.f15065c = parcel.readString();
        this.f15066d = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15063a);
        parcel.writeString(this.f15064b);
        parcel.writeString(this.f15065c);
        ParcelUtil.a(parcel, this.f15066d);
    }
}
