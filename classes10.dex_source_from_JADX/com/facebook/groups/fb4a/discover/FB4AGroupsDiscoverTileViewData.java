package com.facebook.groups.fb4a.discover;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.user.model.UserKey;
import com.facebook.widget.tiles.ThreadTileViewData;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: Trying to send emoji-like on a thread that supports hotlikes. */
public class FB4AGroupsDiscoverTileViewData implements ThreadTileViewData {
    private final String f21957a;
    private final Uri f21958b;
    private final ImmutableList<UserKey> f21959c;
    private final ImmutableList<Uri> f21960d;

    protected FB4AGroupsDiscoverTileViewData(String str, @Nullable Uri uri, ImmutableList<UserKey> immutableList, ImmutableList<Uri> immutableList2) {
        this.f21957a = str;
        this.f21958b = uri;
        this.f21959c = immutableList;
        this.f21960d = immutableList2;
    }

    public final int m23071a() {
        if (this.f21958b != null) {
            return 1;
        }
        return m23076d().size();
    }

    public final ImageRequest m23072a(int i, int i2, int i3) {
        if (this.f21958b != null) {
            return ImageRequest.a(this.f21958b);
        }
        return ImageRequest.a((Uri) this.f21960d.get(i));
    }

    public final ImageRequest m23073b(int i, int i2, int i3) {
        return null;
    }

    public final TileBadge m23074b() {
        return TileBadge.NONE;
    }

    public final boolean m23075c() {
        return this.f21958b != null;
    }

    public final ImmutableList<UserKey> m23076d() {
        if (m23075c()) {
            return RegularImmutableList.a;
        }
        return this.f21959c;
    }

    @Nullable
    public final Bitmap m23077e() {
        return null;
    }

    public final String m23078f() {
        return null;
    }
}
