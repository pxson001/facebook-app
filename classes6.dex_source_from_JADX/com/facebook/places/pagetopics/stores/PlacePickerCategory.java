package com.facebook.places.pagetopics.stores;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.model.PageTopic;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;

/* compiled from: flight_number */
public class PlacePickerCategory implements Parcelable {
    public static final Creator<PlacePickerCategory> CREATOR = new C09551();
    public final String f14793a;
    public final long f14794b;
    public final String f14795c;
    public final ImmutableList<String> f14796d;

    /* compiled from: flight_number */
    final class C09551 implements Creator<PlacePickerCategory> {
        C09551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            String readString2 = parcel.readString();
            Collection a = Lists.a();
            parcel.readStringList(a);
            return new PlacePickerCategory(readString, readLong, readString2, ImmutableList.copyOf(a));
        }

        public final Object[] newArray(int i) {
            return new PlacePickerCategory[i];
        }
    }

    public PlacePickerCategory(String str, long j, String str2, ImmutableList<String> immutableList) {
        this.f14793a = str;
        this.f14794b = j;
        this.f14795c = str2;
        this.f14796d = immutableList;
    }

    public final PageTopic m22450a() {
        return new PageTopic(this.f14794b, this.f14795c, null, RegularImmutableList.a, 0);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14793a);
        parcel.writeLong(this.f14794b);
        parcel.writeString(this.f14795c);
        parcel.writeStringList(this.f14796d);
    }
}
