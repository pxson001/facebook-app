package com.facebook.ipc.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.uicontrib.datepicker.Date;
import com.facebook.uicontrib.datepicker.DatePicker;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerDateInfoDeserializer.class)
@JsonSerialize(using = ComposerDateInfoSerializer.class)
/* compiled from: TOGGLE_STATE */
public class ComposerDateInfo implements Parcelable {
    public static final Creator<ComposerDateInfo> CREATOR = new C13261();
    @JsonProperty("end_date")
    @Nullable
    final Date mEndDate;
    @JsonProperty("is_current")
    final boolean mIsCurrent;
    @JsonProperty("start_date")
    @Nullable
    final Date mStartDate;

    /* compiled from: TOGGLE_STATE */
    final class C13261 implements Creator<ComposerDateInfo> {
        C13261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerDateInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerDateInfo[i];
        }
    }

    /* compiled from: TOGGLE_STATE */
    public final class Builder {
        public Date f13938a;
        public Date f13939b;
        public boolean f13940c;

        public final ComposerDateInfo m23297a() {
            return new ComposerDateInfo(this);
        }
    }

    private ComposerDateInfo() {
        this(new Builder());
    }

    public ComposerDateInfo(Builder builder) {
        this.mStartDate = builder.f13938a;
        this.mEndDate = builder.f13939b;
        this.mIsCurrent = builder.f13940c;
    }

    public ComposerDateInfo(Parcel parcel) {
        this.mStartDate = (Date) parcel.readParcelable(Date.class.getClassLoader());
        this.mEndDate = (Date) parcel.readParcelable(DatePicker.class.getClassLoader());
        this.mIsCurrent = ParcelUtil.m3827a(parcel);
    }

    public final Date m23298a() {
        return this.mStartDate;
    }

    public final Date m23299b() {
        return this.mEndDate;
    }

    public final boolean m23300c() {
        return this.mIsCurrent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mStartDate, 0);
        parcel.writeParcelable(this.mEndDate, 0);
        ParcelUtil.m3826a(parcel, this.mIsCurrent);
    }
}
