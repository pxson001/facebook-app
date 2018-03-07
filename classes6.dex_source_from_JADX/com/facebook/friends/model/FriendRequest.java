package com.facebook.friends.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.friending.common.list.model.FriendListUserCommonModel;
import com.facebook.friending.common.list.model.HasSocialContext;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: maxLinesFromThumbnailSize must be false if titleMaxLines and bodyMaxLines are specified */
public class FriendRequest implements Parcelable, FriendListUserCommonModel, HasSocialContext {
    public static final Creator<FriendRequest> CREATOR = new C06591();
    private final long f10649a;
    public final String f10650b;
    @Nullable
    private final String f10651c;
    private final String f10652d;
    private final GraphQLFriendshipStatus f10653e;
    @Nullable
    private final String f10654f;
    public final ImmutableList<String> f10655g;
    public final boolean f10656h;
    @Nullable
    public final String f10657i;
    public FriendRequestState f10658j;
    public boolean f10659k;

    /* compiled from: maxLinesFromThumbnailSize must be false if titleMaxLines and bodyMaxLines are specified */
    final class C06591 implements Creator<FriendRequest> {
        C06591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FriendRequest(parcel);
        }

        public final Object[] newArray(int i) {
            return new FriendRequest[i];
        }
    }

    public FriendRequest(String str, @Nullable String str2, String str3, GraphQLFriendshipStatus graphQLFriendshipStatus, @Nullable String str4, ImmutableList<String> immutableList, FriendRequestState friendRequestState, boolean z, @Nullable String str5) {
        this.f10649a = Long.parseLong(str);
        this.f10650b = str;
        this.f10651c = str2;
        this.f10652d = str3;
        this.f10653e = graphQLFriendshipStatus;
        this.f10654f = str4;
        this.f10655g = immutableList;
        this.f10658j = friendRequestState;
        this.f10656h = z;
        this.f10657i = str5;
        this.f10659k = false;
    }

    public FriendRequest(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f10649a = parcel.readLong();
        this.f10650b = parcel.readString();
        this.f10651c = parcel.readString();
        this.f10652d = parcel.readString();
        this.f10653e = (GraphQLFriendshipStatus) parcel.readSerializable();
        this.f10654f = parcel.readString();
        this.f10655g = ImmutableList.copyOf(parcel.createStringArrayList());
        this.f10658j = (FriendRequestState) parcel.readSerializable();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f10656h = z;
        this.f10657i = parcel.readString();
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f10659k = z2;
    }

    public final long mo1048a() {
        return this.f10649a;
    }

    @Nullable
    public final String mo1049b() {
        return this.f10651c;
    }

    @Nullable
    public final String mo1050d() {
        return this.f10652d;
    }

    public final int mo1051e() {
        throw new UnsupportedOperationException("FriendRequest model does not support this operation.");
    }

    public final GraphQLFriendshipStatus mo1052f() {
        return this.f10653e;
    }

    @Nullable
    public final String mo1053h() {
        return this.f10654f;
    }

    public final boolean m16766l() {
        return !this.f10655g.isEmpty();
    }

    public final void m16767n() {
        this.f10659k = true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeLong(this.f10649a);
        parcel.writeString(this.f10650b);
        parcel.writeString(this.f10651c);
        parcel.writeString(this.f10652d);
        parcel.writeSerializable(this.f10653e);
        parcel.writeString(this.f10654f);
        parcel.writeStringList(this.f10655g);
        parcel.writeSerializable(this.f10658j);
        if (this.f10656h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f10657i);
        if (!this.f10659k) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
