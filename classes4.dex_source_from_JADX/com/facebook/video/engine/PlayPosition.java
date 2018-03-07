package com.facebook.video.engine;

import com.google.common.base.Preconditions;

/* compiled from: parse trackingCodes error */
public class PlayPosition {
    public static final PlayPosition f5359a = new PlayPosition();
    public static final PlayPosition f5360b = new PlayPosition(0, 0);
    public final int f5361c;
    public final int f5362d;

    private PlayPosition() {
        this.f5361c = -1;
        this.f5362d = -1;
    }

    public PlayPosition(int i, int i2) {
        boolean z;
        boolean z2 = false;
        if (i >= 0 || i == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (i2 >= 0 || i2 == -1) {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        this.f5361c = i;
        this.f5362d = i2;
    }

    public final boolean m5852a() {
        return this.f5362d != -1;
    }

    public final boolean m5853b() {
        return this.f5361c != -1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayPosition)) {
            return false;
        }
        PlayPosition playPosition = (PlayPosition) obj;
        if (playPosition.f5361c == this.f5361c && playPosition.f5362d == this.f5362d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f5361c ^ this.f5362d;
    }

    public String toString() {
        return "PlayPosition{startFromPosition=" + this.f5361c + ", lastStartPosition=" + this.f5362d + '}';
    }
}
