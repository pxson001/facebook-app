package com.facebook.widget.tiles;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: com.facebook.zero.ACTION_FORCE_ZERO_HEADER_REFRESH */
public class DelegatingThreadTileViewData implements ThreadTileViewData {
    private final ThreadTileViewData f19913a;

    public DelegatingThreadTileViewData(ThreadTileViewData threadTileViewData) {
        this.f19913a = threadTileViewData;
    }

    public final int mo1507a() {
        return this.f19913a.mo1507a();
    }

    public final ImageRequest mo1508a(int i, int i2, int i3) {
        return this.f19913a.mo1508a(i, i2, i3);
    }

    public final ImageRequest mo1509b(int i, int i2, int i3) {
        return this.f19913a.mo1509b(i, i2, i3);
    }

    public TileBadge mo1510b() {
        return this.f19913a.mo1510b();
    }

    public final boolean mo1511c() {
        return this.f19913a.mo1511c();
    }

    public final ImmutableList<UserKey> mo1512d() {
        return this.f19913a.mo1512d();
    }

    @Nullable
    public final Bitmap mo1513e() {
        return this.f19913a.mo1513e();
    }

    @Nullable
    public final String mo1514f() {
        return this.f19913a.mo1514f();
    }
}
