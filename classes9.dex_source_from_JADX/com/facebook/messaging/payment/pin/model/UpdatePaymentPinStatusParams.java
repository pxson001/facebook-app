package com.facebook.messaging.payment.pin.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.TriState;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: had_high_score */
public class UpdatePaymentPinStatusParams implements Parcelable {
    public static final Creator<UpdatePaymentPinStatusParams> CREATOR = new C15461();
    public static String f13722a = "updatePaymentPinStatusParams";
    public final long f13723b;
    public final String f13724c;
    public final String f13725d;
    public final TriState f13726e;
    private final Map<String, String> f13727f;

    /* compiled from: had_high_score */
    final class C15461 implements Creator<UpdatePaymentPinStatusParams> {
        C15461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpdatePaymentPinStatusParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpdatePaymentPinStatusParams[i];
        }
    }

    public UpdatePaymentPinStatusParams(long j, String str, @Nullable String str2, @Nullable TriState triState, @Nullable Map<Long, Boolean> map) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        this.f13723b = j;
        this.f13724c = str;
        this.f13725d = str2;
        this.f13726e = triState;
        if (map == null) {
            this.f13727f = null;
            return;
        }
        this.f13727f = new HashMap();
        for (Entry entry : map.entrySet()) {
            this.f13727f.put(((Long) entry.getKey()).toString(), ((Boolean) entry.getValue()).toString());
        }
    }

    public UpdatePaymentPinStatusParams(Parcel parcel) {
        this.f13723b = parcel.readLong();
        this.f13724c = parcel.readString();
        this.f13725d = parcel.readString();
        this.f13726e = ParcelUtil.g(parcel);
        this.f13727f = new HashMap();
        ParcelUtil.b(parcel, this.f13727f);
    }

    @Nullable
    public final ImmutableMap<String, String> m14265e() {
        return this.f13727f == null ? null : ImmutableMap.copyOf(this.f13727f);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("pinId", this.f13723b).add("paymentsProtected", this.f13726e).add("threadProfilesProtected", this.f13727f).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f13723b);
        parcel.writeString(this.f13724c);
        parcel.writeString(this.f13725d);
        ParcelUtil.a(parcel, this.f13726e);
        ParcelUtil.a(parcel, this.f13727f);
    }
}
