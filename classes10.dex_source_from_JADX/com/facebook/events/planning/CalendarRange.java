package com.facebook.events.planning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import java.util.Calendar;
import javax.annotation.Nullable;

/* compiled from: b9c06b81d1229d13f522f3dc47cc4350 */
public class CalendarRange implements Parcelable {
    public static final Creator CREATOR = new C26921();
    public Calendar f18982a;
    @Nullable
    public Calendar f18983b;

    /* compiled from: b9c06b81d1229d13f522f3dc47cc4350 */
    final class C26921 implements Creator {
        C26921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CalendarRange(parcel);
        }

        public final Object[] newArray(int i) {
            return new CalendarRange[i];
        }
    }

    public CalendarRange(Parcel parcel) {
        m19226a(parcel);
    }

    public CalendarRange(Calendar calendar, Calendar calendar2) {
        m19227a(calendar, calendar2);
    }

    private void m19226a(Parcel parcel) {
        m19227a(m19228b(parcel), m19228b(parcel));
    }

    private static Calendar m19228b(Parcel parcel) {
        if (!ParcelUtil.a(parcel)) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(parcel.readLong());
        return instance;
    }

    private void m19227a(Calendar calendar, Calendar calendar2) {
        this.f18982a = calendar;
        this.f18983b = calendar2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        boolean z = true;
        ParcelUtil.a(parcel, this.f18982a != null);
        if (this.f18982a != null) {
            parcel.writeLong(this.f18982a.getTimeInMillis());
        }
        if (this.f18983b == null) {
            z = false;
        }
        ParcelUtil.a(parcel, z);
        if (this.f18983b != null) {
            parcel.writeLong(this.f18983b.getTimeInMillis());
        }
    }

    public int describeContents() {
        return 0;
    }
}
