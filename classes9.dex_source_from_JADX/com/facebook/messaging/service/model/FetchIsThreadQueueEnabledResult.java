package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: createHomescreenShortcut() not supported yet */
public class FetchIsThreadQueueEnabledResult implements Parcelable {
    public static final Creator<FetchIsThreadQueueEnabledResult> CREATOR = new C20121();
    public final boolean f17062a;

    /* compiled from: createHomescreenShortcut() not supported yet */
    final class C20121 implements Creator<FetchIsThreadQueueEnabledResult> {
        C20121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchIsThreadQueueEnabledResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchIsThreadQueueEnabledResult[i];
        }
    }

    public FetchIsThreadQueueEnabledResult(boolean z) {
        this.f17062a = z;
    }

    public FetchIsThreadQueueEnabledResult(Parcel parcel) {
        this.f17062a = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f17062a);
    }
}
