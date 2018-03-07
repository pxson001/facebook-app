package com.facebook.events.ui.date;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import java.sql.Date;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: application_request_unblock_application */
public class EventTimeModel implements Parcelable {
    public static final Creator<EventTimeModel> CREATOR = new C27481();
    private final TimeZone f19386a = TimeZone.getDefault();
    public boolean f19387b;
    public TimeZone f19388c;
    public long f19389d;
    public long f19390e;

    /* compiled from: application_request_unblock_application */
    final class C27481 implements Creator<EventTimeModel> {
        C27481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventTimeModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventTimeModel[i];
        }
    }

    public EventTimeModel() {
        m19539a(false, this.f19386a, 0, 0);
    }

    public final EventTimeModel m19539a(boolean z, TimeZone timeZone, long j, long j2) {
        this.f19387b = z;
        if (timeZone == null) {
            timeZone = this.f19386a;
        }
        this.f19388c = timeZone;
        m19536a(j);
        m19537b(j2);
        return this;
    }

    public final EventTimeModel m19538a(long j, long j2) {
        m19536a(j);
        m19537b(j2);
        return this;
    }

    private void m19536a(long j) {
        if (j <= 0) {
            Calendar instance = Calendar.getInstance(this.f19388c);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            instance.add(11, 1);
            j = instance.getTimeInMillis();
        }
        this.f19389d = j;
    }

    private void m19537b(long j) {
        if (this.f19387b) {
            j = this.f19389d + 86399999;
        } else if (j <= 0) {
            j = 0;
        }
        this.f19390e = j;
    }

    public final Date m19540d() {
        return new Date(this.f19389d);
    }

    public final boolean m19541e() {
        return this.f19390e != 0;
    }

    public final Date m19542g() {
        return m19541e() ? new Date(this.f19390e) : null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f19387b);
        parcel.writeString(this.f19388c.getID());
        parcel.writeLong(this.f19389d);
        parcel.writeLong(this.f19390e);
    }

    public EventTimeModel(Parcel parcel) {
        this.f19387b = ParcelUtil.a(parcel);
        this.f19388c = TimeZone.getTimeZone(parcel.readString());
        this.f19389d = parcel.readLong();
        this.f19390e = parcel.readLong();
    }
}
