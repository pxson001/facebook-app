package com.facebook.nearby.v2.typeahead.logging;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;

/* compiled from: parent_control_title_bar */
public class NearbyPlacesTypeaheadLoggerData implements Parcelable {
    public static final Creator<NearbyPlacesTypeaheadLoggerData> CREATOR = new C07351();
    public String f5208a;
    public String f5209b;

    /* compiled from: parent_control_title_bar */
    final class C07351 implements Creator<NearbyPlacesTypeaheadLoggerData> {
        C07351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesTypeaheadLoggerData(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesTypeaheadLoggerData[i];
        }
    }

    public NearbyPlacesTypeaheadLoggerData() {
        m4674a();
        m4675b();
    }

    public NearbyPlacesTypeaheadLoggerData(Parcel parcel) {
        this.f5208a = parcel.readString();
        this.f5209b = parcel.readString();
    }

    public final void m4674a() {
        this.f5208a = SafeUUIDGenerator.a().toString();
    }

    public final void m4675b() {
        this.f5209b = SafeUUIDGenerator.a().toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5208a);
        parcel.writeString(this.f5209b);
    }

    public int describeContents() {
        return 0;
    }
}
