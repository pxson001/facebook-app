package com.facebook.fbservice.results;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.TriState;
import com.facebook.common.util.TriStateUtil;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: results_title */
public class DataFetchDisposition implements Parcelable {
    public static final Creator<DataFetchDisposition> CREATOR = new C02217();
    public static final DataFetchDisposition f3023a = new DataFetchDisposition();
    public static final DataFetchDisposition f3024b;
    public static final DataFetchDisposition f3025c;
    public static final DataFetchDisposition f3026d;
    public static final DataFetchDisposition f3027e;
    public static final DataFetchDisposition f3028f;
    public static final DataFetchDisposition f3029g;
    public static final DataFetchDisposition f3030h;
    public static final DataFetchDisposition f3031i;
    public static final DataFetchDisposition f3032j;
    public static final DataFetchDisposition f3033k;
    public final boolean f3034l;
    public final DataSource f3035m;
    public final TriState f3036n;
    public final TriState f3037o;
    public final TriState f3038p;
    public final TriState f3039q;
    public final TriState f3040r;
    public final TriState f3041s;

    /* compiled from: results_title */
    final class C02151 implements Function<DataFetchDisposition, TriState> {
        C02151() {
        }

        public final Object apply(Object obj) {
            return ((DataFetchDisposition) obj).f3036n;
        }
    }

    /* compiled from: results_title */
    final class C02162 implements Function<DataFetchDisposition, TriState> {
        C02162() {
        }

        public final Object apply(Object obj) {
            return ((DataFetchDisposition) obj).f3037o;
        }
    }

    /* compiled from: results_title */
    final class C02173 implements Function<DataFetchDisposition, TriState> {
        C02173() {
        }

        public final Object apply(Object obj) {
            return ((DataFetchDisposition) obj).f3038p;
        }
    }

    /* compiled from: results_title */
    final class C02184 implements Function<DataFetchDisposition, TriState> {
        C02184() {
        }

        public final Object apply(Object obj) {
            return ((DataFetchDisposition) obj).f3039q;
        }
    }

    /* compiled from: results_title */
    final class C02195 implements Function<DataFetchDisposition, TriState> {
        C02195() {
        }

        public final Object apply(Object obj) {
            return ((DataFetchDisposition) obj).f3040r;
        }
    }

    /* compiled from: results_title */
    final class C02206 implements Function<DataFetchDisposition, TriState> {
        C02206() {
        }

        public final Object apply(Object obj) {
            return ((DataFetchDisposition) obj).f3041s;
        }
    }

    /* compiled from: results_title */
    final class C02217 implements Creator<DataFetchDisposition> {
        C02217() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DataFetchDisposition(parcel);
        }

        public final Object[] newArray(int i) {
            return new DataFetchDisposition[i];
        }
    }

    /* compiled from: results_title */
    public enum DataSource {
        IN_MEMORY_CACHE,
        LOCAL_DISK_CACHE,
        LOCAL_UNSPECIFIED_CACHE,
        SERVER,
        SMS,
        COMPOSED;

        public final boolean isLocal() {
            return this == IN_MEMORY_CACHE || this == LOCAL_DISK_CACHE || this == LOCAL_UNSPECIFIED_CACHE;
        }
    }

    static {
        DataFetchDispositionBuilder newBuilder = newBuilder();
        newBuilder.f3042a = DataSource.SERVER;
        newBuilder = newBuilder;
        newBuilder.f3043b = TriState.YES;
        newBuilder = newBuilder;
        newBuilder.f3044c = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3048g = TriState.NO;
        f3024b = newBuilder.m4200h();
        newBuilder = newBuilder();
        newBuilder.f3042a = DataSource.IN_MEMORY_CACHE;
        newBuilder = newBuilder;
        newBuilder.f3043b = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3044c = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3048g = TriState.NO;
        f3025c = newBuilder.m4200h();
        newBuilder = newBuilder();
        newBuilder.f3042a = DataSource.IN_MEMORY_CACHE;
        newBuilder = newBuilder;
        newBuilder.f3043b = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3044c = TriState.YES;
        newBuilder = newBuilder;
        newBuilder.f3048g = TriState.NO;
        f3026d = newBuilder.m4200h();
        newBuilder = newBuilder();
        newBuilder.f3042a = DataSource.LOCAL_DISK_CACHE;
        newBuilder = newBuilder;
        newBuilder.f3043b = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3044c = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3048g = TriState.NO;
        f3027e = newBuilder.m4200h();
        newBuilder = newBuilder();
        newBuilder.f3042a = DataSource.LOCAL_DISK_CACHE;
        newBuilder = newBuilder;
        newBuilder.f3043b = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3044c = TriState.YES;
        newBuilder = newBuilder;
        newBuilder.f3048g = TriState.NO;
        f3028f = newBuilder.m4200h();
        newBuilder = newBuilder();
        newBuilder.f3042a = DataSource.LOCAL_UNSPECIFIED_CACHE;
        newBuilder = newBuilder;
        newBuilder.f3043b = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3044c = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3048g = TriState.NO;
        f3029g = newBuilder.m4200h();
        newBuilder = newBuilder();
        newBuilder.f3042a = DataSource.LOCAL_UNSPECIFIED_CACHE;
        newBuilder = newBuilder;
        newBuilder.f3043b = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3044c = TriState.YES;
        newBuilder = newBuilder;
        newBuilder.f3048g = TriState.NO;
        f3030h = newBuilder.m4200h();
        newBuilder = newBuilder();
        newBuilder.f3042a = DataSource.LOCAL_UNSPECIFIED_CACHE;
        newBuilder = newBuilder;
        newBuilder.f3043b = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3044c = TriState.YES;
        newBuilder = newBuilder;
        newBuilder.f3046e = TriState.YES;
        newBuilder = newBuilder;
        newBuilder.f3048g = TriState.NO;
        f3031i = newBuilder.m4200h();
        newBuilder = newBuilder();
        newBuilder.f3042a = DataSource.LOCAL_UNSPECIFIED_CACHE;
        newBuilder = newBuilder;
        newBuilder.f3043b = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3045d = TriState.YES;
        newBuilder = newBuilder;
        newBuilder.f3048g = TriState.NO;
        f3032j = newBuilder.m4200h();
        newBuilder = newBuilder();
        newBuilder.f3042a = DataSource.SMS;
        newBuilder = newBuilder;
        newBuilder.f3043b = TriState.YES;
        newBuilder = newBuilder;
        newBuilder.f3044c = TriState.NO;
        newBuilder = newBuilder;
        newBuilder.f3048g = TriState.NO;
        f3033k = newBuilder.m4200h();
    }

    private DataFetchDisposition() {
        this.f3034l = false;
        this.f3035m = null;
        this.f3036n = TriState.UNSET;
        this.f3037o = TriState.UNSET;
        this.f3038p = TriState.UNSET;
        this.f3039q = TriState.UNSET;
        this.f3040r = TriState.UNSET;
        this.f3041s = TriState.UNSET;
    }

    DataFetchDisposition(DataFetchDispositionBuilder dataFetchDispositionBuilder) {
        this.f3034l = true;
        this.f3035m = (DataSource) Preconditions.checkNotNull(dataFetchDispositionBuilder.f3042a);
        this.f3036n = (TriState) Preconditions.checkNotNull(dataFetchDispositionBuilder.f3043b);
        this.f3037o = (TriState) Preconditions.checkNotNull(dataFetchDispositionBuilder.f3044c);
        this.f3038p = (TriState) Preconditions.checkNotNull(dataFetchDispositionBuilder.f3045d);
        this.f3039q = (TriState) Preconditions.checkNotNull(dataFetchDispositionBuilder.f3046e);
        this.f3040r = (TriState) Preconditions.checkNotNull(dataFetchDispositionBuilder.f3047f);
        this.f3041s = (TriState) Preconditions.checkNotNull(dataFetchDispositionBuilder.f3048g);
    }

    public DataFetchDisposition(Parcel parcel) {
        this.f3034l = ParcelUtil.m3827a(parcel);
        this.f3035m = (DataSource) parcel.readSerializable();
        this.f3036n = (TriState) parcel.readSerializable();
        this.f3037o = (TriState) parcel.readSerializable();
        this.f3038p = (TriState) parcel.readSerializable();
        this.f3039q = (TriState) parcel.readSerializable();
        this.f3040r = (TriState) parcel.readSerializable();
        this.f3041s = (TriState) parcel.readSerializable();
    }

    public static DataFetchDispositionBuilder newBuilder() {
        return new DataFetchDispositionBuilder();
    }

    public static DataFetchDisposition m4193a(List<DataFetchDisposition> list) {
        if (list.isEmpty()) {
            return f3023a;
        }
        if (list.size() == 1) {
            return (DataFetchDisposition) list.get(0);
        }
        int i;
        for (DataFetchDisposition dataFetchDisposition : list) {
            if (dataFetchDisposition != f3023a) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i != 0) {
            return f3023a;
        }
        DataFetchDispositionBuilder newBuilder = newBuilder();
        newBuilder.f3042a = DataSource.COMPOSED;
        newBuilder.f3043b = TriStateUtil.m3929a(Lists.a(list, new C02151()), TriStateUtil.f2794a, TriState.NO);
        newBuilder.f3044c = TriStateUtil.m3929a(Lists.a(list, new C02162()), TriStateUtil.f2795b, TriState.YES);
        newBuilder.f3045d = TriStateUtil.m3929a(Lists.a(list, new C02173()), TriStateUtil.f2795b, TriState.YES);
        newBuilder.f3046e = TriStateUtil.m3929a(Lists.a(list, new C02184()), TriStateUtil.f2795b, TriState.YES);
        newBuilder.f3047f = TriStateUtil.m3929a(Lists.a(list, new C02195()), TriStateUtil.f2795b, TriState.YES);
        newBuilder.f3048g = TriStateUtil.m3929a(Lists.a(list, new C02206()), TriStateUtil.f2795b, TriState.YES);
        return newBuilder.m4200h();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.m3826a(parcel, this.f3034l);
        parcel.writeSerializable(this.f3035m);
        parcel.writeSerializable(this.f3036n);
        parcel.writeSerializable(this.f3037o);
        parcel.writeSerializable(this.f3038p);
        parcel.writeSerializable(this.f3039q);
        parcel.writeSerializable(this.f3040r);
        parcel.writeSerializable(this.f3041s);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataSource", this.f3035m).add("fromAuthoritativeData", this.f3036n).add("isStaleData", this.f3037o).add("isIncompleteData", this.f3038p).add("fellbackToCachedDataAfterFailedToHitServer", this.f3039q).add("needsInitialFetch", this.f3040r).add("wasFetchSynchronous", this.f3041s).toString();
    }
}
