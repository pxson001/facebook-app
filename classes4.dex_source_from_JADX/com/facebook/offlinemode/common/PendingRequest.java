package com.facebook.offlinemode.common;

import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.google.common.base.Strings;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: feed_toggle_page_like */
public abstract class PendingRequest {
    public static final long f11828a = TimeUnit.DAYS.toMillis(7);
    public final String f11829b;
    @Nullable
    public final String f11830c;
    public final long f11831d;
    public final long f11832e;
    public final int f11833f;
    public final int f11834g;

    /* compiled from: feed_toggle_page_like */
    public abstract class Builder {
        @Nullable
        public String f11822a;
        @Nullable
        public String f11823b;
        public long f11824c;
        public long f11825d = PendingRequest.f11828a;
        public int f11826e;
        public int f11827f = 1000;

        public abstract PendingRequest mo880a();

        public final Builder m12424a(@Nullable String str) {
            this.f11822a = str;
            return this;
        }

        public final Builder m12423a(long j) {
            this.f11825d = j;
            return this;
        }

        public final Builder m12427b(long j) {
            this.f11824c = j;
            return this;
        }

        public final Builder m12422a(int i) {
            this.f11826e = i;
            return this;
        }

        public final Builder m12426b(int i) {
            this.f11827f = i;
            return this;
        }
    }

    public abstract String mo881c();

    protected PendingRequest(int i, long j, @Nullable String str, @Nullable String str2, int i2, long j2) {
        if (Strings.isNullOrEmpty(str)) {
            str = SafeUUIDGenerator.a().toString();
        }
        this.f11833f = i;
        this.f11832e = j;
        this.f11829b = str;
        this.f11830c = str2;
        this.f11834g = i2;
        this.f11831d = j2;
    }

    public final boolean m12428a(long j) {
        if (this.f11832e > 0 && j >= this.f11831d + this.f11832e) {
            return true;
        }
        return false;
    }

    public final boolean m12429b() {
        return this.f11831d <= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PendingRequest)) {
            return false;
        }
        return this.f11829b.equals(((PendingRequest) obj).f11829b);
    }

    public int hashCode() {
        return this.f11829b.hashCode();
    }
}
