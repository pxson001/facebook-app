package com.facebook.uicontrib.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.uicontrib.datepicker.Date.Builder;
import java.util.Calendar;

/* compiled from: screenshot- */
public class Period implements Parcelable {
    public static final Creator<Period> CREATOR = new C03181();
    private static final Date f5268a;
    private static final Date f5269b;
    public Date f5270c;
    public Date f5271d;

    /* compiled from: screenshot- */
    final class C03181 implements Creator<Period> {
        C03181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Period(parcel);
        }

        public final Object[] newArray(int i) {
            return new Period[i];
        }
    }

    static {
        Builder builder = new Builder();
        builder.f5238a = Calendar.getInstance().get(1) - 99;
        builder = builder;
        builder.f5239b = Integer.valueOf(1);
        builder = builder;
        builder.f5240c = Integer.valueOf(1);
        f5268a = builder.m7932a();
        builder = new Builder();
        builder.f5238a = Calendar.getInstance().get(1);
        builder = builder;
        builder.f5239b = Integer.valueOf(12);
        builder = builder;
        builder.f5240c = Integer.valueOf(31);
        f5269b = builder.m7932a();
    }

    public Period() {
        this.f5270c = f5268a;
        this.f5271d = f5269b;
    }

    public final int m7973a() {
        if (this.f5270c == null || this.f5270c.m7933a() == 0) {
            return f5268a.m7933a();
        }
        return this.f5270c.m7933a();
    }

    public final int m7974b() {
        if (this.f5271d == null || this.f5271d.m7933a() == 0) {
            return f5269b.m7933a();
        }
        return this.f5271d.m7933a();
    }

    public final Integer m7975c() {
        if (this.f5270c == null || this.f5270c.m7934b() == null) {
            return f5268a.m7934b();
        }
        return this.f5270c.m7934b();
    }

    public final Integer m7976d() {
        if (this.f5271d == null || this.f5271d.m7934b() == null) {
            return f5269b.m7934b();
        }
        return this.f5271d.m7934b();
    }

    public final Integer m7977e() {
        if (this.f5270c == null || this.f5270c.m7935c() == null) {
            return f5268a.m7935c();
        }
        return this.f5270c.m7935c();
    }

    public final Integer m7978f() {
        if (this.f5271d == null || this.f5271d.m7935c() == null) {
            return f5269b.m7935c();
        }
        return this.f5271d.m7935c();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5270c, i);
        parcel.writeParcelable(this.f5271d, i);
    }

    public Period(Parcel parcel) {
        this.f5270c = (Date) parcel.readParcelable(Date.class.getClassLoader());
        this.f5271d = (Date) parcel.readParcelable(Date.class.getClassLoader());
    }
}
