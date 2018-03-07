package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: createStoryPromotion */
public class FetchIdentityKeysResult implements Parcelable {
    public static final Creator<FetchIdentityKeysResult> CREATOR = new C20101();
    public final ImmutableMap<String, String> f17059a;

    /* compiled from: createStoryPromotion */
    final class C20101 implements Creator<FetchIdentityKeysResult> {
        C20101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchIdentityKeysResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchIdentityKeysResult[i];
        }
    }

    public FetchIdentityKeysResult(Parcel parcel) {
        Map hashMap = new HashMap();
        ParcelUtil.b(parcel, hashMap);
        this.f17059a = ImmutableMap.copyOf(hashMap);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f17059a);
    }
}
