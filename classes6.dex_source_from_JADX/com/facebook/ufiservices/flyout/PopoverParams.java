package com.facebook.ufiservices.flyout;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: d6021821dd6956e835b3e8217068bdad */
public class PopoverParams implements Parcelable {
    public static final Creator<PopoverParams> CREATOR = new C13111();
    public boolean f18078a;

    /* compiled from: d6021821dd6956e835b3e8217068bdad */
    final class C13111 implements Creator<PopoverParams> {
        C13111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PopoverParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PopoverParams[i];
        }
    }

    /* compiled from: d6021821dd6956e835b3e8217068bdad */
    public class Builder {
        public boolean f18077a = true;

        public final PopoverParams m26563a() {
            return new PopoverParams(this);
        }
    }

    public PopoverParams(Parcel parcel) {
        this.f18078a = ParcelUtil.a(parcel);
    }

    public PopoverParams(Builder builder) {
        this.f18078a = builder.f18077a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f18078a);
    }

    public int describeContents() {
        return 0;
    }
}
