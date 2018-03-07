package com.facebook.events.permalink.guestlist.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: header_see_less_tap */
public class EventGuestSingleListModel implements Parcelable {
    public static final Creator<EventGuestSingleListModel> CREATOR = new C12491();
    public EventGuestListType f11452a;
    public Integer f11453b;
    public int f11454c;

    /* compiled from: header_see_less_tap */
    final class C12491 implements Creator<EventGuestSingleListModel> {
        C12491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventGuestSingleListModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventGuestSingleListModel[i];
        }
    }

    public EventGuestSingleListModel(EventGuestListType eventGuestListType) {
        this.f11452a = eventGuestListType;
    }

    public EventGuestSingleListModel(EventGuestListType eventGuestListType, Integer num, int i) {
        this.f11452a = eventGuestListType;
        this.f11453b = num;
        this.f11454c = i;
    }

    public EventGuestSingleListModel(Parcel parcel) {
        this.f11452a = EventGuestListType.valueOf(parcel.readString());
        this.f11453b = (Integer) parcel.readValue(null);
        this.f11454c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11452a.toString());
        parcel.writeValue(this.f11453b);
        parcel.writeInt(this.f11454c);
    }
}
