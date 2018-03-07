package com.facebook.messaging.model.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upload_retry_fast */
public class MessagesCollection implements Parcelable {
    public static final Creator<MessagesCollection> CREATOR = new C00971();
    public final ThreadKey f2108a;
    public final ImmutableList<Message> f2109b;
    public final boolean f2110c;

    /* compiled from: upload_retry_fast */
    final class C00971 implements Creator<MessagesCollection> {
        C00971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessagesCollection(parcel);
        }

        public final Object[] newArray(int i) {
            return new MessagesCollection[i];
        }
    }

    public MessagesCollection(ThreadKey threadKey, ImmutableList<Message> immutableList, boolean z) {
        this.f2108a = threadKey;
        this.f2109b = immutableList;
        this.f2110c = z;
        m3428a(immutableList, null, null, false, null);
    }

    public MessagesCollection(Parcel parcel) {
        this.f2108a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f2109b = ImmutableList.copyOf(parcel.createTypedArrayList(Message.CREATOR));
        this.f2110c = ParcelUtil.a(parcel);
        m3428a(this.f2109b, null, null, false, null);
    }

    public MessagesCollection(ThreadKey threadKey, ImmutableList<Message> immutableList, boolean z, @Nullable MessagesCollection messagesCollection, @Nullable MessagesCollection messagesCollection2, boolean z2, @Nullable User user) {
        this.f2108a = threadKey;
        this.f2109b = immutableList;
        this.f2110c = z;
        m3428a(immutableList, messagesCollection, messagesCollection2, z2, user);
    }

    public static MessagesCollection m3426a(Message message) {
        return new MessagesCollection(message.f2011b, ImmutableList.of(message), false);
    }

    private static void m3428a(ImmutableList<Message> immutableList, @Nullable MessagesCollection messagesCollection, @Nullable MessagesCollection messagesCollection2, boolean z, @Nullable User user) {
        if (!m3429a((ImmutableList) immutableList)) {
            String str;
            if (messagesCollection == null || messagesCollection2 == null || (((user == null || !user.o) && !BLog.b(3)) || messagesCollection.m3438g() + messagesCollection2.m3438g() > 100)) {
                str = "Thread messages were not in order";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread messages were not in order, requireOverlap=").append(z).append(", newMessages=").append(m3427a(messagesCollection)).append(", oldMessages=").append(m3427a(messagesCollection2));
                str = stringBuilder.toString();
            }
            BLog.c("MessagesCollection", str);
        }
    }

    public static boolean m3429a(ImmutableList<Message> immutableList) {
        long j = Long.MAX_VALUE;
        int size = immutableList.size();
        int i = 0;
        long j2 = Long.MAX_VALUE;
        while (i < size) {
            long j3;
            Message message = (Message) immutableList.get(i);
            if (message.f2024o) {
                j3 = j;
                j = j2;
            } else if (message.f2012c > j2 && MessageUtil.d(message) > j) {
                return false;
            } else {
                j = message.f2012c;
                j3 = MessageUtil.d(message);
            }
            i++;
            j2 = j;
            j = j3;
        }
        return true;
    }

    public static String m3427a(MessagesCollection messagesCollection) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        ImmutableList immutableList = messagesCollection.f2109b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) immutableList.get(i);
            stringBuilder.append("{");
            stringBuilder.append(message.f2010a).append(",").append(message.f2023n).append(",").append(message.f2012c).append(",").append(message.f2013d).append(",").append(message.f2024o);
            stringBuilder.append("}");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final ThreadKey m3430a() {
        return this.f2108a;
    }

    public final ImmutableList<Message> m3433b() {
        return this.f2109b;
    }

    @Nullable
    public final Message m3434c() {
        return this.f2109b.isEmpty() ? null : (Message) this.f2109b.get(0);
    }

    @Nullable
    public final Message m3435d() {
        return this.f2109b.isEmpty() ? null : (Message) this.f2109b.get(this.f2109b.size() - 1);
    }

    public final boolean m3431a(int i) {
        return this.f2110c || i <= this.f2109b.size();
    }

    public final boolean m3436e() {
        return this.f2110c;
    }

    public final boolean m3437f() {
        return this.f2109b.isEmpty();
    }

    public final int m3438g() {
        return this.f2109b.size();
    }

    public final Message m3432b(int i) {
        return (Message) this.f2109b.get(i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2108a, i);
        parcel.writeTypedList(this.f2109b);
        ParcelUtil.a(parcel, this.f2110c);
    }
}
