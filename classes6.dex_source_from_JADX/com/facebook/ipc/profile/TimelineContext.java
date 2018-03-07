package com.facebook.ipc.profile;

import android.os.ParcelUuid;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/* compiled from: latlng */
public abstract class TimelineContext {
    public final long f11666a;
    public final long f11667b;
    public final String f11668c;
    public final ParcelUuid f11669d;
    public final TimelineType f11670e;

    /* compiled from: latlng */
    public enum TimelineType {
        USER,
        PAGE,
        PAGE_IDENTITY;

        public final boolean isPageTimeline() {
            return this == PAGE || this == PAGE_IDENTITY;
        }
    }

    public abstract boolean m18350a();

    public abstract boolean m18351b();

    public abstract boolean m18352c();

    public abstract boolean m18353d();

    public abstract Optional<String> m18354e();

    protected TimelineContext(long j, long j2, String str, TimelineType timelineType, ParcelUuid parcelUuid) {
        this.f11666a = j;
        this.f11667b = j2;
        this.f11668c = str;
        this.f11670e = timelineType;
        this.f11669d = (ParcelUuid) Preconditions.checkNotNull(parcelUuid);
    }

    public final long m18355f() {
        return this.f11666a;
    }

    public final long m18356g() {
        return this.f11667b;
    }

    public final boolean m18357i() {
        return this.f11667b == this.f11666a;
    }
}
