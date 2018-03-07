package com.facebook.photos.creativeediting.model;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: t. */
public class CreativeEditingUploadParams implements Parcelable {
    public static final Creator<CreativeEditingUploadParams> CREATOR = new C02131();
    public final CreativeEditingData f3381a;
    public final ImmutableList<RectF> f3382b;

    /* compiled from: t. */
    final class C02131 implements Creator<CreativeEditingUploadParams> {
        C02131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreativeEditingUploadParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreativeEditingUploadParams[i];
        }
    }

    public CreativeEditingUploadParams(CreativeEditingData creativeEditingData, List<RectF> list) {
        Preconditions.checkNotNull(creativeEditingData);
        Preconditions.checkNotNull(list);
        this.f3381a = creativeEditingData;
        this.f3382b = ImmutableList.copyOf(list);
    }

    public CreativeEditingUploadParams(Parcel parcel) {
        this.f3381a = (CreativeEditingData) parcel.readParcelable(CreativeEditingData.class.getClassLoader());
        this.f3382b = ImmutableList.copyOf(parcel.readArrayList(RectF.class.getClassLoader()));
    }

    public final CreativeEditingData m4459a() {
        return this.f3381a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3381a, i);
        parcel.writeList(this.f3382b);
    }
}
