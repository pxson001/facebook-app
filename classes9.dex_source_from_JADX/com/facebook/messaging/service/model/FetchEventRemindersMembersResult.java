package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.google.common.collect.ImmutableList;

/* compiled from: create_account */
public class FetchEventRemindersMembersResult implements Parcelable {
    public static final Creator<FetchEventRemindersMembersResult> CREATOR = new C20071();
    public final ImmutableList<ThreadEventReminder> f17050a;

    /* compiled from: create_account */
    final class C20071 implements Creator<FetchEventRemindersMembersResult> {
        C20071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchEventRemindersMembersResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchEventRemindersMembersResult[i];
        }
    }

    public FetchEventRemindersMembersResult(ImmutableList<ThreadEventReminder> immutableList) {
        this.f17050a = immutableList;
    }

    public FetchEventRemindersMembersResult(Parcel parcel) {
        this.f17050a = ImmutableList.copyOf(parcel.createTypedArrayList(ThreadEventReminder.CREATOR));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f17050a);
    }
}
