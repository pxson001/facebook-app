package com.facebook.vault.momentsupsell.model;

import android.os.Parcel;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: thread_message_view */
public class ParcelableHelper {
    @Nullable
    public static ImmutableList<String> m1904a(Parcel parcel) {
        Collection createStringArrayList = parcel.createStringArrayList();
        return createStringArrayList == null ? null : ImmutableList.copyOf(createStringArrayList);
    }
}
