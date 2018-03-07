package com.facebook.messaging.photos.tiles.model;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileViewLogic;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.tiles.ThreadTileViewData;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: today_notification */
public class MessengerThreadTileViewData implements ThreadTileViewData {
    private final UserTileViewLogic f1544a;
    private final String f1545b;
    private final Uri f1546c;
    private final boolean f1547d;
    private final ImmutableList<UserKey> f1548e;
    private final TileBadge f1549f;
    private final Bitmap f1550g;
    private final String f1551h;

    /* compiled from: today_notification */
    public class Builder {
        public UserTileViewLogic f1536a;
        public String f1537b;
        public Uri f1538c;
        public boolean f1539d;
        public ImmutableList<UserKey> f1540e;
        public TileBadge f1541f = TileBadge.NONE;
        private Bitmap f1542g;
        public String f1543h;

        public final Builder m1712a(UserKey userKey) {
            this.f1540e = ImmutableList.of(userKey);
            return this;
        }

        public final MessengerThreadTileViewData m1713a() {
            return new MessengerThreadTileViewData(this.f1536a, this.f1537b, this.f1538c, this.f1539d, this.f1540e != null ? this.f1540e : RegularImmutableList.a, this.f1541f, this.f1542g, this.f1543h);
        }
    }

    private MessengerThreadTileViewData(UserTileViewLogic userTileViewLogic, String str, @Nullable Uri uri, boolean z, ImmutableList<UserKey> immutableList, TileBadge tileBadge, Bitmap bitmap, String str2) {
        this.f1544a = userTileViewLogic;
        this.f1545b = str;
        this.f1546c = uri;
        this.f1547d = z;
        this.f1548e = immutableList;
        this.f1549f = tileBadge;
        this.f1550g = bitmap;
        this.f1551h = str2;
    }

    public final int m1714a() {
        if (this.f1547d) {
            return 0;
        }
        if (this.f1550g == null && this.f1546c == null) {
            return this.f1548e.size();
        }
        return 1;
    }

    public final ImageRequest m1715a(int i, int i2, int i3) {
        Preconditions.checkArgument(m1714a() > 0);
        if (this.f1546c != null) {
            return ImageRequest.a(this.f1546c);
        }
        return this.f1544a.a(UserTileViewParams.a((UserKey) this.f1548e.get(i)), i2, i3);
    }

    public final ImageRequest m1716b(int i, int i2, int i3) {
        if (i < 0 || i >= this.f1548e.size()) {
            return null;
        }
        return UserTileViewLogic.a((UserKey) this.f1548e.get(i), i2);
    }

    public final TileBadge m1717b() {
        return this.f1549f;
    }

    public final boolean m1718c() {
        return this.f1546c != null;
    }

    public final ImmutableList<UserKey> m1719d() {
        if (m1718c()) {
            return RegularImmutableList.a;
        }
        return this.f1548e;
    }

    @Nullable
    public final Bitmap m1720e() {
        return this.f1550g;
    }

    public final String m1721f() {
        return this.f1551h;
    }
}
