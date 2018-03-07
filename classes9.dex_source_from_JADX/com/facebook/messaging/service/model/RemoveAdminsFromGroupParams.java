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

/* compiled from: contacts_never_ask_again_shown */
public class RemoveAdminsFromGroupParams implements Parcelable {
    public static final Creator<RemoveAdminsFromGroupParams> CREATOR = new C20471();
    public static String f17272a = "removeAdminsFromGroupParams";
    public final ImmutableList<UserKey> f17273b;
    public final ThreadKey f17274c;

    /* compiled from: contacts_never_ask_again_shown */
    final class C20471 implements Creator<RemoveAdminsFromGroupParams> {
        C20471() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RemoveAdminsFromGroupParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new RemoveAdminsFromGroupParams[i];
        }
    }

    public RemoveAdminsFromGroupParams(ImmutableList<UserKey> immutableList, ThreadKey threadKey) {
        Preconditions.checkNotNull(threadKey);
        Preconditions.checkArgument(threadKey.b());
        Preconditions.checkArgument(!immutableList.isEmpty());
        Iterator it = immutableList.iterator();
        while (it.hasNext()) {
            Preconditions.checkArgument(((UserKey) it.next()).a().equals(Type.FACEBOOK));
        }
        this.f17273b = immutableList;
        this.f17274c = threadKey;
    }

    public RemoveAdminsFromGroupParams(Parcel parcel) {
        this.f17273b = ImmutableList.copyOf(parcel.readArrayList(UserKey.class.getClassLoader()));
        this.f17274c = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f17273b);
        parcel.writeParcelable(this.f17274c, i);
    }
}
