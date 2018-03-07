package com.facebook.interstitial.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: street_2 */
public class FetchInterstitialsParams implements Parcelable {
    public static final Creator<FetchInterstitialsParams> CREATOR = new C00901();
    public final ImmutableList<String> f1645a;

    /* compiled from: street_2 */
    final class C00901 implements Creator<FetchInterstitialsParams> {
        C00901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchInterstitialsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchInterstitialsParams[i];
        }
    }

    public FetchInterstitialsParams(ImmutableList<String> immutableList) {
        this.f1645a = immutableList;
    }

    public FetchInterstitialsParams(Parcel parcel) {
        this.f1645a = ImmutableList.copyOf(parcel.readArrayList(String.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f1645a);
    }
}
