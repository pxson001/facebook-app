package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.MessagingNotification.Type;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: inviter_friendship_status */
public class ReadThreadNotification extends MessagingNotification {
    public static final Creator<ReadThreadNotification> CREATOR = new C14341();
    public final ImmutableMap<ThreadKey, Long> f12767a;

    /* compiled from: inviter_friendship_status */
    final class C14341 implements Creator<ReadThreadNotification> {
        C14341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReadThreadNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReadThreadNotification[i];
        }
    }

    public ReadThreadNotification(ImmutableMap<ThreadKey, Long> immutableMap) {
        super(Type.READ_THREAD);
        this.f12767a = immutableMap;
    }

    public ReadThreadNotification(Parcel parcel) {
        ImmutableMap b;
        super(parcel);
        try {
            Map readHashMap = parcel.readHashMap(null);
            Builder builder = ImmutableMap.builder();
            for (Entry entry : readHashMap.entrySet()) {
                ThreadKey a = ThreadKey.a((String) entry.getKey());
                if (a != null) {
                    builder.b(a, entry.getValue());
                }
            }
            b = builder.b();
        } catch (Exception e) {
            b = null;
        }
        if (b == null) {
            b = ImmutableBiMap.a();
        }
        this.f12767a = b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        Map hashMap = new HashMap();
        Iterator it = this.f12767a.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            hashMap.put(((ThreadKey) entry.getKey()).toString(), entry.getValue());
        }
        parcel.writeMap(hashMap);
    }
}
