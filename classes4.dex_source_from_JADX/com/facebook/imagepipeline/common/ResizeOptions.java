package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;

/* compiled from: overflowed_notification_story_cache_entries */
public class ResizeOptions {
    public final int f5739a;
    public final int f5740b;

    public ResizeOptions(int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        if (i2 <= 0) {
            z2 = false;
        }
        Preconditions.a(z2);
        this.f5739a = i;
        this.f5740b = i2;
    }

    public int hashCode() {
        return ((this.f5739a + 31) * 31) + this.f5740b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResizeOptions)) {
            return false;
        }
        ResizeOptions resizeOptions = (ResizeOptions) obj;
        if (this.f5739a == resizeOptions.f5739a && this.f5740b == resizeOptions.f5740b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%dx%d", new Object[]{Integer.valueOf(this.f5739a), Integer.valueOf(this.f5740b)});
    }
}
