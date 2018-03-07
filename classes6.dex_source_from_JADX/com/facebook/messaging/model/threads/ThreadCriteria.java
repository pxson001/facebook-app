package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.RegularImmutableSet;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: updateSavedState */
public class ThreadCriteria implements Parcelable {
    public static final Creator<ThreadCriteria> CREATOR = new C01181();
    @Deprecated
    @Nullable
    public final String f2243a;
    public final ImmutableSet<ThreadKey> f2244b;
    @Nullable
    public final String f2245c;

    /* compiled from: updateSavedState */
    final class C01181 implements Creator<ThreadCriteria> {
        C01181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadCriteria(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThreadCriteria[i];
        }
    }

    private ThreadCriteria(@Nullable String str, @Nullable String str2) {
        this.f2243a = str;
        this.f2244b = RegularImmutableSet.a;
        this.f2245c = str2;
    }

    public ThreadCriteria(Collection<ThreadKey> collection) {
        this.f2243a = null;
        this.f2244b = ImmutableSet.copyOf((Collection) Preconditions.checkNotNull(collection));
        this.f2245c = null;
    }

    @Deprecated
    public static ThreadCriteria m3527a(String str) {
        return new ThreadCriteria((String) Preconditions.checkNotNull(str), null);
    }

    public static ThreadCriteria m3526a(ThreadKey threadKey) {
        return new ThreadCriteria(ImmutableSet.of(threadKey));
    }

    public static ThreadCriteria m3528b(String str) {
        return new ThreadCriteria(null, (String) Preconditions.checkNotNull(str));
    }

    public ThreadCriteria(Parcel parcel) {
        ImmutableSet immutableSet;
        this.f2243a = parcel.readString();
        ThreadKey[] threadKeyArr = (ThreadKey[]) parcel.createTypedArray(ThreadKey.CREATOR);
        if (threadKeyArr == null) {
            immutableSet = RegularImmutableSet.a;
        } else {
            immutableSet = ImmutableSet.copyOf(threadKeyArr);
        }
        this.f2244b = immutableSet;
        this.f2245c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final ThreadKey m3529a() {
        return this.f2244b.isEmpty() ? null : (ThreadKey) this.f2244b.iterator().next();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2243a);
        parcel.writeTypedArray((Parcelable[]) this.f2244b.toArray(new ThreadKey[this.f2244b.size()]), i);
        parcel.writeString(this.f2245c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ThreadCriteria threadCriteria = (ThreadCriteria) obj;
        if (Objects.equal(this.f2243a, threadCriteria.f2243a) && Iterables.a(this.f2244b, threadCriteria.f2244b) && Objects.equal(this.f2245c, threadCriteria.f2245c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f2243a, this.f2244b, this.f2245c});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f2243a != null) {
            stringBuilder.append("tid: ").append(this.f2243a);
        } else if (this.f2245c != null) {
            stringBuilder.append("threadIdReferenceQuery: ").append(this.f2245c);
        } else {
            stringBuilder.append("threadkeys: [");
            Iterator it = this.f2244b.iterator();
            while (it.hasNext()) {
                stringBuilder.append((ThreadKey) it.next()).append(", ");
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }
}
