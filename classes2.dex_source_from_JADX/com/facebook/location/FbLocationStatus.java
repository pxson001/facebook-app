package com.facebook.location;

import android.os.Build.VERSION;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: request_body */
public class FbLocationStatus {
    public final State f15655a;
    public final ImmutableSet<String> f15656b;
    public final ImmutableSet<String> f15657c;

    /* compiled from: request_body */
    public enum State {
        PERMISSION_DENIED,
        LOCATION_UNSUPPORTED,
        LOCATION_DISABLED,
        OKAY
    }

    public FbLocationStatus(State state, ImmutableSet<String> immutableSet, ImmutableSet<String> immutableSet2) {
        this.f15655a = state;
        this.f15656b = immutableSet;
        this.f15657c = immutableSet2;
    }

    public static boolean m22304a(State state) {
        switch (1.a[state.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return true;
            case 3:
                return VERSION.SDK_INT >= 23;
            default:
                return false;
        }
    }

    public static boolean m22305b(State state) {
        switch (1.a[state.ordinal()]) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return true;
            case 3:
                if (VERSION.SDK_INT < 23) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FbLocationStatus)) {
            return false;
        }
        FbLocationStatus fbLocationStatus = (FbLocationStatus) obj;
        if (this.f15655a == fbLocationStatus.f15655a && Objects.equal(this.f15656b, fbLocationStatus.f15656b) && Objects.equal(this.f15657c, fbLocationStatus.f15657c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f15655a, this.f15656b, this.f15657c);
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("state", this.f15655a).add("userEnabledProviders", this.f15656b).add("userDisabledProviders", this.f15657c).toString();
    }
}
