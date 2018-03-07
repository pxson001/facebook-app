package com.facebook.search.quickpromotion;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;

/* compiled from: TEXT_ENTITY_TAP */
public class AwarenessTutorialNuxCardConfiguration implements Parcelable {
    public static final Creator<AwarenessTutorialNuxCardConfiguration> CREATOR = new C23741();
    public final String f22337a;
    public final String f22338b;
    @Nullable
    public final Uri f22339c;
    public final String f22340d;
    public final int f22341e;

    /* compiled from: TEXT_ENTITY_TAP */
    final class C23741 implements Creator<AwarenessTutorialNuxCardConfiguration> {
        C23741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AwarenessTutorialNuxCardConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new AwarenessTutorialNuxCardConfiguration[i];
        }
    }

    public AwarenessTutorialNuxCardConfiguration(String str, String str2, Uri uri, String str3, int i) {
        this.f22337a = str;
        this.f22338b = str2;
        this.f22339c = uri;
        this.f22340d = str3;
        this.f22341e = i;
    }

    public AwarenessTutorialNuxCardConfiguration(Parcel parcel) {
        this.f22337a = parcel.readString();
        this.f22338b = parcel.readString();
        this.f22339c = Uri.parse(parcel.readString());
        this.f22340d = parcel.readString();
        this.f22341e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22337a);
        parcel.writeString(this.f22338b);
        parcel.writeString(this.f22339c != null ? this.f22339c.toString() : null);
        parcel.writeString(this.f22340d);
        parcel.writeInt(this.f22341e);
    }
}
