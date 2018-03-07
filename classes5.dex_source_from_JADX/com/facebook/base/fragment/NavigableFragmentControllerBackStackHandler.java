package com.facebook.base.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;

/* compiled from: subscription_status */
public class NavigableFragmentControllerBackStackHandler {
    private static final Class<?> f2446a = NavigableFragmentControllerBackStackHandler.class;
    public final ArrayList<ShadowBackstackEntry> f2447b;

    /* compiled from: subscription_status */
    public class ShadowBackstackEntry implements Parcelable {
        public static final Creator<ShadowBackstackEntry> CREATOR = new C01621();
        public final String f2444a;
        public final boolean f2445b;

        /* compiled from: subscription_status */
        final class C01621 implements Creator<ShadowBackstackEntry> {
            C01621() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new ShadowBackstackEntry(parcel);
            }

            public final Object[] newArray(int i) {
                return new ShadowBackstackEntry[i];
            }
        }

        public ShadowBackstackEntry(String str, boolean z) {
            this.f2444a = str;
            this.f2445b = z;
        }

        public ShadowBackstackEntry(Parcel parcel) {
            boolean z = true;
            this.f2444a = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f2445b = z;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f2444a);
            parcel.writeInt(this.f2445b ? 1 : 0);
        }
    }

    public NavigableFragmentControllerBackStackHandler() {
        this.f2447b = Lists.a();
    }

    public NavigableFragmentControllerBackStackHandler(ArrayList<ShadowBackstackEntry> arrayList) {
        this.f2447b = arrayList;
    }

    public final ImmutableList<String> m3546a(String str, boolean z, boolean z2) {
        Builder builder = ImmutableList.builder();
        if (z2 && !this.f2447b.isEmpty()) {
            ShadowBackstackEntry shadowBackstackEntry = (ShadowBackstackEntry) this.f2447b.get(this.f2447b.size() - 1);
            for (int i = 0; i < this.f2447b.size() - 1; i++) {
                ShadowBackstackEntry shadowBackstackEntry2 = (ShadowBackstackEntry) this.f2447b.get(i);
                if (!shadowBackstackEntry2.f2445b) {
                    builder.c(shadowBackstackEntry2.f2444a);
                }
            }
            this.f2447b.clear();
            if (z) {
                this.f2447b.add(new ShadowBackstackEntry(shadowBackstackEntry.f2444a, false));
            }
        }
        this.f2447b.add(new ShadowBackstackEntry(str, z));
        return builder.b();
    }
}
