package com.facebook.imagepipeline.image;

/* compiled from: last_send_failure_captive_portal_notified_ms */
public class ImmutableQualityInfo {
    public static final ImmutableQualityInfo f17879a = m25101a(Integer.MAX_VALUE, true, true);
    int f17880b;
    public boolean f17881c;
    public boolean f17882d;

    private ImmutableQualityInfo(int i, boolean z, boolean z2) {
        this.f17880b = i;
        this.f17881c = z;
        this.f17882d = z2;
    }

    public final int m25102a() {
        return this.f17880b;
    }

    public final boolean m25103b() {
        return this.f17881c;
    }

    public final boolean m25104c() {
        return this.f17882d;
    }

    public int hashCode() {
        int i = 0;
        int i2 = (this.f17881c ? 4194304 : 0) ^ this.f17880b;
        if (this.f17882d) {
            i = 8388608;
        }
        return i2 ^ i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableQualityInfo)) {
            return false;
        }
        ImmutableQualityInfo immutableQualityInfo = (ImmutableQualityInfo) obj;
        if (this.f17880b == immutableQualityInfo.f17880b && this.f17881c == immutableQualityInfo.f17881c && this.f17882d == immutableQualityInfo.f17882d) {
            return true;
        }
        return false;
    }

    public static ImmutableQualityInfo m25101a(int i, boolean z, boolean z2) {
        return new ImmutableQualityInfo(i, z, z2);
    }
}
