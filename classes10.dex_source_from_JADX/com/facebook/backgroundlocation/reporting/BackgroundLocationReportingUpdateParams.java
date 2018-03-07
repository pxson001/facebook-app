package com.facebook.backgroundlocation.reporting;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.location.LocationSignalDataPackage;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: disableContactPicker */
public class BackgroundLocationReportingUpdateParams implements Parcelable {
    public static final Creator<BackgroundLocationReportingUpdateParams> CREATOR = new C20791();
    public final ImmutableList<LocationSignalDataPackage> f14900a;
    public final ImmutableList<String> f14901b;

    /* compiled from: disableContactPicker */
    final class C20791 implements Creator<BackgroundLocationReportingUpdateParams> {
        C20791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BackgroundLocationReportingUpdateParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new BackgroundLocationReportingUpdateParams[i];
        }
    }

    public BackgroundLocationReportingUpdateParams(ImmutableList<LocationSignalDataPackage> immutableList, ImmutableList<String> immutableList2) {
        this.f14900a = immutableList;
        this.f14901b = immutableList2;
    }

    public BackgroundLocationReportingUpdateParams(Parcel parcel) {
        this.f14900a = ImmutableList.copyOf(parcel.readArrayList(LocationSignalDataPackage.class.getClassLoader()));
        this.f14901b = ImmutableList.copyOf(parcel.readArrayList(String.class.getClassLoader()));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f14900a);
        parcel.writeList(this.f14901b);
    }

    public int describeContents() {
        return 0;
    }

    public BackgroundLocationReportingUpdateParams(ImmutableList<LocationSignalDataPackage> immutableList) {
        this(immutableList, RegularImmutableList.a);
    }
}
