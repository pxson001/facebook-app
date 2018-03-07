package com.facebook.events.create.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: confirmation_title_text */
public class EventCategoryModel implements Parcelable {
    public static final Creator<EventCategoryModel> CREATOR = new C22781();
    public String f16316a;
    public String f16317b;

    /* compiled from: confirmation_title_text */
    final class C22781 implements Creator<EventCategoryModel> {
        C22781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventCategoryModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventCategoryModel[i];
        }
    }

    public EventCategoryModel(Parcel parcel) {
        this.f16316a = parcel.readString();
        this.f16317b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16316a);
        parcel.writeString(this.f16317b);
    }
}
