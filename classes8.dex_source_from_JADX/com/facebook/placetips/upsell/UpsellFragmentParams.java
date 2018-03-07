package com.facebook.placetips.upsell;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: canPost */
public class UpsellFragmentParams implements Parcelable {
    public static final Creator<UpsellFragmentParams> CREATOR = new C20541();
    public final UpsellPageConfig[] f18543a;
    @Nullable
    public final String f18544b;

    /* compiled from: canPost */
    final class C20541 implements Creator<UpsellFragmentParams> {
        C20541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpsellFragmentParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpsellFragmentParams[i];
        }
    }

    public UpsellFragmentParams(List<UpsellPageConfig> list, @Nullable String str) {
        this.f18543a = (UpsellPageConfig[]) list.toArray(new UpsellPageConfig[list.size()]);
        this.f18544b = str;
    }

    public UpsellFragmentParams(Parcel parcel) {
        this.f18543a = (UpsellPageConfig[]) parcel.createTypedArray(UpsellPageConfig.CREATOR);
        this.f18544b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f18543a, i);
        parcel.writeString(this.f18544b);
    }

    public final UpsellPageConfig m22464a(int i) {
        return this.f18543a[i];
    }

    public int describeContents() {
        return 0;
    }
}
