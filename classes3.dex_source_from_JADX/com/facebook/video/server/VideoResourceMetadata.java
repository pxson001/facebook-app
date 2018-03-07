package com.facebook.video.server;

import android.net.Uri;
import com.google.common.base.Preconditions;

/* compiled from: TE;) */
public class VideoResourceMetadata {
    private static final String f354b = VideoResourceMetadata.class.getSimpleName();
    public final String f355a;
    public Uri f356c;
    public long f357d = -1;
    public long f358e = -1;
    public long f359f;
    public VideoResourceType f360g = VideoResourceType.PROGRESSIVE;
    public boolean f361h;
    public String f362i;

    /* compiled from: TE;) */
    public enum VideoResourceType {
        PROGRESSIVE,
        DASH
    }

    public VideoResourceMetadata(Uri uri) {
        this.f356c = uri;
        this.f355a = null;
    }

    public VideoResourceMetadata(Uri uri, String str) {
        this.f356c = uri;
        this.f355a = str;
    }

    public final void m320a(long j) {
        this.f357d = j;
    }

    public final void m321b(long j) {
        this.f358e = j;
    }

    public final void m323c(long j) {
        this.f359f = j;
    }

    public final Uri m319a() {
        return this.f356c;
    }

    public final long m322c() {
        return this.f358e;
    }

    public final long m324d() {
        return this.f359f;
    }

    public final boolean m325f() {
        return this.f361h;
    }

    public final boolean m326h() {
        return this.f356c != null && this.f357d > 0 && this.f358e > 0 && this.f359f > 0;
    }

    public final int m318a(long j, int i, int i2) {
        int i3;
        Preconditions.checkArgument(j >= 0);
        if (this.f357d <= 0 || this.f358e <= 0) {
            i3 = 500000;
        } else {
            j = Math.min(this.f359f, j);
            i3 = (int) (((double) this.f357d) + (((double) this.f358e) * ((((double) j) * 0.001d) / 8.0d)));
        }
        Long.valueOf(this.f357d);
        Long.valueOf(this.f358e);
        Long.valueOf(j);
        Integer.valueOf(i3);
        i3 = Math.max(i3, i);
        if (i2 > 0) {
            return Math.min(i3, i2);
        }
        return i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VideoResourceMetadata videoResourceMetadata = (VideoResourceMetadata) obj;
        if (this.f357d != videoResourceMetadata.f357d) {
            return false;
        }
        if (this.f358e != videoResourceMetadata.f358e) {
            return false;
        }
        if (this.f359f != videoResourceMetadata.f359f) {
            return false;
        }
        if (this.f356c != null) {
            if (this.f356c.equals(videoResourceMetadata.f356c)) {
                return true;
            }
        } else if (videoResourceMetadata.f356c == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f356c != null ? this.f356c.hashCode() : 0) * 31) + ((int) (this.f357d ^ (this.f357d >>> 32)))) * 31) + ((int) (this.f358e ^ (this.f358e >>> 32)))) * 31) + ((int) (this.f359f ^ (this.f359f >>> 32)));
    }
}
