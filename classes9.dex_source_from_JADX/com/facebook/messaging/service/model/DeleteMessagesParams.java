package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;

/* compiled from: create_thread_action */
public class DeleteMessagesParams implements Parcelable {
    public static final Creator<DeleteMessagesParams> CREATOR = new C19971();
    @Nullable
    public final ThreadKey f17025a;
    public final ImmutableSet<String> f17026b;
    public final ServerParam f17027c;

    /* compiled from: create_thread_action */
    final class C19971 implements Creator<DeleteMessagesParams> {
        C19971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeleteMessagesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeleteMessagesParams[i];
        }
    }

    /* compiled from: create_thread_action */
    public enum ServerParam {
        MUST_UPDATE_SERVER,
        CLIENT_ONLY
    }

    public DeleteMessagesParams(ImmutableSet<String> immutableSet, ServerParam serverParam, @Nullable ThreadKey threadKey) {
        this.f17026b = immutableSet;
        this.f17027c = serverParam;
        this.f17025a = threadKey;
    }

    DeleteMessagesParams(Parcel parcel) {
        this.f17026b = ImmutableSet.copyOf(parcel.createStringArrayList());
        this.f17027c = ServerParam.valueOf(parcel.readString());
        this.f17025a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17026b.asList());
        parcel.writeString(this.f17027c.name());
        parcel.writeParcelable(this.f17025a, i);
    }
}
