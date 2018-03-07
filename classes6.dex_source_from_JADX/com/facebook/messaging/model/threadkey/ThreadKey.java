package com.facebook.messaging.model.threadkey;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: upgrade_accept */
public class ThreadKey implements Parcelable {
    public static final Creator<ThreadKey> CREATOR = new C01121();
    public final Type f2224a;
    public final long f2225b;
    public final long f2226c;
    public final long f2227d;
    public final long f2228e;
    @Nullable
    public final String f2229f;

    /* compiled from: upgrade_accept */
    final class C01121 implements Creator<ThreadKey> {
        C01121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadKey((Type) parcel.readSerializable(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new ThreadKey[i];
        }
    }

    /* compiled from: upgrade_accept */
    public enum Type {
        ONE_TO_ONE("ONE_TO_ONE"),
        GROUP("GROUP"),
        TINCAN("TINCAN"),
        PENDING_THREAD("PENDING_THREAD"),
        SMS("SMS"),
        MY_MONTAGE("MY_MONTAGE"),
        MONTAGE("MONTAGE");
        
        public final String dbValue;

        private Type(String str) {
            this.dbValue = str;
        }

        @Nullable
        public static Type fromDbValue(String str) {
            for (Type type : values()) {
                if (Objects.equal(type.dbValue, str)) {
                    return type;
                }
            }
            return null;
        }
    }

    private ThreadKey(Type type, long j, long j2, long j3, long j4, String str) {
        this.f2224a = type;
        this.f2225b = j;
        this.f2227d = j2;
        this.f2228e = j3;
        this.f2226c = j4;
        this.f2229f = str;
        switch (type) {
            case ONE_TO_ONE:
                boolean z;
                Preconditions.checkArgument(j == -1);
                Preconditions.checkArgument(j2 > -1);
                Preconditions.checkArgument(j3 > -1);
                Preconditions.checkArgument(j4 == -1);
                if (str == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                return;
            case GROUP:
                Preconditions.checkArgument(j > -1);
                Preconditions.checkArgument(j2 == -1);
                Preconditions.checkArgument(j3 == -1);
                Preconditions.checkArgument(j4 == -1);
                Preconditions.checkArgument(str == null);
                return;
            case TINCAN:
                Preconditions.checkArgument(j == -1);
                Preconditions.checkArgument(j2 > -1);
                Preconditions.checkArgument(j3 > -1);
                Preconditions.checkArgument(j4 == -1);
                Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
                return;
            case PENDING_THREAD:
                Preconditions.checkArgument(j == -1);
                Preconditions.checkArgument(j2 == -1);
                Preconditions.checkArgument(j3 == -1);
                Preconditions.checkArgument(j4 > -1);
                Preconditions.checkArgument(str == null);
                return;
            case SMS:
                Preconditions.checkArgument(j2 == -1);
                Preconditions.checkArgument(j3 == -1);
                Preconditions.checkArgument(j4 == -1);
                Preconditions.checkArgument(str == null);
                return;
            case MY_MONTAGE:
                Preconditions.checkArgument(j == -1);
                Preconditions.checkArgument(j2 == -1);
                Preconditions.checkArgument(j3 == -1);
                Preconditions.checkArgument(j4 == -1);
                Preconditions.checkArgument(str == null);
                return;
            case MONTAGE:
                Preconditions.checkArgument(j > -1);
                Preconditions.checkArgument(j2 > -1);
                Preconditions.checkArgument(j3 == -1);
                Preconditions.checkArgument(j4 == -1);
                Preconditions.checkArgument(str == null);
                return;
            default:
                throw new IllegalArgumentException("Unsupported ThreadKey type: " + type);
        }
    }

    public static ThreadKey m3490a(long j, long j2) {
        return new ThreadKey(Type.ONE_TO_ONE, -1, j, j2, -1, null);
    }

    public static ThreadKey m3489a(long j) {
        return new ThreadKey(Type.GROUP, j, -1, -1, -1, null);
    }

    public static ThreadKey m3492a(String str, long j, long j2) {
        return new ThreadKey(Type.TINCAN, -1, j, j2, -1, str);
    }

    private static ThreadKey m3497c(long j) {
        return new ThreadKey(Type.PENDING_THREAD, -1, -1, -1, j, null);
    }

    public static ThreadKey m3494b(long j) {
        return new ThreadKey(Type.SMS, j, -1, -1, -1, null);
    }

    public static ThreadKey m3488a() {
        return new ThreadKey(Type.MY_MONTAGE, -1, -1, -1, -1, null);
    }

    public static ThreadKey m3495b(long j, long j2) {
        return new ThreadKey(Type.MONTAGE, j, j2, -1, -1, null);
    }

    @Nullable
    public static UserKey m3493a(ThreadKey threadKey) {
        if (threadKey == null || threadKey.f2224a != Type.ONE_TO_ONE) {
            return null;
        }
        return UserKey.b(Long.toString(threadKey.f2227d));
    }

    @Nullable
    public static ThreadKey m3491a(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        if (split.length <= 0) {
            return null;
        }
        Type fromDbValue = Type.fromDbValue(split[0]);
        try {
            if (fromDbValue == Type.ONE_TO_ONE && split.length == 3) {
                return m3490a(Long.parseLong(split[1]), Long.parseLong(split[2]));
            }
            if (fromDbValue == Type.GROUP && split.length == 2) {
                return m3489a(Long.parseLong(split[1]));
            }
            if (fromDbValue == Type.TINCAN && split.length == 4) {
                return m3492a(split[1], Long.parseLong(split[2]), Long.parseLong(split[3]));
            }
            if (fromDbValue == Type.PENDING_THREAD && split.length == 2) {
                return m3497c(Long.parseLong(split[1]));
            }
            if (fromDbValue == Type.SMS && split.length == 2) {
                return m3494b(Long.parseLong(split[1]));
            }
            if (fromDbValue == Type.MONTAGE && split.length == 3) {
                return m3495b(Long.parseLong(split[1]), Long.parseLong(split[2]));
            }
            if (fromDbValue == Type.MY_MONTAGE && split.length == 1) {
                return m3488a();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public final boolean m3505b() {
        return this.f2224a == Type.GROUP;
    }

    public final boolean m3506c() {
        return this.f2224a == Type.MY_MONTAGE;
    }

    public final boolean m3507d() {
        return m3506c() || this.f2224a == Type.MONTAGE;
    }

    public final boolean m3508e() {
        return (m3505b() || m3507d() || this.f2227d != this.f2228e) ? false : true;
    }

    public final boolean m3509f() {
        return this.f2224a == Type.PENDING_THREAD;
    }

    public static boolean m3496b(@Nullable ThreadKey threadKey) {
        return threadKey != null && threadKey.f2224a == Type.ONE_TO_ONE;
    }

    public static boolean m3498c(@Nullable ThreadKey threadKey) {
        return threadKey != null && threadKey.f2224a == Type.GROUP;
    }

    public static boolean m3499d(@Nullable ThreadKey threadKey) {
        return threadKey != null && threadKey.f2224a == Type.SMS;
    }

    public static boolean m3500e(@Nullable ThreadKey threadKey) {
        return m3499d(threadKey) && threadKey.m3512i() == -100;
    }

    public static boolean m3501f(@Nullable ThreadKey threadKey) {
        return threadKey != null && threadKey.f2224a == Type.PENDING_THREAD;
    }

    public static boolean m3502g(@Nullable ThreadKey threadKey) {
        return threadKey != null && threadKey.f2224a == Type.TINCAN;
    }

    public static boolean m3503h(@Nullable ThreadKey threadKey) {
        return m3502g(threadKey) && "PENDING".equals(threadKey.f2229f);
    }

    public static boolean m3504j(@Nullable ThreadKey threadKey) {
        return threadKey != null && threadKey.m3507d();
    }

    public final String m3510g() {
        switch (this.f2224a) {
            case ONE_TO_ONE:
                return this.f2224a.dbValue + ":" + this.f2227d + ":" + this.f2228e;
            case GROUP:
            case SMS:
                return this.f2224a.dbValue + ":" + this.f2225b;
            case TINCAN:
                return this.f2224a.dbValue + ":" + this.f2229f + ":" + this.f2227d + ":" + this.f2228e;
            case PENDING_THREAD:
                return this.f2224a.dbValue + ":" + this.f2226c;
            case MY_MONTAGE:
                return this.f2224a.dbValue;
            case MONTAGE:
                return this.f2224a.dbValue + ":" + this.f2225b + ":" + this.f2227d;
            default:
                return "UNKNOWN_TYPE";
        }
    }

    public final String m3511h() {
        switch (this.f2224a) {
            case ONE_TO_ONE:
                long min = Math.min(this.f2228e, this.f2227d);
                return min + "u" + Math.max(this.f2228e, this.f2227d);
            case GROUP:
                return "g" + this.f2225b;
            case MY_MONTAGE:
                return "montage";
            case MONTAGE:
                return "m" + this.f2225b;
            default:
                return "unknown";
        }
    }

    public final long m3512i() {
        if (this.f2224a == Type.ONE_TO_ONE) {
            return this.f2227d;
        }
        return this.f2225b;
    }

    public String toString() {
        return m3510g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ThreadKey threadKey = (ThreadKey) obj;
        if (this.f2227d != threadKey.f2227d) {
            return false;
        }
        if (this.f2225b != threadKey.f2225b) {
            return false;
        }
        if (this.f2228e != threadKey.f2228e) {
            return false;
        }
        if (this.f2226c != threadKey.f2226c) {
            return false;
        }
        if (Objects.equal(this.f2229f, threadKey.f2229f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = (((((((int) (this.f2225b ^ (this.f2225b >>> 32))) * 31) + ((int) (this.f2227d ^ (this.f2227d >>> 32)))) * 31) + ((int) (this.f2228e ^ (this.f2228e >>> 32)))) * 31) + ((int) (this.f2226c ^ (this.f2226c >>> 32)));
        if (this.f2229f != null) {
            return (i * 31) + this.f2229f.hashCode();
        }
        return i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f2224a);
        parcel.writeLong(this.f2225b);
        parcel.writeLong(this.f2227d);
        parcel.writeLong(this.f2228e);
        parcel.writeLong(this.f2226c);
        parcel.writeString(this.f2229f);
    }
}
