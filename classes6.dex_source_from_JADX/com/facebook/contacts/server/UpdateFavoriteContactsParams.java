package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: p2p_unlock */
public class UpdateFavoriteContactsParams implements Parcelable {
    public static final Creator<UpdateFavoriteContactsParams> CREATOR = new C05471();
    public final ImmutableList<User> f8463a;

    /* compiled from: p2p_unlock */
    final class C05471 implements Creator<UpdateFavoriteContactsParams> {
        C05471() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpdateFavoriteContactsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpdateFavoriteContactsParams[i];
        }
    }

    public UpdateFavoriteContactsParams(List<User> list) {
        this.f8463a = ImmutableList.copyOf(list);
    }

    UpdateFavoriteContactsParams(Parcel parcel) {
        this.f8463a = ImmutableList.copyOf(parcel.readArrayList(User.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f8463a);
    }
}
