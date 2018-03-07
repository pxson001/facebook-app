package com.facebook.feedback.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: savedSelectedIds */
public class FeedbackControllerParams implements Parcelable {
    public static final Creator<FeedbackControllerParams> CREATOR = new C04201();
    public static final FeedbackControllerParams f4498a = new Builder().m5071a();
    private final Boolean f4499b;
    private final boolean f4500c;

    /* compiled from: savedSelectedIds */
    final class C04201 implements Creator<FeedbackControllerParams> {
        C04201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FeedbackControllerParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FeedbackControllerParams[i];
        }
    }

    /* compiled from: savedSelectedIds */
    public class Builder {
        public boolean f4496a;
        public boolean f4497b;

        public final FeedbackControllerParams m5071a() {
            return new FeedbackControllerParams(this);
        }
    }

    public FeedbackControllerParams(Parcel parcel) {
        this.f4499b = Boolean.valueOf(ParcelUtil.a(parcel));
        this.f4500c = ParcelUtil.a(parcel);
    }

    public FeedbackControllerParams(Builder builder) {
        this.f4499b = Boolean.valueOf(builder.f4496a);
        this.f4500c = builder.f4497b;
    }

    public final boolean m5072a() {
        return this.f4499b.booleanValue();
    }

    public final boolean m5073b() {
        return this.f4500c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f4499b.booleanValue());
        ParcelUtil.a(parcel, this.f4500c);
    }
}
