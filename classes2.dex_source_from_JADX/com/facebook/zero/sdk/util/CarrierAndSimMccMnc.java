package com.facebook.zero.sdk.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

/* compiled from: fonts/Roboto-Black.ttf */
public class CarrierAndSimMccMnc implements Parcelable {
    public static final Creator<CarrierAndSimMccMnc> CREATOR = new C09601();
    public static final CarrierAndSimMccMnc f23517a = new CarrierAndSimMccMnc(null, null);
    public final MccMncPair f23518b;
    public final MccMncPair f23519c;

    /* compiled from: fonts/Roboto-Black.ttf */
    final class C09601 implements Creator<CarrierAndSimMccMnc> {
        C09601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CarrierAndSimMccMnc(parcel);
        }

        public final Object[] newArray(int i) {
            return new CarrierAndSimMccMnc[i];
        }
    }

    /* compiled from: fonts/Roboto-Black.ttf */
    public class MccMncPair implements Parcelable {
        public static final Creator<MccMncPair> CREATOR = new C09611();
        public final String f23520a;
        public final String f23521b;

        /* compiled from: fonts/Roboto-Black.ttf */
        final class C09611 implements Creator<MccMncPair> {
            C09611() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new MccMncPair(parcel);
            }

            public final Object[] newArray(int i) {
                return new MccMncPair[i];
            }
        }

        public MccMncPair(String str, String str2) {
            this.f23520a = str;
            this.f23521b = str2;
        }

        public MccMncPair(Parcel parcel) {
            this.f23520a = parcel.readString();
            this.f23521b = parcel.readString();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof MccMncPair)) {
                return false;
            }
            return this.f23520a.equals(((MccMncPair) obj).f23520a) && this.f23521b.equals(((MccMncPair) obj).f23521b);
        }

        public int hashCode() {
            return Objects.hashCode(this.f23520a, this.f23521b);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f23520a);
            parcel.writeString(this.f23521b);
        }
    }

    public CarrierAndSimMccMnc(MccMncPair mccMncPair, MccMncPair mccMncPair2) {
        this.f23518b = mccMncPair;
        this.f23519c = mccMncPair2;
    }

    public CarrierAndSimMccMnc(String str) {
        ImmutableList copyOf = ImmutableList.copyOf(str.split(":"));
        if (copyOf.size() != 4) {
            this.f23518b = null;
            this.f23519c = null;
            return;
        }
        this.f23518b = new MccMncPair((String) copyOf.get(0), (String) copyOf.get(1));
        this.f23519c = new MccMncPair((String) copyOf.get(2), (String) copyOf.get(3));
    }

    public CarrierAndSimMccMnc(Parcel parcel) {
        this.f23518b = (MccMncPair) parcel.readParcelable(MccMncPair.class.getClassLoader());
        this.f23519c = (MccMncPair) parcel.readParcelable(MccMncPair.class.getClassLoader());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CarrierAndSimMccMnc)) {
            return false;
        }
        CarrierAndSimMccMnc carrierAndSimMccMnc = (CarrierAndSimMccMnc) obj;
        if (Objects.equal(this.f23518b, carrierAndSimMccMnc.f23518b) && Objects.equal(this.f23519c, carrierAndSimMccMnc.f23519c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f23518b, this.f23519c);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f23518b, i);
        parcel.writeParcelable(this.f23519c, i);
    }
}
