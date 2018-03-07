package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

/* compiled from: created_for_group_id */
public class AddAdminsToGroupParams implements Parcelable {
    public static final Creator<AddAdminsToGroupParams> CREATOR = new C19891();
    public static String f17005a = "addAdminsToGroupParams";
    public final ImmutableList<UserKey> f17006b;
    public final ThreadKey f17007c;

    /* compiled from: created_for_group_id */
    final class C19891 implements Creator<AddAdminsToGroupParams> {
        C19891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddAdminsToGroupParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddAdminsToGroupParams[i];
        }
    }

    public AddAdminsToGroupParams(ImmutableList<UserKey> immutableList, ThreadKey threadKey) {
        Preconditions.checkNotNull(threadKey);
        Preconditions.checkArgument(threadKey.b());
        Preconditions.checkArgument(!immutableList.isEmpty());
        Iterator it = immutableList.iterator();
        while (it.hasNext()) {
            Preconditions.checkArgument(((UserKey) it.next()).a().equals(Type.FACEBOOK));
        }
        this.f17006b = immutableList;
        this.f17007c = threadKey;
    }

    public AddAdminsToGroupParams(Parcel parcel) {
        this.f17006b = ImmutableList.copyOf(parcel.readArrayList(UserKey.class.getClassLoader()));
        this.f17007c = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f17006b);
        parcel.writeParcelable(this.f17007c, i);
    }
}
