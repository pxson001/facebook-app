package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: http_status_code */
public class PlaceSuggestionMutationParams implements Parcelable {
    public static final Creator<PlaceSuggestionMutationParams> CREATOR = new C08401();
    public final String f12952a;
    public final String f12953b;
    public final String f12954c;

    /* compiled from: http_status_code */
    final class C08401 implements Creator<PlaceSuggestionMutationParams> {
        C08401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlaceSuggestionMutationParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlaceSuggestionMutationParams[i];
        }
    }

    public PlaceSuggestionMutationParams(String str, String str2, String str3) {
        this.f12952a = str;
        this.f12953b = str2;
        this.f12954c = str3;
    }

    public PlaceSuggestionMutationParams(Parcel parcel) {
        this.f12952a = parcel.readString();
        this.f12953b = parcel.readString();
        this.f12954c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12952a);
        parcel.writeString(this.f12953b);
        parcel.writeString(this.f12954c);
    }
}
