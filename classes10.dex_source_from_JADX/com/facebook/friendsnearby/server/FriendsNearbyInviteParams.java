package com.facebook.friendsnearby.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: [B) */
public class FriendsNearbyInviteParams implements Parcelable {
    public static final Creator<FriendsNearbyInviteParams> CREATOR = new C29511();
    public final String f20675a;
    public final ImmutableList<String> f20676b;
    public final ImmutableList<String> f20677c = ImmutableList.of("CURRENT_LOCATION");

    /* compiled from: [B) */
    final class C29511 implements Creator<FriendsNearbyInviteParams> {
        C29511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FriendsNearbyInviteParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FriendsNearbyInviteParams[i];
        }
    }

    public FriendsNearbyInviteParams(String str) {
        this.f20675a = str;
        this.f20676b = RegularImmutableList.a;
    }

    public FriendsNearbyInviteParams(ImmutableList<String> immutableList) {
        this.f20675a = (String) immutableList.get(0);
        this.f20676b = immutableList.subList(1, immutableList.size());
    }

    public FriendsNearbyInviteParams(Parcel parcel) {
        this.f20675a = parcel.readString();
        this.f20676b = ImmutableList.copyOf(parcel.readArrayList(String.class.getClassLoader()));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f20675a);
        parcel.writeList(this.f20676b);
    }

    public int describeContents() {
        return 0;
    }
}
