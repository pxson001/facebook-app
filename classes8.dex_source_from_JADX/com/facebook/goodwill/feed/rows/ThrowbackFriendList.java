package com.facebook.goodwill.feed.rows;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;

/* compiled from: feed_share_action */
public class ThrowbackFriendList implements Parcelable {
    public static final Creator<ThrowbackFriendList> CREATOR = new C14401();
    public ImmutableList<ThrowbackFriend> f13579a;

    /* compiled from: feed_share_action */
    final class C14401 implements Creator<ThrowbackFriendList> {
        C14401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThrowbackFriendList(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThrowbackFriendList[i];
        }
    }

    public ThrowbackFriendList(ImmutableList<ThrowbackFriend> immutableList) {
        this.f13579a = immutableList;
    }

    public ThrowbackFriendList(Parcel parcel) {
        this.f13579a = ImmutableList.copyOf(parcel.readArrayList(ThrowbackFriend.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f13579a);
    }
}
