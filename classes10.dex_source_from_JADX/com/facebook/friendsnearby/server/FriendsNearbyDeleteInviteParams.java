package com.facebook.friendsnearby.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;

/* compiled from: [I>; */
public class FriendsNearbyDeleteInviteParams implements Parcelable {
    public static final Creator<FriendsNearbyDeleteInviteParams> CREATOR = new C29501();
    public final String f20673a;
    public final ImmutableList<String> f20674b = ImmutableList.of("CURRENT_LOCATION");

    /* compiled from: [I>; */
    final class C29501 implements Creator<FriendsNearbyDeleteInviteParams> {
        C29501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FriendsNearbyDeleteInviteParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FriendsNearbyDeleteInviteParams[i];
        }
    }

    public FriendsNearbyDeleteInviteParams(String str) {
        this.f20673a = str;
    }

    public FriendsNearbyDeleteInviteParams(Parcel parcel) {
        this.f20673a = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f20673a);
    }

    public int describeContents() {
        return 0;
    }
}
