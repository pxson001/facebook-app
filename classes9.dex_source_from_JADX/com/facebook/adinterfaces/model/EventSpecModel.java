package com.facebook.adinterfaces.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.EventSpec.EventBoostType;

/* compiled from: \\ */
public class EventSpecModel implements Parcelable {
    public static final Creator<EventSpecModel> CREATOR = new C25131();
    public final String f21778a;
    public final EventBoostType f21779b;

    /* compiled from: \\ */
    final class C25131 implements Creator<EventSpecModel> {
        C25131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventSpecModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventSpecModel[i];
        }
    }

    public EventSpecModel(String str, EventBoostType eventBoostType) {
        this.f21778a = str;
        this.f21779b = eventBoostType;
    }

    public EventSpecModel(Parcel parcel) {
        this.f21778a = parcel.readString();
        this.f21779b = EventBoostType.values()[parcel.readInt()];
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f21778a);
        parcel.writeInt(this.f21779b.ordinal());
    }
}
