package com.facebook.presence;

import com.facebook.common.util.TriState;
import com.google.common.base.Objects;

/* compiled from: image_block_image_48 */
public class PresenceState {
    public static final PresenceState f11184a = new Builder().m13098g();
    public final Availability f11185b;
    public final boolean f11186c;
    public final TriState f11187d;
    public final boolean f11188e;
    public final int f11189f;
    public final long f11190g;

    /* compiled from: image_block_image_48 */
    public class Builder {
        public Availability f11178a = Availability.NONE;
        public boolean f11179b;
        public TriState f11180c = TriState.UNSET;
        public boolean f11181d;
        public int f11182e;
        public long f11183f;

        public final PresenceState m13098g() {
            return new PresenceState(this);
        }
    }

    PresenceState(Builder builder) {
        this.f11185b = builder.f11178a;
        this.f11186c = builder.f11179b;
        this.f11187d = builder.f11180c;
        this.f11188e = builder.f11181d;
        this.f11189f = builder.f11182e;
        this.f11190g = builder.f11183f;
    }

    public final long m13099g() {
        return this.f11190g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PresenceState presenceState = (PresenceState) obj;
        if (this.f11186c != presenceState.f11186c) {
            return false;
        }
        if (this.f11188e != presenceState.f11188e) {
            return false;
        }
        if (this.f11185b != presenceState.f11185b) {
            return false;
        }
        if (this.f11189f != presenceState.f11189f) {
            return false;
        }
        if (this.f11187d != presenceState.f11187d) {
            return false;
        }
        if (this.f11190g != presenceState.f11190g) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f11185b, Boolean.valueOf(this.f11186c), Boolean.valueOf(this.f11188e), this.f11187d, Long.valueOf(this.f11190g)});
    }
}
