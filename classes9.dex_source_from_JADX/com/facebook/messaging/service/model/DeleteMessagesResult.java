package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: create_thread */
public class DeleteMessagesResult implements Parcelable {
    public static final Creator<DeleteMessagesResult> CREATOR = new C19981();
    public static final DeleteMessagesResult f17028a = new DeleteMessagesResult(null, null, RegularImmutableSet.a, RegularImmutableBiMap.a, RegularImmutableSet.a, false);
    @Nullable
    public final ThreadSummary f17029b;
    @Nullable
    public final ThreadKey f17030c;
    public final ImmutableSet<String> f17031d;
    public final ImmutableMap<String, String> f17032e;
    public final ImmutableSet<String> f17033f;
    public final boolean f17034g;

    /* compiled from: create_thread */
    final class C19981 implements Creator<DeleteMessagesResult> {
        C19981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeleteMessagesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeleteMessagesResult[i];
        }
    }

    public DeleteMessagesResult(@Nullable ThreadSummary threadSummary, ThreadKey threadKey, Set<String> set, Map<String, String> map, Set<String> set2, boolean z) {
        this.f17029b = threadSummary;
        this.f17030c = threadKey;
        this.f17031d = ImmutableSet.copyOf(set);
        this.f17032e = ImmutableMap.copyOf(map);
        this.f17033f = ImmutableSet.copyOf(set2);
        this.f17034g = z;
    }

    DeleteMessagesResult(Parcel parcel) {
        this.f17029b = (ThreadSummary) parcel.readParcelable(ThreadSummary.class.getClassLoader());
        this.f17030c = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17031d = (ImmutableSet) parcel.readSerializable();
        this.f17032e = (ImmutableMap) parcel.readSerializable();
        this.f17033f = (ImmutableSet) parcel.readSerializable();
        this.f17034g = parcel.readInt() != 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17029b, i);
        parcel.writeParcelable(this.f17030c, i);
        parcel.writeSerializable(this.f17031d);
        parcel.writeSerializable(this.f17032e);
        parcel.writeSerializable(this.f17033f);
        parcel.writeInt(this.f17034g ? 1 : 0);
    }
}
