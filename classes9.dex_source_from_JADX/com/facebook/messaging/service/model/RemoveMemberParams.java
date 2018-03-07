package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.UserFbidIdentifier;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: contacts_ccu_persist/ */
public class RemoveMemberParams implements Parcelable {
    public static final Creator<RemoveMemberParams> CREATOR = new C20481();
    public final boolean f17276a;
    public final ThreadKey f17277b;
    public final ImmutableList<UserFbidIdentifier> f17278c;

    /* compiled from: contacts_ccu_persist/ */
    final class C20481 implements Creator<RemoveMemberParams> {
        C20481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RemoveMemberParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new RemoveMemberParams[i];
        }
    }

    public static RemoveMemberParams m17165b(ThreadKey threadKey, UserFbidIdentifier userFbidIdentifier) {
        return new RemoveMemberParams(threadKey, false, ImmutableList.of(userFbidIdentifier));
    }

    public RemoveMemberParams(ThreadKey threadKey, boolean z, List<UserFbidIdentifier> list) {
        this.f17277b = threadKey;
        this.f17276a = z;
        this.f17278c = ImmutableList.copyOf(list);
    }

    public RemoveMemberParams(Parcel parcel) {
        this.f17277b = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17276a = ParcelUtil.a(parcel);
        this.f17278c = ImmutableList.copyOf(parcel.readArrayList(UserFbidIdentifier.class.getClassLoader()));
    }

    public final boolean m17166c() {
        return this.f17276a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17277b, i);
        ParcelUtil.a(parcel, this.f17276a);
        parcel.writeList(this.f17278c);
    }
}
