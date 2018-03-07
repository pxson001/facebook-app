package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: count(*) =  */
public class FetchThreadKeyByParticipantsParams implements Parcelable {
    public static final Creator<FetchThreadKeyByParticipantsParams> CREATOR = new C20251();
    public final UserKey f17113a;
    public final ImmutableSet<UserKey> f17114b;
    private final boolean f17115c;

    /* compiled from: count(*) =  */
    final class C20251 implements Creator<FetchThreadKeyByParticipantsParams> {
        C20251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchThreadKeyByParticipantsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchThreadKeyByParticipantsParams[i];
        }
    }

    public FetchThreadKeyByParticipantsParams(UserKey userKey, Set<UserKey> set, boolean z) {
        this.f17113a = userKey;
        this.f17114b = ImmutableSet.copyOf(set);
        this.f17115c = z;
    }

    public FetchThreadKeyByParticipantsParams(Parcel parcel) {
        this.f17113a = (UserKey) ParcelUtil.b(parcel, UserKey.class);
        this.f17114b = ImmutableSet.copyOf(ParcelUtil.b(parcel));
        this.f17115c = ParcelUtil.a(parcel);
    }

    public final UserKey m17103a() {
        return this.f17113a;
    }

    public final ImmutableSet<UserKey> m17105b() {
        return this.f17114b;
    }

    @Nullable
    public final ThreadSummary m17102a(List<ThreadSummary> list) {
        ThreadSummary threadSummary = null;
        for (ThreadSummary threadSummary2 : list) {
            ThreadSummary threadSummary22;
            if (!m17100a(threadSummary22) || (threadSummary != null && threadSummary.k >= threadSummary22.k)) {
                threadSummary22 = threadSummary;
            }
            threadSummary = threadSummary22;
        }
        return threadSummary;
    }

    @Nullable
    public final ThreadSummary m17104b(List<ThreadSummary> list) {
        for (ThreadSummary threadSummary : list) {
            if (m17101b(threadSummary)) {
                return threadSummary;
            }
        }
        return null;
    }

    private boolean m17100a(ThreadSummary threadSummary) {
        if (!m17101b(threadSummary)) {
            return false;
        }
        Set hashSet = new HashSet();
        Iterator it = threadSummary.h.iterator();
        while (it.hasNext()) {
            hashSet.add(((ThreadParticipant) it.next()).b());
        }
        return hashSet.equals(this.f17114b);
    }

    private boolean m17101b(ThreadSummary threadSummary) {
        return threadSummary.w && (!threadSummary.a() || this.f17115c);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17113a, i);
        ParcelUtil.a(parcel, this.f17114b);
        ParcelUtil.a(parcel, this.f17115c);
    }
}
