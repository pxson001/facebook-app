package com.facebook.search.model.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;

/* compiled from: THROWBACK_CHANGED_NOTIFICATION_SUBSCRIPTION */
public class AwarenessGraphSearchConfiguration implements Parcelable {
    public static final Creator<AwarenessGraphSearchConfiguration> CREATOR = new C23711();
    @Nullable
    private AwarenessUnitType f22317a;

    /* compiled from: THROWBACK_CHANGED_NOTIFICATION_SUBSCRIPTION */
    final class C23711 implements Creator<AwarenessGraphSearchConfiguration> {
        C23711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AwarenessGraphSearchConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new AwarenessGraphSearchConfiguration[i];
        }
    }

    /* compiled from: THROWBACK_CHANGED_NOTIFICATION_SUBSCRIPTION */
    public enum AwarenessUnitType {
        TUTORIAL_NUX
    }

    public AwarenessGraphSearchConfiguration(AwarenessUnitType awarenessUnitType) {
        this.f22317a = awarenessUnitType;
    }

    public AwarenessGraphSearchConfiguration(Parcel parcel) {
        try {
            this.f22317a = AwarenessUnitType.valueOf(parcel.readString());
        } catch (IllegalArgumentException e) {
            this.f22317a = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22317a != null ? this.f22317a.name() : "");
    }
}
