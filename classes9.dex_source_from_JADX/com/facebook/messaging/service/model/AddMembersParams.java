package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.UserFbidIdentifier;
import com.facebook.user.model.UserIdentifier;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: create_thread_step */
public class AddMembersParams implements Parcelable {
    public static final Creator<AddMembersParams> CREATOR = new C19901();
    public final ThreadKey f17009a;
    public final ImmutableList<UserIdentifier> f17010b;

    /* compiled from: create_thread_step */
    final class C19901 implements Creator<AddMembersParams> {
        C19901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddMembersParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddMembersParams[i];
        }
    }

    public AddMembersParams(ThreadKey threadKey, List<UserIdentifier> list) {
        this.f17009a = threadKey;
        this.f17010b = ImmutableList.copyOf(list);
    }

    public AddMembersParams(Parcel parcel) {
        this.f17009a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17010b = ImmutableList.copyOf(parcel.readArrayList(UserFbidIdentifier.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17009a, i);
        parcel.writeList(this.f17010b);
    }
}
