package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: openDrawer */
public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Object> {
    public static final Creator<ShareOpenGraphObject> CREATOR = new C06231();

    /* compiled from: openDrawer */
    final class C06231 implements Creator<ShareOpenGraphObject> {
        C06231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShareOpenGraphObject(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShareOpenGraphObject[i];
        }
    }

    ShareOpenGraphObject(Parcel parcel) {
        super(parcel);
    }
}
