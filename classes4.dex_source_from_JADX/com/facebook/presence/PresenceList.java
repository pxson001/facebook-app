package com.facebook.presence;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchStickerPacksAndStickersParams */
public class PresenceList implements Parcelable {
    public static final Creator<PresenceList> CREATOR = new C05651();
    public final ImmutableList<PresenceItem> f11723a;

    /* compiled from: fetchStickerPacksAndStickersParams */
    final class C05651 implements Creator<PresenceList> {
        C05651() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PresenceList(parcel);
        }

        public final Object[] newArray(int i) {
            return new PresenceList[i];
        }
    }

    public PresenceList(ImmutableList<PresenceItem> immutableList) {
        this.f11723a = immutableList;
    }

    public PresenceList(Parcel parcel) {
        this.f11723a = ImmutableList.copyOf(parcel.readArrayList(PresenceItem.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f11723a);
    }
}
