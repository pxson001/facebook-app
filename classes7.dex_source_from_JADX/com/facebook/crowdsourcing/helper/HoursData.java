package com.facebook.crowdsourcing.helper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;

/* compiled from: com.facebook.push.crossapp.REPORT_DELETION */
public class HoursData implements Parcelable {
    public static final Creator<HoursData> CREATOR = new C14321();
    public static final ImmutableList<Integer> f17422a = ImmutableList.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7));
    private HoursForSingleDay[] f17423b;

    /* compiled from: com.facebook.push.crossapp.REPORT_DELETION */
    final class C14321 implements Creator<HoursData> {
        C14321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new HoursData(parcel);
        }

        public final Object[] newArray(int i) {
            return new HoursData[i];
        }
    }

    /* compiled from: com.facebook.push.crossapp.REPORT_DELETION */
    public class HoursForSingleDay {
        public final ImmutableList<HoursInterval> f17418a;
        public boolean f17419b;

        public HoursForSingleDay() {
            this.f17418a = RegularImmutableList.a;
            this.f17419b = false;
        }

        public HoursForSingleDay(ImmutableList<HoursInterval> immutableList) {
            this.f17418a = immutableList;
            this.f17419b = !immutableList.isEmpty();
        }

        public final boolean m21321a() {
            return this.f17419b;
        }
    }

    /* compiled from: com.facebook.push.crossapp.REPORT_DELETION */
    public class HoursInterval implements Parcelable {
        public static final Creator<HoursInterval> CREATOR = new C14331();
        public final long f17420a;
        public final long f17421b;

        /* compiled from: com.facebook.push.crossapp.REPORT_DELETION */
        final class C14331 implements Creator<HoursInterval> {
            C14331() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new HoursInterval(parcel);
            }

            public final Object[] newArray(int i) {
                return new HoursInterval[i];
            }
        }

        public HoursInterval(Parcel parcel) {
            this.f17420a = parcel.readLong();
            this.f17421b = parcel.readLong();
        }

        public HoursInterval(long j, long j2) {
            this.f17420a = j;
            this.f17421b = j2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f17420a);
            parcel.writeLong(this.f17421b);
        }
    }

    public HoursData() {
        this.f17423b = new HoursForSingleDay[(f17422a.size() + 1)];
        for (int i = 0; i < this.f17423b.length; i++) {
            this.f17423b[i] = new HoursForSingleDay();
        }
    }

    public HoursData(Parcel parcel) {
        this.f17423b = new HoursForSingleDay[(f17422a.size() + 1)];
        for (int i = 0; i < this.f17423b.length; i++) {
            boolean z;
            Collection a = Lists.a();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            parcel.readTypedList(a, HoursInterval.CREATOR);
            this.f17423b[i] = new HoursForSingleDay(ImmutableList.copyOf(a));
            this.f17423b[i].f17419b = z;
        }
    }

    public final void m21323a(int i, HoursForSingleDay hoursForSingleDay) {
        this.f17423b[i] = hoursForSingleDay;
    }

    public final HoursForSingleDay m21322a(int i) {
        return this.f17423b[i];
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        for (int i2 = 0; i2 < this.f17423b.length; i2++) {
            int i3;
            if (this.f17423b[i2].f17419b) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            parcel.writeTypedList(this.f17423b[i2].f17418a);
        }
    }
}
