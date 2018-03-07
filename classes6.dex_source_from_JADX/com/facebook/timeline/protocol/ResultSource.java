package com.facebook.timeline.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.DataFreshnessResult;

/* compiled from: db_configs_total */
public enum ResultSource implements Parcelable {
    UNDEFINED,
    DISK_CACHE,
    SERVER,
    GRAPH_CURSOR_DB;
    
    public static final Creator<ResultSource> CREATOR = null;

    /* compiled from: db_configs_total */
    final class C12891 implements Creator<ResultSource> {
        C12891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return ResultSource.values()[parcel.readInt()];
        }

        public final Object[] newArray(int i) {
            return new ResultSource[i];
        }
    }

    /* compiled from: db_configs_total */
    /* synthetic */ class C12902 {
        static final /* synthetic */ int[] f17851a = null;

        static {
            f17851a = new int[DataFreshnessResult.values().length];
            try {
                f17851a[DataFreshnessResult.FROM_SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17851a[DataFreshnessResult.FROM_CACHE_UP_TO_DATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17851a[DataFreshnessResult.FROM_CACHE_INCOMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17851a[DataFreshnessResult.FROM_CACHE_STALE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f17851a[DataFreshnessResult.FROM_CACHE_HAD_SERVER_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f17851a[DataFreshnessResult.FROM_DB_NEED_INITIAL_FETCH.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f17851a[DataFreshnessResult.NO_DATA.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    static {
        CREATOR = new C12891();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }

    public static ResultSource fromGraphQLResultDataFreshness(DataFreshnessResult dataFreshnessResult) {
        switch (C12902.f17851a[dataFreshnessResult.ordinal()]) {
            case 1:
                return SERVER;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return DISK_CACHE;
            case 7:
                throw new IllegalArgumentException("Should not get null data");
            default:
                throw new IllegalArgumentException("Unexpected freshness result: " + dataFreshnessResult);
        }
    }
}
