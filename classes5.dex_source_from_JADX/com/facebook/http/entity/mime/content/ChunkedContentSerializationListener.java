package com.facebook.http.entity.mime.content;

import com.facebook.http.entity.mime.ContentSerializationListener;
import com.google.common.base.Preconditions;

/* compiled from: disabled_favorite_icon */
public abstract class ChunkedContentSerializationListener implements ContentSerializationListener {
    private final long f5045a;
    private final long f5046b;
    private long f5047c;

    public ChunkedContentSerializationListener(long j, int i) {
        boolean z = true;
        Preconditions.checkArgument(j > 0);
        if (i <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f5045a = j;
        this.f5046b = j / ((long) i);
        this.f5047c = 0;
    }

    public final void mo620a(long j) {
        Preconditions.checkArgument(j >= 0);
        if (j >= this.f5047c) {
            this.f5047c = Math.min(((this.f5046b + j) / this.f5046b) * this.f5046b, this.f5045a);
        }
    }
}
