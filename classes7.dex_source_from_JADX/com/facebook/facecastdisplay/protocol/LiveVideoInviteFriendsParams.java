package com.facebook.facecastdisplay.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.google.common.collect.ImmutableList;

/* compiled from: sticker_added */
public class LiveVideoInviteFriendsParams implements Parcelable {
    public static final Creator<LiveVideoInviteFriendsParams> CREATOR = new C02821();
    public String f3275a;
    public ImmutableList<String> f3276b;

    /* compiled from: sticker_added */
    final class C02821 implements Creator<LiveVideoInviteFriendsParams> {
        C02821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LiveVideoInviteFriendsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new LiveVideoInviteFriendsParams[i];
        }
    }

    public LiveVideoInviteFriendsParams(String str, ImmutableList<String> immutableList) {
        this.f3275a = str;
        this.f3276b = immutableList;
    }

    public LiveVideoInviteFriendsParams(Parcel parcel) {
        this.f3275a = parcel.readString();
        this.f3276b = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3275a);
        parcel.writeList(this.f3276b);
    }
}
