package com.facebook.events.create.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;

/* compiled from: confirmation_link_intent_uri */
public class EventCohostsModel implements Parcelable {
    public static final Creator<EventCohostsModel> CREATOR = new C22791();
    public ImmutableList<String> f16324a = RegularImmutableList.a;
    public String f16325b;
    public int f16326c;

    /* compiled from: confirmation_link_intent_uri */
    final class C22791 implements Creator<EventCohostsModel> {
        C22791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            Builder builder = new Builder();
            for (int i = 0; i < readInt; i++) {
                builder.c(parcel.readString());
            }
            return new EventCohostsModel(builder.b(), parcel.readString(), parcel.readInt());
        }

        public final Object[] newArray(int i) {
            return new EventCohostsModel[i];
        }
    }

    public EventCohostsModel(ImmutableList<String> immutableList, String str, int i) {
        this.f16324a = immutableList;
        this.f16325b = str;
        this.f16326c = i;
    }

    public final EventCohostsModel m16805a(ImmutableList<String> immutableList) {
        if (immutableList == null) {
            immutableList = RegularImmutableList.a;
        }
        this.f16324a = immutableList;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f16324a.size());
        int size = this.f16324a.size();
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeString((String) this.f16324a.get(i2));
        }
        parcel.writeString(this.f16325b);
        parcel.writeInt(this.f16326c);
    }
}
