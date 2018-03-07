package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: messenger_get_media_fbid_started */
public class FetchNotificationSeenStatesParams implements Parcelable {
    public static final Creator<FetchNotificationSeenStatesParams> CREATOR = new C03881();
    public final ImmutableList<String> f7984a;

    /* compiled from: messenger_get_media_fbid_started */
    final class C03881 implements Creator<FetchNotificationSeenStatesParams> {
        C03881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchNotificationSeenStatesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchNotificationSeenStatesParams[i];
        }
    }

    public FetchNotificationSeenStatesParams(Collection<String> collection) {
        Preconditions.checkNotNull(collection);
        this.f7984a = ImmutableList.copyOf(collection);
    }

    public FetchNotificationSeenStatesParams(Parcel parcel) {
        this.f7984a = ImmutableList.copyOf(parcel.createStringArrayList());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f7984a);
    }
}
