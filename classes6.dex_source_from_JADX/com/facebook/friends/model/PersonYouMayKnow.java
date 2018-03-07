package com.facebook.friends.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.friending.common.list.model.FriendListUserCommonModel;
import com.facebook.friending.common.list.model.HasMutableFriendshipStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: matched_tokens */
public class PersonYouMayKnow implements Parcelable, FriendListUserCommonModel, HasMutableFriendshipStatus {
    public static final Creator<PersonYouMayKnow> CREATOR = new C06601();
    private final long f10660a;
    private final String f10661b;
    @Nullable
    private final String f10662c;
    private final int f10663d;
    private GraphQLFriendshipStatus f10664e;
    public GraphQLFriendshipStatus f10665f;
    public String f10666g;
    public boolean f10667h;

    /* compiled from: matched_tokens */
    final class C06601 implements Creator<PersonYouMayKnow> {
        C06601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PersonYouMayKnow(parcel);
        }

        public final Object[] newArray(int i) {
            return new PersonYouMayKnow[i];
        }
    }

    public PersonYouMayKnow(long j, String str, @Nullable String str2, int i, GraphQLFriendshipStatus graphQLFriendshipStatus, String str3) {
        this.f10660a = j;
        this.f10661b = str;
        this.f10662c = str2;
        this.f10663d = i;
        this.f10664e = graphQLFriendshipStatus;
        this.f10665f = null;
        this.f10666g = str3;
        this.f10667h = false;
    }

    public PersonYouMayKnow(Parcel parcel) {
        this.f10660a = parcel.readLong();
        this.f10661b = parcel.readString();
        this.f10662c = parcel.readString();
        this.f10663d = parcel.readInt();
        this.f10664e = (GraphQLFriendshipStatus) parcel.readSerializable();
        this.f10665f = (GraphQLFriendshipStatus) parcel.readSerializable();
        this.f10666g = parcel.readString();
        this.f10667h = parcel.readInt() == 1;
    }

    public final long mo1048a() {
        return this.f10660a;
    }

    @Nullable
    public final String mo1050d() {
        return this.f10662c;
    }

    public final String mo1049b() {
        return this.f10661b;
    }

    public final int mo1051e() {
        return this.f10663d;
    }

    public final GraphQLFriendshipStatus mo1052f() {
        return this.f10664e;
    }

    public final void mo1054b(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.f10664e = graphQLFriendshipStatus;
    }

    public final void m16774i() {
        this.f10667h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PersonYouMayKnow personYouMayKnow = (PersonYouMayKnow) obj;
        if (Objects.equal(Long.valueOf(this.f10660a), Long.valueOf(personYouMayKnow.mo1048a())) && Objects.equal(this.f10661b, personYouMayKnow.mo1049b()) && Objects.equal(this.f10662c, personYouMayKnow.mo1050d()) && Objects.equal(Integer.valueOf(this.f10663d), Integer.valueOf(personYouMayKnow.mo1051e())) && Objects.equal(this.f10664e, personYouMayKnow.mo1052f()) && Objects.equal(this.f10665f, personYouMayKnow.f10665f) && Objects.equal(this.f10666g, personYouMayKnow.f10666g) && this.f10667h == personYouMayKnow.f10667h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f10660a), this.f10661b, this.f10662c, Integer.valueOf(this.f10663d), this.f10664e, this.f10665f, this.f10666g, Boolean.valueOf(this.f10667h)});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f10660a);
        parcel.writeString(this.f10661b);
        parcel.writeString(mo1050d());
        parcel.writeInt(this.f10663d);
        parcel.writeSerializable(this.f10664e);
        parcel.writeSerializable(this.f10665f);
        parcel.writeString(this.f10666g);
        parcel.writeInt(this.f10667h ? 1 : 0);
    }
}
