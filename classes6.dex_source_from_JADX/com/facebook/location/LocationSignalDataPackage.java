package com.facebook.location;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.telephony.CellInfo;
import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: ¥ */
public class LocationSignalDataPackage implements Parcelable {
    public static final Creator<LocationSignalDataPackage> CREATOR = new C00061();
    @Nullable
    public final ImmutableLocation f56a;
    @Nullable
    public final Boolean f57b;
    @Nullable
    public final WifiInfo f58c;
    @Nullable
    public final List<ScanResult> f59d;
    @Nullable
    public final GeneralCellInfo f60e;
    @Nullable
    public final List<CellInfo> f61f;

    /* compiled from: ¥ */
    final class C00061 implements Creator<LocationSignalDataPackage> {
        C00061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LocationSignalDataPackage(parcel);
        }

        public final Object[] newArray(int i) {
            return new LocationSignalDataPackage[i];
        }
    }

    /* compiled from: ¥ */
    public class GeneralCellInfo implements Parcelable {
        public static final Creator<GeneralCellInfo> CREATOR = new C00071();
        @Nullable
        public final String f51a;
        @Nullable
        public final String f52b;
        @Nullable
        public final String f53c;
        @Nullable
        public final String f54d;
        public final boolean f55e;

        /* compiled from: ¥ */
        final class C00071 implements Creator<GeneralCellInfo> {
            C00071() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new GeneralCellInfo(parcel);
            }

            public final Object[] newArray(int i) {
                return new GeneralCellInfo[i];
            }
        }

        public GeneralCellInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z) {
            this.f51a = str;
            this.f52b = str2;
            this.f53c = str3;
            this.f54d = str4;
            this.f55e = z;
        }

        public GeneralCellInfo(Parcel parcel) {
            this.f51a = parcel.readString();
            this.f52b = parcel.readString();
            this.f53c = parcel.readString();
            this.f54d = parcel.readString();
            this.f55e = parcel.readByte() != (byte) 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f51a);
            parcel.writeString(this.f52b);
            parcel.writeString(this.f53c);
            parcel.writeString(this.f54d);
            parcel.writeByte(this.f55e ? (byte) 1 : (byte) 0);
        }
    }

    public LocationSignalDataPackage(@Nullable ImmutableLocation immutableLocation, @Nullable Boolean bool) {
        this(immutableLocation, bool, null, null, null, null);
    }

    public LocationSignalDataPackage(@Nullable ImmutableLocation immutableLocation, @Nullable Boolean bool, @Nullable WifiInfo wifiInfo, @Nullable List<ScanResult> list, @Nullable GeneralCellInfo generalCellInfo, @Nullable List<CellInfo> list2) {
        this.f56a = immutableLocation;
        this.f57b = bool;
        this.f58c = wifiInfo;
        this.f59d = list;
        this.f60e = generalCellInfo;
        this.f61f = list2;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("location_manager_info", this.f56a).add("is_user_in_app", this.f57b).add("wifi_scan_results", this.f59d).add("connected_wifi", this.f58c).add("general_cell_info", this.f60e).add("cell_scan", this.f61f).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f56a, i);
        parcel.writeValue(this.f57b);
        parcel.writeList(this.f59d);
        parcel.writeParcelable(this.f58c, i);
        parcel.writeParcelable(this.f60e, i);
        if (VERSION.SDK_INT >= 17) {
            parcel.writeTypedList(this.f61f);
        }
    }

    protected LocationSignalDataPackage(Parcel parcel) {
        this.f56a = (ImmutableLocation) parcel.readParcelable(ImmutableLocation.class.getClassLoader());
        this.f57b = (Boolean) parcel.readValue(null);
        this.f59d = parcel.readArrayList(ScanResult.class.getClassLoader());
        this.f58c = (WifiInfo) parcel.readParcelable(WifiInfo.class.getClassLoader());
        this.f60e = (GeneralCellInfo) parcel.readParcelable(GeneralCellInfo.class.getClassLoader());
        if (VERSION.SDK_INT >= 17) {
            this.f61f = new ArrayList();
            parcel.readTypedList(this.f61f, CellInfo.CREATOR);
            return;
        }
        this.f61f = null;
    }
}
