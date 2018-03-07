package com.facebook.places.create;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.places.checkin.analytics.PlacePickerSessionData;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: center_vertical */
public class BellerophonLoggerData implements Parcelable {
    public static final Creator<BellerophonLoggerData> CREATOR = new C19591();
    public PlacePickerSessionData f18122a;
    public String f18123b;
    public String f18124c;
    public List<String> f18125d;

    /* compiled from: center_vertical */
    final class C19591 implements Creator<BellerophonLoggerData> {
        C19591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BellerophonLoggerData(parcel);
        }

        public final Object[] newArray(int i) {
            return new BellerophonLoggerData[i];
        }
    }

    public BellerophonLoggerData(PlacePickerSessionData placePickerSessionData) {
        Preconditions.checkNotNull(placePickerSessionData);
        this.f18122a = placePickerSessionData;
        this.f18123b = SafeUUIDGenerator.a().toString();
    }

    protected BellerophonLoggerData(Parcel parcel) {
        this.f18122a = (PlacePickerSessionData) parcel.readParcelable(PlacePickerSessionData.class.getClassLoader());
        this.f18123b = parcel.readString();
        this.f18124c = parcel.readString();
        this.f18125d = Lists.a();
        parcel.readList(this.f18125d, List.class.getClassLoader());
    }

    public final long m22107d() {
        return this.f18122a.c;
    }

    public final List<String> m22108f() {
        return this.f18125d == null ? null : ImmutableList.copyOf(this.f18125d);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f18122a, i);
        parcel.writeString(this.f18123b);
        parcel.writeString(this.f18124c);
        parcel.writeList(this.f18125d);
    }
}
