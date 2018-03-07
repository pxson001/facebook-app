package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: createThreadParams */
public class FetchGroupInviteLinkParams implements Parcelable {
    public static final Creator<FetchGroupInviteLinkParams> CREATOR = new C20081();
    public static String f17051a = "fetchGroupInviteLinkParams";
    public final ThreadKey f17052b;

    /* compiled from: createThreadParams */
    final class C20081 implements Creator<FetchGroupInviteLinkParams> {
        C20081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchGroupInviteLinkParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchGroupInviteLinkParams[i];
        }
    }

    public FetchGroupInviteLinkParams(Parcel parcel) {
        this.f17052b = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17052b, i);
    }
}
