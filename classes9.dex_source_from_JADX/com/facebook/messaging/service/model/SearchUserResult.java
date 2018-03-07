package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: contact_info_form_input_controller_fragment_tag */
public class SearchUserResult implements Parcelable {
    public static final Creator<SearchUserResult> CREATOR = new C20561();
    private ImmutableList<User> f17299a;
    private ImmutableList<User> f17300b;
    private ImmutableList<User> f17301c;
    private ImmutableList<User> f17302d;
    private String f17303e;

    /* compiled from: contact_info_form_input_controller_fragment_tag */
    final class C20561 implements Creator<SearchUserResult> {
        C20561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchUserResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SearchUserResult[i];
        }
    }

    public SearchUserResult(String str, ImmutableList<User> immutableList, ImmutableList<User> immutableList2, ImmutableList<User> immutableList3, ImmutableList<User> immutableList4) {
        this.f17299a = immutableList;
        this.f17300b = immutableList2;
        this.f17301c = immutableList3;
        this.f17302d = immutableList4;
        this.f17303e = str;
    }

    public SearchUserResult(Parcel parcel) {
        this.f17299a = ImmutableList.copyOf(parcel.readArrayList(SearchUserParams.class.getClassLoader()));
        this.f17301c = ImmutableList.copyOf(parcel.readArrayList(SearchUserParams.class.getClassLoader()));
        this.f17300b = ImmutableList.copyOf(parcel.readArrayList(SearchUserParams.class.getClassLoader()));
        this.f17302d = ImmutableList.copyOf(parcel.readArrayList(SearchUserParams.class.getClassLoader()));
        this.f17303e = parcel.readString();
    }

    public final ImmutableList<User> m17175a() {
        return this.f17301c;
    }

    public final ImmutableList<User> m17176b() {
        return this.f17300b;
    }

    public final ImmutableList<User> m17177c() {
        return this.f17302d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17299a);
        parcel.writeList(this.f17301c);
        parcel.writeList(this.f17300b);
        parcel.writeList(this.f17302d);
        parcel.writeString(this.f17303e);
    }
}
