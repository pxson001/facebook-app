package com.facebook.uicontrib.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Calendar;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = DateDeserializer.class)
@JsonSerialize(using = DateSerializer.class)
/* compiled from: search_bootstrap_db */
public class Date implements Parcelable {
    public static final Creator<Date> CREATOR = new C03131();
    @JsonIgnore
    public static final Date f5241a = new Date(Calendar.getInstance().get(1), Integer.valueOf(Calendar.getInstance().get(2) + 1), Integer.valueOf(Calendar.getInstance().get(5)));
    @JsonIgnore
    public static final Date f5242b = new Date(0, null, null);
    @JsonProperty("day")
    private final Integer dayOfMonth;
    @JsonProperty("month")
    private final Integer month;
    @JsonProperty("year")
    private final int year;

    /* compiled from: search_bootstrap_db */
    final class C03131 implements Creator<Date> {
        C03131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Date(parcel);
        }

        public final Object[] newArray(int i) {
            return new Date[i];
        }
    }

    /* compiled from: search_bootstrap_db */
    public final class Builder {
        public int f5238a;
        public Integer f5239b;
        public Integer f5240c;

        public final Date m7932a() {
            return new Date(this.f5238a, this.f5239b, this.f5240c);
        }
    }

    private Date() {
        this(new Builder());
    }

    private Date(Builder builder) {
        this.year = builder.f5238a;
        this.month = builder.f5239b;
        this.dayOfMonth = builder.f5240c;
    }

    public Date(int i, Integer num, Integer num2) {
        this.year = i;
        this.month = num;
        this.dayOfMonth = num2;
    }

    public final int m7933a() {
        return this.year;
    }

    public final Integer m7934b() {
        return this.month;
    }

    public final Integer m7935c() {
        return this.dayOfMonth;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeInt(this.year);
        parcel.writeInt(this.month == null ? 0 : this.month.intValue());
        if (this.dayOfMonth != null) {
            i2 = this.dayOfMonth.intValue();
        }
        parcel.writeInt(i2);
    }

    public Date(Parcel parcel) {
        Integer num = null;
        this.year = parcel.readInt();
        int readInt = parcel.readInt();
        this.month = readInt == 0 ? null : Integer.valueOf(readInt);
        readInt = parcel.readInt();
        if (readInt != 0) {
            num = Integer.valueOf(readInt);
        }
        this.dayOfMonth = num;
    }
}
