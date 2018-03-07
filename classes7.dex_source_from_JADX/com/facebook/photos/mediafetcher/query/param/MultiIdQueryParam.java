package com.facebook.photos.mediafetcher.query.param;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.photos.mediafetcher.interfaces.QueryParam;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: kddi */
public class MultiIdQueryParam extends QueryParam {
    public static final Creator<MultiIdQueryParam> CREATOR = new C09041();
    public final ImmutableList<String> f10640a;

    /* compiled from: kddi */
    final class C09041 implements Creator<MultiIdQueryParam> {
        C09041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MultiIdQueryParam(ImmutableList.copyOf(parcel.readArrayList(MultiIdQueryParam.CREATOR.getClass().getClassLoader())));
        }

        public final Object[] newArray(int i) {
            return new MultiIdQueryParam[i];
        }
    }

    public MultiIdQueryParam(ImmutableList<String> immutableList) {
        this.f10640a = (ImmutableList) Preconditions.checkNotNull(immutableList);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f10640a);
    }
}
