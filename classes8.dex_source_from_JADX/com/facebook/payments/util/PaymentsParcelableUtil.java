package com.facebook.payments.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: story_tap */
public class PaymentsParcelableUtil {
    @Nullable
    public static <T extends Parcelable> ImmutableList<T> m2246a(Parcel parcel, Class<T> cls) {
        Collection readArrayList = parcel.readArrayList(cls.getClassLoader());
        return readArrayList != null ? ImmutableList.copyOf(readArrayList) : null;
    }

    @Nullable
    public static <T extends Parcelable> Optional<T> m2248b(Parcel parcel, Class<T> cls) {
        if (ParcelUtil.a(parcel)) {
            return Optional.fromNullable(parcel.readParcelable(cls.getClassLoader()));
        }
        return null;
    }

    public static <T extends Parcelable> void m2247a(Optional<T> optional, Parcel parcel, int i) {
        boolean z = optional != null;
        ParcelUtil.a(parcel, z);
        if (z) {
            parcel.writeParcelable((Parcelable) optional.orNull(), i);
        }
    }
}
