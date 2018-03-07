package com.facebook.messaging.analytics.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_initiate_change_pin */
public class NavigationLogs implements Parcelable {
    public static final Creator<NavigationLogs> CREATOR = new C08481();
    public final ImmutableMap<String, String> f7635a;

    /* compiled from: p2p_initiate_change_pin */
    final class C08481 implements Creator<NavigationLogs> {
        C08481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NavigationLogs(parcel);
        }

        public final Object[] newArray(int i) {
            return new NavigationLogs[i];
        }
    }

    public NavigationLogs(Parcel parcel) {
        this.f7635a = (ImmutableMap) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f7635a);
    }
}
