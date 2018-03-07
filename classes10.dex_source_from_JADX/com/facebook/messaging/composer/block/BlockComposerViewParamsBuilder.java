package com.facebook.messaging.composer.block;

import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: thread.cannotReplyReason */
public class BlockComposerViewParamsBuilder {
    public int f1705a;
    public int f1706b;
    public int f1707c;
    public int f1708d;
    @Nullable
    public Uri f1709e;

    public final BlockComposerViewParamsBuilder m1682a(int i) {
        this.f1705a = i;
        return this;
    }

    public final int m1681a() {
        return this.f1705a;
    }

    public final BlockComposerViewParamsBuilder m1685b(int i) {
        this.f1706b = i;
        return this;
    }

    public final int m1684b() {
        return this.f1706b;
    }

    public final BlockComposerViewParamsBuilder m1687c(int i) {
        this.f1707c = i;
        return this;
    }

    public final int m1686c() {
        return this.f1707c;
    }

    public final BlockComposerViewParamsBuilder m1683a(@Nullable Uri uri) {
        this.f1709e = uri;
        return this;
    }

    public final Uri m1688d() {
        return this.f1709e;
    }

    public final BlockComposerViewParamsBuilder m1689d(int i) {
        this.f1708d = i;
        return this;
    }

    public final int m1690e() {
        return this.f1708d;
    }

    public final BlockComposerViewParams m1691f() {
        return new BlockComposerViewParams(this);
    }
}
