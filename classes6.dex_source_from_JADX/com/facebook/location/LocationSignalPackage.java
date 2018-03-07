package com.facebook.location;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.telephony.CellInfo;
import com.facebook.location.LocationSignalDataPackage.GeneralCellInfo;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: £ */
public class LocationSignalPackage {
    public final LocationSignalDataPackage f70a;
    public final LocationSignalThrowablePackage f71b;

    /* compiled from: £ */
    public class Builder {
        @Nullable
        private ImmutableLocation f62a;
        @Nullable
        private Throwable f63b;
        @Nullable
        private Boolean f64c;
        @Nullable
        private List<ScanResult> f65d;
        @Nullable
        private Throwable f66e;
        @Nullable
        private WifiInfo f67f;
        @Nullable
        private GeneralCellInfo f68g;
        @Nullable
        private List<CellInfo> f69h;

        public final Builder m49a(Object obj) {
            if (obj instanceof Throwable) {
                this.f62a = null;
                this.f63b = (Throwable) obj;
            } else {
                this.f62a = (ImmutableLocation) obj;
                this.f63b = null;
            }
            return this;
        }

        public final Builder m48a(Boolean bool) {
            this.f64c = bool;
            return this;
        }

        public final Builder m52b(Object obj) {
            if (obj instanceof Throwable) {
                this.f65d = null;
                this.f66e = (Throwable) obj;
            } else {
                this.f65d = (List) obj;
                this.f66e = null;
            }
            return this;
        }

        public final Builder m46a(WifiInfo wifiInfo) {
            this.f67f = wifiInfo;
            return this;
        }

        public final Builder m47a(@Nullable GeneralCellInfo generalCellInfo) {
            this.f68g = generalCellInfo;
            return this;
        }

        public final Builder m50a(@Nullable List<CellInfo> list) {
            this.f69h = list;
            return this;
        }

        public final LocationSignalPackage m51a() {
            return new LocationSignalPackage(this.f62a, this.f63b, this.f64c, this.f65d, this.f66e, this.f67f, this.f68g, this.f69h);
        }
    }

    private LocationSignalPackage(@Nullable ImmutableLocation immutableLocation, @Nullable Throwable th, @Nullable Boolean bool, @Nullable List<ScanResult> list, @Nullable Throwable th2, @Nullable WifiInfo wifiInfo, @Nullable GeneralCellInfo generalCellInfo, @Nullable List<CellInfo> list2) {
        int i;
        int i2 = 1;
        Preconditions.checkState((th == null ? 1 : 0) ^ (immutableLocation == null ? 1 : 0));
        if (list == null) {
            i = 1;
        } else {
            i = 0;
        }
        if (th2 != null) {
            i2 = 0;
        }
        Preconditions.checkState(i ^ i2);
        this.f70a = new LocationSignalDataPackage(immutableLocation, bool, wifiInfo, list, generalCellInfo, list2);
        this.f71b = new LocationSignalThrowablePackage(th, th2);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("data", this.f70a).add("throwables", this.f71b).toString();
    }

    public static Builder m53a() {
        return new Builder();
    }
}
