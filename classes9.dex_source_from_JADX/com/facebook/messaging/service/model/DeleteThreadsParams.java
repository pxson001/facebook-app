package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: create_payment_request */
public class DeleteThreadsParams implements Parcelable {
    public static final Creator<DeleteThreadsParams> CREATOR = new C20001();
    public final ImmutableList<ThreadKey> f17036a;

    /* compiled from: create_payment_request */
    final class C20001 implements Creator<DeleteThreadsParams> {
        C20001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeleteThreadsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeleteThreadsParams[i];
        }
    }

    public DeleteThreadsParams(List<ThreadKey> list) {
        this.f17036a = ImmutableList.copyOf(list);
    }

    DeleteThreadsParams(Parcel parcel) {
        this.f17036a = ImmutableList.copyOf(parcel.readArrayList(ThreadKey.class.getClassLoader()));
    }

    public final ImmutableList<ThreadKey> m17083a() {
        return this.f17036a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f17036a);
    }
}
