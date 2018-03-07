package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.google.common.collect.ImmutableList;

/* compiled from: create_commerce_cart_p2p_platform_context */
public class FetchEventRemindersMembersParams implements Parcelable {
    public static final Creator<FetchEventRemindersMembersParams> CREATOR = new C20061();
    public static String f17047a = "fetchEventRemindersMembersParams";
    public final ThreadKey f17048b;
    private final ImmutableList<ThreadEventReminder> f17049c;

    /* compiled from: create_commerce_cart_p2p_platform_context */
    final class C20061 implements Creator<FetchEventRemindersMembersParams> {
        C20061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchEventRemindersMembersParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchEventRemindersMembersParams[i];
        }
    }

    public FetchEventRemindersMembersParams(ThreadKey threadKey, ImmutableList<ThreadEventReminder> immutableList) {
        this.f17048b = threadKey;
        this.f17049c = immutableList;
    }

    public FetchEventRemindersMembersParams(Parcel parcel) {
        this.f17048b = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17049c = ImmutableList.copyOf(parcel.createTypedArrayList(ThreadEventReminder.CREATOR));
    }

    public final ImmutableList<ThreadEventReminder> m17084a() {
        return this.f17049c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17048b, i);
        parcel.writeTypedList(this.f17049c);
    }
}
